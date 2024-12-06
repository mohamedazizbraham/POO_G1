public class Individu {
    private Etat etat; // HEALTHY, INFECTED, RECOVERED, DISEASED
    private sensibilité sensibilite; // SENSIBLE, NEUTRE, RESISTANT
    private boolean vaccine; // Indique si l'individu est vacciné
    private boolean guerie; // Indique si l'individu est guéri
    private float x, y; // Position dans l'espace 2D

    public Individu(Etat etat, sensibilité sensibilite, float x, float y) {
        this.etat = etat;
        this.sensibilite = sensibilite;
        this.x = x;
        this.y = y;
        this.vaccine = false;
        this.guerie = false;
    }

    public boolean isGuerie() {
        return guerie;
    }

    public boolean isVacciné() {
        return vaccine;
    }

    public void recevoirVaccination(int doses) {
        if (doses >= 1) {
            this.sensibilite = sensibilité.Resistant; // Rend l'individu résistant
        }
        if (doses == 2) {
            this.vaccine = true; // Immunité complète
        }
    }

    public Etat getEtat() {
        return etat;
    }

    public void recevoirInfection() {
        if (etat == Etat.Sain) {
            this.etat = Etat.Infecté;
        }
    }

    public void mettreAJourEtat() {
        if (etat == Etat.Infecté) {
            if (Math.random() < 0.4) { // Probabilité de guérison
                this.etat = Etat.Guéri;
                this.guerie = true;
            } else if (Math.random() < 0.1) { // Probabilité de décès
                this.etat = Etat.Décédé;
            }
        }
    }

    public float distance(Individu autre) {
        return (float) Math.sqrt(Math.pow(this.x - autre.x, 2) + Math.pow(this.y - autre.y, 2));
    }
}
