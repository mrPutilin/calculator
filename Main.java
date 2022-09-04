package core.hw1.calc;

import java.util.function.*;

public class Main {
    public static void main(String[] args) {


        Calculator calc = Calculator.instance.get();
        int a = calc.plus.apply(1, 2);
        int b = calc.minus.apply(1, 1);
        int c = calc.divide.apply(a, b);
        int g = calc.abs.apply(-5);
        calc.println.accept(c);
        calc.println.accept(g);


    }
}

class Calculator {

    public Calculator() {
    }

    static Supplier<Calculator> instance = Calculator::new;


    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;
    BinaryOperator<Integer> divide = (x, y) -> {
        if (y == 0) {
            return x;
        }
        return x / y;
    };

    UnaryOperator<Integer> pow = x -> x * x;
    UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;

    Predicate<Integer> isPositive = x -> x > 0;

    Consumer<Integer> println = System.out::println;


}