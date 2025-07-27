import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.collections.FXCollections;
import java.util.ArrayList;

public class LibraryView extends Pane{
    Library model;

    private ListView<String>    iList,cList,pList;
    private ButtonPane       buttonPane;
    private Label label2;
    private TextField sField,rField,pField;

    public ListView<String> getInventoryList() { return iList; }
    public ListView<String> getCartList() { return cList; }
    public ButtonPane getButtonPane() { return buttonPane; }

    public LibraryView(Library initModel) {
        model = initModel;
        // Create the labels
        Label label1 = new Label("Library Inventory:");
        label1.relocate(30, 10);
        label2 = new Label("Current Cart ($"+model.getCartValue()+")");
        label2.relocate(310, 10);
        Label label3 = new Label("Library Summary:");
        label3.relocate(590, 10);
        Label label4 = new Label("# Sales:");
        label4.relocate(595, 40);
        Label label5 = new Label("Revenue:");
        label5.relocate(595, 70);
        Label label6 = new Label("$ / Sale:");
        label6.relocate(595,100);
        Label label7 = new Label("Most Popular Items:");
        label7.relocate(590, 130);

        // Create the listviews
        iList = new ListView<>();
        iList.relocate(30, 40);
        iList.setPrefSize(275,255);

        cList = new ListView<>();
        cList.relocate(310, 40);
        cList.setPrefSize(275,255);

        pList = new ListView<>();
        pList.relocate(590, 150);
        pList.setPrefSize(180,145);

        //create the textfields
        sField = new TextField();
        sField.setText(String.valueOf(model.getSales()));
        sField.relocate(675,40);
        sField.setPrefSize(95,17);

        rField = new TextField();
        rField.setText(String.valueOf(model.getRevenue()));
        rField.relocate(675,70);
        rField.setPrefSize(95,17);

        pField = new TextField();
        pField.setText(String.valueOf(model.getPerSale()));
        pField.relocate(675,100);
        pField.setPrefSize(95,17);

        // Create the button pane
        buttonPane = new ButtonPane();
        buttonPane.relocate(98, 305);
        buttonPane.setPrefSize(535,17);

        // Add all the components to the Pane
        getChildren().addAll(label1, label2, label3, label4, label5, label6, label7, iList, cList, pList, sField, rField, pField, buttonPane);

        setPrefSize(800, 350);
    }
    public void update() {
        ArrayList<String> inv = new ArrayList<>();
        for (LibraryItem item: model.getItems()){
            inv.add(item.toString());
        }
        iList.setItems(FXCollections.observableArrayList(inv));

        ArrayList<String> cart = new ArrayList<>();
        for (LibraryItem item: model.getCart()){
            cart.add(item.getInCart()+" x "+item.toString());
        }
        cList.setItems(FXCollections.observableArrayList(cart));

        ArrayList<String> popular = new ArrayList<>();
        for (LibraryItem item: model.getXPopularItems(3)){
            popular.add(item.toString());
        }
        pList.setItems(FXCollections.observableArrayList(popular));

        sField.setText(String.valueOf(model.getSales()));
        rField.setText(String.valueOf(model.getRevenue()));
        pField.setText(String.valueOf(model.getPerSale()));

        label2.setText("Current Cart ($"+model.getCartValue()+")");
        if(model.getCart().isEmpty()){
            buttonPane.getSale().setDisable(true);
        }
    }
}