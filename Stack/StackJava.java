import java.util.Scanner;

public class StackJava {
    int stack [];
    int top;
    int size;

    public StackJava(int stackSize){
        stack = new int[stackSize];
        top = -1;
        size = stackSize;
    }
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // sc.close();
       StackJava st = new StackJava(10);
       System.out.println(st.isempty());
       st.push(10);
       st.push(10);
       System.out.println(st.peek());
       System.out.println(st.size());
       st.printstack();
       System.out.println(st.isempty());
       st.push(100);
       st.printstack();
       System.out.println(st.peek());
       System.out.println(st.size());

    }

    public  boolean isempty(){
        return top <= -1;
    }

    public int size(){
        return top + 1;
    }

    public  void push(int element){
        if(top >= size - 1){
            System.out.println("Stack is full - overflow");
            return;
        }
        top++;
        stack[top] = element;
    }
    public int peek(){
        if(isempty()){
            System.out.println("Stack is empty - underflow");
            return Integer.MIN_VALUE;
        }
        return stack[top];
    }
    public void printstack(){
        for(int i = 0; i <= top; i++){
            System.out.print(stack[i] );
            if (i!= top) {
                System.out.print(",");
            }
        }
        System.out.println();

    }
    public  int pop(){
        int val = peek();
        if (val!=Integer.MIN_VALUE ) {
            top--;
        }
        return val;
        
    }
}
