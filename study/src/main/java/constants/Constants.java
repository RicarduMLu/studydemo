package constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Code Generator
 * @since 1.0.0
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Constants {
    public static final String SALT = "HQ";
    public static final String AFTER_TRAIL_SPECIAL_RULE_NAME = "checkSpecialRuleAfterTrail";
    public static final String COMPANY_CHECK_NAME = "checkRule";
    public static final String COMPANY_CHECK_INSURED_NAME = "checkInsuredRule";
    public static final String COMPANY_CHECK_PATH = "com.hqins.insurance.goods.service.impl.rule.RuleCheck_";
    public static final String ZERO = "0";
    public static final BigDecimal ZERO_BIG_DECIMAL = new BigDecimal(ZERO);
    public static final String ONE = "1";
    public static final BigDecimal ONE_BIG_DECIMAL = new BigDecimal(ONE);
    public static final Integer DEFAULT_TIMEOUT = 2;
    public static final String LIMIT_ONE = "LIMIT 1";
    public static final String BASE_CODE = "BASE_CODE";
    public static final BigDecimal THOUSAND = new BigDecimal("1000");
    public static final String THOUSAND_STR = "1000";
    /**
     * 拆分大小
     */
    public static final Integer SPLIT_SIZE = 100;

    public static final String FACTOR_START = "#{";
    public static final String FACTOR_END = "}#";
    public static final String CURLY_BRACKET_START = "{";
    public static final String CURLY_BRACKET_END = "}";
    public static final String PERMISSION_ID_STR = "&permissionId=";
    public static final String AUTH_ID_STR = "&authId=";
    public static final String EMPLOYEE_CODE_STR = "&employeeCode=";
    public static final String AGENT_CODE_STR = "&agentCode=";
    public static final String ORG_TYPE_STR = "&orgType=";
    public static final String FLOW_CONTENT_SEPARATOR = "_#_";

    public static final String UNDERLINE = "_";
    public static final String SEMICOLON = ";";
    public static final String COLON = ":";
    public static final String COLON_CHINA = "：";
    public static final String SEMICOLON_CHINA = "；";
    public static final String DUN_HAO = "、";
    public static final String PERIOD = ".";
    public static final String PERIOD_CHINA = "。";

    public static final String COMMA = ",";
    public static final String COMMA_CHINA = "，";

    public static final String DEFAULT_COMPANY_INFO = "{\"id\":1,\"insuranceCompany\":\"HQINS\",\"insuranceCompanyName\":\"横琴人寿保险有限公司\",\"insuranceCompanyIcon\":\"https://hq-prd-e-zine.oss-cn-szfinance.aliyuncs.com/agent/prd/product/2021/09/15/product_1631675306867.png\",\"insuranceCompanyDesc\":\"横琴人寿保险有限公司是经原中国保险监督管理委员会批准，于2016年成立的全国性寿险公司。\",\"title\":\"实力超群\",\"registeredCapital\":\"20亿元\",\"comprehensiveSolvencyAdequacyRatio\":\"165.08%\",\"totalAssetScale\":\"240亿元\",\"comprehensiveRiskRating\":\"A类\",\"dataToYear\":\"2021\",\"dataAsOfQuarter\":\"三\",\"otherTitle\":\"服务创新\",\"otherDesc\":\"横琴人寿以“家庭保险账户”、“合伙型分销网络”、“数字横琴”三大核心的企业经营与发展战略，产品矩阵日益丰富、数字化能力不断增强、行业排名连年提升、市场影响不断扩大。\",\"createTime\":\"2021-09-15 10:25:30\",\"updateTime\":\"2021-10-22 17:43:58\",\"creatorId\":0,\"creator\":\"\",\"modifierId\":0,\"modifier\":\"\",\"deleted\":false}";

    /**
     * BigDecimal保留位数
     */
    public static final Integer PLACES = 4;
    public static final String BASE_PACKAGE = "com.hqins";
    public static final String DEFAULT = "default";
    public static final String POINT = ".";
    public static final String TURN_POINT = "\\.";
    public static final String SWAGGER = "swagger";
    public static final String SWAGGER_URI = "/swagger-ui/index.html";
    public static final String SLASH = "/";
    public static final String MULTIPLY = "*";
    public static final String STRING_NULL = "";
    public static final String DOUBLE_SLASH = "//";
    public static final String SERVER_SSL_KEY_STORE = "server.ssl.key-store";
    public static final String SERVER_CONTEXT_PATH = "server.servlet.context-path";
    public static final String HTTP = "http";
    public static final String HTTPS = "https";
    public static final String APP_NAME = "spring.application.name";
    public static final String APP_PORT = "server.port";
    public static final String APP_RUN_LOG = "\n---------------------------------------------------------------------------------------\n\t" +
            "Application '{}' is running! Access URLs:\n\t" +
            "Swagger-UI: {}://{}:{}{}/swagger-ui/index.html\n\t" +
            "Profile(s): \t{}" +
            "\n---------------------------------------------------------------------------------------";

}
