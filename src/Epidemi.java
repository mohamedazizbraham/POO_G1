public class Epidemi {
    private String nom;
    private float tauxTransmission;
    private float probaGuerison;
    private int periodeIncubation;
    private double probaDeces;

    public Epidemie(String nom, float tauxTransmission, float probaGuerison, int periodeIncubation, double probaDeces) {
        this.nom = nom;
        this.tauxTransmission = tauxTransmission;
        this.probaGuerison = probaGuerison;
        this.periodeIncubation = periodeIncubation;
        this.probaDeces = probaDeces;
    }
}