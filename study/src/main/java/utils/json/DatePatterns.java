package utils.json;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Jianguo Luo
 * @date 2021/4/4
 * @Description 日期格式
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DatePatterns {
    /**
     * 常规格式
     */
    public static final String YYYY_MM = "yyyy-MM";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String YYYY_MM_DD_HH = "yyyy-MM-dd HH";
    public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String HH_MM_SS = "HH:mm:ss";

    /**
     * 无分隔连续格式
     */
    public static final String CONTINUITY_YYYY_MM = "yyyyMM";
    public static final String CONTINUITY_YYYY_MM_DD = "yyyyMMdd";
    public static final String CONTINUITY_YYYY_MM_DD_HH = "yyyyMMddHH";
    public static final String CONTINUITY_YYYY_MM_DD_HH_MM = "yyyyMMddHHmm";
    public static final String CONTINUITY_YYYY_MM_DD_HH_MM_SS = "yyyyMMddHHmmss";
    public static final String CONTINUITY_YYYY_MM_DD_HH_MM_SS_SSS = "yyyyMMddHHmmssSSS";

    /**
     * 斜线格式
     */
    public static final String SLANT_YYYY_MM = "yyyy/MM";
    public static final String SLANT_YYYY_MM_DD = "yyyy/MM/dd";
    public static final String SLANT_YYYY_MM_DD_HH = "yyyy/MM/dd HH";
    public static final String SLANT_YYYY_MM_DD_HH_MM = "yyyy/MM/dd HH:mm";
    public static final String SLANT_YYYY_MM_DD_HH_MM_SS = "yyyy/MM/dd HH:mm:ss";

    /**
     * 中文格式
     */
    public static final String CHN_YYYY_MM = "yyyy年MM月";
    public static final String CHN_YYYY_MM_DD = "yyyy年MM月dd日";
    public static final String CHN_YYYY_MM_DD_HH = "yyyy年MM月dd日 HH时";
    public static final String CHN_YYYY_MM_DD_HH_MM = "yyyy年MM月dd日 HH时mm分";
    public static final String CHN_YYYY_MM_DD_HH_MM_SS = "yyyy年MM月dd日 HH时mm分ss秒";
}
