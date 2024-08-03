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
//    boolean af =isAnagram("rat", "car");
// System.out.println(af);

//    String inp = "ABCDE";
//  reverseString(inp);
      
    //  palindome("mAdam");
    //  boolean a = palindome2("mAdam");
    //  System.out.println(a);

    String ab = reverseVowels("hello");
    System.out.println(ab);

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


    public static String reverseWords3(String s) {
        StringBuilder sb = new StringBuilder(s);
        int len = sb.length();
        int start = 0;
        for(int end = 0; end <=len; end++){
            // word will end at space or at end of string
            if(end == len || sb.charAt(end)==' '){
                reverse(sb, start, end-1);
                start = end+1;
            }
        }
        return sb.toString();
        
    }
   
    public static void reverse (StringBuilder sb,int start, int end){
        while(start<end){
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }


    public static String reverseStr(String s, int k) {
        char arr[]= s.toCharArray();
        int n = arr.length;
        for(int i=0; i<n-1; i+=2*k){
            int b=Math.min(i+k-1, s.length()-1);
               reverse4(arr, i, b);

        }
        return new String(arr);
    }

    public static void reverse4(char[] arr, int start, int end){
        while(start<end){
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end]= temp;
            start++;
            end--;
        }
    }

    public static String reverseVowels(String s) {
        char arr []= s.toCharArray();
        int start = 0, end = s.length()-1;
        String vowels = "aeiouAEIOU";
        while (start<end) {
          while (start < end && vowels.indexOf(arr[start])==-1) {
            start++;
          }

          while (start < end && vowels.indexOf(arr[end])==-1) {
            end--;
          }
          
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return new String(arr);
    }

}
