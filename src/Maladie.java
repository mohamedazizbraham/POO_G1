public class Maladie {
    private String nom;
    private float tauxTransmission;
    private float probaGuerison;
    private int periodeIncubation;
    private double probaDeces;
    private float dMax;
    private float p0;

    public Maladie(String nom, float tauxTransmission, float probaGuerison, int periodeIncubation, double probaDeces, float dMax, float p0) {
        this.nom = nom;
        this.tauxTransmission = tauxTransmission;
        this.probaGuerison = probaGuerison;
        this.periodeIncubation = periodeIncubation;
        this.probaDeces = probaDeces;
        this.dMax=dMax;
        this.p0=p0;
    }


}