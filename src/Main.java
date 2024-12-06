public class Main {
    public static void main(String[] args) {
        // Initialisation des constantes
        final int populationSize = 100; // Taille de la population
        final int cycles = 10; // Nombre de cycles de simulation
        final int initialInfectedPercentage = 20; // 20% de la population sera infectée au départ

        // Création de la population
        Population population = new Population();
        for (int i = 0; i < populationSize; i++) {
            float x = (float) (Math.random() * 10);
            float y = (float) (Math.random() * 10);

            // 20% infectés au départ
            Etat etat = (i < populationSize * initialInfectedPercentage / 100) ? Etat.Infecté : Etat.Sain;

            // Tous les individus commencent avec une sensibilité neutre
            sensibilité sensibilite = sensibilité.Neutre;

            // Création de l'individu avec son état, sa sensibilité et sa position
            Individu individu = new Individu(etat, sensibilite, x, y);
            population.ajouterIndividu(individu);
        }

        // Création de la maladie de base
        Variant variant1 = new Variant(
                1,
                "Variant Alpha",
                0.3f,    // Taux de transmission réduit
                0.6,     // Probabilité de guérison augmentée
                2,       // Période d'incubation
                0.05,    // Probabilité de décès réduite
                8f,      // Distance maximale de transmission réduite
                0.4      // Taux de transmission initial réduit
        );
        population.ajouterVariant(variant1);

        // Suivi des cycles
        SuivieDeCycle suivi = new SuivieDeCycle();

        // Simulation des cycles
        for (int cycle = 1; cycle <= cycles; cycle++) {
            System.out.println("Cycle " + cycle);

            // Introduire un nouveau variant au cycle 5
            if (cycle == 5) {
                Variant variant2 = new Variant(
                        2,
                        "Variant Delta",
                        0.7f,    // Taux de transmission plus élevé
                        0.3,     // Probabilité de guérison plus faible
                        3,       // Période d'incubation plus longue
                        0.15,    // Probabilité de décès plus élevée
                        8f,      // Distance maximale plus courte
                        0.6      // Taux de transmission initial plus fort
                );
                population.ajouterVariant(variant2);
                System.out.println("Variant Delta introduit dans la population !");
            }

            population.simulationCycle(suivi);
        }

        // Affichage des résultats
        System.out.println("\nHistorique de la simulation :");
        for (String historique : suivi.getHistorique()) {
            System.out.println(historique);
        }
    }
}
