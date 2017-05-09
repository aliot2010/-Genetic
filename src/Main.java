public class Main {
    public static int NUMBER_OF_USERS = 16;
    public static int NUMBER_OF_COMUTATORS = 5;

    public static void main(String[] args) {
        Population population = new Population();
        for(int i = 0; i < NUMBER_OF_USERS; i++) {
            population.addChromosome(new Chromosome(NUMBER_OF_USERS, NUMBER_OF_COMUTATORS));
        }
        Reparing.repare(population);
        population.printPopulation();
        System.out.println("Last Generation:");

        for (int cicle = 0 ; cicle < 40; cicle++) {
            Population childPopulation = new Population();

            for (int i = 0; i < NUMBER_OF_USERS; i += 2) {
                Crossing.crossing(population.listOfChromosomes.get(i), population.listOfChromosomes.get(i + 1),
                        Crossing.CrossingType.ONE_POINT_RECOMBINATION, childPopulation);
            }

            Crossing.mutation(childPopulation);
            Reparing.repare(population);
            Selection.selection(population, childPopulation, Selection.SelectionType.ELITE);

        }
        population.printPopulation();
    }

}
