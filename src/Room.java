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

    void setNorth(Room north){
        this.north = north;
    }
    void setSouth(Room south){
        this.south = south;
    }
    void setEast(Room east){
        this.east = east;
    }
    void setWest(Room west){
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
    void setItem(String item){
        this.item.setItems(item);
    }
    Item getItem(){
        return item;
    }
}
