// Leetcode 815

class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        // Get the arrayList at the current bus stop, if it doesn't exist, init new AL
        // i reps bus number
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                int bs = routes[i][j];
                ArrayList<Integer> buses = map.getOrDefault(bs, new ArrayList<Integer>());
                buses.add(i);
                map.put(bs, buses);
            }
        }

        // Make a queue for standard bfs processing
        LinkedList<Helper> queue = new LinkedList<>();
        queue.addLast(new Helper(source, 0));

        // Visited Sets
        HashSet<Integer> busesTaken = new HashSet<>();
        HashSet<Integer> stopsVis = new HashSet<>();
        stopsVis.add(source);

        while (queue.size() > 0) {
            Helper rem = queue.removeFirst();
            if (rem.busStop == target)
                return rem.busCount;

            for (int bus : map.get(rem.busStop)) {

                if (!busesTaken.contains(bus)) {

                    busesTaken.add(bus);

                    for (int i = 0; i < routes[bus].length; i++) {

                        int stop = routes[bus][i];

                        if (!stopsVis.contains(stop)) {
                            stopsVis.add(stop);
                            queue.addLast(new Helper(stop, rem.busCount + 1));
                        }

                    }

                }
            }

        }

        return -1;
    }

    public class Helper {
        int busStop;
        int busCount;

        public Helper(int busStop, int busCount) {
            this.busStop = busStop;
            this.busCount = busCount;
        }
    }
}

// Idea is to apply BFS
// To minimise look up times, we will store bus stop number -> bus number
// mappings in hashmap
// Complexity: O(V+E), V -> Vertex, E -> Edge