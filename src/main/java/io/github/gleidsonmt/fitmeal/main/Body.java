package io.github.gleidsonmt.fitmeal.main;

import io.github.gleidsonmt.fitmeal.Box;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  04/02/2025
 */
public class Body extends VBox {

    public Body() {
        setId("body");
        setFillWidth(true);
        setPadding(new Insets(0,20,0,30));
        getChildren().setAll(
                new SearchBar(),
                new Banner(),
                new TabView()
        );
    }
}
