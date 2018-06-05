package com.cn.controller;

import com.cn.bean.WebResult;
import com.cn.method.Impl.SolutionImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ceshi
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/6/519:48
 */
@Controller
public class DemoController {
    @ResponseBody
    @RequestMapping(value = "demoTest")
    public WebResult demoTest(HttpServletRequest request, HttpServletResponse response) {
        String str = request.getParameter("dataMsg");
        WebResult webResult = new WebResult();
        try {
            SolutionImpl solution = new SolutionImpl();
            if (!solution.isLegalExpress(str)) {
                webResult.setStatus(false);
            } else {
                String expression = solution.toSuffix(str);
                double answer = solution.dealExpression(expression);
                System.out.println("answer=" + answer);
                webResult.setAnswer(String.valueOf(answer));
                webResult.setStatus(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            webResult.setStatus(false);
        }
        return webResult;
    }
}
