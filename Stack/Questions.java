import java.util.Stack;

public class Questions{
    public static void main(String[] args) {
        // boolean  a = validparanthisis("{{}{{}}");
        int  a = valid("()))");
       // System.out.println(a);
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

}