package com.strafeup.cashiersystemspring.entity;

public enum Status {
    OPEN, CLOSED, IN_DISPUTE;

    public static Status getStatusById(int id) {
        switch (id) {
            case 1:
                return OPEN;
            case 2:
                return CLOSED;
            case 3:
                return IN_DISPUTE;

            default:
                throw new IllegalArgumentException("Can't get role for id: " + id);
        }
    }

    public int getId() {
        return this.ordinal() + 1;
    }
}
