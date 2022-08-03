package constants;

/**
 * 登录平台入口类型
 * * IOS - iOS平台 * ANDROID - Android平台 * WXMP - 微信小程序 * WXOFFICIAL - 微信公众号 * WEB - PC网页or移动网页
 */

public enum AppPlatformType {
    WXMP("WXMP"),
    WEB("WEB"),
    WXOFFICIAL("WXOFFICIAL"),
    IOS("IOS"),
    ANDROID("ANDROID"),
    ;

    private String value;

    AppPlatformType(String value) {
        this.value = value;
    }

    public static AppPlatformType fromValue(String text) {
        for (AppPlatformType b : AppPlatformType.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
