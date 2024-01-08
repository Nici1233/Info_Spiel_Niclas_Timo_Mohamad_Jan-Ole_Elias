import com.pholser.junit.quickcheck.internal.Items;
import greenfoot.*;

import java.util.List;


/**
 * @author SAE
 * @version 1.0
 */
public class Player extends MovingActor {


    private InventoryVisualizer inventory;
    //private ChestPuzzle puzzle1;

    private int vaultlife;

    private boolean hasKey = false;
    private boolean inputActive = true;

    private int life = 100;

    private Pickable[] pickables = new Pickable[2];

    /*public Player(){
        puzzle1 = new ChestPuzzle();
    }*/

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


    public void pick(){
        World myWorld = getWorld();
        List<Pickable> objectlist = getNeighbours(1,true,Pickable.class);
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

        }
        startSound("sounds/error-sound.mp3");
        say("Mist, die ist verschlossen!",8,1);
        return false;

    }
    public boolean checkPickaxe(){
        World myWorld = getWorld();
        for (int i = 0; i < pickables.length; i++) {
            if (pickables[i] != null) {
                Pickable pickable = pickables[i];
                pickables[i] = null;
                i = pickables.length;
                return true;
            }

        }
        startSound("sounds/error-sound.mp3");
        say("Ich glaub, ich habe was vergessen...",8,1);
        return false;

    }

    private void checkInput() {
        if (Greenfoot.isKeyDown("enter")) {
            if (inputActive) {

                String input = Greenfoot.ask("Betrachte deine Umgebung und zähle, was du siehst. (Fange mit der größten Zahl an)");

                if (input != null && input.equals("511")) {
                    getWorld().showText("Korrekte Zahl! Du hast gewonnen!",getWorld().getWidth() / 2, getWorld().getHeight() / 2);
                    spawnKey(5,1);
                } else if (input != null && input.equals("42")) {
                    getWorld().showText("Andere korrekte Zahl! Du hast gewonnen!",getWorld().getWidth() / 2, getWorld().getHeight() / 2);
                    spawnKey(1,1);
                } else {
                    getWorld().showText("Falsche Zahl. Versuche es erneut.",getWorld().getWidth() / 2, getWorld().getHeight() / 2);
                }

                inputActive = false;
            } else {
                inputActive = true;
            }
        }
    }

    private void spawnKey(int x, int y) {
        World world = getWorld();
        world.addObject(new Key(), x, y); // Annahme: Es gibt eine Key-Klasse
    }

    public void useDoor(){
        World myWorld = getWorld();
        List<Door> objectlist = myWorld.getObjectsAt(getX() , getY() , Door.class);
        if (objectlist.size() > 0) {
            goToNextWorld();
        }

    }

    public void goToNextWorld(){
        if(getWorld().getClass().equals(Classroom.class) && checkKey()) {
            Greenfoot.setWorld(new Floor());
        }
        if(getWorld().getClass().equals(Floor.class)) {
            Greenfoot.setWorld(new Office());
            startSound("./sounds/OfficeCall.mp3");
        }
        if(getWorld().getClass().equals(Office.class) && checkKey()) {
            Greenfoot.setWorld(new Yard());
        }

        if(getWorld().getClass().equals(Yard.class) && checkPickaxe()) {
            Greenfoot.setWorld(new Floor2());
        }

    }

    public void useChest() {
        World myWorld = getWorld();
        List<Chest> objectlist = myWorld.getObjectsAt(getNextX(1), getNextY(1), Chest.class);
        if (objectlist.size() > 0) {

            Chest chest = objectlist.get(0);
            if(!chest.isChestOpen()) {
                chest.startPuzzle();

            }
        }
    }



    public void vaultHit(){
        List<Vault> vaults = getNeighbours(1,true,Vault.class);
        if (vaults.size() > 0 && checkPickaxe()){
            vaults.get(0).hit(10);
        }
    }

    /*public void destroyVault() {
        World myWorld = getWorld();
        List<Vault> vaults = myWorld.getObjectsAt(getNextX(1), getNextY(1), Vault.class);
        if (vaultlife < 1) {
            if (vaults.size() > 0) {
                Vault vault = vaults.get(0);
                vault.setVaultLife(vault.getVaultLife() - 1);
                //if (vault.getVaultLife() <= 0)
                //myWorld.removeObject(vault);
            }
        }
    }*/




    public void act() {
        performMovement();
        checkInput();
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
            pick();
            useDoor();
            useChest();
        }
        if (Greenfoot.isKeyDown("P") && checkPickaxe()) {
            punchSafe();
        }
    }

    public void punchSafe() {
        World myWorld = getWorld(); // Standort in der Welt
        List<Safe> safes = myWorld.getObjectsAt(getNextX(1), getNextY(1), Safe.class);
        if (safes.size() > 0) {
            Safe safe = safes.get(0);
            safe.setLife(safe.getLife() - 10);
            if (safe.getLife() == 0) {
                myWorld.removeObject(safe);
            }
        }
    }






    public void move() {
        if (canMove()) {
            move(1);

        }
    }





}