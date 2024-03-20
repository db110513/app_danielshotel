package db.danielshotel;


import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;

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


        buttonCrearReserva.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, CrearReserva.class);
            startActivity(i);
        });


        buttonMostrar.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, MostrarReserves.class);
            startActivity(i);
        });


        buttonModificarReserva.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, ModificarReserva.class);
            startActivity(i);
        });


        buttonEsborrarReserva.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, EsborrarReserva.class);
            startActivity(i);
        });


        buttonSortir.setOnClickListener(v -> finish());

    }

    // Mètode per esborrar una reserva segons el DNI
    public static boolean esborrarReserva(String DNI) {
        for (Reserva reserva : reserves) {
            if (reserva.getDNI() == DNI) {
                reserves.remove(reserva);
                return true;
            }
        }
        return false;
    }

}
