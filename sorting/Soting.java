
public class Soting {

    public static void main(String[] args) {
        int arr[]={2,1,5,9,3,8,6};
        InsertionSortIncresingOrder(arr);
        for (int i : arr) {
            System.out.print(i+",");
        }
        System.out.println();
        InsertionSortDecresingOrder(arr);
        for (int i : arr) {
            System.out.print(i+",");
        }
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
    
}
