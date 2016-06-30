package comceleluengo.fb.petagram.presentador;

import android.content.Context;

import java.util.ArrayList;

import comceleluengo.fb.petagram.basedatos.ConstructorBD;
import comceleluengo.fb.petagram.pojo.Animales;
import comceleluengo.fb.petagram.vista.IRecyclerViewFragmentView;

/**
 * Created by Usuario on 13/06/2016.
 */
public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorBD constructor;
    private ArrayList<Animales> animales;


    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerContactosBaseDatos();
    }

    @Override
    public void obtenerContactosBaseDatos() {
        constructor = new ConstructorBD(context);
        animales = constructor.obtenerDatos();
        mostrarContactosRV();

    }

    @Override
    public void mostrarContactosRV() {

        iRecyclerViewFragmentView.inicializarAdaptador(iRecyclerViewFragmentView.crearAdaptador(animales));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }

}
