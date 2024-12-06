public class Vaccination {
    private int doseType;

    // Constructeur
    public Vaccination(int doseType) {
        this.doseType = doseType;
    }

    // Méthode
    public boolean confirmerVaccination(Individu individu) {
        if (doseType == 1 || doseType == 2) {
            individu.recevoirInfection();
            return true;
        }
        return false;
    }

    public int getDoseType() {
        return doseType;
    }
}
