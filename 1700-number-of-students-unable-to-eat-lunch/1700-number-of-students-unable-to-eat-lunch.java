class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] count = {0, 0};
        
        for(int student : students){
            count[student]++;
        }
        int i = 0;
        int studentsInLine = students.length;
        
        while(i<sandwiches.length){
            if(count[sandwiches[i]]>0){
                count[sandwiches[i]]--;
                studentsInLine--;
                i++;
            }else
                break;
        }
        return studentsInLine;
    }
}