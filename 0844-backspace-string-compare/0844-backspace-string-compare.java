class Solution {
    public boolean backspaceCompare(String s, String t) {
        int rightS = s.length()-1;
        int rightT = t.length()-1;

        int skipS = 0;
        int skipT = 0;

        while(rightS >= 0 || rightT >= 0){
            // for s
            while(rightS >=0){
                if(s.charAt(rightS) == '#'){
                    skipS++;
                    rightS--;
                } else if(skipS > 0){
                    skipS--;
                    rightS--;
                } else {
                    break;
                }
            }

            //for t
            while(rightT >= 0){
                if(t.charAt(rightT) == '#'){
                    skipT++;
                    rightT--;
                } else if(skipT >0){
                    skipT--;
                    rightT--;
                } else {
                    break;
                }
            }

             if(rightS >= 0 && rightT >= 0){
                if(s.charAt(rightS) != t.charAt(rightT)){
                    return false;
                }
                rightS--;
                rightT--;
             } else if(rightS >= 0 || rightT >= 0){
                return false;
             }
        }
        return true;
    }
}