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
    public Floor() {

        super(16,4,60);
        setBackground("./images/Boden_4.jpg");
        addObject(new Wall(),0,1);
        addObject(new Wall(),0,2);
        addObject(new Wall(),0,3);
        addObject(new Wall(),2,3);
        addObject(new Wall(),3,3);
        addObject(new Wall(),5,3);
        addObject(new Wall(),6,3);
        addObject(new Wall(),8,3);
        addObject(new Wall(),9,3);
        addObject(new Wall(),11,3);
        addObject(new Wall(),12,3);
        addObject(new Wall(),14,3);
        addObject(new Wall(),15,3);
        addObject(new Wall(),16,3);


        addObject(new Wall(),0,0);
        addObject(new Wall(),1,0);
        addObject(new Wall(),2,0);
        addObject(new Wall(),4,0);
        addObject(new Wall(),5,0);
        addObject(new Wall(),6,0);
        addObject(new Wall(),7,0);
        addObject(new Wall(),9,0);
        addObject(new Wall(),10,0);
        addObject(new Wall(),11,0);
        addObject(new Wall(),13,0);
        addObject(new Wall(),14,0);
        addObject(new Wall(),15,0);
        setPaintOrder(Player.class);




        addObject(new Door(), 13, 3);
        addObject(new Door(), 1, 3);


        addObject(new FakeDoor(), 4, 3);
        addObject(new FakeDoor(), 7, 3);
        addObject(new FakeDoor(), 10, 3);


        addObject(new FakeDoor(), 3, 0);
        addObject(new FakeDoor(), 8, 0);
        addObject(new FakeDoor(), 12, 0);

        addObject(new Player(), 13, 3);




    }


}
