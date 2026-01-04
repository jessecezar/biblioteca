# Biblioteca API

Projeto backend de uma API para gerenciamento de uma biblioteca.

**Descrição**
- API REST simples para CRUD de livros (listar, consultar por id, cadastrar, atualizar e excluir).
- Backend desenvolvido em Java com Spring Boot e Maven.

**Tecnologias**
- Java + Spring Boot
- Maven
- Spring Data JPA
- Front-end: HTML, CSS e JavaScript (consumo via `src/main/resources/static/js`)
- MySQL (configurado em `src/main/resources/application.properties`)

**Configuração / Pré-requisitos**
- Java 11+ instalado
- Maven (ou usar o wrapper `mvnw` / `mvnw.cmd`)
- MySQL rodando com um banco `db_biblioteca` (ajuste em suas variáveis de ambiente ou em um arquivo `application.properties` local).

Importante: NUNCA inclua credenciais reais no `README` ou em arquivos que serão comitados. Use o arquivo `src/main/resources/application.properties.example` como modelo e mantenha as credenciais fora do repositório (variáveis de ambiente, secrets do CI, ou um arquivo local ignorado pelo Git).

Exemplo (não comitar):

```properties
# spring.datasource.url=jdbc:mysql://localhost:3306/db_biblioteca
# spring.datasource.username=SEU_USUARIO
# spring.datasource.password=SUA_SENHA
```

**Como rodar**
1. Ajuste `application.properties` conforme seu ambiente.
2. Execute com Maven:

```bash
./mvnw spring-boot:run
# ou
mvn spring-boot:run
```

3. A API ficará disponível em `http://localhost:8080` por padrão.

**Desenvolvimento do front-end (SASS)**
O projeto agora usa SASS para os estilos. Para compilar localmente você pode usar o `sass` via npm:

1. Instale dependências (requer Node.js e npm):

```bash
npm install
```

2. Compilar uma vez:

```bash
npm run build:sass
```

3. Assistir alterações durante o desenvolvimento:

```bash
npm run watch:sass
```

Os arquivos SASS ficam em `src/main/resources/sass` e serão compilados para `src/main/resources/static/css`.

Observação: o build Maven foi configurado para compilar o SASS automaticamente durante a fase `generate-resources` (usa `frontend-maven-plugin`). Assim, executar `mvn package` ou `mvn spring-boot:run` também acionará a compilação do SASS quando necessário.

**Endpoints principais**
- GET  /livro/listar — lista todos os livros
- GET  /livro/{id} — busca livro por id
- POST /livro/cadastrar — cadastra um livro (JSON no body)
- POST /livro/cadastrar/lote — cadastra vários livros em lote
- PUT  /livro/{id} — atualiza um livro
- DELETE /livro/{id} — remove um livro

Exemplo (curl):

```bash
curl -X GET http://localhost:8080/livro/listar

curl -X POST http://localhost:8080/livro/cadastrar \
  -H "Content-Type: application/json" \
  -d '{"titulo":"Exemplo","autor":"Autor","isbn":"123"}'
```

**Estrutura**
- `src/main/java` — código-fonte (controllers, services, repositories, models)
- `src/main/resources/static` — arquivos estáticos (HTML, CSS, JS) para o front-end


---
Se quiser, eu posso também gerar um README em inglês ou criar um `docker-compose` para facilitar a execução com MySQL.
"# biblioteca" 
