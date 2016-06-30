package comceleluengo.fb.petagram.vista;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import comceleluengo.fb.petagram.R;
import comceleluengo.fb.petagram.adaptadores.AnimalesAdapter;
import comceleluengo.fb.petagram.pojo.Animales;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {

    private RecyclerView recycler;
    private TextView tvPerfil;
    private ArrayList<Animales> items;

    public PerfilFragment(){
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        recycler = (RecyclerView) v.findViewById(R.id.reciclador);
        tvPerfil = (TextView) v.findViewById(R.id.tvPerfil);
        tvPerfil.setText("Jerry");

        //Mostramos en forma de Grid
        final GridLayoutManager glm= new GridLayoutManager(getActivity(),2, GridLayoutManager.VERTICAL,false);
        recycler.setLayoutManager(glm);

        inicializarMascotas();
        inicializarAdaptador();

        return v;

    }

    public void  inicializarAdaptador(){

        // Crear un nuevo adaptador
        AnimalesAdapter adapter = new AnimalesAdapter(items, getActivity());
        recycler.setAdapter(adapter);

    }
    public  void inicializarMascotas(){

        int cont=1;
        int i;

        items = new ArrayList<>();

        for (i=0;i<=4;i++){

            items.add(new Animales(0,R.drawable.jerry, "Jerry", cont));
            cont*=2;
        }

    }


}
