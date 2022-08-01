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
            amount = amount.add(new BigDecimal( 1000));
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
                            .replace(" ", "")
                            ;
                    System.out.print("职业等级" + job + "       ");
                    System.out.println(LogicUtil.getResult(replaceAll));
                }
            }
        }
    }

}
