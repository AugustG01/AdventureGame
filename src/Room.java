public class Room{
    private Room north;
    private Room south;
    private Room east;
    private Room west;
    private String name;
    private String listOfThings;
    Item item = new Item();

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
    public void setItem(String item1, String item2, String item3){
        this.item.setItems(item1, item2, item3);
    }
    Item getItem(){
        return item;
    }
    public void removeItem(String item){
        this.item.removeItems(item);
    }
}
