

public class Complex {

    private double re, im;

    public Complex (double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return this.re;
    }

    public double getIm() {
        return this.im;
    }

    public double getAbs2() {
        return Math.pow(re, 2) + Math.pow(im, 2);
    }

    public void add(Complex c) {
        this.re += c.getRe();
        this.im += c.getIm();
    }

    public void mul(Complex c) {

        double real = ((this.re * c.getRe()) - (this.im * c.getIm()));
        this.im = (this.im * c.getRe()) + (this.re * c.getIm());
        this.re = real;
    }

}
