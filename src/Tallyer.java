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
        System.out.println("test");

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
        Map<String, Integer> topicsCountMap = new HashMap<>();

        for (String topic : topics) {
           if(!topicsCountMap.containsKey(topic)){
                topicsCountMap.put(topic, 1);
           } else {
                topicsCountMap.put(topic, topicsCountMap.get(topic) + 1);
           }
        }

        return topicsCountMap;
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

        // list for valid topics
        List<String> validTopics = new ArrayList<>();
        // map of topic count
        Map<String, Integer> topicsCountMap = new HashMap<>();

        // count ids
        Map<String, Integer> idsCountMap = new HashMap<>();
        for (String id : ids){
            if(!idsCountMap.containsKey(id)){
                idsCountMap.put(id, 1);
            }
            else {
                idsCountMap.put(id, idsCountMap.get(id) + 1);
            }
        }

        // create list of valid topics
        for (int i = 0; i < ids.size(); i++) {
            if(idsCountMap.get(ids.get(i)) == 2){
                validTopics.add(topics.get(i));
            }
        }

        // count topics

        for (String topic : validTopics) {
           if(!topicsCountMap.containsKey(topic)){
                topicsCountMap.put(topic, 1);
           }
           else {
                topicsCountMap.put(topic, topicsCountMap.get(topic) + 1);
           }
        

        
        }
        return topicsCountMap; 
  }
}
