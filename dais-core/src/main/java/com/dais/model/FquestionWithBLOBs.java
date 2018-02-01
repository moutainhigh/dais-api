package com.dais.model;

public class FquestionWithBLOBs extends Fquestion {
    private String fdesc;

    private String fanswer;

    public String getFdesc() {
        return fdesc;
    }

    public void setFdesc(String fdesc) {
        this.fdesc = fdesc == null ? null : fdesc.trim();
    }

    public String getFanswer() {
        return fanswer;
    }

    public void setFanswer(String fanswer) {
        this.fanswer = fanswer == null ? null : fanswer.trim();
    }
}