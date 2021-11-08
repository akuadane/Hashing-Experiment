package helper_classes;

public class TwinPrimeGenerator {
    static public int[] smallestTwinPrimes(int start,int end){

        for(int i=start;i<=end;i++){
                if(isPrime(i) && isPrime(i+2) && i+2<=end){
                    return new int[]{i,i+2};
                }
        }
        return null;
    }
    static private boolean isPrime(int num){
        int factors=0;
        for(int i=1;i<=num;i++){
            if(num%i==0)
                factors++;

            if(factors>2)
                return false;
        }
        if(num==1)
            return false;
        return true;

    }
}
