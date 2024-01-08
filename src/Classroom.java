import greenfoot.World;

/**
 * Write a description of class RabbitLevel1 here.
 * 
 * @author SAE
 * @version 1.0
 */
public class Classroom extends World
{

    
    /**
     * Constructor for objects of class RabbitLevel1.
     * 
     */
    public Classroom()
    {
        super(14, 6, 60);
        //setBackground("./images/cell.jpg");
        setBackground("./images/Boden_1.jpg");


        addObject(new Chair(),1,1);
        addObject(new Chair(),1,2);
        addObject(new Chair(),1,5);
        addObject(new Chair(),1,4);
        addObject(new Chair(),4,1);
        addObject(new Chair(),4,2);
        addObject(new Chair(),4,5);
        addObject(new Chair(),4,4);
        addObject(new Chair(),7,1);
        addObject(new Chair(),7,2);
        //addObject(new Chair(),7,5);
        addObject(new Chair(),7,4);
        addObject(new Chair(),10,1);
        addObject(new Chair(),10,2);
        addObject(new Chair(),10,5);
        addObject(new Chair(),10,4);
        addObject(new ChairDown(),12,3);

        addObject(new Board(),13,3);


        addObject(new Door(),0,0);
        addObject(new Door(),12,0);

        addObject(new Wall(),15,0);
        addObject(new Wall(),14,0);

        addObject(new Key(), 12, 3);
        addObject(new Teacher(), 13,3 );

        for(int i=1; i<12; i++) {
            Wall wall = new Wall();
            addObject(wall, i, 0);
        }
        setPaintOrder(Player.class);
        addObject(new Player(), 0,1);
    }
    
}
