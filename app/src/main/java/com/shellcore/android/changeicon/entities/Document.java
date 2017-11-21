package com.shellcore.android.changeicon.entities;

/**
 * Created by MOGC on 21/11/2017.
 */

public class Document {

    public static final int WAIT = 1;
    public static final int SEND = 2;
    public static final int DONE = 3;
    public static final int ERROR = 4;

    private String name;
    private int status;

    public Document() {
    }

    public Document(String name, int status) {
        this.name = name;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
