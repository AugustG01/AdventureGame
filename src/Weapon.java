public abstract class Weapon extends Item{
    private int damage;
    Weapon(String description, int damage){
        super(description);
        this.damage = damage;
    }
    public void setDamage(int damage){
        this.damage = damage;
    }
    public int getDamage() {
        return damage;
    }
}
