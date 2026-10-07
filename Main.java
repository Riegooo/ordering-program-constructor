package Ordering_program;

class Order {
    private String customerName;
    private String orderName;
    private double price;
    private int quantity;

    public Order(String customerName, String orderName, double price, int quantity) {
        this.customerName = customerName;
        this.orderName = orderName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getOrderName() {
        return orderName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double calculateTotal() {
        return getPrice() * getQuantity();
    }

    public void displayOrder() {
        System.out.println("Customer Name : " + customerName);
        System.out.println("Order Name    : " + orderName);
        System.out.println("Item Price    : " + price);
        System.out.println("Quantity      : " + quantity);
        System.out.println("Total Price : " + calculateTotal());
    }
}


class CoffeeOrder extends Order {
    private String type;
    private String size;
    private String temperature;
    private String sugarLevel;

    public CoffeeOrder(
            String customerName, String orderName, double price, int quantity, String Type,
            String Size, String Temperature, String SugarLevel
    ) {

        super(customerName, orderName, price, quantity);
        this.type = Type;
        this.size = Size;
        this.temperature = Temperature;
        this.sugarLevel = SugarLevel;
    }

    public String getType() {
        return type;
    }

    public String getSize() {
        return size;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getSugarLevel() {
        return sugarLevel;
    }

    @Override
    public void displayOrder() {

        super.displayOrder();
        System.out.println("Category    : Coffee");
        System.out.println("Coffee Type : " + type);
        System.out.println("Coffee Size : " + size);
        System.out.println("Temperature : " + temperature);
        System.out.println("Sugar Level : " + sugarLevel);
    }
}



class BreadOrder extends Order {

    private String type;
    private String flavor;
    private String size;

    public BreadOrder(
            String customerName, String orderName, double price, int quantity,
            String type, String flavor, String size
    ) {

        super(customerName, orderName, price, quantity);

        this.type = type;
        this.flavor = flavor;
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public String getFlavor() {
        return flavor;
    }

    public String getSize() {
        return size;
    }
    @Override
    public void displayOrder() {

        super.displayOrder();

        System.out.println("Category    : Bread");
        System.out.println("Bread Type  : " + type);
        System.out.println("Flavor      : " + flavor);
        System.out.println("Size        : " + size);
    }
}


public class Main {

    public static void main(String[] args) {

        CoffeeOrder coffee = new CoffeeOrder(
            "Cagas",
            "Caramel Latte",
            120.00,
            2,
            "Latte",
            "Large",
            "Iced",
            "Less Sugar"
        );

        BreadOrder bread = new BreadOrder(
            "Christian",
            "Croissant",
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