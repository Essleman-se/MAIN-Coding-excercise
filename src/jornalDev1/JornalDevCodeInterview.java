package jornalDev1;

import java.io.File;
import java.util.*;

public class JornalDevCodeInterview {

    public static void main(String[] args) {
        //System.out.println("Here go !!");


        String str = "ffffff";

        //System.out.println(revers(str));
        //swapNumbers(10, 20);
        //System.out.println(checkVowles(str));
        //System.out.println(checkPrimeNumber(6));
        //febonchenumber(10);
//        List<Integer> ints2 = Arrays.asList(1, 3, 5, 7);
//        List<Integer> ints = new ArrayList<>();
//        ints.add(1);
//        ints.add(9);
//        ints.add(3);
//        ints.add(5);

        //checkListOnlyOddNum(ints2);

        //System.out.println(palaindromString("aaav"));
        //System.out.println(removeWhiteSpace("salas seido"));
        //System.out.println(findFactorialOfIntegerRec(4));

        List<String> strings = Arrays.asList("Salas", "Semir", "Essain", "");

        strings.add(0, "Abeba");
        strings.remove(3);

        List<Integer> ll = new ArrayList<>();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);


//        System.out.println("Before revers");
//        System.out.println(ll);
//        System.out.println("After revers");


        //System.out.println(reverseLinkedList(ll));

        Integer[] a1 = {1,2,3,2,1};
        Integer[] a2 = {1,2,3};
        Integer[] a3 = {1,2,3,4};

        //System.out.println(checkSameElements(a1, a2));
        //System.out.println(checkSameElements(a1, a3));

        //System.out.println(findSecondLargeNum(new int[]{1,4,7,9,8}));

        //System.out.println(findStringInFile("C:/Users/seydo/Documents/examFile.txt", "Abebe"));

        Map<String, Integer> scores = new HashMap<>();
        scores.put("Salas", 90);
        scores.put("Semir", 23);
        scores.put("Agaje", 9);
        scores.put("Esain", 44);
        scores.put("Sol", 12);

        //System.out.println(sortedValue(scores));

        //sortedValue(scores);

//        for (Map.Entry<String, Integer> e : scores.entrySet()){
//            System.out.println(e.getKey() + " " + e.getValue());
//        }

        //System.out.println(removeCharOccurence("a", "abcdABCDabcdABCD"));
        //System.out.println(countDistictCharsInString("abcdABCDabcdABCD"));

        //profStringIsImmutable();

        try {
            foo(2);
        }catch (IllegalArgumentException | NullPointerException e){
            e.printStackTrace();
            //System.out.println(" Here is the exception thrown :-  "+e.getMessage());
        }
    }
    //next question
    //26. remove all occurrences of a given character from input String?

    public static void foo(Integer x) throws IllegalArgumentException, NullPointerException {
        int res  = 100/x;
        System.out.println("Argument value  :  " + res);
    }
    public static void profStringIsImmutable(){

        String s1 = "Java";
        String s2 = s1;

        System.out.println(s1 == s2);

        s1 = "python";

        System.out.println(s1 == s2);

        System.out.println(s2);

        String s3 = s2;

        s2 = s2 + "Javascript";

        System.out.println(s2);

        System.out.println(s3);


    }
    public static Map<Character, Integer> countDistictCharsInString(String str) {

        Map<Character, Integer> map = new HashMap();
        char[] chrs = str.toCharArray();

        for (char ch : chrs) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

//        for(Map.Entry<Character, Integer> entry : map.entrySet()){
//            if(entry.getValue() == 2)
//                System.out.println(entry.getKey() + "  " + entry.getValue());
//        }

        return map;
    }
    public static String removeCharOccurence(String chr, String str){
        String res = "";

        res = str.replace(chr, "");

        return res;
    }
    public static Map<String, Integer> sortedValue(Map<String, Integer> scores){

        Map<String, Integer> sortedScores = new LinkedHashMap<>();

        Set<Map.Entry<String, Integer>> entrySet = new HashSet<>(scores.entrySet());
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(entrySet);

        entryList.sort((x, y)-> x.getValue().compareTo(y.getValue()));

        for (Map.Entry<String, Integer> e : entryList){
            sortedScores.put(e.getKey(), e.getValue());
        }

        return sortedScores;
    }

    public static boolean findStringInFile(String filePath, String str) {

        File file = new File(filePath);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        while (scanner.hasNext()){
            String line = scanner.nextLine();
            if (line.contains(str)){
                return true;
            }
        }

        return false;
    }
    public static int findSecondLargeNum(int[] nums){
        int highest = Integer.MIN_VALUE;
        int secondHighest = Integer.MIN_VALUE;

        for (int num : nums){
            if (num > highest){
                secondHighest = highest;
                highest = num;
            }else if (num > secondHighest)
                secondHighest = num;
        }
        return secondHighest;
    }
    public static boolean checkSameElements(Object[] arr1, Object[] arr2){
        Set<Object> checkSet1 = new HashSet<>(Arrays.asList(arr1));
        Set<Object> checkSet2 = new HashSet<>(Arrays.asList(arr2));
        System.out.println("set 1");
        System.out.println(checkSet1);

        System.out.println("set 2");
        System.out.println(checkSet2);

        if (checkSet1.size() == checkSet2.size())
            return false;

        for (Object obj : checkSet1){
            if (!checkSet2.contains(obj))
                return false;
        }

        return true;
    }

    public static int binarySearch(int arr[], int low, int high, int key) {
        int mid = (low + high) / 2;

        while (low <= high) {
            if (arr[mid] < key) {
                low = mid + 1;
            } else if (arr[mid] == key) {
                return mid;
            } else {
                high = mid - 1;
            }
            mid = (low + high) / 2;
        }
        if (low > high) {
            return -1;
        }
        return -1;
    }


    public static List<Integer> reverseLinkedList(List<Integer> list){
        List<Integer> reverseList = new ArrayList<>();

        for (int i=list.size()-1; i >= 0; i--){
            reverseList.add(list.get(i));
        }


        return reverseList;
    }

    //recurtion factorail
    public static int findFactorialOfIntegerRec(int n){

        if (n == 1)
            return 1;
        else
            return (n * findFactorialOfInteger(n - 1));
    }

    public static int findFactorialOfInteger(int n){
        int result = 1;
        for (int i=1; i <= n; i++){
            result *= i;
        }

        return result;
    }

    public static boolean checkPalindromString(String str){

        if(str == null)
            throw new IllegalArgumentException("It is null");

        for (int i=0; i < str.length()/2; i++){
            if (str.charAt(i) != str.charAt(str.length()-i-1))
                return false;
        }

        return true;
    }

    public static String removeWhiteSpace(String str){
        StringBuilder res = new StringBuilder();
        char[] chs = str.toCharArray();

//        for(int i=0; i < chs.length; i++){
//            if (chs[i] == ' '){
//                continue;
//            }
//            res.append(chs[i]);
//        }

        for (char ch : chs){
            if (!Character.isWhitespace(ch)){
                res.append(ch);
            }
        }


        return res.toString();
    }

    public static boolean palaindromString(String str) {

        char[] chrs = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        int indx = 0;
        for (int i=chrs.length-1; i >= 0; i--){
            if (str.charAt(indx) != chrs[i])
                return false;
            indx++;
            sb.append(chrs[i]);
        }


        return str.equals(sb.toString());
    }

    public static boolean checkListOnlyOddNum(List<Integer> list) {
//        for (int num : intList){
//            if (num % 2 == 0)
//                return false;
//
//        }
//
//        return true;
        return list
                .parallelStream() // parallel stream for faster processing
                .anyMatch(x -> x % 2 != 0); // return as soon as any elements match the condition
    }

    public static void febonchenumber(int num) {
        int x = 0;
        int y = 1;
        int z = 1;

        for (int i = 1; i <= num; i++) {
            System.out.println(x + ",");
            x = y;
            y = z;
            z = x + y;

        }
    }

    public static boolean checkPrimeNumber(int num) {
        //int i = 2;
//        while (i <= num / 2) {
//            if (num % i == 0) {
//                return false;
//            }
//
//            i++;
//        }

        for (int i=2; i < num/2; i++){
            if (num%i == 0){
                return false;
            }
        }

        return true;
    }

    public static void swapNumbers(int x, int y) {
        System.out.println("Before swap");
        System.out.println("X : " + x + "   Y  :  " + y);

        x = x + y;
        y = x - y;
        x = x - y;

        System.out.println("After swap");
        System.out.println("X : " + x + "   Y  :  " + y);
        System.out.printf("X is %d, Y is %d", x, y);

    }

    public static String revers(String str) {

        if (str == null)
            throw new IllegalArgumentException("Null value is not accepted");
        StringBuilder sb = new StringBuilder();

        char[] chrs = str.toCharArray();

        for (int i = chrs.length - 1; i >= 0; i--) {
            sb.append(chrs[i]);
        }

        return sb.toString();

    }

    public static boolean checkVowles(String input) {

        return input.toLowerCase().matches(".*[aeiou].*");
    }
}
