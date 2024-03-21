package db.danielshotel;

public class Reserva {

    private String DNI;
    private String nom;
    private String preu;
    private String destinacio;


    public Reserva(String DNI, String nom, String preu, String destinacio) {
        this.DNI = DNI;
        this.nom = nom;
        this.preu = preu;
        this.destinacio = destinacio;
    }

    public String getDNI() {
        return DNI;
    }
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPreu() {
        return preu;
    }
    public void setPreu(String preu) {
        this.preu = preu;
    }

    public String getDestinacio() {
        return destinacio;
    }
    public void setDestinacio(String destinacio) {
        this.destinacio = destinacio;
    }

}
