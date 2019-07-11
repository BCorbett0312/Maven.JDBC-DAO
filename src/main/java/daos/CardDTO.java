package daos;


import models.Card;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class CardDTO implements CardDao {
    Connection connection;
    PreparedStatement ps;
    ResultSet rs;

    
    public Card getCard(int id) {
        connection = Connections.getConnection();
        try {
            Statement stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT * FROM collection.cards WHERE id=" + id);

            if(rs.next()){
                return extractCardFromResultSet(rs);
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }

        try{
            closeConnection();
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        
        return null;
    }

    private Card extractCardFromResultSet(ResultSet rs) throws SQLException{
        Card card = new Card();
        card.setId(rs.getInt("id"));
        card.setName(rs.getString("name"));
        card.setQuantity(rs.getInt("quantity"));
        card.setSetname(rs.getString("setname"));
        card.setBorrower(rs.getString("borrower"));
        return card;

    }


    public Set<Card> getAllCards() {
        connection = Connections.getConnection();
        try{
            Statement stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT * FROM collection.cards");

            Set cards = new HashSet();

            while(rs.next()){
                Card card = extractCardFromResultSet(rs);
                cards.add(card);
            }
            return cards;
        } catch(SQLException ex){
            ex.printStackTrace();
        }

        try{
            closeConnection();
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }


    public boolean insertCard(Card card) {
        connection = Connections.getConnection();
        try{
            ps = connection.prepareStatement
                    ("INSERT INTO collection.cards VALUES (null, ?, ?, ?, null)");
            ps.setString(1, card.getName());
            ps.setString(3, card.getSetname());
            ps.setInt(2, card.getQuantity());
            int i = ps.executeUpdate();

            if (i == 1){
                return true;
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }

        try{
            closeConnection();
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }





    public boolean updateCard(Card card) {
        connection = Connections.getConnection();

        try{
            ps = connection.prepareStatement
                    ("UPDATE collection.cards SET name=?, quantity=?, setname=?, borrower=? WHERE id=? ");
            ps.setString(1, card.getName());
            ps.setInt(2, card.getQuantity());
            ps.setString(3, card.getSetname());
            ps.setString(4, card.getBorrower());
            ps.setInt(5, card.getId());
            int i = ps.executeUpdate();

            if(i == 1){
                return true;
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }

        try{
            closeConnection();
        } catch (SQLException ex){
            ex.printStackTrace();
        }

        return false;
    }

    public boolean deleteCard(int id) {
        connection = Connections.getConnection();
        try{
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM collection.cards WHERE id=" + id);

            if (i==1){
                return true;
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }


        return false;
    }

    private void closeConnection() throws SQLException{
        if(rs != null){
            rs.close();
        }
        if(ps != null){
            ps.close();
        }

        if(connection != null){
            connection.close();
        }
    }
}
