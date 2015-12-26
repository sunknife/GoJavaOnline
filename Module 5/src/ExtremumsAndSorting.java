public class ExtremumsAndSorting {
    public int minimalValue(int[] array) {
        int minimalElement = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minimalElement) {
                minimalElement = array[i];
            }
        }
        return minimalElement;
    }

    public int minimalValue(int[] array, int leftBound, int rightBound) {
        int minimalElement = array[leftBound];
        for (int i = leftBound + 1; i <= rightBound; i++) {
            if (array[i] < minimalElement) {
                minimalElement = array[i];
            }
        }
        return minimalElement;
    }

    public int maximumValue(int[] array, int leftBound, int rightBound) {
        int maximumElement = array[leftBound];
        for (int i = leftBound + 1; i <= rightBound; i++) {
            if (array[i] > maximumElement) {
                maximumElement = array[i];
            }
        }
        return maximumElement;
    }

    public int maximumValue(int[] array) {
        int maximumElement = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maximumElement) {
                maximumElement = array[i];
            }
        }
        return maximumElement;
    }

    public void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            if (key < array[i - 1]) {
                insertElement(searchForPlace(array, key, i), array, i, key);
            }
        }

    }

    private void insertElement(int place, int[] array, int index, int key) {
        for (int i = index; i > place; i--) {
            array[i] = array[i - 1];
        }
        array[place] = key;
    }

    private int searchForPlace(int[] array, int key, int index) {
        do {
            index--;
        } while ((array[index] > key) && (index > 0));
        if (array[index] < key) {
            index++;
        }
        return index;
    }

    public void mergeSort(int[] array, int leftBound, int rightBound) {

        if (leftBound < rightBound) {
            int massiveCenter = (leftBound + rightBound) / 2;
            mergeSort(array, leftBound, massiveCenter);
            mergeSort(array, massiveCenter + 1, rightBound);
            mergeTwoMassives(array, leftBound, rightBound, massiveCenter);
        }

    }

    private void mergeTwoMassives(int[] array, int leftBound, int rightBound, int border) {
        int[] buffer = new int[rightBound - leftBound + 1];
        int leftindex = leftBound;
        int rightIndex = border + 1;
        int resultIndex = 0;
        while ((leftindex <= border) && (rightIndex <= rightBound)) {
            if (array[leftindex] < array[rightIndex]) {
                buffer[resultIndex] = array[leftindex];
                resultIndex++;
                leftindex++;
            } else {
                buffer[resultIndex] = array[rightIndex];
                resultIndex++;
                rightIndex++;
            }
        }
        if (leftindex <= border) {
            for (int i = leftindex; i <= border; i++) {
                buffer[resultIndex] = array[i];
                resultIndex++;
            }

        } else if (rightIndex <= rightBound) {
            for (int i = rightIndex; i <= rightBound; i++) {
                buffer[resultIndex] = array[i];
                resultIndex++;
            }
        }

        for (int i = leftBound, j = 0; i <= rightBound; i++, j++) {
            array[i] = buffer[j];
        }
    }

    public void quickSort(int[] array, int leftBound, int rightBound) {
        int leftIndex = leftBound;
        int rightIndex = rightBound;
        int currentMin = minimalValue(array, leftBound, rightBound);
        int currentMax = maximumValue(array, leftBound, rightBound);
        int mediana = (currentMin + currentMax) / 2;
        while (leftIndex < rightIndex) {
            while ((array[leftIndex] < mediana) && (leftIndex < rightBound)) {
                leftIndex++;
            }
            while ((array[rightIndex] > mediana) && (rightIndex > leftBound)) {
                rightIndex--;
            }
            if (leftIndex < rightIndex) {
                int temporaryValue = array[leftIndex];
                array[leftIndex] = array[rightIndex];
                array[rightIndex] = temporaryValue;
            }
        }
        if ((rightIndex > leftBound) && (rightBound - leftBound > 1)) {
            quickSort(array, leftBound, rightIndex);
        }

        if ((leftIndex < rightBound) && (rightBound - leftBound > 1)) {
            quickSort(array, leftIndex, rightBound);
        }

    }

    public static void main(String[] args) {
        ExtremumsAndSorting example = new ExtremumsAndSorting();
        int[] someArray = {-6, 2, 0, 7, -5, 4};
        System.out.println("Minimum element: " + example.minimalValue(someArray));
        System.out.println("Maximum element: " + example.maximumValue(someArray));
        //example.insertionSort(someArray);
        //example.mergeSort(someArray, 0, someArray.length - 1);
        example.quickSort(someArray, 0, someArray.length - 1);
        printMassive(someArray);

    }

    public static void printMassive(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}
