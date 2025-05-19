# Sistema de Adoção de Pets - Frontend Angular

## Visão Geral

Este projeto é o frontend de um sistema completo de adoção de pets, desenvolvido em Angular, com foco na experiência do usuário para visualização, cadastro e gerenciamento de animais disponíveis para adoção. A aplicação é uma SPA (Single Page Application) que consome uma API RESTful para operações CRUD e autenticação.

---

## Motivação

A ideia surgiu para criar uma plataforma eficiente e intuitiva para facilitar a adoção responsável de pets, proporcionando uma interface moderna e responsiva que possa ser usada tanto por interessados quanto por administradores da ONG.

---

## Funcionalidades Principais

- Autenticação de usuários com rotas protegidas.
- Cadastro, edição e visualização detalhada dos pets.
- Filtros avançados por localização, espécie, porte, idade, entre outros.
- Formulários reativos e validação robusta para garantir qualidade dos dados.
- Navegação intuitiva e responsiva para diferentes dispositivos.
- Feedback visual e mensagens claras para interação com o usuário.

---

## Estrutura do Projeto

- `src/app/components` - Componentes reutilizáveis (cards, botões, formulários).
- `src/app/pages` - Páginas principais da aplicação (home, login, dashboard).
- `src/app/services` - Serviços Angular para consumo da API e manipulação dos dados.
- `src/app/models` - Interfaces e modelos de dados para tipagem TypeScript.
- `src/assets` - Imagens, estilos globais e recursos estáticos.

---

## Tecnologias Utilizadas

- Angular 15+
- TypeScript
- RxJS para programação reativa
- Angular Router para gerenciamento de rotas
- Angular Reactive Forms para formulários
- HTML5 & CSS3 com design responsivo

---

## Como Rodar o Projeto

### Pré-requisitos

- Node.js (v14+)
- Angular CLI instalado (`npm install -g @angular/cli`)

### Passos para execução

```bash
git clone https://github.com/6gusta/Angulardo.git
cd Angulardo
npm install
ng serve --open
