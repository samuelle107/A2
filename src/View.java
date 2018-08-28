import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

class View extends JPanel //The view class shows what the user will see.
{
    //Member variables
    Model model;

    View(Controller c, Model m)
    {
        model = m;
        c.setView(this);
    }

    public void paintComponent(Graphics g)
    {
        g.setColor(new Color(128, 255, 255)); //Sets the color of the background to be cyan.
        g.fillRect(0,0,this.getWidth(), this.getHeight()); //Fills the specified rectangle

        for(int i = 0; i < model.bricks.size(); i++) //This for loop will loop through all of the brick objects
        {
            Brick b = model.bricks.get(i); //Since we have an array of bricks, we want to change the index every loop
            g.drawImage(Brick.brickImage, b.xLocation-model.hCamPos, b.yLocation, b.wDimension, b.hDimension, null); //Draw the ith brick.  Each brick has difference properties, so we use the object, b.
        }
    }
}
