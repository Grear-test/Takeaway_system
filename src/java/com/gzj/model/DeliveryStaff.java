package com.gzj.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * @projectName: JavaWeb
 * @package: com.gzj.model
 * @className: DeliveryStaff
 * @author: Gzj
 * @description: TODO
 * @date: 2023/12/21 23:40
 * @version: 1.0
 */
public class DeliveryStaff implements Serializable {
    private int DeliveryStaffID;
    private String DeliveryStaffName;
    private String DeliveryStaffPassword;
    private String DeliveryStaffBirthday;
    private String DeliveryStaffSex;
    private String DeliveryStaffTelephone;
    private int VehicleNumber;
    private String CurrentLocation;
    private boolean DeliveryStaffStatus;
    private String DeliveryStaffEmail;

    public DeliveryStaff(){

    }

    public DeliveryStaff(int deliveryStaffID, String deliveryStaffName, String deliveryStaffPassword, String deliveryStaffBirthday, String deliveryStaffSex, String deliveryStaffTelephone, int vehicleNumber, String currentLocation, boolean deliveryStaffStatus, String deliveryStaffEmail) {
        DeliveryStaffID = deliveryStaffID;
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
        DeliveryStaff that = (DeliveryStaff) o;
        return DeliveryStaffID == that.DeliveryStaffID && DeliveryStaffName == that.DeliveryStaffName && DeliveryStaffPassword == that.DeliveryStaffPassword && DeliveryStaffBirthday == that.DeliveryStaffBirthday && DeliveryStaffSex == that.DeliveryStaffSex && DeliveryStaffTelephone == that.DeliveryStaffTelephone && VehicleNumber == that.VehicleNumber && CurrentLocation == that.CurrentLocation && DeliveryStaffStatus == that.DeliveryStaffStatus && DeliveryStaffEmail == that.DeliveryStaffEmail;
    }

    @Override
    public int hashCode() {
        return Objects.hash(DeliveryStaffID, DeliveryStaffName, DeliveryStaffPassword, DeliveryStaffBirthday, DeliveryStaffSex, DeliveryStaffTelephone, VehicleNumber, CurrentLocation, DeliveryStaffStatus, DeliveryStaffEmail);
    }

    @Override
    public String toString() {
        return "DeliveryStaff{" +
                "DeliveryStaffID=" + DeliveryStaffID +
                ", DeliveryStaffName=" + DeliveryStaffName +
                ", DeliveryStaffPassword=" + DeliveryStaffPassword +
                ", DeliveryStaffBirthday=" + DeliveryStaffBirthday +
                ", DeliveryStaffSex=" + DeliveryStaffSex +
                ", DeliveryStaffTelephone=" + DeliveryStaffTelephone +
                ", VehicleNumber=" + VehicleNumber +
                ", CurrentLocation=" + CurrentLocation +
                ", DeliveryStaffStatus=" + DeliveryStaffStatus +
                ", DeliveryStaffEmail=" + DeliveryStaffEmail +
                '}';
    }

    public int getDeliveryStaffID() {
        return DeliveryStaffID;
    }

    public void setDeliveryStaffID(int deliveryStaffID) {
        DeliveryStaffID = deliveryStaffID;
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

    public void setDeliveryStaffPassword(String deliveryStaffPassword) {DeliveryStaffPassword = deliveryStaffPassword;}

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
