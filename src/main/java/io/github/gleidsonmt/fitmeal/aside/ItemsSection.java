package io.github.gleidsonmt.fitmeal.aside;

import io.github.gleidsonmt.fitmeal.main.Body;
import io.github.gleidsonmt.fitmeal.model.Item;
import io.github.gleidsonmt.fitmeal.utils.Assets;
import io.github.gleidsonmt.glad.controls.avatar.AvatarRectView;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.text.DecimalFormat;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  07/02/2025
 */
public class ItemsSection extends ScrollPane {

    public ItemsSection(List<Item> items) {
        VBox.setVgrow(this, Priority.ALWAYS);

        VBox.setMargin(this, new Insets(20,0,20,0));

        VBox body = new VBox();
        body.setSpacing(20);
        setContent(body);
        setFitToHeight(true);
        setFitToWidth(true);

        items.forEach(el -> {
            GridPane grid = new GridPane();

            AvatarRectView avatarRectView = new AvatarRectView();
            avatarRectView.setSize(80);
            avatarRectView.setArcWidth(20);
            avatarRectView.setArcHeight(20);
            avatarRectView.setImage(Assets.getImage(el.img()));

            Text title = new Text(el.name());
            title.getStyleClass().addAll("text-14", "bold");
            Text legend = new Text(el.legend());
            Currency currency = Currency.getInstance(Locale.getDefault());
            Text price = new Text(currency.getSymbol() + " " + new DecimalFormat("0").format(el.price()));
            price.getStyleClass().addAll("text-12", "bolder");

            ComboBox<Integer> combo = new ComboBox<>(FXCollections.observableArrayList(1,2,3,4,5));
            combo.getSelectionModel().select(0);

            grid.setHgap(10);
            grid.setVgap(10);

            grid.add(avatarRectView, 0,0);
            grid.add(title, 1,0);
            grid.add(price, 2,0);
            grid.add(legend, 1,1);
            grid.add(combo, 1,2);


            GridPane.setHgrow(title, Priority.ALWAYS);
            GridPane.setVgrow(avatarRectView, Priority.ALWAYS);
            GridPane.setRowSpan(avatarRectView, GridPane.REMAINING);

            body.getChildren().add(grid);
//            grid.setGridLinesVisible(true);
        });
    }
}
