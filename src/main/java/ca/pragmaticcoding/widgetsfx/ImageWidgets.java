package ca.pragmaticcoding.widgetsfx;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;

public class ImageWidgets {

    public static ImageView scaledImageViewFromUrl(String url, double fitWidth) {
        ImageView results = new ImageView(new Image(url, true));
        results.setFitWidth(fitWidth);
        results.setPreserveRatio(true);
        return results;
    }

    public static Background stretchedImageBackgroundFromUrl(String url) {
        BackgroundSize backgroundSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true);
        return (new Background(new BackgroundImage(new Image(url, true), null, null, null, backgroundSize)));
    }
}
