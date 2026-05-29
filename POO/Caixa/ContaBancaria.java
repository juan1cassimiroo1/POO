import java.util.logging.Logger;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import java.util.logging.Level;

public class ContaBancaria {
    private String titular;
    private double saldo;

    private static final Logger logger = Logger.getLogger(ContaBancaria.class.getName());
    static{
        try{
            FileHandler fileHandler = new FileHandler("logs_caixa_eletronico.txt", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            logger.setLevel(Level.INFO);
        }catch(IOException e){
            System.err.println("Nao foi possivel criar o arquivo de log: "+e.getMessage());
        }
    }

    public ContaBancaria(String titular, double saldoInicial){
        this.titular = titular;
        this.saldo = saldoInicial;
        logger.info("Conta criada para "+titular+"com saldo de R$ "+saldoInicial);
    }
    
    public double verificarSaldo(){
        return saldo;
    }

    public void depositar(double valor) throws ValorInvalidoException{
        logger.info("Iniciando operacao de deposito. Valor: R$"+valor);

        if(valor <= 0){
            //fazemos o log e disparamos o erro
            logger.warning("Falha no deposito: Tentativa de depositar valor negativo ou zero. Titular: "+titular);
            throw new ValorInvalidoException("O valor de deposito deve ser maior que zero!");  
        }
        saldo += valor;
        logger.info("Deposito realizado com sucesso. Novo saldo: R$"+saldo);
    }

    public void sacar(double valor) throws ValorInvalidoException, SaldoInsuficienteException{
        logger.info("Iniciando operacao de saque. Valor: R$"+valor);

        if(valor <=0){
            logger.warning("Falha no saque: Tentativa de savar balor negativo ou zero. Titular: "+titular);
            throw new ValorInvalidoException("O valor do saque deve ser maior que zero!"); 
        }
        if(valor > saldo){
            //erro severo
            logger.severe("Falha critica: Saque negado. Saldo: R$"+saldo+"| Tentativa: R$"+valor+"| Titular: "+titular);
            throw new SaldoInsuficienteException("Voce nao tem limite para esta saque! saldo atual: R$"+saldo);
        }
        saldo -= valor;
        logger.info("Saque de R$"+valor+" realizado com sucesso.");
    }
}
