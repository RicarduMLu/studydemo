package work;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

public class JavaTest {

    @Test
    public void getUrls() {
        boolean innerFlag = false;
        JSONObject jsonObject = JSON.parseObject(TestConstants.fileUrls1);
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
            if (i < parseArray.size()-1) {
                System.out.print(",");
            }
        }

    }
}
