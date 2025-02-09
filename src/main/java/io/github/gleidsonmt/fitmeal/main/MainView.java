package io.github.gleidsonmt.fitmeal.main;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  04/02/2025
 */
public class MainView extends ScrollPane {

    private Body body;

    public MainView() {
        body = new Body();
        setContent(body);
        setFitToWidth(true);
        setFitToHeight(true);
    }
}
