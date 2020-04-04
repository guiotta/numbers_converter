# Projeto de Conversão de Numerais
Projeto para converter numerais Romanos e Arábicos, permitindo realizar a conversão em qualquer sentido.

## Detalhes
O projeto consiste em um web-service Restful desenvolvido em Java, utilizando Spring-Boot para manter a estrutra do servidor de aplicação.

O serviço é composto por dois endpoints, um listando quais são os tipos de numerais para os quais o valor pode ser convertido e outro, que recebe o tipo de conversão que deve realizado e o valor original, que deve ser convertido.

## Compilando o projeto
Este projeto foi construído utilizando Java 8 e Maven, sendo assim, as dependências do projeto podem ser facilmente baixados após clonar o repositório.

Caso a IDE a ser utilizada para este projeto seja uma versão do Eclipse, é aconselhável executar o seguinte comando no console 'mvn eclipse:eclipse', também é possível acrescentar os seguintes paramêtros '-DdownloadSources=true -DdownloadJavadocs=true' para baixar os source e javadoc destas dependências e colocá-los na pasta .m2 do sistema operacional.

Após este ponto, é importante executar o comando 'mvn clean install', pois este comando realiza o build da aplicação e roda os testes, além de alocar corretamente o arquivo de configuração do projeto, permitindo a execução do mesmo nas IDEs sem comportamentos inesperados.

## Executando a aplicação
Após compilar o projeto, existem dois meios de executá-lo.

O primeiro é pela IDE. Após importá-lo, ele poderá ser construído pela IDE e executado livremente.

O outro, é pela linha de comando, digitando o comando 'mvn spring-boot:run'

## Documentação do projeto
A dependência do Swagger foi adicionado ao projeto, gerando uma documentação dos endpoints criados para o projeto, bem como o schema dos objetos recebidos e enviados por estes endpoints.

O endereço padrão do Swagger do projeto é: http://localhost:8080/swagger-ui.html
