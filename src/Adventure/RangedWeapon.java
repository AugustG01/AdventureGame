package Adventure;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class RangedWeapon extends Weapon{
    private int ammunition;

    RangedWeapon(String description, int damage, int criticalChance, int missChance, int ammunition){
        super(description, damage, criticalChance, missChance);
        this.ammunition = ammunition;
    }
    public int getAmmunition(){
        return ammunition;
    }

    @Override
    public int attack() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        if(ammunition < 1){
            System.out.println(ColorClass.RED + "You are out of ammo!" + ColorClass.RESET);
            return 0;
        }
        else {
            ammunition -= 1;
            return super.attack();
        }
    }
}
