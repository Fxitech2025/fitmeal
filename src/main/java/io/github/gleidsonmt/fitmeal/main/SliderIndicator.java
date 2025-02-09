package io.github.gleidsonmt.fitmeal.main;

import io.github.gleidsonmt.fitmeal.model.Plate;
import io.github.gleidsonmt.fitmeal.utils.Assets;
import io.github.gleidsonmt.glad.controls.avatar.AvatarRectView;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.sql.Time;
import java.text.DecimalFormat;
import java.util.List;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  05/02/2025
 */
public class SliderIndicator extends StackPane {

    private final double indWidth = 16;
    private final double finalWidth = 40;

    public SliderIndicator(List<Plate> plates, AvatarRectView avatarRectView, Text title, Text legend) {

        setPrefSize(287, 50);
        setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);

        SVGPath blockRight = new SVGPath();
        blockRight.getStyleClass().add("slider-block-right");
        blockRight.setContent("M 114 95 C 117 95 120 95 123 95 C 118 95 118 91 114 91");
        blockRight.setScaleX(8);
        blockRight.setScaleY(8);
        blockRight.setFill(Color.WHITE);

        SVGPath blockLeft = new SVGPath();
        blockLeft.getStyleClass().add("slider-block-right");
        blockLeft.setContent("M 114 95 C 114 95 112 95 105 95 C 110 95 110 91 114 91 L 114 91");
        blockLeft.setScaleX(8);
        blockLeft.setScaleY(8);
        blockLeft.setFill(Color.WHITE);

        HBox content = new HBox();
        content.setAlignment(Pos.CENTER);
        content.setSpacing(10);
        StackPane.setMargin(content, new Insets(19,0,0,0));
        content.setStyle("-fx-background-color: white;");
        content.setPrefSize(210, 32);
        content.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);

        StackPane.setAlignment(blockRight, Pos.BOTTOM_RIGHT);
        StackPane.setAlignment(blockLeft, Pos.BOTTOM_LEFT);

        blockRight.setTranslateY(-13);
        blockLeft.setTranslateY(-13);

        getChildren().setAll(blockLeft, content, blockRight);
        DecimalFormat decimalFormat = new DecimalFormat("0");
        ToggleGroup group = new ToggleGroup();
        plates.forEach(e -> {
            ToggleButton indicator = new ToggleButton();
            group.getToggles().add(indicator);
            indicator.setUserData(true);
            indicator.setPrefSize(indWidth, 10);
            indicator.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            indicator.setPadding(new Insets(0));
            indicator.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
            indicator.setStyle("-fx-background-color: #dfdfe0; -fx-background-radius: 100px; -fx-border-radius: 100px; -fx-background-insets: 0px; -fx-border-insets: 0px;");
            indicator.setCursor(Cursor.HAND);
            content.getChildren().add(indicator);

            Timeline timeline = new Timeline();
            timeline.getKeyFrames().setAll(
                    new KeyFrame(Duration.ZERO, new KeyValue(avatarRectView.opacityProperty(), 0)),
                    new KeyFrame(Duration.ZERO, new KeyValue(title.opacityProperty(), 0)),
                    new KeyFrame(Duration.ZERO, new KeyValue(legend.opacityProperty(), 0)),
                    new KeyFrame(Duration.millis(500), new KeyValue(title.opacityProperty(), 1)),
                    new KeyFrame(Duration.millis(500), new KeyValue(legend.opacityProperty(), 1)),
                    new KeyFrame(Duration.millis(500), new KeyValue(avatarRectView.opacityProperty(), 1))
            );

            indicator.setOnMouseClicked(ev -> {
                int index = plates.indexOf(e);
                avatarRectView.setImage(Assets.getImage(plates.get(index ).img()));
                title.setText(decimalFormat.format(plates.get(index).discount()) + "% Off");
                legend.setText(plates.get(index).name());
                timeline.play();

            });

            indicator.selectedProperty().addListener((observableValue, aBoolean, newValue) -> {
                if (newValue) {
                  open(indicator);
                } else {
                    close(indicator);
                }
            });
        });

        legend.setText(plates.get(0).name());
        title.setText(decimalFormat.format(plates.get(0).discount()) + "% Off");
        avatarRectView.setImage(Assets.getImage(plates.get(0).img()));
        group.selectToggle(group.getToggles().get(0));
    }

    private void open(ToggleButton indicator) {
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().setAll(
                new KeyFrame(Duration.ZERO, new KeyValue(indicator.prefWidthProperty(), indWidth)),
                new KeyFrame(Duration.millis(200), new KeyValue(indicator.prefWidthProperty(), finalWidth))
        );
        timeline.play();
    }

    private void close(ToggleButton indicator) {
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().setAll(
                new KeyFrame(Duration.ZERO, new KeyValue(indicator.prefWidthProperty(), finalWidth)),
                new KeyFrame(Duration.millis(200), new KeyValue(indicator.prefWidthProperty(), indWidth))
        );
        timeline.play();
    }
}
