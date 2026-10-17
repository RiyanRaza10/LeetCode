class Solution {
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int m = students.length, n = students[0].length;

        // Pre computing scores
        int[][] scores = new int[m][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                scores[i][j] = calcCompatibility(students, mentors, n, i, j);
            }
        }

        boolean[] usedStudent = new boolean[m];
        boolean[] usedMentor = new boolean[m];

        int[] maxScore = new int[1];

        solve(students, mentors, scores, usedStudent, usedMentor, maxScore, m, n, 0, 0);

        return maxScore[0];
    }

    void solve(int[][] students, int[][] mentors, int[][] scores, boolean[] usedStudent, boolean[] usedMentor, int[] maxScore, int m, int n, int totalScore, int j) {

        // All mapped to each other
        if (j == m) {
            maxScore[0] = Math.max(maxScore[0], totalScore);

            return;
        }

        for (int i = 0; i < m; i++) {

            if (!usedStudent[i] && !usedMentor[j]) {

                // Pick i-th student for j-th mentor
                usedStudent[i] = true;
                usedMentor[j] = true;
                totalScore += scores[i][j];

                // Recursive call
                solve(students, mentors, scores, usedStudent, usedMentor, maxScore, m, n, totalScore, j+1);

                // Not pick / Backtrack
                usedStudent[i] = false;
                usedMentor[j] = false;
                totalScore -= scores[i][j];
            }
        }
    }

    int calcCompatibility(int[][] students, int[][] mentors, int n, int studentRow, int mentorRow) {
        int compatibility = 0;

        for (int i = 0; i < n; i++) {
            if (students[studentRow][i] == mentors[mentorRow][i])
                compatibility++;
        }

        return compatibility;
    }
}