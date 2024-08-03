import java.util.ArrayList;
import java.util.List;

/**
 * Concepts | Bit Manipulation
 * 
 * Number System -> A system used to describe or represent quantities or metric using mathematical notations or symbols
 * called numbers which can be represented on the number line.
 * 
 * Main number systems - decimal (base 10) (0-9), binary (base 2) (0-1), octal (base 8) (0-7) and hexadecimal (base 16) (0-9, A-F)
 * 
 * Conversion from decimal to binary
 * -> Divide the number by 2
 * -> the remainder becomes the LSB (Least Significant Bit)
 * -> Keep dividing the quotient till it becomes zero. 
 * -> Arrange all remainders in reverse order, (Last to first) 
 * 
 * Example -> 243
 *     Q = 121, 60, 30, 15, 7, 3, 1, 0. R = 1, 1, 0, 0, 1, 1, 1, 1
 *     Base10(234) -> Base2(11110011).          
 * 
 * Conversion from decimal to octal
 * Same process as binary, this time we divide by 8 instead of 2.
 * 
 * Example -> 243
 *   Q = 30, 3, 0. R = 3, 6, 3
 *      Base10(243) -> Base8(363)
 * 
 * Conversion from Decimal to Hexadecimal
 * 
 * Same process, divide by 16.
 * 
 * Example -> 15549
 * 
 * Q = 971, 60, 3, 0
 * R = 13, 11, 12, 3
 * 
 *  3, 12, 11, 13 => 3, C, B, D
 * 
 *  Base10(15549) -> Base16(3CBD)
 * 
 * 
 *  Conversion of Binary to Decimal, Octal to Decimal, HexaDecimal to Decimal
 * 
 *  Traverse through the digits from right to left, multiply each digit with its place value. 
 * 
 *  Base2(11110011) -> 1 x 2^0 + 1 x 2^1 + 0 x 2^2 + 0 x 2^3 + 1 x 2^4 + 1 x 2^5 + 1 x 2^6 + 1 x 2^7 = 1+2+0+0+16+32+64+128=Base10(243)
 *  Base8(363) -> 3 x 8^0 + 6 x 8^1 + 3 x 8^2 = 3 + 48 + 192 = Base10(243)
 *  Base16(3CBD) -> D x 16^0 + B x 16^1 + C x 16^2 + 3 x 16^3 = 13 + 11 x 16 + 12 x 16^2 + 3 x 16^3 = 15549
 * 
 *  Conversion of Binary to Octal
 * 
 *  -> Put numbers into groups of 3 from right to left and compute each group binary to octal digit value. 
 * 
 *  Conversion of Binary to HexaDecimal
 * -> Put numbers into groups of 4 from right to left and compute each group binary to hexa digit value.
 * 
 *  Octal to Binary
 *  -> Traverse digits from right to left and for each number, arrange their 3 bit representation.
 * 
 *  Hexadecimal to Binary
 * -> Traverse digits from right to left and for each number, arrange their 4 bit representation.
 * 
 * Octal to HexaDecimal or HexaDecimal to Octal
 * -> Convert to Binary first and then go to the next step, binary to octal/hexadecimal.
 * 
 * Data Types and Ranges: Java
 * 
 * Boolean -> 1 Byte (8 bits) -> values(true, false)
 * Byte -> 1 byte (2's complement integer) -> -128 to 127
 * Short -> 2 byte -> -32768 to 32767
 * Int -> 4 byte -> -2^31 to 2^31 - 1
 * Long -> 8 byte -> -2^63 to 2^63 - 1
 * Float -> 4 byte -> IEEE 754 floating point standard, single precision (upto 7 decimal points)
 * Double -> 8 byte -> IEEE 754 floating point standard, double precision (upto 16 decimal points)
 * 
 * IEEE 754 Floating point standards
 * Single Precision
 * 1 sign bit, 8 biased exponent bits, 23 mantissa bits
 * Double Precision
 * 1 sign bit, 11 biased exponent bits, 52 mantissa bits
 * 
 * bias value -> 2^7 - 1 sp (127), 2^10 - 1 (1023) dp
 * 
 * Actual Exponent = Stored Exponent - Bias Value
 * 
 * 
 * Conversion of fractional part to binary
 * 
 * -> 243.125
 * 
 * 243 -> Base2(11110011)
 * For fractional part, multiply it by 2 and consider part before decimal for binary value, 
 * keep repeating till you get 1.00 as final val after multiplying
 * 
 * 0.125 x 2 -> 0
 * 0.250 x 2 -> 0
 * 0.500 x 2 -> 1
 * 1.00
 * 
 *  243.125 -> 11110011.001
 * 
 * XOR -> even number of 1s -> 0, odd number of 1s -> 1
 * 
 */ 

public class Main {
    public static void main(String[] args) {
        System.out.println(decimalToBinary(243));

        int a = 5;
        int b = 7;

        // swapping without using third variable.
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        // ith bit is set or unset
        // left shift
        // (n & (1 << k)) != 0 
        // right shift
        // ((n >> k) & 1) != 0

        // getting the ith bit. 
        int num = 70;
        int i = 3;
       --i;
       if ((num & (1 << i)) != 0) System.out.print("1 ");
       else System.out.print("0 ");
                   
       // setting the ith bit
       num = (num | (1 << i));
       System.out.print(num + " ");

       // clearing the ith bit
       num = (num & (~(1 << i)));
       System.out.print(num + " ");

        // toggle the ith bit
        num = (num ^ (1 << i));
        System.out.print(num + " ");

        // Remove Rightmost set bit
        // Example ->  16 -> 10000
        // 16 - 1 -> 15 -> 01111
        num = (num & (num - 1));

        // Power of two
        // Number is power of two, it will always have only 1 set bit.
        // n & n -1 basically turns off the rightmost set bit. If a number
        // is a power of two, it is guaranteed to have only 1 set bit and removing that 
        // will result in number turning into 0. 
        // if ((num & (num-1)) == 0)

        // All bits are set
        // ((n + 1) & n) == 0 

        // Count the number of set bits
        /**
         * count = 0;
         * while(n > 0) {
         *   if (n % 2 == 1) count++;   
         *   n = n / 2;
         * }
         * 
         * count = 0;
         * while(n > 0) {
         *  count += n & 1;
         *  n = n >> 1
         * }
         * 
         * Fact -> LSB of odd numbers will always be 1.
         * 
         * Another approach, keep turning off number rightmost set bit and increase counter
         * 
         * count = 0;
         * while (n != 0) {
         *   count++;
         *   n = (n & (n-1)) 
         * }
         */


         // Minimum number of bits to flip to convert one number to another number
         // example -> 1010, 111
         // 1010
         // 0111
         // xor
         // 1101 -> count set bits here
        
    }

    private static String decimalToBinary(int n) {

        StringBuilder sb = new StringBuilder();
        
        while(n > 0) {
            int r = n % 2;
            n = n / 2;
            sb.append(r);
        }

        return sb.reverse().toString();
    }

    public List<List<Integer>> subsets(int[] nums) {

        // Total Subsets will be 2^n
        int totalSubsets = 1 << nums.length;

        List<List<Integer>> powerSet = new ArrayList<>();
        
        // Making subsets using combination of set bits from 0 to 2^n - 1
        for (int i = 0; i < totalSubsets; i++) {

            // Computing ith subset
            List<Integer> set = new ArrayList<>();

            // There will be n bits in the range. 
            // Checking which bits are set.
            // Using nums[setBitIdx] in the combination.
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) != 0) {
                    set.add(nums[j]);
                }
            }
            powerSet.add(set);
        }

        return powerSet;
    }
}