public class FractionAddition {

    // ------------------------------------------- Time Complexity: O(log (den1+den2) ) (Not sure)-------------------------------
                                                                    Time taken to find HCF
    // ------------------------------------------- Space Complexity : O(1) ------------------------------------------------------

    public static void main(String[] args){
        int[] a = {1,3};
        int[] b = {3,9};

        addFractions(a,b);
    }

    public static int[] addFractions(int[] a, int[] b){
        int num1 = a[0];
        int den1 = a[1];
        int num2 = b[0];
        int den2 = b[1];

        int highest_fac = hcf(den1,den2);

        int lcm = (den1*den2)/highest_fac; // hcf * lcm = den1* den2

        int num3 = num1*(lcm/den1) + num2 *(lcm/den2);

        // ans = num3 / lcm
        return reduce(num3,lcm);
    }


    public static int hcf(int den1, int den2){
    
        if(den1==0){
            return den2;
        }
        return hcf(den2%den1 , den1);
    }

    public static int[] reduce (int num, int den){
        int[] result = new int[2];

        int highest_fac = hcf(num,den);
        num = num/highest_fac;
        den = den/highest_fac;

        result[0] = num;
        result[1] = den;

        System.out.println("num: "+num +" den :"+den);
        return result;
    }
}
