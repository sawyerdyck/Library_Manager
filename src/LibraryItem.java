public abstract class LibraryItem {
    private double price;
    private int invQuantity;
    private int soldQuantity;
    private int inCart;

    public LibraryItem(double price, int invQuantity){
        this.price = price;
        this.invQuantity = invQuantity;
        this.soldQuantity = 0;
        this.inCart = 0;
    }

    public double sellUnits(int amount){
        if( amount > 0 && invQuantity >= amount){
            soldQuantity += amount;
            return amount * price;
        }
        return 0;
    }

    public double getPrice(){return price;}
    public int getInvQuantity(){return invQuantity;}
    public int getSoldQuantity(){return soldQuantity;}
    public void setInvQuantity(int invQuantity) {
        this.invQuantity = invQuantity;
    }
    public int getInCart(){return inCart;}
    public void setInCart(int inCart) {
        this.inCart = inCart;
    }
}