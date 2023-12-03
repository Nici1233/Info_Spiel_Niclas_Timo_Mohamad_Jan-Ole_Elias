import greenfoot.World;

/**
 * Write a description of class RabbitLevel1 here.
 *
 * @author SAE
 * @version 1.0
 */
public class Classroom extends MasterLevel
{


    /**
     * Constructor for objects of class RabbitLevel1.
     *
     */
    public Classroom()
    {

        setBackground("./images/cell.jpg");
        setPaintOrder(Player.class);
        addObject(new Player(), 0,0);
    }
    //Test

}
