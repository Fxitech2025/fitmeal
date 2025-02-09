package io.github.gleidsonmt.fitmeal.aside;

import io.github.gleidsonmt.fitmeal.model.Item;
import io.github.gleidsonmt.glad.controls.icon.Icon;
import io.github.gleidsonmt.glad.controls.icon.SVGIcon;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.List;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  04/02/2025
 */
public class Aside extends VBox {
    public Aside() {
        setId("aside");

        getChildren().setAll(createTitle(),
                new DeliveryAddress(),
                new ItemsSection(
                        List.of(
                                new Item("burger_1.jpg", "Burger Mozza Xl", "Extra Cheese", 45),
                                new Item("burger_2.jpg", "Chilli Fried Burger", "Extra Cheese", 39)
                        )
                ),
                new TotalSection()
        );
        setPadding(new Insets(20));
    }

    private Text createTitle() {
        Text title = new Text("My Orders");
        title.getStyleClass().addAll("text-20", "bold");
        VBox.setMargin(title, new Insets(0, 0, 20, 0));
        return title;
    }
}


