import com.pholser.junit.quickcheck.internal.Items;
import greenfoot.*;

import java.util.List;


/**
 * @author SAE
 * @version 1.0
 */
public class Player extends MovingActor {
    private InventoryVisualizer inventory;




    private int life = 100;

    private Item[] keys = new Item[4];

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
        inventory= new InventoryVisualizer(keys);
        world.addObject(inventory,6,world.getHeight()-1);
    }

    public void hit(int damage) {

        setLife(getLife() - damage);
    }


    public void keyPick(){
        World myWorld = getWorld();
        List<Key> objectlist = myWorld.getObjectsAt(getX() +1, getY(), Key.class);
        if (objectlist.size() > 0) {
            Key key = objectlist.get(0);
            for (int i = 0; i < keys.length; i++) {
                if (keys[i] == null){
                    keys[i] = key;
                    myWorld.removeObject(key);
                    i=keys.length;
                }
            }
        }
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
        }
        if (Greenfoot.isKeyDown("O")&& getX()== 13 && getY()==0){
            Floor level = new Floor();
            Greenfoot.setWorld(level);
        }
        if (Greenfoot.isKeyDown("O")&& getX()== 1 && getY()==3){
            Office level = new Office();
            Greenfoot.setWorld(level);
        }
    }

    public void move() {
        if (canMove()) {
            move(1);

        }
    }





}