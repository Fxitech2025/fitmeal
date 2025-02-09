package io.github.gleidsonmt.fitmeal.aside;



import io.github.gleidsonmt.glad.controls.icon.Icon;
import io.github.gleidsonmt.glad.controls.icon.SVGIcon;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  04/02/2025
 */
public class DeliveryAddress extends GridPane {

    public DeliveryAddress() {

        Text legend = new Text("Delivery address");
        GridPane title = createTitle();

        Label legendTime = new Label("40 mins");
        SVGIcon one = new SVGIcon(Icon.CLOCK, 0.6);
        legendTime.setGraphic(one);
        Label legendPlace = new Label("4 kms");
        SVGIcon two = new SVGIcon(Icon.LOCATION_ON, 0.6);
        legendPlace.setGraphic(two);

        add(legend, 0,0);
        add(title, 0,1);
        add(legendTime, 0,2);
        add(legendPlace, 1,2);

        GridPane.setColumnSpan(legend, REMAINING);

        setHgap(30);
        setVgap(5);
//        setGridLinesVisible(true);
    }

    private GridPane createTitle() {
        GridPane grid = new GridPane();
        grid.setPrefWidth(500);
        Text title = new Text("1341 Morris Street");
        title.getStyleClass().addAll("text-22", "bolder");
        SVGIcon icon = new SVGIcon(Icon.CHEVRON_RIGHT, 1.5);
        icon.setStyle("-fx-fill: -dark-gray-2;");
        icon.setRotate(90);
        grid.add(title, 0,0);
        grid.add(icon, 1,0);
        grid.setHgap(20);
        grid.setStyle("-fx-padding: 0px;");
//        grid.setGridLinesVisible(true);

        GridPane.setHalignment(icon, HPos.RIGHT);
        GridPane.setHgrow(grid, Priority.ALWAYS);
        GridPane.setColumnSpan(grid, REMAINING);
        GridPane.setHgrow(title, Priority.ALWAYS);
        return grid;
    }
}


