package com.gzj.dao;

import com.gzj.model.Dish;
import com.gzj.util.DBUtil;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class SearchDao {
    private ResultSet set = null;
    public List<Dish> findAll() {
        String sql = "select * from Dish";
        // 获取操作对象
        PreparedStatement pst = DBUtil.getPst(sql);

        try {
            // 执行 sql
            ResultSet set = pst.executeQuery();
            // 保存结果
            ArrayList<Dish> list = new ArrayList<>();
            while (set.next()){
                int DishID = set.getInt("DishID");
                String OrderID = set.getString("OrderID");
                String DishName = set.getString("DishName");
                String DishDescription = set.getString("DishDescription");
                float Price = set.getFloat("Price");
                boolean DishStatus = set.getBoolean("DishStatus");
                String image_url = set.getString("image_url");

                // 封装数据
                Dish search = new Dish(DishID, OrderID, DishName, DishDescription, Price, DishStatus, image_url);

                list.add(search);
//                System.out.println(list);

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

    /**
     * 根据id查询菜单
     *
     * @param
     * @return
     */
    public  List<Dish> findById(int id) {
        String sql = "select * from Dish where dishID=?";
        // 用于保存查询结果的列表
        List<Dish> searchResults = new ArrayList<>();

        try {
            // 获取操作对象
            PreparedStatement pst = DBUtil.getPst(sql);
            // 给占位符赋值
            pst.setInt(1,id);
            // 执行 sql
            ResultSet set = pst.executeQuery();
            // 保存结果
            while (set.next()){
                int DishID = set.getInt("DishID");
                String OrderID = set.getString("OrderID");
                String DishName = set.getString("DishName");
                String DishDescription = set.getString("DishDescription");
                float Price = set.getFloat("Price");
                boolean DishStatus = set.getBoolean("DishStatus");
                String image_url = set.getString("image_url");

                // 封装数据
                Dish search = new Dish(DishID, OrderID, DishName, DishDescription, Price, DishStatus, image_url);
                searchResults.add(search);
            }
            DBUtil.close(set);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(set);
        }
        return  searchResults;
    }

    /**
     * 根据DishName查询菜单
     *
     * @param
     * @return
     */
    public List<Dish> findByName(String name) {
        String sql = "select * from Dish\n"+
                "where DishName=?";
        // 用于保存查询结果的列表
        List<Dish> searchResults = new ArrayList<>();

        try {
            // 获取操作对象
            PreparedStatement pst = DBUtil.getPst(sql);
            // 给占位符赋值
            pst.setString(1, name);
            // 执行 sql
            ResultSet set = pst.executeQuery();
            // 保存结果
            while (set.next()) {
                int DishID = set.getInt("DishID");
                String OrderID = set.getString("OrderID");
                String DishName = set.getString("DishName");
                String DishDescription = set.getString("DishDescription");
                float Price = set.getFloat("Price");
                boolean DishStatus = set.getBoolean("DishStatus");
                String image_url = set.getString("image_url");

                // 封装数据
                Dish search = new Dish(DishID, OrderID, DishName, DishDescription, Price, DishStatus, image_url);
                searchResults.add(search);
            }
            DBUtil.close(set);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(set);
        }
        return searchResults;
    }
}


