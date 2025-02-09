package io.github.gleidsonmt.fitmeal.drawer;

import io.github.gleidsonmt.glad.controls.icon.Icon;
import io.github.gleidsonmt.glad.controls.icon.SVGIcon;
import javafx.geometry.Insets;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  04/02/2025
 */
public class Drawer extends VBox {

    private ToggleGroup group = new ToggleGroup();

    public Drawer() {
        setId("drawer");
        getChildren().setAll(
            createToggle(Icon.SORT),
            createToggle(Icon.FAVORITE),
            createToggle(Icon.HOME),
            createToggle(Icon.ORDERS),
            createToggle(Icon.CREDIT_CARD)
        );
        group.selectToggle(group.getToggles().get(2));
    }

    private ToggleButton createToggle(Icon _icon) {
        ToggleButton toggleButton = new ToggleButton();
        group.getToggles().add(toggleButton);
        toggleButton.setPrefWidth(60);
        toggleButton.getStyleClass().add("drawer-item");
        SVGIcon icon = new SVGIcon(_icon);
        toggleButton.setGraphic(icon);
        toggleButton.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        return toggleButton;
    }
}
