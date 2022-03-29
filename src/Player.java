import java.util.Scanner;

public class Player {
    Room currentRoom;
    UserInterface ui = new UserInterface();
    List inventory = new List();
    Scanner scan = new Scanner(System.in);

    void takeItem() {
        String item = scan.nextLine();
        Item itemToAdd = currentRoom.itemsInRoom.removeItems(item);
        if (itemToAdd == null) {
            System.out.println("Oops, no such item exists!");
        } else {
            inventory.addItem(itemToAdd);
            ui.displayInventory(itemToAdd.getDescription());
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
        String item = scan.nextLine();
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
        if (currentRoom.getNorth() != null) {
            currentRoom = currentRoom.getNorth();
            System.out.println("You go north");
            System.out.println("Entering " + currentRoom.getName());
            look();
        } else ui.doesNotExist();
    }

    void goSouth() {
        if (currentRoom.getSouth() != null) {
            currentRoom = currentRoom.getSouth();
            System.out.println("You go south");
            System.out.println("Entering " + currentRoom.getName());
            look();
        } else ui.doesNotExist();
    }

    void goEast() {
        if (currentRoom.getEast() != null) {
            currentRoom = currentRoom.getEast();
            System.out.println("You go east");
            System.out.println("Entering " + currentRoom.getName());
            look();
        } else ui.doesNotExist();
    }

    void goWest() {
        if (currentRoom.getWest() != null) {
            currentRoom = currentRoom.getWest();
            System.out.println("You go west");
            System.out.println("Entering " + currentRoom.getName());
            look();
        } else ui.doesNotExist();
    }

}

