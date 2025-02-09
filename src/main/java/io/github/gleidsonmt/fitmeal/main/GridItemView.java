package io.github.gleidsonmt.fitmeal.main;

import io.github.gleidsonmt.fitmeal.model.MenuItem;
import io.github.gleidsonmt.glad.responsive_grid.Break;
import io.github.gleidsonmt.glad.responsive_grid.ResponsiveGrid;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;

import java.util.List;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  06/02/2025
 */
public class GridItemView extends ResponsiveGrid {

    int row = 0;

    public GridItemView(List<MenuItem> items) {
        super(true);
        super.log();


        addPoint((event) -> updateCols(1), Break.SM);
        addPoint((event) -> updateCols(2), Break.MD, Break.LG);
        addPoint((event) -> updateCols(4), Break.XXL);
        addPoint((event) -> updateCols(3), Break.ALL);
        addPoint((event) -> updateCols(6), Break.WIDE);

        items.forEach(el -> {
            Card card = new Card(el);
            getChildren().add(card);
        });
    }

    private void updateCols(int cols) {
        int col = 0;
        for (int i = 0; i < getChildren().size(); i++) {
            GridItemView.setConstraints(getChildren().get(i), col++, row,1,1, HPos.CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS);
            if (col == cols) {
                col = 0;
                row++;
            }
        }
    }
}
