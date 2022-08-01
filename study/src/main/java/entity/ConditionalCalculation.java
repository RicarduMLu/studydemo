package entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * 条件计算类
 *
 * @author lzj10
 * @date 2021-10-22
 */
@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ConditionalCalculation {
    /**
     * 条件 逻辑计算值
     */
    @JsonProperty("co")
    private String condition;
    /**
     * 满足条件的再计算 条件
     */
    @JsonProperty("calCo")
    private ConditionalCalculation calculationCondition;
    /**
     * 最终满足条件计算内容
     */
    @JsonProperty("cal")
    private String calculation;
    /**
     * 否则进行的再计算 条件
     */
    @JsonProperty("elCo")
    private ConditionalCalculation elseCalculationCondition;
    /**
     * 最终满足条件计算内容
     */
    @JsonProperty("elCa")
    private String elseCalculation;
}
