// DecisionBinaria.java
import java.util.Scanner;

public class DecisionBinaria implements LogicaDecision {
    @Override
    public String tomarDecision() {
        System.out.println("¿Qué quieres hacer?");
        System.out.println("1. Entrar a la cueva");
        System.out.println("2. Volver al pueblo");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
