package com.gzj.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * @projectName: JavaWeb
 * @package: com.gzj.model
 * @className: Comment
 * @author: Gzj
 * @description: TODO
 * @date: 2023/12/21 23:22
 * @version: 1.0
 */
public class Comment implements Serializable{
    private int CommentID;
    private int DeliveryStaffID;
    private int CustomerID;
    private String MerchantID;
    private String Content;
    private String CreateTime;
    private boolean CommentIsDeleted;

    public Comment() {

    }

    public Comment(int commentID, int deliveryStaffID, int customerID, String merchantID, String content, String createTime, boolean commentIsDeleted) {
        CommentID = commentID;
        DeliveryStaffID = deliveryStaffID;
        CustomerID = customerID;
        MerchantID = merchantID;
        Content = content;
        CreateTime = createTime;
        CommentIsDeleted = commentIsDeleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return CommentID == comment.CommentID && DeliveryStaffID == comment.DeliveryStaffID && CustomerID == comment.CustomerID && MerchantID == comment.MerchantID && Content == comment.Content && CreateTime == comment.CreateTime && CommentIsDeleted == comment.CommentIsDeleted;
    }

    @Override
    public int hashCode() {
        return Objects.hash(CommentID, DeliveryStaffID, CustomerID, MerchantID, Content, CreateTime, CommentIsDeleted);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "CommentID=" + CommentID +
                ", DeliveryStaffID=" + DeliveryStaffID +
                ", CustomerID=" + CustomerID +
                ", MerchantID=" + MerchantID +
                ", Content=" + Content +
                ", CreateTime=" + CreateTime +
                ", CommentIsDeleted=" + CommentIsDeleted +
                '}';
    }

    public int getCommentID() {
        return CommentID;
    }

    public void setCommentID(int commentID) {
        CommentID = commentID;
    }

    public int getDeliveryStaffID() {
        return DeliveryStaffID;
    }

    public void setDeliveryStaffID(int deliveryStaffID) {
        DeliveryStaffID = deliveryStaffID;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public String getMerchantID() {
        return MerchantID;
    }

    public void setMerchantID(String merchantID) {
        MerchantID = merchantID;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public boolean isCommentIsDeleted() {
        return CommentIsDeleted;
    }

    public void setCommentIsDeleted(boolean commentIsDeleted) {
        CommentIsDeleted = commentIsDeleted;
    }
}