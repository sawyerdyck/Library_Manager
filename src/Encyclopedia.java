public class Encyclopedia extends ReferenceBook {
    private String binding;
    private boolean illustrated;

    public Encyclopedia(String publisher, String title, int year,
                        String binding, boolean illustrated, double price, int invQuantity) {
        super(publisher, title, year, price, invQuantity);
        this.binding = binding;
        this.illustrated = illustrated;
    }

    public String toString(){
        String result = "";
        if(illustrated) result += "Illustrated ";
        return result += "Encyclopedia: " + getYear() + " " + getPublisher() + ", " + getTitle() +
                " (" + binding + "), price $" + String.format("%,.2f", getPrice()) +
                " each ("+getInvQuantity()+" left)";
    }
}