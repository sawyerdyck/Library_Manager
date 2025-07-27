import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.event.*;
import javafx.scene.input.MouseEvent;

public class LibraryApp extends Application {
    Library model;
    LibraryView view;
    Pane aPane;

    public LibraryApp() {
        model = Library.createLibrary();
        view = new LibraryView(model);
    }

    public void start(Stage primaryStage) {
        aPane = new Pane();
        aPane.getChildren().add(view);

        primaryStage.setTitle(model.getName()+" - Sales and Inventory");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(aPane));
        primaryStage.show();
        view.update();

        //event handlers
        view.getInventoryList().setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent mouseEvent) {
                int pressed = view.getInventoryList().getSelectionModel().getSelectedIndex();
                if(pressed>=0){
                    view.getButtonPane().getAdd().setDisable(false);
                }
            }
        });
        view.getCartList().setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent mouseEvent) {
                int pressed = view.getCartList().getSelectionModel().getSelectedIndex();
                if(pressed>=0){
                    view.getButtonPane().getDelete().setDisable(false);
                }
            }
        });
        view.getButtonPane().getAdd().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                int pressed = view.getInventoryList().getSelectionModel().getSelectedIndex();
                if(pressed>=0){
                    view.getButtonPane().getSale().setDisable(false);
                    view.getButtonPane().getAdd().setDisable(true);
                    model.addToCart(model.getItems().get(pressed));
                    view.update();
                }
            }
        });
        view.getButtonPane().getDelete().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                int pressed = view.getCartList().getSelectionModel().getSelectedIndex();
                if(pressed>=0){
                    view.getButtonPane().getDelete().setDisable(true);
                    model.throwFromCart(model.getCart().get(pressed));
                    view.update();
                }
            }
        });
        view.getButtonPane().getSale().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                view.getButtonPane().getSale().setDisable(true);
                model.sellCart();
                view.update();
            }
        });
        view.getButtonPane().getReset().setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent mouseEvent) {
                view.getButtonPane().getDelete().setDisable(true);
                view.getButtonPane().getAdd().setDisable(true);
                model = Library.createLibrary();
                view = new LibraryView(model);
                start(primaryStage);
            }
        });
    }
    public static void main(String[] args) {
        launch(args);
    }
}