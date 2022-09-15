package work;

import com.csvreader.CsvReader;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import utils.JsonUtil;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class 费率表生成 {
    private String 费率表保存路径 = "E:\\File\\JavaText\\studydemo\\study\\src\\main\\resources\\费率表";
    private String 费率表14190 = "E:\\File\\work\\2022.Q3\\费率表\\14190横琴臻享久久养老年金_上线数据.csv";
    private String 费率表14180 = "E:\\File\\work\\2022.Q3\\费率表\\rt_14180.sql";




    @Test
    public void csv14180() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(费率表保存路径 + "\\14180.sql"));
            InputStream is = new FileInputStream(费率表14180);
            List<String> strings = IOUtils.readLines(is, "UTF-8");
            int lineSize = 0;
            int id = 1;
            for (String sqlStr : strings) {
                System.out.println(lineSize);
                lineSize++;
                if (lineSize < 62 || StringUtils.isEmpty(sqlStr) || !sqlStr.contains("INSERT INTO `rt_14180` VALUES")) {
                    bw.write(sqlStr);
                    bw.newLine();
                    continue;
                }
                bw.write(sqlStr
                        .replace(" `rt_14180` ","`rate_hq_14180`")
                        .replace(" 'Y'","true")
                        .replace(" 'N'","false")
                        .replace(".000000","")
                        .replace(", ",",")
                );
                bw.newLine();
                if (lineSize > 100) {
                    break;
                }
            }
            bw.flush();
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }






    @Test
    public void csv() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(费率表保存路径 + "\\14190.sql"));
            CsvReader reader = new CsvReader(费率表14190, ',', StandardCharsets.UTF_8);
            int lineSize = 0;
            int id = 1;
            bw.write(表14190);
            bw.flush();
            while (reader.readRecord()) {
                lineSize++;
                String[] values = reader.getValues();
                if (lineSize < 3) {
                    System.out.println(JsonUtil.toJSON(values));
                    continue;
                }
                if (StringUtils.isEmpty(values[2])) {
                    break;
                }
                String insert = "INSERT INTO `rate_hq_14190` VALUES ("
                        + (id++) + ","   //`id`
                        + "14190,"     //`risk_code`
                        + "'ID4190',"    //`duty_code`
                        + values[2] + ","  //`amount_rate`
                        + values[3] + ","  // `gender`
                        + values[4] + ","  //`insurance_period`
                        + values[5] + ","  //`pay_period`
                        + ("Y".equals(values[7]) ? "true" : "false") + ","  //`is_insurance_expiry`
                        + ("Y".equals(values[8]) ? "true" : "false") + ","  // `is_pay_expiry`
                        + values[6] + ","   // `annuity_age`
                        + values[1] + ","  //`annuity_guaranteed_period`
                        + values[9] + "," //`age`
                        + values[10] + "," //`year`
                        + values[11] + ","  //`premium_rate`
                        + values[12] + ","  //`premium_cv`
                        + values[13] + ","  // `begin_cv`
                        + values[14] + ","  //`enb_cv`
                        + values[15] + ","  //`begsur`
                        + values[16] + ","  //`endsur`
                        + values[17] + ","  //`begben`
                        + values[18] + ","  // `endben`
                        + values[19] + ","  //`prem_val`
                        + values[20] + ","  // `begre`
                        + values[21] + ","  //`endre`
                        + values[22] + ","  // `hig_div`
                        + values[23] + ","  //`avg_div`
                        + values[24] + ","  //`low_div`
                        + values[25] + ","  //`hig_acc`
                        + values[26] + ","  // `avg_acc`
                        + values[27] + ""  //`low_acc`
                        + ");";
                bw.newLine();
                bw.write(insert);
            }
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String 表14190 = "DROP TABLE IF EXISTS `rate_hq_14190`;\n" +
            "CREATE TABLE `rate_hq_14190` (\n" +
            "  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '物理ID',\n" +
            "  `risk_code` varchar(32)  NOT NULL COMMENT '险种',\n" +
            "  `duty_code` varchar(32)  NOT NULL COMMENT '责任',\n" +
            "  `amount_rate` decimal(16,6) NOT NULL COMMENT '保额费率',\n" +
            "  `gender` varchar(2)  NOT NULL COMMENT '性别（0为男性，1为女性，X为不区分性别）',\n" +
            "  `insurance_period` int(8) NOT NULL COMMENT '保险期间(年)',\n" +
            "  `pay_period` int(8) NOT NULL COMMENT '交费期间（年）',\n" +
            "  `is_insurance_expiry` bit(1) NOT NULL COMMENT '保险期限是否为岁满期（如保至60岁，1为是，0为否）',\n" +
            "  `is_pay_expiry` bit(1) NOT NULL COMMENT '交费期限是否为岁满期（如交至60岁，1为是，0为否）',\n" +
            "  `annuity_age` int(8) NOT NULL COMMENT '养老年金领取年龄',\n" +
            "  `annuity_guaranteed_period` int(8) NOT NULL COMMENT '养老年金保障领取期间值',\n" +
            "  `age` int(8) NOT NULL COMMENT '年龄',\n" +
            "  `year` int(8) NOT NULL COMMENT '保单年度',\n" +
            "  `premium_rate` decimal(16,6) NOT NULL COMMENT '保费费率',\n" +
            "  `premium_cv` decimal(16,6) DEFAULT NULL COMMENT '计算现金价值采用的当年保费',\n" +
            "  `begin_cv` decimal(16,6) DEFAULT NULL COMMENT '年初现价',\n" +
            "  `enb_cv` decimal(16,6) DEFAULT NULL COMMENT '年末现价',\n" +
            "  `begsur` decimal(8,0) DEFAULT NULL COMMENT '年初生存给付',\n" +
            "  `endsur` decimal(8,0) DEFAULT NULL COMMENT '年末生存给付',\n" +
            "  `begben` decimal(8,0) DEFAULT NULL COMMENT '年初未来保险利益的现值',\n" +
            "  `endben` decimal(8,0) DEFAULT NULL COMMENT '年末未来保险利益的现值',\n" +
            "  `prem_val` decimal(16,6) DEFAULT NULL COMMENT '评估准备金采用的当年保费',\n" +
            "  `begre` decimal(16,6) DEFAULT NULL COMMENT '年初法定准备金',\n" +
            "  `endre` decimal(16,6) DEFAULT NULL COMMENT '年末法定准备金',\n" +
            "  `hig_div` decimal(16,6) DEFAULT NULL COMMENT '年度红利（高）',\n" +
            "  `avg_div` decimal(16,6) DEFAULT NULL COMMENT '年度红利（中）',\n" +
            "  `low_div` decimal(16,6) DEFAULT NULL COMMENT '年度红利（低）',\n" +
            "  `hig_acc` decimal(16,6) DEFAULT NULL COMMENT '累积红利（高）',\n" +
            "  `avg_acc` decimal(16,6) DEFAULT NULL COMMENT '累积红利（中）',\n" +
            "  `low_acc` decimal(16,6) DEFAULT NULL COMMENT '累积红利（低）',\n" +
            "  PRIMARY KEY (`id`) USING BTREE,\n" +
            "  KEY `idx_year_age` (`year`,`age`) USING BTREE\n" +
            ") ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='横琴14190费率';";
}
