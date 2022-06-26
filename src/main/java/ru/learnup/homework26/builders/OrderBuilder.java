package ru.learnup.homework26.builders;

import ru.learnup.homework26.entity.Buyer;
import ru.learnup.homework26.entity.Order;
import ru.learnup.homework26.entity.Order_Details;

import java.util.List;

public class OrderBuilder {

    private long id;
    private int purchase_amount;
    private Buyer buyer;
    private List<Order_Details> order_details;

    public OrderBuilder withPurchaseAmount(int purchase_amount) {
        this.purchase_amount = purchase_amount;
        return this;
    }

    public OrderBuilder withOrderDetails(List<Order_Details> order_details) {
        this.order_details = order_details;
        return  this;
    }

    public OrderBuilder withBuyer(Buyer buyer) {
        this.buyer = buyer;
        return this;
    }


    public Order build() {
        Order order = new Order();
        order.setBuyer(buyer);
        order.setOrder_details(order_details);
        order.setPurchase_amount(purchase_amount);
        return order;
    }
}
