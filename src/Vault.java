public class Vault extends Blockers {

    private int vaultlife;

    public int getVaultLife() {
        return vaultlife;
    }

    public void setVaultLife(int newVaultlife) {
        vaultlife = newVaultlife;
    }

    public void hit(int damage) {
        setVaultLife(getVaultLife()- damage);
        if (vaultlife <= 0) {
            getWorld().removeObject(this);
        }

    }

}
