class Solution {
    public int largestAltitude(int[] gain) {
        int currentAltitude = 0;
        int highestAltitude = 0;
        int[] altitudes = new int[gain.length];

        for(int i = 0; i<gain.length;i++){
            
            currentAltitude = currentAltitude + gain[i];
            altitudes[i]=currentAltitude;          
        }

        for(int j = 0; j<altitudes.length;j++){
            highestAltitude = Math.max(highestAltitude, altitudes[j]);
        }

        return highestAltitude;
    }
}