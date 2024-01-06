package com.gzj.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * @projectName: JavaWeb
 * @package: com.gzj.model
 * @className: Customer
 * @author: Gzj
 * @description: TODO
 * @date: 2023/12/21 23:35
 * @version: 1.0
 */
public class Customer implements Serializable {
    private int CustomerID;
    private String CustomerIName;
    private String RealName;
    private String CustomerPassword;
    private String CustomerBirthday;
    private String CustomerSex;
    private String CustomerTelephone;
    private String CustomerEmail;
    private boolean CustomerStatus;
    private String profile_image_url;

    public Customer(){

    }

    public Customer(int customerID, String customerIName, String realName, String customerPassword, String customerBirthday, String customerSex, String customerTelephone, String customerEmail, boolean customerStatus, String profile_image_url) {
        CustomerID = customerID;
        CustomerIName = customerIName;
        RealName = realName;
        CustomerPassword = customerPassword;
        CustomerBirthday = customerBirthday;
        CustomerSex = customerSex;
        CustomerTelephone = customerTelephone;
        CustomerEmail = customerEmail;
        CustomerStatus = customerStatus;
        this.profile_image_url = profile_image_url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return CustomerID == customer.CustomerID && CustomerIName == customer.CustomerIName && RealName == customer.RealName && CustomerPassword == customer.CustomerPassword && CustomerBirthday == customer.CustomerBirthday && CustomerSex == customer.CustomerSex && CustomerTelephone == customer.CustomerTelephone && CustomerEmail == customer.CustomerEmail && CustomerStatus == customer.CustomerStatus && profile_image_url == customer.profile_image_url;
    }

    @Override
    public int hashCode() {
        return Objects.hash(CustomerID, CustomerIName, RealName, CustomerPassword, CustomerBirthday, CustomerSex, CustomerTelephone, CustomerEmail, CustomerStatus, profile_image_url);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "CustomerID=" + CustomerID +
                ", CustomerIName=" + CustomerIName +
                ", RealName=" + RealName +
                ", CustomerPassword=" + CustomerPassword +
                ", CustomerBirthday=" + CustomerBirthday +
                ", CustomerSex=" + CustomerSex +
                ", CustomerTelephone=" + CustomerTelephone +
                ", CustomerEmail=" + CustomerEmail +
                ", CustomerStatus=" + CustomerStatus +
                ", profile_image_url=" + profile_image_url +
                '}';
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
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
}
