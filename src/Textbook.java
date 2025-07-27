public class Textbook extends Book {
    private String subject;
    private boolean newEdition;

    public Textbook(String publisher, String title, String subject, int year,
                    boolean newEdition, double price, int invQuantity){
        super(publisher, title, year, price, invQuantity);
        this.subject = subject;
        this.newEdition = newEdition;
    }

    public String toString(){
        String result = "";
        if(newEdition) result = "New Edition ";
        return result += "Textbook: " + getYear() + " " + getAuthor() + ", " + getTitle() +
                " - " + subject + ", price $" + String.format("%,.2f", getPrice()) +
                " each ("+getInvQuantity()+" left)";
    }
}