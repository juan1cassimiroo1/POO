public class Carro {
    // Atributos Encapsulados (private)
    private String marca;
    private String modelo;
    private int ano;
    private final double velocidadeMaxima;
    private double velocidadeAtual; // Corrigido o nome aqui
    private final boolean automatico;

    // Método Construtor (Parâmetros ajustados para minúsculo)
    public Carro(String marca, String modelo, int ano){
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.velocidadeMaxima = 250;
        this.velocidadeAtual = 0;   // Corrigido
        this.automatico = true;
    }

    // Método
    public void acelerar(){
        System.out.println("VRUUUMMMM");
    }

    // Sobrecarga do método acelerar() - Corrigido para double
    public void acelerar(double novaVelocidade){ 
        this.velocidadeAtual = novaVelocidade;
        String velText = String.format("Nova velocidade: %.2f Km/h", velocidadeAtual);
        System.out.println(velText);
    }

    // Método privado
    private String maiuscula(String txt){
        return txt.toUpperCase();
    }

    // Métodos Getters
    public String getMarca(){
        return maiuscula(marca);
    }

    public String getModelo(){
        return modelo.toLowerCase();
    }

    public int getAno(){
        return ano;
    }

    // Métodos Setters
    public void setAno(int novoAno){
        if(novoAno > 2000 && novoAno <= 2026){
            ano = novoAno;
        } else {
            System.out.println("Ano inválido");
        }
    }

    public void setMarca(String novaMarca){
        if(novaMarca != null && !novaMarca.isEmpty()){
            marca = novaMarca;
        } else {
            System.out.println("Marca inválida");
        }
    }

    public void setModelo(String novoModelo){
        if(novoModelo != null && !novoModelo.isEmpty())
            modelo = novoModelo;
        else
            System.out.println("Modelo inválido"); // Corrigido o gênero de "inválida"
    }

    public void mostrarInfo(){
        System.out.println("Marca: " + this.marca);
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Ano de Fabricação: " + this.ano);
        System.out.println("Velocidade Máxima: " + this.velocidadeMaxima);
        System.out.println("Automático: " + this.automatico);
    }
} // Chave de fechamento da classe