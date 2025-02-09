package io.github.gleidsonmt.fitmeal;

import io.github.gleidsonmt.fitmeal.aside.Aside;
import io.github.gleidsonmt.fitmeal.drawer.Drawer;
import io.github.gleidsonmt.fitmeal.main.Body;
import io.github.gleidsonmt.fitmeal.main.MainView;
import io.github.gleidsonmt.glad.base.Container;
import javafx.scene.Node;
import javafx.scene.paint.Color;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  04/02/2025
 */
public class MainLayout extends Container {

    private Drawer drawer;
    private MainView main;
    private Aside aside;

    public MainLayout() {
        drawer = new Drawer();
        main = new MainView();
        aside = new Aside();

        drawer.setPrefWidth(60);
        main.setPrefWidth(1780);
        aside.setPrefWidth(340);

        setLeft(drawer);
        setCenter(main);
        setRight(aside);
    }
}
