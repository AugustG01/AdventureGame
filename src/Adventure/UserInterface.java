package Adventure;

import java.util.Scanner;

public class UserInterface {
    Scanner scan = new Scanner(System.in);
    String answer;

    public void intro() {

        System.out.println("Hi and welcome to the");
        System.out.println(" ('-. .-.   ('-.                      .-') _  .-') _     ('-.  _ .-') _         ('-. .-.                            .-')      ('-.   \n" +
                "( OO )  /  ( OO ).-.                 ( OO ) )(  OO) )  _(  OO)( (  OO) )       ( OO )  /                           ( OO ).  _(  OO)  \n" +
                ",--. ,--.  / . --. / ,--. ,--.   ,--./ ,--,' /     '._(,------.\\     .'_       ,--. ,--. .-'),-----.  ,--. ,--.   (_)---\\_)(,------. \n" +
                "|  | |  |  | \\-.  \\  |  | |  |   |   \\ |  |\\ |'--...__)|  .---',`'--..._)      |  | |  |( OO'  .-.  ' |  | |  |   /    _ |  |  .---' \n" +
                "|   .|  |.-'-'  |  | |  | | .-') |    \\|  | )'--.  .--'|  |    |  |  \\  '      |   .|  |/   |  | |  | |  | | .-') \\  :` `.  |  |     \n" +
                "|       | \\| |_.'  | |  |_|( OO )|  .     |/    |  |  (|  '--. |  |   ' |      |       |\\_) |  |\\|  | |  |_|( OO ) '..`''.)(|  '--.  \n" +
                "|  .-.  |  |  .-.  | |  | | `-' /|  |\\    |     |  |   |  .--' |  |   / :      |  .-.  |  \\ |  | |  | |  | | `-' /.-._)   \\ |  .--'  \n" +
                "|  | |  |  |  | |  |('  '-'(_.-' |  | \\   |     |  |   |  `---.|  '--'  /      |  | |  |   `'  '-'  '('  '-'(_.-' \\       / |  `---. \n" +
                "`--' `--'  `--' `--'  `-----'    `--'  `--'     `--'   `------'`-------'       `--' `--'     `-----'   `-----'     `-----'  `------' ");
    }

    public void newHealth(int healthPoints, int health) {
        if (healthPoints < 0) {
            System.out.println(ColorClass.RED + "You ate POISON!. Your HP is reduced to " + health + ColorClass.RESET);
        } else
            System.out.println(ColorClass.GREEN + "You increased your health by " + healthPoints + ". Your HP is now " + health + ColorClass.RESET);
    }
    public void tryToFlee(){
        System.out.println(ColorClass.CYAN + "You cannot flee during combat!" + ColorClass.RESET);
    }

    public void help() {
        System.out.println(ColorClass.CYAN + """
                Type "go north/south/east/west" to go that way
                Type "look" to look at your surroundings
                type "i" or "inventory" to look at your inventory
                Type "take" to pickup an item in the room
                Type "drop" to drop an item from your inventory
                Type "exit" to exit the game
                Type "attack" to attack the enemy
                Type "equip" to equip a weapon
                Type "eat" to eat something in your inventory or in the room""" + ColorClass.RESET);
    }

    public void playerChoice() {
        System.out.println("""
                                
                What do you want to do?
                Type help to get commands""");
        answer = scan.nextLine().toLowerCase();
    }

    public void doesNotExist() {
        System.out.println(ColorClass.ORANGE + "There is no door in this direction" + ColorClass.RESET);
    }

    public void exit() {
        System.out.println(ColorClass.ORANGE + "You exited the program" + ColorClass.RESET);
    }

    public void takeChoice() {
        System.out.println("Type in the item you want to take?");
    }

    public void eatChoice() {
        System.out.println("Type in the item you would like to eat?");
    }

    public void noItemFound() {
        System.out.println(ColorClass.ORANGE + "No item found" + ColorClass.RESET);
    }

    public void equipChoice() {
        System.out.println("What item would you like to equip?");
    }

    public void displayInventory(String item) {
        System.out.println("You have taken: " + ColorClass.GREEN + item + ColorClass.RESET);
    }

    public void droppedItem(String item) {
        System.out.println("You have dropped " + ColorClass.RED + item + ColorClass.RESET);
    }

    public void dropChoice() {
        System.out.println("Type in the item you want to drop?");
    }

    public void showHealth(int health){
        System.out.println("You have " +ColorClass.RED + health + ColorClass.RESET + " HP");
    }

    Health healthStatus(int health) {
        if(health < 25)
            return Health.CRITICAL_HEALTH;
        if(health < 60 && health >= 25)
            return Health.LOW_HEALTH;
        if(health >= 60)
            return Health.FULL_HEALTH;

        System.out.println("You have " + health + " HP");
        return null;
    }

}
