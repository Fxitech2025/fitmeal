package io.github.gleidsonmt.fitmeal.aside;

import io.github.gleidsonmt.glad.controls.icon.Icon;
import io.github.gleidsonmt.glad.controls.icon.SVGIcon;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Separator;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.Currency;
import java.util.Locale;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  07/02/2025
 */
public class TotalSection extends GridPane {

    public TotalSection() {

//        setGridLinesVisible(true);
        setVgap(10);

        Currency currency = Currency.getInstance(Locale.getDefault());
        Text title = new Text("Sub Total");
        Text delivery = new Text("Delivery Free");

        Text price = new Text(currency.getSymbol() + " 84");
        price.getStyleClass().addAll("bold");
        Text deliveryPrice = new Text(currency.getSymbol() + " 9");
        deliveryPrice.getStyleClass().addAll("bold");

        add(createSeparator(), 0,0);

        add(title, 0,1);
        add(delivery, 0,2);
        add(price, 1,1);
        add(deliveryPrice, 1,2);

        Button btnPromo = new Button("Find Promotion");
        btnPromo.setGraphicTextGap(10);
        btnPromo.setPrefWidth(400);
        btnPromo.setContentDisplay(ContentDisplay.RIGHT);
        Button btnIcon = new Button("Add Coupon");
        btnIcon.setPrefWidth(150);
        SVGIcon icon = new SVGIcon(Icon.CONFIRMATION_NUMBER);
        btnIcon.setGraphic(icon);
        btnPromo.setGraphic(btnIcon);
        btnPromo.setId("promo");

        add(btnPromo, 0,3);
        GridPane.setColumnSpan(btnPromo, REMAINING);
        add(createSeparator(), 0,4);

        Text totalTitle = new Text("Total");
        Text totalPrice = new Text(currency.getSymbol() + " 171");
        totalPrice.getStyleClass().addAll("bold");

        add(totalTitle, 0,5);
        add(totalPrice, 1,5);

        Button button = new Button("Check out");
        button.setPrefWidth(400);
        button.setId("btn-check");
        add(button, 0, 6);

        GridPane.setHgrow(button, Priority.ALWAYS);
        GridPane.setColumnSpan(button, REMAINING);

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(50);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setHalignment(HPos.RIGHT);
        col2.setPercentWidth(50);
        getColumnConstraints().addAll(col1, col2);

    }

    private Node createSeparator() {
        Separator separator = new Separator();
        separator.setMinHeight(5);
        GridPane.setColumnSpan(separator, REMAINING);
        return separator;
    }
}
