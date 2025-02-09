package io.github.gleidsonmt.fitmeal.main;

import io.github.gleidsonmt.fitmeal.model.Plate;
import io.github.gleidsonmt.fitmeal.utils.Assets;
import io.github.gleidsonmt.glad.controls.avatar.AvatarRectView;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  04/02/2025
 */
public class Banner extends StackPane {


    public Banner() {
        VBox.setMargin(this, new Insets(20, 0, 20, 0));
        getStyleClass().add("banner");
        setPrefHeight(200);

        AvatarRectView imageView = new AvatarRectView();
        imageView.setSize(400);
        imageView.setX(400);
        imageView.setY(-100);
        imageView.setManaged(false);

        StackPane boxRight = new StackPane();
//        boxRight.setStyle("-fx-background-color: -fx-accent;");
        VBox container = new VBox();
        Text title = new Text("30% Off");
        title.setStyle("-fx-font-family: \"Poppins Black\"; -fx-fill: #2f1d0e;");
        title.getStyleClass().add("text-34");
        Text legend = new Text("Fitness Meal");
        legend.setStyle(" -fx-fill: white;");
        legend.getStyleClass().add("text-30");
        container.setAlignment(Pos.CENTER_LEFT);
        StackPane.setMargin(container, new Insets(20, 50, 20, 50));
        container.getChildren().addAll(title, legend);
        boxRight.getChildren().add(container);
        StackPane.setAlignment(container, Pos.CENTER);

        boxRight.getChildren().add(imageView);
        StackPane.setAlignment(boxRight, Pos.CENTER_RIGHT);

        StackPane middle = new StackPane();
        middle.setMaxWidth(100);
        middle.getStyleClass().add("trapeze-custom");
        middle.setTranslateX(-300);
        StackPane.setAlignment(middle, Pos.CENTER_RIGHT);

        StackPane boxLeft = new StackPane();
        boxLeft.getStyleClass().add("box-left");

        Polygon one = createPolygon();
        one.getPoints().setAll(-11.0, -5.0, 34.0, -23.0, 0.0, -60.0);
        Polygon two = createPolygon();
        two.setRotate(121);
        two.getPoints().setAll(-10.0, -21.0, 14.0, -27.0, 0.0, -60.0);
        StackPane polygons = new StackPane(one, two);
        StackPane.setAlignment(one, Pos.TOP_LEFT);
        StackPane.setAlignment(two, Pos.BOTTOM_LEFT);
        one.setTranslateX(250);
        one.setTranslateY(10);
        two.setTranslateX(50);
        boxLeft.getChildren().addAll(polygons);

        getChildren().addAll(boxLeft, middle, boxRight);
        middle.toFront();

        VBox box = new VBox();
        VBox triangle = new VBox();

        ObservableList<Plate> plates = FXCollections.observableArrayList();
        plates.addAll(
                new Plate(40, "Steak", "Compose Meal", "img_1.jpg"),
                new Plate(30, "Chicken + Fries", "Compose Meal", "img_2.jpg"),
                new Plate(60, "Super Mix", "Compose Meal", "img_3.jpg"),
                new Plate(10, "Fish", "Compose Meal", "img_4.jpg")
        );
        SliderIndicator sliderIndicator = new SliderIndicator(plates, imageView, title, legend);
        getChildren().add(sliderIndicator);

        StackPane.setAlignment(sliderIndicator, Pos.BOTTOM_CENTER);

        Platform.runLater(() -> {
            Rectangle clip = new Rectangle();

            clip.xProperty().bind(this.widthProperty().subtract(400));
            imageView.xProperty().bind(this.widthProperty().subtract(400));
            clip.widthProperty().bind(this.widthProperty());
            clip.setHeight(200);
            imageView.setClip(clip);

            triangle.setTranslateX(-200);

//            rect.setManaged(false);
        });

        triangle.setMinSize(200, 200);
        triangle.setPrefSize(200, 200);
        triangle.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
        triangle.getStyleClass().add("custom-tri");

        StackPane.setAlignment(triangle, Pos.CENTER_RIGHT);
        boxRight.getChildren().add(triangle);

        box.setStyle("-fx-background-color: pink");
        box.getStyleClass().addAll( "trapeze-custom");

        StackPane.setAlignment(imageView, Pos.CENTER_RIGHT);
        StackPane.setAlignment(box, Pos.CENTER_LEFT);

        imageView.getStyleClass().add("box-right");
        box.toFront();



    }

    private Polygon createPolygon() {
        Polygon polygon = new Polygon();
        polygon.setStyle("-fx-fill: -fx-second;");
        return polygon;
    }
}
