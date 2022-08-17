package work;

import org.junit.Test;
import utils.LogicUtil;

import java.math.BigDecimal;

public class CalculationTest {
    private static String cal = "{\"co\":\"#{SOCIAL_SECURITY}#==1\",\"calCo\":{\"co\":\"#{AMOUNT}#<=2000\",\"calCo\":{\"co\":\"#{JOB_LEVEL}#==1\",\"cal\":\"29\",\"elCo\":{\"co\":\"#{JOB_LEVEL}#==2\",\"cal\":\"36\",\"elCo\":{\"co\":\"#{JOB_LEVEL}#==3\",\"cal\":\"43\",\"elCo\":{\"co\":\"#{JOB_LEVEL}#==4\",\"cal\":\"64\",\"elCo\":{\"co\":\"#{JOB_LEVEL}#==5\",\"cal\":\"100\",\"elCo\":{\"co\":\"#{JOB_LEVEL}#==6\",\"cal\":\"128\",\"elCa\":\"0\"}}}}}},\"elCo\":{\"co\":\"#{JOB_LEVEL}#==1\",\"cal\":\"29 + 6 * (#{AMOUNT}# - 2000) / 1000 \",\"elCo\":{\"co\":\"#{JOB_LEVEL}#==2\",\"cal\":\"36+ 7* (#{AMOUNT}# - 2000) / 1000\",\"elCo\":{\"co\":\"#{JOB_LEVEL}#==3\",\"cal\":\"43+9 * (#{AMOUNT}# - 2000) / 1000\",\"elCo\":{\"co\":\"#{JOB_LEVEL}#==4\",\"cal\":\"64+ 13 * (#{AMOUNT}# - 2000) / 1000\",\"elCo\":{\"co\":\"#{JOB_LEVEL}#==5\",\"cal\":\"100+ 20* (#{AMOUNT}# - 2000) / 1000\",\"elCo\":{\"co\":\"#{JOB_LEVEL}#==6\",\"cal\":\"128+26 * (#{AMOUNT}# - 2000) / 1000\",\"elCa\":\"0\"}}}}}}},\"elCo\":{\"co\":\"#{AMOUNT}#<=2000\",\"calCo\":{\"co\":\"#{JOB_LEVEL}#==1\",\"cal\":\"36\",\"elCo\":{\"co\":\"#{JOB_LEVEL}#==2\",\"cal\":\"45\",\"elCo\":{\"co\":\"#{JOB_LEVEL}#==3\",\"cal\":\"54\",\"elCo\":{\"co\":\"#{JOB_LEVEL}#==4\",\"cal\":\"81\",\"elCo\":{\"co\":\"#{JOB_LEVEL}#==5\",\"cal\":\"126\",\"elCo\":{\"co\":\"#{JOB_LEVEL}#==6\",\"cal\":\"162\",\"elCa\":\"0\"}}}}}},\"elCo\":{\"co\":\"#{JOB_LEVEL}#==1\",\"cal\":\"36 +7 * (#{AMOUNT}# - 2000) / 1000 \",\"elCo\":{\"co\":\"#{JOB_LEVEL}#==2\",\"cal\":\"45+ 9* (#{AMOUNT}# - 2000) / 1000\",\"elCo\":{\"co\":\"#{JOB_LEVEL}#==3\",\"cal\":\"54+ 11 * (#{AMOUNT}# - 2000) / 1000\",\"elCo\":{\"co\":\"#{JOB_LEVEL}#==4\",\"cal\":\"81+ 16 * (#{AMOUNT}# - 2000) / 1000\",\"elCo\":{\"co\":\"#{JOB_LEVEL}#==5\",\"cal\":\"126+ 25 * (#{AMOUNT}# - 2000) / 1000\",\"elCo\":{\"co\":\"#{JOB_LEVEL}#==6\",\"cal\":\"162+  32 * (#{AMOUNT}# - 2000) / 1000\",\"elCa\":\"0\"}}}}}}}}";

    @Test
    public void cal() {
        String job = "1";
        String socialSecurity = "1";
        BigDecimal amount = new BigDecimal("1000");
        String rate = "1000";
        for (int k = 0; k < 6; k++) {
            amount = amount.add(new BigDecimal(1000));
            System.out.println("保额  " + amount.toString());

            for (int j = 0; j < 2; j++) {
                socialSecurity = j + "";
                System.out.println(" 社保 " + socialSecurity);
                for (int i = 0; i < 6; i++) {
                    job = (i + 1) + "";
                    String replaceAll = cal
                            .replace("#{SOCIAL_SECURITY}#", socialSecurity)
                            .replace("#{AMOUNT}#", amount.toString())
                            .replace("#{PREMIUM_RATE}#", rate)
                            .replace("#{JOB_LEVEL}#", job)
                            .replace(" ", "");
                    System.out.print("职业等级" + job + "       ");
                    System.out.println(LogicUtil.getResult(replaceAll));
                }
            }
        }
    }

    private String rt17090 = "(0, 411, 1, 28, 2);\n" +
            " (1, 411, 1, 28, 2);\n" +
            " (2, 411, 1, 28, 2);\n" +
            " (3, 411, 1, 28, 2);\n" +
            " (4, 411, 1, 28, 2);\n" +
            " (5, 411, 1, 28, 2);\n" +
            " (6, 155, 1, 10, 3);\n" +
            " (7, 155, 1, 10, 3);\n" +
            " (8, 155, 1, 10, 3);\n" +
            " (9, 155, 1, 10, 3);\n" +
            " (10, 155, 1, 10, 3);\n" +
            " (11, 73, 1, 5, 3);\n" +
            " (12, 73, 1, 5, 3);\n" +
            " (13, 73, 1, 5, 3);\n" +
            " (14, 73, 1, 5, 3);\n" +
            " (15, 73, 1, 5, 3);\n" +
            " (16, 59, 1, 4, 5);\n" +
            " (17, 59, 1, 4, 5);\n" +
            " (18, 59, 1, 4, 5);\n" +
            " (19, 59, 1, 4, 5);\n" +
            " (20, 59, 1, 4, 5);\n" +
            " (21, 65, 2, 4, 6);\n" +
            " (22, 65, 2, 4, 6);\n" +
            " (23, 65, 2, 4, 6);\n" +
            " (24, 65, 2, 4, 6);\n" +
            " (25, 65, 2, 4, 6);\n" +
            " (26, 109, 4, 6, 10);\n" +
            " (27, 109, 4, 6, 10);\n" +
            " (28, 109, 4, 6, 10);\n" +
            " (29, 109, 4, 6, 10);\n" +
            " (30, 109, 4, 6, 10);\n" +
            " (31, 162, 6, 8, 14);\n" +
            " (32, 162, 6, 8, 14);\n" +
            " (33, 162, 6, 8, 14);\n" +
            " (34, 162, 6, 8, 14);\n" +
            " (35, 162, 6, 8, 14);\n" +
            " (36, 235, 11, 13, 25);\n" +
            " (37, 235, 11, 13, 25);\n" +
            " (38, 235, 11, 13, 25);\n" +
            " (39, 235, 11, 13, 25);\n" +
            " (40, 235, 11, 13, 25);\n" +
            " (41, 319, 18, 21, 43);\n" +
            " (42, 319, 18, 21, 43);\n" +
            " (43, 319, 18, 21, 43);\n" +
            " (44, 319, 18, 21, 43);\n" +
            " (45, 319, 18, 21, 43);\n" +
            " (46, 450, 25, 30, 71);\n" +
            " (47, 450, 25, 30, 71);\n" +
            " (48, 450, 25, 30, 71);\n" +
            " (49, 450, 25, 30, 71);\n" +
            " (50, 450, 25, 30, 71);\n" +
            " (51, 611, 35, 44, 120);\n" +
            " (52, 611, 35, 44, 120);\n" +
            " (53, 611, 35, 44, 120);\n" +
            " (54, 611, 35, 44, 120);\n" +
            " (55, 611, 35, 44, 120);\n" +
            " (56, 749, 44, 58, 215);\n" +
            " (57, 749, 44, 58, 215);\n" +
            " (58, 749, 44, 58, 215);\n" +
            " (59, 749, 44, 58, 215);\n" +
            " (60, 749, 44, 58, 215);\n" +
            " (61, 859, 56, 70, 457);\n" +
            " (62, 859, 56, 70, 457);\n" +
            " (63, 859, 56, 70, 457);\n" +
            " (64, 859, 56, 70, 457);\n" +
            " (65, 859, 56, 70, 457);\n" +
            " (66, 1289, 83, 105, 548);\n" +
            " (67, 1289, 83, 105, 548);\n" +
            " (68, 1289, 83, 105, 548);\n" +
            " (69, 1289, 83, 105, 548);\n" +
            " (70, 1289, 83, 105, 548);";

    @Test
    public void cal01() {
        System.out.println();
        System.out.println();
        System.out.println("DROP TABLE IF EXISTS `rate_hq_17090`;\n" +
                "CREATE TABLE `rate_hq_17090` (\n" +
                "  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '物理ID',\n" +
                "  `risk_code` varchar(32) NOT NULL COMMENT '险种',\n" +
                "  `duty_code` varchar(32) NOT NULL COMMENT '责任',\n" +
                "  `amount` decimal(16,6) NOT NULL COMMENT '保额',\n" +
                "  `age`  int(8)  NOT NULL COMMENT '年龄',\n"+
                "  `premium_rate` decimal(16,6) NOT NULL COMMENT '保费费率', \n" +
                "  PRIMARY KEY (`id`) USING BTREE\n" +
                ") ENGINE=InnoDB ROW_FORMAT=DYNAMIC COMMENT='横琴17090费率';\n" +
                " ");
        int aa = 0;
        //ID7090	一般住院日额津贴
        //ID7091	“恶性肿瘤——重度”住院日额津贴
        //ID7092	重症监护日额津贴
        //ID7093	手术医疗津贴
        String dutyCodes = "ID7090\n" +
                "ID7091\n" +
                "ID7092\n" +
                "ID7093";
        String[] dutyCodeSplit = dutyCodes.split("\n");
        for (String cal : rt17090.replace("(", "").replace(")", "").replace(";", "").replace(" ", "").split("\n")) {
            String[] split = cal.split(",");
            for (int i = 0; i < 4; i++) {
                System.out.print("INSERT INTO `rate_hq_17090` VALUES (");
                System.out.print( " "+ (++aa) +", 17090, '"+dutyCodeSplit[i] +"', 100, "+split[0]+", ");
                System.out.println( split[(i+1)]+");" );

            }

        }

        System.out.println();
        System.out.println();

    }
}
