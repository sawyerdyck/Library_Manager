public class Magazine extends Periodical {
    private String frequency;
    private boolean currentIssue;

    public Magazine(String publisher, String title, int year,
                    String frequency, boolean currentIssue, double price, int invQuantity) {
        super(publisher, title, year, price, invQuantity);
        this.frequency = frequency;
        this.currentIssue = currentIssue;
    }

    public String toString(){
        String result = "";
        if(currentIssue) result += "Current Issue ";
        return result += "Magazine: " + getYear() + " " + getPublisher() + ", " + getTitle() +
                " (" + frequency + "), price $" + String.format("%,.2f", getPrice()) +
                " each ("+getInvQuantity()+" left)";
    }
}