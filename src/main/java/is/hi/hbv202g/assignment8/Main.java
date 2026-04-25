package is.hi.hbv202g.assignment8;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.beans.binding.Bindings;


public class Main extends Application {

    LibrarySystem myLibrarySystem = new LibrarySystem();
    

@Override
    public void start(Stage primaryStage) throws Exception {

        TableView<Book> tblBooks = new TableView<>();
        tblBooks.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        VBox.setVgrow(tblBooks, Priority.ALWAYS );

        TableColumn<Book, String> colTitle = new TableColumn<>("Title");
        TableColumn<Book, String> colAuthor = new TableColumn<>("Author");
        TableColumn<Book, Boolean> colAvailable = new TableColumn<>("Available");

        colTitle.setCellValueFactory( new PropertyValueFactory<>("title") );
        colAuthor.setCellValueFactory( new PropertyValueFactory<>("author") );
        colAvailable.setCellValueFactory( new PropertyValueFactory<>("available") );

        tblBooks.getColumns().addAll(
            colTitle, colAuthor, colAvailable
        );

        tblBooks.getItems().addAll(
            new Book("The Great Gatsby", "F. Scott Fitzgerald", true),
            new Book("To Kill a Mockingbird", "Harper Lee", true),
            new Book("1984", "George Orwell", true)
        );

        Button btnLoans = new Button("Inventory");
        Button btn = new Button("Tax");

        btnLoans.disableProperty().bind(
            tblBooks.getSelectionModel().selectedItemProperty().isNull()
        );

        btn.disableProperty().bind(
            tblBooks.getSelectionModel().selectedItemProperty().isNull().or(
                    Bindings.select(
                        tblBooks.getSelectionModel().selectedItemProperty(),
                        "available"
                    ).isEqualTo(false)
            )
        );

        HBox buttonHBox = new HBox( btnLoans, btn );
        buttonHBox.setSpacing( 8 );

        VBox vbox = new VBox( tblBooks, buttonHBox );
        vbox.setPadding( new Insets(10) );
        vbox.setSpacing( 10 );

        Scene scene = new Scene(vbox);

        primaryStage.setTitle("Available Books");
        primaryStage.setScene( scene );
        primaryStage.setHeight( 720 );
        primaryStage.setWidth( 1280 );
        primaryStage.show();
    }
    public static void main( String[] args ){
        launch(args);
    }
}
