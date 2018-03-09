package Json.fastjson;

import Json.jsonResoler.Account;
import Json.jsonResoler.AccountbookDto;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections.CollectionUtils;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class FastJsonResolver {


    private static final String  ACCOUNTBOOK = "{" +
            "\"account\": [" +
            "{" +
            "\"cCode\": \"1001\"," +
            "\"cFullName\": \"\\u5e93\\u5b58\\u73b0\\u91d1\"," +
            "\"cGUID\": \"692285096804347193\"," +
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
            "\"cGUID\": \"692285096804347194\"," +
            "\"cName\": \"\\u94f6\\u884c\\u5b58\\u6b3e\"," +
            "\"cName1\": \"NULL\"," +
            "\"cParentID\": \"000000\"," +
            "\"curCode\": \"NULL\"," +
            "\"iAdjustRate\": \"0\"," +
            "\"iBalanceDir\": \"1\"," +
            "\"iLeaf\": \"0\"," +
            "\"iLevel\": \"1\"" +
            "}],\"accountbook\": [{\"cAcctGUID\": \"123784347919912990\"," +
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
        JSONObject jsonObject = JSON.parseObject(ACCOUNTBOOK);
        String accountbooks = jsonObject.getString("accountbook");
        String accounts = jsonObject.getString("account");
        List<Account> accountList = JSON.parseArray(accounts, Account.class);
        Map<String, AccountbookDto> accountbookDtoMaps = Maps.newHashMap();
        List<AccountbookDto> accountbookDtoList = JSON.parseArray(accountbooks, AccountbookDto.class);
        if (CollectionUtils.isNotEmpty(accountbookDtoList)){
            for (AccountbookDto accountbookDto:accountbookDtoList){
                accountbookDtoMaps.put(accountbookDto.getCGUID(),accountbookDto);
            }
        }
        List<CloudKmyeDto> cloudKmyeDtos = Lists.newArrayList();
        if (CollectionUtils.isNotEmpty(accountList)) {
            CloudKmyeDto cloudKmyeDto = null;
            for (Account account : accountList) {
                cloudKmyeDto = new CloudKmyeDto();
                cloudKmyeDto.setCode(account.getCCode());
                cloudKmyeDto.setName(account.getCName());
                AccountbookDto accountbookDto = accountbookDtoMaps.get(account.getCGUID());
                //余额方向 iBalanceDir 0-借方,1-贷方
                if (StringUtils.isNotEmpty(account.getIBalanceDir())){
                    cloudKmyeDto.setBalanceDer(account.getIBalanceDir());
                    if (StringUtils.isNotEmpty(accountbookDto)){
                        //debitAmt：借方发生   --->iYearDebitAMT 年借方累计本币金额
                        String debitAmt = StringUtil.isEmpty(accountbookDto.getIYearDebitAMT())?"0":accountbookDto.getIYearDebitAMT();
                        BigDecimal debit = BigDecimal.valueOf(Double.valueOf(debitAmt));
                        cloudKmyeDto.setDebitAmt(debitAmt);
                        //creditAmt：贷方发生  ----> iYearCreditAMT 年贷方累计本币金额
                        String creditAmt = StringUtil.isEmpty(accountbookDto.getIYearCreditAMT())?"0":accountbookDto.getIYearCreditAMT();
                        BigDecimal credit = BigDecimal.valueOf(Double.valueOf(creditAmt));
                        cloudKmyeDto.setCreditAmt(creditAmt);
                        if ("0".equals(account.getIBalanceDir())){
                            //initDebit：期初借方  --> iInitAMT + 0  期初本币金额
                            String initDebit = StringUtil.isEmpty(accountbookDto.getIInitAMT())?"0":accountbookDto.getIInitAMT();
                            cloudKmyeDto.setInitDebit(initDebit);
                            cloudKmyeDto.setInitCredit("0");
                            BigDecimal debitDecimal = BigDecimal.valueOf(Double.valueOf(initDebit));
                            //balanceDebit--期末借方 --> 期末借方余额=期初借方余额+本期累计借方发生-本期累计贷方发生
                            BigDecimal balanceDebit = debitDecimal.add(debit).subtract(credit);
                            cloudKmyeDto.setBalanceDebit(balanceDebit.toString());
                            cloudKmyeDto.setBalanceCredit("0");
                        } else {
                            //initCredit：期初贷方 --> iInitAMT + 1  期初本币金额
                            String initCredit = StringUtil.isEmpty(accountbookDto.getIInitAMT())?"0":accountbookDto.getIInitAMT();
                            cloudKmyeDto.setInitCredit(initCredit);
                            cloudKmyeDto.setInitDebit("0");
                            BigDecimal creditDecimal = BigDecimal.valueOf(Double.valueOf(initCredit));
                            //balanceCredit--期末贷方 --> 期末贷方余额=期初贷方余额+本期累计贷方发生-本期累计贷方发生
                            BigDecimal balanceCredit = creditDecimal.add(debit).subtract(credit);
                            cloudKmyeDto.setBalanceCredit(balanceCredit.toString());
                            cloudKmyeDto.setBalanceDebit("0");
                        }
                    }
                }
                cloudKmyeDtos.add(cloudKmyeDto);
            }
        }
        cloudKmyeDtos.size();
        //余额方向 iBalanceDir 0-资产类(借方),1-负债类(贷方)
        //List<AccountbookDto> accountbookList = JsonUtil.getListForJson(accountbook,AccountbookDto.class);
        /*for (AccountbookDto account:accountbookDtos){
            String cAcctGUID = account.getCAcctGUID();
        }*/
    }

    @Override
    public String resolver() {
        return null;
    }
}
