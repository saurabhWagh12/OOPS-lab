public class Que2 {
    
    public static int findSmallestMultiplications(int base, int exponent) {
        if (exponent == 0) {
            return 0; // base case: anything raised to the power of 0 is 1, so no multiplications needed
        }
        
        if (exponent % 2 == 0) {
            int halfExponent = exponent / 2;
            int halfResult = findSmallestMultiplications(base, halfExponent);
            return halfResult + 1; // one multiplication for squaring
        } else {
            int halfExponent = (exponent - 1) / 2;
            int halfResult = findSmallestMultiplications(base, halfExponent);
            return halfResult + 2; // two multiplications for squaring and multiplying by base
        }
    }

    public static void main(String[] args) {
        int base = 2;
        int exponent = 30;
        int minMultiplications = findSmallestMultiplications(base, exponent);
        
        System.out.println("Minimum number of multiplications: " + minMultiplications);
    }
}
