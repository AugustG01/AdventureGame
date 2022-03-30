import java.util.Random;

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
    public int attack(){

        if(missChance())
            return 0;
        else
            return criticalChance();
    }

    public boolean missChance() {
        int miss = random.nextInt(missChance);
        //System.out.println("miss random number: " + miss);
        if (miss == 0) {
            System.out.println(ColorClass.YELLOW + "Miss" + ColorClass.RESET);
            return true;
        }
        return false;
    }
    public int criticalChance() {
        int crit = random.nextInt(criticalChance);
        //System.out.println("critical random number: " + crit);
        if (crit == 0) {
            System.out.println(ColorClass.RED + "Critical" + ColorClass.RESET);
            return damage * 2;
        }
        else
        return damage;
    }
}
