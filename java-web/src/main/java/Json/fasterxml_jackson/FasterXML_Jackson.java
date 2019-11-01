package Json.fasterxml_jackson;

import Vo.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zsy
 */
public class FasterXML_Jackson {
    public static void main(String[] args) throws Exception{
        Person person = new Person();
        person.setName("yale");
        person.setAge(18);
        person.setMobile("151000000");
        person.setAddress("xxxxxxxxx");
        person.setBirthday(new Date());

        ObjectMapper objectMapper = new ObjectMapper();
        String writeValueAsString = objectMapper.writeValueAsString(person);
        System.out.println("JacksonUtil writeValueAsString>>>>>>>:{}"+  writeValueAsString);

        String array2Json = Array2Json(person);
        System.out.println("JacksonUtil Array2Json>>>>>>>:{}"+  array2Json);

        String wrapString = wrapSuccessString(1, array2Json);
        System.out.println("JacksonUtil wrapSuccessString>>>>>>>:{}"+  wrapString);
    }


    /**
     *  对象或对象集合转Json时日期格式处理
      * @param array
     * @return
     */
    public  static String Array2Json(Object array){
        String result = "";
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
            result = mapper.writeValueAsString(array);
        } catch (Exception e) {
            System.err.println("JacksonUtil Exception>>>>>>>:{}"+ e.toString());
            throw new RuntimeException(e);
        }
        return result;
    }

    /**
     * Jackson对象节点创建及使用
     * @param status
     * @param jsonSource
     * @return
     */
    public static String wrapSuccessString(int status, String jsonSource) {
        String result = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            ObjectNode node = mapper.createObjectNode();
            node.put("status", status);
            node.put("value", mapper.readTree(jsonSource));
            //数组节点创建
           /* ArrayNode node = mapper.createArrayNode();
            node.add(status);
            node.add(mapper.readTree(jsonSource));*/
            result = mapper.writeValueAsString(node);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
