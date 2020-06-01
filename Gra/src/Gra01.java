import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class Gra01 extends Application {

    @Override
    public void start(Stage primarystage) {
        Group root = new Group();
        primarystage.setTitle("Gra");

        Rectangle rect = new Rectangle();
        Rectangle rectRest = new Rectangle();
        root.getChildren().add(rect);
        root.getChildren().add(rectRest);

        final int[] x = new int[1];
        final int[] y = {0};

        rect.setX(x[0]);
        rect.setY(y[0]);
        rect.setWidth(20);
        rect.setHeight(20);

        Scene scene = new Scene(root, 200, 400);

        scene.setOnKeyPressed(
                event -> {
                    switch (event.getCode()) {
                        case LEFT:
                            if (x[0] >= 20)
                                rect.setX(x[0] -= 20);
                            break;
                        case RIGHT:
                            if (x[0] <= 160)
                                rect.setX(x[0] += 20);
                            break;
                        case UP:
                            if (y[0] >= 20)
                                rect.setY(y[0] -= 20);
                            break;
                        case DOWN:
                            if (y[0] <= 360)
                                rect.setY(y[0] += 20);
                            else {
                                rectRest.setX(x[0]);
                                rectRest.setY(y[0] = 380);
                                rectRest.setWidth(20);
                                rectRest.setHeight(20);
                                rect.setY(y[0] = 0);
                            }
                            break;
                    }
                }
        );

        primarystage.setScene(scene);
        primarystage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
