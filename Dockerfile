# Pegar imagem do java-21
FROM eclipse-temurin:21-jdk-alpine

# Cria pasta app
WORKDIR /app

# Copiar .jar para dentro da pasta
COPY target/spring-crud-produtos-0.0.1-SNAPSHOT.jar /app/spring-crud-produtos-0.0.1-SNAPSHOT.jar

# Expor porta
EXPOSE 8080

# Comando CMD
CMD ["java", "-jar", "spring-crud-produtos-0.0.1-SNAPSHOT.jar"]