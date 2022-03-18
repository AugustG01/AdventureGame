import java.util.ArrayList;

public class Item {
    ArrayList<String> items = new ArrayList<>();

    ArrayList<String> getItems(){
        return items;
    }
    public void setItems(String item1, String item2, String item3){
        items.add(item1);
        items.add(item2);
        items.add(item3);
    }
    public void removeItems(String itemToBeRemoved) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).equalsIgnoreCase(itemToBeRemoved)){
                items.remove(items.get(i));

            }
        }
    }
}