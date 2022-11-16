package work;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class 开门红活动 {
    private static  String select = " select * from goods_activity_relation where goods_code in (\n" +
            "CODES\n" +
            ") and activity_code = 'open_new_year_2023' ; \n";
    private static String 关联 =
            "INSERT INTO goods_activity_relation(goods_code,activity_code,special_activity_config_info,is_open,sort)VALUES" +
                    "('GOODSCODE','open_new_year_2023',NULL,1,NULL);\n";

    private static String 渠道关联 =
            "INSERT INTO goods_activity_channel_relation(goods_code,activity_code,special_activity_config_info,owner_code,is_white,is_black,start_time,end_time,sort) VALUES" +
                    "('GOODSCODE','open_new_year_2023',NULL,'ORGCODE',1,0,'START','END');";

    @Test
    public void 生成() {
        String START = "2022-12-01 00:00:00";
        String END = "2022-12-30 23:59:59";
        String 商品 = "A1106002\nA1409001\nA1115001";
        String 已经存在商品基础关联的 = "A1106002\nA1409001";

        String 渠道  = "C00095320102033\n" +
                "C00095320302032\n" +
                "C00095320202031\n" +
                "C00095320202030\n" +
                "C00095320502029\n" +
                "C00095320402028\n" +
                "C00095320501023\n" +
                "C00095320101022\n" +
                "11756\n" +
                "C00095440301014\n" +
                "C00095440101013\n" +
                "30046\n" +
                "C00095000001\n";
        System.out.println();
        System.out.println();
        System.out.println(select.replace("CODES", Arrays.stream(商品.split("\n")).map(s -> "'" + s + "'").collect(Collectors.joining(","))));
        System.out.println();

        for (String CODE : 商品.split("\n")) {
            if (!Lists.newArrayList(已经存在商品基础关联的.split("\n")).contains(CODE)) {
                System.out.println(关联
                        .replace("GOODSCODE", CODE)
                );
            }
            System.out.println();
            for (String org : 渠道.split("\n")) {
                System.out.println(渠道关联
                        .replace("GOODSCODE", CODE)
                        .replace("ORGCODE", org)
                        .replace("START", START)
                        .replace("END", END)
                );
            }
            System.out.println();
            System.out.println();
        }

    }
}
