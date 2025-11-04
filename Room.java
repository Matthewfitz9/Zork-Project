import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;


public class Room {
    private List<Item> items = new ArrayList<>();
    private String description;
    private Map<String, Room> exits; // Map direction to neighboring Room

    public Room(String description) {
        this.description = description;
        exits = new HashMap<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public boolean removeItemByName(String name) {
        return items.removeIf(i -> i.getName().equalsIgnoreCase(name));
    }

    public List<Item> getItems() {
        return items;
    }

    public String getItemString() {
        if (items.isEmpty()) {
            return "No items here.";
        }
        StringBuilder sb = new StringBuilder("Items: ");
        for (Item item : items) {
            sb.append(item.getName()).append(", ");
        }
        return sb.substring(0, sb.length() - 2);
    }
        public String getDescription () {
            return description;
        }

        public void setExit (String direction, Room neighbor){
            exits.put(direction, neighbor);
        }

        public Room getExit (String direction){
            return exits.get(direction);
        }

        public String getExitString () {
            StringBuilder sb = new StringBuilder();
            for (String direction : exits.keySet()) {
                sb.append(direction).append(" ");
            }
            return sb.toString().trim();
        }

        public String getLongDescription () {
            return "You are " + description + ".\nExits: " + getExitString() + "\n" + getItemString();
        }
}

