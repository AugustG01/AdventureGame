import java.util.Scanner;

public class Player {
    private int health;
    Room currentRoom;
    UserInterface ui = new UserInterface();
    List inventory = new List();
    Scanner scan = new Scanner(System.in);
    Weapon weapon;
    boolean inCombat = false;

    Player(int health){
        setHealth(health);
    }

    public void setHealth(int health){
        this.health = health;
    }

    public int getHealth(){
        return health;
    }

    public void displayHealth(){
        ui.showHealth(getHealth());
    }
    //equip weapon
    public void equip(){
        ui.equipChoice();
        String equippedItem = scan.nextLine();
        Item weaponToEquip = inventory.removeItems(equippedItem);

        if(weaponToEquip == null){
            System.out.println("No item found in inventory");
        }
        else if(weaponToEquip instanceof Weapon){
            if (weapon != null) {
                inventory.addItem(weapon);
            }
            weapon = ((Weapon) weaponToEquip);
            System.out.println("Weapon equipped");
        }
        else
            System.out.println(weaponToEquip.getDescription() + " is not a weapon");

    }
    //checks if attacking is possible
    public boolean attackPossible(){
        if(weapon == null) {
            System.out.println("You cannot attack without a weapon!");
            return false;
        }
        if(currentRoom.getEnemy() == null){
            System.out.println("No enemy to attack");
            return false;
        }
        else
            return true;
    }
    //enemy killed, removed from room and weapon is given to player
    public void killEnemy(Enemy enemy){
        System.out.println("Enemy died!");
        inventory.addItem(enemy.drop());
        System.out.println("You picked up " + enemy.drop().getDescription());
        currentRoom.setEnemy(null);
    }
    //player attacks the enemy
    public void attack() {
        inCombat = true;
        if(attackPossible()) {
            Enemy enemy = currentRoom.getEnemy();
            //System.out.println("You are attacking with " + weapon.getDescription() + " and it does " + weapon.attack() + " damage");
            enemy.hit(weapon.attack());
            if(enemy.getHealth() <= 0) {
                killEnemy(enemy);
                inCombat = false;
            }
            else hit(enemy);
        }
    }
    //enemy hits player, and checks if the player is dead, if not print current health
    public void hit(Enemy enemy){
        int tmp = enemy.attack();
        health -= tmp;
        checkIfDead();

        // if player is dead, checkIfDead sets GameOn to false
        if (GameTest.gameOn) {
            System.out.println("Enemy attacks you and deals " + tmp + " damage");
            System.out.println("your current health is now " + health);
            if(weapon instanceof RangedWeapon){
                System.out.println("ammo left: " + ((RangedWeapon) weapon).getAmmunition());
            }
        }
    }

    //eat food, adds health to player
    public void eat() {
        String foodItem = scan.nextLine();
        //Scanner for food item
        Item itemToEat = currentRoom.itemsInRoom.removeItems(foodItem);
        //fjerner food item fra rummet
        if(itemToEat == null){
            itemToEat = inventory.removeItems(foodItem);
            if(itemToEat == null){
                ui.noItemFound();
            }
            else addHealth(itemToEat);
        } else addHealth(itemToEat);

    }
    //Adds heath to player after eating
    public void addHealth(Item itemToEat) {
        if (itemToEat instanceof Food){
            int addedHealth = ((Food)itemToEat).getHealthPoints();
            health += addedHealth;
            ui.newHealth(addedHealth, health);
            checkIfDead();
        }else
        System.out.println("Not edible!!");

    }
    //checks if the player is dead
    public void checkIfDead(){
        if (health <= 0){
            System.out.println("You died");
            GameTest.gameOn = false;
        }
    }

    public void takeItem(){
        // get user input
        String item = scan.nextLine();
        // remove item from room and store in itemToAdd variable
        Item itemToAdd = currentRoom.itemsInRoom.removeItems(item);
        if (itemToAdd == null) {
            System.out.println("Oops, no such item exists!");
        } else if (inventory.itemList.size() < 5){
            inventory.addItem(itemToAdd);
            ui.displayInventory(itemToAdd.getDescription());
        } else {
            System.out.println("Your inventory is full. Drop some items to make space for new ones");
        }
    }

    public void lookInInventory() {
        if (inventory.itemList.size() == 0) {
            System.out.println("Your inventory is empty");
        } else {
            System.out.println("\nYou have \n" + inventory.printList() + "in your inventory");
        }
    }

    public void dropItem() {
        // get user input
        String item = scan.nextLine();
        // remove item from inventory and store item in itemToDrop
        Item itemToDrop = inventory.removeItems(item);
        if(itemToDrop != null) {
            currentRoom.itemsInRoom.addItem(itemToDrop);
            inventory.removeItems(item);
            ui.droppedItem(item);
        } else {
            System.out.println("no such item exists");
        }
    }
    //prints out the items in the currentRoom
    void look() {
        System.out.println(currentRoom.getRoomDescription());
        System.out.println("\nThere are some items in the room: \n" + currentRoom.itemsInRoom.printList());
        if (currentRoom.getEnemy() != null) {
            System.out.println("A creature is approaching. Be careful!");
            System.out.println(currentRoom.getEnemy().getName() + ", "
                    + currentRoom.getEnemy().getDescription()
                    + ". HP: " + currentRoom.getEnemy().getHealth());
        }


    }


    void goNorth() {
        if(!inCombat) {
            if (currentRoom.getNorth() != null) {
                currentRoom = currentRoom.getNorth();
                System.out.println("You go north");
                System.out.println("Entering " + currentRoom.getName());
                look();
            } else ui.doesNotExist();
        } else ui.tryToFlee();
    }

    void goSouth() {
        if(!inCombat) {
            if (currentRoom.getSouth() != null) {
                currentRoom = currentRoom.getSouth();
                System.out.println("You go south");
                System.out.println("Entering " + currentRoom.getName());
                look();
            } else ui.doesNotExist();
        } else ui.tryToFlee();
    }

    void goEast() {
        if(!inCombat) {
            if (currentRoom.getEast() != null) {
                currentRoom = currentRoom.getEast();
                System.out.println("You go east");
                System.out.println("Entering " + currentRoom.getName());
                look();
            } else ui.doesNotExist();
        } else ui.tryToFlee();
    }

    void goWest() {
        if(!inCombat) {
            if (currentRoom.getWest() != null) {
                currentRoom = currentRoom.getWest();
                System.out.println("You go west");
                System.out.println("Entering " + currentRoom.getName());
                look();
            } else ui.doesNotExist();
        } else ui.tryToFlee();
    }

}

