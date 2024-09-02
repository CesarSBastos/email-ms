# Email Microsservice

Um microsserviço de envio de e-mail utilizando Gmail.

## Descrição

Este projeto é um microsserviço simples para envio de e-mails usando o serviço de SMTP do Gmail. Ele é construído com Java e Spring Boot, aproveitando várias bibliotecas e frameworks para facilitar o desenvolvimento e a integração.

## Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.3.3**
- **Lombok**: Para reduzir o boilerplate code.
- **Validation**: Para validações de dados.
- **PostgreSQL Driver**: Para integração com banco de dados PostgreSQL.
- **Spring Data JPA**: Para persistência de dados.
- **Java Mail Sender**: Para envio de e-mails.
- **Spring Web**: Para construir a API REST.

## Requisitos de Instalação

Antes de iniciar, certifique-se de ter os seguintes softwares instalados em sua máquina:

- **Java 8+** 
- **Maven** (para gerenciar as dependências e o build)
- **Spring Boot** 3.3.3 (embutido no projeto)

## Configuração Inicial

### 1. Clonar o Repositório

```bash
git clone https://github.com/seu-usuario/email-microsservice.git
cd email-microsservice
```
### 2. Configurar Credenciais do Gmail
O serviço utiliza o SMTP do Gmail para enviar e-mails. Para isso, é necessário configurar suas credenciais de acesso.

Crie um arquivo application.properties em src/main/resources com as seguintes propriedades:
```properties
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=seu-email@gmail.com
spring.mail.password=sua-senha-de-app
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```
### 3. Build e Execução
Para compilar e executar o projeto, use o Maven:

```bash
mvn clean install
mvn spring-boot:run
```
### Como Usar
Após iniciar o aplicativo, você pode enviar um e-mail fazendo uma solicitação POST para o endpoint /api/v1/send-email com um corpo JSON semelhante a este:

```json
{
    "ownerRef" : "Example",
    "emailFrom" : "example@remetente",
    "emailTo" : "example@destinatario",
    "subject" : "Assunto do Email",
    "text" : "Corpo do Email" 
}
```
### Exemplo de Solicitação CURL
```bash
curl --location 'http://localhost:8080/sending-email' \
--header 'Content-Type: application/json' \
--data-raw '{
    "ownerRef" : "Example",
    "emailFrom" : "example@remetente",
    "emailTo" : "example@destinatario",
    "subject" : "Assunto do Email",
    "text" : "Corpo do Email" 
}'
```
### Funcionalidades
Enviar e-mails utilizando o serviço de SMTP do Gmail.
