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

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        List<String> ids = new ArrayList<>();
        List<String> topics = new ArrayList<>();
        
        // Reading input for IDs and topics
        while (input.hasNext()) {
            ids.add(input.next());      // add ID
            topics.add(input.next());   // add topic
        }
        input.close();
        
        // Wave 1: Tally the topics without filtering
        Map<String, Integer> topicCounts = tallyTopics(topics);
        System.out.println("Here are how many times each topic appears (unfiltered):");
        System.out.println(topicCounts);

        // Wave 2: Tally the topics with filtering (only users with exactly 2 topics)
        Map<String, Integer> topicCountsFiltered = tallyTopicsFiltered(ids, topics);
        System.out.println("Here are how many times each topic appears (filtered):");
        System.out.println(topicCountsFiltered);
    }

    /**
     * Wave 1: Tally the occurrences of each topic from the provided list of topics.
     *
     * @param topics a list of strings representing the topics to be tallied
     * @return a map containing topics as keys and their occurrence counts as values
     */
    public static Map<String, Integer> tallyTopics(List<String> topics) {
        Map<String, Integer> topicCountMap = new HashMap<>();

        // Loop through each topic and count occurrences
        for (String topic : topics) {
            topicCountMap.put(topic, topicCountMap.getOrDefault(topic, 0) + 1);
        }

        return topicCountMap;
    }

    /**
     * Wave 2: Tally the occurrences of each topic, but only count users who provided exactly 2 topics.
     *
     * @param ids a list of strings representing IDs associated with each topic
     * @param topics a list of strings representing the topics to be tallied
     * @return a map containing topics as keys and their occurrence counts as values, filtered by valid users
     */
    public static Map<String, Integer> tallyTopicsFiltered(List<String> ids, List<String> topics) {
        Map<String, Integer> topicCountMap = new HashMap<>();
        Map<String, Integer> studentTopicCount = new HashMap<>();

        // Count how many topics each student has entered
        for (String id : ids) {
            studentTopicCount.put(id, studentTopicCount.getOrDefault(id, 0) + 1);
        }

        // Tally only the topics from students who entered exactly 2 topics
        for (int i = 0; i < ids.size(); i++) {
            String studentId = ids.get(i);
            if (studentTopicCount.get(studentId) == 2) {
                String topic = topics.get(i);
                topicCountMap.put(topic, topicCountMap.getOrDefault(topic, 0) + 1);
            }
        }

        return topicCountMap;
    }
}
