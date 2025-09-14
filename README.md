# Biblioteca

Um projeto em Java para gerenciamento de biblioteca (ou coleção de livros), que serve como base de estudo/prática.

---

## Índice

1. [Sobre](#sobre)
2. [Funcionalidades](#funcionalidades)
3. [Estrutura do Projeto](#estrutura-do-projeto)
4. [Pré-requisitos](#pré-requisitos)
5. [Como Executar](#como-executar)
6. [Configurações](#configurações)
7. [Contribuição](#contribuição)
8. [Licença](#licença)

---

## Sobre

Este projeto serve como template para iniciar um aplicativo em Java usando VS Code. Ele facilita a organização de fontes, dependências e saídas compiladas.

---

## Funcionalidades

* Organização de código fonte (`src`)
* Gerenciamento de dependências externas em `lib`
* Saída compilada em `bin`
* Estrutura já preparada para personalização via configurações do VS Code

---

## Estrutura do Projeto

```
biblioteca/
├── src/        # Código fonte Java
├── lib/        # Bibliotecas externas (jar etc.)
├── bin/        # Arquivos compilados
├── .vscode/
│   └── settings.json  # Configurações de workspace
└── README.md
```

---

## Pré-requisitos

* Java JDK (versão 24 ou superior)
* VS Code (ou outro editor de sua preferência)
* Se usar alguma biblioteca externa, ter os arquivos `.jar` em `lib`

---

## Como Executar

1. Clonar este repositório:

   ```bash
   git clone https://github.com/jessecezar/biblioteca.git
   ```

2. Abrir no VS Code (ou outro IDE/editor).

3. Garantir que a JDK esteja configurada corretamente no ambiente.

4. Compilar os arquivos Java (por exemplo dentro de `src`), configurando saída para `bin`.

5. Executar o arquivo principal / ponto de entrada do projeto.

---

## Configurações

Você pode customizar algumas partes:

* O `.vscode/settings.json` permite alterar os caminhos de compilação, saída, etc.
* Adicionar novas dependências em `lib` quando necessário.

---

## Contribuição

Se quiser contribuir:

1. Faça um *fork* deste repositório
2. Crie uma *branch* com sua feature ou correção
3. Faça *pull request* explicando as mudanças

---

## Licença

Este projeto está licenciado sob a **MIT License**.

---
