package java8.base.collect.stream;

public class FormulaServce {
    public static void main(String[] args) {
        Formula formula = new Formula(){
            @Override
            public double calculate(int a) {
                return a+1;
            }
        };
        System.out.println(formula.calculate(4));
        System.out.println(formula.sqrt(4));
        int add = Formula.add(4, 5);
        System.out.println(add);
    }
}
