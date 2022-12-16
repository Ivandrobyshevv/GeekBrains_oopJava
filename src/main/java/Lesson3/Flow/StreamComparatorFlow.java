package Lesson3.Flow;


import java.util.Comparator;

public class StreamComparatorFlow implements Comparator<Flow> {

    @Override
    public int compare(Flow flow1, Flow flow2) {
        return Integer.compare(flow1.getSize(), flow2.getSize());
    }
}