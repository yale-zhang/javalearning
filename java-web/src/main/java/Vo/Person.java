package Vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;

/**
 * @JsonInclude(JsonInclude.Include.NON_NULL) 序列化时排除null或者空字符串
 * @JsonInclude(JsonInclude.Include.NON_EMPTY) 序列化Person时值为null的字段排除掉
 *
 * 在默认情况下，如果Json数据中有多余的字段，那么在反序列化时Jackson发现无法找到对应的对象字段，
 * 便会抛出UnrecognizedPropertyException: Unrecognized field xxx异常，此时可以做如下配置：
 *  objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
 *
 */
@lombok.Data
@JsonIgnoreProperties(value = {"sex","age"},ignoreUnknown = true)
public class Person implements Serializable {
    private String name;
    private Integer age;
    private String mobile;
    private String sex;
    @JsonIgnore
    private String address;
    private Date birthday;

}
