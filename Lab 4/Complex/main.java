package Complex;

public class main {
    public static void main(String[] args) {
        Complex<Integer> c1 = new Complex<Integer>(9, 3);
        Complex<Integer> c2 = new Complex<Integer>(3, 5);
        Complex<Double> addComplex = c1.add(c2);
        System.out.println("Sum is: " + addComplex);

        Complex<Double> subComplex = c1.subtract(c2);
        System.out.println("Diff is: " + subComplex);


        Complex<Double> c3 = new Complex<Double>(5.0, 8.8);
        Complex<Double> c4 = new Complex<Double>(1.5, 1.4);

        Complex<Double> addComplex2 = c3.add(c4);
        System.out.println("Sum is: " + addComplex2);

        Complex<Double> subComplex2 = c3.subtract(c4);
        System.out.println("Diff is: " + subComplex2);
    }
}
