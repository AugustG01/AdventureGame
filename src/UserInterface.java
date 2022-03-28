import java.util.Scanner;

public class UserInterface {
    Scanner scan = new Scanner(System.in);
    String answer;

    public void intro() {
        String name;
        System.out.print("What is your name? ");
        name = scan.nextLine();
        System.out.println("Hi " + name + " and welcome to the");
        System.out.println(ColorClass.RED + " ('-. .-.   ('-.                      .-') _  .-') _     ('-.  _ .-') _         ('-. .-.                            .-')      ('-.   \n" +
                "( OO )  /  ( OO ).-.                 ( OO ) )(  OO) )  _(  OO)( (  OO) )       ( OO )  /                           ( OO ).  _(  OO)  \n" +
                ",--. ,--.  / . --. / ,--. ,--.   ,--./ ,--,' /     '._(,------.\\     .'_       ,--. ,--. .-'),-----.  ,--. ,--.   (_)---\\_)(,------. \n" +
                "|  | |  |  | \\-.  \\  |  | |  |   |   \\ |  |\\ |'--...__)|  .---',`'--..._)      |  | |  |( OO'  .-.  ' |  | |  |   /    _ |  |  .---' \n" +
                "|   .|  |.-'-'  |  | |  | | .-') |    \\|  | )'--.  .--'|  |    |  |  \\  '      |   .|  |/   |  | |  | |  | | .-') \\  :` `.  |  |     \n" +
                "|       | \\| |_.'  | |  |_|( OO )|  .     |/    |  |  (|  '--. |  |   ' |      |       |\\_) |  |\\|  | |  |_|( OO ) '..`''.)(|  '--.  \n" +
                "|  .-.  |  |  .-.  | |  | | `-' /|  |\\    |     |  |   |  .--' |  |   / :      |  .-.  |  \\ |  | |  | |  | | `-' /.-._)   \\ |  .--'  \n" +
                "|  | |  |  |  | |  |('  '-'(_.-' |  | \\   |     |  |   |  `---.|  '--'  /      |  | |  |   `'  '-'  '('  '-'(_.-' \\       / |  `---. \n" +
                "`--' `--'  `--' `--'  `-----'    `--'  `--'     `--'   `------'`-------'       `--' `--'     `-----'   `-----'     `-----'  `------' " + ColorClass.RESET);
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
                Type "equip" to equip a weapon""" + ColorClass.RESET);
    }
    public void playerChoice() {
        System.out.println("""
                
                What do you want to do?
                Type help to get commands""");
        answer = scan.nextLine().toLowerCase();
    }
    public void doesNotExist(){
        System.out.println(ColorClass.ORANGE + "There is no door in this direction" + ColorClass.RESET);
    }
    public void exit(){
        System.out.println(ColorClass.ORANGE + "You exited the program" + ColorClass.RESET);
    }
    public void takeChoice() {
        System.out.println("Type in the item you want to take?");
    }
    public void eatChoice(){
        System.out.println("Type in the item you would like to eat?");
    }
    public void noItemFound(){
        System.out.println("No item found");
    }
    public void equipChoice(){
        System.out.println("What item would you like to equip?");
    }

    public void displayInventory(String item) {
        System.out.println("You have taken: " + ColorClass.GREEN + item + ColorClass.RESET);
    }
    public void droppedItem(String item){
        System.out.println("You have dropped " + ColorClass.RED + item + ColorClass.RESET);
    }
    public void dropChoice() {
        System.out.println("Type in the item you want to drop?");
    }
}
