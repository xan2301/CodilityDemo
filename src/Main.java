/**
 * Write a function that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A. <br/>
 * For example, given <code>A = [1, 3, 6, 4, 1, 2]</code>, the function should return 5. <br/>
 * Given <code>A = [1, 2, 3]</code>, the function should return 4. <br/>
 * Given <code>A = [-1, -3]</code>, the function should return 1. <br/>
 * <br/>
 * Write an efficient algorithm for the following assumptions: <br/>
 * N is an integer within the range <code>[1..100,000]</code>. <br/>
 * Each element of array A is an integer within the range <code>[-1,000,000..1,000,000]</code>. <br/>
 * <br/>
 * Max time for resolution: 30 minutes.
 */



class CodilityDemo {

    public static void main(String[] args) {

        CodilityDemo answer = new CodilityDemo();

        System.out.println(answer.answer1(new int[] {1, 3, 6, 4, 1, 2})); // 5
        System.out.println(answer.answer1(new int[] {1, 2, 3})); // 4
        System.out.println(answer.answer1(new int[] {-1, -3})); // 1
        System.out.println(answer.answer1(new int[] {-1000000, 1000000})); // 1
    }

    public int answer1(int[] A) {

        // check corner cases
        if (A == null || A.length == 0) {
            return 1;
        }

        // Each element of array A is an integer within the range [−1,000,000..1,000,000].
        // We are going to keep track only of positive numbers we have visited
        boolean[] visitedPositives = new boolean[1000000 + 1]; // initialized by the JVM with false

        // traverse all target array and keep track of positive integers
        for (int i=0, c=A.length; i < c; ++i) {

            // get current number
            int current = A[i];

            // keep track of visited positive numbers
            if (current > 0) {
                visitedPositives[current] = true;
            }
        }

        // traverse visited positive numbers array and keep the index > 0 of the first position marked as false
        for (int i=1, c=visitedPositives.length; i < c; i++) {
            if (!visitedPositives[i]) {
                return i;
            }
        }

        // fallback: all positive numbers exist in the A array
        return 10000001;
    }

}