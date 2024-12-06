public class Variant extends Maladie {
    private int idVariant; // Identifiant unique pour différencier les variants

    // Constructeur
    public Variant(int idVariant, String nom, float tauxTransmission, double probaGuerison, int periodeIncubation, double probaDeces, float dMax, double p0) {
        super(nom, tauxTransmission, probaGuerison, periodeIncubation, probaDeces, dMax, p0);
        this.idVariant = idVariant;
    }

    // Getter pour l'identifiant du variant
    public int getIdVariant() {
        return idVariant;
    }
}
