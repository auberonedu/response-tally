import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * The Tallyer class provides functionality for reading ID and topic pairs from
 * user input,
 * and tallying the number of occurrences of each topic.
 */
public class Tallyer {

    /**
     * The main method serves as the entry point for the program. It reads pairs of
     * IDs and topics
     * from standard input, stores them in lists, and then calculates the number of
     * occurrences
     * of each topic. The IDs and topics are guaranteed to not include internal
     * whitespace.
     *
     * @param args command-line arguments (not used in this implementation)
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        List<String> ids = new ArrayList<>(); // Creates a list of Strings for the ids
        List<String> topics = new ArrayList<>(); // Creates a list of Strings for the topics

        // Reading input for IDs and topics
        // Assumes file is well formed into pairs
        while (input.hasNext()) { // while input has another value after it
            ids.add(input.next()); // adds each id to the created List
            topics.add(input.next()); // adds each topic to the created List
        }
        input.close(); // stops the Scanner

        // Wave 1
        Map<String, Integer> topicCounts = tallyTopics(topics); // creates a new map where the key is a String and value
                                                                // is an Integer
        System.out.println("Here are how many times each topic appears (unfiltered):");
        System.out.println(topicCounts);

        // Wave 2
        // Map<String, Integer> topicCountsFiltered = tallyTopicsFiltered(ids, topics);
        // System.out.println("Here are how many times each topic appears (filtered):");
        // System.out.println(topicCountsFiltered);
    }

    /**
     * Tally the occurrences of each topic from the provided lists of IDs and
     * topics.
     * This method takes two lists, one of IDs and one of topics, and returns a map
     * where each topic is associated with the number of times it appears in the
     * input.
     *
     * @param ids    a list of strings representing IDs associated with each topic
     * @param topics a list of strings representing the topics to be tallied
     * @return a map containing topics as keys and their occurrence counts as values
     */
    public static Map<String, Integer> tallyTopics(List<String> topics) {
        Map<String, Integer> countTopics = new HashMap<>();
        int x;
        // WAVE 1
        // TODO: Remove the print statements and implement this method
        for (String topic : topics) {
            if (countTopics.containsKey(topic)) {
                x = countTopics.get(topic);
                x++;
                countTopics.put(topic, x);
            } else {
                countTopics.put(topic, 1);
            }
        }

        return countTopics;
    }

    /**
     * Tally the occurrences of each topic from the provided lists of IDs and
     * topics.
     * This method takes two lists, one of IDs and one of topics, and returns a map
     * where each topic is associated with the number of times it appears in the
     * input.
     * However, any user who did not enter exactly 2 topics should not have their
     * votes counted.
     *
     * @param ids    a list of strings representing IDs associated with each topic
     * @param topics a list of strings representing the topics to be tallied
     * @return a map containing topics as keys and their occurrence counts as values
     */
    // public static Map<String, Integer> tallyTopicsFiltered(List<String> ids,
    // List<String> topics) {
    // // WAVE 2
    // // TODO: Implement this method

    // return null;
    // }
}
