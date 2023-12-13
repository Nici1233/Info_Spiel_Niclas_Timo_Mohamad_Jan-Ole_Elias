import greenfoot.World;

/**
 * Write a description of class RabbitLevel1 here.
 *
 * @author SAE
 * @version 1.0
 */
public class Floor extends World
{


    /**
     * Constructor for objects of class RabbitLevel1.
     *
     */
    public Floor()
    {


        super(16,4,60);
        setBackground("./images/Boden_4.jpg");
        setPaintOrder(Player.class);
        addObject(new Player(), 13, 3);


        addObject(new Door(), 13, 3);

        addObject(new Wall(), 15, 3);
        addObject(new Wall(), 14, 3);

        for (int i = 0; i < 13; i++) {
            Wall wall = new Wall();
            addObject(wall, i, 3);
        }
        addObject(new Wall(), 0, 0);
        for (int i = 2; i < 16; i++) {
            Wall wall = new Wall();
            addObject(wall, i, 0);
        }

        addObject(new Wall(), 0, 2);
        addObject(new Wall(), 0, 1);

        addObject(new Door(), 1, 0);

    }


}
