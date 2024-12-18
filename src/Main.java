public class Main {
    public static void main(String[] args) {
        // Initialisation des constantes
        final int populationSize = 100;
        final int cycles = 10;
        final int initialInfectedPercentage = 20;

        // Création de l'épidémie
        Epidemie epidemie = new Epidemie("Simulation de la COVID-19");

        // Création de la population
        Population population = new Population();
        int totalDistanciation = 0;
        int totalProtection = 0;

        for (int i = 0; i < populationSize; i++) {
            float x = (float) (Math.random() * 10);
            float y = (float) (Math.random() * 10);

            // 20% infectés au départ
            Etat etat = (i < populationSize * initialInfectedPercentage / 100) ? Etat.Infecté : Etat.Guéri;

            // Tous les individus commencent avec une sensibilité neutre
            sensibilité sensibilite = sensibilité.Neutre;

            // Ajout de comportements sociaux pour certains individus
            boolean distanciation = Math.random() < 0.3; // 30% des individus pratiquent la distanciation
            boolean protection = Math.random() < 0.5;    // 50% des individus portent un masque

            // Création d'un individu standard ou avec comportement social
            Individu individu;
            if (distanciation || protection) {
                individu = new ComportementSocial(etat, sensibilite, x, y, distanciation, protection);
                if (distanciation) totalDistanciation++;
                if (protection) totalProtection++;
            } else {
                individu = new Individu(etat, sensibilite, x, y);
            }

            population.ajouterIndividu(individu);
        }

        System.out.println("Épidémie simulée : " + epidemie.getNom());
        System.out.println("Population initiale :");
        System.out.println("Individus avec distanciation sociale : " + totalDistanciation);
        System.out.println("Individus avec protection (masque) : " + totalProtection);
        System.out.println();

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

        // Associer le variant à l'épidémie
        epidemie.ajouterMaladie(variant1);
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

                // Associer le nouveau variant à l'épidémie
                epidemie.ajouterMaladie(variant2);
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

        // Résumé des variants associés à l'épidémie
        System.out.println("\nMaladies associées à l'épidémie " + epidemie.getNom() + ":");
        for (Maladie maladie : epidemie.getMaladies()) {
            System.out.println("- " + maladie.getNom());
        }
    }
}
