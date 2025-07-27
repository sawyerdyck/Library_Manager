public class Fiction extends Book {
    private String genre;

    public Fiction(String author, String title, String genre, int year, double price, int invQuantity){
        super(author, title, year, price, invQuantity);
        this.genre = genre;
    }
    public String getGenre(){return genre;}

    public String toString(){
        return getYear() + " " + getAuthor() + ", " + getTitle() + " (" + getGenre() +
                "), price $" + String.format("%,.2f", getPrice()) + " each ("+getInvQuantity()+" left)";
    }
}