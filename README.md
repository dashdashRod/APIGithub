# APIGithub
Api Rest feita em java

Classe Usuario, classe responsável por getters e setters, se trata como objeto a ser armazenado

Classe Controller, responsável por Criar, Deletar, Modificar e Vizualizar os itens no banco.

Classe GitHubContent, utilizado como wrapper para a api gitHub


Paths:
    
    8080/Lista : Lista todos os usuarios salvos em banco :GET
    
    8080/Lista/{id}: Mostra usuario salvo com determinado Id  :GET
    
    8080/SalvaUsuario: Path responsável pela inserção do objeto Usuario em Banco :POST
    
    8080/Lista/{id}/github: Path responsável pela utilização do GitHubAPi, para fim de listar os repositórios do usuario :GET
    
    8080/DeletarUsuario/{id}: Path responsável por deletar um usuário dado o Id :DELETE
    
    
    Exemplificação do corpo de uma requisição POST:
     
    {
    "id": 1,
    "name":"ZZZZpa",
    "login":"fulano3",
    "password":"12345",
    "gitHub":"https://github.com/jezdez",
    "email":"somenew@something.com"
   }
