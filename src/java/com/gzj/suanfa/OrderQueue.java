package com.gzj.suanfa;

import java.util.LinkedList;
import java.util.Queue;

public class OrderQueue {
    private Queue<Order> queue;

    public OrderQueue() {
        queue = new LinkedList<>();
    }

    public void addOrder(Order order) {
        queue.offer(order);
    }

    public Order getNextOrder() {
        return queue.poll();
    }

    public boolean hasOrder() {
        return !queue.isEmpty();
    }

    public static void main(String[] args) {
        OrderQueue orderQueue = new OrderQueue();

        // 添加订单
        orderQueue.addOrder(new Order("iPhone 13", 1));
        orderQueue.addOrder(new Order("iPad Pro", 2));
        orderQueue.addOrder(new Order("MacBook Pro", 3));

        // 处理订单
        while (orderQueue.hasOrder()) {
            Order order = orderQueue.getNextOrder();
            System.out.println("Processing order: " + order);
        }
    }
}

class Order {
    private String productName;
    private int quantity;

    public Order(String productName, int quantity) {
        this.productName = productName;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "productName='" + productName + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
