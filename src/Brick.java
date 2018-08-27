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

    static BufferedImage brickImage;

    //Brick constructor
    Brick(int x, int y, int w, int h)
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

    // Marshals this object into a JSON DOM
    Json marshal()
    {
        Json ob = Json.newObject();
        ob.add("x", xLocation);
        ob.add("y", yLocation);
        ob.add("w", wDimension);
        ob.add("h", hDimension);
        return ob;
    }

    //Unmarhsaling constructor
    Brick(Json ob)
    {
        xLocation = (int)ob.getLong("x");
        yLocation = (int)ob.getLong("y");
        wDimension = (int)ob.getLong("w");
        hDimension = (int)ob.getLong("h");
    }
}
