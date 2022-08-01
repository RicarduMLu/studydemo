package utils;

import com.fasterxml.jackson.databind.JavaType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import utils.json.JacksonMapper;

import java.io.IOException;
import java.util.List;

/**
 * @author Jianguo Luo
 * @date 2021/4/4
 * @Description Json工具类
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class JsonUtil {

    private static final ThreadLocal<JacksonMapper> JACKSON_MAPPER_THREAD_LOCAL = ThreadLocal.withInitial(JacksonMapper::new);

    public static <T> String toJSON(T obj) {
        if (obj == null) {
            return null;
        }
        try {
            return JACKSON_MAPPER_THREAD_LOCAL.get().writeValueAsString(obj);
        } catch (Exception e) {
        } finally {
            JACKSON_MAPPER_THREAD_LOCAL.remove();
        }
        return null;
    }

    public static <T> T fromJSON(String json, Class<T> type) {
        if (StringUtils.isBlank(json)) {
            return null;
        }
        try {
            return JACKSON_MAPPER_THREAD_LOCAL.get().readValue(json, type);
        } catch (Exception e) {
        } finally {
            JACKSON_MAPPER_THREAD_LOCAL.remove();
        }
        return null;
    }

    public static <T> List<T> toList(String json, Class<? extends List> collectionClass, Class<T> elementClass) {
        if (StringUtils.isBlank(json)) {
            return null;
        }
        try {
            JavaType javaType = JACKSON_MAPPER_THREAD_LOCAL.get().getTypeFactory().constructCollectionType(collectionClass, elementClass);
            return JACKSON_MAPPER_THREAD_LOCAL.get().readValue(json, javaType);
        } catch (IOException e) {
            return null;
        } finally {
            JACKSON_MAPPER_THREAD_LOCAL.remove();
        }
    }

}
