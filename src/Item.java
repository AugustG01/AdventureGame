import java.util.ArrayList;

public class Item {

    ArrayList<String> items = new ArrayList<>();

    public void setItems(String item){
        items.add(item);
    }
    ArrayList<String> getItems(){
        return items;
    }

}
