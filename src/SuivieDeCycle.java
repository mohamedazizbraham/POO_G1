import java.util.ArrayList;
import java.util.List;

public class SuivieDeCycle {
    private List<String> historique;

    public SuivieDeCycle() {
        historique = new ArrayList<>();
    }

    public void enregistrerCycle(Population population) {
        int healthy = 0, infected = 0, recovered = 0, diseased = 0;
        for (Individu individu : population.getIndividus()) {
            switch (individu.getEtat()) {
                case Sain -> healthy++;
                case Infecté -> infected++;
                case Guéri -> recovered++;
                case Décédé -> diseased++;
            }
        }
        historique.add("Sain: " + healthy + ", Infecté: " + infected + ", Guéri: " + recovered + ", Décédé: " + diseased);
    }

    public List<String> getHistorique() {
        return historique;
    }
}
