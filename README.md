# Micro Sass - Auth Server

> Este repositório contém a implementação de um gestor de acessos, visando controlar os acessos dos usuários localmente (base de dados h2).

## 💻 Pré-requisitos

Para executar este projeto, certifique-se de ter as seguintes ferramentas configuradas no seu ambiente:

- **Java 21** ou superior;
- **Apache Maven** para gerenciamento de dependências e build do projeto;
- Editor ou IDE de sua escolha (IntelliJ IDEA, Eclipse, VS Code, etc.).

## 🚀 Sobre o projeto

Esse projeto visa criar um controle sobre os usuários logados no sistema, gerando um token cadastrado para os mesmos, caso estejam logados. Isso acata mais flexibilidade a outros serviços, e, permite que esse projeto seja acoploado a outros projetos.

### ✨ Funcionalidades

- Cadastra um usuário;
- Realiza login de um usuário cadastrado retornando um token;
- Busca token ativo do usuário cadastrado;

### 🛠️ Tecnologias Utilizadas

- **Java**: Linguagem de programação principal do projeto;
- **Apache Maven**: Ferramenta de build e gerenciamento de dependências;

## 🛠️ Configuração e Execução

1. Clone este repositório:
   
bash
   git clone https://github.com/enzokaua/auth-server
