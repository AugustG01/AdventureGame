import java.util.ArrayList;

public class List {
    ArrayList<Item> itemList = new ArrayList<>();

    public Item removeItems(String itemToBeRemoved) {
        for (int i = 0; i < itemList.size(); i++) {
            Item tmp = itemList.get(i);
            if (itemList.get(i).getDescription().equalsIgnoreCase(itemToBeRemoved)){
                itemList.remove(itemList.get(i));
                return tmp;
            }
        } return null;
    }
    public void addItem(Item itemToBeAdded){
        itemList.add(itemToBeAdded);
    }
    public void setItem(Item item1, Item item2, Item item3){
        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);
    }
    ArrayList<Item> getItems(){
        return itemList;
    }


}
