package freeseawind.ninepatch.javafx;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public class ImageHolder {
    public Control control;
    public Image image;
    public ImageHolder(Control control, Image image) {
        super();
        this.control = control;
        this.image = image;
    }
}
