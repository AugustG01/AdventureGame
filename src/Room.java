public class Room{
    private Room north;
    private Room south;
    private Room east;
    private Room west;
    private String name;
    private String roomDescription;
    private Enemy enemy;

    List itemsInRoom = new List();

    Room(){}
    Room(String name, String listOfThings){
        this.roomDescription = listOfThings;
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
    String getRoomDescription(){
        return roomDescription;
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
    public void setEnemy(Enemy enemy){
        this.enemy = enemy;
    }
    public Enemy getEnemy(){
        return enemy;
    }
}
