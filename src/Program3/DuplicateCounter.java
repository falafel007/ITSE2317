package Program3;

import java.util.HashMap;
import java.util.Map;

public class DuplicateCounter {

    private final String sentence;

    private final Map<String, Integer> wordCountMap = new HashMap<>();

    // Scanner Constructor
    DuplicateCounter(String input) {
        this.sentence = input;
    } //end scanner constructor

    private String[] listWords() {
        String lowerSentence = this.sentence.toLowerCase().replaceAll("\\p{Punct}", "");
        return lowerSentence.split(" ");
    } //end listWords

    private void createWordCountMap(){

        for(String word: this.listWords()) {

            if (this.wordCountMap.containsKey(word)) {
                Integer count = this.wordCountMap.get(word) + 1;
                this.wordCountMap.put(word, count);
            }
            else {
                this.wordCountMap.put(word, 1);
            }
        }
    } // end createMap

    public void displayDuplicates() {

        this.createWordCountMap();

        int duplicateCount = 0;

        for(String key: this.wordCountMap.keySet()) {
            if (this.wordCountMap.get(key) > 1) {
                System.out.format("%s is repeated %d times.%n", key, this.wordCountMap.get(key));
                duplicateCount++;
            }
        }
        System.out.format("There are %d duplicated words in \"%s\"%n", duplicateCount, this);
    } // end displayDuplicates

    @Override
    public String toString() {
        return this.sentence;
    } // end toString

}