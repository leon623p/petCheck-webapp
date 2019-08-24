package com.petcheck.petcheck.model.Guides;

public class Guide {

    private String name;
    private String body;
    private String tag;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Guide(String name, String body) {
        this.name = name;
        this.body = body;
        this.tag = "general";
    }
}

