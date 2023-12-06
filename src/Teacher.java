public class Teacher extends MovingActor {

    private int life = 100;

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
