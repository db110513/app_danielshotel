package db.danielshotel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.Nullable;


import androidx.annotation.NonNull;

import java.util.ArrayList;

public class ReservaAdapter extends ArrayAdapter<Reserva> {

    private Context mContext;
    private int mResource;

    public ReservaAdapter(Context context, int resource, ArrayList<Reserva> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);
        }

        // Obtenir la reserva actual
        Reserva reserva = getItem(position);

        // Obté les referències als elements de la vista
        TextView textViewDNI = convertView.findViewById(R.id.textViewDNI);
        TextView textViewNom = convertView.findViewById(R.id.textViewNom);
        TextView textViewPreu = convertView.findViewById(R.id.textViewPreu);
        TextView textViewDestinacio = convertView.findViewById(R.id.textViewDestinacio);

        // Assigna les dades de la reserva als elements de la vista
        if (reserva != null) {
            textViewDNI.setText(reserva.getDNI());
            textViewNom.setText(reserva.getNom());
            textViewDestinacio.setText(reserva.getDestinacio());
        }

        return convertView;
    }
}
