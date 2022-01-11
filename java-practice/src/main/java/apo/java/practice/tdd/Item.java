package apo.java.practice.tdd;

public class Item {
    private final double price;
    private final int quantity;

    public Item(int price, int quantity) {
	this.price = price;
	this.quantity = quantity;
    }

    public double getSubtotal(){
        return price * quantity;
    }
}
