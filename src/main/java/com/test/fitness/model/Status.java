package com.test.fitness.model;

public enum Status {
    TERDAFTAR("TERDAFTAR"), TIDAK_TERDAFTAR("TIDAK TERDAFTAR"), BELUM_TERVALIDASI("BELUM TERVALIDASI");

    private String displayName;

    Status(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
