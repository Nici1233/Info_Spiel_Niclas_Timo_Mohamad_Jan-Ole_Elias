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
        say("Mist, die ist verschlossen!",5,1);
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
        if(!getWorld().getClass().equals(Basement.class)){
            startSound("sounds/error-sound.mp3");
            say("Ich glaub, ich habe was vergessen...", 5, 1);
        }
        return false;

    }

    private void checkInput() {
        if (Greenfoot.isKeyDown("Q") && (getWorld().getClass().equals(Office.class))) {
            if (inputActive) {

                String input = Greenfoot.ask("Ich sehe was was du nicht siehst");
                if (input != null && input.equals("511")) {
                    say("Der ist wohl richtig!",8, 1);
                    spawnKey(5,1);
                    startSound("sounds/correct-choice.mp3");
                } else {
                    say("Mist falsch! Aber wieviel liegt da eigentlich rum?",8, 1);
                    startSound("sounds/error-sound.mp3");
                }

                inputActive = false;
            } else {
                inputActive = true;
            }
        }
    }

    private void checkInput1() {
        if (Greenfoot.isKeyDown("Q") && (getWorld().getClass().equals(Floor2.class))) {
            if (inputActive) {

                String input = Greenfoot.ask("Licht scheint manchmal unscheinbar");
                if (input != null && input.equals("42")) {
                    say("Super! Geschafft! Dahinten ist auch schon der Schlüssel",8, 1);
                    say("",1,1);
                    spawnKey(1,1);
                    startSound("sounds/correct-choice.mp3");
                } else {
                    say("Mist, dass war wohl falsch... ",8, 1);

                    say("Aber wieso sind manche Fackeln aus und andere an?", 8,1);
                    say("",1,1);
                    startSound("sounds/error-sound.mp3");
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
            pick();


        }
        if(getWorld().getClass().equals(Floor2.class) && checkKey()) {
            Greenfoot.setWorld(new Basement());
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






    public void act() {
        performMovement();
        checkInput();
        checkInput1();
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
        if (Greenfoot.isKeyDown("P") && checkPickaxe() && getWorld().getClass().equals(Basement.class)  ) {
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
                getWorld().showText("Herzlichen Glückwunsch, sie haben ihr Abitur bestanden",getWorld().getWidth() / 2, getWorld().getHeight() / 2);
            }
        }
    }






    public void move() {
        if (canMove()) {
            move(1);

        }
    }





}