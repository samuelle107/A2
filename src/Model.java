import java.util.ArrayList;
class Model
{
//    int brick_x;
//    int brick_y;
    int dest_x;
    int dest_y;

    int hCamPos;

    ArrayList<Brick> bricks;

    Model()
    {
        bricks = new ArrayList<Brick>();
    }

    public void addTube(int x, int y, int w, int h)
    {
        //Create a new Brick object called b and adds it to the bricks array
        Brick b = new Brick(x, y, w, h);
        bricks.add(b);
    }

    public void update()
    {
        //This will move the turtle to the destination of the mouse click.
//        this.brick_x = dest_x;
//        this.brick_y = dest_y;
    }

    //Marshall Method
    Json marshal()
    {
        Json ob = Json.newObject();
        Json brickList = Json.newList();
        ob.add("bricks", brickList);
        for(int i = 0; i < bricks.size(); i++)
            brickList.add(bricks.get(i).marshal());
        return ob;
    }

    //Unmarshal method
    void unMarshal (Json ob)
    {
        ArrayList<Brick> newList = new ArrayList<Brick>();
        Json jsonList = ob.get("bricks");
        for (int i = 0; i < jsonList.size(); i++)
            newList.add(new Brick(jsonList.get(i)));
        bricks = newList;
    }



}
