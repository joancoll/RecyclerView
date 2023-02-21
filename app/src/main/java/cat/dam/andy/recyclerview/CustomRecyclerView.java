package cat.dam.andy.recyclerview;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomRecyclerView extends RecyclerView.Adapter<CustomRecyclerView.ViewHolder>{

    //Interface perquè MainActivity o qualsevol altra activitat implementi el listener i poder capturar l'esdeveniment
    //fora de l'adaptador
    public interface ItemClickListener {
        void onClick(View view, int position);
    }

    //Aquí podem passar qualsevol tipus de col·lecció d'objectes
    private final ArrayList<Item> dataSet;
    //L'utilitzem per poder capturar els clics sobre els elements fora de l'adaptador
    private ItemClickListener clicListener;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //Aquí obtenim la referència als nostres elements visuals
        private final TextView tv_item_name;
        private final TextView tv_item_desc;
        private final TextView tv_item_price;
        private final ImageView iv_item_image;

        public ViewHolder(View view) {
            super(view);
            // Defineix clic listener per a ViewHolder's View
            view.setOnClickListener(this);
            tv_item_name =  view.findViewById(R.id.tv_item_name);
            tv_item_desc =  view.findViewById(R.id.tv_item_desc);
            tv_item_price = view.findViewById(R.id.tv_item_price);
            iv_item_image =  view.findViewById(R.id.iv_item_image);
        }

        //Getters
        public TextView getTv_item_name() {
            return tv_item_name;
        }
        public TextView getTv_item_desc() {
            return tv_item_desc;
        }
        public TextView getTv_item_price() {
            return tv_item_price;
        }
        public ImageView getIv_item_image() {
            return iv_item_image;
        }

        //Això propaga l'esdeveniment cap a fora, així podem capturar-lo al punt que vulguem de
        //la nostra aplicació
        @Override
        public void onClick(View view) {
            clicListener.onClick(view, getAdapterPosition());
        }
    }

    //Constructor, aquí passem els ítems que mostrarem, és a dir, el model de dades
    public CustomRecyclerView(Context context, ArrayList<Item> dataSet) {
        this.dataSet = dataSet;
    }

    //Aquest mètode s'utilitza des de l'activitat que captura l'esdeveniment de clic dels ítems
    public void setOnClickListener(ItemClickListener clicListener){
        this.clicListener = clicListener;
    }

    //Només es crida la primera vegada en crear la llista
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        //Creem la vista de cada ítem a partir del nostre layout
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_item, viewGroup, false);
        return new ViewHolder(view);
    }

    //Es crida cada vegada que es fa scroll a la pantalla i els elements desapareixen i apareixen
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        //Setegem els valors en cada camp dels que hem obtingut al constructor del ViewHolder
        viewHolder.getTv_item_name().setText(dataSet.get(position).getName());
        viewHolder.getTv_item_desc().setText(dataSet.get(position).getDescription());
        String price = dataSet.get(position).getPrice() +" €";
        viewHolder.getTv_item_price().setText(price);
        viewHolder.getIv_item_image().setImageResource(dataSet.get(position).getImageResourceID());
    }

    // Tornem el nombre d'ítems del nostre arraylist, l'invoca automàticament el layout manager
    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
