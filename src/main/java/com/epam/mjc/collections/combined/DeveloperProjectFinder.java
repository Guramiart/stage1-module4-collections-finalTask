package com.epam.mjc.collections.combined;

import java.util.*;

public class DeveloperProjectFinder {
    public List<String> findDeveloperProject(Map<String, Set<String>> projects, String developer) {
        List<String> projectList = new ArrayList<>();
        for(Map.Entry<String, Set<String>> entry : projects.entrySet()) {
            String key = entry.getKey();
            if(entry.getValue().contains(developer)) {
                projectList.add(key);
            }
        }
        projectList.sort(comparator);
        return projectList;
    }

    private final Comparator<String> comparator = new Comparator<>() {
        @Override
        public int compare(String o1, String o2) {
            int o1length = o1.length();
            int o2length = o2.length();
            int result;
            if(o1length == o2length) {
                result = o2.compareTo(o1);
            } else {
                result = o2.length() - o1.length();
            }
            return result;
        }
    };
}
