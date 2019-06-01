package com.javaexamples.problems;


import java.util.HashMap;

public class Check2StringsAnagrams{


    public static void main(String[] args) {

        String str1 = "software_problems";
        String str2 = "problems_software";

        test(str1,str2);

        test("malay", "yalam");
    }

    private static void test(String str1, String str2) {

        System.out.println("We are checking 2 strings if they are anagram of each:  "+ str1+ " " + str2 );

        if(isAnagram(str1,str2)){
            System.out.println("Yes they are anagrams of each other");
        }
        else{
            System.out.println("No, they are not anagram of each other");
        }

    }

    private static boolean isAnagram(String str1, String str2) {

        HashMap<Character, Integer> hashMap1 = generateHashMapOfCharacterCounts(str1.toCharArray());
        HashMap<Character, Integer> hashMap2 = generateHashMapOfCharacterCounts(str2.toCharArray());

        return hashMap1.equals(hashMap2);
    }

    private static HashMap<Character,Integer> generateHashMapOfCharacterCounts(char inpArray[]){
        HashMap<Character, Integer> hashMap1 = new HashMap<Character, Integer>();

        for(int i = 0; i < inpArray.length; i++){
            if(hashMap1.get(inpArray[i]) == null){
                hashMap1.put(inpArray[i],1);
            }
            else{
                Integer integer = hashMap1.get(inpArray[i]);
                hashMap1.put(inpArray[i],integer++);
            }
        }

        return hashMap1;
    }


}