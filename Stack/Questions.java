import java.util.Arrays;
import java.util.Stack;

public class Questions{
    public static void main(String[] args) {
        // boolean  a = validparanthisis("{{}{{}}");
        // int  a = minSwaps("[]]]][][[[[]");
        // System.out.println(a);

        long[] arr = {1,3,2,4}; // Example array
        long[] result = nextGreaterElement(arr,4);
        System.out.println(Arrays.toString(result)); 
       
    }

    public static boolean validparanthisis(String s){
        Stack<Character> stack= new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char  ch = s.charAt(i);
            if (ch=='{'|| ch=='[' || ch=='(') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (ch==']'&& stack.peek()!='[') {
                    return false;
                } else if (ch=='}'&& stack.peek()!='{') {
                    return false;
                } else if (ch==')'&& stack.peek()!='(') {
                    return false;
                } else{
                    stack.pop();
                }
            }
        }
        return stack.size()==0;
    }


    public static int countrev(String s){
        if (s.length()%2!=0) {
            return -1;
        }
        Stack<Character> stack= new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char  ch = s.charAt(i);
            if (ch=='{') {
                stack.push(ch);
            }else {
               if (stack.isEmpty()|| stack.peek()!='{') {
                stack.push(ch);
               } else{
                stack.pop();
               }
            }
        }
        int ans =0,open=0,close=0;
        while (!stack.isEmpty()) {
            char top = stack.pop();
            if(top =='{'){
                open++;
            } else{
                close++;
            }
        }
        ans= (int)(Math.ceil(open/2.0) +Math.ceil(close/2.0));
        return ans;
    }

    public static int valid(String s){

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch=='('){
                stack.push(ch);
            } else{
                if (stack.isEmpty() || stack.peek() != '(') {
                    stack.push(ch);
                } else {
                    stack.pop();
                }
            }
        }
       
        return stack.size();
    }

    public static int minSwaps(String s) {
        int open = 0;
        int close = 0;
        int swap = 0;
        int unbalance = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch= s.charAt(i);
            if (ch == '[') {
                open++;
                if (unbalance>0) {
                    swap+=unbalance;
                    unbalance--;
                }
            } else{
                close++;
                unbalance = close-open;
            }
        }
        return swap;
    }


    public static long[] nextGreaterElement(long[]arr,int n){
        Stack<Long> stack = new Stack<>();
        long[] result = new long[n];
        for (int i = n-1; i >=0 ; i--) {
            while (!stack.isEmpty() && stack.peek()<=arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty() ) {
                result[i]=-1;
            } else {
                result[i]=stack.peek();
            }
            stack.push(arr[i]);
        }
        return result;
    }

public static int[] findNextGreaterElements(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Arrays.fill(result, -1); // Initialize result array with -1

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    result[i] = arr[j];
                    break; // Found the next greater element
                }
            }
        }

        return result;
    }


}