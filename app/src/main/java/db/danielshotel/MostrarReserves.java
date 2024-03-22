package db.danielshotel;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MostrarReserves extends AppCompatActivity {

    private ListView listViewReserves;
    private ArrayList<Reserva> reserves;
    private Button inici, mostrarReservesButton;
    private ReservaAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mostrar_reserves_ui);

        inici = findViewById(R.id.buttonInici);
        listViewReserves = findViewById(R.id.listViewReserves);
        mostrarReservesButton = findViewById(R.id.buttonMostrarReserves);

        // Obtenim l'ArrayList de reserves de MainActivity
        reserves = MainActivity.reserves;

        // adaptador amb les reserves vinculat al ListView
        adapter = new ReservaAdapter(this, R.layout.reserva_item, reserves);
        listViewReserves.setAdapter(adapter);

        inici.setOnClickListener(v -> inici());
        mostrarReservesButton.setOnClickListener(v -> mostrarReserves());
    }

    // Navega a l'activitat MainActivity
    public void inici() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    // Mostra les reserves en la ListView
    private void mostrarReserves() {
        // Actualitzem les dades de l'adaptador (per si han canviat des de l'última vegada)
        adapter.notifyDataSetChanged();
    }
}
