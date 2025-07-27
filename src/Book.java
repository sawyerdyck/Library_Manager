public abstract class Book extends LibraryItem {
    private String author;
    private String title;
    private int year;

    public Book(String author, String title, int year, double price, int quantity){
        super(price, quantity);
        this.author = author;
        this.title = title;
        this.year = year;
    }
    public String getAuthor(){return author;}
    public String getTitle(){return title;}
    public int getYear(){return year;}
}