package com.example.jc346295.hotair;

public class Java {
    String name;
    String desc;

    Java(String nm, String ds)
    {
        name = nm;
        desc = ds;
    }

    @Override
    public String toString()
    {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}
