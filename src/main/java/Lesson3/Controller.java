package Lesson3;

import Lesson3.Flow.Flow;
import Lesson3.Flow.FlowService;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Controller {
        public static void init(){
            StudyGroup group1 = new StudyGroup("group1");
            StudyGroup group2 = new StudyGroup("group2");
            StudyGroup group3 = new StudyGroup("group3");
            StudyGroup group4 = new StudyGroup("group4");
            StudyGroup group5 = new StudyGroup("group5");
            StudyGroup group6 = new StudyGroup("group6");
            StudyGroup group7 = new StudyGroup("group7");
            StudyGroup group8 = new StudyGroup("group8");


            Flow flow1 = new Flow("flow1");
            Flow flow2 = new Flow("flow2");
            Flow flow3 = new Flow("flow3");

            flow1.addGroup(group1);
            flow1.addGroup(group2);
            flow1.addGroup(group3);

            flow2.addGroup(group4);
            flow2.addGroup(group5);

            flow3.addGroup(group6);
            flow3.addGroup(group7);
            flow3.addGroup(group8);

            ArrayList<Flow> flowArrayList = new ArrayList<>();
            flowArrayList.add(flow1);
            flowArrayList.add(flow2);
            flowArrayList.add(flow3);

            System.out.println(flowArrayList);
            FlowService.sortedStreams(flowArrayList);
            System.out.println(flowArrayList);
        }

}
