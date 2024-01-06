package com.gzj.dao;

import com.gzj.model.*;
import com.gzj.util.DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: JavaWeb
 * @package: com.gzj.dao
 * @className: OrderDao
 * @author: Gzj
 * @description: 任务表持久层
 * @date: 2023/12/22 23:06
 * @version: 1.0
 */
public class OrderDao {
    private ResultSet set =null;
    public List<Order_infor> findAll() {
        String sql = "SELECT * FROM ORDERS \n" +
                "LEFT OUTER JOIN Customer ON Orders.CustomerID = Customer.CustomerID \n" +
                "LEFT OUTER JOIN DeliveryStaff ON Orders.DeliveryStaffID = DeliveryStaff.DeliveryStaffID";
        // 获取操作对象
        PreparedStatement pst = DBUtil.getPst(sql);

        try {
            // 执行 sql
            ResultSet set = pst.executeQuery();
            // 保存结果
            ArrayList<Order_infor> list = new ArrayList<>();
            while (set.next()){
                int OrderID = set.getInt("OrderID");
                int CustomerID = set.getInt("CustomerID");
                int DeliveryStaffID = set.getInt("DeliveryStaffID");
                String OrderDate = set.getString("OrderDate");
                int Quantity = set.getInt("Quantity");
                float TotalPrice = set.getFloat("TotalPrice");
                String delivery_image_url = set.getString("delivery_image_url");
                boolean OrderIsDeleat = set.getBoolean("OrderIsDeleat");

                String CustomerIName = set.getString("CustomerIName");
                String RealName = set.getString("RealName");
                String CustomerPassword = set.getString("CustomerPassword");
                String CustomerBirthday = set.getString("CustomerBirthday");
                String CustomerSex = set.getString("CustomerSex");
                String CustomerTelephone = set.getString("CustomerTelephone");
                String CustomerEmail = set.getString("CustomerEmail");
                String profile_image_url = set.getString("profile_image_url");
                boolean CustomerStatus = set.getBoolean("CustomerStatus");

                String DeliveryStaffName = set.getString("DeliveryStaffName");
                String DeliveryStaffPassword = set.getString("DeliveryStaffPassword");
                String DeliveryStaffBirthday = set.getString("DeliveryStaffBirthday");
                String DeliveryStaffSex = set.getString("DeliveryStaffSex");
                String DeliveryStaffTelephone = set.getString("DeliveryStaffTelephone");
                int VehicleNumber = set.getInt("VehicleNumber");
                String CurrentLocation = set.getString("CurrentLocation");
                String DeliveryStaffEmail = set.getString("DeliveryStaffEmail");
                boolean DeliveryStaffStatus = set.getBoolean("DeliveryStaffStatus");

                // 封装数据
                Order_infor order_infor = new Order_infor(OrderID, CustomerID, DeliveryStaffID, OrderDate, Quantity, TotalPrice, delivery_image_url, OrderIsDeleat, CustomerIName, RealName, CustomerPassword, CustomerBirthday, CustomerSex, CustomerTelephone, CustomerEmail, CustomerStatus, profile_image_url, DeliveryStaffName, DeliveryStaffPassword, DeliveryStaffBirthday, DeliveryStaffSex, DeliveryStaffTelephone, VehicleNumber, CurrentLocation, DeliveryStaffStatus, DeliveryStaffEmail);

                // 顾客
                Customer customer = new Customer();
                customer.setCustomerID(CustomerID);
                customer.setCustomerIName(CustomerIName);
                customer.setCustomerTelephone(CustomerTelephone);
                customer.setCustomerEmail(CustomerEmail);
                customer.setProfile_image_url(profile_image_url);

                // 配送员
                DeliveryStaff deliveryStaff = new DeliveryStaff();
                deliveryStaff.setDeliveryStaffID(DeliveryStaffID);
                deliveryStaff.setDeliveryStaffName(DeliveryStaffName);
                deliveryStaff.setDeliveryStaffTelephone(DeliveryStaffTelephone);
                deliveryStaff.setDeliveryStaffEmail(DeliveryStaffEmail);
                deliveryStaff.setVehicleNumber(VehicleNumber);
                deliveryStaff.setCurrentLocation(CurrentLocation);

                // 把任务对象存到集合中
                list.add(order_infor);
            }
            // 返回结果
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(set);
        }

        return  null;
    }

    public Customer SaveCustomer(Customer dao) {
        String sql = "INSERT INTO Customer(CustomerID,CustomerIName,CustomerTelephone,CustomerEmail) VALUES\n" +
                "(?,?,?,?);\n" ;
        // 获取连接对象
        PreparedStatement pst = DBUtil.getPst(sql);
        try {
//            (11,'test_insert','19358036391','3096418799@qq.com');
//            (11,11,2,9.9,'aaa.img',FALSE);

            // 占位符赋值-customer
            pst.setInt(1, dao.getCustomerID());
            pst.setString(2, dao.getCustomerIName());
            pst.setString(3, dao.getCustomerTelephone());
            pst.setString(4, dao.getCustomerEmail());
            // 执行sql
            int i = pst.executeUpdate();
            if(i>0){    // 插入成功
                return dao;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(null);
        }

        return null;
    }

    public Orders SaveOrders(Orders dao) {
        String sql = "INSERT INTO Orders(OrderID,CustomerID,Quantity,TotalPrice,delivery_image_url,OrderIsDeleat,OrderDate) VALUES\n" +
                "(?,?,?,?,?,?,?);";
        // 获取连接对象
        PreparedStatement pst = DBUtil.getPst(sql);
        try {
//            (11,'test_insert','19358036391','3096418799@qq.com');
//            (11,11,2,9.9,'aaa.img',FALSE);

            // 占位符赋值-order
            pst.setInt(1, dao.getOrderID());
            pst.setInt(2, dao.getCustomerID());
            pst.setInt(3, dao.getQuantity());
            pst.setFloat(4, dao.getTotalPrice());
            pst.setString(5, dao.getDelivery_image_url());
            pst.setBoolean(6, dao.isOrderIsDeleat());
            pst.setString(7, dao.getOrderDate());
            // 执行sql
            int i = pst.executeUpdate();
            if(i>0){    // 插入成功
                return dao;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(null);
        }

        return null;
    }

    public Order_infor CustomerOrder(Order_infor order_infor){
        String sql = "INSERT INTO Customer(CustomerID,CustomerIName,CustomerTelephone,CustomerEmail) VALUES\n" +
                "(?,?,?,?);\n" ;
        String sql2 = "INSERT INTO Orders(OrderID,CustomerID,Quantity,TotalPrice,delivery_image_url,OrderIsDeleat,OrderDate) VALUES\n" +
                "(?,?,?,?,?,?,?);";
        // 获取连接对象
        PreparedStatement pst = DBUtil.getPst(sql);
        PreparedStatement pst2 = DBUtil.getPst(sql2);
        try {
//            (11,'test_insert','19358036391','3096418799@qq.com');
//            (11,11,2,9.9,'aaa.img',FALSE);
            // 占位符赋值-customer
            pst.setInt(1, order_infor.getCustomerID());
            pst.setString(2, order_infor.getCustomerIName());
            pst.setString(3, order_infor.getCustomerTelephone());
            pst.setString(4, order_infor.getCustomerEmail());

            // 占位符赋值-order
            pst2.setInt(1, order_infor.getOrderID());
            pst2.setInt(2, order_infor.getCustomerID());
            pst2.setInt(3, order_infor.getQuantity());
            pst2.setFloat(4, order_infor.getTotalPrice());
            pst2.setString(5, order_infor.getDelivery_image_url());
            pst2.setBoolean(6, order_infor.isOrderIsDeleat());
            pst2.setString(7, order_infor.getOrderDate());
            // 执行sql
            int i = pst.executeUpdate();
            int j = pst2.executeUpdate();

            if (i > 0 && j > 0) {    // 插入成功
                return order_infor;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {DBUtil.close(null);
        }
        return null;
    }
}
