import java.util.ArrayList;

/**
 * Created by aliot on 08.05.2017.
 */
public class Population {
    ArrayList<Chromosome>  listOfChromosomes;

    public Population() {
        listOfChromosomes = new ArrayList<>();
    }

    public void addChromosome(Chromosome chromosome) {
        listOfChromosomes.add(chromosome);
    }

    public  void printPopulation() {
        for (Chromosome i : listOfChromosomes) {
            System.out.println(i.getArrayOfGens() + "Fitness function = " + i.getFitnessFunction());
        }
    }
}
