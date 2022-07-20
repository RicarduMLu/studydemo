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
    public static void printUrls(String allUrlJson) {
        FileUrlUtils.printUrlsByArray(FileUrlUtils.getUrl(allUrlJson));
    }

    public static void printUrls(String allUrlJson, boolean innerFlag) {
        FileUrlUtils.printUrlsByArray(FileUrlUtils.getUrl(allUrlJson), innerFlag);
    }

    public static void printUrlsByArray(JSONArray array) {
        FileUrlUtils.printUrlsByArray(array, false);
    }

    public static void printUrlsByArray(JSONArray array, boolean innerFlag) {
        System.out.println();
        System.out.println();
        for (int i = 0; i < array.size(); i++) {
            Object fileUrlList = array.get(i);
            JSONObject url = (JSONObject) fileUrlList;
            if (innerFlag) {
                System.out.println(url.get("innerUrl"));
            } else {
                System.out.println(url.get("outerUrl"));
            }
        }
        System.out.println();
        System.out.println();
    }
    public static void printUrlsTogether(String allUrlJson) {
        FileUrlUtils.printUrlsTogetherByArray(FileUrlUtils.getUrl(allUrlJson));
    }

    public static void printUrlsTogether(String allUrlJson, boolean innerFlag) {
        FileUrlUtils.printUrlsTogetherByArray(FileUrlUtils.getUrl(allUrlJson), innerFlag);
    }

    public static void printUrlsTogetherByArray(JSONArray array) {
        FileUrlUtils.printUrlsTogetherByArray(array, false);
    }

    public static void printUrlsTogetherByArray(JSONArray array, boolean innerFlag) {
        System.out.println();
        System.out.println();
        for (int i = 0; i < array.size(); i++) {
            Object fileUrlList = array.get(i);
            JSONObject url = (JSONObject) fileUrlList;
            if (innerFlag) {
                System.out.print(url.get("innerUrl"));
            } else {
                System.out.print(url.get("outerUrl"));
            }
            if (i < array.size() - 1) {
                System.out.print(",");
            }
        }
        System.out.println();
        System.out.println();
    }
}
