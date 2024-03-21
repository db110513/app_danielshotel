package db.danielshotel;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;


public class CrearReserva extends AppCompatActivity {

    private Button inici;
    private Button crea;

    private EditText editTextDNI;
    private EditText editTextNom;
    private EditText editTextPreu;
    private EditText editTextDestinacio;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crear_reserva_ui);

        editTextDNI = findViewById(R.id.editTextDNI);
        editTextNom = findViewById(R.id.editTextNom);
        editTextPreu = findViewById(R.id.editTextPreu);
        editTextDestinacio = findViewById(R.id.editTextDestinacio);

        inici = findViewById(R.id.buttonInici);
        crea = findViewById(R.id.buttonCrearReserva);

        inici.setBackgroundColor(Color.WHITE);
        crea.setBackgroundColor(Color.WHITE);

        inici.setOnClickListener(v -> inici());
        crea.setOnClickListener(v -> crearReserva());

    }

    private void crearReserva() {
        LayoutInflater inflater;
        View layout;

        String DNI = editTextDNI.getText().toString();
        String nom = editTextNom.getText().toString();
        String preu = editTextPreu.getText().toString();
        String destinacio = editTextDestinacio.getText().toString();

        // Verificar que els camps no estiguin buits
        if (TextUtils.isEmpty(DNI) || TextUtils.isEmpty(nom) || TextUtils.isEmpty(preu) || TextUtils.isEmpty(destinacio)) {
            inflater = getLayoutInflater();
            layout = inflater.inflate(R.layout.toast_layout, findViewById(R.id.custom_toast));

            TextView text = layout.findViewById(R.id.textViewMessage);
            text.setText("Omple tots els camps");

            Toast toast = new Toast(getApplicationContext());
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setView(layout);
            toast.show();

            return;
        }

        Reserva novaReserva = new Reserva(DNI, nom, preu, destinacio);
        MainActivity.reserves.add(novaReserva);

        // Continuar amb la lògica per crear la reserva

        // Configurar el text del TextView en el disseny del Toast
        inflater = getLayoutInflater();
        layout = inflater.inflate(R.layout.toast_layout, findViewById(R.id.custom_toast));
        TextView text = layout.findViewById(R.id.textViewMessage);
        text.setText("Reserva creada amb èxit");

        // Crear i mostrar el Toast personalitzat
        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }



    public void inici() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
