# Cadastro de Usuários e Matérias

Um sistema web legado para gerenciamento de cadastro de usuários e suas matérias, desenvolvido com Java Servlet, JSP e banco de dados H2, este é o projeto prjModulo8 mas agora configurado no Maven.

## 📋 Descrição

Sistema de gerenciamento acadêmico que permite:
- **Cadastro de Usuários**: Registro de novos usuários com email e senha
- **Autenticação**: Login seguro com validação de credenciais
- **Gerenciamento de Matérias**: Adicionar, editar e deletar matérias associadas ao usuário
- **Listagem**: Visualizar usuários e matérias cadastrados
- **Console H2**: Interface web para gerenciar o banco de dados

## 🛠️ Tecnologias

- **Java 8+** 
- **Servlet 4.0** / **JSP**
- **H2 Database** (banco em memória/arquivo)
- **Eclipse Dynamic Web Project**
- **Apache Tomcat** (recomendado 9.x)

## 📁 Estrutura do Projeto

```
prjModulo8/
├── src/main/
│   ├── java/ifgoiano/edu/br/
│   │   ├── controles/          # Servlets
│   │   ├── entidades/          # Classes de modelo (Usuario, Materias)
│   │   ├── exceptions/         # Exceções customizadas
│   │   ├── filter/             # Filtros (CharsetFilter)
│   │   ├── negocios/           # Lógica de negócio
│   │   └── repositorio/        # Acesso a dados
│   └── webapp/
│       ├── index.jsp           # Página de login
│       ├── usuario/            # Páginas de usuário
│       ├── erro/               # Páginas de erro
│       ├── essenciais/         # CSS e recursos
│       └── WEB-INF/
│           └── web.xml         # Configuração da aplicação
├── build/                      # Arquivos compilados
└── README.md                   # Este arquivo
```

## 🚀 Como Executar

### Pré-requisitos
- Java 8 instalado
- Apache Tomcat 9.x
- VS Code ou Eclipse

### Opção 1: Via Eclipse IDE (Recomendado)

```bash
1. Abra o Eclipse
2. File → Import → Existing Projects into Workspace
3. Selecione a pasta do projeto
4. Clique com botão direito no projeto → Run As → Run on Server
5. Selecione ou crie um Tomcat Server
```

A aplicação estará disponível em: **http://localhost:8080/prjModulo8**

### Opção 2: Via Tomcat Standalone

```powershell
# Compile o projeto
cd prjModulo8
javac -encoding UTF-8 -d build/classes `
  src/main/java/ifgoiano/edu/br/controles/*.java `
  src/main/java/ifgoiano/edu/br/entidades/*.java `
  src/main/java/ifgoiano/edu/br/exceptions/*.java `
  src/main/java/ifgoiano/edu/br/filter/*.java `
  src/main/java/ifgoiano/edu/br/negocios/*.java `
  src/main/java/ifgoiano/edu/br/repositorio/*.java

# Copie para o Tomcat
Copy-Item -Recurse . -Destination "$env:CATALINA_HOME\webapps\prjModulo8"

# Inicie o Tomcat
& "$env:CATALINA_HOME\bin\catalina.bat" run
```

### Opção 3: Via VS Code + Extension Pack for Java

1. Instale **Extension Pack for Java** no VS Code
2. Instale **Tomcat for Java** extension
3. Configure um servidor Tomcat
4. Execute o projeto

## 🗄️ Banco de Dados

O projeto utiliza **H2 Database** com arquivo persistente:

- **Arquivo**: Consultável no projeto
- **Console Web**: `http://localhost:8080/prjModulo8/h2-console`
- **Driver**: Incluído nas dependências do projeto

### Tabelas Principais
- `USUARIO`: Email, Senha, Nome, Data de Criação, ID
- `MATERIAS`: ID, Nome da Matéria, Usuário

## 📋 Funcionalidades

### Servlet Controllers
- **LoginServlet**: Autenticação de usuários
- **RegistroServlet**: Cadastro de novos usuários
- **ListagemServlet**: Listagem de usuários/matérias
- **MateriasServlet**: Gerenciamento de matérias
- **EditarServlet**: Edição de usuários
- **DeletarServlet**: Remoção de registros
- **EnviarMateriasServlet**: Envio de matérias para usuário

### Páginas JSP
- `index.jsp`: Login
- `usuario/cadastro.jsp`: Cadastro de usuário
- `usuario/listagem.jsp`: Listagem
- `usuario/materias.jsp`: Gerenciamento de matérias
- `usuario/editarUsuario.jsp`: Edição de usuário
- `usuario/editarMateria.jsp`: Edição de matéria
- `usuario/deslogar.jsp`: Logout

## 🔒 Segurança

- ✅ Autenticação com email e senha
- ✅ Filtro CharsetFilter para UTF-8
- ✅ Tratamento de exceções customizadas
- ✅ Páginas de erro personalizadas
- ✅ Uso de Session para manter estado do usuário

## 📝 Notas de Desenvolvimento

- Projeto legado usando padrão MVC com Servlet/JSP
- Possível migração futura para Spring Boot ou Jakarta EE
- Compilação com encoding UTF-8 (caracteres especiais)
- Banco H2 em memória durante desenvolvimento

## 📦 Configuração Java

O projeto foi desenvolvido com **Java 8**. Configurações em:
- `.classpath`
- `.settings/org.eclipse.jdt.core.prefs`
- `.settings/org.eclipse.wst.common.project.facet.core.xml`

## 📦 Dependências

O projeto não utiliza Maven/Gradle. Para adicionar dependências externas:
1. Baixe o JAR necessário
2. Coloque em `src/main/webapp/WEB-INF/lib/`
3. Atualize `.classpath` no Eclipse

## 🐛 Troubleshooting

### Erro de Compilação
```
[ERROR] javac: source release 8 not supported
```
**Solução**: Instale JDK 8 e configure no Eclipse/VS Code

### Erro de Banco de Dados
```
DataBaseException: Conexão recusada
```
**Solução**: Verifique as credenciais H2 em `FabricaDeConexao.java`

### Erro 404 em JSP
**Solução**: Verifique se o Tomcat está mapeando corretamente `/prjModulo8`
