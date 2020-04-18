package com.person.demo.controller;

import com.person.demo.pojo.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class helloController {

    //传参数
    @RequestMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("name", "thymeleaf");

        return "hello";
    }

    //引入样式与参数
    @RequestMapping("/style")
    public String style(Model model) {
        model.addAttribute("name", "StyleAnaJs");
        return "testStyle";
    }


    //表达式
    @RequestMapping("/test")
    public String test(Model model) {
        String style = " <p style='color:red' >红色文字 </P> ";
        Product product = new Product();
        product.setId(1);
        product.setName("product a");
        product.setPrice(125.00f);

        model.addAttribute("htmlContent", style);
        model.addAttribute("productContent", product);

        return "test";
    }

    //include 。
    @RequestMapping("/include")
    public String include(Model model) {
        String style = " <p style='color:red' >红色文字 </P> ";
        Product product = new Product();
        product.setId(1);
        product.setName("product a");
        product.setPrice(125.00f);

        model.addAttribute("htmlContent", style);
        model.addAttribute("productContent", product);

        return "testInclude";
    }

    //th:if="${}" 条件判断
    @RequestMapping("/if")
    public String doIf(Model model) {
        String style = " <p style='color:red' >红色文字 </P> ";
        Product product = new Product();
        product.setId(1);
        product.setName("product a");
        product.setPrice(125.00f);

        //增加一个boolean
        boolean flag = false;

        model.addAttribute("htmlContent", style);
        model.addAttribute("productContent", product);
        model.addAttribute("flag", flag);

        return "testBoolean";
    }


    //测试遍历
    @RequestMapping("/each")
    public String forEach(Model model) {
        List<Product> ps = new ArrayList<>();
        ps.add(new Product(1, "product1", 120.0f));
        ps.add(new Product(2, "product2", 120.0f));
        ps.add(new Product(3, "product3", 125.0f));
        ps.add(new Product(4, "product4", 128.0f));
        ps.add(new Product(5, "product5", 129.0f));
        ps.add(new Product(6, "product6", 120.9f));

        model.addAttribute("ps", ps);

        return "testEach";

    }

    //测试内置工具中的#dates
    @RequestMapping("/time")
    public String time(Model model) {
        Date date = new Date();


        model.addAttribute("now", date);

        return "testDates";

    }

}
