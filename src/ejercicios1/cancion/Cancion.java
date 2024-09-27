package ejercicios1.cancion;

import java.io.Serializable;

public class Cancion implements Serializable {
    private int id;
    private int anyo;
    private String titulo;
    private String artista;
    private String duracion;
    private boolean espanyol;

    public Cancion() {}

    public Cancion(int año, int id, String titulo, String artista, String duracion, boolean español) {
        this.anyo = año;
        this.id = id;
        this.titulo = titulo;
        this.artista = artista;
        this.duracion = duracion;
        this.espanyol = español;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public boolean isEspanyol() {
        return espanyol;
    }

    public void setEspanyol(boolean espanyol) {
        this.espanyol = espanyol;
    }

    public void mostrarDatosCancion() {
        System.out.println("ID: " + this.id);
        System.out.println("AÑO: " + this.anyo);
        System.out.println("TÍTULO: " + this.titulo);
        System.out.println("ARTISTA: " + this.artista);
        System.out.println("DURACIÓN: " + this.duracion);
        System.out.println("ESPAÑOL: " + this.espanyol);

    }
}
