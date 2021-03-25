package converter;
import java.util.Locale;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in).useLocale(Locale.US);


            int radix1 = Integer.parseInt(sc.nextLine());
            String n = sc.nextLine();
            int radix2 = Integer.parseInt(sc.nextLine());

            if (radix1 >= 1 && radix1 <= 36 && radix2 >= 1 && radix2 <= 36) {
                if (radix1 == 1) {
                    System.out.println(converter(1, radix2, Integer.parseInt(n)));

                } else if (radix1 != 10) {
                    //convert radix1 to base 10
                    converterNot10(radix1, n, radix2);
                } else {
                    //converting String n to double n
                    converterIs10(n, radix2);
                }
            } else {
                throw new Exception();
            }


        } catch (Exception nfe) {
            System.out.println("error");
        }

    }


    public static int intOfDouble(double m) {
        String intOfDouble = String.valueOf(m);
        int indexOfDecimal = intOfDouble.indexOf(".");

        String a = intOfDouble.substring(0, indexOfDecimal);
        return Integer.parseInt(a);
    }


    public static double decimals(double m) {
        return m - intOfDouble(m);
    }


    public static String converter(int radix1, int radix2, int m) {
        int i = 0;
        if (radix1 == 1) {
            int b = Integer.toString(m).length();
            return Integer.toString(b, radix2);

        } else if (radix2 == 1) {
            while (i < m) {
                i++;
                System.out.print(1);
                if (i > m) {
                    break;
                }
            }
        } else {
            int a = Integer.parseInt(String.valueOf(m), radix1);
            return Integer.toString(a, radix2);
        }
        return "";
    }


    public static void converterNot10(int radix1, String n, int radix2) {

        String integers = String.valueOf(n);
        String decimals;
        String integers2;
        String final1;
        double finalDec = 0;
        int a = integers.indexOf(".");
        if (n.contains(".")) {
            integers2 = integers.substring(0, a);
            decimals = integers.substring(a + 1);

            //integer part converter from radix1 to radix2


            int abc = Integer.parseInt(integers2, radix1);
            final1 = converter(10, radix2, abc);


            //finds the decimalValue from the formula used to calculate decimals
            int i;
            for (i = 0; i < decimals.length(); i++) {
                int dec = Character.getNumericValue(decimals.charAt(i));
                finalDec = finalDec + (dec / Math.pow(radix1, i + 1));
            }

            double y = finalDec * radix2;
            int yy = intOfDouble(y);
            char yyy1 = Character.forDigit(yy, radix2);

            double y2 = decimals(y) * radix2;
            int yy2 = intOfDouble(y2);
            char yyy2 = Character.forDigit(yy2, radix2);

            double y3 = decimals(y2) * radix2;
            int yy3 = intOfDouble(y3);
            char yyy3 = Character.forDigit(yy3, radix2);

            double y4 = decimals(y3) * radix2;
            int yy4 = intOfDouble(y4);
            char yyy4 = Character.forDigit(yy4, radix2);

            double y5 = decimals(y4) * radix2;
            int yy5 = intOfDouble(y5);
            char yyy5 = Character.forDigit(yy5, radix2);


            System.out.print(final1);
            if (integers.contains(".")) {
                System.out.println("." + yyy1 + yyy2 + yyy3 + yyy4 + yyy5);
            }

        } else {
            int abc = Integer.parseInt(integers, radix1);
            final1 = converter(10, radix2, abc);

            System.out.println(final1);
        }
    }


    public static void converterIs10(String n, int radix2) {
        //converting String n to double n
        double m = Double.parseDouble(n);


        double j = (float) decimals(m) * radix2;
        char jc = Character.forDigit(intOfDouble(j), radix2);


        double j2 = (float) decimals(j) * radix2;
        char jc2 = Character.forDigit(intOfDouble(j2), radix2);


        double j3 = (float) decimals(j2) * radix2;
        char jc3 = Character.forDigit(intOfDouble(j3), radix2);


        double j4 = (float) decimals(j3) * radix2;
        char jc4 = Character.forDigit(intOfDouble(j4), radix2);


        double j5 = (float) decimals(j4) * radix2;
        char jc5 = Character.forDigit(intOfDouble(j5), radix2);


        System.out.print(converter(10, radix2, intOfDouble(m)));
        if (n.contains(".")) {
            System.out.println("." + jc + jc2 + jc3 + jc4 + jc5);
        }
    }
}