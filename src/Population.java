import java.util.ArrayList;
import java.util.List;

public class Population {
    private List<Individu> individus;
    private List<Variant> variantsActifs;

    public Population() {
        individus = new ArrayList<>();
        variantsActifs = new ArrayList<>();
    }

    public void ajouterIndividu(Individu individu) {
        individus.add(individu);
    }

    public void ajouterVariant(Variant variant) {
        variantsActifs.add(variant);
    }

    public void simulationCycle(SuivieDeCycle suivi) {
        for (Individu individu : individus) {
            if (individu.getEtat() == Etat.Infecté) {
                for (Individu autre : individus) {
                    if (individu == autre) continue;

                    // Identifier le variant qui affecte l'individu
                    Variant variant = variantsActifs.get(0); // Exemple : premier variant actif
                    float distance = individu.distance(autre);

                    if (distance <= variant.getDMax() && autre.getEtat() == Etat.Sain) {
                        double probaTransmission = variant.calculerProbTransmission(distance);
                        if (Math.random() < probaTransmission) {
                            autre.recevoirInfection(); // Transmission selon le variant
                        }
                    }
                }
            }
            individu.mettreAJourEtat();
        }
        suivi.enregistrerCycle(this);
    }

    public List<Individu> getIndividus() {
        return individus;
    }

    public List<Variant> getVariantsActifs() {
        return variantsActifs;
    }
}
