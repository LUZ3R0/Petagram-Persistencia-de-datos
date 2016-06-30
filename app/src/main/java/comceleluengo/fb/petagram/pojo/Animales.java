package comceleluengo.fb.petagram.pojo;

/**
 * Created by Usuario on 06/05/2016.
 */
public class Animales {

    private int id, imagen, likes;
    private String nombre;


    public Animales(int id, int imagen, String nombre, int likes) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.id = id;
        this.likes = likes;
    }

    public Animales() {

    }

    public void setImagen(int imagen) { this.imagen = imagen; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getImagen() { return imagen; }

    public String getNombre() { return nombre; }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public int getLikes() { return likes; }

    public void setLikes(int likes) { this.likes = likes; }
}
