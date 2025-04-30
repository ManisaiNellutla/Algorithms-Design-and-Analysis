public class EasyNPComplete {
    public static boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums) total += num;
        if (total % 2 != 0) return false;
        return subsetSum(nums, total / 2, 0);
    }

    static boolean subsetSum(int[] arr, int sum, int idx) {
        if (sum == 0) return true;
        if (idx >= arr.length || sum < 0) return false;
        return subsetSum(arr, sum, idx + 1) || subsetSum(arr, sum - arr[idx], idx + 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        System.out.println("Can be partitioned? " + canPartition(nums));
    }
}



--------------------------------------------------------------------------------------

import java.util.*;

public class EasyNPComplete {
    public static boolean canPartition(int[] nums) {
        System.out.println("Input array: " + Arrays.toString(nums));  // Print input

        int total = 0;
        for (int num : nums) total += num;

        if (total % 2 != 0) return false;

        List<Integer> result = new ArrayList<>();
        boolean found = subsetSum(nums, total / 2, 0, result);
        if (found) {
            System.out.println("Subset that forms half of total: " + result);
        }
        return found;
    }

    static boolean subsetSum(int[] arr, int sum, int idx, List<Integer> subset) {
        if (sum == 0) return true;
        if (idx >= arr.length || sum < 0) return false;

        // Include arr[idx]
        subset.add(arr[idx]);
        if (subsetSum(arr, sum - arr[idx], idx + 1, subset)) {
            return true;
        }
        subset.remove(subset.size() - 1); // Backtrack

        // Exclude arr[idx]
        return subsetSum(arr, sum, idx + 1, subset);
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        System.out.println("Can be partitioned? " + canPartition(nums));
    }
}
-----------------------------------------------------------------------------
import java.util.Arrays;

public class EasyNPHard {
    static int minTime = Integer.MAX_VALUE;

    public static void assignTasks(int[] tasks, int i, int m1, int m2) {
        if (i == tasks.length) {
            minTime = Math.min(minTime, Math.max(m1, m2));
            return;
        }

        assignTasks(tasks, i + 1, m1 + tasks[i], m2); // assign to machine 1
        assignTasks(tasks, i + 1, m1, m2 + tasks[i]); // assign to machine 2
    }

    public static void main(String[] args) {
        int[] tasks = {3, 1, 4, 2, 2};
        assignTasks(tasks, 0, 0, 0);
        System.out.println("Minimum time to finish all tasks: " + minTime);
    }
}
--------------------------------------------------------
import java.util.Random;

public class RandomizedQuickSort {

    // Function to swap two elements in the array
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Standard partition process (Lomuto partition)
    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];  // pivot is last element
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    // Randomized partition: choose random pivot, swap with last element, then call standard partition
    static int randomizedPartition(int[] arr, int low, int high) {
        Random rand = new Random();
        int pivotIndex = rand.nextInt(high - low + 1) + low;
        swap(arr, pivotIndex, high);  // Move random pivot to end
        return partition(arr, low, high);
    }

    // Main randomized quick sort function
    static void randomizedQuickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = randomizedPartition(arr, low, high);
            randomizedQuickSort(arr, low, pi - 1);
            randomizedQuickSort(arr, pi + 1, high);
        }
    }

    // Main method to test
    public static void main(String[] args) {
        int[] arr = {10, 80, 30, 90, 40, 50, 70};

        System.out.println("Original array:");
        for (int num : arr) System.out.print(num + " ");

        randomizedQuickSort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array:");
        for (int num : arr) System.out.print(num + " ");
    }
}