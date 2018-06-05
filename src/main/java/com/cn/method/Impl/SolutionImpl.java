package com.cn.method.Impl;

import com.cn.method.Solution;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ceshi
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/6/517:39
 */
public class SolutionImpl implements Solution {
    //设置优先级
    private static Map<String, Integer> map;
    private static String fuhao = "+-*/()";
    private static final String split = ",";

    static {
        map = new HashMap<String, Integer>();
        map.put("+", 1);
        map.put("-", 1);
        map.put("*", 2);
        map.put("/", 2);
        map.put("(", 0);
        map.put(")", 0);
    }

    @Override
    public double dealExpression(String expression) {
        String[] str = expression.split(split);
        Stack<Double> stack = new Stack();
        for (int i = 0; i < str.length; i++) {
            if (fuhao.contains(str[i])) {
                double d1 = stack.pop();
                double d2 = stack.pop();
                switch (str[i]) {
                    case "+":
                        stack.push(d2 + d1);
                        break;
                    case "-":
                        stack.push(d2 - d1);
                        break;
                    case "*":
                        stack.push(d2 * d1);
                        break;
                    case "/":
                        stack.push(d2 / d1);
                        break;
                    default:
                        break;
                }
            } else {
                stack.push(Double.parseDouble(str[i]));
            }
        }
        return stack.pop();
    }

    @Override
    public String toSuffix(String str) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        Queue<String> queue = new LinkedList<>();

        if (str.charAt(str.length() - 1) == '=') {
            str = str.substring(0, str.length() - 1);
        }
        // 将中缀表达式变为后缀表达式
        for (int i = 0; i < str.length(); i++) {
            String s = String.valueOf(str.charAt(i));
            if (fuhao.contains(s)) {
                if (sb.length() != 0) {
                    //先对数字栈进行操作
                    queue.add(sb.toString());
                    sb.delete(0, sb.length());
                }
                //对符号栈处理
                int t = map.get("(");
                while (!stack.empty() && map.get(stack.peek()) >= map.get(s) && map.get(s) != 0) {
                    queue.add(stack.pop());
                }
                // ) 符号 匹配左符号
                if (s.equals(")")) {
                    while (!stack.peek().equals("(")) {
                        queue.add(stack.pop());
                    }
                    //将( 括号出栈
                    stack.pop();
                } else {
                    stack.push(s);
                }

            } else {
                sb.append(s);
            }
        }
        //将最后一个值加入
        if (sb.length() != 0) {
            queue.add(sb.toString());
        }
        //将符号栈中的元素 输出
        while (!stack.empty()) {
            queue.add(stack.pop());
        }
        //输出后缀表达式
        String expression = queue.stream().collect(Collectors.joining(split));
        return expression;
    }

    @Override
    public boolean isLegalExpress(String express) {
        String test = "+-*/";
        if (express.length() <= 3) {
            return false;
        } else {
            for (int i = 1; i < express.length(); i++) {
                char c1 = express.charAt(i - 1);
                char c2 = express.charAt(i);
                if (test.contains(String.valueOf(c1)) && test.contains(String.valueOf(c2))) {
                    return false;
                }
            }
        }
        return true;
    }
}
