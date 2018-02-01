package com.dais.model;

import java.util.Date;

public class User {
    private Integer fid;

    private String fnickName;

    private String frealName;

    private String ftelePhone;

    private String femail;

    private String floginPassword;

    private String ftradePassword;

    private String floginName;

    private String foldLoginName;

    private String fidentityNo;

    private Integer fidentityType;

    private Date fregisterTime;

    private Date flastLoginTime;

    private Date flastUpdateTime;

    private Boolean fhasRealValidate;

    private Boolean fisTelephoneBind;

    private Boolean fisMailValidate;

    private Boolean fpostRealValidate;

    private Boolean hasPayPwd;

    private Date fhasRealValidateTime;

    private Integer authStatus;

    private Integer fidentityStatus;

    private String fidentityPath;

    private String fidentityPath2;

    private String fidentityPath3;

    private String memWords;

    private String fheadImgUrl;

    private String token;

    private Date gagTime;

    private Integer walletStatus;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getFnickName() {
        return fnickName;
    }

    public void setFnickName(String fnickName) {
        this.fnickName = fnickName == null ? null : fnickName.trim();
    }

    public String getFrealName() {
        return frealName;
    }

    public void setFrealName(String frealName) {
        this.frealName = frealName == null ? null : frealName.trim();
    }

    public String getFtelePhone() {
        return ftelePhone;
    }

    public void setFtelePhone(String ftelePhone) {
        this.ftelePhone = ftelePhone == null ? null : ftelePhone.trim();
    }

    public String getFemail() {
        return femail;
    }

    public void setFemail(String femail) {
        this.femail = femail == null ? null : femail.trim();
    }

    public String getFloginPassword() {
        return floginPassword;
    }

    public void setFloginPassword(String floginPassword) {
        this.floginPassword = floginPassword == null ? null : floginPassword.trim();
    }

    public String getFtradePassword() {
        return ftradePassword;
    }

    public void setFtradePassword(String ftradePassword) {
        this.ftradePassword = ftradePassword == null ? null : ftradePassword.trim();
    }

    public String getFloginName() {
        return floginName;
    }

    public void setFloginName(String floginName) {
        this.floginName = floginName == null ? null : floginName.trim();
    }

    public String getFoldLoginName() {
        return foldLoginName;
    }

    public void setFoldLoginName(String foldLoginName) {
        this.foldLoginName = foldLoginName == null ? null : foldLoginName.trim();
    }

    public String getFidentityNo() {
        return fidentityNo;
    }

    public void setFidentityNo(String fidentityNo) {
        this.fidentityNo = fidentityNo == null ? null : fidentityNo.trim();
    }

    public Integer getFidentityType() {
        return fidentityType;
    }

    public void setFidentityType(Integer fidentityType) {
        this.fidentityType = fidentityType;
    }

    public Date getFregisterTime() {
        return fregisterTime;
    }

    public void setFregisterTime(Date fregisterTime) {
        this.fregisterTime = fregisterTime;
    }

    public Date getFlastLoginTime() {
        return flastLoginTime;
    }

    public void setFlastLoginTime(Date flastLoginTime) {
        this.flastLoginTime = flastLoginTime;
    }

    public Date getFlastUpdateTime() {
        return flastUpdateTime;
    }

    public void setFlastUpdateTime(Date flastUpdateTime) {
        this.flastUpdateTime = flastUpdateTime;
    }

    public Boolean getFhasRealValidate() {
        return fhasRealValidate;
    }

    public void setFhasRealValidate(Boolean fhasRealValidate) {
        this.fhasRealValidate = fhasRealValidate;
    }

    public Boolean getFisTelephoneBind() {
        return fisTelephoneBind;
    }

    public void setFisTelephoneBind(Boolean fisTelephoneBind) {
        this.fisTelephoneBind = fisTelephoneBind;
    }

    public Boolean getFisMailValidate() {
        return fisMailValidate;
    }

    public void setFisMailValidate(Boolean fisMailValidate) {
        this.fisMailValidate = fisMailValidate;
    }

    public Boolean getFpostRealValidate() {
        return fpostRealValidate;
    }

    public void setFpostRealValidate(Boolean fpostRealValidate) {
        this.fpostRealValidate = fpostRealValidate;
    }

    public Boolean getHasPayPwd() {
        return hasPayPwd;
    }

    public void setHasPayPwd(Boolean hasPayPwd) {
        this.hasPayPwd = hasPayPwd;
    }

    public Date getFhasRealValidateTime() {
        return fhasRealValidateTime;
    }

    public void setFhasRealValidateTime(Date fhasRealValidateTime) {
        this.fhasRealValidateTime = fhasRealValidateTime;
    }

    public Integer getAuthStatus() {
        return authStatus;
    }

    public void setAuthStatus(Integer authStatus) {
        this.authStatus = authStatus;
    }

    public Integer getFidentityStatus() {
        return fidentityStatus;
    }

    public void setFidentityStatus(Integer fidentityStatus) {
        this.fidentityStatus = fidentityStatus;
    }

    public String getFidentityPath() {
        return fidentityPath;
    }

    public void setFidentityPath(String fidentityPath) {
        this.fidentityPath = fidentityPath == null ? null : fidentityPath.trim();
    }

    public String getFidentityPath2() {
        return fidentityPath2;
    }

    public void setFidentityPath2(String fidentityPath2) {
        this.fidentityPath2 = fidentityPath2 == null ? null : fidentityPath2.trim();
    }

    public String getFidentityPath3() {
        return fidentityPath3;
    }

    public void setFidentityPath3(String fidentityPath3) {
        this.fidentityPath3 = fidentityPath3 == null ? null : fidentityPath3.trim();
    }

    public String getMemWords() {
        return memWords;
    }

    public void setMemWords(String memWords) {
        this.memWords = memWords == null ? null : memWords.trim();
    }

    public String getFheadImgUrl() {
        return fheadImgUrl;
    }

    public void setFheadImgUrl(String fheadImgUrl) {
        this.fheadImgUrl = fheadImgUrl == null ? null : fheadImgUrl.trim();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public Date getGagTime() {
        return gagTime;
    }

    public void setGagTime(Date gagTime) {
        this.gagTime = gagTime;
    }

    public Integer getWalletStatus() {
        return walletStatus;
    }

    public void setWalletStatus(Integer walletStatus) {
        this.walletStatus = walletStatus;
    }
}