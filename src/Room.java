import java.util.ArrayList;

public class Room{
    private Room north;
    private Room south;
    private Room east;
    private Room west;
    private String name;
    private String listOfThings;
    //Item item = new Item();
    ArrayList<Item> items = new ArrayList<>();

    Room(){}
    Room(String name, String listOfThings){
        this.listOfThings = listOfThings;
        this.name = name;
    }
    public void setNorth(Room north){
        this.north = north;
    }
    public void setSouth(Room south){
        this.south = south;
    }
    public void setEast(Room east){
        this.east = east;
    }
    public void setWest(Room west){
        this.west = west;
    }
    String getListOfThings(){
        return listOfThings;
    }
    String getName(){
        return name;
    }
    Room getNorth(){
        return north;
    }
    Room getSouth(){
        return south;
    }
    Room getEast(){
        return east;
    }
    Room getWest() {
        return west;
    }
    public void setItem(Item item1, Item item2, Item item3){
        items.add(item1);
        items.add(item2);
        items.add(item3);
    }
    ArrayList<Item> getItems(){
        return items;
    }
    public Item removeItems(String itemToBeRemoved) {
        for (int i = 0; i < items.size(); i++) {
            Item tmp = items.get(i);
            if (items.get(i).getDescription().equalsIgnoreCase(itemToBeRemoved)){
                items.remove(items.get(i));
                return tmp;
            }
        } return null;
    }
    public void addItem(Item itemToBeAdded){
        items.add(itemToBeAdded);
    }
}
