import greenfoot.Greenfoot;

import java.util.List;

public class Chest extends Blockers {


    private boolean chestOpen =false;
    public boolean isChestOpen() {
        return chestOpen;
    }

    public void setChestOpen(boolean chestOpen) {
        this.chestOpen = chestOpen;
    }
public void startPuzzle(){
    List<Player> objectlist = getWorld().getObjectsAt(getX()-1,getY(),Player.class);
    Player player = objectlist.get(0);
    player.say("Mist, ich glaub ich brauch einen ", 8, 1);
    player.say("3-stelligen Code für die Truhe...", 16, 1);
    player.turnLeft();
    player.turnLeft();

    player.say("Ah, da ist ein Hinweis,", 8,1);
    player.say("",1,1);
    player.move(1);
    player.say("Vielleicht kann der mit ja helfen...",8,1);
    player.say("",1,1);
    player.turn(Direction.EAST);
    player.move(1);
    Greenfoot.delay(5);



    if(getWorld().getClass().equals(Yard.class)) {

        while(query(579, "Die Ziffern sind aufeinanderfolgende, aufsteigende ungerade Zahlen, und die Summe der Ziffern beträgt 21..") == false){

            player.say("Mist, wieso ist das denn falsch!?", 8, 1);
            player.say("Dann muss ichs wohl",6,1);
            player.say("nochmal versuchen...",8,1);
            player.say("",1,1);
            query(579, "Die Ziffern sind aufeinanderfolgende, aufsteigende ungerade Zahlen, und die Summe der Ziffern beträgt 21.");
        }
        //startSound("");
        this.setImage("images/Chest_07_01.png");
        getWorld().addObject(new Pickaxt(), 7,0);
        setChestOpen(true);
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



}
