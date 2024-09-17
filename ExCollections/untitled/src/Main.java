import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Compras> compras = new ArrayList<>();

        int key = 0;
        do {

        System.out.println("Escreva a descricao do produto");
        String name = sc.next();
        System.out.println("Agora o valor");
        int value = sc.nextInt();


        if(value <= Conta.valorConta){
            Compras item = new Compras(name,value);
            System.out.println("Compra realizada");
            compras.add(item);
        }else{
            System.out.println("Sem saldo");
        }
        System.out.println("deseja continuar 1, deseja sair 2");
        key = sc.nextInt();
        }while (key == 1);
        compras.sort(Comparator.comparing(Compras::getValor));
        compras.forEach(System.out::println);
    }
}