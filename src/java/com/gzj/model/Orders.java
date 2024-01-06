package com.gzj.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * @projectName: JavaWeb
 * @package: com.gzj.model
 * @className: Orders
 * @author: Gzj
 * @description: TODO
 * @date: 2023/12/21 23:51
 * @version: 1.0
 */
public class Orders implements Serializable {
    private int OrderID;
    private int CustomerID;
    private int DeliveryStaffID;
    private String OrderDate;
    private int Quantity;
    private float TotalPrice;
    private String delivery_image_url;
    private boolean OrderIsDeleat;

    public Orders(){

    }

    public Orders(int orderID, int customerID, int deliveryStaffID, String orderDate, int quantity, float totalPrice, String delivery_image_url, boolean orderIsDeleat) {
        OrderID = orderID;
        CustomerID = customerID;
        DeliveryStaffID = deliveryStaffID;
        OrderDate = orderDate;
        Quantity = quantity;
        TotalPrice = totalPrice;
        this.delivery_image_url = delivery_image_url;
        OrderIsDeleat = orderIsDeleat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return OrderID == orders.OrderID && CustomerID == orders.CustomerID && DeliveryStaffID == orders.DeliveryStaffID && OrderDate == orders.OrderDate && Quantity == orders.Quantity && Float.compare(orders.TotalPrice, TotalPrice) == 0 && delivery_image_url == orders.delivery_image_url && OrderIsDeleat == orders.OrderIsDeleat;
    }

    @Override
    public int hashCode() {
        return Objects.hash(OrderID, CustomerID, DeliveryStaffID, OrderDate, Quantity, TotalPrice, delivery_image_url, OrderIsDeleat);
    }

    @Override
    public String toString() {
        return "Orders{" +
                "OrderID=" + OrderID +
                ", CustomerID=" + CustomerID +
                ", DeliveryStaffID=" + DeliveryStaffID +
                ", OrderDate=" + OrderDate +
                ", Quantity=" + Quantity +
                ", TotalPrice=" + TotalPrice +
                ", delivery_image_url=" + delivery_image_url +
                ", OrderIsDeleat=" + OrderIsDeleat +
                '}';
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int i) {
        OrderID = OrderID;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public int getDeliveryStaffID() {
        return DeliveryStaffID;
    }

    public void setDeliveryStaffID(int deliveryStaffID) {
        DeliveryStaffID = deliveryStaffID;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String orderDate) {
        OrderDate = orderDate;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public float getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        TotalPrice = totalPrice;
    }

    public String getDelivery_image_url() {
        return delivery_image_url;
    }

    public void setDelivery_image_url(String delivery_image_url) {
        this.delivery_image_url = delivery_image_url;
    }

    public boolean isOrderIsDeleat() {
        return OrderIsDeleat;
    }

    public void setOrderIsDeleat(boolean orderIsDeleat) {
        OrderIsDeleat = orderIsDeleat;
    }
}
