package db.danielshotel;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EsborrarReserva extends AppCompatActivity {

    private EditText editTextDNI;
    private Button buttonEsborrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.esborrar_reserva_ui);

        editTextDNI = findViewById(R.id.editTextDNI);
        buttonEsborrar = findViewById(R.id.buttonEsborrar);

        buttonEsborrar.setOnClickListener(v -> esborrarReserva());
    }

    private void esborrarReserva() {
        String DNI = editTextDNI.getText().toString();

        // Busca la reserva amb el DNI indicat a l'ArrayList de MainActivity
        boolean reservaEsborrada = MainActivity.esborrarReserva(DNI);

        if (reservaEsborrada) {
            Toast.makeText(this, "Reserva esborrada amb èxit", Toast.LENGTH_SHORT).show();
        }

        else {
            Toast.makeText(this, "No s'ha trobat cap reserva amb aquest DNI", Toast.LENGTH_SHORT).show();
        }
    }
}
