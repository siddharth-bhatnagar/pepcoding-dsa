// Leetcode 853
// O(nlogn), O(n)

class Solution {
    public static class Cars implements Comparable<Cars> {
        int pos;
        double time;

        public Cars(int pos, double time) {
            this.pos = pos;
            this.time = time;
        }

        @Override
        public int compareTo(Cars object) {
            return this.pos - object.pos;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 0)
            return 0;
        Cars[] cars = new Cars[n];
        for (int i = 0; i < n; i++) {
            double time = (target - (double) position[i]) / (double) speed[i];
            cars[i] = new Cars(position[i], time);
        }
        Arrays.sort(cars);
        int fleet = 0;
        double fleetTime = 0;
        for (int i = n - 1; i >= 0; i--) {
            Cars car = cars[i];
            if (car.time > fleetTime) {
                fleet++;
                fleetTime = car.time;
            }
        }

        return fleet;
    }
}