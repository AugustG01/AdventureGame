public class GameTest {

    boolean gameOn = true;
    Map map = new Map();
    Player player = new Player();
    UserInterface ui = new UserInterface();

    void go() {
        map.gameSetup();
        player.currentRoom = map.getStartRoom();
        ui.intro();
        while(gameOn) {
            ui.playerChoice();
            moveCommands();
        }
    }
    void moveCommands() {
        switch (ui.answer) {
            case "help" -> ui.help();
            case "exit" -> {
                ui.exit();
                gameOn = false;
            }
            case "look" -> player.look();
            case "take" -> {
                ui.takeChoice();
                player.takeItem();
            }
            case "inventory","i" -> player.lookInInventory();
            case "drop","d" -> {
                ui.dropChoice();
                player.dropItem();
            }
            case "health" -> player.displayHealth();
            case "eat", "namme nam" -> player.eat();
            case "north", "n", "go north" -> player.goNorth();
            case "south", "s", "go south" -> player.goSouth();
            case "east", "e", "go east" -> player.goEast();
            case "west", "w", "go west" -> player.goWest();
        }
    }
}



