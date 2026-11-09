class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();

        int n = temperatures.length;
        int[] nextWarmer = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            int currTemp = temperatures[i];

            // Jab tk next temperatures smaller h current temp se , remove them , as they are invalid candidates
            while (!stack.isEmpty() && temperatures[stack.peek()] <= currTemp) stack.pop();

            // if stack is empty , i.e day not found else calculate gap
            nextWarmer[i] = stack.isEmpty() ? 0 : stack.peek() - i;

            // Push current day
            stack.push(i);
        }

        return nextWarmer;
    }
}