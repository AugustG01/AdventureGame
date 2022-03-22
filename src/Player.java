import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    Room currentRoom;
    UserInterface ui = new UserInterface();
    Item itm = new Item("hovsa");
    ArrayList<Item> inventory = new ArrayList<>();
    Scanner scan = new Scanner(System.in);

    void takeItem() {
        String item = scan.nextLine();
        Item itemToAdd = currentRoom.removeItems(item);
        if(itemToAdd != null) {
            addItem(itemToAdd);
            ui.displayInventory(itemToAdd.getDescription());
        }
    }
    public void lookInInventory(){
        System.out.println(itm.getItems());
    }
    public void dropItem() {
        String item = scan.nextLine();
        Item itemToDrop = removeItems(item);
        currentRoom.addItem(itemToDrop);
        removeItems(item);
        ui.droppedItem(item);
    }
    void look() {
        System.out.println(currentRoom.getListOfThings());
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
    public Item removeItems(String itemToBeRemoved) {
        for (int i = 0; i < inventory.size(); i++) {
            Item tmp = inventory.get(i);
            if (inventory.get(i).getDescription().equalsIgnoreCase(itemToBeRemoved)){
                inventory.remove(inventory.get(i));
                return tmp;
            }
        } return null;
    }
    public void addItem(Item itemToBeAdded){
        inventory.add(itemToBeAdded);
    }
}

