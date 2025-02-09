package io.github.gleidsonmt.fitmeal.main;

import io.github.gleidsonmt.fitmeal.model.MenuItem;
import io.github.gleidsonmt.glad.controls.icon.Icon;
import io.github.gleidsonmt.glad.controls.icon.SVGIcon;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

import java.util.List;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  06/02/2025
 */
public class TabView extends TabPane {
    public TabView() {
        Tab tabOne = createTab("Nearby");
        tabOne.setGraphic(new SVGIcon(Icon.NEARBY));
        Tab tabTwo = createTab("Promotion");
        tabTwo.setGraphic(new SVGIcon(Icon.CONFIRMATION_NUMBER));
        Tab tabThree = createTab("Newcomers");
        tabThree.setGraphic(new SVGIcon(Icon.ORDERS));
        Tab tabFour = createTab("Best Sellers");
        tabFour.setGraphic(new SVGIcon(Icon.WORKSPACE_PREMIUM));
        Tab tabFive = createTab("Top Rated");
        tabFive.setGraphic(new SVGIcon(Icon.FAVORITE));
        Tab tabSix = createTab("All");
        tabSix.setGraphic(new SVGIcon(Icon.APPS));

        getTabs().setAll(
                tabOne,
                tabTwo,
                tabThree,
                tabFour,
                tabFive,
                tabSix
        );

        tabOne.setContent(createContainer(new GridItemView(
                List.of(
                        new MenuItem("Burger Mozza XL", "Burger Queen", 39, "img_1.jpg" ),
                        new MenuItem("Vag Manchaurian XL", "Burger Queen", 39, "img_2.jpg" ),
                        new MenuItem("Fired Slad", "Burger Queen", 39, "img_3.jpg" ),
                        new MenuItem("Burger Mozza XL", "Burger Queen", 39, "img_4.jpg" ),
                        new MenuItem("Chicken Caesar Salad Wrap", "Burger Queen", 45, "img_5.jpg" ),
                        new MenuItem("Chicken Caesar Salad Wrap", "Burger Queen", 35, "img_6.jpg" )
                )
        )));
    }

    public ScrollPane createContainer(Node content) {
        ScrollPane container = new ScrollPane();
        container.setContent(content);
        container.setFitToWidth(true);
        container.setFitToHeight(true);
        return container;
    }

    private Tab createTab(String text) {
        Tab tab = new Tab(text);
        tab.setClosable(false);
        return tab;
    }
}
