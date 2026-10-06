package Ordering_program;

class OrderProgram {

    private String customerName;
    private String item;
    private double price;
    private int quantity;

    public OrderProgram(String customerName, String item, double price, int quantity) {

        this.customerName = customerName;
        this.item = item;
        this.price = price;
        this.quantity = quantity;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getItem() {
        return item;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void displayOrder() {

        System.out.println("Customer Name : " + customerName);
        System.out.println("Item Name     : " + item);
        System.out.println("Item Price    : " + price);
        System.out.println("Quantity      : " + quantity);
    }
}


class CoffeeOrder extends OrderProgram {

    private String coffeeName;
    private String coffeeType;
    private String coffeeSize;
    private String coffeeTemperature;
    private String coffeeSugarLevel;

    public CoffeeOrder(
            String customerName, String item, double price, int quantity, String coffeeName, String coffeeType,
            String coffeeSize, String coffeeTemperature, String coffeeSugarLevel
    ) {

        super(customerName, item, price, quantity);

        this.coffeeName = coffeeName;
        this.coffeeType = coffeeType;
        this.coffeeSize = coffeeSize;
        this.coffeeTemperature = coffeeTemperature;
        this.coffeeSugarLevel = coffeeSugarLevel;
    }

    public String getCoffeeName() {
        return coffeeName;
    }

    public String getCoffeeType() {
        return coffeeType;
    }

    public String getCoffeeSize() {
        return coffeeSize;
    }

    public String getCoffeeTemperature() {
        return coffeeTemperature;
    }

    public String getCoffeeSugarLevel() {
        return coffeeSugarLevel;
    }

    public double calculateTotal() {
        return getPrice() * getQuantity();
    }

    @Override
    public void displayOrder() {

        super.displayOrder();

        System.out.println("Category    : Coffee");
        System.out.println("Coffee Name : " + coffeeName);
        System.out.println("Coffee Type : " + coffeeType);
        System.out.println("Coffee Size : " + coffeeSize);
        System.out.println("Temperature : " + coffeeTemperature);
        System.out.println("Sugar Level : " + coffeeSugarLevel);
        System.out.println("Total Price : " + calculateTotal());
    }
}



class BreadOrder extends OrderProgram {

    private String breadType;
    private String flavor;
    private String size;

    public BreadOrder(
            String customerName, String item, double price, int quantity,
            String breadType, String flavor, String size
    ) {

        super(customerName, item, price, quantity);

        this.breadType = breadType;
        this.flavor = flavor;
        this.size = size;
    }

    public String getBreadType() {
        return breadType;
    }

    public String getFlavor() {
        return flavor;
    }

    public String getSize() {
        return size;
    }

    public double calculateTotal() {
        return getPrice() * getQuantity();
    }

    @Override
    public void displayOrder() {

        super.displayOrder();

        System.out.println("Category    : Bread");
        System.out.println("Bread Type  : " + breadType);
        System.out.println("Flavor      : " + flavor);
        System.out.println("Size        : " + size);
        System.out.println("Total Price : " + calculateTotal());
    }
}


public class Main {

    public static void main(String[] args) {

        CoffeeOrder coffee = new CoffeeOrder(
                "Cagas",
                "Coffee",
                120.00,
                2,
                "Caramel Latte",
                "Latte",
                "Large",
                "Iced",
                "Less Sugar"
        );

        BreadOrder bread = new BreadOrder(
                "Christian",
                "Bread",
                85.00,
                1,
                "Croissant",
                "Chocolate",
                "Medium"
        );


        System.out.println("===== COFFEE ORDER =====");
        coffee.displayOrder();

        System.out.println();

        System.out.println("===== BREAD ORDER =====");
        bread.displayOrder();
    }
}
