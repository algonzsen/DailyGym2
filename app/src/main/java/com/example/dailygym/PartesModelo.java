package com.example.dailygym;

public class PartesModelo {
    private String parte;
    private int fotoParte;

    public PartesModelo() {
    }

    public PartesModelo(String parte, int fotoParte) {
        this.parte = parte;
        this.fotoParte = fotoParte;
    }

    public String getParte() {
        return parte;
    }

    public void setParte(String parte) {
        this.parte = parte;
    }

    public int getFotoParte() {
        return fotoParte;
    }

    public void setFotoParte(int fotoParte) {
        this.fotoParte = fotoParte;
    }
}
