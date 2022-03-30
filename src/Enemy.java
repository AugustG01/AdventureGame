public class Enemy {
    private String name;
    private String description;
    private Item weapon;
    private int health;


    public Enemy(String name, String description, Item weapon, int health){
        setName(name);
        setDescription(description);
        setWeapon(weapon);
        setHealth(health);
    }

    public void hit(int damage) {
        health -= damage;
        if(health > 0) {
            System.out.println("You hit " + name + " and did " + damage + " damage to him");
            if (health >= 1)
                System.out.println(name + " now has " + health + " HP");
        }
    }

    public int attack() {
        return ((Weapon)weapon).attack();
    }

    public Item drop() {
        return weapon;
    }

    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public Item getWeapon(){
        return weapon;
    }
    public int getHealth(){
        return health;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setWeapon(Item weapon){
        this.weapon = weapon;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
