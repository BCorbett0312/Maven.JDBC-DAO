package models;

public class Card {
    private Integer id;
    private String name;
    private Integer quantity;
    private String setname;
    private String borrower = null;

    public Card() {

    }

    public Card(String name, Integer quantity, String setname) {
        this.id = null;
        this.name = name;
        this.quantity = quantity;
        this.setname = setname;
        this.borrower = null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getSetname() {
        return setname;
    }

    public void setSetname(String setname) {
        this.setname = setname;
    }

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", setname='" + setname + '\'' +
                ", borrower='" + borrower + '\'' +
                '}';
    }
}
