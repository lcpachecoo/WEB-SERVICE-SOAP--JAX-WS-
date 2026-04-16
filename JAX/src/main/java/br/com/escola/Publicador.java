package br.com.escola;

import br.com.escola.servico.MatriculaServiceImpl;
import javax.xml.ws.Endpoint;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;




public class Publicador {

    public static void main(String[] args) {
        String endereco = "http://localhost:8080/matricula";

        System.out.println("Publicando o Web Service em: " + endereco);
        System.out.println("WSDL disponível em: " + endereco + "?wsdl");

        Endpoint.publish(endereco, new MatriculaServiceImpl());

        System.out.println("Serviço publicado com sucesso! Aguardando requisições...");
    }
}