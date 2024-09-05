import java.util.*;

public class RegionFinder {
    public static String findSmallestRegion(List<List<String>> regions, String r1, String r2) {
        // Create a parent mapping for each region
        Map<String, String> parentMap = new HashMap<>();
        for (List<String> regionList : regions) {
            for (int i = 1; i < regionList.size(); i++) {
                parentMap.put(regionList.get(i), regionList.get(0));
            }
        }

        // Trace the path from region1 to the root
        Set<String> path1 = new HashSet<>();
        while (parentMap.containsKey(r1)) {
            path1.add(r1);
            r1 = parentMap.get(r1);
        }
        // Include the root
        path1.add(r1);

        // Trace the path from region2 to the root and find the common ancestor
        while (parentMap.containsKey(r2)) {
            if (path1.contains(r2)) {
                return r2;
            }
            r2 = parentMap.get(r2);
        }
        return r2;
    }

    public static void main(String[] args) {
        List<List<String>> regions = Arrays.asList(
            Arrays.asList("Earth", "North America", "South America"),
            Arrays.asList("North America", "United States", "Canada"),
            Arrays.asList("United States", "New York", "Boston"),
            Arrays.asList("Canada", "Ontario", "Quebec")
        );
        String r1 = "Quebec";
        String r2 = "New York";

        System.out.println(findSmallestRegion(regions, r1, r2));
    }
}