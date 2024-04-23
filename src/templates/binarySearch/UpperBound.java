package templates.binarySearch;

/**
 * @author Raian Rahman
 * @since 4/23/2024
 */
public class UpperBound {

    public static int upperBound(int[] values, int key) {
        int lo = 0;
        int hi = values.length - 1;

        int ans = values.length;
        while (lo <= hi) {
            int mid = (lo + hi) >> 1;

            if (values[mid] <= key) {
                lo = mid + 1;
            } else {
                ans = mid;
                hi = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] values = new int[]{1, 3, 5, 7, 9};

        for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + upperBound(values, i));
        }
    }
}
