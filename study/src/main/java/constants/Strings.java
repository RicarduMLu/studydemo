package constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Jianguo Luo
 * @date 2021/4/3
 * @Description 通用字符串常量
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Strings {

    public static final String COMMA = ",";

    public static final String EMPTY = "";

    public static final String TRUE = "true";

    public static final String FALSE = "false";

    public static final String DB_FIELD_ID = "id";

    public static final String DB_FIELD_CREATE_TIME = "create_time";

    public static final String DB_FIELD_UPDATE_TIME = "update_time";

    public static final String CURRENT_PAGE_MSG = "当前页码";

    public static final String SIZE_PAGE_MSG = "每页显示记录数";

    public static final String REGEX_ID = "^[1-9]\\d*$";

    public static final String REGEX_STRING = "[a-zA-Z0-9_]+";

}
