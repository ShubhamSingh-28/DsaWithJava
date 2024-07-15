
public class Soting {

    public static void main(String[] args) {
        System.out.println("Sorting");
    }

    public static void InsertionSort(int arr[]){
        for(int i = 0;i<=arr.length-1;i++){
            int key = arr[i];
            int j = i-1;
            while(j>=0&&arr[j]>key){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]= key;
        }
    }

    
}
