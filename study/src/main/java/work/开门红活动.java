package work;

import com.google.common.collect.Lists;
import entity.ChannelPer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class 开门红活动 {
    private static String select = " select * from goods_activity_relation where goods_code in (\n" +
            "CODES\n" +
            ") and activity_code = 'open_new_year_2023' ; \n";
    private static String 关联 =
            "INSERT INTO goods_activity_relation(goods_code,activity_code,special_activity_config_info,is_open)VALUES" +
                    "('GOODSCODE','open_new_year_2023',NULL,true);\n";

    private static String 渠道关联 =
            "INSERT INTO goods_activity_channel_relation(goods_code,activity_code,special_activity_config_info,owner_code,is_white,is_black,start_time,end_time) VALUES" +
                    "('GOODSCODE','open_new_year_2023',NULL,'ORGCODE',true,false,'START','END');";
    private static String 永达理渠道 = "11448\n" +
            "11470\n" +
            "11472\n" +
            "11530\n" +
            "11531\n" +
            "11532\n" +
            "11533\n" +
            "11534\n" +
            "11535\n" +
            "11536\n" +
            "11537\n" +
            "11651\n" +
            "11652\n" +
            "11653\n" +
            "11654\n" +
            "11657\n" +
            "11660\n" +
            "11662\n" +
            "11663\n" +
            "11664\n" +
            "11665\n" +
            "11666\n" +
            "11667\n" +
            "11668\n" +
            "11672\n" +
            "11677\n" +
            "11679\n" +
            "11682\n" +
            "11690\n" +
            "11691\n" +
            "30013\n" +
            "3001301\n" +
            "300130101\n" +
            "300130102\n" +
            "300130103\n" +
            "300130104\n" +
            "300130105\n" +
            "300130106\n" +
            "300130107\n" +
            "3001302\n" +
            "300130201\n" +
            "300130202\n" +
            "C00153000001\n" +
            "C00153320101017\n" +
            "C00153320402018\n" +
            "C00153320501025\n" +
            "C00153321002036\n" +
            "C00153321102033\n" +
            "C00153440101035\n" +
            "C00153440301034\n";
    private static String 明亚渠道 =
            "C00095320102033\n" +
                    "C00095320302032\n" +
                    "C00095320202031\n" +
                    "C00095320202030\n" +
                    "C00095320502029\n" +
                    "C00095320402028\n" +
                    "C00095320501023\n" +
                    "C00095320101022\n" +
                    "11756\n" +
                    "C00095440301014\n" +
                    "C00095440101013\n" +
                    "30046\n" +
                    "C00095000001\n";

    @Test
    public void 生成() {
        String START = "2022-12-01 00:00:00";
        String END = "2022-12-30 23:59:59";
        String 商品 = "A1106002\nA1409001\nA1115001";
        String 已经存在商品基础关联的 = "A1106002\nA1409001\nA1115001";
        System.out.println();
        System.out.println();
        System.out.println(select.replace("CODES", Arrays.stream(商品.split("\n")).map(s -> "'" + s + "'").collect(Collectors.joining(","))));
        System.out.println();

        for (String CODE : 商品.split("\n")) {
            if (!Lists.newArrayList(已经存在商品基础关联的.split("\n")).contains(CODE)) {
                System.out.println(关联
                        .replace("GOODSCODE", CODE)
                );
            }
            System.out.println();
            for (String org : 永达理渠道.split("\n")) {
                System.out.println(渠道关联
                        .replace("GOODSCODE", CODE)
                        .replace("ORGCODE", org)
                        .replace("START", START)
                        .replace("END", END)
                );
            }
            System.out.println();
            System.out.println();
        }

    }

    private String 明亚授权 =
            "A1106002\tC00095320302032\tBB988B437444F535B22EB6EFD20F65A6\n" +
                    "A1106002\tC00095320102033\tC3DA9D312C992358DEEE9359A1A9BD6C\n" +
                    "A1106002\tC00095320202031\tD09D242B2C01FD9A79065C9B36D77960\n" +
                    "A1106002\tC00095320202030\tD96E5A62E6CF517F534FF83D67BFB83F\n" +
                    "A1106002\tC00095320502029\t171E1FD194F151D1489078475A6061AC\n" +
                    "A1106002\tC00095320402028\tEB2BF5792D3DDE6F455C798D9040E1FC\n" +
                    "A1106002\tC00095320501023\t94FBB751FF4CE669278F9E77727B8CD3\n" +
                    "A1106002\tC00095320101022\tC12FA1D3C85D4DF08506A89E2C996F23\n" +
                    "A1106002\t11756\t6BF722874CD4025114C89E1AE9E1D85D\n" +
                    "A1106002\tC00095440301014\tD3550B211EBB399F95EAF8035FD9C0D1\n" +
                    "A1106002\tC00095440101013\t83DB93590A992225695222259E5FD678\n" +
                    "A1106002\t30046\tE849AA7591A7E671A5142744933AAFF8\n" +
                    "A1106002\tC00095000001\t71A283682EF41FA634540650A9D49FCD\n" +
                    "A1409001\t11756\t0F6709F7E22C5E5514906AD876EEA098\n" +
                    "A1409001\tC00095000001\tFE74F80DE2520A213254554CFCA0F30A\n" +
                    "A1409001\tC00095320102033\t746CA25EDECA18ED94413B746B043AA2\n" +
                    "A1409001\tC00095320202030\t369B1CEB9FA82F3EBCA3072003EE4E78\n" +
                    "A1409001\tC00095320202031\t2ED4F0C0401B1E2823E9172FECD061EF\n" +
                    "A1409001\tC00095320302032\t67321C2EE40959EB0B140199558A96E3\n" +
                    "A1409001\tC00095320402028\t31B7B385C66E6B0495ED70110BF39DFD\n" +
                    "A1409001\tC00095320502029\tD643EB228221F13526A09E116BC10393\n" +
                    "A1409001\tC00095440101013\t342F823571F013FBDB6CD4E585AC500A\n" +
                    "A1409001\tC00095440301014\tE306DDA5B79BFD25A7116075CAF2DC57\n" +
                    "A1409001\t30046\t43335F51E76CC78E2A5BAB31FCC2C91B\n" +
                    "A1409001\tC00095320501023\t52C2AFC1175304287E8A6BE378490F13\n" +
                    "A1409001\tC00095320101022\t9528CB635F0A95F2BC61CF3D14F67FBA\n";
    private String 永达理授权 =
            "A1409001\t11470\t2CADA63D242118BEFA85F2D46B95974A\n" +
                    "A1409001\t11472\tEA60C83879B4D8EB0022921A92D215F3\n" +
                    "A1409001\t11530\t76CAB40FE16F6D907FC26CC181CA0061\n" +
                    "A1409001\t11531\t13196F977E680BDFB926204BE0D6A89C\n" +
                    "A1409001\t11532\t2F961B34260A2406C189AB0A7A66E64E\n" +
                    "A1409001\t11533\t99C9F88844FD8BFFF11EA71177ED15B8\n" +
                    "A1409001\t11534\tBE38E20B19C1100D5AD33723CAEE340B\n" +
                    "A1409001\t11535\t9E3A06E23DB5D08DFD21E091AA77159E\n" +
                    "A1409001\t11536\t3AC9E6830DFCA816BF9737F1347BC19B\n" +
                    "A1409001\t11537\t950E8E23527094740BD11ADBF4BE4B15\n" +
                    "A1409001\t11651\t0F923DA91B6FCA6E83DD1621E27C8920\n" +
                    "A1409001\t11652\t158D7B693180941A41DEC4688509E562\n" +
                    "A1409001\t11653\t16EDDB1604DA98035F436D31BCBA62D1\n" +
                    "A1409001\t11654\t26CF1216F96F10AEF421011ECA210A07\n" +
                    "A1409001\t11660\t0A1A31A0D90B0A847A09ABD7360080E4\n" +
                    "A1409001\t11690\t7A7246D198D0297F8CFC832CE99366AD\n" +
                    "A1409001\t11691\t778CBEA446BC5EB6A4D59448E71679C1\n" +
                    "A1409001\tC00153321002036\tD16AF64BAFAD1BF27C64338CB241EE91\n" +
                    "A1409001\tC00153321102033\tB48F8B74441540945A2B87EA2208306F\n" +
                    "A1409001\t11657\tF91A2114610546585FE2A8BB2836D199\n" +
                    "A1409001\t11662\t45AB093F8B4DE6F6A3E27D74E41E876A\n" +
                    "A1409001\t11664\t3109E1A3A94F4707871FBD6909C93038\n" +
                    "A1409001\t11672\tAB12A20CE332C561B95CDA7F655562D4\n" +
                    "A1409001\t11663\tA748CC254D51E1088F67A16C4884CC50\n" +
                    "A1409001\t11666\t5A3B0671315AA09B3D266E67919FAA27\n" +
                    "A1409001\t11668\t7C596FFCBF7F3F6F6E03A99BD82D7268\n" +
                    "A1409001\t11665\t8234AE812BDC82281E58ACD88690D669\n" +
                    "A1409001\t11667\t8D8F29A385A60E89FE10019203E2B26E\n" +
                    "A1409001\t11677\t87953B0FDB47FF6B29B535438B28C2CD\n" +
                    "A1409001\t11679\t1334028374AFC3049FB807EB67AC50ED\n" +
                    "A1409001\t11682\t7CA6BF9158A6302A30E4AE55FC2A9084\n" +
                    "A1409001\t30013\t8E55F518D8B877EFDBA0206CBA931AB9\n" +
                    "A1409001\t3001301\t066DEE72120311C01660E9B8C9C42931\n" +
                    "A1409001\t300130101\tC8417456E3791067F7344E144632821D\n" +
                    "A1409001\t300130102\tB6EDB87A57D69C8622C52A76B00ED31F\n" +
                    "A1409001\t300130103\t6F2557D644CE54750BB820F4AE6BACF5\n" +
                    "A1409001\t300130104\t8D805777A61A15D14FF2777C2E5ACCF4\n" +
                    "A1409001\t300130105\t79B7FF1E1F1FCCECFEC5F8F24F40661A\n" +
                    "A1409001\t300130106\t8B6813EBA85DB2927E62AAB4B8947499\n" +
                    "A1409001\t300130107\tE80BD9284CB32B8D5AAD230E0B735299\n" +
                    "A1409001\t3001302\t56FCA120EC686A82FF9B7BAD89CAF808\n" +
                    "A1409001\t11448\t40CDA4E50860A17B3E6E1E92ACB4112C\n" +
                    "A1409001\t300130201\t2AB134226BD4C5E894A673C3F580A89F\n" +
                    "A1409001\t300130202\t2204885E5446D34F370FCF96E059324D\n" +
                    "A1409001\tC00153000001\t2050ADB685AA38DAE24E4A93627F8A89\n" +
                    "A1409001\tC00153320101017\t5B4D6C9EA0DEEF28B9DEBF86D4B2E740\n" +
                    "A1409001\tC00153320402018\tD5F4BBF43760B6E69CA3EB2B8DC3D1D3\n" +
                    "A1409001\tC00153320501025\tED613EFA95C8FCAEF534D505A9CE1CE0\n" +
                    "A1409001\tC00153440101035\tDC49F1BE314B75E9209A16E3C851DB00\n" +
                    "A1409001\tC00153440301034\t91A635041A4374EEFDF60514E23A96B6\n" +
                    "A1106002\t11470\t51995AE1893732E0A7A0E9CD160C2BA0\n" +
                    "A1106002\t11472\t09705DC70E2848D39C2A9B000E9A9BFD\n" +
                    "A1106002\t11530\tA2F2089101F8A8CD7858B098336A572C\n" +
                    "A1106002\t11531\t9F8C076EE0988E202048E61F5E083A80\n" +
                    "A1106002\t11532\t598CF2CD704E35FEE99FBF7C016744BC\n" +
                    "A1106002\t11533\t9986079680437B286178612B995D1DC0\n" +
                    "A1106002\t11534\t705F300644B1DB0DFC19944C5734CA1D\n" +
                    "A1106002\t11535\t70DBC8CFEDD3846D5848F9C77500F241\n" +
                    "A1106002\t11536\tC2573D403F6199650585D869F294C54C\n" +
                    "A1106002\t11537\t3C722EC4B8804D7B759089A8CA296217\n" +
                    "A1106002\t11651\t3D1E930A62AB9C71519F3B4D2D692196\n" +
                    "A1106002\t11652\t84F9D9F1435ADA1A7162839ECE8CB4B6\n" +
                    "A1106002\t11653\t5084DA47A5227C169A418CE1717FCE31\n" +
                    "A1106002\t11654\t52717B9B9B0CB6CF6A5B5B0C2D19DAD0\n" +
                    "A1106002\t11660\t9D5B985B77C6F0C90ED7FC12202CD82F\n" +
                    "A1106002\t11690\t3A3011414611BD39E74C4A07F6858D42\n" +
                    "A1106002\t11691\t378E77BFF11C374270F0F6A0B9190BDF\n" +
                    "A1106002\tC00153321002036\t22A37268CF740DC55DFE12DA357CFB3A\n" +
                    "A1106002\tC00153321102033\t6BA6CCE8C051433162235684E5190886\n" +
                    "A1106002\t11657\tC63DE1A920386D229D04D0903186ADBD\n" +
                    "A1106002\t11662\t863F938B4368B33548B41FF6A3CBD4E9\n" +
                    "A1106002\t11664\t23AABBC71E4C033DA047E9E4D8850327\n" +
                    "A1106002\t11672\tE833BAEFF3B344E85E418256E78051E1\n" +
                    "A1106002\t11663\t6A39B3491D6B56A69CDAD496BFDFF11E\n" +
                    "A1106002\t11666\tF21355767588198E178EE8864704ED70\n" +
                    "A1106002\t11668\tD6270849A458D9730D7B15738D9D1A69\n" +
                    "A1106002\t11665\tFD1C7A82D51A4E11AE913C0BE5A34642\n" +
                    "A1106002\t11667\t5484E7D37C2F838C995D950E4AC87633\n" +
                    "A1106002\t11677\tF5B7EDF59A99A704C9FC37C3D750D754\n" +
                    "A1106002\t11679\tE243FDE3334F6BBB763E91B69AA6C5B0\n" +
                    "A1106002\t11682\t7A1B21DDF37C265AD367A535B816AD55\n" +
                    "A1106002\t30013\t70D708747EE4002291DDE7AB50600AE3\n" +
                    "A1106002\t3001301\t155CB95E0E1F460861F49F74BDE782DD\n" +
                    "A1106002\t300130101\tF061BFB71A4CF036B95B07339262419B\n" +
                    "A1106002\t300130102\t9C6CDE465048BBCA0C657CE71F0758B8\n" +
                    "A1106002\t300130103\t06EDAAEFE0E069806E52FA6923C6C0B1\n" +
                    "A1106002\t300130104\tECB34D6216BDC4C63185390B68F4B638\n" +
                    "A1106002\t300130105\t2105E1EB98017064ADB513713C4A809A\n" +
                    "A1106002\t300130106\t92AA34EC3A66AD98E7D56B8AEA301A7C\n" +
                    "A1106002\t300130107\t047350EA73FF7D5E85BD375BC583BCE3\n" +
                    "A1106002\t3001302\t01B33788788BE202DDEAFE24B0378DF2\n" +
                    "A1106002\t11448\tEFF997D58F3DAF9DE1A7A6BCA8B0C045\n" +
                    "A1106002\t300130201\t1D3311B14489A3788AD8A24CBE59F042\n" +
                    "A1106002\t300130202\tB9FB40BDF14EE9BA31CD210044FE8644\n" +
                    "A1106002\tC00153000001\t130B3581FBF8FF4F1CF474101D154EC3\n" +
                    "A1106002\tC00153320101017\t1A8065FD20AEF7673CDC4854466D2282\n" +
                    "A1106002\tC00153320402018\t9A8115FBCBF941C2BF18D6B19130D3AB\n" +
                    "A1106002\tC00153320501025\t36C6CBF8CF306EA48E9E2B19B1936BC7\n" +
                    "A1106002\tC00153440101035\tCB32811838F0B987BB0F5CD25220E0FB\n" +
                    "A1106002\tC00153440301034\t079F06F330E395314AE813FABD250682\n";


    @Test
    public void test00() {
        String ruleChannel = "INSERT INTO `goods_rule_channel` ( `goods_code`, `risk_code`, `plan_code`, `permission_id`, `owner_org_code`, `rule_type`, `rule_control_type`, `rule_scope`, `default_info` ) VALUES " +
                "( 'gggggggggg', 'rrrrrrrr', '', " +
                "'ppppppppp'," +
                " 'ooooooo', " +
                " 'PAY_FREQUENCY', 'ENUMERATION', '{\\\"scopeMap\\\":{\\\"SINGLE\\\":\\\"趸交\\\",\\\"ANNUAL\\\":\\\"年交\\\"}}', 'ANNUAL' );";

        Map<String, Map<String, String>> collect = Arrays.stream(明亚授权.split("\n")).map(s -> {
            String[] split = s.split("\t");
            return ChannelPer.builder().goodsCode(split[0]).ownerOrgCode(split[1]).permissionId(split[2]).build();
        }).collect(Collectors.groupingBy(ChannelPer::getGoodsCode, Collectors.toMap(ChannelPer::getOwnerOrgCode, ChannelPer::getPermissionId, (key1, key2) -> key1)));
        System.out.println();
        System.out.println();
        for (String org : 明亚渠道.split("\n")) {
            Map<String, String> a1106002 = collect.get("A1106002");
            System.out.print(ruleChannel
                    .replace("gggggggggg", "A1106002")
                    .replace("rrrrrrrr", "11060")
                    .replace("ppppppppp", a1106002.get(org))
                    .replace("ooooooo", org)
            );
            System.out.println();

        }
        System.out.println();
        System.out.println();
        for (String org : 明亚渠道.split("\n")) {
            Map<String, String> a1409001 = collect.get("A1409001");
            System.out.print(ruleChannel
                    .replace("gggggggggg", "A1409001")
                    .replace("rrrrrrrr", "14090")
                    .replace("ppppppppp", a1409001.get(org))
                    .replace("ooooooo", org)
            );
            System.out.println();
        }
    }
}
