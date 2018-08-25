import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;


public class Brick
{
    //Member variables
    int xLocation;
    int yLocation;
    int wDimension;
    int hDimension;

    BufferedImage brickImage;


    public Brick(int x, int y, int w, int h)
    {
        xLocation = x;
        yLocation = y;
        wDimension = w;
        hDimension = h;

        try
        {
            this.brickImage = ImageIO.read(new File("brick.jpg"));
        }
        catch(Exception e)
        {
            e.printStackTrace(System.err);
            System.exit(1);
        }
    }


}
