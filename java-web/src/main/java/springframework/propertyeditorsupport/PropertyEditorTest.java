package springframework.propertyeditorsupport;

import java.util.HashMap;
import java.util.Map;

public class PropertyEditorTest {
    public static void main(String[] args) throws Exception{
       Map<String,String> parameters= new HashMap<String,String>(){
            {
                put("nodeName","zhangsan");
                put("user","zhangsan|zhangsan@163.com|2019-10-08 15:06:00");
            }
        };
        Node node = PropertyEditorSample.convert(parameters);
        //System.out.println(node.getNodeName());
        //System.out.println(node.getUser());
    }
}
