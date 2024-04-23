package templates.binarySearch;

/**
 * @author Raian Rahman
 * @since 4/23/2024
 */
public class BinarySearch {

    public static int binarySearch(int[] values, int key) {
        int lo = 0;
        int hi = values.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) >> 1;

            if (values[mid] == key) {
                return mid;
            } else if (values[mid] < key) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return values.length;
    }

    public static void main(String[] args) {
        int[] values = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for (int value : values) {
            System.out.println(value + " " + binarySearch(values, value));
        }
    }
}
