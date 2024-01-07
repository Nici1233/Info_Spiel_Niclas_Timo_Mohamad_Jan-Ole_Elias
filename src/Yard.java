import greenfoot.*;

public class Yard extends World {
    public Yard()
    {
        super(8, 4, 60);
        //setBackground("./images/cell.jpg");
        setBackground("./images/concrete_Floor_3v.png");
        setPaintOrder(Player.class);
        addObject(new Player(), 0,1);
        //addObject(new Chest(), 8,0);

        addObject(new Tree(),3,4);
        addObject(new Tree(),3,3);
        addObject(new Tree(),2,3);
        addObject(new Tree(),2,4);
    }


}
