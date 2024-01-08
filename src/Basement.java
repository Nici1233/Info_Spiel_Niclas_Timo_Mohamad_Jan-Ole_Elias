import greenfoot.World;

/**
 * Write a description of class RabbitLevel1 here.
 *
 * @author SAE
 * @version 1.0
 */
public class Basement extends World{


    /**
     * Constructor for objects of class RabbitLevel1.
     *
     */
    public Basement()
    {
        super(9, 6, 60);
        setBackground("./images/concrete_Floor_3v.png");
        setPaintOrder(Player.class);


        addObject(new Wall(),1,5);
        addObject(new Wall(),2,5);
        addObject(new Wall(),3,5);
        addObject(new Wall(),5,5);
        addObject(new Wall(),6,5);
        addObject(new Wall(),7,5);

        for(int i=0; i<9; i++) {
            Wall wall = new Wall();
            addObject(wall, i, 0);
        }

        for(int i=1; i<6; i++) {
            Wall wall = new Wall();
            addObject(wall, 0, i);
        }

        for(int i=1; i<6; i++) {
            Wall wall = new Wall();
            addObject(wall, 8, i);
        }

        addObject(new Door(), 4, 5);

        addObject(new Letter(),4,2);
        addObject(new Safe(),4,2);
        addObject(new Player(),4,4);

        addObject(new Pickaxt(),3,3);

    }


}
