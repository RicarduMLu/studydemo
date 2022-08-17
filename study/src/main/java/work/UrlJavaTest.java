package work;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import constants.TestConstants;
import org.junit.Test;
import utils.FileUrlUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UrlJavaTest {

    @Test
    public void getUrls() {
//        HashMap<String, String> objectObjectHashMap = new LinkedHashMap<>();
//        for (int i = 0; i < 12; i++) {
//            objectObjectHashMap.put((i + 1)+"", (i + 1) + "月");
//        }
//        System.out.println(JSON.toJSONString(objectObjectHashMap));


//        FileUrlUtils.printUrlsTogether(TestConstants.保险条款15180);
//        FileUrlUtils.printUrlsTogether(TestConstants.保险条款15200);
//        FileUrlUtils.printUrlsTogether(TestConstants.保险条款15210);
//        FileUrlUtils.printUrlsTogether(TestConstants.保险条款17070);
        FileUrlUtils.printUrlsTogether(TestConstants.保险条款17090);
//        FileUrlUtils.printUrls(TestConstants.BANNER图片组11140);
    }

    @Test
    public void getUrls4() {
        System.out.println();
        System.out.println();
        JSONArray parseArray = FileUrlUtils.getUrl(TestConstants.新免责声明);
        for (Object o : parseArray) {
            JSONObject url = (JSONObject) o;
            // UPDATE `risk_text`  SET text_info  = 'https:' WHERE `text_type` = 'DISCLAIMERS_TEMPLATE'  AND `insurance_company` = 'HQINS'  AND risk_code =  '11010';
            System.out.print("UPDATE `risk_text`  SET text_info  = '" + url.get("innerUrl") + "' WHERE `text_type` = 'DISCLAIMERS_TEMPLATE'  AND `insurance_company` = 'HQINS'  AND risk_code =  '" + url.get("originalFileName").toString().replace(".pdf","") + "';");
            System.out.println();

        }
        System.out.println();
        System.out.println();
    }



    @Test
    public void getUrls2() {
        System.out.println();
        System.out.println();
        boolean innerFlag = true;
//        JSONArray parseArray =  FileUrlUtils.getUrl(TestConstants.fileTemplate);
        JSONArray parseArray = FileUrlUtils.getUrl(TestConstants.fileTemplate2);
        for (int i = 0; i < parseArray.size(); i++) {
            Object fileUrlList = parseArray.get(i);
            JSONObject url = (JSONObject) fileUrlList;
            if (innerFlag) {
                System.out.println("    911201_PDF_" + (i + 1) + ": " + url.get("innerUrl"));
            } else {
                System.out.print(url.get("outerUrl"));
            }
            if (i < parseArray.size() - 1) {
            }
        }
        System.out.println();

    }

    @Test
    public void getUrls3() {
        System.out.println();
        System.out.println();
        boolean innerFlag = false;
        //SELECT
        //CONCAT( ' map.put("',goods_code,'" , "',goods_name , '" );')
        //FROM
        //	`goods` WHERE flow_type = 'AGENT_FLOW';
        //
        HashMap<String, String> map = new HashMap<>();
        map.put("A1409001", "臻享一生");
        map.put("A1108001", "传世壹号");
        map.put("A1110001", "传世金彩");
        map.put("A1113001", "传世久久");
        map.put("A1412001", "倍珍贵");
        map.put("A1306001", "传世兴家");
        map.put("A1109001", "传世恒富");
        map.put("A1107001", "琴童尊享");
        map.put("A1103001", "传世赢家");
        map.put("A1106001", "永恒金生");
        map.put("A1650001", "琴心保");
        map.put("A3401001", "宜家年金");
        map.put("A3404001", "家庭账户年金");
        map.put("A1654001", "嘉贝保-至尊");
        map.put("A1655001", "嘉贝保-尊享");
        map.put("A1409002", "臻享一生");
        map.put("A1108002", "传世壹号");
        map.put("A1720001", "爱家保");
        map.put("A1646001", "粤港澳大湾区");
        map.put("A1114001", "传世金彩-福享版");
        map.put("A1115001", "传世壹号-悦享版");
        map.put("A1404001", "金禧年年");
        map.put("A1302001", "百万乐途");
        map.put("A1101001", "优爱宝终身");
        map.put("A1714001", "恶性肿瘤特药");
        map.put("A1417001", "琴心如意");
        map.put("A1408001", "福如意");
        map.put("A1203001", "优爱宝定期");
        map.put("A165201653001", "同心保成人");
        map.put("A1653001", "同心保少儿");
        map.put("A1415001", "明爱金生");
        map.put("A1659001", "琴康保");
        HashMap<String, String> map2 = JSON.parseObject(JSON.toJSONString(map), HashMap.class);

        JSONArray parseArray = FileUrlUtils.getUrl(TestConstants.全量图片Url);
        ArrayList<String> pngs = new ArrayList<>();
        for (int i = 0; i < parseArray.size(); i++) {
            Object fileUrlList = parseArray.get(i);
            JSONObject url = (JSONObject) fileUrlList;
            if (innerFlag) {
            } else {
                Object outerUrl = url.get("outerUrl");
                String originalFileName = url.get("originalFileName").toString().replace(".png", "");
                boolean aaa = true;
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (entry.getValue().equals(originalFileName)) {
                        System.out.print("UPDATE `goods_text` SET `text_info` = '" + outerUrl + "'  WHERE `text_type` = 'CHARACTERISTIC_URL' and `goods_code` = '" + entry.getKey() + "' ;");
                        map2.remove(entry.getKey());
                        aaa = false;
                    }
                }
                if (aaa) {
                    pngs.add(originalFileName);
                }
            }
            System.out.println();

            if (i < parseArray.size() - 1) {
            }
        }
        System.out.println("INSERT INTO `goods_text` ( `goods_code`,   `text_type`, `text_name`, `text_info`, `is_must_read`, `sort`) VALUES \n" +
                "( 'A1650001',   'REMINDER_URL', '温馨提示', 'https://hq-prd-e-zine.oss-cn-szfinance.aliyuncs.com/agent/prd/agent/2022/06/22/product_1655890071431.png', false,15);\n");

        System.out.println("缺失的产品" + JSON.toJSONString(map2));
        System.out.println("缺失匹配的图片" + JSON.toJSONString(pngs));
        System.out.println();

    }
}
