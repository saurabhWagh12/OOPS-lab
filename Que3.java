import java.util.*;
public class Que3 {
    // static class Number {
    //     private int[] digits;
        
    //     public Number(int[] digits) {
    //         this.digits = digits;
    //     }
        
    //     public int multiplyByInteger(int multiplier) {
    //         int carry = 0;
            
    //         for (int i = digits.length - 1; i >= 0; i--) {
    //             int product = digits[i] * multiplier + carry;
    //             digits[i] = product % 10;
    //             carry = product / 10;
    //         }
            
    //         return carry; // Returns the whole number part of the result
    //     }
        
    //     public int[] getDigits() {
    //         return digits;
    //     }
    // }

    static class DecimalNumber{
        int[] digits;
        public DecimalNumber(int digit[]){
            digits = digit;
        }

        public int[] result(int n){
            StringBuilder sb = new StringBuilder("");
            for(int i=0;i<digits.length;i++){
                sb.append(digits[i]);
            }
            String s = sb.toString();
            System.out.println(s);
            long number = Long.parseLong(s);
            sb = new StringBuilder("1");

            for(int i=0;i<s.length();i++){
                sb.append('0');
            }

            long num2 = Long.parseLong(sb.toString());
            
            double num = num2;
            System.out.println(num);
            //finding final answer:
            double ans = (number/num)*n;

            System.out.println(ans);

            int result[] = new int[6];
            s = Double.toString(ans);
            
            int count =0,i=2,j=0;
            while(count<6){
                count++;
                result[j] = Character.getNumericValue(s.charAt(i));
                i++;j++;
            }

            return result;
        }


    }

    public static void main(String[] args) {
            int[] digits = {1, 4, 2, 8, 5, 7};
            // Number number = new Number(digits);
            
            // int wholeNumberPart = number.multiplyByInteger(6);
            // int[] updatedDigits = number.getDigits();
            
            // System.out.println("Whole Number Part: " + wholeNumberPart);
            // System.out.println("Updated Digits: " + Arrays.toString(updatedDigits));
            int n;
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter any number for which you want result: ");
            n = sc.nextInt(); 
            DecimalNumber dn = new DecimalNumber(digits);
            int res[] = dn.result(n);
            for(int i=0;i<res.length;i++){
                System.out.print(res[i]+" ");
            }
        }
    
    
    
}
