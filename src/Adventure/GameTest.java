package Adventure;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class GameTest {

    public static boolean gameOn = true;
    Map map = new Map();
    Player player = new Player(100);
    UserInterface ui = new UserInterface();

    void go() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        map.gameSetup();
        player.currentRoom = map.getStartRoom();
        ui.intro();
        while(gameOn) {
            ui.playerChoice();
            moveCommands();
        }
    }
    void moveCommands() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
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
            case "drop" -> {
                ui.dropChoice();
                player.dropItem();
            }
            case "health" -> player.displayHealth();
            case "eat", "namme nam" ->{
                ui.eatChoice();
                player.eat();
            }
            case "equip","eq" -> player.equip();
            case "attack", "a" -> player.attack();
            case "north", "n", "go north" -> player.goNorth();
            case "south", "s", "go south" -> player.goSouth();
            case "east", "e", "go east" -> player.goEast();
            case "west", "w", "go west" -> player.goWest();
        }
    }
}



