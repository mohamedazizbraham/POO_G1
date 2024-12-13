import java.util.ArrayList;
import java.util.List;

public class Epidemie {
    private String nom; // Nom de l'épidémie
    private List<Maladie> maladies; // Liste des maladies associées

    // Constructeur
    public Epidemie(String nom) {
        this.nom = nom;
        this.maladies = new ArrayList<>();
    }

    // Ajouter une maladie à l'épidémie
    public void ajouterMaladie(Maladie maladie) {
        maladies.add(maladie);
        maladie.setEpidemie(this); // Lier la maladie à cette épidémie
    }

    // Récupérer le nom de l'épidémie
    public String getNom() {
        return nom;
    }

    // Récupérer la liste des maladies
    public List<Maladie> getMaladies() {
        return maladies;
    }
}
