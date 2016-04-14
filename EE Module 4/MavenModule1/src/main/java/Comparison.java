import java.io.*;
import java.util.*;

public class Comparison {
    private static final int TEN_THOUSANDS = 10000;
    private static final int HUNDRED_THOUSANDS = 100000;
    private static final int MILLION = 1000000;
    private static final int EXPERIMENT_NUMBER = 100;
    ArrayList<Integer> arrayList = new ArrayList<>();
    List<Integer> linkedList = new LinkedList<>();
    Set<Integer> hashSet = new HashSet<>();
    Set<Integer> treeSet = new TreeSet<>();
    double[][][] table = new double[4][7][3];

    public void populate(int volume, Collection<Integer> structure) {
        for (int i = 0; i < volume; i++) {
            structure.add(i);
        }
    }

    public void populateArrayListComparison() {
        double result = 0.0;
        long startTime;
        for (int i = 0; i < EXPERIMENT_NUMBER; i++) {
            startTime = System.currentTimeMillis();
            populate(TEN_THOUSANDS, arrayList);
            result += System.currentTimeMillis() - startTime;
            arrayList.clear();
            arrayList.trimToSize();
        }
        table[0][4][0] = result / EXPERIMENT_NUMBER;
        result = 0.0;
        for (int i = 0; i < EXPERIMENT_NUMBER; i++) {
            startTime = System.currentTimeMillis();
            populate(HUNDRED_THOUSANDS, arrayList);
            result += System.currentTimeMillis() - startTime;
            arrayList.clear();
            arrayList.trimToSize();
        }
        table[0][4][1] = result / EXPERIMENT_NUMBER;
        result = 0.0;
        for (int i = 0; i < EXPERIMENT_NUMBER; i++) {
            startTime = System.currentTimeMillis();
            populate(MILLION, arrayList);
            result += System.currentTimeMillis() - startTime;
            arrayList.clear();
            arrayList.trimToSize();
        }
        table[0][4][2] = result / EXPERIMENT_NUMBER;
    }

    public void populateLinkedListComparison() {
        double result = 0.0;
        long startTime;
        for (int i = 0; i < EXPERIMENT_NUMBER; i++) {
            startTime = System.currentTimeMillis();
            populate(TEN_THOUSANDS, linkedList);
            result += System.currentTimeMillis() - startTime;
            linkedList.clear();
        }
        table[1][4][0] = result / EXPERIMENT_NUMBER;
        result = 0.0;
        for (int i = 0; i < EXPERIMENT_NUMBER; i++) {
            startTime = System.currentTimeMillis();
            populate(HUNDRED_THOUSANDS, linkedList);
            result += System.currentTimeMillis() - startTime;
            linkedList.clear();
        }
        table[1][4][1] = result / EXPERIMENT_NUMBER;
        result = 0.0;
        for (int i = 0; i < EXPERIMENT_NUMBER; i++) {
            startTime = System.currentTimeMillis();
            populate(MILLION, linkedList);
            result += System.currentTimeMillis() - startTime;
            linkedList.clear();
        }
        table[1][4][2] = result / EXPERIMENT_NUMBER;
    }

    public void populateHashSet() {
        double result = 0.0;
        long startTime;
        for (int i = 0; i < EXPERIMENT_NUMBER; i++) {
            startTime = System.currentTimeMillis();
            populate(TEN_THOUSANDS, hashSet);
            result += System.currentTimeMillis() - startTime;
            hashSet.clear();
        }
        table[2][4][0] = result / EXPERIMENT_NUMBER;
        result = 0.0;
        for (int i = 0; i < EXPERIMENT_NUMBER; i++) {
            startTime = System.currentTimeMillis();
            populate(HUNDRED_THOUSANDS, hashSet);
            result += System.currentTimeMillis() - startTime;
            hashSet.clear();
        }
        table[2][4][1] = result / EXPERIMENT_NUMBER;
        result = 0.0;
        for (int i = 0; i < EXPERIMENT_NUMBER; i++) {
            startTime = System.currentTimeMillis();
            populate(MILLION, hashSet);
            result += System.currentTimeMillis() - startTime;
            hashSet.clear();
        }
        table[2][4][2] = result / EXPERIMENT_NUMBER;
    }

    public void populateTreeSet() {
        double result = 0.0;
        long startTime;
        for (int i = 0; i < EXPERIMENT_NUMBER; i++) {
            startTime = System.currentTimeMillis();
            populate(TEN_THOUSANDS, treeSet);
            result += System.currentTimeMillis() - startTime;
            treeSet.clear();
        }
        table[3][4][0] = result / EXPERIMENT_NUMBER;
        result = 0.0;
        for (int i = 0; i < EXPERIMENT_NUMBER; i++) {
            startTime = System.currentTimeMillis();
            populate(HUNDRED_THOUSANDS, treeSet);
            result += System.currentTimeMillis() - startTime;
            treeSet.clear();
        }
        table[3][4][1] = result / EXPERIMENT_NUMBER;
        result = 0.0;
        for (int i = 0; i < EXPERIMENT_NUMBER; i++) {
            startTime = System.currentTimeMillis();
            populate(MILLION, treeSet);
            result += System.currentTimeMillis() - startTime;
            treeSet.clear();
        }
        table[3][4][2] = result / EXPERIMENT_NUMBER;
    }

    public void addRemoveArrayListComparison() {
        double addResult = 0.0;
        double removeResult = 0.0;
        long startTime;
        populate(TEN_THOUSANDS, arrayList);
        for (int i = 0; i < EXPERIMENT_NUMBER; i++) {
            startTime = System.currentTimeMillis();
            arrayList.add(TEN_THOUSANDS / 2, TEN_THOUSANDS / 2);
            addResult += System.currentTimeMillis() - startTime;
            startTime = System.currentTimeMillis();
            arrayList.remove(TEN_THOUSANDS / 2);
            removeResult += System.currentTimeMillis() - startTime;
        }
        table[0][0][0] = addResult / EXPERIMENT_NUMBER;
        table[0][2][0] = removeResult / EXPERIMENT_NUMBER;
        arrayList.clear();
        addResult = 0.0;
        removeResult = 0.0;
        populate(HUNDRED_THOUSANDS, arrayList);
        for (int i = 0; i < EXPERIMENT_NUMBER; i++) {
            startTime = System.currentTimeMillis();
            arrayList.add(HUNDRED_THOUSANDS / 2, HUNDRED_THOUSANDS / 2);
            addResult += System.currentTimeMillis() - startTime;
            startTime = System.currentTimeMillis();
            arrayList.remove(HUNDRED_THOUSANDS / 2);
            removeResult += System.currentTimeMillis() - startTime;
        }
        table[0][0][1] = addResult / EXPERIMENT_NUMBER;
        table[0][2][1] = removeResult / EXPERIMENT_NUMBER;
        arrayList.clear();
        arrayList.trimToSize();
        addResult = 0.0;
        removeResult = 0.0;
        populate(MILLION, arrayList);
        for (int i = 0; i < EXPERIMENT_NUMBER; i++) {
            startTime = System.currentTimeMillis();
            arrayList.add(MILLION / 2, MILLION / 2);
            addResult += System.currentTimeMillis() - startTime;
            startTime = System.currentTimeMillis();
            arrayList.remove(MILLION / 2);
            removeResult += System.currentTimeMillis() - startTime;
        }
        table[0][0][2] = addResult / EXPERIMENT_NUMBER;
        table[0][2][2] = removeResult / EXPERIMENT_NUMBER;
        arrayList.clear();

    }

    public void addRemoveLinkedListComparison() {
        double addResult = 0.0;
        double removeResult = 0.0;
        long startTime;
        populate(TEN_THOUSANDS, linkedList);
        for (int i = 0; i < EXPERIMENT_NUMBER; i++) {
            startTime = System.currentTimeMillis();
            linkedList.add(TEN_THOUSANDS / 2, TEN_THOUSANDS / 2);
            addResult += System.currentTimeMillis() - startTime;
            startTime = System.currentTimeMillis();
            linkedList.remove(TEN_THOUSANDS / 2);
            removeResult += System.currentTimeMillis() - startTime;
        }
        table[1][0][0] = addResult / EXPERIMENT_NUMBER;
        table[1][2][0] = removeResult / EXPERIMENT_NUMBER;
        linkedList.clear();
        addResult = 0.0;
        removeResult = 0.0;
        populate(HUNDRED_THOUSANDS, linkedList);
        for (int i = 0; i < EXPERIMENT_NUMBER; i++) {
            startTime = System.currentTimeMillis();
            linkedList.add(HUNDRED_THOUSANDS / 2, HUNDRED_THOUSANDS / 2);
            addResult += System.currentTimeMillis() - startTime;
            startTime = System.currentTimeMillis();
            linkedList.remove(HUNDRED_THOUSANDS / 2);
            removeResult += System.currentTimeMillis() - startTime;
        }
        table[1][0][1] = addResult / EXPERIMENT_NUMBER;
        table[1][2][1] = removeResult / EXPERIMENT_NUMBER;
        linkedList.clear();
        addResult = 0.0;
        removeResult = 0.0;
        populate(MILLION, linkedList);
        for (int i = 0; i < EXPERIMENT_NUMBER; i++) {
            startTime = System.currentTimeMillis();
            linkedList.add(MILLION / 2, MILLION / 2);
            addResult += System.currentTimeMillis() - startTime;
            startTime = System.currentTimeMillis();
            linkedList.remove(MILLION / 2);
            removeResult += System.currentTimeMillis() - startTime;
        }
        table[1][0][2] = addResult / EXPERIMENT_NUMBER;
        table[1][2][2] = removeResult / EXPERIMENT_NUMBER;
        linkedList.clear();

    }

    public void addRemoveHashSetComparison() {
        double addResult = 0.0;
        double removeResult = 0.0;
        long startTime;
        populate(TEN_THOUSANDS, hashSet);
        for (int i = 0; i < EXPERIMENT_NUMBER; i++) {
            startTime = System.currentTimeMillis();
            hashSet.add(TEN_THOUSANDS);
            addResult += System.currentTimeMillis() - startTime;
            startTime = System.currentTimeMillis();
            treeSet.remove(TEN_THOUSANDS);
            removeResult += System.currentTimeMillis() - startTime;
        }
        table[2][0][0] = addResult / EXPERIMENT_NUMBER;
        table[2][2][0] = removeResult / EXPERIMENT_NUMBER;
        hashSet.clear();
        addResult = 0.0;
        removeResult = 0.0;
        populate(HUNDRED_THOUSANDS, hashSet);
        for (int i = 0; i < EXPERIMENT_NUMBER; i++) {
            startTime = System.currentTimeMillis();
            hashSet.add(HUNDRED_THOUSANDS);
            addResult += System.currentTimeMillis() - startTime;
            startTime = System.currentTimeMillis();
            hashSet.remove(HUNDRED_THOUSANDS);
            removeResult += System.currentTimeMillis() - startTime;
        }
        table[2][0][1] = addResult / EXPERIMENT_NUMBER;
        table[2][2][1] = removeResult / EXPERIMENT_NUMBER;
        hashSet.clear();
        addResult = 0.0;
        removeResult = 0.0;
        populate(MILLION, hashSet);
        for (int i = 0; i < EXPERIMENT_NUMBER; i++) {
            startTime = System.currentTimeMillis();
            hashSet.add(MILLION);
            addResult += System.currentTimeMillis() - startTime;
            startTime = System.currentTimeMillis();
            hashSet.remove(MILLION);
            removeResult += System.currentTimeMillis() - startTime;
        }
        table[2][0][2] = addResult / EXPERIMENT_NUMBER;
        table[2][2][2] = removeResult / EXPERIMENT_NUMBER;
        hashSet.clear();
    }

    public void addRemoveTreeSetComparison() {
        double addResult = 0.0;
        double removeResult = 0.0;
        long startTime;
        populate(TEN_THOUSANDS, treeSet);
        for (int i = 0; i < EXPERIMENT_NUMBER; i++) {
            startTime = System.currentTimeMillis();
            treeSet.add(TEN_THOUSANDS);
            addResult += System.currentTimeMillis() - startTime;
            startTime = System.currentTimeMillis();
            treeSet.remove(TEN_THOUSANDS);
            removeResult += System.currentTimeMillis() - startTime;
        }
        table[3][0][0] = addResult / EXPERIMENT_NUMBER;
        table[3][2][0] = removeResult / EXPERIMENT_NUMBER;
        treeSet.clear();
        addResult = 0.0;
        removeResult = 0.0;
        populate(HUNDRED_THOUSANDS, treeSet);
        for (int i = 0; i < EXPERIMENT_NUMBER; i++) {
            startTime = System.currentTimeMillis();
            treeSet.add(HUNDRED_THOUSANDS);
            addResult += System.currentTimeMillis() - startTime;
            startTime = System.currentTimeMillis();
            treeSet.remove(HUNDRED_THOUSANDS);
            removeResult += System.currentTimeMillis() - startTime;
        }
        table[3][0][1] = addResult / EXPERIMENT_NUMBER;
        table[3][2][1] = removeResult / EXPERIMENT_NUMBER;
        treeSet.clear();
        addResult = 0.0;
        removeResult = 0.0;
        populate(MILLION, treeSet);
        for (int i = 0; i < EXPERIMENT_NUMBER; i++) {
            startTime = System.currentTimeMillis();
            treeSet.add(MILLION);
            addResult += System.currentTimeMillis() - startTime;
            startTime = System.currentTimeMillis();
            treeSet.remove(MILLION);
            removeResult += System.currentTimeMillis() - startTime;
        }
        table[3][0][2] = addResult / EXPERIMENT_NUMBER;
        table[3][2][2] = removeResult / EXPERIMENT_NUMBER;
        treeSet.clear();
    }

    public void containsGetArrayListComparison() {
        double containsResult = 0.0;
        double getResult = 0.0;
        long startTime;
        populate(TEN_THOUSANDS, arrayList);
        for (int i = 0; i < EXPERIMENT_NUMBER; i++) {
            startTime = System.currentTimeMillis();
            arrayList.contains(TEN_THOUSANDS / 2);
            containsResult += System.currentTimeMillis() - startTime;
            startTime = System.currentTimeMillis();
            arrayList.get(TEN_THOUSANDS / 2);
            getResult += System.currentTimeMillis() - startTime;
        }
        arrayList.clear();
        table[0][3][0] = containsResult / EXPERIMENT_NUMBER;
        table[0][1][0] = getResult / EXPERIMENT_NUMBER;
        containsResult = 0.0;
        getResult = 0.0;
        populate(HUNDRED_THOUSANDS, arrayList);
        for (int i = 0; i < EXPERIMENT_NUMBER; i++) {
            startTime = System.currentTimeMillis();
            arrayList.contains(HUNDRED_THOUSANDS / 2);
            containsResult += System.currentTimeMillis() - startTime;
            startTime = System.currentTimeMillis();
            arrayList.get(HUNDRED_THOUSANDS / 2);
            getResult += System.currentTimeMillis() - startTime;
        }
        arrayList.clear();
        table[0][3][1] = containsResult / EXPERIMENT_NUMBER;
        table[0][1][1] = getResult / EXPERIMENT_NUMBER;
        containsResult = 0.0;
        getResult = 0.0;
        populate(MILLION, arrayList);
        for (int i = 0; i < EXPERIMENT_NUMBER; i++) {
            startTime = System.currentTimeMillis();
            arrayList.contains(MILLION / 2);
            containsResult += System.currentTimeMillis() - startTime;
            startTime = System.currentTimeMillis();
            arrayList.get(MILLION / 2);
            getResult += System.currentTimeMillis() - startTime;
        }
        arrayList.clear();
        table[0][3][2] = containsResult / EXPERIMENT_NUMBER;
        table[0][1][2] = getResult / EXPERIMENT_NUMBER;
    }

    public void containsGetLinkedListComparison() {
        double containsResult = 0.0;
        double getResult = 0.0;
        long startTime;
        populate(TEN_THOUSANDS, linkedList);
        for (int i = 0; i < EXPERIMENT_NUMBER; i++) {
            startTime = System.currentTimeMillis();
            linkedList.contains(TEN_THOUSANDS / 2);
            containsResult += System.currentTimeMillis() - startTime;
            startTime = System.currentTimeMillis();
            linkedList.get(TEN_THOUSANDS / 2);
            getResult += System.currentTimeMillis() - startTime;
        }
        linkedList.clear();
        table[1][3][0] = containsResult / EXPERIMENT_NUMBER;
        table[1][1][0] = getResult / EXPERIMENT_NUMBER;
        containsResult = 0.0;
        getResult = 0.0;
        populate(HUNDRED_THOUSANDS, linkedList);
        for (int i = 0; i < EXPERIMENT_NUMBER; i++) {
            startTime = System.currentTimeMillis();
            linkedList.contains(HUNDRED_THOUSANDS / 2);
            containsResult += System.currentTimeMillis() - startTime;
            startTime = System.currentTimeMillis();
            linkedList.get(HUNDRED_THOUSANDS / 2);
            getResult += System.currentTimeMillis() - startTime;
        }
        linkedList.clear();
        table[1][3][1] = containsResult / EXPERIMENT_NUMBER;
        table[1][1][1] = getResult / EXPERIMENT_NUMBER;
        containsResult = 0.0;
        getResult = 0.0;
        populate(MILLION, linkedList);
        for (int i = 0; i < EXPERIMENT_NUMBER; i++) {
            startTime = System.currentTimeMillis();
            linkedList.contains(MILLION / 2);
            containsResult += System.currentTimeMillis() - startTime;
            startTime = System.currentTimeMillis();
            linkedList.get(MILLION / 2);
            getResult += System.currentTimeMillis() - startTime;
        }
        linkedList.clear();
        table[1][3][2] = containsResult / EXPERIMENT_NUMBER;
        table[1][1][2] = getResult / EXPERIMENT_NUMBER;
    }

    public void containsHashSetComparison() {
        double result = 0.0;
        long startTime;
        populate(TEN_THOUSANDS, hashSet);
        for (int i = 0; i < EXPERIMENT_NUMBER; i++) {
            startTime = System.currentTimeMillis();
            hashSet.contains(TEN_THOUSANDS / 2);
            result += System.currentTimeMillis() - startTime;

        }
        hashSet.clear();
        table[2][3][0] = result / EXPERIMENT_NUMBER;
        result = 0.0;
        populate(HUNDRED_THOUSANDS, hashSet);
        for (int i = 0; i < EXPERIMENT_NUMBER; i++) {
            startTime = System.currentTimeMillis();
            hashSet.contains(HUNDRED_THOUSANDS / 2);
            result += System.currentTimeMillis() - startTime;

        }
        hashSet.clear();
        table[2][3][1] = result / EXPERIMENT_NUMBER;
        result = 0.0;
        populate(MILLION, hashSet);
        for (int i = 0; i < EXPERIMENT_NUMBER; i++) {
            startTime = System.currentTimeMillis();
            hashSet.contains(MILLION / 2);
            result += System.currentTimeMillis() - startTime;

        }
        hashSet.clear();
        table[2][3][2] = result / EXPERIMENT_NUMBER;
    }

    public void containsTreeSetComparison() {
        double result = 0.0;
        long startTime;
        populate(TEN_THOUSANDS, treeSet);
        for (int i = 0; i < EXPERIMENT_NUMBER; i++) {
            startTime = System.currentTimeMillis();
            treeSet.contains(TEN_THOUSANDS / 2);
            result += System.currentTimeMillis() - startTime;

        }
        treeSet.clear();
        table[3][3][0] = result / EXPERIMENT_NUMBER;
        result = 0.0;
        populate(HUNDRED_THOUSANDS, treeSet);
        for (int i = 0; i < EXPERIMENT_NUMBER; i++) {
            startTime = System.currentTimeMillis();
            treeSet.contains(HUNDRED_THOUSANDS / 2);
            result += System.currentTimeMillis() - startTime;

        }
        treeSet.clear();
        table[3][3][1] = result / EXPERIMENT_NUMBER;
        result = 0.0;
        populate(MILLION, treeSet);
        for (int i = 0; i < EXPERIMENT_NUMBER; i++) {
            startTime = System.currentTimeMillis();
            treeSet.contains(MILLION / 2);
            result += System.currentTimeMillis() - startTime;

        }
        treeSet.clear();
        table[3][3][2] = result / EXPERIMENT_NUMBER;
    }

    public void iteratorAddRemoveArrayListComparison() {

        double addResult = 0.0;
        double removeResult = 0.0;
        long startTime;
        populate(TEN_THOUSANDS, arrayList);
        ListIterator<Integer> iterator = arrayList.listIterator();
        for (int i = 0; i < EXPERIMENT_NUMBER; i++) {
            startTime = System.currentTimeMillis();
            iterator.add(TEN_THOUSANDS);
            addResult += System.currentTimeMillis() - startTime;
            iterator.previous();
            startTime = System.currentTimeMillis();
            iterator.remove();
            removeResult += System.currentTimeMillis() - startTime;
        }
        arrayList.clear();
        table[0][5][0] = addResult / EXPERIMENT_NUMBER;
        table[0][6][0] = removeResult / EXPERIMENT_NUMBER;
        addResult = 0.0;
        removeResult = 0.0;
        populate(HUNDRED_THOUSANDS, arrayList);
        iterator = arrayList.listIterator();
        for (int i = 0; i < EXPERIMENT_NUMBER; i++) {
            startTime = System.currentTimeMillis();
            iterator.add(HUNDRED_THOUSANDS);
            addResult += System.currentTimeMillis() - startTime;
            iterator.previous();
            startTime = System.currentTimeMillis();
            iterator.remove();
            removeResult += System.currentTimeMillis() - startTime;
        }
        arrayList.clear();
        table[0][5][1] = addResult / EXPERIMENT_NUMBER;
        table[0][6][1] = removeResult / EXPERIMENT_NUMBER;
        addResult = 0.0;
        removeResult = 0.0;
        populate(MILLION, arrayList);
        iterator = arrayList.listIterator();
        for (int i = 0; i < EXPERIMENT_NUMBER; i++) {
            startTime = System.currentTimeMillis();
            iterator.add(MILLION);
            addResult += System.currentTimeMillis() - startTime;
            iterator.previous();
            startTime = System.currentTimeMillis();
            iterator.remove();
            removeResult += System.currentTimeMillis() - startTime;
        }
        arrayList.clear();
        table[0][5][2] = addResult / EXPERIMENT_NUMBER;
        table[0][6][2] = removeResult / EXPERIMENT_NUMBER;

    }

    public void iteratorAddRemoveLinkedListComparison() {
        double addResult = 0.0;
        double removeResult = 0.0;
        long startTime;
        populate(TEN_THOUSANDS, linkedList);
        ListIterator<Integer> iterator = linkedList.listIterator();
        for (int i = 0; i < EXPERIMENT_NUMBER; i++) {
            startTime = System.currentTimeMillis();
            iterator.add(TEN_THOUSANDS);
            addResult += System.currentTimeMillis() - startTime;
            iterator.previous();
            startTime = System.currentTimeMillis();
            iterator.remove();
            removeResult += System.currentTimeMillis() - startTime;
        }
        linkedList.clear();
        table[1][5][0] = addResult / EXPERIMENT_NUMBER;
        table[1][6][0] = removeResult / EXPERIMENT_NUMBER;
        addResult = 0.0;
        removeResult = 0.0;
        populate(HUNDRED_THOUSANDS, linkedList);
        iterator = linkedList.listIterator();
        for (int i = 0; i < EXPERIMENT_NUMBER; i++) {
            startTime = System.currentTimeMillis();
            iterator.add(HUNDRED_THOUSANDS);
            addResult += System.currentTimeMillis() - startTime;
            iterator.previous();
            startTime = System.currentTimeMillis();
            iterator.remove();
            removeResult += System.currentTimeMillis() - startTime;
        }
        linkedList.clear();
        table[1][5][1] = addResult / EXPERIMENT_NUMBER;
        table[1][6][1] = removeResult / EXPERIMENT_NUMBER;
        addResult = 0.0;
        removeResult = 0.0;
        populate(MILLION, linkedList);
        iterator = linkedList.listIterator();
        for (int i = 0; i < EXPERIMENT_NUMBER; i++) {
            startTime = System.currentTimeMillis();
            iterator.add(MILLION);
            addResult += System.currentTimeMillis() - startTime;
            iterator.previous();
            startTime = System.currentTimeMillis();
            iterator.remove();
            removeResult += System.currentTimeMillis() - startTime;
        }
        linkedList.clear();
        table[1][5][2] = addResult / EXPERIMENT_NUMBER;
        table[1][6][2] = removeResult / EXPERIMENT_NUMBER;

    }

    public void printTable() {
        BufferedWriter saver = null;
        try {
            saver = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Comparations.txt")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("There is no such file");
        }
        try {
            System.out.println("|            | add          | get           | remove       | contains      | populate      | iterator.add  | iterator.remove |");
            saver.write("|            | add          | get           | remove       | contains      | populate      | iterator.add  | iterator.remove |\n");
            for (int i = 0; i < table.length; i++) {
                if (i == 0) {
                    System.out.print("| ArrayList  |");
                    saver.write("| ArrayList  |");
                } else if (i == 1) {
                    System.out.print("| LinkedList |");
                    saver.write("| LinkedList |");
                } else if (i == 2) {
                    System.out.print("| HashSet    |");
                    saver.write("| HashSet    |");
                } else if (i == 3) {
                    System.out.print("| TreeSet    |");
                    saver.write("| TreeSet    |");
                }
                for (int j = 0; j < table[0].length; j++) {
                    for (int k = 0; k < table[0][0].length; k++) {
                        System.out.print(" " + table[i][j][k]);
                        saver.write(" ");
                        saver.write(String.valueOf(table[i][j][k]));
                    }
                    System.out.print(" |");
                    saver.write(" |");
                }
                System.out.println();
                saver.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                saver.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Comparison program = new Comparison();
        program.populateArrayListComparison();
        program.populateLinkedListComparison();
        program.populateHashSet();
        program.populateTreeSet();
        program.addRemoveArrayListComparison();
        program.addRemoveLinkedListComparison();
        program.addRemoveHashSetComparison();
        program.addRemoveTreeSetComparison();
        program.containsHashSetComparison();
        program.containsTreeSetComparison();
        program.containsGetArrayListComparison();
        program.containsGetLinkedListComparison();
        program.iteratorAddRemoveArrayListComparison();
        program.iteratorAddRemoveLinkedListComparison();
        program.printTable();
    }
}
