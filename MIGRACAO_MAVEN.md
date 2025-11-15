# Guia de Migração para Maven - prjModulo8

## ✅ O que foi feito

O arquivo `pom.xml` foi criado com toda a configuração necessária para transformar este projeto legado em um projeto Maven completo.

## 📋 Estrutura Maven

O projeto agora segue a estrutura padrão Maven:

```
prjModulo8/
├── pom.xml                     # Configuração Maven (NOVO)
├── src/
│   ├── main/
│   │   ├── java/              # Código Java
│   │   ├── resources/         # Recursos (properties, XML, etc)
│   │   └── webapp/            # Arquivos web (JSP, CSS, JS)
│   │       └── WEB-INF/
│   │           └── web.xml
│   └── test/
│       └── java/              # Testes unitários (opcional)
├── target/                    # Construído pelo Maven (NOVO)
└── build/                     # Pode ser deletado
```

## 🎯 Dependências Configuradas

- **Servlet API 4.0.1** - Para Servlets
- **JSP API 2.3.1** - Para JSP
- **H2 Database 2.2.224** - Banco de dados (já usado no projeto)
- **JSTL 1.2** - Para tags JSP (opcional, disponível se precisar)

## 🚀 Como Usar Maven

### 1️⃣ Compilar o Projeto
```powershell
cd d:\Users\mathe\OneDrive\Documentos\site materias github\site materias com maven\prjModulo8
mvn clean compile
```

### 2️⃣ Executar Testes
```powershell
mvn test
```

### 3️⃣ Gerar WAR (pacote web)
```powershell
mvn clean package
```
Isso gera `target/prjModulo8.war`

### 4️⃣ Executar Localmente com Tomcat
```powershell
mvn tomcat7:run
```
A aplicação estará em: **http://localhost:8080/prjModulo8**

### 5️⃣ Limpar Arquivos de Build
```powershell
mvn clean
```

## 📝 Próximos Passos

### Opcional: Criar estrutura de recursos
```powershell
# Criar diretório de recursos se necessário
mkdir src\main\resources
```

### Opcional: Adicionar testes
```powershell
# Criar diretório de testes
mkdir src\test\java
mkdir src\test\resources
```

## 🔄 IDE Integration

### VS Code
1. Instale a extensão "Extension Pack for Java"
2. Abra a pasta do projeto
3. Maven será detectado automaticamente
4. Use a paleta de comandos (Ctrl+Shift+P) e digite "Maven"

### Eclipse
1. File → Import → Existing Maven Projects
2. Selecione a pasta do projeto
3. Clique em "Finish"
4. Eclipse importará automaticamente

### IntelliJ IDEA
1. File → Open
2. Selecione a pasta com `pom.xml`
3. Clique em "Open as Project"

## 🛠️ Configurações Principais do pom.xml

| Propriedade | Valor | Descrição |
|-------------|-------|-----------|
| `groupId` | `ifgoiano.edu.br` | Identificador único do grupo |
| `artifactId` | `prjModulo8` | Nome do artefato |
| `version` | `1.0.0` | Versão do projeto |
| `packaging` | `war` | Tipo de pacote (web application) |
| `source` | `1.8` | Versão Java (compatível com o projeto original) |

## 🗄️ Banco de Dados

O H2 Database está configurado em `src/main/java/ifgoiano/edu/br/repositorio/FabricaDeConexao.java`:
- URL: `jdbc:h2:~/test`
- Usuário: `sa`
- Senha: `sa`

Se precisar alterar, edite apenas aquele arquivo - não é necessário mexer no `pom.xml`.

## ❌ Removendo configurações antigas

Você pode deletar:
- `build/` - Será recriado pelo Maven em `target/`
- `.classpath` - Maven gerencia automaticamente
- `.project` - Apenas necessário para Eclipse puro
- `.settings/` - Configurações do Eclipse

No VS Code, estes arquivos não são necessários.

## 📚 Referências

- [Maven Official Site](https://maven.apache.org/)
- [Maven POM Reference](https://maven.apache.org/pom.html)
- [WAR Plugin](https://maven.apache.org/plugins/maven-war-plugin/)
- [Tomcat7 Maven Plugin](https://tomcat.apache.org/maven-plugin-2.2/)

## 💡 Dicas

1. **Cache Maven**: Maven baixa dependências em `~/.m2/repository`. Pode levar tempo na primeira vez.
2. **Offline Mode**: Use `mvn -o` para trabalhar sem internet (requer dependências já baixadas).
3. **Skip Tests**: Use `mvn package -DskipTests` para pular testes.
4. **Update Dependencies**: Use `mvn dependency:update-snapshots` para atualizar dependências.

## ✨ Benefícios da Migração

✅ Gerenciamento automático de dependências  
✅ Build padronizado e reproduzível  
✅ Fácil integração com IDEs modernas  
✅ Suporte para CI/CD (GitHub Actions, Jenkins, etc)  
✅ Facilita futuras migrações (Spring Boot, etc)  
✅ Versionamento melhorado  

---

**Status**: ✅ Projeto Maven pronto para uso!
