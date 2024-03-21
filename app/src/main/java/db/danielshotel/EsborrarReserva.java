package db.danielshotel;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class EsborrarReserva extends AppCompatActivity {

    private EditText editTextDNI;
    private Button buttonEsborrar, buttonInici;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.esborrar_reserva_ui);

        editTextDNI = findViewById(R.id.editTextDNI);
        buttonEsborrar = findViewById(R.id.buttonEsborrar);
        buttonInici = findViewById(R.id.buttonInici);

        buttonEsborrar.setOnClickListener(v -> esborrarReserva());
        buttonInici.setOnClickListener(v -> inici());
    }

    private void esborrarReserva() {
        LayoutInflater inflater;
        View layout;

        String DNI = editTextDNI.getText().toString();

        if (TextUtils.isEmpty(DNI)) {
            inflater = getLayoutInflater();
            layout = inflater.inflate(R.layout.toast_layout, findViewById(R.id.custom_toast));

            TextView text = layout.findViewById(R.id.textViewMessage);
            text.setText("Omple el camp DNI");

            Toast toast = new Toast(getApplicationContext());
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setView(layout);
            toast.show();

            return;
        }



        // Busca la reserva amb el DNI indicat a l'ArrayList de MainActivity
        boolean reservaEsborrada = MainActivity.esborrarReserva(this, DNI);

        if (reservaEsborrada) {
            inflater = getLayoutInflater();
            layout = inflater.inflate(R.layout.toast_layout, findViewById(R.id.custom_toast));

            TextView text = layout.findViewById(R.id.textViewMessage);
            text.setText("Reserva esborrada correctament");

            Toast toast = new Toast(getApplicationContext());
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setView(layout);
            toast.show();

            inici();
        }

        else {
            inflater = getLayoutInflater();
            layout = inflater.inflate(R.layout.toast_layout, findViewById(R.id.custom_toast));

            TextView text = layout.findViewById(R.id.textViewMessage);
            text.setText("No s'ha esborrat la reserva");

            Toast toast = new Toast(getApplicationContext());
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setView(layout);
            toast.show();
        }

    }

    private void inici() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

}
