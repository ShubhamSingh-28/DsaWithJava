
public class Soting {

    public static void main(String[] args) {
        int arr[]={2,1,5,9,3,8,6};
       BrickSort(arr); 
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

}
