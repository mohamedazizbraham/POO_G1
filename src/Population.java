import java.util.List;
import java.util.ArrayList;

public class Population {
    private List<Individu> individus;
    private int taille;

    public Population(int taille) {
        this.taille = taille;
        this.individus = new ArrayList<>();
    }
}
