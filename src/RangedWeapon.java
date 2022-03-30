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
    public int attack() {
        if(ammunition < 1){
            System.out.println("You are out of ammo!");
            return 0;
        }
        else {
            ammunition -= 1;
            return super.attack();
        }
    }
}
