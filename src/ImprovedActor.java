import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.GreenfootSound;

public class ImprovedActor extends Actor {
    private GreenfootImage currentImage; //stored to ensure paint can be removed

    /**
     * Sets the image saving the old image for later use.
     * @param image to set
     */
    @Override
    public void setImage(GreenfootImage image){
        currentImage = image;
        super.setImage(new ImprovedGreenfootImage(image));
    }


    /**
     * Draws the text over the current image.
     * @param text to be drawn
     */
    public void draw(String text){
        ImprovedGreenfootImage image = new ImprovedGreenfootImage(currentImage);
        image.drawString(text, 0, 10);
        super.setImage(image);
    }

    /**
     * Draws the int value over the current image.
     * @param value to be drawn
     */
    public void draw(int value){
        draw(String.valueOf(value));
    }
    public void startSound(String titel){
        GreenfootSound sound = new GreenfootSound(titel);
        sound.play();
    }
    public void say(String text, int delay) {
        int y = getY() - 1;
        if (y < 0) {
            y = 1;
        }

        getWorld().showText(text, getX()-3, y);
        System.out.println("a " + this.getClass().getName() + " says: " + text);
        Greenfoot.delay(delay);
        getWorld().showText("", getX()-3, y);

    }
}
