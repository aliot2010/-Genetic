import java.util.ArrayList;

/**
 * Created by aliot on 09.05.2017.
 */
public class Crossing {
    public static enum CrossingType {
        ONE_POINT_RECOMBINATION, TWO_POINT_RECOMBINATION
    }

    public static void crossing(Chromosome chromosome1, Chromosome chromosome2, CrossingType crossingType, Population newPopulation) {
        if (crossingType == CrossingType.ONE_POINT_RECOMBINATION) {
            onePointRecombination(chromosome1, chromosome2,newPopulation);
        }


    }

    private static void onePointRecombination(Chromosome chromosome1, Chromosome chromosome2, Population newPopulation){
        ArrayList<Integer> genList1 = chromosome1.getArrayOfGens();
        ArrayList<Integer> genList2 = chromosome2.getArrayOfGens();

        Chromosome newChromosome1 = new Chromosome(chromosome1);
        Chromosome newChromosome2 = new Chromosome(chromosome2);

        int separator = (int)(Math.random() * genList1.size());

        for (int i = 0; i < separator; i++) {
            newChromosome1.getArrayOfGens().set(i, genList2.get(i));
            newChromosome2.getArrayOfGens().set(i, genList1.get(i));
        }

        newPopulation.addChromosome(newChromosome1);
        newPopulation.addChromosome(newChromosome2);
    }

    private static void twoPointRecombination(Chromosome chromosome1, Chromosome chromosome2, Population newPopulation){
        ArrayList<Integer> genList1 = chromosome1.getArrayOfGens();
        ArrayList<Integer> genList2 = chromosome2.getArrayOfGens();

        Chromosome newChromosome1 = new Chromosome(chromosome1);
        Chromosome newChromosome2 = new Chromosome(chromosome2);

        int separator = (int)(Math.random() * genList1.size());

        for (int i = 0; i < separator; i++) {
            newChromosome1.getArrayOfGens().set(i, genList2.get(i));
            newChromosome2.getArrayOfGens().set(i, genList1.get(i));
        }

        newPopulation.addChromosome(newChromosome1);
        newPopulation.addChromosome(newChromosome2);
    }

    public static  void mutation(Population population) {

        for (int i = 0; i<population.listOfChromosomes.size(); i++) {
            for (int j = 0; j < population.listOfChromosomes.get(i).getArrayOfGens().size(); j++) {
                if (Math.random()*100 < 7) {
                    population.listOfChromosomes.get(i).getArrayOfGens().set( j, ((int) (Math.random() * Main.NUMBER_OF_COMUTATORS)));
                }
            }
        }
    }
}

