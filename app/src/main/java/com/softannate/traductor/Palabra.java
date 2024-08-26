package com.softannate.traductor;

public class Palabra {
    private String espaniol;
    private String ingles;
    private Integer imagen;

    public Palabra(String espaniol,  String ingles, Integer imagen) {
        this.espaniol = espaniol;
        this.ingles = ingles;
        this.imagen = imagen;
    }

    public String getEspaniol() {
        return espaniol;
    }

    public String getIngles() {
        return ingles;
    }

    public Integer getImagen() {
        return imagen;
    }

    public void setEspaniol(String espaniol) {
        this.espaniol = espaniol;
    }

    public void setIngles(String ingles) {
        this.ingles = ingles;
    }

    public void setImagen(Integer imagen) {
        this.imagen = imagen;
    }
}
