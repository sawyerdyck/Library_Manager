public abstract class Periodical extends LibraryItem {
    private String publisher;
    private String title;
    private int year;

    public Periodical(String publisher, String title, int year, double price, int quantity){
        super(price, quantity);
        this.publisher = publisher;
        this.title = title;
        this.year = year;
    }
    public String getPublisher(){return publisher;}
    public String getTitle(){return title;}
    public int getYear(){return year;}

    public String toString(){
        return getYear() + " " + getPublisher() + ", " + getTitle() +
                ", price $" + String.format("%,.2f",getPrice()) + " each ("+getInvQuantity()+" left)";
    }
}