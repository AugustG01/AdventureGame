import java.util.Scanner;

public class Player {
    Room currentRoom;
    UserInterface ui = new UserInterface();
    List inventory = new List();
    Scanner scan = new Scanner(System.in);

    void takeItem() {
        String item = scan.nextLine();
        Item itemToAdd = currentRoom.itemsInRoom.removeItems(item);
        if(itemToAdd != null) {
            inventory.addItem(itemToAdd);
            ui.displayInventory(itemToAdd.getDescription());
        }
    }
    public void lookInInventory(){

        System.out.println("\nYou have " + inventory.printList() + " in your inventory");
    }
    public void dropItem() {
        String item = scan.nextLine();
        Item itemToDrop = inventory.removeItems(item);
        currentRoom.itemsInRoom.addItem(itemToDrop);
        inventory.removeItems(item);
        ui.droppedItem(item);
    }
    void look() {
        System.out.println(currentRoom.getRoomDescription());
        System.out.println("\nThere are some items in the room: " + currentRoom.itemsInRoom.printList());

    }
    void goNorth(){
        if(currentRoom.getNorth() != null) {
            currentRoom = currentRoom.getNorth();
            System.out.println("You go north");
            System.out.println("Entering " + currentRoom.getName());
            look();
        } else ui.doesNotExist();
    }
    void goSouth(){
        if(currentRoom.getSouth() != null) {
            currentRoom = currentRoom.getSouth();
            System.out.println("You go south");
            System.out.println("Entering " + currentRoom.getName());
            look();
        } else ui.doesNotExist();
    }

    void goEast(){
        if(currentRoom.getEast() != null) {
            currentRoom = currentRoom.getEast();
            System.out.println("You go east");
            System.out.println("Entering " + currentRoom.getName());
            look();
        } else ui.doesNotExist();
    }
    void goWest(){
        if(currentRoom.getWest() != null) {
            currentRoom = currentRoom.getWest();
            System.out.println("You go west");
            System.out.println("Entering " + currentRoom.getName());
            look();
        } else ui.doesNotExist();
    }

}

