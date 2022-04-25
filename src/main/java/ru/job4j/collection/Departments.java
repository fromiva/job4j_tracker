package ru.job4j.collection;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.LinkedHashSet;
import static java.util.Collections.sort;

public class Departments {
    public static List<String> fillGaps(List<String> deps) {
        Set<String> result = new LinkedHashSet<>();
        for (String dep : deps) {
            String string = "";
            for (String element : dep.split("/")) {
                string = "".equals(string) ? element : string + "/" + element;
                result.add(string);
            }
        }
        return new ArrayList<>(result);
    }

    public static void sortAsc(List<String> orgs) {
        sort(orgs);
    }

    public static void sortDesc(List<String> orgs) {
        sort(orgs, new DepDescComp());
    }
}
