package io.github.gleidsonmt.fitmeal.utils;

import io.github.gleidsonmt.fitmeal.App;
import javafx.scene.image.Image;

import java.util.Objects;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  01/02/2025
 * v. 1.0
 */
public class Assets {

    public static Image getImage(String name) {
        return new Image(Objects.requireNonNull(App.class.getResource("img/" + name)).toExternalForm());
    }

    public static Image getImage(String name, int size) {
        return new Image(Objects.requireNonNull(App.class.getResource("img/" + name)).toExternalForm(), size, size, true, true);
    }

    public static Image getImage(String name, int width, int height) {
        return new Image(Objects.requireNonNull(App.class.getResource("img/" + name)).toExternalForm(), width, height, true, true);
    }

    public static String getCSS(String name) {
        return Objects.requireNonNull(Objects.requireNonNull(App.class.getResource("css/" + name)).toExternalForm());
    }
}
