package s30.preCourse2;

class MergeSort
{
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int arr[], int l, int m, int r)
    {
        int[] tempArr = new int[r-l+1];
        int idx1 = l;
        int idx2 = m+1;
        int x = 0;
        while(idx1 <= m && idx2 <= r) {
            if(arr[idx1] <= arr[idx2]) {
                tempArr[x++] = arr[idx1++];
            } else {
                tempArr[x++] = arr[idx2++];
            }
        }

        while(idx1 <= m) {
            tempArr[x++] = arr[idx1++];
        }
        while(idx2 <= r) {
            tempArr[x++] = arr[idx2++];
        }
        for(int i = l , j = 0 ; i <= r ; i++, j++) {
            arr[i] = tempArr[j];
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int l, int r) {
        int mid = l + (r-l)/2;
        if(l>=r) return;

        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver method
    public static void main(String args[])
    {
        int arr[] = {12, 11, 13, 5, 6, 7};

        System.out.println("Given Array");
        printArray(arr);

        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length-1);

        System.out.println("\nSorted array");
        printArray(arr);
    }
}
