# COFFEE ORDERING PROGRAM USING CONSTRUCTOR, INHERITANCE, AND ENCAPSULATION

This program demonstrates basic Java OOP concepts by creating a simple **Coffee Ordering Program**.

The program uses a parent class called `OrderProgram` and two child classes:

* `CoffeeOrder`
* `BreadOrder`

The main concepts used are:

* Constructor
* Inheritance
* Encapsulation
* `super()`
* Method Overriding
* `@Override`

---

## PROGRAM STRUCTURE

The program has one parent class and two child classes:

```text
                    OrderProgram
                   /            \
                  /              \
         CoffeeOrder          BreadOrder
```

### `OrderProgram`

Contains the common information shared by different types of orders:

```text
customerName
item
price
quantity
```

### `CoffeeOrder`

Inherits the common information from `OrderProgram` and adds coffee-specific information:

```text
coffeeName
coffeeType
coffeeSize
coffeeTemperature
coffeeSugarLevel
```

### `BreadOrder`

Also inherits the common information from `OrderProgram` and adds bread-specific information:

```text
breadType
flavor
size
```

---

# CONSTRUCTOR

A **constructor** is used to initialize an object when the object is created.

The `OrderProgram` class has a constructor that receives the basic order information:

```java
public OrderProgram(String customerName, String item, double price, int quantity) {

    this.customerName = customerName;
    this.item = item;
    this.price = price;
    this.quantity = quantity;

}
```

For example:

```java
OrderProgram order =
    new OrderProgram("Christian", "Coffee", 120.00, 2);
```

The values are passed to the constructor:

```text
customerName = "Christian"
item         = "Coffee"
price        = 120.00
quantity     = 2
```

### Why use a constructor?

Instead of creating an empty object and assigning every value separately, the constructor allows us to initialize the object immediately when it is created.

---

# INHERITANCE

**Inheritance** allows a child class to acquire accessible properties and methods from a parent class.

In this program:

```java
class CoffeeOrder extends OrderProgram
```

and:

```java
class BreadOrder extends OrderProgram
```

Here:

```text
OrderProgram = Parent Class

CoffeeOrder  = Child Class
BreadOrder   = Child Class
```

The relationship is:

```text
                 OrderProgram
                /            \
               ↓              ↓
        CoffeeOrder       BreadOrder
```

Both child classes inherit the common information from `OrderProgram`.

The parent class contains:

```text
customerName
item
price
quantity
```

Instead of declaring these variables again in both child classes, `CoffeeOrder` and `BreadOrder` inherit them from `OrderProgram`.

---

## COFFEE ORDER

`CoffeeOrder` has its own coffee-specific variables:

```java
private String coffeeName;
private String coffeeType;
private String coffeeSize;
private String coffeeTemperature;
private String coffeeSugarLevel;
```

So the complete structure is:

```text
CoffeeOrder

Inherited from OrderProgram:
    customerName
    item
    price
    quantity

Own variables:
    coffeeName
    coffeeType
    coffeeSize
    coffeeTemperature
    coffeeSugarLevel
```

---

## BREAD ORDER

`BreadOrder` also inherits the common variables from `OrderProgram`.

It has its own variables:

```java
private String breadType;
private String flavor;
private String size;
```

So the structure is:

```text
BreadOrder

Inherited from OrderProgram:
    customerName
    item
    price
    quantity

Own variables:
    breadType
    flavor
    size
```

---

# ENCAPSULATION

**Encapsulation** means protecting the data inside a class and controlling how that data can be accessed.

The variables in the classes are declared as `private`.

For example:

```java
private String customerName;
private String item;
private double price;
private int quantity;
```

Because these variables are `private`, they cannot be directly accessed from outside the class.

For example:

```java
order.price;
```

is not allowed.

Instead, we use getter methods:

```java
public double getPrice() {
    return price;
}
```

Then we can access the value through:

```java
order.getPrice();
```

The same concept is used for the other variables.

### Simple idea

```text
private data
     ↓
protected inside the class
     ↓
accessed through methods
     ↓
getters / setters
```

Encapsulation helps prevent direct and uncontrolled access to an object's data.

---

# `SUPER()`

`super()` is used to call the **parent class constructor**.

For example, the `CoffeeOrder` constructor contains:

```java
public CoffeeOrder(
        String customerName,
        String item,
        double price,
        int quantity,
        String coffeeName,
        String coffeeType,
        String coffeeSize,
        String coffeeTemperature,
        String coffeeSugarLevel
) {

    super(customerName, item, price, quantity);

    this.coffeeName = coffeeName;
    this.coffeeType = coffeeType;
    this.coffeeSize = coffeeSize;
    this.coffeeTemperature = coffeeTemperature;
    this.coffeeSugarLevel = coffeeSugarLevel;
}
```

The:

```java
super(customerName, item, price, quantity);
```

calls the constructor of the parent class:

```java
public OrderProgram(
        String customerName,
        String item,
        double price,
        int quantity
) {

    this.customerName = customerName;
    this.item = item;
    this.price = price;
    this.quantity = quantity;
}
```

This allows the parent class to initialize the common order information.

The child class then initializes its own coffee-specific information.

### Simple idea

```text
CoffeeOrder constructor
        |
        ↓
super(...)
        |
        ↓
OrderProgram constructor
        |
        ↓
initializes common information
        |
        ├── customerName
        ├── item
        ├── price
        └── quantity
```

---

# METHOD OVERRIDING

**Method overriding** happens when a child class creates its own version of a method that already exists in the parent class.

The parent class contains:

```java
public void displayOrder() {

    System.out.println("Customer Name : " + customerName);
    System.out.println("Item Name     : " + item);
    System.out.println("Item Price    : " + price);
    System.out.println("Quantity      : " + quantity);

}
```

`CoffeeOrder` then overrides the method:

```java
@Override
public void displayOrder() {

    super.displayOrder();

    System.out.println("Category      : Coffee");
    System.out.println("Coffee Name   : " + coffeeName);
    System.out.println("Coffee Type   : " + coffeeType);
    System.out.println("Coffee Size   : " + coffeeSize);
    System.out.println("Temperature   : " + coffeeTemperature);
    System.out.println("Sugar Level   : " + coffeeSugarLevel);
    System.out.println("Total Price   : " + calculateTotal());
}
```

The child is basically saying:

> "I inherited `displayOrder()` from the parent, but I want my own version of it."

That's **method overriding**.

---

# `SUPER.DISPLAYORDER()`

Inside the overridden method, we use:

```java
super.displayOrder();
```

This calls the **parent class's version** of `displayOrder()`.

So:

```java
@Override
public void displayOrder() {

    super.displayOrder();

    // Additional CoffeeOrder information
}
```

means:

```text
Run the parent's displayOrder()
            ↓
Then run CoffeeOrder's additional display information
```

This prevents us from having to rewrite the parent's display logic again.

---

# `@OVERRIDE`

`@Override` tells Java that the method is intended to override a method from the parent class.

Example:

```java
@Override
public void displayOrder() {

    ...
}
```

It also helps Java detect mistakes.

For example, if the parent has:

```java
public void displayOrder()
```

but you accidentally write:

```java
@Override
public void displayOrders()
```

Java will give an error because `displayOrders()` does not match the parent's method.

---

# INHERITANCE VS OVERRIDING

These two concepts are related, but they are **not the same**.

## Inheritance

**Inheritance = the child class gets accessible properties and methods from the parent class.**

Example:

```java
class CoffeeOrder extends OrderProgram
```

`CoffeeOrder` inherits the common functionality from `OrderProgram`.

```text
OrderProgram
    |
    ↓
CoffeeOrder
```

The child can use methods such as:

```java
getCustomerName()
getItem()
getPrice()
getQuantity()
displayOrder()
```

---

## Overriding

**Overriding = the child class changes or redefines the behavior of an inherited method.**

Example:

```java
@Override
public void displayOrder() {

    super.displayOrder();

    System.out.println("Category : Coffee");
}
```

The child uses the same method name:

```text
displayOrder()
```

but provides its own implementation.

---

# SIMPLE WAY TO REMEMBER

```text
INHERITANCE

    ↓

Child gets accessible things from Parent.


OVERRIDING

    ↓

Child creates its own version of an inherited method.
```

Or simply:

```text
Inheritance = "I get what the parent has."

Overriding = "I will make my own version of this method."
```

---

# CALCULATING THE TOTAL PRICE

Both `CoffeeOrder` and `BreadOrder` have a `calculateTotal()` method.

The calculation uses:

```text
Price × Quantity
```

For example:

```text
Price = ₱120
Quantity = 2

Total = ₱120 × 2

Total = ₱240
```

In `CoffeeOrder`:

```java
public double calculateTotal() {
    return getPrice() * getQuantity();
}
```

`getPrice()` and `getQuantity()` are inherited functionality that allows the child class to access the parent's private data safely through methods.

---

# OOP STRUCTURE OF THE PROGRAM

```text
                         OrderProgram
                       /              \
                      /                \
                     ↓                  ↓
              CoffeeOrder          BreadOrder
                  |                     |
                  |                     |
          Coffee information      Bread information
                  |                     |
                  ↓                     ↓
           displayOrder()        displayOrder()
                  |                     |
                  ↓                     ↓
              overridden             overridden
```

## `OrderProgram`

Contains common order information:

```text
customerName
item
price
quantity
```

It also contains:

```text
getCustomerName()
getItem()
getPrice()
getQuantity()
displayOrder()
```

---

## `CoffeeOrder`

Inherits the common information from `OrderProgram` and adds:

```text
coffeeName
coffeeType
coffeeSize
coffeeTemperature
coffeeSugarLevel
```

It also has:

```text
calculateTotal()
displayOrder()
```

where `displayOrder()` overrides the parent method.

---

## `BreadOrder`

Inherits the common information from `OrderProgram` and adds:

```text
breadType
flavor
size
```

It also has:

```text
calculateTotal()
displayOrder()
```

where `displayOrder()` overrides the parent method.

---

# SUMMARY

| Concept               | Meaning                                                                               |
| --------------------- | ------------------------------------------------------------------------------------- |
| **Constructor**       | Initializes an object when it is created                                              |
| **Inheritance**       | Allows a child class to acquire accessible properties and methods from a parent class |
| **Encapsulation**     | Protects data by controlling how it can be accessed                                   |
| **`super()`**         | Calls the parent class constructor                                                    |
| **`super.method()`**  | Calls a method from the parent class                                                  |
| **Method Overriding** | Allows a child class to create its own version of an inherited method                 |
| **`@Override`**       | Tells Java that a method is intended to override a parent method                      |

---

# FINAL REMINDER

```text
Constructor
= initializes the object

Inheritance
= child gets accessible things from parent

Encapsulation
= protects/hides the data

super()
= calls the parent constructor

super.method()
= calls the parent's method

Overriding
= child creates its own version of the parent's method

@Override
= tells Java that the method is overriding a parent method
```

The main idea of this program is:

```text
                 OrderProgram
                 /           \
                /             \
               ↓               ↓
        CoffeeOrder        BreadOrder
               |               |
               ↓               ↓
      Coffee-specific     Bread-specific
         information         information
```

This allows the program to reuse common order information while giving `CoffeeOrder` and `BreadOrder` their own specialized data and behavior.
