package com.gzj.servlet;

import com.alibaba.fastjson2.JSON;
import com.gzj.dao.OrderDao;
import com.gzj.model.Customer;
import com.gzj.model.Order_infor;
import com.gzj.model.Orders;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

/**
 * @projectName: JavaWeb
 * @package: com.gzj.servlet
 * @className: OrderServlet
 * @author: Gzj
 * @description: 任务操作的控制层
 * @date: 2023/12/19 23:08
 * @version: 1.0
 */
@WebServlet("/orders")
@MultipartConfig   // 配置提交文件的请求
public class OrderServlet extends HttpServlet {
    // 持久层
    private OrderDao dao = new OrderDao();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求类型
        String type = req.getParameter("type");
        if("Customer_order".equals(type)){        // 顾客点单
            try {
                Customer_order(req, resp);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else if ("DeliveryStaff_order".equals(type)){        // 配送订单
            DeliveryStaff_order(req, resp);
        } else if ("find_orders".equals(type)){        // 查看订单
            find_orders(req, resp);
        }
    }

    private void find_orders(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 调用dao层
        List<Order_infor> list = dao.findAll();
        // 返回结果
        resultJson(resp,200,list);
    }

    private void DeliveryStaff_order(HttpServletRequest req, HttpServletResponse resp) {
        boolean a = true;

        String b = Boolean.toString(a);
    }

    private void Customer_order(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        // 获取请求参数
        int OrderID = Integer.parseInt(req.getParameter("OrderID"));
        int CustomerID = Integer.parseInt(req.getParameter("CustomerID"));
        String OrderDate = req.getParameter("OrderDate");
        int Quantity = Integer.parseInt(req.getParameter("Quantity"));
        float TotalPrice = Float.parseFloat(req.getParameter("TotalPrice"));
        boolean OrderIsDeleat = Boolean.parseBoolean(req.getParameter("OrderIsDeleat"));
        String Delivery_image_url = req.getParameter("Delivery_image_url");
        String CustomerIName = req.getParameter("CustomerIName");
        String CustomerTelephone = req.getParameter("CustomerTelephone");
        String CustomerEmail = req.getParameter("CustomerEmail");

        // 封装数据-customer
        Customer customer = new Customer();
        customer.setCustomerID(CustomerID);
        customer.setCustomerIName(CustomerIName);
        customer.setCustomerTelephone(CustomerTelephone);
        customer.setCustomerEmail(CustomerEmail);

        // 封装数据-orders
        Orders orders = new Orders();
        orders.setOrderID(OrderID);
        orders.setCustomerID(CustomerID);
        orders.setOrderDate(OrderDate);
        orders.setQuantity(Quantity);
        orders.setTotalPrice(TotalPrice);
        orders.setOrderIsDeleat(OrderIsDeleat);
        orders.setDelivery_image_url(Delivery_image_url);

        // 封装数据-order_info
        Order_infor order_infor = new Order_infor();
        order_infor.setCustomerID(CustomerID);
        order_infor.setCustomerIName(CustomerIName);
        order_infor.setCustomerTelephone(CustomerTelephone);
        order_infor.setCustomerEmail(CustomerEmail);
        order_infor.setOrderID(OrderID);
        order_infor.setOrderDate(OrderDate);
        order_infor.setQuantity(Quantity);
        order_infor.setTotalPrice(TotalPrice);
        order_infor.setOrderIsDeleat(OrderIsDeleat);
        order_infor.setDelivery_image_url(Delivery_image_url);

        // 调用dao层
        customer =  dao.SaveCustomer(customer);
        orders = dao.SaveOrders(orders);
        order_infor = dao.CustomerOrder(order_infor);

        if(order_infor!=null){
            resultJson(resp, 200, order_infor);
        }else {
            resultJson(resp,404,"新增失败");
        }
    }

    /**
     * 返回响应的方法
     * @param resp
     * @param code
     * @param data
     */

    private void  resultJson(HttpServletResponse resp,int code,Object data) throws IOException {
        // 封装返回数据
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",code);
        map.put("data",data);
        // 转json
        String json = JSON.toJSONString(map);
        // 输出响应
        PrintWriter writer = resp.getWriter();
        writer.write(json);
        writer.close();
    }
}