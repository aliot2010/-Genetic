/**
 * Created by aliot on 09.05.2017.
 */
public class Reparing {
    public static void repare(Population population) {

        for (int j = 0; j < population.listOfChromosomes.size(); j++){
            repareChromosome(population.listOfChromosomes.get(j));
        }


    }

    private static void repareChromosome(Chromosome chromosome) {
        int[] countOfConnections = new int[chromosome.getArrayOfGens().size()];
        for (int i = 0; i < chromosome.getArrayOfGens().size(); i++) {
            countOfConnections[i] = 0;
        }

        for (int i = 0; i < chromosome.getArrayOfGens().size(); i++) {
            countOfConnections[chromosome.getArrayOfGens().get(i)] ++ ;
        }

        for (int i = 0; i < chromosome.getArrayOfGens().size(); i++) {
            if (countOfConnections[chromosome.getArrayOfGens().get(i)] > Main.NUMBER_OF_COMUTATORS) {
                chromosome.getArrayOfGens().set(i, (int)(Math.random() * Main.NUMBER_OF_COMUTATORS));
                repareChromosome(chromosome);
                break;
            }
        }

    }

}
