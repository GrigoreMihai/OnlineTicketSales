package models;

public class Card {
    private int id;

    private String cardNumber;

    public Card(int id, String cardNumber) {
        this.id = id;
        this.cardNumber = cardNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }




}
