package Json;

import java.util.HashMap;
import java.util.Map;

public class jsonObjectTest {

    /**
     * 往JSONObject对象中添加属性及属性值，最后将JSONObjecct对象转成json数据返回
     * @return
     */
    public String jsonObjectTest(){
        // 拼接返回的json数据
        JSONObject returnJson = new JSONObject();
        JSONObject dataJson = new JSONObject();
        JSONArray dataArray = new JSONArray();

        // 模拟接口调用后获得的结果数据
        String data = getData();
        JSONObject object = JSONObject.fromObject(data);

        // 获取状态码，如果是1表示调用成功，则获取数据集合和总记录数
        // String code = object.get("code").toString();
        String code = object.getString("code");
        String total = null;
        if("1".equals(code)){
            JSONArray jsonArray = object.getJSONObject("data").getJSONArray("list");
            total = object.getJSONObject("data").get("total").toString();
            for(int i=0; i<jsonArray.size(); i++){
                String itemStr = jsonArray.get(i).toString();
                JSONObject itemObject = JSONObject.fromObject(itemStr);
                String id = itemObject.get("id").toString();
                String name = itemObject.get("itemName").toString();
                String price = itemObject.get("price").toString();
                dataJson.put("id", id);
                dataJson.put("name", name);
                dataJson.put("price", price);
                dataArray.add(dataJson);
            }
        }
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("itemList", dataArray);
        map.put("total", total);

        // 根据APP端返回json数据
        String response = "{\"code\":\"200\",\"title\":\"成功\",\"message\":\"成功！\",\"style\":0}";
        returnJson.element("data", map);
        returnJson.element("response", response);

        return returnJson.toString();
    }
}
