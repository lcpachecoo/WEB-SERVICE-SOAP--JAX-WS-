package br.com.escola.servico;

import br.com.escola.modelo.Aluno;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;


@WebService
public interface MatriculaService {

    /**
     * Cadastra um novo aluno no sistema.
     * @param aluno Objeto Aluno preenchido com matrícula, nome e notas.
     */
    @WebMethod
    void cadastrarAluno(Aluno aluno);

    /**
     * Busca um aluno pelo número de matrícula.
     * @param matricula Identificador único do aluno.
     * @return Objeto Aluno correspondente, ou null se não encontrado.
     */
    @WebMethod
    Aluno buscarPorMatricula(String matricula);

    /**
     * Calcula a média aritmética das duas notas do aluno.
     * Fórmula: (nota1 + nota2) / 2
     * @param matricula Identificador único do aluno.
     * @return Média calculada como double.
     */
    @WebMethod
    double calcularMedia(String matricula);

    /**
     * Verifica a situação do aluno com base na média.
     * Regra: média >= 6 → "APROVADO" | média < 6 → "REPROVADO"
     * @param matricula Identificador único do aluno.
     * @return String com a situação: "APROVADO" ou "REPROVADO".
     */
    @WebMethod
    String verificarSituacao(String matricula);

    /**
     * Retorna todos os alunos cadastrados no sistema.
     * @return Lista de objetos Aluno.
     */
    @WebMethod
    List<Aluno> listarTodos();
}