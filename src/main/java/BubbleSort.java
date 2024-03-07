import java.util.Arrays;


// tak powinno wyglądać zadanie
//<style>
// h1 {
//       color: red; /* Zmiana koloru na czerwony */
//     font-size: 36px; /* Powiększenie czcionki */
//                }
//</style>

public class BubbleSort {
    public static void main(String[] args) {
        int[] numbers = {3, 1, 1, 5, 6, 4};

        // funkc sortująca
        sort(numbers);


        System.out.println("Posortowane liczby: " + Arrays.toString(numbers));
    }


    public static void sort(int[] array) {
        int n = array.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (array[i - 1] > array[i]) {
                    // zmiana
                    int temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }
}