package HashMap;

public class JaroRabin {
    
    private static final int PRIME =101;

    private long calculateHash(String str){
        long hash =0;
        for (int i = 0; i < str.length(); i++) {
            // hash = hash + str.charAt(i) * Math.pow(PRIME, i);

            
        }


        return hash ;
    }
    private long updateHash(long prevHash , char oldChar , char newChar , int patternLength ){
        long  newHash = (prevHash -oldChar) /PRIME;
        // newHash = newHash +newChar *Math.pow(PRIME, patternLength-1);

        return newHash;

    }

    // public void Search(String )

}
