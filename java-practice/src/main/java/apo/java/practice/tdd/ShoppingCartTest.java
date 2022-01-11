package apo.java.practice.tdd;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ShoppingCartTest {

    @Test
    public void emptyShoppingCart(){
	var shoppingCart = new ShoppingCart(List.of());
	Assert.assertEquals(0.0,shoppingCart.getTotal(),0.0);
    }
}
