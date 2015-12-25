public class ExtremumsAndSorting {
    public int minimalValue(int[] massive) {
        int minimalElement = massive[0];
        for (int element : massive) {
            if (element < minimalElement) {
                minimalElement = element;
            }
        }
        return minimalElement;
    }

    public int minimalValue(int[] massive, int leftBound, int rightBound) {
        int minimalElement = massive[leftBound];
        for (int i = leftBound; i <= rightBound; i++) {
            if (massive[i] < minimalElement) {
                minimalElement = massive[i];
            }
        }
        return minimalElement;
    }

    public int maximumValue(int[] massive, int leftBound, int rightBound) {
        int maximumElement = massive[leftBound];
        for (int i = leftBound; i <= rightBound; i++) {
            if (massive[i] > maximumElement) {
                maximumElement = massive[i];
            }
        }
        return maximumElement;
    }

    public int maximumValue(int[] massive) {
        int maximumElement = massive[0];
        for (int element : massive) {
            if (element > maximumElement) {
                maximumElement = element;
            }
        }
        return maximumElement;
    }

    public void insertionSort(int[] massive) {
        for (int i = 1; i < massive.length; i++) {
            int key = massive[i];
            if (key < massive[i - 1]) {
                insertElement(searchForPlace(massive, key, i), massive, i, key);
            }
            printMassive(massive);
        }

    }

    private void insertElement(int place, int[] massive, int index, int key) {
        for (int i = index; i > place; i--) {
            massive[i] = massive[i - 1];
        }
        massive[place] = key;
    }

    private int searchForPlace(int[] massive, int key, int index) {
        do {
            index--;
        } while ((massive[index] > key) && (index > 0));
        if (massive[index] < key) {
            index++;
        }
        System.out.println("Place: " + index);
        return index;
    }

    public void mergeSort(int[] massive, int leftBound, int rightBound) {

        if (leftBound < rightBound) {
            int massiveCenter = (leftBound + rightBound) / 2;
            mergeSort(massive, leftBound, massiveCenter);
            mergeSort(massive, massiveCenter + 1, rightBound);
            mergeTwoMassives(massive, leftBound, rightBound, massiveCenter);
        }

    }

    private void mergeTwoMassives(int[] massive, int leftBound, int rightBound, int border) {
        int[] buffer = new int[rightBound - leftBound + 1];
        int leftindex = leftBound;
        int rightIndex = border + 1;
        int resultIndex = 0;
        while ((leftindex <= border) && (rightIndex <= rightBound)) {
            if (massive[leftindex] < massive[rightIndex]) {
                buffer[resultIndex] = massive[leftindex];
                resultIndex++;
                leftindex++;
            } else {
                buffer[resultIndex] = massive[rightIndex];
                resultIndex++;
                rightIndex++;
            }
        }
        if (leftindex <= border) {
            for (int i = leftindex; i <= border; i++) {
                buffer[resultIndex] = massive[i];
                resultIndex++;
            }

        } else if (rightIndex <= rightBound) {
            for (int i = rightIndex; i <= rightBound; i++) {
                buffer[resultIndex] = massive[i];
                resultIndex++;
            }
        }

        for (int i = leftBound, j = 0; i <= rightBound; i++, j++) {
            massive[i] = buffer[j];
        }
        System.out.println("Changed streak: ");
        printMassive(buffer);
        System.out.println("Whole massive: ");
        printMassive(massive);
    }

    public void quickSort(int[] massive, int leftBound, int rightBound) {
        //System.out.println(leftBound + " " + rightBound);
        //printMassive(massive);
        int leftIndex = leftBound;
        int rightIndex = rightBound;
        int currentMin = minimalValue(massive, leftBound, rightBound);
        int currentMax = maximumValue(massive, leftBound, rightBound);
        int mediana = (currentMin + currentMax) / 2;
        while (leftIndex < rightIndex) {
            while ((massive[leftIndex] < mediana) && (leftIndex < rightBound)) {
                leftIndex++;
            }
            while ((massive[rightIndex] > mediana) && (rightIndex > leftBound)) {
                rightIndex--;
            }
            if (leftIndex < rightIndex) {
                int temporaryValue = massive[leftIndex];
                massive[leftIndex] = massive[rightIndex];
                massive[rightIndex] = temporaryValue;
            }
        }
        if ((rightIndex > leftBound) && (rightBound - leftBound > 1)) {
            quickSort(massive, leftBound, rightIndex);
        }

        if ((leftIndex < rightBound) && (rightBound - leftBound > 1)) {
            quickSort(massive, leftIndex, rightBound);
        }

    }

    public static void main(String[] args) {
        ExtremumsAndSorting example = new ExtremumsAndSorting();
        int[] someMassive = {3, 2, 0, 7, -5, 4};
        //System.out.println("Minimum element: " + example.minimalValue(someMassive));
        //System.out.println("Maximum element: " + example.maximumValue(someMassive));
        //example.insertionSort(someMassive);
        //example.mergeSort(someMassive, 0, someMassive.length - 1);
        example.quickSort(someMassive, 0, someMassive.length - 1);
        printMassive(someMassive);

    }

    public static void printMassive(int[] massive) {
        for (int i = 0; i < massive.length; i++) {
            System.out.print(massive[i] + " ");
        }
        System.out.println();
    }

}
