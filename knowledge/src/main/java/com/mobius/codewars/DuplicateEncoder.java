package com.mobius.codewars;

//The goal of this exercise is to convert a string to a new string where each character in the new string is "(" if that character appears only once in the original string, or ")" if that character appears more than once in the original string. Ignore capitalization when determining if a character is a duplicate.
//
//        Examples
//        "din"      =>  "((("
//        "recede"   =>  "()()()"
//        "Success"  =>  ")())())"
//        "(( @"     =>  "))(("
//        Notes
//
//        Assertion messages may be unclear about what they display in some languages. If you read "...It Should encode XXX", the "XXX" is the expected result, not the input!

import java.util.*;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import org.apache.commons.lang3.StringUtils;
public class DuplicateEncoder {
    static String encode(String word){

        String wordInput = word.toLowerCase();
        Map<Character,Integer> wordMap = new HashMap<>();
        for (int i = 0 ; i < wordInput.length(); i++){
            Character value = Character.valueOf(wordInput.charAt(i));
            wordMap.put(value,wordMap.getOrDefault(value,0)+1);
        }
        char[] chars = wordInput.toCharArray();
        for (int j = 0; j < chars.length; j++) {
            if (wordMap.get(Character.valueOf(chars[j])) > 1) {
                chars[j] = ')';
            } else{
                chars[j] = '(';
            }
        }
        wordInput = new String(chars);
        return wordInput;
    }

    static String encode1(String word){
        String word_1 = word.toLowerCase();
        Set<String> word_dup = Arrays.stream(word_1.split("")).collect(Collectors.toSet());
        Integer w_index = -1;

        if(word.length() == word_1.replace(")","").length()+1){

            w_index = word_1.indexOf(")");
            word_dup.remove(")");
        }

        if(word.length() > word_1.replace("(","").length()+1){
            word_1 = word.replace("(",")");
            word_dup.remove("(");
        }
        if(w_index >= 0 ){
            word_1 = word_1.substring(0,w_index) + "(" + word_1.substring(w_index+1);
        }
        for(String x:word_dup){
            if( word.length() > word_1.replace(x,"").length()+1){
                word_1 = word_1.replace(x,")");
            }
            word_1 = word_1.replace(x,"(");

        }
        return word_1;
    }

    static String encode2(String word){
        word = word.toLowerCase();
        String result = "";
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            result += word.lastIndexOf(c) == word.indexOf(c) ? "(" : ")";
        }
        return result;
    }

    static String encode3(String word){
        return word.toLowerCase()
                .chars()
                .mapToObj(i -> String.valueOf((char)i))
                .map(i -> word.toLowerCase().indexOf(i) == word.toLowerCase().lastIndexOf(i) ? "(" : ")")
                .collect(joining());
    }

    static String encode4(String word) {
        word = word.toLowerCase();

        Map<Character, Integer> letters = new HashMap<Character, Integer>();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            Integer index = letters.get(c);

            if (index == null) {
                // First occurrence
                result.append("(");
                letters.put(c, i);
            } else if (index >= 0) {
                // 2nd occurrence, replace first instance, and set entry to -1
                result.replace(index, index + 1, ")");
                result.append(")");
                letters.put(c, -1);
            } else {
                result.append(")");
            }
        }
        return result.toString();
    }


    static String encode5(String word){
        String lowerWord = word.toLowerCase();
        StringBuilder result = new StringBuilder();
        for(char ch: lowerWord.toCharArray()) {
            boolean single = lowerWord.indexOf(ch) == lowerWord.lastIndexOf(ch);
            result.append(single ? '(' : ')');
        }
        return result.toString();
    }

    static String encode6(final String word) {
        final Map<Integer, Long> frequencies = word.codePoints()
                .map(Character::toLowerCase)
                .boxed()
                .collect(groupingBy(identity(), counting()));
        return word.codePoints()
                .map(Character::toLowerCase)
                .mapToObj(i -> frequencies.get(i) > 1 ? ")" : "(")
                .collect(joining());
    }
    static String encode7(String word)
    {
        word = word.toLowerCase();
        String result = "";
        for (int i = 0; i < word.length(); i++)
        {
            if (word.indexOf(word.charAt(i)) == word.lastIndexOf(word.charAt(i)))
                result += "(";
            else result += ")";

        }
        return result;
    }

    static String encode8(String word){
        String wrd = word.toLowerCase();
        return wrd.chars().mapToObj(i -> (char)i).map(chr ->
                wrd.length() - wrd.replace(chr.toString(), "").length() > 1 ? ")":"("
        ).collect(Collectors.joining(""));
    }

    static String encode9(String word){
        char[] cWord = word.toUpperCase().toCharArray();
        List<Character> wordArray = new ArrayList<>();
        for(char c : cWord)
        {
            wordArray.add(c);
        }
        Map<Character, Integer> frequencies = wordArray
                .stream()
                .distinct()
                .collect(
                        Collectors.toMap(
                                character -> character,
                                character -> Collections.frequency(wordArray, character)));
        Character[] plop = wordArray
                .stream()
                .map(character -> frequencies.get(character) == 1 ? '(': ')')
                .collect(Collectors.<Character>toList())
                .toArray(new Character[wordArray.size()]);
        for(int i = 0; i < plop.length; ++i)
        {
            cWord[i] = plop[i];
        }
        return new String(cWord);
    }

    static String encode10(String word) {
        StringBuilder encodedWord = new StringBuilder();
        String wordLowerCase = word.toLowerCase();
        for (int i = 0; i < word.length(); i++) {
            if (StringUtils.countMatches(wordLowerCase.toLowerCase(), wordLowerCase.charAt(i)) > 1) {
                encodedWord.append(")");
            } else {
                encodedWord.append("(");
            }
        }
        return encodedWord.toString();
    }
    public static void main(String[] args) {
        System.out.println(DuplicateEncoder.encode1("Success"));

    }
}
