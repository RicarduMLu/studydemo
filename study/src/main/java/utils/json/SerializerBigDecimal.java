package utils.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/**
 * @ClassName SerializerBigDecimal
 * @Description
 * @Author 夜十一狼
 * @Version 1.0
 * @Create 2021-07-03 20:03:32
 * @Update
 */

public class SerializerBigDecimal extends JsonSerializer<BigDecimal> {
   @Override
   public void serialize(BigDecimal value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
      if(Objects.isNull(value)) {
         gen.writeNull();
      } else {
         // 四舍五入
         gen.writeNumber(value.setScale(2, RoundingMode.HALF_UP));
      }
   }
}
