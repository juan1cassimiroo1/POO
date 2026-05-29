public class ValorInvalidoException extends Exception {
    public ValorInvalidoException(String mensagem){
        //repassa a mensagem para a classe super
        super(mensagem);
    }
}
