package work;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

public class JavaTest {

    @Test
    public void getUrls() {
        System.out.println();
        System.out.println();
        boolean innerFlag = false;
//        JSONObject jsonObject = JSON.parseObject(TestConstants.fileUrls16590);
        JSONObject jsonObject = JSON.parseObject(TestConstants.fileUrls16590免责);
        JSONObject data = (JSONObject) jsonObject.get("data");
        JSONArray parseArray = JSON.parseArray(JSON.toJSONString(data.get("fileUrlList")));
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
    public void getUrls2() {
        System.out.println();
        System.out.println();
        boolean innerFlag = true;
        JSONObject jsonObject = JSON.parseObject(TestConstants.fileTemplate2);
//        JSONObject jsonObject = JSON.parseObject(TestConstants.fileTemplate);
        JSONObject data = (JSONObject) jsonObject.get("data");
        JSONArray parseArray = JSON.parseArray(JSON.toJSONString(data.get("fileUrlList")));
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
        JSONObject jsonObject = JSON.parseObject(TestConstants.fileUrl);
//        JSONObject jsonObject = JSON.parseObject(TestConstants.fileTemplate);
        JSONObject data = (JSONObject) jsonObject.get("data");
        JSONArray parseArray = JSON.parseArray(JSON.toJSONString(data.get("fileUrlList")));
        for (int i = 0; i < parseArray.size(); i++) {
            Object fileUrlList = parseArray.get(i);
            JSONObject url = (JSONObject) fileUrlList;
            if (innerFlag) {
            } else {
                System.out.print(url.get("outerUrl") );
                System.out.print("   ");
                System.out.print(url.get("originalFileName") );
            }
            System.out.println();

            if (i < parseArray.size() - 1) {
            }
        }
        System.out.println();

    }
}
