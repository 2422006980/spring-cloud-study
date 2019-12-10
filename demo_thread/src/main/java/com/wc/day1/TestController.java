package com.wc.day1;

import com.wc.bean.User;
import com.wc.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author: wangcheng
 * @date: 2019/12/4
 * @description
 * @version: 1.0
 */
@RestController
public class TestController {

    @Autowired
    UserMapper userMapper;

    @Autowired
    DataSource dataSource;

    @RequestMapping(value = "/hello")
    public String hello() throws SQLException {

       // User user = userMapper.queryById(187);
        //System.out.println(dataSource.);
       Connection conn = dataSource.getConnection();
       PreparedStatement ps =conn.prepareStatement("select id, email as `name` from iot.user where id = ?");
       ps.setInt(1, 187);
       ResultSet rs = ps.executeQuery();
       String name = null;
       while(rs.next()){
           name = rs.getString("name");
       }

        return name;
    }

    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    public String hello1(){


        return "111";
    }
}
