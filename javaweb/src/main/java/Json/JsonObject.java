package Json;

public class JsonObject {
/*
    data={
        "status": "查询成功",
        "data": {
                    "total": 143,
                    "list": [{"exceptionnum": "28",
                                    "areacn": "余杭区",
                                    "areaid": "330110000000000000",
                                    "comnum": "150"},
                            {"exceptionnum": "22",
                                    "areacn": "拱墅区",
                                    "areaid": "330105000000000000",
                                    "comnum": "97"},
                            {"exceptionnum": "22",
                                    "areacn": "萧山区",
                                    "areaid": "330109000000000000",
                                    "comnum": "178"}]
                  },
        "code": "1"
        }
*/
    public static void main(String[] args) {
        String data =null;
        //需求一：调用第三方接口返回json字符串，我们自己处理成所需格式的json数据？
        //将字符串数据转成JSONObject对象
        JSONObject object = JSONObject.fromObject(data);
        //一个简单字符串就可以用get或getString方法来获取
        //String code = object.get("code").toString();
        String code = object.getString("code");
        //获取data中的list集合数据,用getJSONArray方法来获取
        JSONArray jsonArray = object.getJSONObject("data").getJSONArray("list");//获取小data中的list数据
        total = object.getJSONObject("data").get("total").toString();//获取小data中的total数据

        //需求二：往JSONObject对象中添加属性及属性值，最后将JSONObjecct对象转成json数据返回？

    }


}
