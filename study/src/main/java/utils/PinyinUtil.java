package utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.apache.commons.lang3.StringUtils;

public class PinyinUtil {

    public static void main(String[] args) throws Exception {
        System.out.println(getPinyin("hahaa啊啊啊啊啊啊啊啊啊啊", " "));
        System.out.println(getPinyinInitials("阿萨达"));
    }

    /**
     * 将汉字转换为全拼
     *
     * @param text      文本
     * @param separator 分隔符
     * @return {@link String}
     */
    public static String getPinyin(String text, String separator) {
        char[] chars = text.toCharArray();
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        // 设置大小写
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        // 设置声调表示方法
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        // 设置字母u表示方法
        format.setVCharType(HanyuPinyinVCharType.WITH_V);
        String[] s;
        String rs = StringUtils.EMPTY;
        try {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < chars.length; i++) {
                // 判断是否为汉字字符
                if (String.valueOf(chars[i]).matches("[\\u4E00-\\u9FA5]+")) {
                    s = PinyinHelper.toHanyuPinyinStringArray(chars[i], format);
                    if (s != null) {
                        sb.append(s[0]).append(separator);
                        continue;
                    }
                }
                sb.append(String.valueOf(chars[i]));
                if ((i + 1 >= chars.length) || String.valueOf(chars[i + 1]).matches("[\\u4E00-\\u9FA5]+")) {
                    sb.append(separator);
                }
            }
            rs = sb.substring(0, sb.length() - 1);
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            e.printStackTrace();
        }
        return rs;
    }

    /**
     * 获取全部汉字首字母
     *
     * @param text 文本
     * @return {@link String}
     */
    public static String getPinyinInitials(String text) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            String[] s = PinyinHelper.toHanyuPinyinStringArray(ch);
            if (s != null) {
                sb.append(s[0].charAt(0));
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    /**
     * 仅获取第一个汉字首字母
     *
     * @param text 文本
     * @return {@link String}
     */
    public static String getFirstPinyinInitials(String text) {
        StringBuilder sb = new StringBuilder();
        char ch = text.charAt(0);
        String[] s = PinyinHelper.toHanyuPinyinStringArray(ch);
        if (s != null) {
            sb.append(s[0].charAt(0));
        } else {
            sb.append(ch);
        }
        return sb.toString();
    }
}