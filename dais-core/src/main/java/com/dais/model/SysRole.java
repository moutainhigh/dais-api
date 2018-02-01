package com.dais.model;

public class SysRole {
    private Integer id;

    private String enname;

    private String chname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEnname() {
        return enname;
    }

    public void setEnname(String enname) {
        this.enname = enname == null ? null : enname.trim();
    }

    public String getChname() {
        return chname;
    }

    public void setChname(String chname) {
        this.chname = chname == null ? null : chname.trim();
    }
}