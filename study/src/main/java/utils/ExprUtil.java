package utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 数学公式计算器，费率计算基础功能   不支持幂函数
 *
 * @author lzj10
 * @date 2021-05-24
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExprUtil {
    final static String PATTERN_STR = "(?<!\\d)-?\\d+(\\.\\d+)?|[+\\-*/()]";

    public static String getResult(String expr) {
        /*数字栈*/
        Stack<Double> number = new Stack<>();
        /*符号栈*/
        Stack<String> operator = new Stack<>();
        operator.push(null);// 在栈顶压人一个null，配合它的优先级，目的是减少下面程序的判断

        /* 将expr打散为运算数和运算符 */
        // 这个正则为匹配表达式中的数字或运算符
        Pattern pattern = Pattern.compile(PATTERN_STR);
        Matcher m = pattern.matcher(expr);
        while (m.find()) {
            String temp = m.group();
            if (temp.matches("[+\\-*/()]")) {
                //遇到符号
                if ("(".equals(temp)) {
                    //遇到左括号，直接入符号栈
                    operator.push(temp);
                } else if (")".equals(temp)) {
                    //遇到右括号，符号栈弹栈取栈顶符号symbol，数字栈弹栈取栈顶数字 a1，数字栈弹栈取栈顶数字 a2，计算 a2 symbol a1 ,将结果压入数字栈，重复引号步骤至取栈顶为左括号，将左括号弹出
                    String symbol = null;
                    while (!"(".equals(symbol = operator.pop())) {
                        double value = number.pop();
                        double passiveValue = number.pop();
                        number.push(doubleCal(passiveValue, value, symbol.charAt(0)));
                    }
                } else {
                    //遇到运算符，满足该运算符的优先级大于栈顶元素的优先级压栈；否则计算后压栈
                    while (getPriority(temp) <= getPriority(operator.peek())) {
                        double a1 = number.pop();
                        double a2 = number.pop();
                        String b = operator.pop();
                        number.push(doubleCal(a2, a1, b.charAt(0)));
                    }
                    operator.push(temp);
                }
            } else {
                //遇到数字，直接压入数字栈
                number.push(Double.valueOf(temp));
            }
        }

        while (operator.peek() != null) {
            //遍历结束后，符号栈数字栈依次弹栈计算，并将结果压入数字栈
            double a1 = number.pop();
            double a2 = number.pop();
            String b = operator.pop();
            number.push(doubleCal(a2, a1, b.charAt(0)));
        }
        return number.pop() + "";
    }

    private static double doubleCal(double v, double pv, char operator){
        switch (operator) {
            case '+':
                return v + pv;
            case '-':
                return v - pv;
            case '*':
                return v * pv;
            case '/':
                return v / pv;
            default:
                break;
        }
        return 0;
    }

    private static int getPriority(String temp){
        if (temp == null) {
            return 0;
        }
        switch (temp) {
            case "(":
                return 1;
            case "+":
            case "-":
                return 2;
            case "*":
            case "/":
                return 3;
            default:
                break;
        }
        return 3;
    }
}
