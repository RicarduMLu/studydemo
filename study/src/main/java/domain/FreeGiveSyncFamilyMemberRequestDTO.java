package domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 家庭赠险领取同步本人家庭成员并且保存新增数据实体类
 *
 * @author lzj10
 * @create 2020-11-11-宪17:34
 */
@Data
public class FreeGiveSyncFamilyMemberRequestDTO {

    private String policyNo;
    private String valiDate;
    private String result;

}
