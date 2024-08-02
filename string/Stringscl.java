import java.util.Arrays;

public class Stringscl {
    public static void main(String[] args) {
    //     String email = "adfddfgh@gmail.com";
    //     String email2 = "adfddfghjghj@gmail23.com";

    //     String arrString []= email.split("@");
    //     String last = arrString[arrString.length-1];

    //   String arrr[]=  last.split("\\.");
    //   String last2 = arrr[arrr.length-2];
    //   System.out.println(last2);

      //string formatting
    //   double num = 67.78757;
    //   System.out.printf("Number is %.2f", num);
    //PrintAllSubstring("abc");
   //PrintAllSubstring("abcde");
   boolean af =isAnagram("abcd", "dcba");
System.out.println(af);

//    String inp = "ABCDE";
//  reverseString(inp);
      
     palindome("mAdam");
     boolean a = palindome2("mAdam");
     System.out.println(a);


    }

    public static void PrintAllSubstring(String input){
        int n = input.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                System.out.println(input.substring(i, j));
            }
        }
    }
  // 1st approach
    public static String reverseString(String input){
        String str = "";
        // for (int i = input.length()-1; i >=0; i--) {
        //     str += input.charAt(i);
        // }

        for (int i = 0; i < input.length(); i++) {
            str = input.charAt(i)+str;
        }
        return str;
        //System.out.println(str);
    }
    // 2nd approch

    public static void reverseString2(String input){
        StringBuilder sb = new StringBuilder(input);
        int n = sb.length();
        for (int i = 0; i < n / 2; i++) {
            char firstChar = sb.charAt(i);
            char lastChar = sb.charAt(n-1-i);
            sb.setCharAt(i, lastChar);
            sb.setCharAt(n-1-i, firstChar);
        }
        System.out.println(sb.toString());
    }

    // 3rd approach

    public static void reverseString3(String input){
        char charArr []= input.toCharArray();
        int n = charArr.length;
        for (int i = 0; i < n / 2; i++) {
            char temp = charArr[i];
            charArr[i] = charArr[n-1-i];
            charArr[n-1-i] = temp;
            // char firstChar =charArr[i];
            // char lastChar = charArr[n-1-i];
            // charArr[i]= lastChar;
            // charArr[n-1-i] = firstChar;
        }
        for (char c : charArr) {
            System.out.print(c+",");
        }
        
    }

    // 1st simple approach
    public static void palindome(String input1){
        String input = input1.toLowerCase();
        String str = reverseString(input);
        if (str.equals(input)) {
            System.out.println("this string is palindrome");
        } else {
            System.out.println("this string is not palindrome");
        }
    }
    // 2nd approach
    public static boolean palindome2(String input1){
        String input = input1.toLowerCase();
        int start = 0;
        int end = input.length()-1;
        while (start<=end) {
            if (input.charAt(start) != input.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public String reverseWords(String s) {
        String str []= s.split(" ");
        String res = " ";
        for(int i = str.length-1 ; i >=0; i--){
        if(str[i].length()==0){
            continue;
        }
        if(res.length()==0){
            res+=str[i];
        } else {
             res +=  " " + str[i] ;
        }
        }
        return res;
    }

     public static boolean isAnagram(String a, String b){
        if (a.length()!=b.length()) {
            return false;
        }
        char arr1[]= a.toCharArray();
        char arr2[]= b.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int index1 = 0;
        int index2 = 0;
        int len = arr1.length;

        while (index1<len && index2 <len) {
            if (arr1[index1]!= arr2[index2]) {
                return false;
            }
            index1++;
            index2++;
        }
        return true;
    }


}
