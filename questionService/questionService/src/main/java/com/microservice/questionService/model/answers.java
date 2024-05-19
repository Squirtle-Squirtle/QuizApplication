package com.microservice.questionService.model;

public class answers {
    private Integer id;
    private String resp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResp() {
        return resp;
    }

    public answers(Integer id, String resp) {
        this.id = id;
        this.resp = resp;
    }

    public void setResp(String resp) {
        resp = resp;
    }
}
