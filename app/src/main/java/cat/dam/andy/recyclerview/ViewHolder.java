package cat.dam.andy.recyclerview;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {

    //El ViewModel fa de pont amb els Views de la interficie gràfica
    //Members
    private TextView name,desc,price;
    private ImageView image;
    private Context context;

    public ViewHolder(Context parent, View itemView) {
        super(itemView);
        name =  itemView.findViewById(R.id.tv_item_name);
        desc =  itemView.findViewById(R.id.tv_item_desc);
        price = itemView.findViewById(R.id.tv_item_price);
        image = itemView.findViewById(R.id.iv_item_image);
        context = parent;
        // Defineix clic listener per els elements de la llista
        itemView.setOnClickListener(this);
    }
    //Getters
    public TextView getName() {
        return name;
    }
    public TextView getDesc() {
        return desc;
    }
    public TextView getPrice() {
        return price;
    }
    public ImageView getImage() {
        return image;
    }

    @Override
    public void onClick(View view) {
        //Podem propagar l'esdeveniment a la MainActivity gràcies al context
        //així podem gestionar el click al punt que vulguem de la nostra aplicació
        MainActivity mainActivity = (MainActivity) context;
        mainActivity.itemClick(view, getAdapterPosition());
    }
}
