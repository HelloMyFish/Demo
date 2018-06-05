package com.cn.method;

import com.cn.bean.WebResult;
import org.springframework.stereotype.Service;

/**
 * @author ceshi
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/6/517:37
 */
@Service
public interface Solution {
    //对后缀表达式 求值
    double dealExpression(String expression);
    // 将中缀表达式 转化成后缀表达式
    String toSuffix(String expression);
    //表达式校验
    boolean isLegalExpress(String express);
}
