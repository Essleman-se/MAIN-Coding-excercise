package leetcode.exe;

import java.util.*;

public class HexaFront {

    public static int romanToInt(String s) {
//        Example 2:
//        Input: s = "LVIII"
//        Output: 58
//        Explanation: L = 50, V= 5, III = 3.
//        Example 3:
//        Input: s = "MCMXCIV"
//        Output: 1994

        Map<Character, Integer> romanInt = new HashMap<>();
        romanInt.put('I', 1);
        romanInt.put('V', 5);
        romanInt.put('X', 10);
        romanInt.put('L', 50);
        romanInt.put('C', 100);
        romanInt.put('D', 500);
        romanInt.put('M', 1000);

        int result = romanInt.get(s.charAt(s.length()-1));
        for (int i=s.length()-2; i >= 0; i--){

            if(romanInt.get(s.charAt(i)) < romanInt.get(s.charAt(i+1))){
                result -= romanInt.get(s.charAt(i));
            }else {
                result += romanInt.get(s.charAt(i));
            }
        }

        return result;
//        Time complexity : O(1)O(1).
//        If roman numerals had an arbitrary number of symbols, then the time complexity would be proportional to the length of the input, i.e. O(n)O(n). This is assuming that looking up the value of each symbol is O(1)O(1).
//        Space complexity : O(1)O(1).
//        Because only a constant number of single-value variables are used, the space complexity is O(1)O(1).
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i < nums.length; i++){
            if (map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]), i};
            }else{
                map.put(nums[i], i);
            }
        }


        return null;

        //-Time complexity: O(n)O(n). We traverse the list containing nn elements only once.
        // Each lookup in the table costs only O(1)O(1) time.
        //-Space complexity: O(n)O(n). The extra space required depends on the number
        // of items stored in the hash table, which stores at most nn elements.
    }


//    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
//    determine if the input string is valid.
    public static boolean isValid(String s) {

        //if(s.length() %2 != 0) return false;

        Stack<Character> stack = new Stack();

        for(Character c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else{
                if(stack.empty())
                    return false; //unmatched right bracket

                if(c == ')' && stack.peek() != '(' ||
                        c == '}' && stack.peek() != '{' ||
                        c == ']' && stack.peek()!= '[' ){
                    //Ensure match
                    return false;
                }else {
                    stack.pop();// good match
                }
            }
        }


        return stack.empty(); //if unmatched left

//        -Time complexity : O(n)O(n) because we simply traverse the given string one character
//        at a time and push and pop operations on a stack take O(1)O(1) time.

//        -Space complexity : O(n)O(n) as we push all opening brackets onto the stack
//        and in the worst case, we will end up pushing all the brackets onto the stack. e.g. ((((((((((
    }

    //121. Best Time to Buy and Sell Stock
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i=0; i < prices.length; i++){
            if(prices[i] < min){
                min = prices[i];
            }else{
                maxProfit = Math.max(maxProfit, prices[i]-min);
            }
        }

        return maxProfit;

        //Time complexity: O(n)O(n). Only a single pass is needed.
        //Space complexity: O(1)O(1). Only two variables are used.
    }

    //Longest Common Prefix
    public static String longestCommonPrefix(String[] strs) {

//        Input: strs = ["flower","flow","flight"]
//        Output: "fl"
        String prefix = strs[0];


        for(int i=1; i < strs.length; i++){

            while(strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0, prefix.length()-1);

                if (prefix.length() == 0) return "";
            }
        }

        return prefix;

        //Time complexity O(iteration element in the array * iteration of string)
        //Sapace conplexity O(1)
    }

    //Fizz Buzz
    public List<String> fizzBuzz(int n) {
//        Given an integer n, return a string array answer (1-indexed) where:
//        answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
//        answer[i] == "Fizz" if i is divisible by 3.
//        answer[i] == "Buzz" if i is divisible by 5.
//        answer[i] == i (as a string) if none of the above conditions are true.

        List<String> list = new ArrayList<>();
        for(int i=1; i <= n; i++){
            if(i % 3 == 0 && i % 5 == 0)
                list.add("FizzBuzz");
            else if(i % 3 == 0)
                list.add("Fizz");
            else if(i % 5 == 0)
                list.add("Buzz");
            else{
                list.add(String.valueOf(i));
            }


        }

        return list;

    }

    //Valid Palindrome II
    public static boolean validPalindrome(String s) {
        int i=0;
        int j=s.length()-1;

        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return isPalaindrom(s, i+1, j) || isPalaindrom(s, i, j-1);
            }

            i++;
            j--;
        }
        return true;

//        -Time complexity: O(N)O(N).
//        The main while loop we use can iterate up to N / 2 times, since each iteration
//        represents a pair of characters. On any given iteration, we may find a mismatch and
//        call checkPalindrome twice. checkPalindrome can also iterate up to N / 2 times,
//        in the worst case where the first and last character of s do not match.
//        Because we are only allowed up to one deletion, the algorithm only considers
//        one mismatch. This means that checkPalindrome will never be called more than twice.
//        As such, we have a time complexity of O(N)O(N).
//
//        -Space complexity: O(1)O(1).
//         The only extra space used is by the two pointers i and j, which can be
//         considered constant relative to the input size.
    }


    private static boolean isPalaindrom(String s, int i, int j){

        while(i < j){
            if(s.charAt(i++) != s.charAt(j--)){
                return false;
            }
        }
        return true;
    }

    public static boolean containsDuplicate(int[] nums) {
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length - 1; i++) {
//            if (nums[i] == nums[i + 1]) return true;
//        }
//        return false;

        Set<Integer> set = new HashSet();
        for(int num : nums){
            if(set.contains(num)){
                return true;
            }else{
                set.add(num);
            }
        }

        return false;

//        -Time complexity: O(n). We do search() and insert() for nn times and
//        each operation takes constant time.
//        -Space complexity: O(n). The space used by a hash table is linear with
//        the number of elements in it.
    }

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
    private static ListNode reverse(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }

        return prev;
    }

    public static void display(ListNode head) {
        ListNode current = head;
        while(current != null) {
            System.out.print(current.val + " --> ");
            current = current.next;
        }
        System.out.print("null");
        System.out.println();
    }
    public static boolean isPalindrome(ListNode head) {


//        if(head == null) return true;
//        List<Integer> l = new ArrayList();
//        while(head != null){
//            l.add(head.val);
//            head = head.next;
//        }
//
//        int start = 0;
//        int end = l.size()-1;
//        while(start < end){
//            if(l.get(start) != l.get(end)) return false;
//            if(!l.get(start).equals(l.get(end))) return false; this one is more appropriate b/c it is Integer not int
//            start++;
//            end--;
//        }
//        // this approch time and space complexity is O(n)
//        return true;

        if(head == null) return true;

        ListNode fast = head;
        ListNode slow = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;

        }

        if(fast != null) slow = slow.next;

        ListNode revHead = reverse(slow);
        while(revHead != null && head != null){
            if(revHead.val != head.val)
                return false;

            revHead = revHead.next;
            head = head.next;
        }

        return true;

//        -Time complexity : O(n)O(n), where nn is the number of nodes in the Linked List.
//        Similar to the above approaches. Finding the middle is O(n)O(n), reversing a list
//        in place is O(n)O(n), and then comparing the 2 resulting Linked Lists is also O(n)O(n).
//        -Space complexity : O(1)O(1).
//        We are changing the next pointers for half of the nodes. This was all memory that had
//        already been allocated, so we are not using any extra memory and therefore it is O(1)O(1).
        ////////////How the node is create ///////////


    }

    public static boolean isPalindromeNumber(int x) {
        if(x < 0) return false;
        int rev = 0;
        int n = x;
        while(n != 0){
            rev = rev * 10 + n%10;
            n = n/10;
        }

        if(rev == x) return true;

        return false;

//        -Time complexity : O(log10n)
//          We divided the input by 10 for every iteration, so the time complexity is O(log10n)
//        -Space complexity : O(1)
    }

    //Valid Word Abbreviation
    public static boolean validWordAbbreviation(String word, String abbr) {
        int i = 0;
        int j = 0;

        while(i < word.length() && j < abbr.length()) {

            if(word.charAt(i) == abbr.charAt(j)) {
                i ++;
                j ++;
                continue;
            }

            if(abbr.charAt(j) <= '0' || abbr.charAt(j) > '9')  return false;

            int start = j;
            while(j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                j ++;
            }

            int count = Integer.valueOf(abbr.substring(start, j));
            i += count;

        }

        if(i == word.length() && j == abbr.length()) {
            return true;
        } else {
            return false;
        }
    }

    //Unique Number of Occurrences
    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap();
        for (int num : arr){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        Set<Integer> set = new HashSet<>(map.values());

        return map.size() == set.size();

        //Time Complexity it linear O(n)
        //Space Complexity it linear O(n)
//
//        for(int i=0; i < arr.length; i++){
//            if(map.containsKey(arr[i]))
//                map.put(arr[i], map.get(arr[i])+1);
//            else
//                map.put(arr[i], 1);
//        }
//
//        Set<Integer> set = new HashSet();
//
//
//        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
//
//            if(set.add(entry.getValue()) == false){
//                return false;
//            }
//        }
//return true;

    }

    //Merge Two Sorted Lists
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode l3 = null;
        if(list1.val <= list2.val){
            l3 = list1;
            list1 = list1.next;
        }else{
            l3 = list2;
            list2 = list2.next;
        }


        ListNode currNode = l3;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                currNode.next = list1;
                list1 = list1.next;
            }else{
                currNode.next = list2;
                list2 = list2.next;
            }

            currNode = currNode.next;

        }

        if(list1 == null)
            currNode.next = list2;
        else
            currNode.next = list1;

        return l3;

        //time coplexity O(n + m)or O(list1 + list2)
        //Space coplexity O(1);
    }

    //Binary Search tree
    public static int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length-1;

        while(left <= right){
            int midpoint = left + (right-left)/2;

            if(nums[midpoint] == target)
                return midpoint;
            else if(nums[midpoint] > target)
                right = midpoint-1;
            else {
                left = midpoint+1;
            }
        }

        return -1;

        //Time Complexity O(logn)
        //Space Coplexity O(1) because usisng 3 variables to keep the range of the values
    }

    //Pascal's Triangle
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList();
        if(numRows == 0) return triangle;

        List<Integer> fRow = new ArrayList();
        fRow.add(1);
        triangle.add(fRow);

        for(int i=1; i < numRows; i++){
            List<Integer> preRow = triangle.get(i-1);
            List<Integer> currRow = new ArrayList();
            currRow.add(1);

            for(int j=1; j < i; j++){
                currRow.add(preRow.get(j-1) + preRow.get(j));
            }

            currRow.add(1);
            triangle.add(currRow);
        }


        return triangle;

//        -Time complexity: O(numRows^2)
//        -Space complexity: O(1)
//        While O(numRows^2)O)
//        space is used to store the output, the input and output generally do not
//        count towards the space complexity.
    }

    //Count Odd Numbers in an Interval Range
    public static int countOdds(int low, int high) {
        if(low % 2 == 0 && high % 2 == 0){
            return (high-low)/2;
        }

        return (high - low)/2 + 1;
        //Time Complexity O(1) because not using loops
        //Space Complexity O(1) because not using extra space

    }
    //Climbing Stairs
    public static int climbStairs(int n) {
        int[] st = new int[n+1];
        st[0] = 1;
        st[1] = 1;

        for(int i=2; i <= n; i++){
            st[i] = st[i-1] + st[i-2];
        }

        return st[n];
        //time complexity (n)
        //space complexity (n)
    }

    //Moving Average from Data Stream
    class MovingAverage {
        private Queue<Integer> q = new LinkedList<Integer>();
        private int capacity;
        private double sum;

        public MovingAverage(int size) {
            capacity = size;
        }

        public double next(int val) {
            if(q.size() == capacity){
                sum -= q.poll();
            }

            q.add(val);
            sum += val;

            return sum/q.size();
        }

        /**
         * Your MovingAverage object will be instantiated and called as such:
         * MovingAverage obj = new MovingAverage(size);
         * double param_1 = obj.next(val);
         */
    }
    //Maximum Units on a Truck
    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        //Old Comparator
//        final Comparator<Integr[]> arrayComparator = new Comparator<int[]>() {
//            @Override
//            public int compare(Integer[] o1, Integer[] o2) {
//                return o1[0].compareTo(o2[0]);
//            }
//        };
//        Arrays.sort(boxTypes, arrayComparator);
   //Old and nice comparotor
//        Arrays.sort(boxTypes, new Comparator<int[]>() {
//            public int compare(int[] frst, int[] scnd) {
//                if(frst[1] > scnd[1]) {
//                    return 1;
//                }
//                else return -1;
//            }
//        });

        //////Java 8
        Arrays.sort(boxTypes, (a, b) -> -Integer.compare(a[1],b[1])); //Decending Order
        int maxUnit = 0;

        for (int[] box : boxTypes){
            if (truckSize < box[0]){
                return maxUnit + truckSize * box[1];
            }
            maxUnit += box[0] * box[1];
            truckSize -= box[0];
        }

        return maxUnit;

    }

    //Valid Anagram
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] charCount = new int[26];
        for (int i=0; i < s.length(); i++){
           charCount[s.charAt(i)-'a']++;
           charCount[t.charAt(i)-'a']--;

            //System.out.println(Arrays.toString(charCount));
        }

        for (int count : charCount){
            if (count != 0)
                return false;
        }

        return true;
        //Time complexity O(n)
        // the space complexity is O(1) because the table's size
        // stays constant no matter how large n is.
        //////////////////////////////////////////////////////////////////////////

        //* for all characters for if the input contains unicode characters
//        if(s.length() != t.length()) return false;
//
//        Map<Character, Integer> charMap = new HashMap<>();
//
//        for (int i=0; i < s.length(); i++){
//            charMap.put(s.charAt(i), charMap.getOrDefault(s.charAt(i),0)+1);
//            charMap.put(t.charAt(i), charMap.getOrDefault(t.charAt(i),0)-1);
//        }
//
//        for (char c : charMap.keySet()){
//            if (charMap.get(c) != 0)
//                return false;
//        }
//
//        return true;
        //Time complexity O(n)
        ///Space complexity O(n) because we use hashmap as extra space
//////////////////////////////////////////////////////////////////////
        //Anather way
//        if (s.length() != t.length()) {
//            return false;
//        }
//        char[] str1 = s.toCharArray();
//        char[] str2 = t.toCharArray();
//        Arrays.sort(str1);
//        Arrays.sort(str2);
//        return Arrays.equals(str1, str2);

        //Time complexity O(nlog n). Assume that nn is the length of ss,
        // sorting costs O(nlog n) and comparing two strings costs O(n).
        // Sorting time dominates and the overall time complexity is O(nlog n).
        //Space complexity O(1). but we can also consider char array as extra space
    }

    //Logger Rate Limiter
    class Logger {

        private Map<String, Integer> times;

        public Logger() {
            times = new HashMap<>();
        }

        public boolean shouldPrintMessage(int timestamp, String message) {

            if(times.containsKey(message)){
                if(timestamp - times.get(message) >= 10){
                    times.put(message, timestamp);
                    return true;
                }

                return false;
            }else{
                times.put(message, timestamp);
                return true;
            }
        }
        //time complexity O(1)
        //space complexity O(n)
    }

    /**
     * Your Logger object will be instantiated and called as such:
     * Logger obj = new Logger();
     * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
     */

    //First Unique Character in a String
    public static int firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap();

        for(int i=0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }

        for(char c : map.keySet()){
            if(map.get(c) == 1)
                return s.indexOf(c);
        }

        // anather way to find the index
//        for (int i = 0; i < s.length(); i++) {
//            if (map.get(s.charAt(i)) == 1)
//                return i;
//        }

        //Another Aproch
//        for(int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if(s.indexOf(c) == s.lastIndexOf(c)) {
//                return i;
//            }
//        }
//
//        return -1;

        return -1;
        //Time complexity O(N) since we go through the string of length N two times.
        //Space complexity O(1) because English alphabet contains 26 letters.
    }

    //Merge Sorted Array
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        m--;
        n--;
        int indx = nums1.length-1;

        while(indx >= 0){
            if(m < 0){
                nums1[indx] = nums2[n--];
            }else if(n < 0){
                nums1[indx] = nums1[m--];
            }else{
                if(nums1[m] > nums2[n]){
                    nums1[indx] = nums1[m--];
                }else{
                    nums1[indx] = nums2[n--];
                }
            }
            indx--;
        }
        System.out.println(Arrays.toString(nums1));
        //Time complexity O(m+n)
        //Space Complexity O(1)
    }

    //Fibonacci Number
    public static int fib(int n) {

        if(n == 0) return 0;
        if(n == 1) return 1;

        int a = 0;
        int b = 1;
        System.out.print(a);
        System.out.print(b);
        int sum =0;

        while(n > 1){
            sum = a+b;
            a = b;
            b = sum;

            n--;
            System.out.print(sum);
        }

        return sum;
    }

    //Running Sum of 1d Array
    public int[] runningSum(int[] nums) {
        int sum = 0;
        for(int i=0; i < nums.length; i++){
            sum += nums[i];
            nums[i] = sum;
        }

        return nums;

        //Time Complexity O(n)
        //Space Complexity O(1)  since we don't use any additional space to find the
        // running sum. Note that we do not take into consideration
        // the space occupied by the output array.
    }
    //Power of Two
    public boolean isPowerOfTwo(int n) {
        //Bitwise AND opertion that means the given n and lese than one a give n
        //return n > 0 && ((n & (n-1)) == 0); //Time complexity O(1)
                                            //Space complexity O(1)


        if(n <= 0) return false;
        while(n%2 == 0){
            n /=2;
        }
        return n == 1;
    }

    //First Bad Version
    public int firstBadVersion(int n) {
        int left = 0;
        int right = n;

        while(left < right){
            int midpoint = left + (right - left)/2;
            if(isBadVersion(midpoint)){
                right = midpoint;
            }else {
                left = midpoint + 1;
            }
        }

        return left;

        //Time complexity O(\log n) The search space is halved each time,
        // so the time complexity is O(log n)
        //Space complexity O(1)
    }

    private boolean isBadVersion(int mid) {
        if(mid == 4)
            return true;

        return false;
    }

    //Transpose Matrix
    public int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] resMatr = new int[columns][rows];

        for(int i=0; i < rows; i++){
            for(int j=0; j < columns; j++){
                resMatr[j][i] = matrix[i][j];
            }
        }

        return resMatr;
        //Time Complexity O(R * C) where RR and CC are the number of rows and
        // columns in the given matrix.
        //Space Complexity O(R * C)the space used by the resMatr.
    }

    //Intersection of Two Arrays
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet();
        for(int n : nums1){
            set.add(n);
        }

        Set<Integer> commonNums = new HashSet<>();
        for(int n : nums2){
            if(set.contains(n)){
                commonNums.add(n);
            }
        }

        int[] result = new int[commonNums.size()];
        int indx = 0;
        for(int n : commonNums){
            result[indx++] = n;
        }

        return result;

        //Time Complexity : O(n+M) in the average case and O(n*m) in the worst case
        //Space Complexity : o(n+m) in the worst case when all elements in the array are
        // different
    }

    //Move Zeroes
    public static void moveZeroes(int[] nums) {

        int j = 0;

        // for(int i=0; i < nums.length; i++){
        //     if(nums[i] == 0 && nums[j] != 0){
        //         j = i;
        //     }else if(nums[i] != 0 && nums[j] == 0 ){
        //         nums[j] = nums[i];
        //         nums[i] = 0;
        //         j++;
        //     }
        // }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[j];
                nums[j++] = nums[i];
                nums[i] = temp;
            }
        }

        System.out.println(Arrays.toString(nums));

        //Time and space complexity O(1);
    }

    //Remove Palindromic Subsequences
    public static int removePalindromeSub(String s) {
//        if (s.isEmpty()) {
//            return 0;
//        }
//        // See below for code that compacts this into one line.
//        StringBuilder sb = new StringBuilder(s);
//        sb.reverse();
//        String reversedString = sb.toString();
//        if (reversedString.equals(s)) {
//            return 1;
//        }
//        return 2;
        //Above senario Time and space complexity is O(n)
//////////////////////////////////////////////////////////////////////


        if(s.isEmpty()) return 0;
        int i=0;
        int j=s.length()-1;
        while(i < j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }else{
                return 2;
            }
        }

        return 1;
        //This is approach scenario
        // Time complexity O(n)
        // Space complexity is O(1)

        //loops up to n/2 times
    }

    //Remove Duplicates from Sorted Array
    public static int removeDuplicates(int[] nums) {
        int indx = 1;

        for(int i=0; i < nums.length-1; i++){
            if(nums[i] != nums[i+1]){
                nums[indx++] = nums[i+1];
            }
        }

        System.out.println(Arrays.toString(nums));

        return indx;

        //Time Complexity O(n)
        //Space Complexity O(1)
    }

    //Reverse Linked List
    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        while(head != null){
            ListNode tempNode = head.next;
            head.next = prev;
            prev = head;
            head = tempNode;
        }

        return prev;

        //Time complexity :O(n). Assume that nn is the list's length, the time complexity is O(n).
        //Space complexity : O(1).


        ////How to create node
//        ListNode head = new ListNode(10);
//        ListNode second = new ListNode(20);
//        ListNode third = new ListNode(4);
//        ListNode fourth = new ListNode(100);
//
//        //Attach them together
//        head.next = second; //10-->20
//        second.next = third; //10-->20-->4
//        third.next = fourth; //10-->20-->4--100
        /////////end/////////////////////////
    }

    //Contains Duplicate II
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap();

        for(int i=0; i < nums.length; i++){
            if(map.containsKey(nums[i]) && i - map.get(nums[i]) <= k){
                return true;
            }else{
                map.put(nums[i], i);
            }
        }

        return false;

        //Time Complexity O(n)
        //Space Complexity O(n)
    }

    //Reverse Words in a String III
    public static String reverseWords(String s) {
     //it is a good approch regarding memory usage
            int j = 0;
            char[] chs = s.toCharArray();
            for(int i=0; i < chs.length; i++){
                if(chs[i] == ' '){
                    revers(chs, j, i-1);
                    j = i + 1;
                }
            }

            revers(chs, j, chs.length-1 );

            return new String(chs);
            ////////////////////////////////////////////////
           //Time complecity O(n)
           //Space Coplexity O(n)
           ////////////////////////////////////////////////

   //     String[] strArray = s.split(" ");
//        StringBuilder sb = new StringBuilder();
//        for(int i=0; i < strArray.length; i++){
//            String revWor = revers(strArray[i]);
//            if(sb.toString().isEmpty()){
//                sb.append(revWor);
//            }else{
//                sb.append(" ");
//                sb.append(revers(revWor));
//            }
//        }
//
//        return sb.toString();
        }
    private static void revers(char[] chs, int j, int i) {

        while (j <= i) {
            char temp = chs[j];
            chs[j] = chs[i];
            chs[i] = temp;

            j++;
            i--;
        }
    }
    //Richest Customer Wealth
    public static int maximumWealth(int[][] accounts) {
        int max = Integer.MIN_VALUE;
        for(int i=0; i < accounts.length; i++){
            int sum=0;
            for(int j=0; j < accounts[i].length; j++){
                sum += accounts[i][j];
            }
            max = Math.max(max, sum);
        }

        return max;

        //Time complexity O(m*n)
        //Space Complexity O(1)
    }




//    private static String revers(String s){
//        StringBuilder sb = new StringBuilder();
//        for(int i = s.length()-1; i >= 0; i--){
//            sb.append(s.charAt(i));
//        }
//
//        return sb.toString();
//    }

    //Majority Element
    public static int majorityElement(int[] nums) {
        ///////////////////More faster approch//////////
        if(nums.length == 1){
            return nums[0];
        }
        Map<Integer, Integer> map = new HashMap();

        for(int i : nums){
            if(map.containsKey(i) && map.get(i)+1 > nums.length/2){
                return i;
            }else{
                map.put(i, map.getOrDefault(i, 0)+1);
            }
        }

        return -1;

        /////////////////////////////////////////////////////
//        Map<Integer, Integer> map = new HashMap();
//        for(int i : nums){
//            map.put(i, map.getOrDefault(i, 0)+1);
//        }
//
//        for(int i : map.keySet()){
//            if(map.get(i) > nums.length/2){
//                return i;
//            }
//        }
//
//        return -1;

        //for all approach
        //Time complexity O(n)
        //Space complexity O(n)
    }
    //Count Binary Substrings
    public static int countBinarySubstrings(String s) {
        int count=0, i=1, curr=1, prev=0;

        while(i < s.length()){
            if(s.charAt(i-1) != s.charAt(i)){
                count += Math.min(prev, curr);
                prev = curr;
                curr = 1;
            }else{
                curr++;
            }

            i++;
        }

        return count += Math.min(prev, curr);

        //Time Complexity O(n)
        //Space Complexity O(1)
    }

    //Next Greater Element I
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack();

        for(Integer num : nums2){
            while(!stack.isEmpty() && stack.peek() < num){
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }

        for(int i=0; i < nums1.length; i++){
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }


        return nums1;

        //Time Complexity O(n)
        //Space Complexity O(n)
    }

    //Find Pivot Index
    public static int pivotIndex(int[] nums) {
        int totalSum = 0;
        int leftSum = 0;

        for(int num : nums){
            totalSum += num;
        }

        for(int i=0; i < nums.length; i++){
            if(i != 0)
                leftSum += nums[i-1];

            if(totalSum - leftSum - nums[i] == leftSum){
                return i;
            }
        }

        return -1;

        //Time Complexity O(n)
        //Space complexity O(1)
    }

    //Ransom Note
    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> counts = new HashMap<>();

        for(char c : magazine.toCharArray()){
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        for(char c : ransomNote.toCharArray()){
            if(!counts.containsKey(c) || counts.get(c) <= 0){
                return false;
            }

            counts.put(c, counts.get(c) - 1);
        }

        return true;
        //Time Complexity O(m+n)
        //Space Complexity O(n), because store chars into map from magazine string
    }

    //Valid Palindrome
    public boolean isPalindrome(String s) {
        String str =  s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        StringBuilder sb = new StringBuilder();
        int indx = 0;
        for(int i=str.length()-1; i >= 0; i--){
            if(str.charAt(indx++) != str.charAt(i)){
                return false;
            }
        }
        return true;
        //Time comlexity O(n)
        //Space complexity O(n)
    }
    //Isomorphic Strings
    public boolean isIsomorphic(String s, String t) {

        HashMap<Character, Character> map = new HashMap<>();

        for(int i=0; i < s.length(); i++){
            char x = s.charAt(i);
            char y = t.charAt(i);

            if(map.containsKey(x)){
                if(!map.get(x).equals(y))
                    return false;
            }else{
                if(!map.containsValue(y))
                    map.put(x, y);
                else
                    return false;

            }
        }

        return true;

        //Time Complexity O(n)
        //Space complexity O(n)

//        Map<Character, Integer> map1 = new HashMap<>();
//        Map<Character, Integer> map2 = new HashMap<>();
//
//        for(Integer i = 0; i <s.length(); i ++) {
//            if(map1.put(s.charAt(i), i) != map2.put(t.charAt(i), i))
//                return false;
//        }
//        return true;
    }

    //Reverse Vowels of a String
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        Set<Character> vowels = new HashSet<>();
        vowels.add('A');
        vowels.add('a');
        vowels.add('E');
        vowels.add('e');
        vowels.add('I');
        vowels.add('i');
        vowels.add('O');
        vowels.add('o');
        vowels.add('U');
        vowels.add('u');

        int i=0, j=s.length()-1;
        while(i < j){
            while(i < j && !vowels.contains(chars[i])){
                i++;
            }

            while(i < j && !vowels.contains(chars[j])){
                j--;
            }

            char temp = chars[i];
            chars[i++] = chars[j];
            chars[j--] = temp;

        }

        return new String(chars);

        //time comlexity O(n)
        //space O(n)
    }

    //Missing Number
    public static int missingNumber(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }

        int x = nums.length+1;
        return (x*(x-1)/2)-sum;

        //Time Complexity O(n)
        //Space Complexity O(1)
///////////////////////////////////////////////////////////////
//        Set<Integer> set = new HashSet<>();
//
//        for(int num : nums){
//            set.add(num);
//        }
//
//        for(int i=0; i <= nums.length; i++){
//            if(!set.contains(i)){
//                return i;
//            }
//        }
//
//        return -1;
        //Time Complexity O(n)
        //Space Complexity O(n)
    }

    //Remove All Adjacent Duplicates In String
    public static String removeDuplicates(String s) {
        int j = 0;
        char[] stack = new char[s.length()];

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(j > 0 && stack[j-1] == c){
                j--;
            }else{
                stack[j] = c;
                j++;
            }
        }

        return new String(stack, 0, j);
        //Time complexity O(n)
        //Space Complexity O(n)

//        StringBuilder sb = new StringBuilder();
//        Stack<Character> stack = new Stack();
//
//        for(int i=0; i < s.length(); i++){
//            char c = s.charAt(i);
//            if(stack.isEmpty() || stack.peek() != c){
//                stack.push(c);
//            }else{
//                stack.pop();
//            }
//        }
//
//        while(!stack.isEmpty()){
//            sb.append(stack.pop());
//
//        }
//
//        return sb.reverse().toString();

        //same complexity with the above one but a bit slow

    }


    ////////////////////Medium Questions////////////////////////////////
    //Merge Intervals
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
        int[] curArr = intervals[0];
        List<int[]> resultArr = new ArrayList<>();
        resultArr.add(curArr);

        for(int[] interval : intervals){
            int curStart = curArr[0];
            int curEnd = curArr[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if(curEnd >= nextStart){
                curArr[1] = Math.max(curEnd, nextEnd);

            }else{
                curArr = interval;
                resultArr.add(curArr);
            }
        }

        return resultArr.toArray(new int[resultArr.size()][]);

        //Time comp O(n);
        //Space Comp O(n)
    }

    // Number of Islands
    public static int numIslands(char[][] grid) {
        int count = 0;

        for(int i=0; i < grid.length; i++){
            System.out.println(Arrays.deepToString(grid));
            for(int j=0; j < grid[i].length; j++){
                System.out.println(Arrays.deepToString(grid));
                if(grid[i][j] == '1'){
                    count++;
                    callBFS(grid, i, j);
                }
            }
        }

        return count;
        //T com O(M * N) number of row and column
        //Space com worest case O(M * N)
    }

    private static void callBFS(char[][] grid, int i, int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j]=='0')
            return;

        grid[i][j] = '0';
        System.out.println(Arrays.deepToString(grid));
        callBFS(grid, i+1, j); //up
        System.out.println(Arrays.deepToString(grid));
        callBFS(grid, i-1, j); //down
        System.out.println(Arrays.deepToString(grid));
        callBFS(grid, i, j-1); //left
        System.out.println(Arrays.deepToString(grid));
        callBFS(grid, i, j+1); //right
        System.out.println(Arrays.deepToString(grid));

    }

    //Longest Substring Without Repeating Characters
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int maxLen = 0;
        int j = 0;
        int i = 0;

        while(i < s.length()){
            if(!set.contains(s.charAt(i))){
                set.add(s.charAt(i));
                maxLen = Math.max(set.size(), maxLen);
                i++;
            }else{
                set.remove(s.charAt(j));
                j++;
            }

        }

//        for(int i=0; i<s.length(); i++){
//            if (!set.contains(s.charAt(i))){
//                set.add(s.charAt(i));
//                maxLen = Math.max(set.size(), maxLen);
//            }else{
//                set.remove(s.charAt(j));
//                j++;
//                i--;
//            }
//        }




        return maxLen;
    }

    //Add Two Numbers
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;

        while(l1 != null || l2 != null){
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int sum = x + y + carry;
            carry = sum/10;
            curr.next = new ListNode(sum%10);
            curr = curr.next;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        if(carry > 0)
            curr.next = new ListNode(carry);

        display(dummy.next);

        return dummy.next;
        //Time complexity O(max(l1, l2)
        //Space Complexity O(1)
    }

    //Longest Palindromic Substring
    public String longestPalindrome(String s) {
        if(s == null || s.length()<1) return "";

        int start=0, end=0;

        for(int i=0; i < s.length(); i++){
            int len1 = exapandFromMidle(s, i, i);
            int len2 = exapandFromMidle(s, i, i+1);
            int len = Math.max(len1, len2);

            if(len > end - start){
                start = i - ((len - 1)/2);
                end = i +(len/2);
            }
        }


        return s.substring(start, end+1);

        //Tiem Complexity O(n2)
        //Space Complexity O(1);
    }

    private int exapandFromMidle(String s, int left, int right){
        if(s == null || left > right) return 0;

        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }

        return right - left - 1;
    }


    //Add Binary
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = a.length()-1;
        int j = b.length()-1;

        while(i >= 0 || j >= 0){
            int sum = carry;
            if(i >= 0)
                sum += a.charAt(i) - '0'; //ascii java car value '0'->48 and '1'->49
            if(j >= 0)
                sum += b.charAt(j) - '0';
            sb.append(sum%2);
            carry = sum/2;

            i--;
            j--;
        }

        if(carry > 0)
            sb.append(carry);

       //Time Complexity : O(max(m,n)) m and n is length of string a, b
        //Space Complexity : O(max(m,n)) m and n is length of string a, b

        return sb.reverse().toString();
    }
    //Sqrt(x)
    public int mySqrt(int x) {
        long res = 1;

        while(res * res <= x){
            ++res;
        }

        return (int) res-1;

    }

    //Check Whether Two Strings are Almost Equivalent
    public boolean checkAlmostEquivalent(String word1, String word2) {
        Map<Character, Integer> map = new HashMap();

        for(char c : word1.toCharArray()){
            if(map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            }else{
                map.put(c, 1);

            }
        }

        for(char c : word2.toCharArray()){
            if(map.containsKey(c)){
                map.put(c, map.get(c) - 1);
            }else{
                map.put(c, -1);
            }
        }

        for(char k : map.keySet()){
            if(Math.abs(map.get(k)) > 3){
                return false;
            }
        }
        //Time Complexity max(word1.len, word2.len)
        //Space Complexity max(word1.len, word2.len)

        return true;
    }
    public static void main(String[] args){
        String[] strs = {"dog","racecar","car"};
        int[] ints = {-1,0,3,5,9,12};
        int[][] boxTypes = {{1,3},{2,2},{3,1}};
        int truckSize = 4;
        HexaFront hexa =new HexaFront();
        HexaFront.Logger logger = hexa.new Logger();
        //System.out.println(logger.shouldPrintMessage(1, "foo"));
        //System.out.println("Index of first unic character is :   " + firstUniqChar("aabb"));
        int[] nums1 = {2,4};
        int m = 3;
        int[] nums2 = {1,2,3,4};
        int[] nums = {3, 0, 1};
        int n = 3;
        int[][] accounts = {{1,2,3},{3,2,1}};
        String ransomNote = "aa", magazine = "aab";
        //System.out.println(removeDuplicates("abbaac"));
        char[][] grid = {{'1','1','0','0','0'},
                          {'1','1','0','0','0'},
                          {'0','0','1','0','0'},
                          {'0','0','0','1','1'}};

        //System.out.println(numIslands(grid));
        //System.out.println(lengthOfLongestSubstring("abcabcbb"));
        ListNode l1 = new ListNode(2);
        ListNode second = new ListNode(4);
        ListNode third = new ListNode(3);
        l1.next = second;
        second.next = third;

        ListNode l2 = new ListNode(5);
        ListNode l2sec = new ListNode(6);
        ListNode l2third = new ListNode(4);
        l2.next = l2sec;
        l2sec.next = l2third;
        System.out.println(addTwoNumbers(l1, l2));

        //System.out.println(majorityElement(nums1));
        //System.out.println(countBinarySubstrings("00110011"));
        //System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
        //System.out.println(pivotIndex(nums));
        //System.out.println(canConstruct(ransomNote, magazine));
        //System.out.println(missingNumber(nums));
        //moveZeroes(nums1);
        //System.out.println(removeDuplicates(nums1));
        //System.out.println(reverseWords("Let's take LeetCode contest"));
        //System.out.println(maximumWealth(accounts));

        //merge(nums1, m, nums2, n);
        //System.out.println(fib(2));
        //System.out.println(Arrays.toString(intersection(nums1, nums2)));
        //System.out.println(uniqueOccurrences(ints));
        //System.out.println(generate(5));
        //System.out.println(search(ints, 9));
        //System.out.println(countOdds(3, 7));
        //System.out.println(climbStairs(4));
        //System.out.println(maximumUnits(boxTypes, 4));
        //Input: s = "anagram", t = "nagaram"
        //System.out.println(isAnagram("rat", "car"));

        //System.out.println(isPalindromeNumber(122));

        //System.out.println(node);
        //System.out.println("Is this palaindrome linked list :  " + isPalindrome(node));
        //System.out.println(romanToInt("MCMXCIV"));
        //int[] ints = {2,7,11,15};
        //System.out.println(Arrays.toString(twoSum(ints, 9)));
        //System.out.println(isValid("({}[])"));
        //System.out.println(longestCommonPrefix(strs));
        //System.out.println(validPalindrome("abcc"));
        //System.out.println(containsDuplicate(ints));
    }
}
