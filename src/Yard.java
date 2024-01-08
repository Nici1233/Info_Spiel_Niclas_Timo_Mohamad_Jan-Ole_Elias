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
        addObject(new Chest(),7,0);

        addObject(new Bench(),0,2);
        addObject(new Tree(),0,1);

        addObject(new Bench(),7,2);
        addObject(new Tree(),7,3);

        addObject(new Window(),0,3);
        addObject(new Window(),1,3);

        addObject(new Door(),3,0);
        addObject(new Wall(),2,0);
        addObject(new Wall(),4,0);
    }


}
