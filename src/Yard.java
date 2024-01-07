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
        addObject(new Tree(),0,3);
        addObject(new Tree(),3,2);
        addObject(new Tree(),7,2);
        addObject(new Tree(),2,0);
        addObject(new Tree(), 1,1);
        addObject(new Tree(),6,1);
        addObject(new Tree(),7,1);
        addObject(new Tree(), 4,0);
        addObject(new Tree(), 7,3);
        addObject(new Tree(),6,2);
    }


}
