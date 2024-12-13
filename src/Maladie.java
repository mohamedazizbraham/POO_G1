public class Maladie {
    // Attributs
    private String nom;
    private float tauxTransmission;
    private float probaGuerison;
    private int periodeIncubation;
    private double probaDeces;
    private float dMax;
    private float p0;
    private Epidemie epidemie;

    // Constructeur
    public Maladie(String nom, float tauxTransmission, double probaGuerison, int periodeIncubation, double probaDeces, float dMax, double p0) {
        this.nom = nom;
        this.tauxTransmission = tauxTransmission;
        this.probaGuerison = (float) probaGuerison; // Conversion double -> float
        this.periodeIncubation = periodeIncubation;
        this.probaDeces = probaDeces;
        this.dMax = dMax;
        this.p0 = (float) p0; // Conversion double -> float
    }

    // Méthodes
    public double calculerProbTransmission(float distance) {
        return (distance <= dMax) ? p0 * (1 - distance / dMax) : 0;
    }

    // Getters
    public String getNom() {
        return nom;
    }

    public float getTauxTransmission() {
        return tauxTransmission;
    }

    public float getProbaGuerison() {
        return probaGuerison;
    }

    public int getPeriodeIncubation() {
        return periodeIncubation;
    }

    public double getProbaDeces() {
        return probaDeces;
    }

    public float getDMax() {
        return dMax;
    }

    public float getP0() {
        return p0;
    }
    public Epidemie getEpidemie() {
        return epidemie;
    }

    public void setEpidemie(Epidemie epidemie) {
        this.epidemie = epidemie;
    }
}
