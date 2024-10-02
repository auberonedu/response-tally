import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
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
        // TODO: Remove the print statements and implement this method
        Map<String, Integer> countTopic = new HashMap<>();
        for (String topic : topics) {
            if (!countTopic.containsKey(topic)){
                countTopic.put(topic, 1);
            } else {
                int currentCount = countTopic.get(topic);
                int newCount = currentCount + 1;
                countTopic.put(topic, newCount);
            }
        }
        return countTopic;
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
      // TODO: Implement this method
        Map<String, Integer> idCount = new HashMap<>();
        for (String id : ids){
            if (!idCount.containsKey(id)){
                idCount.put(id, 1);
            } else {
                int currentCount = idCount.get(id);
                int newCount = currentCount + 1;
                idCount.put(id, newCount);
            }
        }

        Map<String, Integer> filteredCount = new HashMap<>();
        for (int i = 0; i < ids.size(); i++) {
            String id = ids.get(i);
            String topic = topics.get(i);

            if (idCount.get(id) == 2){
                if (!filteredCount.containsKey(topic)){
                filteredCount.put(topic, 1);
                } else {
                    int currentCount = filteredCount.get(topic);
                    int newCount = currentCount + 1;
                    filteredCount.put(topic, newCount);
                }
            }
        }
        return filteredCount;
  }
}
