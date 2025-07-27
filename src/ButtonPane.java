import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class ButtonPane extends Pane {

    private Button add;
    private Button delete;
    private Button sale;
    private Button reset;

    public ButtonPane() {

        add = new Button("Add to Cart");
        add.relocate(0, 0);
        add.setPrefSize(120, 25);
        add.setDisable(true);

        delete = new Button("Remove Item");
        delete.relocate(226, 0);
        delete.setPrefSize(120, 25);
        delete.setDisable(true);

        sale = new Button("Complete Sale");
        sale.relocate(354, 0);
        sale.setPrefSize(120, 25);
        sale.setDisable(true);

        reset = new Button("Reset Stock");
        reset.relocate(530, 0);
        reset.setPrefSize(120, 25);

        add.setStyle("-fx-font: 12 arial; -fx-base: rgb(235,235,235); " + "-fx-text-fill: rgb(0,0,0);");
        delete.setStyle("-fx-font: 12 arial; -fx-base: rgb(235,235,235); " + "-fx-text-fill: rgb(0,0,0);");
        sale.setStyle("-fx-font: 12 arial; -fx-base: rgb(235,235,235); " + "-fx-text-fill: rgb(0,0,0);");
        reset.setStyle("-fx-font: 12 arial; -fx-base: rgb(235,235,235); " + "-fx-text-fill: rgb(0,0,0);");

        this.getChildren().addAll(add,delete,sale,reset);

    }

    public Button getAdd() {
        return add;
    }

    public Button getDelete() {
        return delete;
    }

    public Button getSale() {return sale;}

    public Button getReset() {return reset;}
}
