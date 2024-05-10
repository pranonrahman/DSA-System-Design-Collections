package leetcodeProblems;

import java.util.PriorityQueue;

/**
 * @author Raian Rahman
 * @since 5/10/2024
 */
public class KthSmallestPrimeFraction {

    static class Obj {
        double value;
        int firstValue;
        int secondValue;

        public Obj(double value, int firstValue, int secondValue) {
            this.value = value;
            this.firstValue = firstValue;
            this.secondValue = secondValue;
        }
    }

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<Obj> pq = new PriorityQueue<Obj>((a, b) -> {
            if(a.value<b.value) {
                return -1;
            }

            return 1;
        });

        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j< arr.length; j++) {
                pq.add(new Obj(getFraction(arr, i, j), arr[i], arr[j]));
            }
        }

        while(k>1) {
            pq.poll();
            k--;
        }

        int[] result = new int[2];
        Obj obj = pq.poll();
        assert obj != null;
        result[0] = obj.firstValue;
        result[1] = obj.secondValue;

        return result;
    }

    private double getFraction(int[] arr, int lo, int hi) {
        return (double)(1.0*arr[lo])/arr[hi];
    }
}
