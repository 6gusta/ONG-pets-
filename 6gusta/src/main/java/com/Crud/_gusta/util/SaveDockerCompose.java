package com.Crud._gusta.util;

import jakarta.annotation.PostConstruct;

import java.io.FileWriter;

public class SaveDockerCompose {

    @PostConstruct
    public void salvarArquivo() {
        String conteudo =
                "version: \"3.8\"\n" +
                        "\n" +
                        "services:\n" +
                        "  meuappspring:\n" +
                        "    image: meuappspring\n" +
                        "    ports:\n" +
                        "      - \"8080:8080\"\n" +
                        "    deploy:\n" +
                        "      labels:\n" +
                        "        - \"traefik.enable=true\"\n" +
                        "        - \"traefik.http.routers.meuapp.rule=Host(`api.upestagio.com`)\"\n" +
                        "        - \"traefik.http.routers.meuapp.entrypoints=web\"\n" +
                        "        - \"traefik.http.services.meuapp.loadbalancer.server.port=8080\"\n" +
                        "    networks:\n" +
                        "      - minha_rede\n" +
                        "\n" +
                        "networks:\n" +
                        "  minha_rede:\n" +
                        "    external: true\n";

        try (FileWriter fw = new FileWriter("docker-compose.yml")) {
            fw.write(conteudo);
            System.out.println("docker-compose.yml criado com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao salvar docker-compose.yml: " + e.getMessage());
        }
    }
}
