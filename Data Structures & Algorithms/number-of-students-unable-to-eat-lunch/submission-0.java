class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int n = students.length;
        int result = n;

        int[] studentCount = new int[2];
        for(int student : students) {
            studentCount[student]++;
        }

        for(int sandwhich : sandwiches) {
            if(studentCount[sandwhich] > 0) {
                studentCount[sandwhich]--;
                result--;
            } else {
                return result;
            }
        }

        return 0;

    }
}