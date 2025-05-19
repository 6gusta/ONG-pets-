Sistema de Adoção de Pets - Frontend Angular
Este projeto é o frontend de um sistema completo de adoção de pets, desenvolvido em Angular, com foco na experiência do usuário para visualização, cadastro e gerenciamento de animais disponíveis para adoção. A aplicação é uma SPA (Single Page Application) que consome uma API RESTful para operações CRUD e autenticação.

Visão Geral
Este projeto foi gerado usando o Angular CLI versão 19.2.8.

Motivação
A ideia surgiu para criar uma plataforma eficiente e intuitiva para facilitar a adoção responsável de pets, proporcionando uma interface moderna e responsiva que possa ser usada tanto por interessados quanto por administradores da ONG.

Funcionalidades Principais
Autenticação de usuários com rotas protegidas.

Cadastro, edição e visualização detalhada dos pets.

Filtros avançados por localização, espécie, porte, idade, entre outros.

Formulários reativos e validação robusta para garantir qualidade dos dados.

Navegação intuitiva e responsiva para diferentes dispositivos.

Feedback visual e mensagens claras para interação com o usuário.

Estrutura do Projeto
src/app/components - Componentes reutilizáveis (cards, botões, formulários).

src/app/pages - Páginas principais da aplicação (home, login, dashboard).

src/app/services - Serviços Angular para consumo da API e manipulação dos dados.

src/app/models - Interfaces e modelos de dados para tipagem TypeScript.

src/assets - Imagens, estilos globais e recursos estáticos.

Tecnologias Utilizadas
Angular 15+

TypeScript

RxJS para programação reativa

Angular Router para gerenciamento de rotas

Angular Reactive Forms para formulários

HTML5 & CSS3 com design responsivo

Como Rodar o Projeto
Pré-requisitos
Node.js (v14+)

Angular CLI instalado (npm install -g @angular/cli)

Passos para execução
bash
Copy
Edit
git clone https://github.com/6gusta/Angulardo.git
cd Angulardo
npm install
ng serve --open
Após executar o servidor local, abra o navegador em http://localhost:4200/. A aplicação irá recarregar automaticamente sempre que você modificar algum arquivo fonte.

Desenvolvimento e Utilitários
Gerar componentes
Para gerar um novo componente, utilize:

bash
Copy
Edit
ng generate component nome-do-componente
Para listar todos os esquemas disponíveis (componentes, diretivas, pipes):

bash
Copy
Edit
ng generate --help
Build da aplicação
Para compilar a aplicação e gerar os arquivos finais, rode:

bash
Copy
Edit
ng build
Os arquivos compilados serão salvos na pasta dist/. Por padrão, o build de produção otimiza o código para desempenho e velocidade.

Testes
Testes unitários
Para executar testes unitários usando o Karma:

bash
Copy
Edit
ng test
Testes end-to-end (e2e)
Para testes end-to-end:

bash
Copy
Edit
ng e2e
