package db.danielshotel;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
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

    private static final int MAX_LENGTH = 9;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crear_reserva_ui);

        editTextDNI = findViewById(R.id.editTextDNI);

        // obliga EditText a tindre 9 char
        editTextDNI.setFilters(new InputFilter[] { new MaxLengthFilter(9) });

        editTextNom = findViewById(R.id.editTextNom);
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
        String destinacio = editTextDestinacio.getText().toString();

        // Verificar que els camps no estiguin buits
        if (TextUtils.isEmpty(DNI) || TextUtils.isEmpty(nom) || TextUtils.isEmpty(destinacio)) {
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

        Reserva novaReserva = new Reserva(DNI, nom, destinacio);
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

        inici();

    }

    // dni vàlid -> 8 num + 1 lletra
    private InputFilter dniValid() {
        return new InputFilter.LengthFilter(9) {
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                // 9 caràcters
                if (end == 9) {
                    String dni = source.toString();
                    if (dni.matches("\\d{8}[a-zA-Z]")) {
                        return null; // L'entrada és vàlida
                    } else {
                        return "";
                    }
                }
                // Restricció de longitud
                else {
                    return null;
                }
            }
        };
    }


    public void inici() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
