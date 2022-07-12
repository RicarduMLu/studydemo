package utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public final class FileUrlUtils {
    public static JSONArray getUrl(String allUrlJson) {
        JSONObject jsonObject = JSON.parseObject(allUrlJson);
        JSONObject data = (JSONObject) jsonObject.get("data");
        return JSON.parseArray(JSON.toJSONString(data.get("fileUrlList")));
    }
}
