package Adventure;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.sound.sampled.*;

public abstract class Weapon extends Item{
    private int damage;
    private int criticalChance;
    private int missChance;
    Random random = new Random();

    Weapon(String description, int damage, int criticalChance, int missChance){
        super(description);
        this.damage = damage;
        this.criticalChance = criticalChance;
        this.missChance = missChance;
    }
    public void setDamage(int damage){
        this.damage = damage;
    }
    public int getDamage() {
        return damage;
    }

    public int attack() throws UnsupportedAudioFileException, LineUnavailableException, IOException {

        if(missChance())
            return 0;
        else
            return criticalChance();
    }

    public boolean missChance() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        int miss = random.nextInt(missChance);
        //System.out.println("miss random number: " + miss);
        if (miss == 0) {
            System.out.println(ColorClass.YELLOW + "Miss" + ColorClass.RESET);


           /* File swoosh = new File("swoosh.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(swoosh);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            clip.start();
           */

            return true;
        }
        return false;
    }
    public int criticalChance() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        int crit = random.nextInt(criticalChance);
        //System.out.println("critical random number: " + crit);
        if (crit == 0) {
            System.out.println(ColorClass.RED + "Critical" + ColorClass.RESET);

            File swoosh = new File("Super Smash Bros - Critical Hit Sound Effect.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(swoosh);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            clip.start();


            return damage * 2;
        }
        else
        return damage;
    }


}
