package comceleluengo.fb.petagram.adaptadores;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import comceleluengo.fb.petagram.basedatos.ConstructorBD;
import comceleluengo.fb.petagram.pojo.Animales;
import comceleluengo.fb.petagram.R;
import comceleluengo.fb.petagram.presentador.RecyclerViewFragmentPresenter;

public class AnimalesAdapter extends RecyclerView.Adapter<AnimalesAdapter.AnimalesViewHolder>{

    private ArrayList<Animales> items;
    Activity activity;


    public static class AnimalesViewHolder extends RecyclerView.ViewHolder {

        // Campos de un item
        private ImageView imagen;
        private TextView nombre, likes;
        private ImageButton raiting;

        public AnimalesViewHolder(View v) {
            super(v);
            imagen = (ImageView) v.findViewById(R.id.imgImagen);
            nombre = (TextView) v.findViewById(R.id.tvNombre);
            likes = (TextView) v.findViewById(R.id.tvNumHuesitos);
            raiting = (ImageButton) v.findViewById(R.id.imgraiting);

        }
    }

    public AnimalesAdapter(ArrayList<Animales> items, Activity activity) {

        this.items = items;
        this.activity = activity;

    }

    //Cantidad de elementos que contiene mi lista
    @Override
    public int getItemCount() {

        return items.size();
    }


    //Infla el layout y lo pasa al viewHolder para que el obtenga los views
    @Override
    public AnimalesViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.animales_card, viewGroup, false);
        return new AnimalesViewHolder(v);
    }

    //Asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(final AnimalesViewHolder viewHolder, int i) {

        final Animales an = items.get(i);
        viewHolder.imagen.setImageResource(an.getImagen());
        viewHolder.nombre.setText(an.getNombre());

        //Obtenemos los likes de manera que cuando hagamos scroll en el rv se siga manteniendo el valor actual
        ConstructorBD constructorBD = new ConstructorBD(activity);
        viewHolder.likes.setText(String.valueOf(constructorBD.obtenerLikesAnimales(an)));


        viewHolder.raiting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toast.makeText(activity, "Diste like a " + an.getNombre(), Toast.LENGTH_SHORT).show();

                ConstructorBD constructorBD = new ConstructorBD(activity);
                constructorBD.darLike(an);
                viewHolder.likes.setText(String.valueOf(constructorBD.obtenerLikesAnimales(an)));

            }

        });
    }



}
