package db.danielshotel;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private Button buttonCrearReserva;
    private Button buttonMostrar;
    private Button buttonModificarReserva;
    private Button buttonEsborrarReserva;
    private Button buttonSortir;

    // ArrayList per emmagatzemar les reserves
    public static ArrayList<Reserva> reserves;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reserves = new ArrayList<>();

        buttonCrearReserva = findViewById(R.id.buttonCrearReserva);
        buttonMostrar = findViewById(R.id.buttonMostrar);
        buttonModificarReserva = findViewById(R.id.buttonModificarReserva);
        buttonEsborrarReserva = findViewById(R.id.buttonEsborrarReserva);
        buttonSortir = findViewById(R.id.buttonSortir);


        buttonCrearReserva.setOnClickListener(v -> navgA(CrearReserva.class));
        buttonMostrar.setOnClickListener(v -> navgA(MostrarReserves.class));
        buttonModificarReserva.setOnClickListener(v -> navgA(ModificarReserva.class));
        buttonEsborrarReserva.setOnClickListener(v -> navgA(EsborrarReserva.class));

        buttonSortir.setOnClickListener(v -> atura());

    }

    // Mètode per esborrar una reserva segons el DNI
    public static boolean esborrarReserva(Context context, String DNI) {
        LayoutInflater inflater;
        View layout;

        if (DNI.isEmpty()) {
            Toast.makeText(context, "El camp DNI està buit", Toast.LENGTH_LONG).show();
            return false;
        }

        for (Reserva reserva : reserves) {
            if (reserva.getDNI().equals(DNI)) {
                reserves.remove(reserva);
                return true;
            }
        }
        return false;
    }

    private void atura() {
        finishAffinity();
        System.exit(0);
    }

    public void navgA(Class<?> classeDesti) {
        Intent i = new Intent(this, classeDesti);
        startActivity(i);
    }

    private void inici() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }


}
