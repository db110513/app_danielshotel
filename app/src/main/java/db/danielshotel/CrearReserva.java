package db.danielshotel;

import android.content.Intent;
import android.os.Bundle;
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


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crear_reserva_ui);

        editTextDNI = findViewById(R.id.editTextDNI);
        editTextNom = findViewById(R.id.editTextNom);
        editTextPreu = findViewById(R.id.editTextPreu);
        inici = findViewById(R.id.buttonInici);
        crea = findViewById(R.id.buttonCrearReserva);

        inici.setOnClickListener(v -> inici());
        crea.setOnClickListener(v -> crearReserva());

    }

    private void crearReserva() {
        String DNI = editTextDNI.getText().toString();
        String nom = editTextNom.getText().toString();
        double preu = Double.parseDouble(editTextPreu.getText().toString());

        Reserva novaReserva = new Reserva(DNI, nom, preu);
        MainActivity.reserves.add(novaReserva);

        // Inflar el disseny personalitzat del Toast
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_layout, findViewById(R.id.custom_toast_layout));

        // Configurar el text del TextView en el disseny del Toast
        TextView text = layout.findViewById(R.id.textViewMessage);
        text.setText("Reserva creada amb èxit"); // Text dinàmic

        // Crear i mostrar el Toast personalitzat
        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }



    public void inici() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
