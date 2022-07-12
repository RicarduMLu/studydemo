package work;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import utils.FileUrlUtils;

public class JavaTest01 {
    private static String nacos1 = "    PERSONAL_INFORMATION_PROCESSING_AUTHORIZATION: ";
    private static String nacos2 = "    PERSONAL_INFORMATION_PROCESSING_AUTHORIZATION_OUT: ";
    private static String nacos3 = "    #个人信息处理授权协议 签字版";
    private static String nacos3_1 = "    911201_SIZE_";
    private static String nacos4 = "    #个人信息处理授权协议 千里眼PDF版";
    private static String nacos4_2 = "    911201_PDF_";


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
            System.out.print((i+1)+": ");
            System.out.println(url.get("innerUrl"));
        }
        parseArray = FileUrlUtils.getUrl(TestConstants.个人千里眼PDFFileUrls);
        System.out.println(nacos4);
        for (int i = 0; i < parseArray.size(); i++) {
            Object fileUrlList = parseArray.get(i);
            JSONObject url = (JSONObject) fileUrlList;
            System.out.print(nacos4_2);
            System.out.print((i+1)+": ");
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
}

