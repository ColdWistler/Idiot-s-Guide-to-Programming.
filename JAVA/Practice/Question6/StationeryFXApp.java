import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// Main JavaFX Application class for the Stationery Price Tool.
public class StationeryFXApp extends Application {

    /**
     * The main entry point for all JavaFX applications.
     * The start method is called after the init method has returned,
     * and after the system is ready for the application to begin running.
     * @param primaryStage The primary stage for this application, onto which
     * the application scene can be set. The first stage is constructed by the framework.
     */
    @Override
    public void start(Stage primaryStage) {
        try {
            // Load the FXML file. FXMLLoader will automatically
            // instantiate the controller and inject FXML elements.
            Parent root = FXMLLoader.load(
                getClass().getResource("StationeryPriceTool.fxml")
            );

            // Create a new Scene with the loaded FXML root.
            Scene scene = new Scene(root);

            // Set the title of the primary stage (window).
            primaryStage.setTitle("Stationery Price Tool");
            // Set the scene on the primary stage.
            primaryStage.setScene(scene);
            // Make the stage not resizable.
            primaryStage.setResizable(false);
            // Display the stage.
            primaryStage.show();
        } catch (IOException e) {
            // Print any exceptions that occur during FXML loading.
            System.err.println(
                "Failed to load FXML file for Stationery Price Tool: " +
                e.getMessage()
            );
            e.printStackTrace();
        }
    }

    /**
     * The main method to launch the JavaFX application.
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        // Launches the JavaFX application. The start() method will be called.
        launch(args);
    }
}
