
public class Soting {

    public static void main(String[] args) {

        // int arr [] = {0,1};
        // int n = missingNumber(arr);
        // System.out.println(n);
        int arr[]={2,1,5,4,9,0,7,3,8,6};
        
      cyclicSort(arr); 
        for (int i : arr) {
            System.out.print(i+",");
        }
        // System.out.println();
        // InsertionSortDecresingOrder(arr);
        // for (int i : arr) {
        //     System.out.print(i+",");
        // }
    }

    public static void InsertionSortIncresingOrder(int arr[]){
        for(int i=1;i<arr.length;i++){
            int key=arr[i];
            int j=i-1;
            while(j>=0 && arr[j]>key){
                arr[j+1]=arr[j];
                j=j-1;
            }
            arr[j+1]=key;
        }
    }

    public static void InsertionSortDecresingOrder(int arr[]){
        for(int i=1;i<arr.length;i++){
            int key=arr[i];
            int j=i-1;
            while(j>=0 && arr[j]<key){
                arr[j+1]=arr[j];
                j=j-1;
            }
            arr[j+1]=key;
        }
    }
    

    //1st approch

    public static void SelectionSortIncreasingOrder(int arr[]){
        for (int i = 0; i < arr.length-1; i++) {
            int minEl = arr[i];
            int minElIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if (minEl > arr[j]) {
                    minEl= arr[j];
                    minElIndex = j;
                }
            }
            swap(arr,i,minElIndex);
        }
    }

    public static void SelectionSortDecreasingOrder(int arr[]){
        for (int i = 0; i < arr.length-1; i++) {
            int minEl = arr[i];
            int minElIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if (minEl < arr[j]) {
                    minEl= arr[j];
                    minElIndex = j;
                }
            }
            swap(arr,i,minElIndex);
        }
    }

    public static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 2nd aproach
    public static void BidiractionalSelectionSort(int arr[]){
        int k = arr.length-1;
        for (int i = 0; i < k; i++) {
            int minEl = arr[i];
            int minElIndex = i;
            int maxEl = arr[i];
            int maxElIndex = i;
            for (int j = i+1; j <= k; j++) {
                if (minEl > arr[j]) {
                    minEl= arr[j];
                    minElIndex = j;
                } else if (maxEl < arr[j]) {
                    maxEl= arr[j];
                    maxElIndex = j;
                }
            }
            swap(arr,i, minElIndex);
            if (maxEl == arr[minElIndex]) {
                swap(arr,k, minElIndex);
            } else {
                swap(arr,k, maxElIndex);
            }
            k--;
        }
    }

    public static void BubbleSort(int arr[]){
        int n =arr.length;
        int passes = n-2;

        for (int i = 0; i <=passes ; i++) {
             for (int j = 0; j <=passes-i; j++) {
                if (arr[j]<arr[j+1]){   
                    swap(arr,j,j+1);
                }
            }
        }

    }


    public static void BrickSort(int arr[]){
        int n =arr.length;
        boolean isSorted= false;
        while (!isSorted) {
            boolean flag = false;
            // for even case
            for (int i = 0; i <=n-2; i+=2) {
                if (arr[i]>arr[i+1]) {
                    swap(arr, i, i+1);
                    flag = true;
                }
            }

            //for odd case
            for (int i = 1; i <=n-2; i+=2) {
                if (arr[i]>arr[i+1]) {
                    swap(arr, i, i+1);
                    flag = true;
                }
            
            }

            if (!flag) {
                isSorted=true;
            }


        }
    }

    public static int[] CountingSort(int arr[]){
        int n = arr.length;
        int res[]= new int[n];
        int max= Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i]>max) {
                max= arr[i];
            }
        }
        if (max==Integer.MIN_VALUE) {
            return res;
        }
        int count[]= new int[max+1];
        // for finding frequancy
        for (int i = 0; i < n; i++) {
            int index = arr[i];
            count[index]++;
        }

        for (int i = 1; i <=max; i++) {
            count[i]+= count[i-1];
        }

        for (int i = n-1; i >=0; i--) {
            int val = arr[i];
            int countval = --count[val];
            res[countval] = val;
        }

        return res;

    }

    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int exceptedSum = n*(n+1)/2;
        System.out.println(exceptedSum);
        int actualSum = 0;
        for (int i = 0; i < nums.length; i++) {
            actualSum+= nums[i];
        }

        int res = exceptedSum - actualSum;
        return res;
    }
// 1 to n 

    public static void cycleSort (int arr[]){
        int n = arr.length;
        int index = 0;
        while (index < n) {
            int element = arr[index];
            int actualpos = element-1;
            if (arr[index]<n && arr[index] != arr[actualpos]) {
                swap(arr, index, actualpos);
            } else{
                index++;
            }
        }
    }

    // 0 to n

    public static void cycleSort0TON (int arr[]){
        int n = arr.length;
        int index = 0;
        while (index < n) {
            int element = arr[index];
            int actualpos = element;
            if (arr[index]<n && arr[index] != arr[actualpos]) {
                swap(arr, index, actualpos);
            } else{
                index++;
            }
        }
    }

    public static void cyclicSort (int arr[]){
        int n = arr.length;
       for (int i = 0; i < n-1; i++) {
        int pos =i;
        int item = arr[i];
         for (int j = i+1; j < arr.length; j++) {
            if (arr[j] < item) {
                pos++;
            }
         }
         if (pos == i) {
            continue;
         }
         while (arr[pos]== item) {
            pos++;
         }
         if (pos!=i) {  
          int temp =arr[pos];
          arr[pos] = item;
          item = temp;
         }

         while (pos!=i) {
             pos = i;
             for (int j= i+1;  j< arr.length; j++) {
                if (arr[j]<item) {
                    pos++;
                }
             }
             while (arr[pos]== item) {
                pos++;
             }

             if (item!=arr[pos]) {
                int temp =arr[pos];
          arr[pos] = item;
          item = temp;
             }
         }
       }
    }


}
