package calculator;

class Calc{
  private double operand1;
  private double operand2;
  private char operator;
  private double result;

  public Calc(){
    operand1 = 0;
    operand2 = 0;
    operator = '+';
    result = 0;
  }


  public Calc(double operand1, double operand2, char operator){
    this.operand1 = operand1;
    this.operand2 = operand2;
    this.operator = operator;
    this.result = 0;
  }

  public void setOperand1(double operand1){
    this.operand1 = operand1;
  }

  public void setOperand2(double operand2){
    this.operand2 = operand2;
  }

  public void setOperator(char operator){
    this.operator = operator;
  }

  public double getOperand1(){
    return this.operand1;
  }

  public double getOperand2(){
    return this.operand2;
  }

  public double getOPerator(){
    return this.operator;
  }

  public double add(){
    result = operand1 + operand2;
    return result;
  }

  public double subtract(){
    result = operand1 - operand2;
    return result;
  }

  public double muliply(){
    result = operand1 * operand2;
    return result;
  }

  public double divide(){
    if(operand2 == 0){
      System.out.println("Math Error: Can not divide by 0!");
      result = -1;
    }
    else
      result = operand1 / operand2;
    return result;
  }

  public static void main(String[] args){
    Calc myCalculator = new Calc();
    myCalculator.setOperand1(Double.parseDouble(args[0]));
    myCalculator.setOperator(args[1].charAt(0));
    myCalculator.setOperand2(Double.parseDouble(args[2]));

    double result = myCalculator.add();
    System.out.printf("%.2f + %.2f = %.2f\n", myCalculator.getOperand1(), myCalculator.getOperand2(), result);

    result = myCalculator.subtract();
    System.out.printf("%.2f - %.2f = %.2f\n", myCalculator.getOperand1(), myCalculator.getOperand2(), result);

    result = myCalculator.muliply();
    System.out.printf("%.2f * %.2f = %.2f\n", myCalculator.getOperand1(), myCalculator.getOperand2(), result);

    result = myCalculator.divide();
    System.out.printf("%.2f / %.2f = %.2f\n", myCalculator.getOperand1(), myCalculator.getOperand2(), result);
  }
}
