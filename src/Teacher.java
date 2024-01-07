public class Teacher extends MovingActor {

    private int life = 100;
    private boolean introCompleted = false;
    public void act(){
        if (!introCompleted) {
            turn(Direction.EAST);

            say("Sch�n, dass Sie es auch mal geschafft haben.",8);
            say("Sie k�nnen sich gerne setzen.",8);
            say(" Ihre Aufgabe f�r heute ist es,",8);
            say("100mal diesen Satz abzuschreiben:",8);
            say("'Ich stehle weder noch beleidige ich",8);
            say("meine Mitsch�ler und Mitsch�lerinnen!'",8);

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
