package simpleHttpServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Anagram {

    private final String filename = "words.txt";

    public List<String> findAnagrams(String word){
        var anagrams = new ArrayList<String>();
        var wordList = loadWordList();
        var sortedWord = sortWord(word);

        wordList.forEach(w -> {
            if (sortedWord.equals(sortWord(w))) anagrams.add(w);
        });
        return anagrams;
    }

    private String sortWord(String word) {
        var sortedWord = word.toLowerCase().toCharArray();
        Arrays.sort(sortedWord);
        return new String(sortedWord);
    }

    private Set<String> loadWordList() {
        List<String> words = new ArrayList<>();
        try (var wordList = getClass().getClassLoader().getResourceAsStream(filename)) {
            String word;
            var reader = new BufferedReader(new InputStreamReader(wordList));
            while ((word = reader.readLine()) != null){
                words.add(word.toLowerCase());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new HashSet<>(words);
    }
}
