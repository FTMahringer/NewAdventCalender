package htl.steyr.newadventcalender;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AdventCalendar extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Advent Calendar");

        // Create a GridPane for the calendar
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);

        int doorSize = 100; // Default door size

        for (int i = 1; i <= 24; i++) {
            Button door = new Button(String.valueOf(i));
            door.setPrefSize(doorSize, doorSize);
            int doorNumber = i; // Capture for lambda

            // Add click event to open the popup with an image
            door.setOnAction(event -> showImagePopup(doorNumber));

            // Calculate row and column positions for the grid to be 6x4
            int row = (i - 1) / 6;
            int col = (i - 1) % 6;

            // Add the door to the grid
            grid.add(door, col, row);
        }

        // Set up the main scene
        Scene scene = new Scene(grid, 600, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showImagePopup(int doorNumber) {
        Stage popup = new Stage();
        popup.initModality(Modality.APPLICATION_MODAL);
        popup.setTitle("Day " + doorNumber);

        Image image = new Image(getClass().getResource("/htl/steyr/adventcalender/imgs/door-" + doorNumber + ".png").toString());
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(400); // Adjust image size as needed
        imageView.setFitHeight(300);

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().add(imageView);
        Scene popupScene = new Scene(anchorPane);
        popup.setScene(popupScene);
        popup.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}