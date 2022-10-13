import java.io.*;
import java.util.*;

class Anagram{
    public static void main(String args[])throws IOException{
        Scanner sc=new Scanner(System.in);
        //Converting the input strings to lowercase so that Rat and rat are interpreted the same 
        System.out.println("Enter string one");
        String a=sc.next().toLowerCase();
        System.out.println("Enter string two");
        String b=sc.next().toLowerCase();
        boolean ans=isAnagram(a,b);
        if(ans){
            System.out.println("True");
        }
        else{
            System.out.println("False");
        }
    }
    static boolean isAnagram(String a , String b){
        //for two strings to be anagram, they must be of same length 
        if (a.length() != b.length()) {
            return false;
        }
        
        
        //Hashmap that stores character as key and count of character as Value.
        HashMap<Character, Integer> map = new HashMap<>();
        
        //Looping over all character of String a and putting in HashMap.
        for(int i=0;i<a.length();i++){
            // If map already has that character, increase count by 1 for that character
            // else put that character in map and set count to 1 
            if(map.containsKey(a.charAt(i))){
                map.put(a.charAt(i), map.get(a.charAt(i))+1);
            }
            else{
                map.put(a.charAt(i), 1);
            }
        }
        
        //looping over String b
        for (int i = 0; i < b.length(); i++) {
            // If hashmap contains the character, reduce count of that character by 1 
            //If by the end of this loop all the keys of hashmap become zero, it would mean that both string have same character
            if (map.containsKey(b.charAt(i))) {
                map.put(b.charAt(i),map.get(b.charAt(i)) - 1);
            }
            else {
                return false;
            }
        }
        
        Set<Character> keys = map.keySet();
        //Loop over all keys and check if all keys are 0. 
        //0 means they are anagram 
        for (Character key : keys) {
            if (map.get(key) != 0) {
                return false;
            }
        }
        return true;
    }
}

/*
 *Time Complexity: O(N)
 *Space Complexity: O(1)
 *Approach:
 *1)Iterate over "String a" and store it in hashmap such that different letters with their frequency of count are stored.
 *2)Iterate over "String b". For each character in String b check: if it exists in map reduce the frequenchy count.
 *  If it does not exist "return False" as it would mean that a new letter has been detetcted in String b which is not in String a.
 *3)Make a set of all keys, ie., frequency counts of map and iterate over them.
 *  If any one is not 0, this would been that frequency of a character is more or less in String b than String a.
 *  So, it is not an Anagram
 *4) Return true if no condition fails.
 */