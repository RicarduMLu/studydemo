package utils.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/**
 * @ClassName DataDeserializerBigDecimal
 * @Description
 * @Author 夜十一狼
 * @Version 1.0
 * @Create 2021-07-03 20:02:20
 * @Update
 */


public class DeserializerBigDecimal extends JsonDeserializer<BigDecimal> {

    /**
     * 出参保留两位小数
     * @param jsonParser
     * @param deserializationContext
     * @return
     * @throws IOException
     */
    @Override
    public BigDecimal deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (Objects.isNull(jsonParser.getDecimalValue())) {
            return null;
        } else {
            // 四舍五入
            return jsonParser.getDecimalValue().setScale(2, RoundingMode.HALF_UP);
        }
    }

}
