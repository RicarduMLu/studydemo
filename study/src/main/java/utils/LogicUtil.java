package utils;


import constants.Constants;
import entity.ConditionalCalculation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * 逻辑计算公式
 *
 * @author lzj10
 * @date 2021-10-22
 */
public class LogicUtil {
    private static final String START = Constants.FACTOR_START;
    private static final BigDecimal ZERO = Constants.ZERO_BIG_DECIMAL;

    /**
     * 无限递归计算逻辑公式
     *
     * @param formula 递归公式   以  LogicUtil:  开始
     * @return 计算结果
     */
    public static BigDecimal getResult(String formula) {

        if (formula.startsWith(LogicUtil.class.getSimpleName())) {
            return LogicUtil.loopCalculation(JsonUtil.fromJSON(formula.replace(LogicUtil.class.getSimpleName() + Constants.COLON, ""), ConditionalCalculation.class));
        } else if (formula.startsWith("{") && formula.endsWith("}") && formula.contains("\"co\"")) {
            return LogicUtil.loopCalculation(JsonUtil.fromJSON(formula, ConditionalCalculation.class));
        } else {
            if (formula.contains(START)) {
                return ZERO;
            }
            return new BigDecimal(ExprUtil.getResult(formula));
        }
    }

    /**
     * 无限递归计算逻辑公式
     *
     * @param conditionalCalculation 递归公式
     * @return 计算结果
     */
    public static BigDecimal loopCalculation(final ConditionalCalculation conditionalCalculation) {
        if (conditionalCalculation == null) {
            return Constants.ZERO_BIG_DECIMAL;
        }
        if (LogicUtil.parse2(conditionalCalculation.getCondition())) {
            if (conditionalCalculation.getCalculationCondition() != null) {
                return loopCalculation(conditionalCalculation.getCalculationCondition());
            }
            if (StringUtils.isNotEmpty(conditionalCalculation.getCalculation())) {
                return new BigDecimal(ExprUtil.getResult(conditionalCalculation.getCalculation()));
            } else {
                return Constants.ZERO_BIG_DECIMAL;
            }
        } else {
            if (conditionalCalculation.getElseCalculationCondition() != null) {
                return loopCalculation(conditionalCalculation.getElseCalculationCondition());
            }
            if (StringUtils.isNotEmpty(conditionalCalculation.getElseCalculation())) {
                return new BigDecimal(ExprUtil.getResult(conditionalCalculation.getElseCalculation()));
            } else {
                return Constants.ZERO_BIG_DECIMAL;
            }
        }
    }

    /**
     * @param expression 公式
     * @return 结果
     * @author Carol
     * 计算表达式
     * 利用一个操作数栈和一个操作栈来进行计算
     * 出栈情况：当前字符串为操作并且优先级小于栈顶操作元素或者遇到“)”，将操作栈中栈顶元素出栈，操作数栈中出栈俩元素
     * 入栈情况：“(”直接入栈，或者当前操作优先级大于栈顶元素则直接入栈，操作数直接入栈
     */
    public static boolean parse2(String expression) {
        Deque<String> operands = new LinkedList<>();//操作数栈
        Deque<String> operate = new LinkedList<>();//操作栈
        StringBuilder sb = new StringBuilder();
        try {
            byte[] bytes = expression.getBytes("GBK");
            for (int i = 0; i < bytes.length; i++) {
                //汉字
                if (bytes[i] < 0) {
                    if (i != bytes.length - 1) {
                        sb.append(new String(new byte[]{bytes[i], bytes[i + 1]}, "GBK"));
                        i++;
                    }
                    continue;
                }
                String thisOp = new String(new byte[]{bytes[i]});
                //直接入栈
                if ("(".equals(thisOp)) {
                    pushOperandIntoStack(operands, sb);
                    operate.addFirst(thisOp);
                    continue;
                }
                //到“(”之前的全部出栈
                if (")".equals(thisOp)) {
                    pushOperandIntoStack(operands, sb);
                    String topOp = operate.pollFirst();
                    //直到(为栈顶位置
                    while (!"(".equals(topOp)) {
                        calculate(operands, topOp);
                        if (operate.size() > 0) {
                            topOp = operate.pollFirst();
                        } else {
                            //括号没匹配上，逻辑表达式出错
                            return false;
                        }
                    }
                    continue;
                }
                if (OperatorEnum.isOperator(thisOp)) {
                    //当前是否为操作符
                    //是，1.查看之前是否有字符未入栈，先入栈字符
                    pushOperandIntoStack(operands, sb);
                    //2.查看下一个是否为操作，并且非括号，是合并当前一起入操作栈
                    if (i + 1 >= bytes.length) {
                        //操作符不可为最后一个 直接返回False
                        return false;
                    }
                    String nextOp = new String(new byte[]{bytes[i + 1]});
                    //下个与当前一起组成一个操作
                    if (!"(".equals(nextOp) && !")".equals(nextOp) && OperatorEnum.isOperator(nextOp)) {
                        if (OperatorEnum.isOperator(thisOp + nextOp)) {
                            thisOp += nextOp;
                            i++;
                        } else {
                            System.out.println("非正常操作符" + thisOp + "下一个" + nextOp);
                            pushOperandIntoStack(operands, sb);
                            operate.addFirst(thisOp);
                            continue;
                        }
                    }
                    //判断当前操作与栈顶操作优先级
                    if (operate.size() > 0) {
                        String topOp = operate.getFirst();
                        while (!"(".equals(topOp) && OperatorEnum.getEnumByName(topOp).getPriority() < OperatorEnum.getEnumByName(thisOp).getPriority()) {
                            //优先级高，出栈进行计算
                            topOp = operate.pollFirst();
                            calculate(operands, topOp);
                            if (operate.size() > 0) {
                                topOp = operate.getFirst();
                            } else {
                                break;
                            }

                        }
                    }
                    operate.addFirst(thisOp);
                } else {
                    sb.append(thisOp);
                }
            }
        } catch (Exception e) {
        }
        if (sb.length() > 0) {
            operands.addFirst(sb.toString());
        }
        while (operate.size() > 0) {
            String topOp = operate.pollFirst();
            calculate(operands, topOp);
        }
        if (operands.size() > 0) {
            String str = operands.pollFirst();
            return StringUtils.isNotBlank(str) && Boolean.parseBoolean(str);
        }
        return false;
    }

    /**
     * 入栈
     *
     * @param operands 栈
     * @param sb       字符
     */
    private static void pushOperandIntoStack(Deque<String> operands, StringBuilder sb) {
        if (sb.length() > 0) {
            operands.addFirst(sb.toString());
            sb.setLength(0);
        }
    }

    /**
     * 计算
     *
     * @param operands 操作栈
     * @param topOp    栈顶
     */
    private static void calculate(Deque<String> operands, String topOp) {
        //后入先出
        if (operands.size() == 1) {
            if (OperatorEnum.NOT.getCode().equals(topOp)) {
                //防止下面空指针异常
                operands.addFirst(topOp);
            }
        }
        String operand2 = operands.pollFirst().trim();
        String operand1 = operands.pollFirst().trim();
        //判断两个操作数类型，不一致不可比较直接返回false
        OperandTypeEnum type1 = judgeType(operand1);
        OperandTypeEnum type2 = judgeType(operand2);
        if (type1 == type2) {
            switch (type1) {
                case NUM:
                    operands.addFirst(numCalculate(Long.parseLong(operand1), Long.parseLong(operand2), OperatorEnum.getEnumByName(topOp)) + "");
                    break;
                case DATE:
                    operands.addFirst(dateCalculate(operand1, operand2, OperatorEnum.getEnumByName(topOp)) + "");
                    break;
                case STR:
                    operands.addFirst(strCalculate(operand1, operand2, OperatorEnum.getEnumByName(topOp)) + "");
                    break;
                default:
                    break;
            }
        } else {
            operands.addFirst("false");
        }
    }

    /**
     * 判断字符类型
     *
     * @param operands 栈出内容
     * @return 类型
     */
    private static OperandTypeEnum judgeType(String operands) {
        operands = operands.trim();
        if (Pattern.matches("^[-\\+]?[\\d]*$", operands)) {
            return OperandTypeEnum.NUM;
        }
        if (DateUtil.verifyDateLegal(operands)) {
            return OperandTypeEnum.DATE;
        }
        return OperandTypeEnum.STR;
    }

    /**
     * 数字逻辑运算
     *
     * @param operand1 数字一
     * @param operand2 数字二
     * @param operate  操作类型
     * @return 逻辑运算结果
     */
    private static boolean numCalculate(long operand1, long operand2, OperatorEnum operate) {
        switch (operate) {
            case LT:
                return operand1 < operand2;
            case ELT:
                return operand1 <= operand2;
            case GT:
                return operand1 > operand2;
            case EGT:
                return operand1 >= operand2;
            case EQ:
                return operand1 == operand2;
            case NEQ:
                return operand1 != operand2;
            default:
                return true;
        }
    }

    /**
     * 字符串逻辑运算
     *
     * @param operand1 字符一
     * @param operand2 字符二
     * @param operate  操作类型
     * @return 逻辑运算结果
     */
    private static boolean strCalculate(String operand1, String operand2, OperatorEnum operate) {
        switch (operate) {
            case NOT:
                return !"true".equals(operand1);
            case EQ:
                return operand1.equals(operand2);
            case NEQ:
                return !operand1.equals(operand2);
            case AND:
                return "true".equals(operand1) && "true".equals(operand2);
            case BAND:
                return "true".equals(operand1) & "true".equals(operand2);
            case OR:
                return "true".equals(operand1) || "true".equals(operand2);
            case BOR:
                return "true".equals(operand1) | "true".equals(operand2);
            default:
                return true;
        }
    }

    /**
     * 日期逻辑运算
     *
     * @param operand1 日期一
     * @param operand2 日期二
     * @param operate  操作类型
     * @return 逻辑运算结果
     */
    private static boolean dateCalculate(String operand1, String operand2, OperatorEnum operate) {
        switch (operate) {
            case LT:
                return DateUtil.compareDate(operand1, operand2) == -1;
            case ELT:
                return DateUtil.compareDate(operand1, operand2) <= 0;
            case GT:
                return DateUtil.compareDate(operand1, operand2) == 1;
            case EGT:
                return DateUtil.compareDate(operand1, operand2) >= 0;
            case EQ:
                return DateUtil.compareDate(operand1, operand2) == 0;
            case NEQ:
                return DateUtil.compareDate(operand1, operand2) != 0;
            default:
                return true;
        }
    }
}


@Getter
@AllArgsConstructor
enum OperatorEnum {
    //!,&,|运算时暂时未考虑在内，主要用于判断字符是否为操作
    NOT("!", 0),
    LT("<", 1),
    ELT("<=", 1),
    GT(">", 1),
    EGT(">=", 1),
    EQ("==", 2),
    NEQ("!=", 2),
    BAND("&", 3),
    BOR("|", 4),
    AND("&&", 5),
    OR("||", 6),
    E("=", 7);
    private final String code;
    private final Integer priority;

    private static final Map<String, OperatorEnum> ENUMS = new HashMap<>();

    public static void enumToMap() {
        ENUMS.put("!", OperatorEnum.NOT);
        ENUMS.put("<", OperatorEnum.LT);
        ENUMS.put("<=", OperatorEnum.ELT);
        ENUMS.put(">", OperatorEnum.GT);
        ENUMS.put(">=", OperatorEnum.EGT);
        ENUMS.put("==", OperatorEnum.EQ);
        ENUMS.put("!=", OperatorEnum.NEQ);
        ENUMS.put("&", OperatorEnum.BAND);
        ENUMS.put("|", OperatorEnum.BOR);
        ENUMS.put("&&", OperatorEnum.AND);
        ENUMS.put("||", OperatorEnum.OR);
        ENUMS.put("=", OperatorEnum.E);
    }

    public static OperatorEnum getEnumByName(String name) {
        if (ENUMS.size() < 1) {
            enumToMap();
        }
        return ENUMS.get(name);
    }

    public static boolean isOperator(String name) {
        if (ENUMS.size() < 1) {
            enumToMap();
        }
        return ENUMS.containsKey(name);
    }
}

@Getter
@AllArgsConstructor
enum OperandTypeEnum {
    /**
     * 操作类型
     */
    NUM("数字"),
    DATE("日期"),
    STR("字符串");

    private final String typeName;
}