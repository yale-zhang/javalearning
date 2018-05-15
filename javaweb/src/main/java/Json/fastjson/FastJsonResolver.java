package Json.fastjson;

import java.util.List;

public class FastJsonResolver {

  /*  private static final String  COMPLEX_JSON_STR1 = "{\"account\": [" +
            "{" +
            "\"cCode\": \"1001\"," +
            "\"cFullName\": \"\\u5e93\\u5b58\\u73b0\\u91d1\"," +
            "\"cGUID\": \"123784347919912990\"," +
            "\"cName\": \"\\u5e93\\u5b58\\u73b0\\u91d1\"," +
            "\"cName1\": \"NULL\"," +
            "\"cParentID\": \"000000\"," +
            "\"curCode\": \"NULL\"," +
            "\"iAdjustRate\": \"0\"," +
            "\"iBalanceDir\": \"1\"," +
            "\"iLeaf\": \"1\"," +
            "\"iLevel\": \"1\"" +
            "}," +
            "{" +
            "\"cCode\": \"1002\"," +
            "\"cFullName\": \"\\u94f6\\u884c\\u5b58\\u6b3e\"," +
            "\"cGUID\": \"123784347919912991\"," +
            "\"cName\": \"\\u94f6\\u884c\\u5b58\\u6b3e\"," +
            "\"cName1\": \"NULL\"," +
            "\"cParentID\": \"000000\"," +
            "\"curCode\": \"NULL\"," +
            "\"iAdjustRate\": \"0\"," +
            "\"iBalanceDir\": \"1\"," +
            "\"iLeaf\": \"0\"," +
            "\"iLevel\": \"1\"" +
            "}]}";

    private static final String  COMPLEX_JSON_STR = "{\"accountbook\": [{\"cAcctGUID\": \"123784347919912990\"," +
            "\"cGUID\":\"692285096804347193\"," +
            "\"ccode\": \"1001\"," +
            "\"cname\": \"\\u5e93\\u5b58\\u73b0\\u91d1\"," +
            "\"iCreditAMT\": \"104000.00000000\"," +
            "\"iCreditAMT_F\": \"104000.00000000\"," +
            "\"iCreditQTY\": \"0.00000000\"," +
            "\"iDebitAMT\": \"420000.00000000\"," +
            "\"iDebitAMT_F\": \"420000.00000000\"," +
            "\"iDebitQTY\": \"0.00000000\"," +
            "\"iInitAMT\": \"205319.33000000\"," +
            "\"iInitAMT_F\": \"205319.33000000\"," +
            "\"iInitQTY\": \"0.00000000\"," +
            "\"iMonth\": \"1\"," +
            "\"iYear\": \"2013\"," +
            "\"iYearCreditAMT\": \"104000.00000000\"," +
            "\"iYearCreditAMT_F\": \"104000.00000000\"," +
            "\"iYearCreditQTY\": \"0.00000000\"," +
            "\"iYearDebitAMT\": \"420000.00000000\"," +
            "\"iYearDebitAMT_F\": \"420000.00000000\"," +
            "\"iYearDebitQTY\": \"0.00000000\"},{\"cAcctGUID\": \"123784347919912991\"," +
            "\"cGUID\": \"692285096804347194\"," +
            "\"ccode\": \"1002\"," +
            "\"cname\": \"\\u94f6\\u884c\\u5b58\\u6b3e\"," +
            "\"iCreditAMT\": \"1743261.85000000\"," +
            "\"iCreditAMT_F\": \"1743261.85000000\"," +
            "\"iCreditQTY\": \"0.00000000\"," +
            "\"iDebitAMT\": \"1902105.00000000\"," +
            "\"iDebitAMT_F\": \"1902105.00000000\"," +
            "\"iDebitQTY\": \"0.00000000\"," +
            "\"iInitAMT\": \"55290.48000000\"," +
            "\"iInitAMT_F\": \"55290.48000000\"," +
            "\"iInitQTY\": \"0.00000000\"," +
            "\"iMonth\": \"1\"," +
            "\"iYear\": \"2013\"," +
            "\"iYearCreditAMT\": \"1743261.85000000\"," +
            "\"iYearCreditAMT_F\": \"1743261.85000000\"," +
            "\"iYearCreditQTY\": \"0.00000000\"," +
            "\"iYearDebitAMT\": \"1902105.00000000\"," +
            "\"iYearDebitAMT_F\": \"1902105.00000000\"," +
            "\"iYearDebitQTY\": \"0.00000000\"" +
            "}]}";

    public static void main(String[] args) {
        JSONObject jsonObject = JSON.parseObject(COMPLEX_JSON_STR);
        String accountbook = jsonObject.getString("accountbook");
        List<Accountbook> accountbookDtos = JSON.parseArray(accountbook, Accountbook.class);
        //List<AccountbookDto> accountbookList = JsonUtil.getListForJson(accountbook,AccountbookDto.class);
        for (Accountbook account:accountbookDtos){
            String cAcctGUID = account.getCAcctGUID();
        }
    }*/
}
