import greenfoot.World;

public class Floor2 extends World {

    public Floor2 (){

        super(16,4,60);
        setBackground("./images/Boden_4.jpg");
        setPaintOrder(Player.class);



        addObject(new Door(), 0, 3);
        addObject(new Door(), 15, 3);


        addObject(new Wall(), 4, 3);
        addObject(new Wall(), 10, 3);
        addObject(new Wall(), 14, 3);


        addObject(new Wall(), 2, 0);
        addObject(new Wall(), 6, 0);
        addObject(new Wall(), 11, 0);


        addObject(new Wall(),1,3);
        addObject(new Wall(),2,3);
        addObject(new Wall(),3,3);
        addObject(new Wall(),5,3);
        addObject(new Wall(),6,3);
        addObject(new Wall(),7,3);
        addObject(new Wall(),8,3);
        addObject(new Wall(),9,3);
        addObject(new Wall(),11,3);
        addObject(new Wall(),12,3);
        addObject(new Wall(),13,3);
        addObject(new TorchOff(),13,3);
        addObject(new TorchOff(),2,3);
        addObject(new TorchOn(),5,3);
        addObject(new TorchOff(),10,3);


        addObject(new Wall(),0,0);
        addObject(new Wall(),1,0);
        addObject(new Wall(),3,0);
        addObject(new Wall(),4,0);
        addObject(new Wall(),5,0);
        addObject(new Wall(),7,0);
        addObject(new Wall(),8,0);
        addObject(new Wall(),9,0);
        addObject(new Wall(),10,0);
        addObject(new Wall(),12,0);
        addObject(new Wall(),13,0);
        addObject(new Wall(),14,0);
        addObject(new Wall(),15,0);
        addObject(new TorchOff(),13,0);
        addObject(new TorchOff(),2,0);
        addObject(new TorchOff(),5,0);
        addObject(new TorchOn(),10,0);


        addObject(new Player(), 0, 2);








    }
}