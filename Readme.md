# ORDERING PROGRAM USING CONSTRUCTOR WITH INHERITANCE AND ENCAPSULATION

This program demonstrates basic Java OOP concepts using an Ordering Program.

The main concepts used are:

* Constructor
* Inheritance
* Encapsulation
* `super()`
* Method Overriding

---

## CONSTRUCTOR

A **constructor** is used to initialize an object when the object is created.

The constructor receives values and assigns them to the object's fields.

```java
public Order(String customerName, String item, double price) {
    this.customerName = customerName;
    this.item = item;
    this.price = price;
}
```

For example:

```java
Order order = new Order("Christian", "Burger", 120.00);
```

The values are passed to the constructor:

```text
customerName = "Christian"
item         = "Burger"
price        = 120.00
```

### Why use a constructor?

Instead of creating an empty object and assigning each value separately, the constructor allows us to initialize the object immediately.

---

## INHERITANCE

**Inheritance** allows one class to acquire the accessible properties (fields) and behaviors (methods) of another class.

```java
class FoodOrder extends Order
```

Here:

```text
Order      = Parent Class
FoodOrder  = Child Class
```

`FoodOrder` inherits the accessible methods from `Order`, such as:

```java
getCustomerName()
getItem()
getPrice()
displayOrder()
```

The relationship is:

```text
Order
  |
  ↓
FoodOrder
```

The child class can also have its own fields and methods in addition to the inherited ones.

For example:

```java
class FoodOrder extends Order {

    private int quantity;
}
```

`quantity` belongs specifically to `FoodOrder`, while `customerName`, `item`, and `price` come from `Order`.

---

## ENCAPSULATION

**Encapsulation** means hiding/protecting the data and controlling how it can be accessed.

The fields in the class are declared as `private`:

```java
private String customerName;
private String item;
private double price;
```

Because they are `private`, they cannot be directly accessed from outside the class.

For example:

```java
order.price;
```

is not allowed.

Instead, we use methods such as getters:

```java
public double getPrice() {
    return price;
}
```

Then we can access the price through:

```java
order.getPrice();
```

### Simple idea:

```text
private data
     ↓
protected/controlled inside the class
     ↓
accessed through methods
```

Encapsulation helps prevent direct and uncontrolled modification of the object's data.

---

## `SUPER()`

`super()` is used to call the **parent class constructor**.

Example:

```java
public FoodOrder(String customerName, String item, double price, int quantity) {
    super(customerName, item, price);
    this.quantity = quantity;
}
```

The:

```java
super(customerName, item, price);
```

calls the constructor of the parent class:

```java
public Order(String customerName, String item, double price) {
    this.customerName = customerName;
    this.item = item;
    this.price = price;
}
```

So instead of initializing the parent class fields again inside `FoodOrder`, we let the parent constructor handle them.

### Simple idea:

```text
FoodOrder constructor
        |
        ↓
super(...)
        |
        ↓
Order constructor
        |
        ↓
initializes customerName
initializes item
initializes price
```

---

## METHOD OVERRIDING

**Method overriding** happens when the child class creates its own version of a method that already exists in the parent class.

The parent class has:

```java
public void displayOrder() {
    System.out.println("Customer: " + customerName);
    System.out.println("Item: " + item);
    System.out.println("Price: ₱" + price);
}
```

The child class also has:

```java
@Override
public void displayOrder() {
    super.displayOrder();
    System.out.println("Quantity: " + quantity);
}
```

The child is basically saying:

> "I inherited `displayOrder()` from the parent, but I want my own version of it."

That's **method overriding**.

The parent version:

```java
displayOrder()
```

and the child version:

```java
@Override
displayOrder()
```

have the same method name and parameters, but the child changes what the method does.

---

## `@OVERRIDE`

`@Override` tells Java that the method is intended to override a method from the parent class.

Example:

```java
@Override
public void displayOrder() {
    ...
}
```

It also helps detect mistakes.

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

## INHERITANCE VS OVERRIDING

These two concepts are related but they are **not the same**.

### Inheritance

**Inheritance = ginagamit/naminana mo yung accessible methods and properties ng parent class.**

Example:

```java
class FoodOrder extends Order
```

`FoodOrder` can use inherited methods such as:

```java
getCustomerName()
getItem()
getPrice()
displayOrder()
```

---

### Overriding

**Overriding = binabago o nire-redefine mo ang behavior ng inherited method sa child class.**

Example:

```java
@Override
public void displayOrder() {
    super.displayOrder();
    System.out.println("Quantity: " + quantity);
}
```

The child is using the same method name:

```text
displayOrder()
```

but gives it additional/different behavior.

---

## SIMPLE WAY TO REMEMBER

```text
INHERITANCE
    ↓
Child gets accessible properties and methods from Parent.

OVERRIDING
    ↓
Child changes/redefines the behavior of an inherited method.
```

Or simply:

```text
Inheritance = "I get what the parent has."

Overriding = "I will make my own version of this method."
```

---

## OOP STRUCTURE OF THE PROGRAM

```text
                    Order
                     |
                     | inheritance
                     ↓
                 FoodOrder
                     |
                     ↓
              displayOrder()
                 overridden
```

### Order

Contains the common information:

```text
customerName
item
price
```

### FoodOrder

Inherits the common information from `Order` and adds:

```text
quantity
```

It also overrides:

```text
displayOrder()
```

so it can display the additional `quantity` information.

---

## SUMMARY

| Concept               | Meaning                                                                           |
| --------------------- | --------------------------------------------------------------------------------- |
| **Constructor**       | Initializes an object when it is created                                          |
| **Inheritance**       | Allows a child class to acquire accessible fields and methods from a parent class |
| **Encapsulation**     | Hides/protects data and controls how it is accessed                               |
| **`super()`**         | Calls the parent class constructor                                                |
| **Method Overriding** | Allows a child class to create its own version of an inherited method             |
| **`@Override`**       | Tells Java that a method is intended to override a parent method                  |

### Final Reminder

```text
Constructor
= initializes the object

Inheritance
= child gets accessible things from parent

Encapsulation
= protects/hides the data

super()
= calls the parent constructor

Overriding
= child creates its own version of the parent's method
```
