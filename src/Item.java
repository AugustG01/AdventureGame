import java.util.ArrayList;

public class Item {

    ArrayList<String> items = new ArrayList<String>();

    ArrayList<String> getItems(){
        return items;
    }

    public void setItems(String item1, String item2, String item3){
        items.add(item1);
        items.add(item2);
        items.add(item3);
    }


}
