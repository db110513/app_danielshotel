package db.danielshotel;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MostrarReserves extends AppCompatActivity {

    private ListView listViewReserves;
    private ArrayList<Reserva> reservesList;
    private Button inici;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mostrar_reserves_ui);

        inici = findViewById(R.id.buttonInici);
        listViewReserves = findViewById(R.id.listViewReserves);

        reservesList = MainActivity.reserves;

        ReservaAdapter adapter = new ReservaAdapter(this, R.layout.reserva_item, reservesList);
        listViewReserves.setAdapter(adapter);

        inici.setOnClickListener(v -> inici());

    }

    public void inici() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

}
