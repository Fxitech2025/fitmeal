package io.github.gleidsonmt.fitmeal.main;

import io.github.gleidsonmt.glad.controls.icon.Icon;
import io.github.gleidsonmt.glad.controls.icon.SVGIcon;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import org.jetbrains.annotations.Contract;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  04/02/2025
 */
public class SearchBar extends GridPane {
    public SearchBar() {
        setId("search-bar");
        add(createIcon(Icon.SEARCH), 0,0);
        add(createTextField(), 1,0);
        add(createIcon(Icon.FILTER), 2,0);

        setConstraints();
    }

    @Contract(pure = true)
    private void setConstraints(){
        VBox.setMargin(this, new Insets(30,0,0,0));
        RowConstraints row1 = new RowConstraints();
        row1.setMinHeight(60);
        getRowConstraints().setAll(row1);
    }

    private SVGIcon createIcon(Icon icon) {
        SVGIcon svgIcon = new SVGIcon(icon);
        GridPane.setMargin(svgIcon, new Insets(10,20, 10, 20));
        return svgIcon;
    }

    private TextField createTextField() {
        TextField field = new TextField();
        field.setPromptText("What would you like to eat?");
        GridPane.setHgrow(field, Priority.ALWAYS);
        return field;
    }
}
