package com.example.dailygym.ui.rutina;

class Rutinas {
    private String parte;
    private int fotoRutina;

    public Rutinas() {
    }

    public Rutinas(String parte, int fotoRutina) {
        this.parte = parte;
        this.fotoRutina = fotoRutina;
    }


    public String getParte() {
        return parte;
    }

    public void setParte(String parte) {
        this.parte = parte;
    }

    public int getFotoRutina() {
        return fotoRutina;
    }

    public void setFotoRutina(int fotoRutina) {
        this.fotoRutina = fotoRutina;
    }
}
