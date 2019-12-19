package complex;

class Complex{
  private int real;
  private int imag;

  public Complex(){
    real = 0;
    imag = 0;
  }

  public Complex(int n){
    this.real = this.imag = n;
  }

  public Complex(int real, int imag){
    this.real = real;
    this.imag = imag;
  }

  public void setReal(int real){
    this.real = real;
  }

  public void setImag(int imag){
    this.imag = imag;
  }

  public int getReal(){
    return real;
  }

  public int getImag(){
    return imag;
  }

  public Complex addComplex(Complex comp){
    Complex result = new Complex();
    result.real = this.real + comp.real;
    result.imag = this.imag + comp.imag;
    return result;
  }


  public Complex subtractComplex(Complex comp){
    Complex result = new Complex();
    result.real = this.real - comp.real;
    result.imag = this.imag - comp.imag;
    return result;
  }


  public void print(){
    if(imag < 0)
        System.out.println(real+"-"+imag+"i");
    else if(imag > 0)
      System.out.println(real+"+"+imag+"i");
    else
      System.out.println(real);

  }


  public static void main(String[] args){
    Complex cmplx1 = new Complex(2,4);
    Complex cmplx2 = new Complex(1,3);

    Complex sumComp = cmplx1.addComplex(cmplx2);
    sumComp.print();

    Complex subComp = cmplx1.subtractComplex(cmplx2);
    subComp.print();
  }
}
