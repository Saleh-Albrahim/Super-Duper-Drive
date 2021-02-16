package com.udacity.jwdnd.course1.cloudstorage.model.Credential;

public class Credential {
    private int credentialid;
    private String url;
    private String userName;
    private String key;
    private String password;
    private String decryptedPassword;
    private Integer userid;


    public Credential(int credentialid, String url, String userName, String key, String password, Integer userid) {
        this.credentialid = credentialid;
        this.url = url;
        this.userName = userName;
        this.key = key;
        this.password = password;
        this.userid = userid;
    }

    public Credential(int userid,String url, String userName, String decryptedPassword) {
        this.userid=userid;
        this.url = url;
        this.userName = userName;
        this.decryptedPassword = decryptedPassword;
    }
    public Credential(int userid,int credentialid,String url, String userName, String decryptedPassword) {
        this.userid=userid;
        this.credentialid=credentialid;
        this.url = url;
        this.userName = userName;
        this.decryptedPassword = decryptedPassword;
    }

    public String getDecryptedPassword() {
        return decryptedPassword;
    }

    public void setDecryptedPassword(String decryptedPassword) {
        this.decryptedPassword = decryptedPassword;
    }

    public Integer getCredentialid() {
        return credentialid;
    }

    public void setCredentialid(Integer credentialid) {
        this.credentialid = credentialid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}
