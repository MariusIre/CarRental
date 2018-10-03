package ro.jademy.carrental.cars.specs;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public enum Make {
    DACIA("Dacia"),
    OPEL("Opel"),
    BMW("BMW"),
    AUDI("Audi"),
    MERCEDES("Mercedes");

    private String name;

    Make(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static List<Make> getSorteddList() {
        List<Make> list = Arrays.asList(values());
        Collections.sort(list, new MyMakeComparator());

        return list;
    }

    static class MyMakeComparator implements Comparator<Make> {
        public int compare(Make o1, Make o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }
}
