package com.jiyun.geeknews.bean;

public class WechatSearchbean {
    private String query;
    private int type;

    public WechatSearchbean(String query, int type) {
        this.query = query;
        this.type = type;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
