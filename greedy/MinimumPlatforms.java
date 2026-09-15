class Solution {
    public int minPlatform(int arr[], int dep[]) {
        //  code here
        int n = arr.length;

        List<Integer> arrivals = new ArrayList<>();
        List<Integer> departures = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arrivals.add(arr[i]);
            departures.add(dep[i]);
        }

        Collections.sort(arrivals);
        Collections.sort(departures);

        int si = 0;
        int ei = 0;

        int plat = 0;
        int ans = 0;

        while (si < n && ei < n) {
            if (arrivals.get(si) <= departures.get(ei)) {
                plat++;
                ans = Math.max(ans, plat);
                si++;
            } else {
                plat--;
                ei++;
            }
        }

        return ans;
    }
}
