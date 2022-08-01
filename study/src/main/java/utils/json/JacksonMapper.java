package utils.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Jianguo Luo
 * @date 2021/4/9
 * @Description
 */
public class JacksonMapper extends ObjectMapper {

    public JacksonMapper() {
        super();
        this.configure(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN, true);
        this.configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true);
        this.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        /**
         * 这两个参数的设定后续再看看
         * this.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
         * this.activateDefaultTyping(this.getPolymorphicTypeValidator(), ObjectMapper.DefaultTyping.NON_FINAL) ;
         */
        SimpleModule simpleModule = new SimpleModule();
        //日期格式化
        simpleModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DatePatterns.YYYY_MM_DD_HH_MM_SS)));
        simpleModule.addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern(DatePatterns.YYYY_MM_DD)));
        simpleModule.addSerializer(LocalTime.class, new LocalTimeSerializer(DateTimeFormatter.ofPattern(DatePatterns.HH_MM_SS)));
        simpleModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(DatePatterns.YYYY_MM_DD_HH_MM_SS)));
        simpleModule.addDeserializer(LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ofPattern(DatePatterns.YYYY_MM_DD)));
        simpleModule.addDeserializer(LocalTime.class, new LocalTimeDeserializer(DateTimeFormatter.ofPattern(DatePatterns.HH_MM_SS)));

        registerModule(simpleModule);
    }
}
