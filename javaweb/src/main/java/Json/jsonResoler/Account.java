package Json.jsonResoler;

import java.io.Serializable;
import java.util.List;

public class Account implements Serializable{

    private static final long serialVersionUID = 1L;

    private String cCode;
    private String cFullName;
    private String cGUID;
    private String cName;
    private String cName1;
    private String cParentID;
    private String curCode;
    private String iAdjustRate;
    private String iBalanceDir;
    private String iLeaf;
    private String iLevel;
    public void setCCode(String cCode) {
        this.cCode = cCode;
    }
    public String getCCode() {
        return cCode;
    }

    public void setCFullName(String cFullName) {
        this.cFullName = cFullName;
    }
    public String getCFullName() {
        return cFullName;
    }

    public void setCGUID(String cGUID) {
        this.cGUID = cGUID;
    }
    public String getCGUID() {
        return cGUID;
    }

    public void setCName(String cName) {
        this.cName = cName;
    }
    public String getCName() {
        return cName;
    }

    public void setCName1(String cName1) {
        this.cName1 = cName1;
    }
    public String getCName1() {
        return cName1;
    }

    public void setCParentID(String cParentID) {
        this.cParentID = cParentID;
    }
    public String getCParentID() {
        return cParentID;
    }

    public void setCurCode(String curCode) {
        this.curCode = curCode;
    }
    public String getCurCode() {
        return curCode;
    }

    public void setIAdjustRate(String iAdjustRate) {
        this.iAdjustRate = iAdjustRate;
    }
    public String getIAdjustRate() {
        return iAdjustRate;
    }

    public void setIBalanceDir(String iBalanceDir) {
        this.iBalanceDir = iBalanceDir;
    }
    public String getIBalanceDir() {
        return iBalanceDir;
    }

    public void setILeaf(String iLeaf) {
        this.iLeaf = iLeaf;
    }
    public String getILeaf() {
        return iLeaf;
    }

    public void setILevel(String iLevel) {
        this.iLevel = iLevel;
    }
    public String getILevel() {
        return iLevel;
    }
}
