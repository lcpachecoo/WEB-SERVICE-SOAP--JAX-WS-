package br.com.escola.servico;

import br.com.escola.modelo.Aluno;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@WebService(endpointInterface = "br.com.escola.servico.MatriculaService")
public class MatriculaServiceImpl implements MatriculaService {

    // Banco de dados em memória: matrícula → Aluno
    private final Map<String, Aluno> bancoDeDados = new HashMap<>();

    @Override
    public void cadastrarAluno(Aluno aluno) {
        if (aluno == null || aluno.getMatricula() == null) {
            throw new IllegalArgumentException("Aluno ou matrícula não podem ser nulos.");
        }
        // Usa a matrícula como chave única no mapa
        bancoDeDados.put(aluno.getMatricula(), aluno);
        System.out.println("Aluno cadastrado: " + aluno.getNome());
    }

    @Override
    public Aluno buscarPorMatricula(String matricula) {
        Aluno aluno = bancoDeDados.get(matricula);
        if (aluno == null) {
            throw new RuntimeException("Aluno com matrícula '" + matricula + "' não encontrado.");
        }
        return aluno;
    }

    @Override
    public double calcularMedia(String matricula) {
        Aluno aluno = buscarPorMatricula(matricula);
        // Regra de negócio: média aritmética simples
        return (aluno.getNota1() + aluno.getNota2()) / 2.0;
    }

    @Override
    public String verificarSituacao(String matricula) {
        double media = calcularMedia(matricula);
        // Regra de negócio: aprovação com média >= 6
        return media >= 6.0 ? "APROVADO" : "REPROVADO";
    }

    @Override
    public List<Aluno> listarTodos() {
        // Retorna todos os valores do mapa como uma lista
        return new ArrayList<>(bancoDeDados.values());
    }
}