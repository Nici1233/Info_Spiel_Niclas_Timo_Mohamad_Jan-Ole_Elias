public class Safe extends Blockers {

    private int life=10;

    public int getLife() {
        return life;
    }
    public void setLife(int newLife){ //Methode
        life = newLife;
        getImage().drawString(String.valueOf(life), 0, 10);
    }
}
