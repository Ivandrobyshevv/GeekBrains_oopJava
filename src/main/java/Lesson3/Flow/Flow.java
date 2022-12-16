package Lesson3.Flow;

import Lesson3.StudyGroup;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Flow implements Iterable<StudyGroup>{

    protected String name;
    protected List<StudyGroup> studyGroups = new ArrayList<>();

    protected int index = 0;

    public Flow(String name) {
        this.name = name;
    }

    public void addGroup(StudyGroup group) {
        this.studyGroups.add(group);
    }

    @Override
    public Iterator<StudyGroup> iterator() {
        Iterator<StudyGroup> iter = new Iterator<StudyGroup>() {
            @Override
            public boolean hasNext() {
                return index < studyGroups.size();
            }

            @Override
            public StudyGroup next() {
                if (this.hasNext()) {
                    return studyGroups.get(index++);
                }
                return null;
            }
        };
        return iter;
    }

    public int getSize() {
        return this.studyGroups.size();
    }

    @Override
    public String toString() {
        return String.format("Поток: %s - %d кол-во", this.name, this.getSize());
    }
}
