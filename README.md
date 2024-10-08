import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * The Tallyer class provides functionality for reading ID and topic pairs from user input,
 * and tallying the number of occurrences of each topic.
 */
public class Tallyer {

    /**
     * The main method serves as the entry point for the program. It reads pairs of IDs and topics
     * from standard input, stores them in lists, and then calculates the number of occurrences
     * of each topic. The IDs and topics are guaranteed to not include internal whitespace.
     *
     * @param args command-line arguments (not used in this implementation)
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        List<String> ids = new ArrayList<>();
        List<String> topics = new ArrayList<>();
        
        // Reading input for IDs and topics
        // Assumes input is well formed into pairs
        while (input.hasNext()) {
            ids.add(input.next());
            topics.add(input.next());
        }
        input.close();
        
        // Wave 1
        Map<String, Integer> topicCounts = tallyTopics(topics);
        System.out.println("Here are how many times each topic appears (unfiltered):");
        System.out.println(topicCounts);

        // Wave 2
        Map<String, Integer> topicCountsFiltered = tallyTopicsFiltered(ids, topics);
        System.out.println("Here are how many times each topic appears (filtered):");
        System.out.println(topicCountsFiltered);
    }

    /**
     * Tally the occurrences of each topic from the provided lists of topics.
     * This method takes a list of topics and returns a map where each topic is associated
     * with the number of times it appears in the input.
     *
     * @param topics a list of strings representing the topics to be tallied
     * @return a map containing topics as keys and their occurrence counts as values
     */
    public static Map<String, Integer> tallyTopics(List<String> topics) {
        // Create a map to hold the count of each topic
        Map<String, Integer> topicCountMap = new HashMap<>();

        // Iterate through the list of topics and count occurrences
        for (String topic : topics) {
            topicCountMap.put(topic, topicCountMap.getOrDefault(topic, 0) + 1);
        }

        System.out.println("Topic counts: " + topicCountMap); // Debugging line
        return topicCountMap; // Return the map with topic counts
    }

    /**
     * Tally the occurrences of each topic from the provided lists of IDs and topics.
     * This method takes two lists, one of IDs and one of topics, and returns a map
     * where each topic is associated with the number of times it appears in the input.
     * However, any user who did not enter exactly 2 topics should not have their votes counted.
     *
     * @param ids a list of strings representing IDs associated with each topic
     * @param topics a list of strings representing the topics to be tallied
     * @return a map containing topics as keys and their occurrence counts as values
     */
    public static Map<String, Integer> tallyTopicsFiltered(List<String> ids, List<String> topics) {
        Map<String, Integer> filteredTopicCountMap = new HashMap<>();

        // Create a map to count the occurrences of IDs
        Map<String, Integer> idCountMap = new HashMap<>();
        for (String id : ids) {
            idCountMap.put(id, idCountMap.getOrDefault(id, 0) + 1);
        }

        System.out.println("ID counts: " + idCountMap); // Debugging line

        // Iterate through the topics and count occurrences for valid IDs
        for (int i = 0; i < ids.size(); i++) {
            String id = ids.get(i);
            String topic = topics.get(i);
            // Only count if the ID appears exactly twice
            if (idCountMap.get(id) == 2) {
                filteredTopicCountMap.put(topic, filteredTopicCountMap.getOrDefault(topic, 0) + 1);
            }
        }

        System.out.println("Filtered topic counts: " + filteredTopicCountMap); // Debugging line
        return filteredTopicCountMap; // Return the map with filtered topic counts
    }
}
