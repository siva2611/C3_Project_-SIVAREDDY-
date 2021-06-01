import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Restaurant {
    private String name;
    private String location;
    public LocalTime openingTime;
    public LocalTime closingTime;
    private List<Item> menu = new ArrayList<Item>();

    public Restaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public boolean isRestaurantOpen() {
        LocalTime localTime = getCurrentTime();
        if (localTime.compareTo(openingTime) > 0 && localTime.compareTo(closingTime) < 0) {
            return true;
        } else
            return false;
    }
    //DELETE ABOVE STATEMENT AND WRITE CODE HERE

    public LocalTime getCurrentTime() {
        return LocalTime.now();
    }

    public List<Item> getMenu() {
        return menu;
        //return null;
        //DELETE ABOVE RETURN STATEMENT AND WRITE CODE HERE
    }

    private Item findItemByName(String itemName) {
        for (Item item : menu) {
            if (Objects.equals(item.getName(), itemName))
                return item;
        }
        return null;
    }

    public void addToMenu(String name, int price) {
        Item newItem = new Item(name, price);
        menu.add(newItem);
    }

    public void removeFromMenu(String itemName) throws itemNotFoundException {

        Item itemToBeRemoved = findItemByName(itemName);
        if (itemToBeRemoved == null)
            throw new itemNotFoundException(itemName);

        menu.remove(itemToBeRemoved);
    }

    public void displayDetails() {
        System.out.println("Restaurant:" + name + "\n"
                + "Location:" + location + "\n"
                + "Opening time:" + openingTime + "\n"
                + "Closing time:" + closingTime + "\n"
                + "Menu:" + "\n" + getMenu());

    }

    public String getName() {
        return name;
    }
    public List addToOrder(){

        List<Item> order = new ArrayList<Item>();
        order.add(menu.get(Integer.parseInt(name)));
        return order;
    }
    public int calculateCost(List order){
        int totalCost=0;
        for(int i = 0; i<=order.size(); i++) {
            totalCost = totalCost + get(Item.getPrice());
        }
        return totalCost;
    }

    private int get(int price) {
        return price;
    }


}
