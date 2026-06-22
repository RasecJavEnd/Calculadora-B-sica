import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculadora calc = new Calculadora();

        System.out.println("=== Calculadora Básica ===");
        System.out.println("Operações disponíveis: +  -  *  /");

        boolean continuar = true;

        while (continuar) {
            System.out.print("Digite o primeiro número: ");
            double num1 = scanner.nextDouble();

            System.out.print("Digite o operador (+, -, *, /): ");
            String operador = scanner.next();

            System.out.print("Digite o segundo número: ");
            double num2 = scanner.nextDouble();

            double resultado;

            switch (operador) {
                case "+":
                    resultado = calc.somar(num1, num2);
                    break;
                case "-":
                    resultado = calc.subtrair(num1, num2);
                    break;
                case "*":
                    resultado = calc.multiplicar(num1, num2);
                    break;
                case "/":
                    try {
                        resultado = calc.dividir(num1, num2);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                    break;
                default:
                    System.out.println("Operador inválido!");
                    continue;
            }

            System.out.println("Resultado: " + resultado);

            System.out.print("Deseja continuar? (s/n): ");
            String resposta = scanner.next();
            continuar = resposta.equalsIgnoreCase("s");
        }

        System.out.println("Encerrando calculadora...");
        scanner.close();
    }
}
