import java.awt.event.*;

class Controller implements MouseListener, KeyListener
{
    //Member variables
    View view;
    Model model;

    boolean keyLeft;
    boolean keyRight;
    boolean keyUp;
    boolean keyDown;

    int preXLocation; //X coordinate on mouse press
    int preYLocation; //Y coordinate on mouse press
    int postXLocation; //X coordinate on mouse release
    int postYLocation; //Y coordinate on mouse release

    Controller(Model m) //Constructor
    {
        model = m; //I pass in the model object to this constructor and call it "m".  It is then assigned to model in this class.
    }

    void setView(View v)
    {
        view = v;
    }

    public void keyPressed(KeyEvent e)
    {
        int movementSpeed = 15; //Movement speed of the camera

        switch(e.getKeyCode())
        {
            case KeyEvent.VK_RIGHT: keyRight = true;
            model.hCamPos += movementSpeed; //Moves x pixels to the right.
            break;
            case KeyEvent.VK_LEFT: keyLeft = true;
            model.hCamPos -= movementSpeed; //Moves x pixels to the left.
            break;
            case KeyEvent.VK_UP: keyUp = true; break;
            case KeyEvent.VK_DOWN: keyDown = true; break;
        }
    }

    public void keyReleased(KeyEvent e)
    {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_RIGHT: keyRight = false; break;
            case KeyEvent.VK_LEFT: keyLeft = false; break;
            case KeyEvent.VK_UP: keyUp = false; break;
            case KeyEvent.VK_DOWN: keyDown = false; break;
        }
    }

    public void keyTyped(KeyEvent e)
    {
    }

    void update() //This function updates every few ms and updates the model's location based on the keypress
    {
        if(keyRight) model.dest_x++;
        if(keyLeft) model.dest_x--;
        if(keyDown) model.dest_y++;
        if(keyUp) model.dest_y--;
    }

    public void mousePressed(MouseEvent e)
    {
        //Getting the preCoordinates of the brick
        preXLocation = e.getX();
        preYLocation = e.getY();
    }

    public void mouseReleased(MouseEvent e)
    {
        int xFinal; //The final value for the x coordinate
        int yFinal; //The final value for the y coordinate
        int w; //Magnitude of the difference of the pre and post x coordinates
        int h; //Magnitude of the difference of the pre and post y coordinates

        //Getting the postCoordinates of the brick
        postXLocation = e.getX();
        postYLocation = e.getY();

        //Calculating width and height
        w = postXLocation - preXLocation;
        h = postYLocation - preYLocation;

        //Adjusting for negative widths
        if(w < 0)
           w = -w;
        if(h < 0)
            h = -h;

        //Determines the final location of the brick based on the way the box is drawn.  This is because the image is always drawn in the left corner.
        if(postYLocation > preYLocation)
        {
            if(postXLocation > preXLocation)
            {
                xFinal = preXLocation;
                yFinal = preYLocation;
            }
            else
            {
                xFinal = preXLocation - w;
                yFinal = postYLocation - h;
            }
        }
        else
        {
            if(postXLocation > preXLocation)
            {
                xFinal = postXLocation - w;
                yFinal = preYLocation - h;
            }
            else
            {
                xFinal = postXLocation;
                yFinal = postYLocation;
            }
        }

        model.addTube(xFinal, yFinal,w,h); //Adds the tube to the array
    }

    public void mouseEntered(MouseEvent e)
    {

    }

    public void mouseExited(MouseEvent e)
    {

    }

    public void mouseClicked(MouseEvent e)
    {

    }

}
