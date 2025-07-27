import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Library {

    private String name;
    private double revenue;
    private ArrayList<LibraryItem> items;
    private ArrayList<LibraryItem> cart;
    private int sales;

    public Library(String name) {
        this.name = name;
        revenue = 0;
        items = new ArrayList<>();
        cart = new ArrayList<>();
        sales = 0;
    }

    public void addAnItem(LibraryItem item) {
        items.add(item);
    }//adds items to library

    public static Library createLibrary() {
        Library library = new Library("Book Haven");
        Fiction f1 = new Fiction("Stephen King", "The Shining", "Horror", 1977, 15.99, 10);
        Fiction f2 = new Fiction("J.K. Rowling", "Harry Potter", "Fantasy", 1997, 22.50, 10);
        library.addAnItem(f1);
        library.addAnItem(f2);
        Textbook tb1 = new Textbook("Pearson", "Calculus", "Mathematics", 2021, true, 120.00, 10);
        Textbook tb2 = new Textbook("McGraw-Hill", "Biology 101", "Science", 2018, false, 95.00, 10);
        library.addAnItem(tb1);
        library.addAnItem(tb2);
        Encyclopedia e1 = new Encyclopedia("Britannica", "World History", 2019, "Hardcover", true, 250.00, 10);
        Encyclopedia e2 = new Encyclopedia("World Book", "Science Encyclopedia", 2022, "Paperback", false, 180.00, 10);
        library.addAnItem(e1);
        library.addAnItem(e2);
        Magazine m1 = new Magazine("Time", "Weekly News", 2020, "Current Events", true, 5.99, 10);
        Magazine m2 = new Magazine("National Geographic", "Nature", 2019, "Science", false, 7.50, 10);
        library.addAnItem(m1);
        library.addAnItem(m2);
        Bookmark bm1 = new Bookmark(10, 30, true, 3.90, 20);
        Bookmark bm2 = new Bookmark(12, 35, false, 3.20, 20);
        library.addAnItem(bm1);
        library.addAnItem(bm2);
        return library;
    }
    //getters
    public String getName(){return name;}
    public int getSales() {return sales;}
    public String getRevenue() {
        return String.format("$%.2f", revenue); // Forces 2 decimal places
    }

    public String getPerSale() {
        if (sales == 0) {
            return "N/A";
        }
        double avg = revenue / sales;
        return String.format("$%.2f", avg); // Forces 2 decimal places
    }
    public ArrayList<LibraryItem> getItems() {return items;}
    public ArrayList<LibraryItem> getCart() {return cart;}
    //adds an item if there is space available in the array

    public void sellCart(){
        for (LibraryItem item :cart){//sells every item in cart and resets incart value
            revenue+=item.sellUnits(item.getInCart());
            item.setInCart(0);
        }
        cart.clear();//clears cart/counts sales
        sales++;
    }

    public void addToCart(LibraryItem i) {
        if (i.getInvQuantity()>0){//checks that enough are in inventory
            i.setInCart(i.getInCart()+1);//increase incart value
            i.setInvQuantity(i.getInvQuantity()-1);// decreases inventory value
            if(!cart.contains(i)){// checks if matching already in cart, adds to list if not
                cart.add(i);
            }
            if(i.getInvQuantity()==0){// checks for none remaining in inventory
                items.remove(i);
            }
        }
    }

    public void throwFromCart(LibraryItem i) {
        if (i.getInCart() > 0) {// checks that exist in cart
            i.setInCart(i.getInCart() - 1);//decreases in cart value
            if (items.contains(i)) {//checks that item hasnt been removed from inventory/ adds value if not
                i.setInvQuantity(i.getInvQuantity() + 1);
            }else{
                items.add(i);//if none left in inventory must add entire object
                i.setInvQuantity(1);
            }
            if (i.getInCart() == 0) {// checks for none remaining in cart
                cart.remove(i);
            }
        }
    }

    public List<LibraryItem> getXPopularItems(int x){
        if (x<=0){
            return new ArrayList<>();//checks for invalid input
        }
        ArrayList<LibraryItem> toSort = new ArrayList<>(items);// copy of items list to sort
        ArrayList<LibraryItem> mostPop = new ArrayList<>();// empty list to hold sorted items
        Collections.sort(toSort, Comparator.comparingInt(LibraryItem::getSoldQuantity));// sorts items by sold quantity using comparator to compare ints
        Collections.reverse(toSort);// reverses sort order from ascending to descending
        int end = 0;
        for (LibraryItem i:toSort) {// adds x items to new list
            if(end>=x){
                break;
            }
            mostPop.add(i);
            end++;
        }
        return mostPop;
    }

    public double getCartValue(){//just returns total value of the cart
        int value=0;
        for (LibraryItem item: cart){
            value+=item.getPrice()* item.getInCart();
        }
        return value;
    }
}
