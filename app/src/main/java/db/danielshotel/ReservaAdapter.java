package db.danielshotel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;


public class ReservaAdapter extends ArrayAdapter<Reserva> {

    private Context context;
    private int layoutResourceId;
    private ArrayList<Reserva> reserves;

    public ReservaAdapter(Context context, int layoutResourceId, ArrayList<Reserva> reserves) {
        super(context, layoutResourceId, reserves);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.reserves = reserves;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ReservaHolder holder;

        if (row == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new ReservaHolder();
            holder.textViewDNI = row.findViewById(R.id.textViewDNI);
            holder.textViewNom = row.findViewById(R.id.textViewNom);
            holder.textViewPreu = row.findViewById(R.id.textViewPreu);

            row.setTag(holder);
        } else {
            holder = (ReservaHolder) row.getTag();
        }

        Reserva reserva = reserves.get(position);
        holder.textViewDNI.setText(String.valueOf(reserva.getDNI()));
        holder.textViewNom.setText(reserva.getNom());
        holder.textViewPreu.setText(String.valueOf(reserva.getPreu()));

        return row;
    }

    static class ReservaHolder {
        TextView textViewDNI;
        TextView textViewNom;
        TextView textViewPreu;
    }
}
