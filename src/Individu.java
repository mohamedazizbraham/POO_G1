public class Individu {
private Etat etat;
private sensibilité sensibilite;
private int cycleResistance;
private float x;
private float y;
private boolean infecter;
private boolean guerie;


public Individu(Etat etat, float x, float y, String sensitivite) {
    this.etat = etat;
    this.x = x;
    this.y = y;
    this.sensibilite = sensibilite;
    this.infecter = false;
    this.guerie = false;
    this.cycleResistance = 0;
}
public float distance() {

    return 0;
}
    public float misaAjourPosition() {

        return 0;
    }
    public String mettreAjourEtat() {


        return "";
    }
    public boolean recevoirInfection() {


        return false;
    }
}
