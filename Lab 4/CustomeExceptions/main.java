public class main {
    public static void main(String[] args) {
        Calc c = new Calc();
        try{
            c.divide(5,5);
            c.add(5, '-', 9);
            c.parseInput(" ");
        }catch(InvalidInputException err){
            System.out.println(err.getMessage());
        }catch(InvalidOperatorException err){
            System.out.println(err.getMessage());
        }catch(ArithmeticException err){
            System.out.println(err.getMessage());
        }finally{
            System.out.println("Final Statement!");
        }
    }
}
