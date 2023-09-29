package Program3;

import java.util.HashMap;
import java.util.Map;

public class DuplicateCounter {

    private final String sentence;
    private final Map<String, Integer> wordCountMap = new HashMap<>();

    DuplicateCounter(String input) {
        this.sentence = input;
        this.populateWordCountMap();
    }

    /**
     * EFFECT prints duplicates in sentence
     */
    public void displayDuplicates() {
        int duplicateCount = this.countWordDuplicates();
        System.out.format("There are %d duplicated words in \"%s\"%n", duplicateCount, this);
    } // end displayDuplicates

    /**
     *
     * @return duplicate count
     * EFFECT print word duplicates
     */
    private int countWordDuplicates() {
        int duplicateCount = 0;

        for (String key : this.wordCountMap.keySet()) {
            if (this.wordCountMap.get(key) > 1) {
                System.out.format("%s is repeated %d times.%n", key, this.wordCountMap.get(key));
                duplicateCount++;
            }
        }
        return duplicateCount;
    } // end countWordDuplicates

    /**
     *  converts sentence to lowercase and removes punctuation; then adds words to array.
     * @return an array of the words in a sentence
     */
    private String[] listWords() {
        String lowerSentence = this.sentence.toLowerCase().replaceAll("\\p{Punct}", "");
        return lowerSentence.split(" ");
    } //end listWords

    /**
     * populates the WordCountMap with words from a String[]
     */
    private void populateWordCountMap(){

        for(String word: this.listWords()) {
            if (this.wordCountMap.containsKey(word)) {
                this.wordCountMap.put(word, this.wordCountMap.get(word) + 1);
            }
            else {
                this.wordCountMap.put(word, 1);
            }
        }
    }

    @Override
    public String toString() {
        return this.sentence;
    }

}