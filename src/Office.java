import greenfoot.World;

public class Office extends World
{



    public Office()
    {


        super(8,6,60);
        setBackground("./images/Boden_1.jpg");
        setPaintOrder(Player.class);
        addObject(new Player(), 1, 5);
        for (int i = 2; i < 8; i++) {
            Wall wall = new Wall();
            addObject(wall, i, 6);
        }
        addObject(new ChairDown(),5,1);

        addObject(new Table(),5,3);

        addObject(new Mug(),5,3);

        addObject(new Pizza(),6,3);

        addObject(new Door(), 1, 5);

        addObject(new Window(),2,0);
        addObject(new Window(),3,0);


        for (int i = 0; i < 6; i++) {
            Wall wall = new Wall();
            addObject(wall, 0, i);
        }
        for (int i = 4; i < 8; i++) {
            Wall wall = new Wall();
            addObject(wall, i, 0);
        }

        for (int i = 0; i < 6; i++) {
            Wall wall = new Wall();
            addObject(wall, 8, i);
        }


        addObject(new Wall(), 1, 0);
/*
        addObject(new Wall(), 0, 2);
        addObject(new Wall(), 0, 1);

        addObject(new Door(), 1, 0);*/

    }


}