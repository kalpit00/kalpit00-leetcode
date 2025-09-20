// Last updated: 9/19/2025, 8:12:41 PM
class Router {
    Map<List<Integer>, Integer> mpp = new HashMap<>(); // to track duplicates
    Queue<List<Integer>> queue = new LinkedList<>(); // to store packets in FIFO order
    Map<Integer, List<Integer>> timestamps = new HashMap<>(); // for timestamps tracking
    Map<Integer, Integer> st = new HashMap<>();
    int maxSize = 0; // maxSize allowed

    public Router(int memoryLimit) { 
        maxSize = memoryLimit; 
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        List<Integer> packet = Arrays.asList(source, destination, timestamp);
        // checking for duplicate
        if (mpp.containsKey(packet))
            return false;
        if (queue.size() == maxSize) { // remove the first element if queue is full
            List<Integer> res = queue.poll();
            mpp.remove(res);
            int temp = res.get(1);
            st.put(temp, st.getOrDefault(temp, 0) + 1);
        }
        queue.offer(packet);
        mpp.put(packet, 1);
        timestamps.computeIfAbsent(destination, k -> new ArrayList<>()).add(timestamp);
        return true;
    }

    public int[] forwardPacket() {
        if(queue.isEmpty()) return new int[0];
        List<Integer> res = queue.poll();
        mpp.remove(res);
        int temp = res.get(1);
        st.put(temp, st.getOrDefault(temp, 0) + 1);
        return new int[]{res.get(0), res.get(1), res.get(2)};
    }

    public int getCount(int destination, int startTime, int endTime) {
        if(!timestamps.containsKey(destination))
            return 0;
        List<Integer> p = timestamps.get(destination);
        int temp = st.getOrDefault(destination, 0);
        int right = lowerBound(p, startTime, temp);
        int left = upperBound(p, endTime, temp);
        return left - right;
    }

    private int lowerBound(List<Integer> p, int target, int start) {
        int l = start, r = p.size();
        while(l < r) {
            int mid = (l + r) / 2;
            if(p.get(mid) < target) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    private int upperBound(List<Integer> p, int target, int start) {
        int l = start, r = p.size();
        while(l < r) {
            int mid = (l + r) / 2;
            if(p.get(mid) <= target) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}