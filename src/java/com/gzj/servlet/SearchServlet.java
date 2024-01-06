package com.gzj.servlet;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.gzj.dao.SearchDao;
import com.gzj.model.Dish;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    // 持久层对象
    private SearchDao dao = new SearchDao();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求类型
        String type = req.getParameter("type");
        // 判断 并调用对应的方法
        if("all".equals(type)){
            all(req,resp);
        } else if ("findById".equals(type)) {
            findById(req,resp);
        } else if ("findByName".equals(type)) {
            findByName(req,resp);
        }
    }

    /**
     * 根据Name 搜索
     * @param req
     * @param resp
     */
    private void findByName(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 获取请求参数
        String DishName = req.getParameter("DishName");
        // 调用 DAO 层方法，假设 findByName 返回 List<Dish>
        List<Dish> searchResults = dao.findByName(DishName);

        if(searchResults!=null){
            resultJson(resp,200,searchResults);
        }else {
            resultJson(resp,404,null);
        }
    }

    /**
     * 根据id 搜索
     * @param req
     * @param resp
     */
    private void findById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 获取请求参数
        String DishID = req.getParameter("DishID");
        // 调用 DAO 层方法，假设 findById 返回 List<Dish>
        List<Dish> searchResults = dao.findById(Integer.parseInt(DishID));

        if(searchResults!=null){
            resultJson(resp,200,searchResults);
        }else {
            resultJson(resp,404,null);
        }

    }

    /**
     * 查询全部任务
     * @param req
     * @param resp
     */
    private void all(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 调用dao层
        List<Dish> list = dao.findAll();
        // 返回结果
        resultJson(resp,200,list);
    }

    /**
     * 返回响应的方法
     * @param resp
     * @param code
     * @param data
     */
    private void resultJson(HttpServletResponse resp,int code,Object data) throws IOException {
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

