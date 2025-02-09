module io.github.gleidsonmt.fitmeal {
    requires javafx.controls;

    requires io.github.gleidsonmt.glad;
    requires fr.brouillard.oss.cssfx;
    requires org.jetbrains.annotations;
    requires org.scenicview.scenicview;
    requires java.sql;

    opens io.github.gleidsonmt.fitmeal to javafx.fxml;
    exports io.github.gleidsonmt.fitmeal;
}