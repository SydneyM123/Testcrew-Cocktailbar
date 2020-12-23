import Cocktailbar.Customer;
import Cocktailbar.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderTests
{
    @Test
    public void canSetCorrectOrderId()
    {
        var order = new Order(new Customer("TestCustomer"));
        assertEquals(Order.ORDER_ID - 1, order.getOrderId());
    }
}