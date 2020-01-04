package dev.codenmore.tilegame.display;

import javafx.scene.transform.Affine;
import sun.tools.jstat.Scale;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * TODO
 * @author Faysal Al-Kharraz
 * @version
 */
public class ImageLoader {

    private static final String IMAGE_LODER_ERROR_MESSAGE = "Error Loading the Image \n" +
            "Error: ";

    //****************************************************************************************************************//

    //Defining variables to determine image dimensions
    private static int imageHeight;
    private static int imageWidth;

    //****************************************************************************************************************//

    public static BufferedImage imageLoader(String path) {
        try {
            return ImageIO.read(ImageLoader.class.getResource(path));
        } catch (IOException e) {
            System.err.println(IMAGE_LODER_ERROR_MESSAGE);
            System.err.println(e.getMessage());
        }

        return null;
    }

}
