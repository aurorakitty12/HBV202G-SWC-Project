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

    Book book1, book2, book3;

    LibrarySystem myLibrarySystem = new LibrarySystem();

    //method to add some books to the library system and UI; throws an exception if a book cannot be added
    public void addBooks() throws UserOrBookDoesNotExistException {
    myLibrarySystem.addBook("The Great Gatsby","F. Scott Fitzgerald", true);
    myLibrarySystem.addBook("To Kill a Mockingbird", "Harper Lee", true);
    myLibrarySystem.addBook("1984", "George Orwell", true);
        book1 = myLibrarySystem.findBookByTitle("The Great Gatsby");
        book2 = myLibrarySystem.findBookByTitle("To Kill a Mockingbird");
        book3 = myLibrarySystem.findBookByTitle("1984");
    }
    //JavaFX application start method; sets up the UI for the library system, including a table view of books and buttons for loans and users.
    @Override
    public void start(Stage primaryStage) throws Exception {

        addBooks();

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

        tblBooks.getItems().addAll(book1, book2, book3);

        Button btnLoans = new Button("Loans");
        Button btnUsers = new Button("Users");

        btnLoans.disableProperty().bind(
            tblBooks.getSelectionModel().selectedItemProperty().isNull()
        );

        btnUsers.disableProperty().bind(
            tblBooks.getSelectionModel().selectedItemProperty().isNull().or(
                    Bindings.select(
                        tblBooks.getSelectionModel().selectedItemProperty(),
                        "available"
                    ).isEqualTo(false)
            )
        );

        HBox buttonHBox = new HBox( btnLoans, btnUsers );
        buttonHBox.setSpacing( 8 );

        VBox vbox = new VBox( tblBooks, buttonHBox );
        vbox.setPadding( new Insets(10) );
        vbox.setSpacing( 10 );

        Scene scene = new Scene(vbox);

        primaryStage.setTitle("Available Books");
        primaryStage.setScene( scene );
        primaryStage.setHeight( 650 );
        primaryStage.setWidth( 1280 );
        primaryStage.show();
    }
    //main method to launch the JavaFX application
    public static void main( String[] args ){
        launch(args);
    }
}
