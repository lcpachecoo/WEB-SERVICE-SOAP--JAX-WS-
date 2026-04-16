package br.com.escola.modelo;

public class Aluno {

    private String matricula;
    private String nome;
    private double nota1;
    private double nota2;


    public Aluno() {}

    public Aluno(String matricula, String nome, double nota1, double nota2) {
        this.matricula = matricula;
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public double getNota1() { return nota1; }
    public void setNota1(double nota1) { this.nota1 = nota1; }

    public double getNota2() { return nota2; }
    public void setNota2(double nota2) { this.nota2 = nota2; }
}