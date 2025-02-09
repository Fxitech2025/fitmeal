package io.github.gleidsonmt.fitmeal;

import fr.brouillard.oss.cssfx.CSSFX;
import io.github.gleidsonmt.fitmeal.utils.Assets;
import io.github.gleidsonmt.glad.base.Container;
import io.github.gleidsonmt.glad.base.Root;
import io.github.gleidsonmt.glad.theme.Css;
import io.github.gleidsonmt.glad.theme.Font;
import io.github.gleidsonmt.glad.theme.ThemeAccessor;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.scenicview.ScenicView;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  04/02/2025
 */
public class App extends Application {
    @Override
    public void start(Stage stage) {
        MainLayout mainLayout = new MainLayout();
        Root root = createRoot(mainLayout);
        stage.setScene(createScene(root));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

    private Root createRoot(Container container) {
        Root root = new Root(container);
        ThemeAccessor.install(root, Font.POPPINS);
        ThemeAccessor.install(root,
                Css.COLORS,
                Css.TYPOGRAPHIC,
                Css.SHAPES,
                Css.PROPERTIES,
                Css.BOOTSTRAP,
                Css.IMMERSIVE_SCROLL,
                Css.TAB_PANE,
                Css.COMBO_BOX,
                Css.CONTEXT_MENU
        );
        root.getStylesheets().addAll(
                Assets.getCSS("drawer.css"),
                Assets.getCSS("main.css"),
                Assets.getCSS("aside.css")
        );

        return root;
    }

    private Scene createScene(Parent root) {
        Scene scene = new Scene(root, 1200, 768);
        scene.setFill(Color.TRANSPARENT);
        CSSFX.start(scene);
        ScenicView.show(scene);
        return scene;
    }
}
