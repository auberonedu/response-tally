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
        // Assumes file is well formed into pairs
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
     * Tally the occurrences of each topic from the provided lists of IDs and topics.
     * This method takes two lists, one of IDs and one of topics, and returns a map
     * where each topic is associated with the number of times it appears in the input.
     *
     * @param ids a list of strings representing IDs associated with each topic
     * @param topics a list of strings representing the topics to be tallied
     * @return a map containing topics as keys and their occurrence counts as values
     */
    public static Map<String, Integer> tallyTopics(List<String> topics) {
        // WAVE 1
        // DONE THE TO-DO!
        Map<String, Integer> waveOneMap = new HashMap<>();
        
        // looping through
        for (String topic : topics) {
            // if the topic is already there 
            if (waveOneMap.containsKey(topic)) {
                waveOneMap.put(topic, waveOneMap.get(topic) + 1);
            } else {
                waveOneMap.put(topic, 1);
            }
        }
        return waveOneMap;  
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
      // WAVE 2
      // DONE THE TO-DO!
        Map<String, Integer> waveTwoMap = new HashMap<>();
        Map<String, Integer> userTopicCounts = new HashMap<>();

        // count the number of topics that each user entered
        for (String id : ids) {
            if (userTopicCounts.containsKey(id)) {
                userTopicCounts.put(id, userTopicCounts.get(id) + 1);
            } else {
                userTopicCounts.put(id, 1);
            }
        }

        // count topics from users who entered exactly 2 topics
        for (int i = 0; i < ids.size(); i++) {
            String id = ids.get(i);
            String topic = topics.get(i);
            if (userTopicCounts.get(id) == 2) {
                if (waveTwoMap.containsKey(topic)) {
                    waveTwoMap.put(topic, waveTwoMap.get(topic) + 1);
                } else {
                    waveTwoMap.put(topic, 1);
                }
            }
        }
        return waveTwoMap;
    }
}
