package cat.dam.andy.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements CustomRecyclerView.ItemClickListener {

    //member variables
    private final ArrayList<Item> items = new ArrayList<>();
    private RecyclerView rv_items;
    private CustomRecyclerView myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initData();
        initDataAdapter();
        initListeners();
    }

    private void initViews() {
        rv_items = findViewById(R.id.rv_items);
    }

    private void initData() {
        //Creem els items
        items.add(new Item(1,  "Pomes", "Pomes Fuji! De l'Empordà. Les millors del món!!!", R.drawable.apple, 3.15));
        items.add(new Item(2,  "Plàtans", "Platans de Canàries, ideals per recuperar l'energia!!!", R.drawable.banana, 4.45));
        items.add(new Item(3,  "Peres", "Riques i sucoses peres per als amants de les fruites de la millor qualitat", R.drawable.pear, 3.12));
        items.add(new Item(4,  "Madueixes", "Maduixes amb gran qualitat ia un preu assequible!!!", R.drawable.strawberry, 5.6));
        items.add(new Item(5,  "Taronges", "Veritables taronges de València. Boníssimes!!", R.drawable.orange, 1.2));
        items.add(new Item(6,  "Mandarines", "Mandarines molt dolces", R.drawable.mandarin, 1.18));
        items.add(new Item(7,  "Pomelos", "Pomelos de l'Horta. Les has de provar!!!", R.drawable.pomelo, 5.3));
        items.add(new Item(8,  "Prunes", "Si t'agraden les prunes, aquestes són les teves, són boníssimes!!!", R.drawable.plum, 3.2));
        items.add(new Item(9,  "Raïms", "No cal que esperis al cap d'any a comprar raïms. Aquests són de la millor qualitat!!!", R.drawable.grapes, 2.3));
        items.add(new Item(10,  "Melons", "Melons dolços i refrescants amb la qualitat garantida!!!", R.drawable.muskmelon, 1.03));
    }

    private void initDataAdapter() {
        //Creem l'adaptador
        myAdapter = new CustomRecyclerView(this, items);
        //Establim l'adaptador i el layout manager
        rv_items.setAdapter(myAdapter);
        rv_items.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initListeners() {
        //Establim el capturador d'esdeveniments de pulsacions d'elements; en aquest cas som nosaltres mateixos. És el mètode onClick
        myAdapter.setOnClickListener(this);
    }

    @Override
    //Gestionem el click de l'usuari al RecyclerView
    public void onClick(View view, int position) {
        Toast.makeText(this, getString(R.string.haspressed,position), Toast.LENGTH_SHORT).show();
    }
}