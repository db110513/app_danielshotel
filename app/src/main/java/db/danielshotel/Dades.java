package db.danielshotel;

import java.util.ArrayList;


public class Dades {

    private static ArrayList<Reserva> llistaReserves = new ArrayList<>();

    public static void afegirReserva(Reserva reserva) {
        llistaReserves.add(reserva);
    }

    public static ArrayList<Reserva> getLlistaReserves() {
        return llistaReserves;
    }

    public static void actualitzarReserva(String dni, Reserva reservaActualitzada) {
        for (int i = 0; i < llistaReserves.size(); i++) {
            if (llistaReserves.get(i).getDNI().toString().equals(dni)) {
                llistaReserves.set(i, reservaActualitzada);
                break;
            }
        }
    }

    public static void esborrarReserva(String dni) {
        for (int i = 0; i < llistaReserves.size(); i++) {
            if (llistaReserves.get(i).getDNI().equals(dni)) {
                llistaReserves.remove(i);
                break;
            }
        }
    }

}
