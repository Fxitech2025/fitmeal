package io.github.gleidsonmt.fitmeal.main;

import io.github.gleidsonmt.fitmeal.model.MenuItem;
import io.github.gleidsonmt.fitmeal.utils.Assets;
import io.github.gleidsonmt.glad.controls.avatar.AvatarRectView;
import io.github.gleidsonmt.glad.controls.icon.Icon;
import io.github.gleidsonmt.glad.controls.icon.IconButton;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import java.text.DecimalFormat;
import java.util.Currency;
import java.util.Locale;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  06/02/2025
 */
public class Card extends VBox {

    public Card(MenuItem menuItem) {

        StackPane imgView = createImageView();
        imgView.getChildren().add(createRectView(menuItem.img()));
        imgView.getChildren().add(createFavoriteButton());

        Footer footer = new Footer(menuItem);

        getChildren().addAll(imgView, footer);

        configLayout(footer);
    }

    private void configLayout(Footer footer) {
        setAlignment(Pos.CENTER);
        setMaxWidth(250);
        setPadding(new Insets(20));
    }

    private AvatarRectView createRectView(String image) {
        AvatarRectView avatarRectView = new AvatarRectView();
        avatarRectView.setImage(Assets.getImage(image));
        avatarRectView.setWidth(200);
        avatarRectView.setHeight(180);
        avatarRectView.setArcHeight(20);
        avatarRectView.setArcWidth(20);
        return avatarRectView;
    }

    private IconButton createFavoriteButton() {
        IconButton icon = new IconButton();
        icon.getStyleClass().add("bg-white");
        icon.setStyle("-fx-fill: red; -gn-icon: favorite_filled; -gn-icon-color: -fx-accent;");
        StackPane.setAlignment(icon, Pos.TOP_RIGHT);
        StackPane.setMargin(icon, new Insets(10));
        return icon;
    }

    private StackPane createImageView() {
        StackPane imgView = new StackPane();
        return imgView;
    }
}

class Footer extends GridPane {

    public Footer(MenuItem menuItem) {
        setPadding(new Insets(10));
        Text title = new Text(menuItem.name());
        Text legend = new Text(menuItem.legend());
        title.setStyle("-fx-font-weight: bold");
        legend.getStyleClass().add("info-text");
        Currency currency = Currency.getInstance(Locale.getDefault());
        Text price = new Text(currency.getSymbol() + " " + new DecimalFormat("0.##").format(menuItem.price()));
        add(title, 0,0);
        add(legend, 0,1);
        add(price, 1,0);

        GridPane.setRowSpan(price, 2);
        GridPane.setHgrow(title, Priority.ALWAYS);
    }
}
