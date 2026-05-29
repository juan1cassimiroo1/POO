import java.util.Scanner;

public class SistemaCaixaEletronico {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ContaBancaria conta = new ContaBancaria("Neymar junior", 50.0);

        System.out.println("--- Bem vindo ao banco Master ---");

        try{
            //Operação 1: Sucesso de deposito
            conta.depositar(200.0);
            System.out.println("Saldo atual: R$"+conta.verificarSaldo());
            //Operação 2: Sucesso de saque
            conta.sacar(20.0);
            System.out.println("Saldo atual: R$"+conta.verificarSaldo());
            //Operação 3: Deposito com ValorInvalidoExeption
            System.out.print("Quando deseja depositar? R$");
            double valorDeposito = scanner.nextDouble();
            conta.depositar(valorDeposito);
            //Operação 4: Saque com ValorInvalidoExeption
            System.out.print("Quanto deseja depositar? R$");
            double valorSaque = scanner.nextDouble();
            conta.sacar(valorSaque);
            //Operação 5: Saque com SaldoInsuficienteException
            System.out.println("Quanto deseja sacar? R$");
            valorSaque = scanner.nextDouble();
            conta.sacar(valorSaque);
            
            System.out.println("Por favor, retire seu dinheiro");
        }catch(SaldoInsuficienteException e){
            System.out.println("Erro de saldo!: "+e.getMessage());
            System.out.println("Gostaria de fazer um emprestimo?");
        }catch(ValorInvalidoException e){
            System.out.println("Erro de sistema!: "+e.getMessage());
        }finally{
            System.out.println("Encerrando operação.");
            scanner.close();
        }
    }
}
