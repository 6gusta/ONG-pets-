# Use a imagem oficial do OpenJDK 21 como base
FROM openjdk:21-jdk-slim

# Diretório de trabalho dentro do container
WORKDIR /app

# Copie o jar da aplicação para dentro do container
COPY target/seu-app.jar app.jar

# Exponha a porta padrão do Spring Boot
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
