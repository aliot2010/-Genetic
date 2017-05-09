import java.util.ArrayList;

/**
 * Created by aliot on 08.05.2017.
 */
public class Chromosome {
    private ArrayList<Integer> arrayOfGens;
    public int numberOfGens;
    public int numberOfComutators;
    private int fitnessFunction;
    private static int MAX_TRAFIC = 64;

    public  static int[][] matrixOfUsersConnections;

    public Chromosome(int numberOfGens, int numberOfComutators) {
        this.numberOfComutators = numberOfComutators;
        this.numberOfGens = numberOfGens;
        arrayOfGens = new ArrayList<>();
        randomizeArrayOfChromosomes();
        if(Chromosome.matrixOfUsersConnections == null){
            randomizeArrayOfUserConnectionsMatrix();
        }

    }
    public Chromosome(Chromosome ch) {
        this.numberOfComutators = ch.numberOfComutators;
        this.numberOfGens = ch.numberOfGens;
        arrayOfGens = (ArrayList<Integer>) ch.getArrayOfGens().clone();

    }

    private void randomizeArrayOfUserConnectionsMatrix() {
        Chromosome.matrixOfUsersConnections = new int[numberOfGens][numberOfGens];
        for (int i = 0; i < matrixOfUsersConnections.length; i++) {
            for (int j = 0; j < matrixOfUsersConnections.length; j++) {
                if (i == j) {
                    Chromosome.matrixOfUsersConnections[i][j] = 0;
                } else {
                    Chromosome.matrixOfUsersConnections[i][j] = ((int) (Math.random() * MAX_TRAFIC));
                }
                if (matrixOfUsersConnections[i][j]/10 < 1) {
                    System.out.print(matrixOfUsersConnections[i][j] + "  ");
                } else {
                    System.out.print(matrixOfUsersConnections[i][j] + " ");
                }
            }
            System.out.println();
        }


    }

    private void randomizeArrayOfChromosomes() {
        for (int i = 0;  i < this.numberOfGens; i++ ) {
            arrayOfGens.add((int) (Math.random()*numberOfComutators));
        }
    }

    public ArrayList<Integer> getArrayOfGens() {
        return arrayOfGens;
    }

    public void setArrayOfGens(ArrayList<Integer> arrayOfGens) {
        this.arrayOfGens = arrayOfGens;
    }

    public int getFitnessFunction() {
        fitnessFunction = 0;
        for (int i = 0; i < numberOfGens; i++) {
            for (int j= 0; j < numberOfGens; j++) {
                if (arrayOfGens.get(i) != arrayOfGens.get(j)) {
                    fitnessFunction += matrixOfUsersConnections[i][j];
                }
            }
        }

        return fitnessFunction;
    }

}
