package comceleluengo.fb.petagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import comceleluengo.fb.petagram.adaptadores.AnimalesAdapter;
import comceleluengo.fb.petagram.basedatos.ConstructorBD;
import comceleluengo.fb.petagram.pojo.Animales;

public class MisFavoritos extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView recycler;
    ArrayList items;
    private ConstructorBD constructor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_favoritos);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        //botón de subir
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //cambiamos el título de appbar
        getSupportActionBar().setTitle("    Mis favoritos");

        //Agregamos el Icono
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.cat);

        //Cargamos los datos de la base de datos a un ArrayList
        constructor = new ConstructorBD(this);
        items = new ArrayList<Animales>();
        items = constructor.obtenerDatos();

        // Ordenamos los datos de forma ascendente, según la cantidad de likes que tienen
        Collections.sort(items, new Comparator<Animales>() {
            //@Override
            public int compare(Animales p1, Animales p2) {
                // Comparamos el atributo likes de p2 con el de p1
                return new Integer(p2.getLikes()).compareTo(new Integer(p1.getLikes()));
            }
        });

        //Obtenemos los 5 que tienen mas cantidad de likes
        items= new ArrayList<>(items.subList(0,5));


        if (!items.isEmpty()) {
            recycler = (RecyclerView) findViewById(R.id.reciclador);
            recycler.setHasFixedSize(true);
            LinearLayoutManager lManager = new LinearLayoutManager(this);
            lManager.setOrientation(LinearLayoutManager.VERTICAL);
            recycler.setLayoutManager(lManager);
            recycler.setClickable(false);
            recycler.setEnabled(false);
            recycler.setLayoutFrozen(true);
            AnimalesAdapter adapter = new AnimalesAdapter(items, this);
            recycler.setAdapter(adapter);
        }

    }

}