public class ComportementSocial extends Individu {
    private boolean distanciation;
    private boolean protection;

    public ComportementSocial(Etat etat, sensibilité sensibilite, float x, float y, boolean distanciation, boolean protection) {
        super(etat, sensibilite, x, y);
        this.distanciation = distanciation;
        this.protection = protection;
    }

    public float ajusterTransmission(float p0) {
        if (protection) {
            p0 *= 0.5;
        }
        if (distanciation) {
            p0 *= 0.75; // Doublement de la distance = 25% moins de transmissions
        }
        return p0;
    }
}
