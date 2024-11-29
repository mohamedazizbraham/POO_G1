public class Individu {
private Etat etat;
private sensibilité sensibilite;
private int cycleResistance;
private float x;
private float y;
private String sensitivite;
private boolean infecter;
private boolean guerie;

public Individu(Etat etat, float x, float y, String sensitivite) {
    this.etat = etat;
    this.x = x;
    this.y = y;
    this.sensitivite = sensitivite;
    this.infecter = false;
    this.guerie = false;
    this.cycleResistance = 0;
}}
