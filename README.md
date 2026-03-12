# spring-crud-product

![Java Version](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?style=for-the-badge&logo=springboot)
![Status](https://img.shields.io/badge/Status-Concluído-brightgreen?style=for-the-badge)

Projeto básico em Spring Boot para prática, implementando um CRUD de produtos. Aplicação focada apenas no backend, sem interface gráfica.
A interação com a aplicação é feita por meio de requisições HTTP (POST, GET, PUT e DELETE) enviadas diretamente para a URL da API.
<br>

---
## Estrutura de Pastas
Projeto desenvolvido utilizando arquitetura em camadas.<br>
Arquitetura em camadas para melhor organização e manutenção:

- `service` — regras de negócio  
- `controller` — camada de controle  
- `infrastructure` — camada de entidades, exceptions e etc
---  

## Como executar
- Fazer git clone do repositorio com comando [ git clone https://github.com/ViniciusS4ntos/spring-crud-product.git ]
- Ter o **JDK 21** instalado
- Ter o **Docker**
- Abrir o repositorio por alguma ide ( Prefira Intelij )
- usar o comando [ mvn clean package ] para gerar um .jar
- usar  o comando [ docker build -t spring-crud-product .
- usar o comando [ docker run -p 8080:8080 spring-crud-product ]
- e fazer bom uso
