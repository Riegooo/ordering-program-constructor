package Ordering_program;

class OrderProgram {

    private String customername;
    private String item;
    private double price;

    public OrderProgram(String customername, String item, double price) {
        this.customername = customername;
        this.item = item;
        this.price = price;
    }

    public String getCutomerName() {
        return customername;
    }

    public String getItem() {
        return item;
    }    

    public Double getPrice() {
        return price;
    }

    public void displayOrder() {

        System.out.print("Customer name : " + customername);
        System.out.print("\nItem Name : " + item);
        System.out.print("\nItem Price : " + price);

    }
}

class FoodOrder extends OrderProgram {
    
    private int quantity;

    public FoodOrder(String customerName, String item, double price, int quantity) {
        super(customerName, item, price); 
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public double calculateTotal() {
        return getPrice() * quantity;
    }

    @Override
    public void displayOrder() {
        super.displayOrder();

        System.out.println("\nCategory : Food");

        System.out.println("\nItem Quantity : " + quantity);
        System.out.println("Total Price : " + calculateTotal());
    }

}

class DrinkOrder extends OrderProgram {
    
    private String size;

    public DrinkOrder(String customerName, String item, double price, String size) {
        super(customerName, item, price);
        this.size = size;
    }

    @Override
    public void displayOrder() {
        super.displayOrder();

        System.out.println("\nSize : " + size);
        System.out.println("Category : Drink");
    }

}

public class Main {
    public static void main(String[] args) {

        FoodOrder food_order = new FoodOrder("Riego", "Burger", 120.00, 2);
        DrinkOrder drink_order = new DrinkOrder("Riego", "Iced Coffee", 190.00, "Lagre");
        food_order.displayOrder();
        System.out.println();
        drink_order.displayOrder();

    }
}
