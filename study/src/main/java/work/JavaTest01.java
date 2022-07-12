package work;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import utils.FileUrlUtils;

public class JavaTest01 {
    @Test
    public void getUrls() {
        System.out.println();
        System.out.println();
        boolean innerFlag = false;
        JSONArray parseArray = FileUrlUtils.getUrl(TestConstants.fileUrls16590免责);
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
}
