public class Item {
    private static int price;
    private String name;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }
    public static int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString(){
        return  name + ":"
                + price
                + "\n"
                ;
    }
}
