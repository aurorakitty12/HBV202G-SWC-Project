package is.hi.hbv202g.assignment8;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Main extends Application
{
        private Parent createContent() {
        return new StackPane(new Text("Hello World"));
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Hello World");
        stage.setScene(new Scene(createContent(), 300, 300));
        stage.show();
    }
    public static void main( String[] args )
    {
        LibrarySystem myLibrarySystem = new LibrarySystem();
        launch(args);
    }
}
