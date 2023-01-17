package work;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import constants.PeriodConstants;
import constants.TestConstants;
import org.junit.Test;
import utils.FileUrlUtils;

public class OtherTest {
    private static String nacos1 = "    PERSONAL_INFORMATION_PROCESSING_AUTHORIZATION: ";
    private static String nacos2 = "    PERSONAL_INFORMATION_PROCESSING_AUTHORIZATION_OUT: ";
    private static String nacos3 = "    #个人信息处理授权协议 签字版";
    private static String nacos3_1 = "    911201_SIZE_";
    private static String nacos4 = "    #个人信息处理授权协议 千里眼PDF版";
    private static String nacos4_2 = "    911201_PDF_";


    @Test
    public void getSql2() {
        String sql1 = "INSERT INTO `goods_content_info` (`goods_code`, `risk_code`, `is_main`, `main_code`, `page_type`, `function_type`, `content_type`, `content_show_type`, `content_input_item`, `content_silent_display`, `content_scope`, `content_postfix`, `is_must`, `content_sort` ) VALUES \n" +
                "( 'A1106001', '', false, '', 'A_APPLICANT', 'A_PERSONAL_INFORMATION', 'A_PERSONAL_INFORM_TAX', 'DROP_DOWN', '纳税身份信息', NULL, '', NULL, true, 35);";
        String sql2 = "INSERT INTO `goods_content_info` ( `goods_code`, `risk_code`, `is_main`, `main_code`, `page_type`, `function_type`, `content_type`, `content_show_type`, `content_input_item`, `content_silent_display`, `content_scope`, `content_postfix`, `is_must`, `content_sort`) VALUES \n" +
                "( 'A1106001', '', false, '', 'A_APPLICANT', 'A_PERSONAL_INFORMATION', 'A_PERSONAL_INFORM_OTHER_IMAGE', 'FILE_UPLOADER', '其他影像(可选)', NULL, '', NULL, false, 56);";
        String sql3 = "INSERT INTO `goods_content_info` ( `goods_code`, `risk_code`, `is_main`, `main_code`, `page_type`, `function_type`, `content_type`, `content_show_type`, `content_input_item`, `content_silent_display`, `content_scope`, `content_postfix`, `is_must`, `content_sort`) VALUES \n" +
                " ( 'A1106001', '', false, '', 'A_RECOGNIZE', 'A_RECOGNIZE_INFORMATION', 'A_RECOGNIZE_INFORM_CASE_IMAGE', 'FILE_UPLOADER', '病例影像(可选)', NULL, '', NULL, true, 87),\n" +
                " ( 'A1106001', '', false, '', 'A_RECOGNIZE', 'A_RECOGNIZE_INFORMATION', 'A_RECOGNIZE_INFORM_THROWBACK_IMAGE', 'FILE_UPLOADER', '隔代影像(可选)', NULL, '', NULL, true, 88),\n" +
                " ( 'A1106001', '', false, '', 'A_RECOGNIZE', 'A_RECOGNIZE_INFORMATION', 'A_RECOGNIZE_INFORM_OTHER_IMAGE', 'FILE_UPLOADER', '其他影像(可选)', NULL, '', NULL, true, 89);";
        String sql4 = "INSERT INTO `goods_rule` ( `goods_code`, `risk_code`, `plan_code`, `rule_type`, `rule_control_type`, `rule_scope`, `default_info`, `is_pass`, `sort`) VALUES\n" +
                " ( 'A1106001', '', '', 'APPLICANT_TAX', 'ENUMERATION', '{\\\"scopeMap\\\":{\\\"TAX_CHINA_ONLY\\\":\\\"仅为中国税收居民\\\",\\\"TAX_NON_CHINA_ONLY\\\":\\\"仅为非中国税收居民\\\",\\\"TAX_BOTH_CHINA_AND_OTHER_COUNTRIES\\\":\\\"既是中国税收居民又是其他国家（地区）税收居民\\\"}}', NULL, b'0', NULL);";
        System.out.println();
        System.out.println();
        String 长期险CODE = "A1101001\n" +
                "A1103001\n" +
                "A1106001\n" +
                "A1106002\n" +
                "A1106003\n" +
                "A1107001\n" +
                "A1108001\n" +
                "A1108002\n" +
                "A1109001\n" +
                "A1110001\n" +
                "A1114001\n" +
                "A1114002\n" +
                "A1115001\n" +
                "A1117001\n" +
                "A1118001\n" +
                "A1203001\n" +
                "A1302001\n" +
                "A1306001\n" +
                "A1404001\n" +
                "A1408001\n" +
                "A1409001\n" +
                "A1409002\n" +
                "A1409003\n" +
                "A1410001\n" +
                "A1412001\n" +
                "A1415001\n" +
                "A1417001\n" +
                "A1418001\n" +
                "A1419001\n" +
                "A1646001\n" +
                "A1650001\n" +
                "A165201653001\n" +
                "A1653001\n" +
                "A1654001\n" +
                "A1655001\n" +
                "A1659001";
        System.out.println("--  只有长险可以+纳税");
        for (String goods : 长期险CODE.split("\n")) {
            System.out.println(sql1.replace("A1106001", goods));
        }
        System.out.println();
        System.out.println("--  只有长险可以+纳税");

        for (String goods : 长期险CODE.split("\n")) {
            System.out.println(sql4.replace("A1106001", goods));
        }

        String 全量Code = "A1101001\n" +
                "A1103001\n" +
                "A1106001\n" +
                "A1106002\n" +
                "A1106003\n" +
                "A1107001\n" +
                "A1108001\n" +
                "A1108002\n" +
                "A1109001\n" +
                "A1110001\n" +
                "A1114001\n" +
                "A1114002\n" +
                "A1115001\n" +
                "A1117001\n" +
                "A1118001\n" +
                "A1203001\n" +
                "A1302001\n" +
                "A1306001\n" +
                "A1404001\n" +
                "A1408001\n" +
                "A1409001\n" +
                "A1409002\n" +
                "A1409003\n" +
                "A1410001\n" +
                "A1412001\n" +
                "A1415001\n" +
                "A1417001\n" +
                "A1418001\n" +
                "A1419001\n" +
                "A1518001\n" +
                "A1646001\n" +
                "A1650001\n" +
                "A165201653001\n" +
                "A1653001\n" +
                "A1654001\n" +
                "A1655001\n" +
                "A1659001\n" +
                "A1714001\n" +
                "A1720001\n" +
                "A3401001\n" +
                "A3404001";
        System.out.println("--  增加投保人其他影像\n");
        for (String goods : 全量Code.split("\n")) {
            System.out.println(sql2.replace("A1106001", goods));
        }
        String 存在祖孙的CODE = "A1101001\n" +
                "A1103001\n" +
                "A1106001\n" +
                "A1106002\n" +
                "A1107001\n" +
                "A1108001\n" +
                "A1108002\n" +
                "A1109001\n" +
                "A1110001\n" +
                "A1114001\n" +
                "A1114002\n" +
                "A1115001\n" +
                "A1117001\n" +
                "A1118001\n" +
                "A1203001\n" +
                "A1302001\n" +
                "A1306001\n" +
                "A1404001\n" +
                "A1408001\n" +
                "A1409001\n" +
                "A1409002\n" +
                "A1409003\n" +
                "A1410001\n" +
                "A1412001\n" +
                "A1415001\n" +
                "A1417001\n" +
                "A1419001\n" +
                "A1518001\n" +
                "A1646001\n" +
                "A1650001\n" +
                "A165201653001\n" +
                "A1653001\n" +
                "A1654001\n" +
                "A1655001\n" +
                "A1659001\n" +
                "A1714001\n" +
                "A1720001\n" +
                "A3401001";
        for (String goods : 全量Code.split("\n")) {
            if (存在祖孙的CODE.contains(goods)) {
                System.out.println(sql3.replace("A1106001", goods));
            }else {
                // 不增加隔代内容
                System.out.println(sql3
                        .replace(" ( 'A1106001', '', false, '', 'A_RECOGNIZE', 'A_RECOGNIZE_INFORMATION', 'A_RECOGNIZE_INFORM_THROWBACK_IMAGE', 'FILE_UPLOADER', '隔代影像(可选)', NULL, '', NULL, true, 88),","")
                        .replace("A1106001", goods));

            }
        }

        System.out.println();
        System.out.println();

    }

    @Test
    public void getUrls2222() {
        for (int i = 1; i < 53; i++) {
            System.out.println(".replace(\"\\\\\\\"" + i + "\\\\\\\":\\\\\\\"" + i + "年\\\\\\\"\",\"\\\\\\\"" + i + "_YEAR\\\\\\\":\\\\\\\"" + i + "年\\\\\\\"\")");
        }
        for (int i = 1; i < 13; i++) {
            System.out.println(".replace(\"\\\\\\\"" + i + "\\\\\\\":\\\\\\\"" + i + "月\\\\\\\"\",\"\\\\\\\"" + i + "_MONTH\\\\\\\":\\\\\\\"" + i + "月\\\\\\\"\")");
        }

        for (int i = 1; i < 8; i++) {
            System.out.println(".replace(\"\\\\\\\"" + i + "\\\\\\\":\\\\\\\"" + i + "天\\\\\\\"\",\"\\\\\\\"" + i + "_DAY\\\\\\\":\\\\\\\"" + i + "天\\\\\\\"\")");
        }


        System.out.println(".replace(\"\\\\\\\"" + 55 + "\\\\\\\":\\\\\\\"至55周岁\\\\\\\"\",\"\\\\\\\"" + 55 + "_AGE\\\\\\\":\\\\\\\"至55周岁\\\\\\\"\")");
        System.out.println(".replace(\"\\\\\\\"" + 60 + "\\\\\\\":\\\\\\\"至60周岁\\\\\\\"\",\"\\\\\\\"" + 60 + "_AGE\\\\\\\":\\\\\\\"至60周岁\\\\\\\"\")");
        System.out.println(".replace(\"\\\\\\\"" + 65 + "\\\\\\\":\\\\\\\"至65周岁\\\\\\\"\",\"\\\\\\\"" + 65 + "_AGE\\\\\\\":\\\\\\\"至65周岁\\\\\\\"\")");
        System.out.println(".replace(\"\\\\\\\"" + 70 + "\\\\\\\":\\\\\\\"至70周岁\\\\\\\"\",\"\\\\\\\"" + 70 + "_AGE\\\\\\\":\\\\\\\"至70周岁\\\\\\\"\")");
        System.out.println(".replace(\"\\\\\\\"" + 105 + "\\\\\\\":\\\\\\\"至105周岁\\\\\\\"\",\"\\\\\\\"" + 105 + "_AGE\\\\\\\":\\\\\\\"至105周岁\\\\\\\"\")");

    }

    @Test
    public void getPayPeriod() {

        System.out.println();
        System.out.println();
        String[] goodsSplit = PeriodConstants.payPeriod_rule.replace("}\n", "}").split("\n");
        for (String goodsRisk : goodsSplit) {
            String[] split = goodsRisk.split("\t");
            System.out.print(" UPDATE `goods_rule` SET `rule_type` = 'PAY_PERIOD' , `rule_scope` = ");

            String ruleScope = split[3]
                    .replace("\\\"1000\\\":\\\"趸交\\\"", "\\\"1000_YEAR\\\":\\\"一次性交清\\\"")
                    .replace("\\\"1000\\\":\\\"一次性交清\\\"", "\\\"1000_YEAR\\\":\\\"一次性交清\\\"")
                    .replace("\\\"1\\\":\\\"1年\\\"", "\\\"1_YEAR\\\":\\\"1年\\\"")
                    .replace("\\\"2\\\":\\\"2年\\\"", "\\\"2_YEAR\\\":\\\"2年\\\"")
                    .replace("\\\"3\\\":\\\"3年\\\"", "\\\"3_YEAR\\\":\\\"3年\\\"")
                    .replace("\\\"4\\\":\\\"4年\\\"", "\\\"4_YEAR\\\":\\\"4年\\\"")
                    .replace("\\\"5\\\":\\\"5年\\\"", "\\\"5_YEAR\\\":\\\"5年\\\"")
                    .replace("\\\"6\\\":\\\"6年\\\"", "\\\"6_YEAR\\\":\\\"6年\\\"")
                    .replace("\\\"7\\\":\\\"7年\\\"", "\\\"7_YEAR\\\":\\\"7年\\\"")
                    .replace("\\\"8\\\":\\\"8年\\\"", "\\\"8_YEAR\\\":\\\"8年\\\"")
                    .replace("\\\"9\\\":\\\"9年\\\"", "\\\"9_YEAR\\\":\\\"9年\\\"")
                    .replace("\\\"10\\\":\\\"10年\\\"", "\\\"10_YEAR\\\":\\\"10年\\\"")
                    .replace("\\\"11\\\":\\\"11年\\\"", "\\\"11_YEAR\\\":\\\"11年\\\"")
                    .replace("\\\"12\\\":\\\"12年\\\"", "\\\"12_YEAR\\\":\\\"12年\\\"")
                    .replace("\\\"13\\\":\\\"13年\\\"", "\\\"13_YEAR\\\":\\\"13年\\\"")
                    .replace("\\\"14\\\":\\\"14年\\\"", "\\\"14_YEAR\\\":\\\"14年\\\"")
                    .replace("\\\"15\\\":\\\"15年\\\"", "\\\"15_YEAR\\\":\\\"15年\\\"")
                    .replace("\\\"16\\\":\\\"16年\\\"", "\\\"16_YEAR\\\":\\\"16年\\\"")
                    .replace("\\\"17\\\":\\\"17年\\\"", "\\\"17_YEAR\\\":\\\"17年\\\"")
                    .replace("\\\"18\\\":\\\"18年\\\"", "\\\"18_YEAR\\\":\\\"18年\\\"")
                    .replace("\\\"19\\\":\\\"19年\\\"", "\\\"19_YEAR\\\":\\\"19年\\\"")
                    .replace("\\\"20\\\":\\\"20年\\\"", "\\\"20_YEAR\\\":\\\"20年\\\"")
                    .replace("\\\"21\\\":\\\"21年\\\"", "\\\"21_YEAR\\\":\\\"21年\\\"")
                    .replace("\\\"22\\\":\\\"22年\\\"", "\\\"22_YEAR\\\":\\\"22年\\\"")
                    .replace("\\\"23\\\":\\\"23年\\\"", "\\\"23_YEAR\\\":\\\"23年\\\"")
                    .replace("\\\"24\\\":\\\"24年\\\"", "\\\"24_YEAR\\\":\\\"24年\\\"")
                    .replace("\\\"25\\\":\\\"25年\\\"", "\\\"25_YEAR\\\":\\\"25年\\\"")
                    .replace("\\\"26\\\":\\\"26年\\\"", "\\\"26_YEAR\\\":\\\"26年\\\"")
                    .replace("\\\"27\\\":\\\"27年\\\"", "\\\"27_YEAR\\\":\\\"27年\\\"")
                    .replace("\\\"28\\\":\\\"28年\\\"", "\\\"28_YEAR\\\":\\\"28年\\\"")
                    .replace("\\\"29\\\":\\\"29年\\\"", "\\\"29_YEAR\\\":\\\"29年\\\"")
                    .replace("\\\"30\\\":\\\"30年\\\"", "\\\"30_YEAR\\\":\\\"30年\\\"")
                    .replace("\\\"31\\\":\\\"31年\\\"", "\\\"31_YEAR\\\":\\\"31年\\\"")
                    .replace("\\\"32\\\":\\\"32年\\\"", "\\\"32_YEAR\\\":\\\"32年\\\"")
                    .replace("\\\"33\\\":\\\"33年\\\"", "\\\"33_YEAR\\\":\\\"33年\\\"")
                    .replace("\\\"34\\\":\\\"34年\\\"", "\\\"34_YEAR\\\":\\\"34年\\\"")
                    .replace("\\\"35\\\":\\\"35年\\\"", "\\\"35_YEAR\\\":\\\"35年\\\"")
                    .replace("\\\"36\\\":\\\"36年\\\"", "\\\"36_YEAR\\\":\\\"36年\\\"")
                    .replace("\\\"37\\\":\\\"37年\\\"", "\\\"37_YEAR\\\":\\\"37年\\\"")
                    .replace("\\\"38\\\":\\\"38年\\\"", "\\\"38_YEAR\\\":\\\"38年\\\"")
                    .replace("\\\"39\\\":\\\"39年\\\"", "\\\"39_YEAR\\\":\\\"39年\\\"")
                    .replace("\\\"40\\\":\\\"40年\\\"", "\\\"40_YEAR\\\":\\\"40年\\\"")
                    .replace("\\\"41\\\":\\\"41年\\\"", "\\\"41_YEAR\\\":\\\"41年\\\"")
                    .replace("\\\"42\\\":\\\"42年\\\"", "\\\"42_YEAR\\\":\\\"42年\\\"")
                    .replace("\\\"43\\\":\\\"43年\\\"", "\\\"43_YEAR\\\":\\\"43年\\\"")
                    .replace("\\\"44\\\":\\\"44年\\\"", "\\\"44_YEAR\\\":\\\"44年\\\"")
                    .replace("\\\"45\\\":\\\"45年\\\"", "\\\"45_YEAR\\\":\\\"45年\\\"")
                    .replace("\\\"46\\\":\\\"46年\\\"", "\\\"46_YEAR\\\":\\\"46年\\\"")
                    .replace("\\\"47\\\":\\\"47年\\\"", "\\\"47_YEAR\\\":\\\"47年\\\"")
                    .replace("\\\"48\\\":\\\"48年\\\"", "\\\"48_YEAR\\\":\\\"48年\\\"")
                    .replace("\\\"49\\\":\\\"49年\\\"", "\\\"49_YEAR\\\":\\\"49年\\\"")
                    .replace("\\\"50\\\":\\\"50年\\\"", "\\\"50_YEAR\\\":\\\"50年\\\"")
                    .replace("\\\"51\\\":\\\"51年\\\"", "\\\"51_YEAR\\\":\\\"51年\\\"")
                    .replace("\\\"52\\\":\\\"52年\\\"", "\\\"52_YEAR\\\":\\\"52年\\\"")
                    .replace("\\\"1\\\":\\\"1月\\\"", "\\\"1_MONTH\\\":\\\"1月\\\"")
                    .replace("\\\"2\\\":\\\"2月\\\"", "\\\"2_MONTH\\\":\\\"2月\\\"")
                    .replace("\\\"3\\\":\\\"3月\\\"", "\\\"3_MONTH\\\":\\\"3月\\\"")
                    .replace("\\\"4\\\":\\\"4月\\\"", "\\\"4_MONTH\\\":\\\"4月\\\"")
                    .replace("\\\"5\\\":\\\"5月\\\"", "\\\"5_MONTH\\\":\\\"5月\\\"")
                    .replace("\\\"6\\\":\\\"6月\\\"", "\\\"6_MONTH\\\":\\\"6月\\\"")
                    .replace("\\\"7\\\":\\\"7月\\\"", "\\\"7_MONTH\\\":\\\"7月\\\"")
                    .replace("\\\"8\\\":\\\"8月\\\"", "\\\"8_MONTH\\\":\\\"8月\\\"")
                    .replace("\\\"9\\\":\\\"9月\\\"", "\\\"9_MONTH\\\":\\\"9月\\\"")
                    .replace("\\\"10\\\":\\\"10月\\\"", "\\\"10_MONTH\\\":\\\"10月\\\"")
                    .replace("\\\"11\\\":\\\"11月\\\"", "\\\"11_MONTH\\\":\\\"11月\\\"")
                    .replace("\\\"12\\\":\\\"12月\\\"", "\\\"12_MONTH\\\":\\\"12月\\\"")
                    .replace("\\\"1000\\\"", "\\\"1000_YEAR\\\"");

            System.out.print("'ruleScope' ".replace("ruleScope", ruleScope));
            System.out.println(", `default_info` = ");
            String def = null;
            if ("1000".equals(split[4])) {
                def = "_YEAR";
            } else if (split[3].contains("年")) {
                def = "_YEAR";
            } else if (split[3].contains("月")) {
                def = "_MONTH";
            }
            System.out.print("'defaultInfo' ".replace("defaultInfo", split[4] + def));

            System.out.print(" WHERE `rule_type` = 'PAY_YEAR' AND `goods_code` = ");
            System.out.print("'goodsCode' ".replace("goodsCode", split[0]));
            System.out.print("AND risk_code = ");
            System.out.print("'riskCode' ".replace("riskCode", split[1]));

            System.out.println(";");
            System.out.println();
        }

        System.out.println();
        System.out.println();

    }

    @Test
    public void getInsuredPeriod() {

        System.out.println();
        System.out.println();
        String[] goodsSplit = PeriodConstants.inuredPeriod_rule.replace("}\n", "}").split("\n");
        for (String goodsRisk : goodsSplit) {
            String[] split = goodsRisk.split("\t");
            System.out.print(" UPDATE `goods_rule` SET `rule_type` = 'INSURANCE_PERIOD' , `rule_scope` = ");

            String ruleScope = split[3]
                    .replace("\\\"1000\\\":\\\"终身\\\"", "\\\"1000_LIFELONG\\\":\\\"终身\\\"")
                    .replace("\\\"1\\\":\\\"1年\\\"", "\\\"1_YEAR\\\":\\\"1年\\\"")
                    .replace("\\\"2\\\":\\\"2年\\\"", "\\\"2_YEAR\\\":\\\"2年\\\"")
                    .replace("\\\"3\\\":\\\"3年\\\"", "\\\"3_YEAR\\\":\\\"3年\\\"")
                    .replace("\\\"4\\\":\\\"4年\\\"", "\\\"4_YEAR\\\":\\\"4年\\\"")
                    .replace("\\\"5\\\":\\\"5年\\\"", "\\\"5_YEAR\\\":\\\"5年\\\"")
                    .replace("\\\"6\\\":\\\"6年\\\"", "\\\"6_YEAR\\\":\\\"6年\\\"")
                    .replace("\\\"7\\\":\\\"7年\\\"", "\\\"7_YEAR\\\":\\\"7年\\\"")
                    .replace("\\\"8\\\":\\\"8年\\\"", "\\\"8_YEAR\\\":\\\"8年\\\"")
                    .replace("\\\"9\\\":\\\"9年\\\"", "\\\"9_YEAR\\\":\\\"9年\\\"")
                    .replace("\\\"10\\\":\\\"10年\\\"", "\\\"10_YEAR\\\":\\\"10年\\\"")
                    .replace("\\\"11\\\":\\\"11年\\\"", "\\\"11_YEAR\\\":\\\"11年\\\"")
                    .replace("\\\"12\\\":\\\"12年\\\"", "\\\"12_YEAR\\\":\\\"12年\\\"")
                    .replace("\\\"13\\\":\\\"13年\\\"", "\\\"13_YEAR\\\":\\\"13年\\\"")
                    .replace("\\\"14\\\":\\\"14年\\\"", "\\\"14_YEAR\\\":\\\"14年\\\"")
                    .replace("\\\"15\\\":\\\"15年\\\"", "\\\"15_YEAR\\\":\\\"15年\\\"")
                    .replace("\\\"16\\\":\\\"16年\\\"", "\\\"16_YEAR\\\":\\\"16年\\\"")
                    .replace("\\\"17\\\":\\\"17年\\\"", "\\\"17_YEAR\\\":\\\"17年\\\"")
                    .replace("\\\"18\\\":\\\"18年\\\"", "\\\"18_YEAR\\\":\\\"18年\\\"")
                    .replace("\\\"19\\\":\\\"19年\\\"", "\\\"19_YEAR\\\":\\\"19年\\\"")
                    .replace("\\\"20\\\":\\\"20年\\\"", "\\\"20_YEAR\\\":\\\"20年\\\"")
                    .replace("\\\"21\\\":\\\"21年\\\"", "\\\"21_YEAR\\\":\\\"21年\\\"")
                    .replace("\\\"22\\\":\\\"22年\\\"", "\\\"22_YEAR\\\":\\\"22年\\\"")
                    .replace("\\\"23\\\":\\\"23年\\\"", "\\\"23_YEAR\\\":\\\"23年\\\"")
                    .replace("\\\"24\\\":\\\"24年\\\"", "\\\"24_YEAR\\\":\\\"24年\\\"")
                    .replace("\\\"25\\\":\\\"25年\\\"", "\\\"25_YEAR\\\":\\\"25年\\\"")
                    .replace("\\\"26\\\":\\\"26年\\\"", "\\\"26_YEAR\\\":\\\"26年\\\"")
                    .replace("\\\"27\\\":\\\"27年\\\"", "\\\"27_YEAR\\\":\\\"27年\\\"")
                    .replace("\\\"28\\\":\\\"28年\\\"", "\\\"28_YEAR\\\":\\\"28年\\\"")
                    .replace("\\\"29\\\":\\\"29年\\\"", "\\\"29_YEAR\\\":\\\"29年\\\"")
                    .replace("\\\"30\\\":\\\"30年\\\"", "\\\"30_YEAR\\\":\\\"30年\\\"")
                    .replace("\\\"31\\\":\\\"31年\\\"", "\\\"31_YEAR\\\":\\\"31年\\\"")
                    .replace("\\\"32\\\":\\\"32年\\\"", "\\\"32_YEAR\\\":\\\"32年\\\"")
                    .replace("\\\"33\\\":\\\"33年\\\"", "\\\"33_YEAR\\\":\\\"33年\\\"")
                    .replace("\\\"34\\\":\\\"34年\\\"", "\\\"34_YEAR\\\":\\\"34年\\\"")
                    .replace("\\\"35\\\":\\\"35年\\\"", "\\\"35_YEAR\\\":\\\"35年\\\"")
                    .replace("\\\"36\\\":\\\"36年\\\"", "\\\"36_YEAR\\\":\\\"36年\\\"")
                    .replace("\\\"37\\\":\\\"37年\\\"", "\\\"37_YEAR\\\":\\\"37年\\\"")
                    .replace("\\\"38\\\":\\\"38年\\\"", "\\\"38_YEAR\\\":\\\"38年\\\"")
                    .replace("\\\"39\\\":\\\"39年\\\"", "\\\"39_YEAR\\\":\\\"39年\\\"")
                    .replace("\\\"40\\\":\\\"40年\\\"", "\\\"40_YEAR\\\":\\\"40年\\\"")
                    .replace("\\\"41\\\":\\\"41年\\\"", "\\\"41_YEAR\\\":\\\"41年\\\"")
                    .replace("\\\"42\\\":\\\"42年\\\"", "\\\"42_YEAR\\\":\\\"42年\\\"")
                    .replace("\\\"43\\\":\\\"43年\\\"", "\\\"43_YEAR\\\":\\\"43年\\\"")
                    .replace("\\\"44\\\":\\\"44年\\\"", "\\\"44_YEAR\\\":\\\"44年\\\"")
                    .replace("\\\"45\\\":\\\"45年\\\"", "\\\"45_YEAR\\\":\\\"45年\\\"")
                    .replace("\\\"46\\\":\\\"46年\\\"", "\\\"46_YEAR\\\":\\\"46年\\\"")
                    .replace("\\\"47\\\":\\\"47年\\\"", "\\\"47_YEAR\\\":\\\"47年\\\"")
                    .replace("\\\"48\\\":\\\"48年\\\"", "\\\"48_YEAR\\\":\\\"48年\\\"")
                    .replace("\\\"49\\\":\\\"49年\\\"", "\\\"49_YEAR\\\":\\\"49年\\\"")
                    .replace("\\\"50\\\":\\\"50年\\\"", "\\\"50_YEAR\\\":\\\"50年\\\"")
                    .replace("\\\"51\\\":\\\"51年\\\"", "\\\"51_YEAR\\\":\\\"51年\\\"")
                    .replace("\\\"52\\\":\\\"52年\\\"", "\\\"52_YEAR\\\":\\\"52年\\\"")
                    .replace("\\\"1\\\":\\\"1月\\\"", "\\\"1_MONTH\\\":\\\"1月\\\"")
                    .replace("\\\"2\\\":\\\"2月\\\"", "\\\"2_MONTH\\\":\\\"2月\\\"")
                    .replace("\\\"3\\\":\\\"3月\\\"", "\\\"3_MONTH\\\":\\\"3月\\\"")
                    .replace("\\\"4\\\":\\\"4月\\\"", "\\\"4_MONTH\\\":\\\"4月\\\"")
                    .replace("\\\"5\\\":\\\"5月\\\"", "\\\"5_MONTH\\\":\\\"5月\\\"")
                    .replace("\\\"6\\\":\\\"6月\\\"", "\\\"6_MONTH\\\":\\\"6月\\\"")
                    .replace("\\\"7\\\":\\\"7月\\\"", "\\\"7_MONTH\\\":\\\"7月\\\"")
                    .replace("\\\"8\\\":\\\"8月\\\"", "\\\"8_MONTH\\\":\\\"8月\\\"")
                    .replace("\\\"9\\\":\\\"9月\\\"", "\\\"9_MONTH\\\":\\\"9月\\\"")
                    .replace("\\\"10\\\":\\\"10月\\\"", "\\\"10_MONTH\\\":\\\"10月\\\"")
                    .replace("\\\"11\\\":\\\"11月\\\"", "\\\"11_MONTH\\\":\\\"11月\\\"")
                    .replace("\\\"12\\\":\\\"12月\\\"", "\\\"12_MONTH\\\":\\\"12月\\\"")
                    .replace("\\\"1\\\":\\\"1天\\\"", "\\\"1_DAY\\\":\\\"1天\\\"")
                    .replace("\\\"2\\\":\\\"2天\\\"", "\\\"2_DAY\\\":\\\"2天\\\"")
                    .replace("\\\"3\\\":\\\"3天\\\"", "\\\"3_DAY\\\":\\\"3天\\\"")
                    .replace("\\\"4\\\":\\\"4天\\\"", "\\\"4_DAY\\\":\\\"4天\\\"")
                    .replace("\\\"5\\\":\\\"5天\\\"", "\\\"5_DAY\\\":\\\"5天\\\"")
                    .replace("\\\"6\\\":\\\"6天\\\"", "\\\"6_DAY\\\":\\\"6天\\\"")
                    .replace("\\\"7\\\":\\\"7天\\\"", "\\\"7_DAY\\\":\\\"7天\\\"")
                    .replace("\\\"55\\\":\\\"至55周岁\\\"", "\\\"55_AGE\\\":\\\"至55周岁\\\"")
                    .replace("\\\"60\\\":\\\"至60周岁\\\"", "\\\"60_AGE\\\":\\\"至60周岁\\\"")
                    .replace("\\\"65\\\":\\\"至65周岁\\\"", "\\\"65_AGE\\\":\\\"至65周岁\\\"")
                    .replace("\\\"70\\\":\\\"至70周岁\\\"", "\\\"70_AGE\\\":\\\"至70周岁\\\"")
                    .replace("\\\"70\\\":\\\"保至70岁\\\"", "\\\"70_AGE\\\":\\\"至70周岁\\\"")
                    .replace("\\\"105\\\":\\\"至105周岁\\\"", "\\\"105_AGE\\\":\\\"至105周岁\\\"")
                    .replace("\\\"1000\\\"", "\\\"1000_LIFELONG\\\"");

            System.out.print("'ruleScope' ".replace("ruleScope", ruleScope));
            System.out.println(", `default_info` = ");
            String def = null;
            if ("1000".equals(split[4])) {
                def = "_LIFELONG";
            } else if (Integer.parseInt(split[4]) > 30) {
                def = "_AGE";
            } else if (split[3].contains("年")) {
                def = "_YEAR";
            } else if (split[3].contains("月")) {
                def = "_MONTH";
            } else if (split[3].contains("天")) {
                def = "_DAY";
            }
            System.out.print("'defaultInfo' ".replace("defaultInfo", split[4] + def));
            System.out.print(" WHERE `rule_type` = 'POLICY_PERIOD' AND `goods_code` = ");
            System.out.print("'goodsCode' ".replace("goodsCode", split[0]));
            System.out.print("AND risk_code = ");
            System.out.print("'riskCode' ".replace("riskCode", split[1]));

            System.out.println(";");
            System.out.println();
        }

        System.out.println();
        System.out.println();

    }


    @Test
    public void goodsRuleRelationInfo() {
        System.out.println();


        String sql = "INSERT INTO `goods_rule_relation_info` (`goods_code`, `risk_code`, `plan_code`, `rule_relation_code`, `main_content_type`, `main_rule_type`, `main_content_control_scope`, `main_rule_control_type`, `content_type`, `control_rule_type`, `rule_control_type`, `control_scope`, `default_info`) VALUES ( 'A1419001', '16480', '', 'A1419001_1', '', 'PAY_YEAR', '{\\\"scopeMap\\\":{XXXXXXX}}', 'ENUMERATION', '', 'RECOGNIZE_AGE', 'SCOPE', '{\\\"maxScope\\\":AGEE,\\\"maxScopeUnit\\\":\\\"AGE\\\"}', 'DEFAULT');";
        //交至59周岁  投保人最小16 周岁 最多交费43年
        for (int i = 8; i < 53; i++) {

            System.out.print(sql
                    .replace("XXXXXXX", "\\\"" + i + "\\\":\\\"" + i + "年\\\"")
                    .replace("AGEE", (70 - i) + "")
                    .replace("DEFAULT", (70 - i) > 30 ? "30" : (70 - i - 1) + "")
            );
            if (i < 58) {
                System.out.println("");
            }
        }
    }

    @Test
    public void getUrls2() {
        System.out.println();
        System.out.println();
        JSONArray parseArray = FileUrlUtils.getUrl(TestConstants.个人纯签名图片FileUrls);
        System.out.println(nacos3);
        for (int i = 0; i < parseArray.size(); i++) {
            Object fileUrlList = parseArray.get(i);
            JSONObject url = (JSONObject) fileUrlList;
            System.out.print(nacos3_1);
            System.out.print((i + 1) + ": ");
            System.out.println(url.get("innerUrl"));
        }
        parseArray = FileUrlUtils.getUrl(TestConstants.个人千里眼PDFFileUrls);
        System.out.println(nacos4);
        for (int i = 0; i < parseArray.size(); i++) {
            Object fileUrlList = parseArray.get(i);
            JSONObject url = (JSONObject) fileUrlList;
            System.out.print(nacos4_2);
            System.out.print((i + 1) + ": ");
            System.out.println(url.get("innerUrl"));
        }

        getUrls();
    }

    @Test
    public void getUrls() {
        System.out.println();
        System.out.println();
        JSONArray parseArray = FileUrlUtils.getUrl(TestConstants.个人纯文本图片FileUrls);
        boolean innerFlag = true;
        System.out.print(nacos1);
        for (int i = 0; i < parseArray.size(); i++) {
            Object fileUrlList = parseArray.get(i);
            JSONObject url = (JSONObject) fileUrlList;
            if (innerFlag) {
                System.out.print(url.get("innerUrl"));
            } else {
                System.out.print(url.get("outerUrl"));
            }
            if (i < parseArray.size() - 1) {
                System.out.print(",");
            }
        }
        System.out.println();
        innerFlag = false;
        System.out.print(nacos2);
        for (int i = 0; i < parseArray.size(); i++) {
            Object fileUrlList = parseArray.get(i);
            JSONObject url = (JSONObject) fileUrlList;
            if (innerFlag) {
                System.out.print(url.get("innerUrl"));
            } else {
                System.out.print(url.get("outerUrl"));
            }
            if (i < parseArray.size() - 1) {
                System.out.print(",");
            }
        }
        System.out.println();
        System.out.println();
    }

    @Test
    public void test0001() {
        String sql0 = "INSERT INTO `goods_text`( `goods_code`, `permission_id`, `text_type`, `text_name`, `text_info`, `is_must_read`, `sort` ) VALUES";
        String sql00 = "('goodsCode', 'permissionId', 'CHARACTERISTIC_URL', '产品特色', 'characteristicUrl', false, 15)";
        String sql1 =
                "INSERT INTO `goods_rule_channel` ( `goods_code`, `plan_code`,`risk_code`, `permission_id`, `rule_type`, `rule_control_type`, `rule_scope`, `default_info`) VALUES";
        String sql11 = "( 'goodsCode', 'riskCode', '', 'permissionId', 'PAY_FREQUENCY', 'ENUMERATION', 'ruleScope', 'ANNUAL')";

        String sql2 = "INSERT INTO `goods_rule_channel_relation` ( `goods_code`, `risk_code`, `plan_code`, `permission_id`, `channel_rule_relation_code`, `channel_rule_relation_name`, `content_type`, `rule_type`, `rule_control_type`) VALUES";
        String sql22 = "( 'goodsCode', 'riskCode', '', 'permissionId', 'orgCode_1', '交费期间控制投保年龄', 'A_TRAIL_RISKS_PAYENDYEAR', 'PAY_YEAR', 'ENUMERATION')";
        String sql3 = "INSERT INTO `goods_rule_channel_relation_info` ( `goods_code`, `risk_code`, `plan_code`, `permission_id`, `channel_rule_relation_code`, `main_content_type`, `main_rule_type`, `main_content_control_scope`, `main_rule_control_type`, `content_type`, `control_rule_type`, `rule_control_type`, `control_scope`, `default_info`) VALUES";
        String sql33 = "('goodsCode', 'riskCode', '', 'permissionId', 'orgCode_1', 'A_TRAIL_RISKS_PAYENDYEAR', 'PAY_YEAR', '{\\\"scopeMap\\\":{\\\"3\\\":\\\"3年\\\",\\\"20\\\":\\\"20年\\\"}}', 'ENUMERATION', 'A_TRAIL_RECOGNIZE_BIRTHDAY', 'RECOGNIZE_AGE', 'SCOPE', '{\\\"maxScope\\\":50,\\\"maxScopeUnit\\\":\\\"AGE\\\"}', '30'),\n" +
                "('goodsCode', 'riskCode', '', 'permissionId', 'orgCode_1', 'A_TRAIL_RISKS_PAYENDYEAR', 'PAY_YEAR', '{\\\"scopeMap\\\":{\\\"5\\\":\\\"5年\\\"}}', 'ENUMERATION', 'A_TRAIL_RECOGNIZE_BIRTHDAY', 'RECOGNIZE_AGE', 'SCOPE', '{\\\"maxScope\\\":45,\\\"maxScopeUnit\\\":\\\"AGE\\\"}', '30'),\n" +
                "('goodsCode', 'riskCode', '', 'permissionId', 'orgCode_1', 'A_TRAIL_RISKS_PAYENDYEAR', 'PAY_YEAR', '{\\\"scopeMap\\\":{\\\"10\\\":\\\"10年\\\"}}', 'ENUMERATION', 'A_TRAIL_RECOGNIZE_BIRTHDAY', 'RECOGNIZE_AGE', 'SCOPE', '{\\\"maxScope\\\":40,\\\"maxScopeUnit\\\":\\\"AGE\\\"}', '30')";

        String goodsCode = "A1409001";
        String riskCode = "14090";
        String characteristicUrl = "https://hq-prd-e-zine.oss-cn-szfinance.aliyuncs.com/agent/prd/agent/2022/06/23/product_1655968218743.png";
        String ruleScope = "{\\\"scopeMap\\\":{\\\"SINGLE\\\":\\\"趸交\\\",\\\"ANNUAL\\\":\\\"年交\\\"}}";

        sql00 = sql00.replaceAll("characteristicUrl", characteristicUrl);
        sql00 = sql00.replaceAll("goodsCode", goodsCode).replaceAll("riskCode", riskCode);
        sql11 = sql11.replaceAll("ruleScope", ruleScope);
        sql11 = sql11.replaceAll("goodsCode", goodsCode).replaceAll("riskCode", riskCode);
        sql22 = sql22.replaceAll("goodsCode", goodsCode).replaceAll("riskCode", riskCode);
        sql33 = sql33.replaceAll("goodsCode", goodsCode).replaceAll("riskCode", riskCode);
        String[] split = TestConstants.渠道特殊配置0720.split("\n");
        //"1\tC00013440604415\t臻享一生养老年金\tA1409001\t32EBBD3CED435BB82CEA227B6E5DF680\n"
        System.out.println();
        System.out.println();
        System.out.println(sql0);
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            String[] ss = s.split("\t");
            System.out.print(sql00.replaceAll("orgCode", ss[1]).replaceAll("permissionId", ss[4]));
            if (i < split.length - 1) {
                System.out.println(",");
            } else {
                System.out.println(";");
            }
        }
        System.out.println();
        System.out.println();
        System.out.println(sql1);
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            String[] ss = s.split("\t");
            System.out.print(sql11.replaceAll("orgCode", ss[1]).replaceAll("permissionId", ss[4]));
            if (i < split.length - 1) {
                System.out.println(",");
            } else {
                System.out.println(";");
            }
        }
        System.out.println();
        System.out.println();
        System.out.println(sql2);
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            String[] ss = s.split("\t");
            System.out.print(sql22.replaceAll("orgCode", ss[1]).replaceAll("permissionId", ss[4]));
            if (i < split.length - 1) {
                System.out.println(",");
            } else {
                System.out.println(";");
            }
        }
        System.out.println();
        System.out.println();
        System.out.println(sql3);
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            String[] ss = s.split("\t");
            System.out.print(sql33.replaceAll("orgCode", ss[1]).replaceAll("permissionId", ss[4]));
            if (i < split.length - 1) {
                System.out.println(",");
            } else {
                System.out.println(";");
            }
        }
        System.out.println();


        System.out.println();
    }

    @Test
    public void test0002() {
        String sql1 =
                "INSERT INTO `goods_rule_channel` ( `goods_code`,`risk_code`, `plan_code`, `permission_id`, `rule_type`, `rule_control_type`, `rule_scope`, `default_info`) VALUES";
        String initSql11 = "( 'goodsCode', 'riskCode', '', 'permissionId', 'PAY_FREQUENCY', 'ENUMERATION', '{\\\"scopeMap\\\":{\\\"SINGLE\\\":\\\"趸交\\\",\\\"ANNUAL\\\":\\\"年交\\\"}}', 'ANNUAL')";
        String initSql112 = "( 'goodsCode', 'riskCode', '', 'permissionId', 'PAY_YEAR', 'ENUMERATION', '{\\\"scopeMap\\\":{\\\"1000\\\":\\\"一次性交清\\\",\\\"3\\\":\\\"3年\\\",\\\"5\\\":\\\"5年\\\",\\\"10\\\":\\\"10年\\\"}}', '10')";


        String sql2 = "INSERT INTO `goods_rule_channel_relation` ( `goods_code`, `risk_code`, `plan_code`, `permission_id`, `channel_rule_relation_code`, `channel_rule_relation_name`, `content_type`, `rule_type`, `rule_control_type`) VALUES";
        String initSql22 = "( 'goodsCode', 'riskCode', '', 'permissionId', 'orgCode_1', '缴费频次控制浮动与交费期间', 'A_TRAIL_RISKS_FREQUENCY', 'PAY_FREQUENCY', 'ENUMERATION')";

        String sql3 = "INSERT INTO `goods_rule_channel_relation_info` ( `goods_code`, `risk_code`, `plan_code`, `permission_id`, `channel_rule_relation_code`, `main_content_type`, `main_rule_type`, `main_content_control_scope`, `main_rule_control_type`, `content_type`, `control_rule_type`, `rule_control_type`, `control_scope`, `default_info`) VALUES";
        String initSql33 = "('goodsCode', 'riskCode', '', 'permissionId', 'orgCode_1'," +
                //主规则
                " 'A_TRAIL_RISKS_FREQUENCY', 'PAY_FREQUENCY', '{\\\"scopeMap\\\":{\\\"ANNUAL\\\":\\\"年交\\\",\\\"MONTHLY\\\":\\\"月交\\\"}}', 'ENUMERATION', " +
                //副规则
                "'A_TRAIL_RISKS_PAYENDYEAR', 'PAY_YEAR', 'ENUMERATION', '{\\\"scopeMap\\\":{\\\"3\\\":\\\"3年\\\",\\\"5\\\":\\\"5年\\\",\\\"10\\\":\\\"10年\\\"}}', '10')";
        String initSql332 =
                "('goodsCode', 'riskCode', '', 'permissionId', 'orgCode_1'," +
                        //主规则
                        " 'A_TRAIL_RISKS_FREQUENCY', 'PAY_FREQUENCY', '{\\\"scopeMap\\\":{\\\"SINGLE\\\":\\\"趸交\\\"}}', 'ENUMERATION', " +
                        //副规则
                        "'A_TRAIL_RISKS_PAYENDYEAR', 'PAY_YEAR', 'ENUMERATION', '{\\\"scopeMap\\\":{\\\"1000\\\":\\\"一次性交清\\\"}}', '1000')";


        String goodsCode = "A1410001";
        String riskCode = "14100";
        String addRiskCode = "14140";
        boolean addRiskFlag = true;

        String sql11 = initSql11.replaceAll("goodsCode", goodsCode).replaceAll("riskCode", riskCode);
        String sql112 = initSql112.replaceAll("goodsCode", goodsCode).replaceAll("riskCode", riskCode);
        String sql22 = initSql22.replaceAll("goodsCode", goodsCode).replaceAll("riskCode", riskCode);
        String sql33 = initSql33.replaceAll("goodsCode", goodsCode).replaceAll("riskCode", riskCode);
        String sql332 = initSql332.replaceAll("goodsCode", goodsCode).replaceAll("riskCode", riskCode);
        //附加险
        String sql11add = initSql11.replaceAll("goodsCode", goodsCode).replaceAll("riskCode", addRiskCode);
        String sql112add = initSql112.replaceAll("goodsCode", goodsCode).replaceAll("riskCode", addRiskCode);
        String sql22add = initSql22.replaceAll("goodsCode", goodsCode).replaceAll("riskCode", addRiskCode);
        String sql33add = initSql33.replaceAll("goodsCode", goodsCode).replaceAll("riskCode", addRiskCode);
        String sql332add = initSql332.replaceAll("goodsCode", goodsCode).replaceAll("riskCode", addRiskCode);
        String[] split = TestConstants.get渠道特殊配置0729.split("\n");
        //"1\tC00013440604415\t臻享一生养老年金\tA1409001\t32EBBD3CED435BB82CEA227B6E5DF680\n"
        System.out.println();
        System.out.println();

        System.out.println(sql1);
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            String[] ss = s.split("\t");
            System.out.print(sql11.replaceAll("orgCode", ss[1]).replaceAll("permissionId", ss[4]));
            System.out.println(",");
            System.out.print(sql112.replaceAll("orgCode", ss[1]).replaceAll("permissionId", ss[4]));
            if (addRiskFlag) {
                System.out.println(",");
                System.out.print(sql11add.replaceAll("orgCode", ss[1]).replaceAll("permissionId", ss[4]));
                System.out.println(",");
                System.out.print(sql112add.replaceAll("orgCode", ss[1]).replaceAll("permissionId", ss[4]));
            }
            if (i < split.length - 1) {
                System.out.println(",");
            } else {
                System.out.println(";");
            }
        }
        System.out.println();
        System.out.println();
        System.out.println(sql2);
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            String[] ss = s.split("\t");
            System.out.print(sql22.replaceAll("orgCode", ss[1]).replaceAll("permissionId", ss[4]));
            if (addRiskFlag) {
                System.out.println(",");
                System.out.print(sql22add.replaceAll("orgCode", ss[1]).replaceAll("permissionId", ss[4]));
            }
            if (i < split.length - 1) {
                System.out.println(",");
            } else {
                System.out.println(";");
            }
        }
        System.out.println();
        System.out.println();
        System.out.println(sql3);
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            String[] ss = s.split("\t");
            System.out.print(sql33.replaceAll("orgCode", ss[1]).replaceAll("permissionId", ss[4]));
            System.out.println(",");
            System.out.print(sql332.replaceAll("orgCode", ss[1]).replaceAll("permissionId", ss[4]));
            if (addRiskFlag) {
                System.out.println(",");
                System.out.print(sql33add.replaceAll("orgCode", ss[1]).replaceAll("permissionId", ss[4]));
                System.out.println(",");
                System.out.print(sql332add.replaceAll("orgCode", ss[1]).replaceAll("permissionId", ss[4]));
            }
            if (i < split.length - 1) {
                System.out.println(",");
            } else {
                System.out.println(";");
            }
        }
        System.out.println();


        System.out.println();
    }

    @Test
    public void test0003() {
        String sql1 =
                "INSERT INTO `goods_rule_channel` ( `goods_code`,`risk_code`, `plan_code`, `permission_id`, `rule_type`, `rule_control_type`, `rule_scope`, `default_info`) VALUES";
        String initSql11 = "( 'goodsCode', 'riskCode', '', 'permissionId', 'PAY_FREQUENCY', 'ENUMERATION', '{\\\"scopeMap\\\":{\\\"SINGLE\\\":\\\"趸交\\\",\\\"ANNUAL\\\":\\\"年交\\\"}}', 'ANNUAL')";
        String initSql112 = "( 'goodsCode', 'riskCode', '', 'permissionId', 'PAY_YEAR', 'ENUMERATION', '{\\\"scopeMap\\\":{\\\"1000\\\":\\\"一次性交清\\\",\\\"3\\\":\\\"3年\\\",\\\"5\\\":\\\"5年\\\",\\\"10\\\":\\\"10年\\\"}}', '10')";


        String sql2 = "INSERT INTO `goods_rule_channel_relation` ( `goods_code`, `risk_code`, `plan_code`, `permission_id`, `channel_rule_relation_code`, `channel_rule_relation_name`, `content_type`, `rule_type`, `rule_control_type`) VALUES";
        String initSql22 = "( 'goodsCode', 'riskCode', '', 'permissionId', 'orgCode_1', '缴费频次控制浮动与交费期间', 'A_TRAIL_RISKS_FREQUENCY', 'PAY_FREQUENCY', 'ENUMERATION')";

        String sql3 = "INSERT INTO `goods_rule_channel_relation_info` ( `goods_code`, `risk_code`, `plan_code`, `permission_id`, `channel_rule_relation_code`, `main_content_type`, `main_rule_type`, `main_content_control_scope`, `main_rule_control_type`, `content_type`, `control_rule_type`, `rule_control_type`, `control_scope`, `default_info`) VALUES";
        String initSql33 = "('goodsCode', 'riskCode', '', 'permissionId', 'orgCode_1'," +
                //主规则
                " 'A_TRAIL_RISKS_FREQUENCY', 'PAY_FREQUENCY', '{\\\"scopeMap\\\":{\\\"ANNUAL\\\":\\\"年交\\\",\\\"MONTHLY\\\":\\\"月交\\\"}}', 'ENUMERATION', " +
                //副规则
                "'A_TRAIL_RISKS_PAYENDYEAR', 'PAY_YEAR', 'ENUMERATION', '{\\\"scopeMap\\\":{\\\"3\\\":\\\"3年\\\",\\\"5\\\":\\\"5年\\\",\\\"10\\\":\\\"10年\\\"}}', '10')";
        String initSql332 =
                "('goodsCode', 'riskCode', '', 'permissionId', 'orgCode_1'," +
                        //主规则
                        " 'A_TRAIL_RISKS_FREQUENCY', 'PAY_FREQUENCY', '{\\\"scopeMap\\\":{\\\"SINGLE\\\":\\\"趸交\\\"}}', 'ENUMERATION', " +
                        //副规则
                        "'A_TRAIL_RISKS_PAYENDYEAR', 'PAY_YEAR', 'ENUMERATION', '{\\\"scopeMap\\\":{\\\"1000\\\":\\\"一次性交清\\\"}}', '1000')";


        String goodsCode = "A1410001";
        String riskCode = "14100";
        String addRiskCode = "14140";
        boolean addRiskFlag = true;

        String sql11 = initSql11.replaceAll("goodsCode", goodsCode).replaceAll("riskCode", riskCode);
        String sql112 = initSql112.replaceAll("goodsCode", goodsCode).replaceAll("riskCode", riskCode);
        String sql22 = initSql22.replaceAll("goodsCode", goodsCode).replaceAll("riskCode", riskCode);
        String sql33 = initSql33.replaceAll("goodsCode", goodsCode).replaceAll("riskCode", riskCode);
        String sql332 = initSql332.replaceAll("goodsCode", goodsCode).replaceAll("riskCode", riskCode);
        //附加险
        String sql11add = initSql11.replaceAll("goodsCode", goodsCode).replaceAll("riskCode", addRiskCode);
        String sql112add = initSql112.replaceAll("goodsCode", goodsCode).replaceAll("riskCode", addRiskCode);
        String sql22add = initSql22.replaceAll("goodsCode", goodsCode).replaceAll("riskCode", addRiskCode);
        String sql33add = initSql33.replaceAll("goodsCode", goodsCode).replaceAll("riskCode", addRiskCode);
        String sql332add = initSql332.replaceAll("goodsCode", goodsCode).replaceAll("riskCode", addRiskCode);
        String[] split = TestConstants.get渠道特殊配置0729_02.split("\n");
        //"1\tC00013440604415\t臻享一生养老年金\tA1409001\t32EBBD3CED435BB82CEA227B6E5DF680\n"
        System.out.println();
        System.out.println();

        System.out.println(sql1);
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            String[] ss = s.split("\t");
            System.out.print(sql11.replaceAll("orgCode", ss[1]).replaceAll("permissionId", ss[4]));
            System.out.println(",");
            System.out.print(sql112.replaceAll("orgCode", ss[1]).replaceAll("permissionId", ss[4]));
            if (addRiskFlag) {
                System.out.println(",");
                System.out.print(sql11add.replaceAll("orgCode", ss[1]).replaceAll("permissionId", ss[4]));
                System.out.println(",");
                System.out.print(sql112add.replaceAll("orgCode", ss[1]).replaceAll("permissionId", ss[4]));
            }
            if (i < split.length - 1) {
                System.out.println(",");
            } else {
                System.out.println(";");
            }
        }
        System.out.println();
        System.out.println();
        System.out.println(sql2);
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            String[] ss = s.split("\t");
            System.out.print(sql22.replaceAll("orgCode", ss[1]).replaceAll("permissionId", ss[4]));
            if (addRiskFlag) {
                System.out.println(",");
                System.out.print(sql22add.replaceAll("orgCode", ss[1]).replaceAll("permissionId", ss[4]));
            }
            if (i < split.length - 1) {
                System.out.println(",");
            } else {
                System.out.println(";");
            }
        }
        System.out.println();
        System.out.println();
        System.out.println(sql3);
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            String[] ss = s.split("\t");
            System.out.print(sql33.replaceAll("orgCode", ss[1]).replaceAll("permissionId", ss[4]));
            System.out.println(",");
            System.out.print(sql332.replaceAll("orgCode", ss[1]).replaceAll("permissionId", ss[4]));
            if (addRiskFlag) {
                System.out.println(",");
                System.out.print(sql33add.replaceAll("orgCode", ss[1]).replaceAll("permissionId", ss[4]));
                System.out.println(",");
                System.out.print(sql332add.replaceAll("orgCode", ss[1]).replaceAll("permissionId", ss[4]));
            }
            if (i < split.length - 1) {
                System.out.println(",");
            } else {
                System.out.println(";");
            }
        }
        System.out.println();


        System.out.println();
    }
}

