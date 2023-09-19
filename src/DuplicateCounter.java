
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class DuplicateCounter {

    private final String sentence;

    private Map<String, Integer> wordCountMap = new HashMap<>();

    // Scanner Constructor
    DuplicateCounter(Scanner input) {
        this.sentence = input.nextLine();
    } //end scanner constructor

    public String getSentence() {
        return this.sentence;
    }

    private String[] listWords() {
        String lowerSentence = this.sentence.toLowerCase();
        return lowerSentence.split(" ");
    } //end listWords

    public void setWordCountMap(){

        for(String word: this.listWords()) {

            if (this.wordCountMap.containsKey(word)) {
                Integer count = this.wordCountMap.get(word) + 1;
                this.wordCountMap.put(word, count);
            }
            else {
                this.wordCountMap.put(word, 1);
            }
            // System.out.format("%s: %d%n", word, this.wordCountMap.get(word));
        }
    } // end createMap

    public void displayDuplicates() {

        int duplicateCount = 0;

        for(String key: this.wordCountMap.keySet()) {
            if (this.wordCountMap.get(key) > 1) {
                System.out.format("%s is repeated %d times.%n", key, this.wordCountMap.get(key));
                duplicateCount++;
            }
        }
        System.out.format("There are %d duplicated words in \"%s\"", duplicateCount, this);
    } // end displayDuplicates

    @Override
    public String toString() {
        return this.sentence;
    } // end toString

}