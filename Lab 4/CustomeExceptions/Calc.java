public class Calc {    
    public int divide(int a, int b) throws ArithmeticException {
        int x;
        if(a==0 || b==0){
            throw new ArithmeticException("Cant divide by Zero!");
        }else{
            x = a/b;
            return x;
        }
    }
    public int add(int a, char c, int b) throws InvalidOperatorException{
        int x;
        if(c == '+'){
            x=a+b;
            return x;
        }else{
            throw new InvalidOperatorException("invalid operator!");
        }
    }

    public double parseInput(String input) throws InvalidInputException {
        if(input == null||input==" "){
            throw new InvalidInputException("Null Value found!");
        }
        return Double.parseDouble(input);
    }
   
}