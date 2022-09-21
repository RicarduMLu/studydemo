package work;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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
    public void getUrls22() {
        String sql = "INSERT INTO `goods_rule_relation_info` (`goods_code`, `risk_code`, `plan_code`, `rule_relation_code`, `main_content_type`, `main_rule_type`, `main_content_control_scope`, `main_rule_control_type`, `content_type`, `control_rule_type`, `rule_control_type`, `control_scope`, `default_info`) VALUES ( 'A1419001', '16480', '', 'A1419001_1', '', 'PAY_YEAR', '{\\\"scopeMap\\\":{XXXXXXX}}', 'ENUMERATION', '', 'RECOGNIZE_AGE', 'SCOPE', '{\\\"maxScope\\\":AGEE,\\\"maxScopeUnit\\\":\\\"AGE\\\"}', 'DEFAULT');";
        //交至59周岁  投保人最小16 周岁 最多交费43年
        for (int i = 8; i <44; i++) {

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

