package Lesson3.Flow;

import java.util.ArrayList;

public class FlowService {
    public static void sortedStreams(ArrayList<Flow> streams) {
        StreamComparatorFlow comparator = new StreamComparatorFlow();
        streams.sort(comparator);
    }
}
