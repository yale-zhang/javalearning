package Json.fastjson;/*
 * @Author: Dkerlo
 * @Description :
 * @Date: 创建于 2018/1/26
 * @Modified By:Dkerlo
 */

import java.io.Serializable;

/**
 *   云记账 科目余额表
 */
public class CloudKmyeDto implements Serializable {

    private static final long serialVersionUID = 1L;

//    code：科目编码
//    name：科目名称
//    balanceDer：科目余额方向
//    initDebit：期初借方
//    initCredit：期初贷方
//    debitAmt：借方发生
//    creditAmt：贷方发生
//    balanceAmt：期末余额
//    balanceDebit--期末借方
//    balanceCredit--期末贷方

    private String code;
    private String name;
    private String balanceDer;
    private String initDebit;
    private String initCredit;
    private String debitAmt;
    private String creditAmt;
    private String balanceAmt;
    private String balanceDebit;
    private String balanceCredit;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBalanceDer() {
        return balanceDer;
    }

    public void setBalanceDer(String balanceDer) {
        this.balanceDer = balanceDer;
    }

    public String getInitDebit() {
        return initDebit;
    }

    public void setInitDebit(String initDebit) {
        this.initDebit = initDebit;
    }

    public String getInitCredit() {
        return initCredit;
    }

    public void setInitCredit(String initCredit) {
        this.initCredit = initCredit;
    }

    public String getDebitAmt() {
        return debitAmt;
    }

    public void setDebitAmt(String debitAmt) {
        this.debitAmt = debitAmt;
    }

    public String getCreditAmt() {
        return creditAmt;
    }

    public void setCreditAmt(String creditAmt) {
        this.creditAmt = creditAmt;
    }

    public String getBalanceAmt() {
        return balanceAmt;
    }

    public void setBalanceAmt(String balanceAmt) {
        this.balanceAmt = balanceAmt;
    }

    public String getBalanceDebit() {
        return balanceDebit;
    }

    public void setBalanceDebit(String balanceDebit) {
        this.balanceDebit = balanceDebit;
    }

    public String getBalanceCredit() {
        return balanceCredit;
    }

    public void setBalanceCredit(String balanceCredit) {
        this.balanceCredit = balanceCredit;
    }
}
