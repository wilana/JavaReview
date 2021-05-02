package JavaFX;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        // Step 1: import the JavaFX library from /Users/wilanamatthews/Documents/javafx-sdk-15/lib
        // Step 2: Go to Run -> Edit Configs -> VM Options
            /*  --module-path /Users/wilanamatthews/Documents/javafx-sdk-15/lib
                --add-modules javafx.controls,javafx.fxml
                --add-exports javafx.graphics/com.sun.javafx.sg.prism=ALL-UNNAMED
             */

        // Step 3: extend the application class, add start method
        launch(args);   // include in main

        // Step 4: Create a view to launch to, and its controller
        // Step 5: Go into the view and make sure it points to the right controller!!
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("./view.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
