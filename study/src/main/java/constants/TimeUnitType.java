package constants;

/**
 * 时间单位
 *
 * @author lzj10
 * @date 2021-05-26
 */
public enum TimeUnitType {
    /**
     * 单位
     */
    LIFELONG("终身"),
    AGE("岁"),
    YEAR("年"),
    QUARTER("季"),
    HALF_YEAR("半年"),
    MONTH("月"),
    DAY("天"),
    HOUR("时"),
    MINUTE("分"),
    SECOND("秒"),
    MILLISECOND("毫秒"),
    ;
    private final String label;

    TimeUnitType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }

    public static boolean isValid(String name) {
        return get(name) != null;
    }

    public static TimeUnitType get(String name) {
        for (TimeUnitType value : TimeUnitType.values()) {
            if (value.name().equals(name)) {
                return value;
            }
        }
        return null;
    }

    public static String getLabel(String name) {
        for (TimeUnitType value : TimeUnitType.values()) {
            if (value.name().equals(name)) {
                return value.label;
            }
        }
        return null;
    }
}
