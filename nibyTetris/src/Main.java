import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application implements EventHandler<ActionEvent> {
    private static int i = 0;

    @Override
    public void start(Stage stage) {
        Group root = new Group();
        stage.setTitle("Gra");

        Rectangle rect = new Mechanika().kwadratWskaznik();

        rect.relocate(80, 0);
        root.getChildren().add(rect);

        rect.setWidth(19);
        rect.setHeight(19);

        Scene scene = new Scene(root, 200, 400);

        stage.setScene(scene);
        stage.show();

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:
                        if (rect.getLayoutY() >= 20)
                            rect.relocate(rect.getLayoutX(), rect.getLayoutY() - 20);
                        break;
                    case DOWN:
                        if (rect.getLayoutY() <= 360)
                            rect.relocate(rect.getLayoutX(), rect.getLayoutY() + 20);
                        break;
                    case LEFT:
                        if (rect.getLayoutX() >= 20)
                            rect.relocate(rect.getLayoutX() - 20, rect.getLayoutY());
                        break;
                    case RIGHT:
                        if (rect.getLayoutX() <= 160)
                            rect.relocate(rect.getLayoutX() + 20, rect.getLayoutY());
                        break;
                }
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(ActionEvent actionEvent) {

    }
}
