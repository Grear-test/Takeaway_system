package com.gzj.model;

import java.util.Objects;

/**
 * @projectName: JavaWeb
 * @package: com.gzj.model
 * @className: Order_infor
 * @author: Gzj
 * @description: 订单信息实体类（包含顾客和配送员的信息）
 * @date: 2023/12/22 23:27
 * @version: 1.0
 */
public class Order_infor {
    private int OrderID;
    private int CustomerID;
    private int DeliveryStaffID;
    private String OrderDate;
    private int Quantity;
    private float TotalPrice;
    private String delivery_image_url;
    private boolean OrderIsDeleat;
    private String CustomerIName;
    private String RealName;
    private String CustomerPassword;
    private String CustomerBirthday;
    private String CustomerSex;
    private String CustomerTelephone;
    private String CustomerEmail;
    private boolean CustomerStatus;
    private String profile_image_url;
    private String DeliveryStaffName;
    private String DeliveryStaffPassword;
    private String DeliveryStaffBirthday;
    private String DeliveryStaffSex;
    private String DeliveryStaffTelephone;
    private int VehicleNumber;
    private String CurrentLocation;
    private boolean DeliveryStaffStatus;
    private String DeliveryStaffEmail;

    public Order_infor() {

    }

    public Order_infor(int orderID, int customerID, int deliveryStaffID, String orderDate, int quantity, float totalPrice, String delivery_image_url, boolean orderIsDeleat, String customerIName, String realName, String customerPassword, String customerBirthday, String customerSex, String customerTelephone, String customerEmail, boolean customerStatus, String profile_image_url, String deliveryStaffName, String deliveryStaffPassword, String deliveryStaffBirthday, String deliveryStaffSex, String deliveryStaffTelephone, int vehicleNumber, String currentLocation, boolean deliveryStaffStatus, String deliveryStaffEmail) {
        OrderID = orderID;
        CustomerID = customerID;
        DeliveryStaffID = deliveryStaffID;
        OrderDate = orderDate;
        Quantity = quantity;
        TotalPrice = totalPrice;
        this.delivery_image_url = delivery_image_url;
        OrderIsDeleat = orderIsDeleat;
        CustomerIName = customerIName;
        RealName = realName;
        CustomerPassword = customerPassword;
        CustomerBirthday = customerBirthday;
        CustomerSex = customerSex;
        CustomerTelephone = customerTelephone;
        CustomerEmail = customerEmail;
        CustomerStatus = customerStatus;
        this.profile_image_url = profile_image_url;
        DeliveryStaffName = deliveryStaffName;
        DeliveryStaffPassword = deliveryStaffPassword;
        DeliveryStaffBirthday = deliveryStaffBirthday;
        DeliveryStaffSex = deliveryStaffSex;
        DeliveryStaffTelephone = deliveryStaffTelephone;
        VehicleNumber = vehicleNumber;
        CurrentLocation = currentLocation;
        DeliveryStaffStatus = deliveryStaffStatus;
        DeliveryStaffEmail = deliveryStaffEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order_infor that = (Order_infor) o;
        return OrderID == that.OrderID && CustomerID == that.CustomerID && DeliveryStaffID == that.DeliveryStaffID && Quantity == that.Quantity && Float.compare(that.TotalPrice, TotalPrice) == 0 && OrderIsDeleat == that.OrderIsDeleat && CustomerStatus == that.CustomerStatus && VehicleNumber == that.VehicleNumber && DeliveryStaffStatus == that.DeliveryStaffStatus && Objects.equals(OrderDate, that.OrderDate) && Objects.equals(delivery_image_url, that.delivery_image_url) && Objects.equals(CustomerIName, that.CustomerIName) && Objects.equals(RealName, that.RealName) && Objects.equals(CustomerPassword, that.CustomerPassword) && Objects.equals(CustomerBirthday, that.CustomerBirthday) && Objects.equals(CustomerSex, that.CustomerSex) && Objects.equals(CustomerTelephone, that.CustomerTelephone) && Objects.equals(CustomerEmail, that.CustomerEmail) && Objects.equals(profile_image_url, that.profile_image_url) && Objects.equals(DeliveryStaffName, that.DeliveryStaffName) && Objects.equals(DeliveryStaffPassword, that.DeliveryStaffPassword) && Objects.equals(DeliveryStaffBirthday, that.DeliveryStaffBirthday) && Objects.equals(DeliveryStaffSex, that.DeliveryStaffSex) && Objects.equals(DeliveryStaffTelephone, that.DeliveryStaffTelephone) && Objects.equals(CurrentLocation, that.CurrentLocation) && Objects.equals(DeliveryStaffEmail, that.DeliveryStaffEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(OrderID, CustomerID, DeliveryStaffID, OrderDate, Quantity, TotalPrice, delivery_image_url, OrderIsDeleat, CustomerIName, RealName, CustomerPassword, CustomerBirthday, CustomerSex, CustomerTelephone, CustomerEmail, CustomerStatus, profile_image_url, DeliveryStaffName, DeliveryStaffPassword, DeliveryStaffBirthday, DeliveryStaffSex, DeliveryStaffTelephone, VehicleNumber, CurrentLocation, DeliveryStaffStatus, DeliveryStaffEmail);
    }

    @Override
    public String toString() {
        return "Order_infor{" +
                "OrderID=" + OrderID +
                ", CustomerID=" + CustomerID +
                ", DeliveryStaffID=" + DeliveryStaffID +
                ", OrderDate='" + OrderDate + '\'' +
                ", Quantity=" + Quantity +
                ", TotalPrice=" + TotalPrice +
                ", delivery_image_url='" + delivery_image_url + '\'' +
                ", OrderIsDeleat=" + OrderIsDeleat +
                ", CustomerIName='" + CustomerIName + '\'' +
                ", RealName='" + RealName + '\'' +
                ", CustomerPassword='" + CustomerPassword + '\'' +
                ", CustomerBirthday='" + CustomerBirthday + '\'' +
                ", CustomerSex='" + CustomerSex + '\'' +
                ", CustomerTelephone='" + CustomerTelephone + '\'' +
                ", CustomerEmail='" + CustomerEmail + '\'' +
                ", CustomerStatus=" + CustomerStatus +
                ", profile_image_url='" + profile_image_url + '\'' +
                ", DeliveryStaffName='" + DeliveryStaffName + '\'' +
                ", DeliveryStaffPassword='" + DeliveryStaffPassword + '\'' +
                ", DeliveryStaffBirthday='" + DeliveryStaffBirthday + '\'' +
                ", DeliveryStaffSex='" + DeliveryStaffSex + '\'' +
                ", DeliveryStaffTelephone='" + DeliveryStaffTelephone + '\'' +
                ", VehicleNumber=" + VehicleNumber +
                ", CurrentLocation='" + CurrentLocation + '\'' +
                ", DeliveryStaffStatus=" + DeliveryStaffStatus +
                ", DeliveryStaffEmail='" + DeliveryStaffEmail + '\'' +
                '}';
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int orderID) {
        OrderID = orderID;
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

    public String getCustomerIName() {
        return CustomerIName;
    }

    public void setCustomerIName(String customerIName) {
        CustomerIName = customerIName;
    }

    public String getRealName() {
        return RealName;
    }

    public void setRealName(String realName) {
        RealName = realName;
    }

    public String getCustomerPassword() {
        return CustomerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        CustomerPassword = customerPassword;
    }

    public String getCustomerBirthday() {
        return CustomerBirthday;
    }

    public void setCustomerBirthday(String customerBirthday) {
        CustomerBirthday = customerBirthday;
    }

    public String getCustomerSex() {
        return CustomerSex;
    }

    public void setCustomerSex(String customerSex) {
        CustomerSex = customerSex;
    }

    public String getCustomerTelephone() {
        return CustomerTelephone;
    }

    public void setCustomerTelephone(String customerTelephone) {
        CustomerTelephone = customerTelephone;
    }

    public String getCustomerEmail() {
        return CustomerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        CustomerEmail = customerEmail;
    }

    public boolean isCustomerStatus() {
        return CustomerStatus;
    }

    public void setCustomerStatus(boolean customerStatus) {
        CustomerStatus = customerStatus;
    }

    public String getProfile_image_url() {
        return profile_image_url;
    }

    public void setProfile_image_url(String profile_image_url) {
        this.profile_image_url = profile_image_url;
    }

    public String getDeliveryStaffName() {
        return DeliveryStaffName;
    }

    public void setDeliveryStaffName(String deliveryStaffName) {
        DeliveryStaffName = deliveryStaffName;
    }

    public String getDeliveryStaffPassword() {
        return DeliveryStaffPassword;
    }

    public void setDeliveryStaffPassword(String deliveryStaffPassword) {
        DeliveryStaffPassword = deliveryStaffPassword;
    }

    public String getDeliveryStaffBirthday() {
        return DeliveryStaffBirthday;
    }

    public void setDeliveryStaffBirthday(String deliveryStaffBirthday) {
        DeliveryStaffBirthday = deliveryStaffBirthday;
    }

    public String getDeliveryStaffSex() {
        return DeliveryStaffSex;
    }

    public void setDeliveryStaffSex(String deliveryStaffSex) {
        DeliveryStaffSex = deliveryStaffSex;
    }

    public String getDeliveryStaffTelephone() {
        return DeliveryStaffTelephone;
    }

    public void setDeliveryStaffTelephone(String deliveryStaffTelephone) {
        DeliveryStaffTelephone = deliveryStaffTelephone;
    }

    public int getVehicleNumber() {
        return VehicleNumber;
    }

    public void setVehicleNumber(int vehicleNumber) {
        VehicleNumber = vehicleNumber;
    }

    public String getCurrentLocation() {
        return CurrentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        CurrentLocation = currentLocation;
    }

    public boolean isDeliveryStaffStatus() {
        return DeliveryStaffStatus;
    }

    public void setDeliveryStaffStatus(boolean deliveryStaffStatus) {
        DeliveryStaffStatus = deliveryStaffStatus;
    }

    public String getDeliveryStaffEmail() {
        return DeliveryStaffEmail;
    }

    public void setDeliveryStaffEmail(String deliveryStaffEmail) {
        DeliveryStaffEmail = deliveryStaffEmail;
    }
}
