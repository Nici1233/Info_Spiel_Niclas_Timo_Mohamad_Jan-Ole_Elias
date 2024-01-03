import com.pholser.junit.quickcheck.internal.Items;
import greenfoot.*;

import java.util.List;


/**
 * @author SAE
 * @version 1.0
 */
public class Player extends MovingActor {


    private InventoryVisualizer inventory;
private ChestPuzzle puzzle1;



    private int life = 100;

    private Pickable[] pickables = new Pickable[4];
    public Player(){
        puzzle1 = new ChestPuzzle();
    }

    public int getLife() {
        return life;
    }
    public void setLife(int life) {
        this.life = life;
    }


    public void teacherHit() {
        List<Teacher> teachers= getNeighbours(1, true, Teacher.class);
        if (teachers.size() > 0) {
            teachers.get(0).hit(10);
        }
    }
    protected void addedToWorld(World world){
        inventory= new InventoryVisualizer(pickables);
        world.addObject(inventory,(world.getWidth()/2)- pickables.length/2,world.getHeight()-1);
    }
    protected void addedKeyToWorld(World world){
        Key key= new Key();
        world.addObject(key,this.getX(), this.getY());
    }

    public void hit(int damage) {

        setLife(getLife() - damage);
    }


    public void keyPick(){
        World myWorld = getWorld();
        List<Pickable> objectlist = myWorld.getObjectsAt(getX() +1, getY(), Pickable.class);
        if (objectlist.size() > 0) {
            Pickable pickable = objectlist.get(0);
            for (int i = 0; i < pickables.length; i++) {
                if (pickables[i] == null){
                    pickables[i] = pickable;
                    myWorld.removeObject(pickable);
                    i=pickables.length;
                }
            }
        }
    }

    public boolean checkKey(){
        World myWorld = getWorld();
        for (int i = 0; i < pickables.length; i++) {
            if (pickables[i] != null) {
                Pickable pickable = pickables[i];
                pickables[i] = null;
                i = pickables.length;
                return true;

            }

        }return false;

    }

    public void useDoor(){
        World myWorld = getWorld();
        List<Door> objectlist = myWorld.getObjectsAt(getX() , getY() , Door.class);
        if (objectlist.size() > 0) {
            goToNextWorld();
        }

    }

    public void goToNextWorld(){
        if(getWorld().getClass().equals(TestWorld.class) && checkKey()) {
            Greenfoot.setWorld(new Floor());
        }
        if(getWorld().getClass().equals(Floor.class)) {
            Greenfoot.setWorld(new Office());
        }
        if(getWorld().getClass().equals(Office.class) && checkKey()) {
            Greenfoot.setWorld(new Yard());
        }

        /*if(getWorld().getClass().equals(Yard.class) && checkKey()) {
            Greenfoot.setWorld(new Floor2());
        }*/

    }

    public void useChest(){
        World myWorld = getWorld();
        List<Chest> objectlist = myWorld.getObjectsAt(getNextX(1) ,getNextY(1),Chest.class);
        if (objectlist.size() > 0) {
            if(getWorld().getClass().equals(Yard.class)) {

                while(query(6, "Was ist 3+3?") == false){
                    System.out.println("Das ist nicht richtig. Versuche es noch einmal!");
                    query(6, "Was ist 3+3?");
                }
                System.out.println("Das ist richtig. Du hast das Schloss genackt!");
            }

        }

    }

    public boolean query(int solution, String task) {

        String input = Greenfoot.ask(task);
        int playerNumber = Integer.parseInt(input);
        if (playerNumber == solution) {
            return true;
        }
        return false;
    }




    public void act() {
        performMovement();
    }

    private void performMovement() {
        if (Greenfoot.isKeyDown("W")) {
            turn(Direction.NORTH);
            move();


        }
        if (Greenfoot.isKeyDown("A")) {
            turn(Direction.WEST);
            move();
        }
        if (Greenfoot.isKeyDown("S")) {
            turn(Direction.SOUTH);
            move();
        }
        if (Greenfoot.isKeyDown("D")) {
            turn(Direction.EAST);
            move();
        }
        if (Greenfoot.isKeyDown("E")) {
            keyPick();
            useDoor();
            useChest();
        }
        /*if (Greenfoot.isKeyDown("O")){

            if (getX()== 13 && getY()==0) {
                Floor level1 = new Floor();
                Greenfoot.setWorld(level1);
            }
            if (getX()== 1 && getY()==3){
                Office level2 = new Office();
                Greenfoot.setWorld(level2);
            }

            if (getX()== 13 && getY()==3){
                TestWorld level3 = new TestWorld();
                Greenfoot.setWorld(level3);
            }

            if (getX()== 1 && getY()==5){
                Floor level4 = new Floor();
                Greenfoot.setWorld(level4);
            }

            if (getX()== 1 && getY()==5){
                Floor level5 = new Floor();
                Greenfoot.setWorld(level5);
            }

            if (getX()== 3 && getY()==0){
                Yard level6 = new Yard();
                Greenfoot.setWorld(level6);
            }

            //if ()
        }*/







    }






    public void move() {
        if (canMove()) {
            move(1);

        }
    }





}