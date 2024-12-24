package Complex;

public class Complex <T extends Number>{
    public T real;
    public T img;

    public Complex(T real, T img) {
        this.real = real;
        this.img = img;
    }

    public Complex<Double> add(Complex<T> c){
        double realResult = this.real.doubleValue() + c.real.doubleValue();
        double imgResult = this.img.doubleValue() + c.img.doubleValue();
        return new Complex<Double>(realResult,imgResult);
    }

    public Complex<Double> subtract(Complex<T> c){
        double realResult = this.real.doubleValue() - c.real.doubleValue();
        double imgResult = this.img.doubleValue() - c.img.doubleValue();
        return new Complex<Double>(realResult,imgResult);
    }

    public String toString() {
        return real + " + " + img + "i";
    }
}
