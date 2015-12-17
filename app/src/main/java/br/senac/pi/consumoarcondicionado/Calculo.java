package br.senac.pi.consumoarcondicionado;

/**
 * Created by Aluno on 16/12/2015.
 */
public class Calculo {
    private long id;
    private String nome;
    private double resultado;

    public Calculo(long id, String nome, double resultado) {
        this.id = id;
        this.nome = nome;
        this.resultado = resultado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public Calculo() {


    }
}
