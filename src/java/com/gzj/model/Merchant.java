package com.gzj.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * @projectName: JavaWeb
 * @package: com.gzj.model
 * @className: Merchant
 * @author: Gzj
 * @description: TODO
 * @date: 2023/12/21 23:47
 * @version: 1.0
 */
public class Merchant implements Serializable {
    private String MerchantID;
    private String MerchantName;
    private String AirlineName;
    private String MerchantLocation;
    private String MerchantEmail;
    private boolean MerchantStatus;
    private String logo_image_url;
    private String MerchantTelephone;

    public Merchant(){

    }

    public Merchant(String merchantID, String merchantName, String airlineName, String merchantLocation, String merchantEmail, boolean merchantStatus, String logo_image_url, String merchantTelephone) {
        MerchantID = merchantID;
        MerchantName = merchantName;
        AirlineName = airlineName;
        MerchantLocation = merchantLocation;
        MerchantEmail = merchantEmail;
        MerchantStatus = merchantStatus;
        this.logo_image_url = logo_image_url;
        MerchantTelephone = merchantTelephone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Merchant merchant = (Merchant) o;
        return MerchantID == merchant.MerchantID && MerchantName == merchant.MerchantName && AirlineName == merchant.AirlineName && MerchantLocation == merchant.MerchantLocation && MerchantEmail == merchant.MerchantEmail && MerchantStatus == merchant.MerchantStatus && logo_image_url == merchant.logo_image_url && MerchantTelephone == merchant.MerchantTelephone;
    }

    @Override
    public int hashCode() {
        return Objects.hash(MerchantID, MerchantName, AirlineName, MerchantLocation, MerchantEmail, MerchantStatus, logo_image_url, MerchantTelephone);
    }

    @Override
    public String toString() {
        return "Merchant{" +
                "MerchantID=" + MerchantID +
                ", MerchantName=" + MerchantName +
                ", AirlineName=" + AirlineName +
                ", MerchantLocation=" + MerchantLocation +
                ", MerchantEmail=" + MerchantEmail +
                ", MerchantStatus=" + MerchantStatus +
                ", logo_image_url=" + logo_image_url +
                ", MerchantTelephone=" + MerchantTelephone +
                '}';
    }

    public String getMerchantID() {
        return MerchantID;
    }

    public void setMerchantID(String merchantID) {
        MerchantID = merchantID;
    }

    public String getMerchantName() {
        return MerchantName;
    }

    public void setMerchantName(String merchantName) {
        MerchantName = merchantName;
    }

    public String getAirlineName() {
        return AirlineName;
    }

    public void setAirlineName(String airlineName) {
        AirlineName = airlineName;
    }

    public String getMerchantLocation() {
        return MerchantLocation;
    }

    public void setMerchantLocation(String merchantLocation) {
        MerchantLocation = merchantLocation;
    }

    public String getMerchantEmail() {
        return MerchantEmail;
    }

    public void setMerchantEmail(String merchantEmail) {
        MerchantEmail = merchantEmail;
    }

    public boolean isMerchantStatus() {
        return MerchantStatus;
    }

    public void setMerchantStatus(boolean merchantStatus) {
        MerchantStatus = merchantStatus;
    }

    public String getLogo_image_url() {
        return logo_image_url;
    }

    public void setLogo_image_url(String logo_image_url) {
        this.logo_image_url = logo_image_url;
    }

    public String getMerchantTelephone() {
        return MerchantTelephone;
    }

    public void setMerchantTelephone(String merchantTelephone) {
        MerchantTelephone = merchantTelephone;
    }
}
