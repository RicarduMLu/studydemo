package utils;
import com.alibaba.fastjson.JSON;

/**
 * 打印工具类
 *
 * @author lzj10
 * @create 2020-12-20-宪12:20
 */
public class PR {
    public static void JS(Object o){
        System.out.println(JSON.toJSONString(o));
    }

}
