import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by aliot on 09.05.2017.
 */
public class Selection {
    public enum SelectionType {
        TOURNEY, ROULETTE_WHEEL, ELITE
    }

    public static void selection(Population basePopulation, Population childPoulation, SelectionType selectionType) {
        if (selectionType == SelectionType.ELITE) {
            eliteSelection(basePopulation, childPoulation);
        }

        shuffleChromosomes(basePopulation);
    }

    private static void shuffleChromosomes(Population basePopulation) {
        Collections.shuffle(basePopulation.listOfChromosomes);
    }

    private static void eliteSelection(Population basePopulation, Population childPopulation) {
        ArrayList<Chromosome>  allChromosomes = new ArrayList<Chromosome>();
        for (int i = 0; i < basePopulation.listOfChromosomes.size(); i++) {
            allChromosomes.add(basePopulation.listOfChromosomes.get(i));
            allChromosomes.add(childPopulation.listOfChromosomes.get(i));
        }

        allChromosomes.sort((o1, o2) -> o1.getFitnessFunction() - o2.getFitnessFunction());//TODO

        for (int i = 0; i < basePopulation.listOfChromosomes.size(); i++) {
            basePopulation.listOfChromosomes.set(i, allChromosomes.get(i));
        }
    }


}
