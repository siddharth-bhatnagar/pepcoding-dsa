// Leetcode 815

class Solution {
    public class Pair {
        int busstopno;
        int buscount;

        public Pair(int x, int y) {
            busstopno = x;
            buscount = y;
        }
    }

    public int numBusesToDestination(int[][] routes, int source, int target) {
        int n = routes.length;
        HashMap<Integer, ArrayList<Integer>> stopmap = new HashMap<>();

        for (int i = 0; i < n; i++) { // bus number i
            for (int j = 0; j < routes[i].length; j++) { // routes[i][j] = bus stop
                int busstop = routes[i][j];
                ArrayList<Integer> busno = stopmap.getOrDefault(busstop, new ArrayList<>());
                busno.add(i);
                stopmap.put(busstop, busno);
            }
        }

        LinkedList<Pair> queue = new LinkedList<>();
        HashSet<Integer> stopvis = new HashSet<>();
        HashSet<Integer> busnovis = new HashSet<>();

        queue.addLast(new Pair(source, 0));
        stopvis.add(source);

        while (queue.size() > 0) {
            Pair rem = queue.removeFirst();
            if (rem.busstopno == target)
                return rem.buscount;
            ArrayList<Integer> buses = stopmap.get(rem.busstopno);
            for (int bus : buses) {
                if (busnovis.contains(bus))
                    continue;

                int[] arr = routes[bus];
                for (int stop : arr) {
                    if (stopvis.contains(stop))
                        continue;

                    queue.addLast(new Pair(stop, rem.buscount + 1));
                    stopvis.add(stop);
                }
                busnovis.add(bus);
            }
        }

        return -1;
    }
}