import greenfoot.World;

/**
 * Write a description of class RabbitLevel1 here.
 * 
 * @author SAE
 * @version 1.0
 */
public class TestWorld extends World
{

    
    /**
     * Constructor for objects of class RabbitLevel1.
     * 
     */
    public TestWorld()
    {
        super(16, 8, 60);
        //setBackground("./images/cell.jpg");
        setBackground("./images/Boden_1.jpg");
        setPaintOrder(Player.class);
        addObject(new Player(), 0,0);

        addObject(new Chair(),1,1);
        addObject(new Chair(),1,2);
        addObject(new Chair(),1,5);
        addObject(new Chair(),1,6);
        addObject(new Chair(),4,1);
        addObject(new Chair(),4,2);
        addObject(new Chair(),4,5);
        addObject(new Chair(),4,6);
        addObject(new Chair(),7,1);
        addObject(new Chair(),7,2);
        addObject(new Chair(),7,5);
        addObject(new Chair(),7,6);
        addObject(new Chair(),10,1);
        addObject(new Chair(),10,2);
        addObject(new Chair(),10,5);
        addObject(new Chair(),10,6);
        addObject(new ChairDown(),14,4);

        addObject(new Board(),15,4);
    }
    
}
