package db.danielshotel;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

import db.danielshotel.MainActivity;
import db.danielshotel.R;
import db.danielshotel.Reserva;
import db.danielshotel.ReservaAdapter;

public class MostrarReserves extends AppCompatActivity {

    private ListView listViewReserves;
    private ArrayList<Reserva> reserves;
    private Button inici, mostrarRserves;
    private ReservaAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mostrar_reserves_ui);

        inici = findViewById(R.id.buttonInici);
        listViewReserves = findViewById(R.id.listViewReserves);
        mostrarRserves = findViewById(R.id.buttonMostrarReserves);

        reserves = MainActivity.reserves;

        // Configura l'adaptador per a la llista de reserves
        adapter = new ReservaAdapter(this, R.layout.reserva_item, reserves);
        listViewReserves.setAdapter(adapter);

        inici.setOnClickListener(v -> inici());
        mostrarRserves.setOnClickListener(v -> mostrarReserves());

        // Mostra les reserves en la ListView
        actualitzarReservesListView();
    }

    public void inici() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    // Mostra les reserves per pantalla
    private void mostrarReserves() {
        // No és necessari fer res aquí, ja que les reserves ja s'estan mostrant a listViewReserves
    }

    // Actualitza les reserves a listViewReserves
    private void actualitzarReservesListView() {
        adapter.notifyDataSetChanged(); // Notifica al ListView que les dades han canviat
    }
}
