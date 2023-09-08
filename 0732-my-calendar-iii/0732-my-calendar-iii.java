class MyCalendarThree {
    private int max;
    private TreeMap<Integer, Integer> events;

    public MyCalendarThree() {
        events = new TreeMap<>();
        max = 0;
    }
    
    public int book(int start, int end) {
        events.put(start, events.getOrDefault(start, 0) + 1);
        events.put(end, events.getOrDefault(end, 0) - 1);
        
        int active = 0;
        
        for (int count : events.values()) {
            active += count;
            max = Math.max(max, active);
        }
        
        return max;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */

