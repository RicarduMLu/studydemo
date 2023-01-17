package work;

import com.csvreader.CsvReader;
import org.apache.commons.io.Charsets;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import utils.JsonUtil;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class 费率表生成 {
    private String 费率表保存路径 = "E:\\File\\JavaText\\studydemo\\study\\src\\main\\resources\\费率表";
    private String 费率表14190 = "E:\\File\\work\\2022.Q3\\费率表\\14190横琴臻享久久养老年金_上线数据.csv";
    private String 费率表16600 = "E:\\File\\work\\2023.Q1\\16600_上线数据表.csv";
    private String 费率表14200 = "E:\\File\\work\\2023.Q1\\14200_上线数据表.csv";
    private String 费率表14180 = "E:\\File\\work\\2022.Q3\\费率表\\rt_14180.sql";
    private String 费率表18030 = "E:\\File\\work\\2022.Q3\\费率表\\rt_18030.sql";


    @Test
    public void csv18030() {
        System.out.println("开始读取");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(费率表保存路径 + "\\18030.sql"));
            InputStream is = new FileInputStream(费率表18030);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            System.out.println("读取完毕");
            int lineSize = 0;
            String sqlStr = null;
            long id = 1;
            while ((sqlStr = reader.readLine()) != null) {

                System.out.println(lineSize);
                lineSize++;
                if (lineSize < 59 || StringUtils.isEmpty(sqlStr) || !sqlStr.contains("INSERT INTO `rt_18030` VALUES")) {
                    bw.write(dbSql(sqlStr)
                            .replace("`rt_18030`", "`rate_hq_18030`")
                            .replace("横琴XXX费率", "横琴18030费率")
                    );
                    bw.newLine();
                    continue;
                }
                bw.write(sqlStr
//                        .replace(" `rt_18030` ", "`hqins_insurance_goods_prd`.`rate_hq_18030`")
                                .replace(" `rt_18030` ", "`hqins_insurance_goods_prd`.`rate_hq_18030`")
                                .replace("'18030',", (id++) + ",18030,'ID8030',")
                                .replace(" 'Y', 'N',", "true,false,")
                                .replace(" 'N', 'Y',", "false,true,")
                                .replace(" 'Y', 'Y',", "true,true,")
                                .replace(" 'Y',", "'YEAR',")
                                .replace(".000000,", ",")
                                .replace(".000000)", ")")
                                .replace(", ", ",")
                );
                bw.newLine();
            }
            bw.flush();
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void csv14180() {
        System.out.println("开始读取");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(费率表保存路径 + "\\14180_prd.sql"));
            InputStream is = new FileInputStream(费率表14180);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            System.out.println("读取完毕");
            int lineSize = 0;
            String sqlStr;
            while ((sqlStr = reader.readLine()) != null) {

                System.out.println(lineSize);
                lineSize++;
                if (lineSize < 62 || StringUtils.isEmpty(sqlStr) || !sqlStr.contains("INSERT INTO `rt_14180` VALUES")) {
                    bw.write(sqlStr.replace("`rt_14180`", "`rate_hq_14180`"));
                    bw.newLine();
                    continue;
                }
                bw.write(sqlStr
                        .replace(" `rt_14180` ", "`hqins_insurance_goods_prd`.`rate_hq_14180`")
                        .replace(" 'Y', 'N',", "true,false,")
                        .replace(" 'N', 'Y',", "false,true,")
                        .replace(" 'Y', 'Y',", "true,true,")
                        .replace(" 'Y',", "'YEAR',")
                        .replace(".000000,", ",")
                        .replace(".000000)", ")")
                        .replace(", ", ",")
                );
                bw.newLine();
//                if (lineSize > 100) {
//                    break;
//                }
            }
            bw.flush();
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void csv14190() {
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
                    continue;
                }
                String insert = "INSERT INTO `hqins_insurance_goods_prd`.`rate_hq_14190` VALUES ("
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

    @Test
    public void csv16600() {
        CsvReader reader = null;
        try {
            reader = new CsvReader(费率表16600, ',', StandardCharsets.UTF_8);
        } catch (FileNotFoundException e) {
        }
        String 表SQL = this.表16600;
        String 险种 = "14200";
        String 表名 = "`rate_hq_" + 险种 + "`";
        int 跳过行 = 2;
        try {
            String 环境 = "dat";
            BufferedWriter bw = new BufferedWriter(new FileWriter(费率表保存路径 + "\\" + 险种 + "_" + 环境 + ".sql"));
            int lineSize = 0;
            int id = 1;
            bw.write(表SQL);
            bw.flush();
            while (reader.readRecord()) {
                lineSize++;
                String[] values = reader.getValues();
                if (lineSize < 跳过行) {
                    System.out.println(JsonUtil.toJSON(values));
                    continue;
                }
                if (StringUtils.isEmpty(values[2])) {
                    continue;
                }
                String insert = "INSERT INTO `hqins_insurance_goods_" + 环境 + "`." + 表名 + " VALUES ("
                        + (id++) + ","   //`id`
                        + values[0] + ","    //`risk_code`
                        + "'" + values[1] + "',"   //`duty_code`
                        + values[2] + ","  //`amount_rate`
                        + values[3] + ","  // `gender`
                        + values[4] + ","  //`insurance_period`
                        + values[5] + ","  //`pay_period`
                        + ("Y".equals(values[6]) ? "true" : "false") + ","  //`is_insurance_expiry`
                        + ("Y".equals(values[7]) ? "true" : "false") + ","  // `is_pay_expiry`
                        + values[8] + "," //`age`
                        + values[9] + "," //`year`
                        + values[10].replace(",", "") + ","  //`premium_rate`
                        + values[11].replace(",", "") + ","  //`premium_cv`
                        + values[12].replace(",", "") + ","  // `begin_cv`
                        + values[13].replace(",", "") + ","  //`enb_cv`
                        + values[14].replace(",", "") + ","  //`begsur`
                        + values[15].replace(",", "") + ","  //`endsur`
                        + values[16].replace(",", "") + ","  //`begben`
                        + values[17].replace(",", "") + ","  // `endben`
                        + values[18].replace(",", "") + ","  //`prem_val`
                        + values[19].replace(",", "") + ","  // `begre`
                        + values[20].replace(",", "") + ","  //`endre`
                        + values[21].replace(",", "") + ","  // `hig_div`
                        + values[22].replace(",", "") + ","  //`avg_div`
                        + values[23].replace(",", "") + ","  //`low_div`
                        + values[24].replace(",", "") + ","  //`hig_acc`
                        + values[25].replace(",", "") + ","  // `avg_acc`
                        + values[26].replace(",", "") + ""  //`low_acc`
                        + ");";
                bw.newLine();
                bw.write(insert);
            }
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        String[] split = "uat,prd".split(",");
        try {
            for (String 环境 : split) {
                System.out.println(环境);
                String fileNameDat = 费率表保存路径 + "\\" + 险种 + "_dat.sql";
                String fileName = 费率表保存路径 + "\\" + 险种 + "_" + 环境 + ".sql";
                BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
                InputStream is = new FileInputStream(fileNameDat);
                final BufferedReader readerDat = new BufferedReader(new InputStreamReader(is, Charsets.toCharset("UTF-8")));
                String line;
                while ((line = readerDat.readLine()) != null) {
                    bw.newLine();
                    bw.write(line.replace("dat`.", 环境 + "`."));
                }
                bw.close();

            }
        } catch (Exception e) {
        }
    }

    @Test
    public void csv14200() {
        CsvReader reader = null;
        try {
            reader = new CsvReader(费率表14200, ',', StandardCharsets.UTF_8);
        } catch (FileNotFoundException e) {
        }
        String 表SQL = this.表14200;
        String 险种 = "14200";
        String 责任 = "ID4200";
        String 表名 = "`rate_hq_" + 险种 + "`";
        int 跳过行 = 3;
        try {
            String 环境 = "dat";
            String fileName = 费率表保存路径 + "\\" + 险种 + "_" + 环境 + ".sql";
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            int lineSize = 0;
            int id = 1;
            bw.write(表SQL);
            bw.flush();
            while (reader.readRecord()) {
                lineSize++;
                String[] values = reader.getValues();
                if (lineSize < 跳过行) {
                    System.out.println(JsonUtil.toJSON(values));
                    continue;
                }
                if (StringUtils.isEmpty(values[2])) {
                    continue;
                }
                String insert = "INSERT INTO `hqins_insurance_goods_" + 环境 + "`." + 表名 + " VALUES ("
                        + (id++) + ","   //`id`
                        + "'" + 险种 + "',"     //`risk_code`
                        + "'" + 责任 + "',"   //`duty_code`
                        + values[1] + ","  //`amount_rate`
                        + values[2] + ","  // `gender`
                        + values[3] + ","  //`insurance_period`
                        + values[4] + ","  //`pay_period`
                        + ("Y".equals(values[5]) ? "true" : "false") + ","  //`is_insurance_expiry`
                        + ("Y".equals(values[6]) ? "true" : "false") + ","  // `is_pay_expiry`
                        + values[7] + "," //`get_year`
                        +  " 'YEAR'," //`get_year_flag`
                        + values[8] + "," //`age`
                        + values[9] + "," //`year`
                        + values[10].replace(",", "") + ","  //`premium_rate`
                        + values[11].replace(",", "") + ","  //`premium_cv`
                        + values[12].replace(",", "") + ","  // `begin_cv`
                        + values[13].replace(",", "") + ","  //`enb_cv`
                        + values[14].replace(",", "") + ","  //`begsur`
                        + values[15].replace(",", "") + ","  //`endsur`
                        + values[16].replace(",", "") + ","  //`begben`
                        + values[17].replace(",", "") + ","  // `endben`
                        + values[18].replace(",", "") + ","  //`prem_val`
                        + values[21].replace(",", "") + ","  // `begcre`
                        + values[22].replace(",", "") + ","  //  `endcre`
                        + values[23].replace(",", "") + ","  // `begre`
                        + values[24].replace(",", "") + ","  //`endre`
                        + values[25].replace(",", "") + ","  // `hig_div`
                        + values[26].replace(",", "") + ","  //`avg_div`
                        + values[27].replace(",", "") + ","  //`low_div`
                        + values[28].replace(",", "") + ","  //`hig_acc`
                        + values[29].replace(",", "") + ","  // `avg_acc`
                        + values[30].replace(",", "") + ""  //`low_acc`
                        + ");";
                bw.newLine();
                bw.write(insert);
            }
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] split = "uat,prd".split(",");
        try {
            for (String 环境 : split) {
                System.out.println(环境);
                String fileNameDat = 费率表保存路径 + "\\" + 险种 + "_dat.sql";
                String fileName = 费率表保存路径 + "\\" + 险种 + "_" + 环境 + ".sql";
                BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
                InputStream is = new FileInputStream(fileNameDat);
                final BufferedReader readerDat = new BufferedReader(new InputStreamReader(is, Charsets.toCharset("UTF-8")));
                String line;
                while ((line = readerDat.readLine()) != null) {
                    bw.newLine();
                    bw.write(line.replace("dat`.", 环境 + "`."));
                }
                bw.close();

            }
        } catch (Exception e) {
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
            "  `annuity_guaranteed_period` int(8) NOT NULL COMMENT '养老年金保证领取期间值',\n" +
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
    private String 表16600 = "DROP TABLE IF EXISTS `rate_hq_16600`;\n" +
            "CREATE TABLE `rate_hq_16600` (\n" +
            "  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '物理ID',\n" +
            "  `risk_code` varchar(32)  NOT NULL COMMENT '险种',\n" +
            "  `duty_code` varchar(32)  NOT NULL COMMENT '责任',\n" +
            "  `amount_rate` decimal(16,6) NOT NULL COMMENT '保额费率',\n" +
            "  `gender` varchar(2)  NOT NULL COMMENT '性别（0为男性，1为女性，X为不区分性别）',\n" +
            "  `insurance_period` int(8) NOT NULL COMMENT '保险期间(年)',\n" +
            "  `pay_period` int(8) NOT NULL COMMENT '交费期间（年）',\n" +
            "  `is_insurance_expiry` bit(1) NOT NULL COMMENT '保险期限是否为岁满期（如保至60岁，1为是，0为否）',\n" +
            "  `is_pay_expiry` bit(1) NOT NULL COMMENT '交费期限是否为岁满期（如交至60岁，1为是，0为否）',\n" +
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
            ") ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='横琴16600费率';";
    private String 表14200 = "DROP TABLE IF EXISTS `rate_hq_14200`;\n" +
            "CREATE TABLE `rate_hq_14200` (\n" +
            "  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '物理ID',\n" +
            "  `risk_code` varchar(32)  NOT NULL COMMENT '险种',\n" +
            "  `duty_code` varchar(32)  NOT NULL COMMENT '责任',\n" +
            "  `amount_rate` decimal(16,6) NOT NULL COMMENT '保额费率',\n" +
            "  `gender` varchar(2)  NOT NULL COMMENT '性别（0为男性，1为女性，X为不区分性别）',\n" +
            "  `insurance_period` int(8) NOT NULL COMMENT '保险期间(年)',\n" +
            "  `pay_period` int(8) NOT NULL COMMENT '交费期间（年）',\n" +
            "  `is_insurance_expiry` bit(1) NOT NULL COMMENT '保险期限是否为岁满期（如保至60岁，1为是，0为否）',\n" +
            "  `is_pay_expiry` bit(1) NOT NULL COMMENT '交费期限是否为岁满期（如交至60岁，1为是，0为否）',\n" +
            "  `get_year` varchar(32) NOT NULL COMMENT '年金领取起始',\n" +
            "  `get_year_flag` varchar(32)  DEFAULT NULL COMMENT '年金领取起始单位',\n" +
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
            "  `begcre` decimal(16, 6) DEFAULT NULL COMMENT '年初修正准备金',\n" +
            "  `endcre` decimal(16, 6) DEFAULT NULL COMMENT '年末修正准备金',\n" +
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
            ") ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='横琴14200费率';";


    //            "  `annuity_age` int(8) NOT NULL COMMENT '养老年金领取年龄',
    //            "  `annuity_guaranteed_period` int(8) NOT NULL COMMENT '养老年金保证领取期间值',
    private String dbSql(String coreDbSqlLine) {
        if (coreDbSqlLine.contains("CREATE TABLE")) {
            return coreDbSqlLine + "\n  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '物理ID',";
        }
        if (coreDbSqlLine.contains("`PLANCODE` varchar")) {
            return "  `risk_code` varchar(32)  NOT NULL COMMENT '险种',\n  `duty_code` varchar(32)  NOT NULL COMMENT '责任',";
        }
        if (coreDbSqlLine.contains("`SA0` decimal")) {
            return "  `amount_rate` decimal(16,6) NOT NULL COMMENT '保额费率',";
        }
        if (coreDbSqlLine.contains("`GENDER` varchar")) {
            return "  `gender` varchar(2)  NOT NULL COMMENT '性别（0为男性，1为女性，X为不区分性别）',";
        }
        if (coreDbSqlLine.contains("`BT` decimal")) {
            return "  `insurance_period` int(8) NOT NULL COMMENT '保险期间(年)',";
        }
        if (coreDbSqlLine.contains("`PT` decimal")) {
            return "  `pay_period` int(8) NOT NULL COMMENT '交费期间（年）',";
        }
        if (coreDbSqlLine.contains("`BTOAGE` varchar")) {
            return "  `is_insurance_expiry` bit(1) NOT NULL COMMENT '保险期限是否为岁满期（如保至60岁，1为是，0为否）',";
        }
        if (coreDbSqlLine.contains("`PTOAGE` varchar")) {
            return "  `is_pay_expiry` bit(1) NOT NULL COMMENT '交费期限是否为岁满期（如交至60岁，1为是，0为否）',";
        }
        if (coreDbSqlLine.contains("`AGE` decimal")) {
            return "  `age` int(8) NOT NULL COMMENT '年龄',";
        }
        if (coreDbSqlLine.contains("`DT` decimal")) {
            return "  `year` int(8) NOT NULL COMMENT '保单年度',";
        }
        if (coreDbSqlLine.contains("`PREM` decimal")) {
            return "  `premium_rate` decimal(16,6) NOT NULL COMMENT '保费费率',";
        }
        if (coreDbSqlLine.contains("`PREM_CV` decima")) {
            return "  `premium_cv` decimal(16,6) DEFAULT NULL COMMENT '计算现金价值采用的当年保费',";
        }
        if (coreDbSqlLine.contains("`BEGCV` decimal")) {
            return "  `begin_cv` decimal(16,6) DEFAULT NULL COMMENT '年初现价',";
        }
        if (coreDbSqlLine.contains("`ENDCV` decimal")) {
            return "  `enb_cv` decimal(16,6) DEFAULT NULL COMMENT '年末现价',";
        }
        if (coreDbSqlLine.contains("`BEGSUR` decimal")) {
            return "  `begsur` decimal(8,0) DEFAULT NULL COMMENT '年初生存给付',";
        }
        if (coreDbSqlLine.contains("`ENDSUR` decimal")) {
            return "  `endsur` decimal(8,0) DEFAULT NULL COMMENT '年末生存给付',";
        }
        if (coreDbSqlLine.contains("`BEGBEN` decimal")) {
            return "  `begben` decimal(8,0) DEFAULT NULL COMMENT '年初未来保险利益的现值',";
        }
        if (coreDbSqlLine.contains("`ENDBEN` decimal")) {
            return "  `endben` decimal(8,0) DEFAULT NULL COMMENT '年末未来保险利益的现值',";
        }
        if (coreDbSqlLine.contains("`PREM_VAL` decimal")) {
            return "  `prem_val` decimal(16,6) DEFAULT NULL COMMENT '评估准备金采用的当年保费',";
        }
        if (coreDbSqlLine.contains("`BEGRE` decimal")) {
            return "  `begre` decimal(16,6) DEFAULT NULL COMMENT '年初法定准备金',";
        }
        if (coreDbSqlLine.contains("`ENDRE` decimal")) {
            return "  `endre` decimal(16,6) DEFAULT NULL COMMENT '年末法定准备金',";
        }
        if (coreDbSqlLine.contains("`BEGCRE` decimal")) {
            return "  `beg_cre` decimal(16,6) DEFAULT NULL COMMENT '年初修正准备金',";
        }
        if (coreDbSqlLine.contains("`ENDCRE` decimal")) {
            return "  `end_cre` decimal(16,6) DEFAULT NULL COMMENT '年末修正准备金',";
        }
        if (coreDbSqlLine.contains("`BEGXRE` decimal")) {
            return "  `beg_xre` decimal(16,6) DEFAULT NULL COMMENT '年初修正准备金',";
        }
        if (coreDbSqlLine.contains("`ENDXRE` decimal")) {
            return "  `end_xre` decimal(16,6) DEFAULT NULL COMMENT '年末修正准备金',";
        }
        if (coreDbSqlLine.contains("`BEGPRE` decimal")) {
            return "  `beg_pre` decimal(16,6) DEFAULT NULL COMMENT '年初保费不足准备金',";
        }
        if (coreDbSqlLine.contains("`ENDPRE` decimal")) {
            return "  `end_pre` decimal(16,6) DEFAULT NULL COMMENT '年末保费不足准备金',";
        }
        if (coreDbSqlLine.contains("`HIG_DIV` decimal")) {
            return "  `hig_div` decimal(16,6) DEFAULT NULL COMMENT '年度红利（高）',";
        }
        if (coreDbSqlLine.contains("`AVG_DIV` decimal")) {
            return "  `avg_div` decimal(16,6) DEFAULT NULL COMMENT '年度红利（中）',";
        }
        if (coreDbSqlLine.contains("`LOW_DIV` decimal")) {
            return "  `low_div` decimal(16,6) DEFAULT NULL COMMENT '年度红利（低）',";
        }
        if (coreDbSqlLine.contains("`HIG_ACC` decimal")) {
            return "  `hig_acc` decimal(16,6) DEFAULT NULL COMMENT '累积红利（高）',";
        }
        if (coreDbSqlLine.contains("`AVG_ACC` decimal")) {
            return "  `avg_acc` decimal(16,6) DEFAULT NULL COMMENT '累积红利（中）',";
        }
        if (coreDbSqlLine.contains("`LOW_ACC` decimal")) {
            return "  `low_acc` decimal(16,6) DEFAULT NULL COMMENT '累积红利（低）',\n " +
                    "  PRIMARY KEY (`id`) USING BTREE,\n" +
                    "  KEY `idx_year_age` (`year`,`age`) USING BTREE\n";
        }
        if (coreDbSqlLine.contains("AUTO_INCREMENT =")) {
            return coreDbSqlLine.replace(
                            coreDbSqlLine.substring(coreDbSqlLine.indexOf("AUTO_INCREMENT ="), coreDbSqlLine.lastIndexOf("CHARACTER ") - 1),
                            "")
                    .replace(";", " COMMENT='横琴XXX费率';");
        }
        return coreDbSqlLine;

    }
}
