
public class Soting {

    public static void main(String[] args) {
        int arr1[]={2,9,5,8,1,6,3,2};
        //System.out.println("Sorting");
        InsertionSortDecresingOrder(arr1);
        for (int i : arr1) {
            System.out.print(i+",");
        }
    }

    public static void InsertionSortIncresingOrder(int arr[]){
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i-1;
            while (j>=0  && arr[j]>key) {
                arr[j+1]= arr[j];
                j--;
            }
            arr[j+1]= key;
        }
    } 

    public static void InsertionSortDecresingOrder(int arr[]){
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i-1;
            while (j>=0  && arr[j]<key) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1]= key;
        }
    } 

    
}