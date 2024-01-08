import java.util.List;

public class Teacher extends MovingActor {

    private int life = 100;
    private boolean introCompleted = false;
    public void act(){
        if (!introCompleted) {
            //List<Player> objectlist = getWorld().getObjects(Player.class);
           // Player player = objectlist.get(0);
            //player.say("Hallo",8,1);
            say("Schön, dass Sie es auch mal geschafft haben.",8);
            say("Sie können sich gerne setzen.",8);
            say(" Ihre Aufgabe für heute ist es,",8);
            say("100mal diesen Satz abzuschreiben:",8);
            say("'Ich stehle weder noch beleidige ich",8);
            say("meine Mitschüler und Mitschülerinnen!'",8);

            introCompleted = true;
        }
    }

    public int getLife() {
        return life;
    }
    public void setLife(int life) {
        this.life = life;
    }


    public void hit(int damage) {
        hit(damage);
        if (getLife() <= 0) {
            getWorld().removeObject(this);
        }
    }

}