public abstract class ReferenceBook extends Book {
    private String publisher;

    public ReferenceBook(String publisher, String title, int year, double price, int quantity){
        super(publisher, title, year, price, quantity);
        this.publisher = publisher;
    }
    public String getPublisher(){return publisher;}

    public String toString(){
        return getYear() + " " + getPublisher() + ", " + getTitle() +
                ", price $" + String.format("%,.2f", getPrice()) + " each ("+getInvQuantity()+" left)";
    }
}