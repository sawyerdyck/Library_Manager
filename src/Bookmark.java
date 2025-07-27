public class Bookmark extends LibraryItem {
    int length;
    int width;
    boolean magnetic;

    public Bookmark(int length, int width, boolean magnetic, double price, int invQuantity){
        super(price, invQuantity);
        this.length = length;
        this.width = width;
        this.magnetic = magnetic;
    }

    public String toString(){
        String result = "";
        if(magnetic) result += "Magnetic Bookmark";
        else result = "Standard Bookmark";
        return result + " " + length + "cm x " + width +
                "cm, price $" + String.format("%,.2f",getPrice()) + " each ("+getInvQuantity()+" left)";
    }
}