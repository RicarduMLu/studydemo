package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 继承基础库
 *
 * @author lzj10
 * @date 2021-10-25
 */
public class DateUtil {
    /**
     * 验证字符串是否为合法日期 支持2019-03-12 2019/03/12 2019.03.12   HH:mm:ss HH:mm常用格式
     * @param date
     * @return
     */
    public static boolean verifyDateLegal(String date) {
        if ((date.contains("-") && date.contains("/"))
                || (date.contains("-") && date.contains("."))
                || (date.contains("/") && date.contains("."))){
            return false;
        }
        date.trim();
        StringBuilder timeSb = new StringBuilder();
        date = date.replaceAll("[\\.]|[//]", "-");
        String[] time = date.split(" ");
        timeSb.append(time[0]);
        timeSb.append(" ");
        if (time.length > 1) {
            timeSb.append(time[1]);
        }
        int i = time.length > 1 ? time[1].length() : 0;
        for ( ; i < 8 ; i ++) {
            if (i == 2 || i == 5){
                timeSb.append(":");
            } else {
                timeSb.append("0");
            }
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            sdf.setLenient(false);
            sdf.parse(timeSb.toString());
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    /**
     * @author Carol
     * 比较日期大小
     * @return
     */
    public static int compareDate(String date1, String date2){
        String d1 = date1.trim().replaceAll("-|:|/| ","");
        String d2 = date2.trim().replaceAll("-|:|/| ", "");
        StringBuilder sb1 = new StringBuilder(d1);
        StringBuilder sb2 = new StringBuilder(d2);
        while(sb1.length() < 14){
            sb1.append("0");
        }
        while(sb2.length() < 14){
            sb2.append("0");
        }
        long num1 = Long.parseLong(sb1.toString());
        long num2 = Long.parseLong(sb2.toString());
        return num1 == num2 ? 0 : num1 > num2 ? 1 : -1;
    }
}
