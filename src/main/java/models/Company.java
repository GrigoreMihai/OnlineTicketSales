package models;

public class Company {

    private int id;

    private String name;

    private String cui;

    private int rating;

    private Card card;

    public Company(int id, String name, String cui, int rating, Card card) {
        this.card = card;
        this.id = id;
        this.name = name;
        this.cui = cui;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getCui() {
        return cui;
    }

    public void setCui(String cui) {
        this.cui = cui;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }


    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cui='" + cui + '\'' +
                ", rating=" + rating +
                ", card=" + card +
                '}';
    }
}
