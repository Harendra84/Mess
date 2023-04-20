package com.gramtarang.mess.common;

public enum UserSatus {
    UNDEFINED(0),
    ACTIVE(1),
    INACTIVE(2);

    private int id;

    UserSatus(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public static UserSatus valueOf(int id) {
        switch (id) {
            case 1:
                return ACTIVE;
            case 2:
                return INACTIVE;
            default:
                return UNDEFINED;
        }
    }
}

