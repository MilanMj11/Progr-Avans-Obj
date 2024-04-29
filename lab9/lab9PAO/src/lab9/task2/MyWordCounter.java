package lab9.task2;

import lab9.task1.SortedListSet;

import java.util.*;

public class MyWordCounter implements WordCounter{

    private HashMap<String,Integer> wordCounter;
    private SortedListSet<String> uniqueWords;

    public MyWordCounter() {
        wordCounter = new HashMap<>();
        uniqueWords = new SortedListSet<>();
    }

    @Override
    public void parse(String text) {
        String[] words = text.split(" ");
        for (String word : words){
            if(!word.isEmpty()){
                wordCounter.put(word, wordCounter.getOrDefault(word, 0) + 1);
                uniqueWords.add(word);
            }
        }
    }

    @Override
    public int getCount(String word) {
        Integer count = wordCounter.get(word);
        if(count == null){
            return 0;
        }
        return count;
    }

    @Override
    public SortedSet<String> getUniqueWords() {
        return this.uniqueWords;
    }

    @Override
    public void printWordCounts() {

        wordCounter.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(System.out::println);

    }

    @Override
    public void reset() {
        wordCounter.clear();
        uniqueWords.clear();
    }
}
