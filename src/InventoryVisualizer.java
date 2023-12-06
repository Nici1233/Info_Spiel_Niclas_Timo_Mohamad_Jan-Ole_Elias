import greenfoot.Actor;
import greenfoot.World;

import java.util.List;

public class InventoryVisualizer extends Actor {

    private final InventorySlot[] slots;
    private final Actor[] inventory;

    public InventoryVisualizer(Actor[] inventory) {
        getImage().setTransparency(0);
        slots = new InventorySlot[inventory.length];
        this.inventory = inventory;
    }

    public InventoryVisualizer(List<Actor> inventory) {
        this(inventory.toArray(new Actor[0]));
    }

    public void act(){
        update();
    }
    
    protected void addedToWorld(World world){
        for(int i=0; i < slots.length; i++){
            slots[i] = createItemSlot(i);
        }
    }

    private InventorySlot createItemSlot(int i) {
        InventorySlot slot = new InventorySlot();
        getWorld().addObject(slot, i, getY());
        return slot;
    }

    
    /**
     * Updates all inventory Slots at the bottom of the screen with the content of the given inventory Array
     */ 
    private void update() {
        int length = Math.min(inventory.length, this.slots.length);
        for (int i = 0; i < length; i++) {
            if (inventory[i] != this.slots[i].getItem()) {
                slots[i].setItem(inventory[i]);
            }
        }
    }

}
