<h1># Teste-ITAVENTURES</h1>

<h2> MER </h2>

<img src="https://user-images.githubusercontent.com/81486915/192194768-6d111876-6b50-4dda-8ee4-342dee2e72a1.png">


<h2>Passo a passo</h2>

1 - Clonar o repositório git clone https://github.com/IgorRibeiro-S/Teste-ITAVENTURES.git

2 - Rodar mvn clean install para instalar as dependências

3 - Rodar mvn spring-boot:run para subir a aplicação

4 - A aplicação estará disponível na porta 8080

5 - As tabelas são criadas automaticamente ao rodar a aplicação.

<h2> *IMPORTANTE* </h2>

Alterar o application.properties conforme o seu banco.
Utilizar a ferramenta POSTMAN para requisições.

Para teste ADMIN - login: admin
                   senha: password



Para teste USER - login: user
                   senha: password
                   
                   
<h1> *URLS DISPONÍVEIS PARA ADMIN* </h1>

<h3>* /presenca/data?start={DATA DE INICIO}&END={DATA FIM}</h3>
Esta URL filtra as datas selecionadas.

<img src="https://user-images.githubusercontent.com/81486915/192188582-ca40c741-4b11-4838-b4dc-36d5ab0aabc6.png" width="550" height="290">


<h3>* /presenca/{ID}</h3>
Esta URL seleciona a presença por id.
*GET
*DELETE
*PUT

<img src="https://user-images.githubusercontent.com/81486915/192189124-750334e7-83a7-477f-a946-e5d825794eed.png" width="550" height="290">

<h3>* /presenca</h3>
Esta URL lista todos as presenças.

<img src="https://user-images.githubusercontent.com/81486915/192189348-94798f01-caa7-4726-8ca7-79f353f0b4da.png" width="550" height="290">


<h3>* /usuario</h3>
Esta URL lista todos os usuarios em seu estado atual.

<h3>* /usuario/{ID}</h3>
Esta URL seleciona o usuario por ID em seu estado atual.
*GET
*DELETE
*PUT

<h3>* /usuario/novo</h3>
Esta URL insere um novo usuário.

<h1> *SEGURANÇA* </h1>

Abaixo veremos alguns alguns exemplos de resposta dos usuários ("USER") e ("ADMIN")

<h3> Resposta OK para ADMIN </h3>

<img src="https://user-images.githubusercontent.com/81486915/192190140-1e9c6841-59e5-4779-ab72-96c1b43cf79e.png" width="550" height="290">

<h3> Resposta FORBIDDEN para USER </h3>

<img src="https://user-images.githubusercontent.com/81486915/192190290-63558d1c-4bc2-4869-9938-f7907536d232.png" width="550" height="290">


<h2> COMO CONCEDER ROLES A UM USUÁRIO </h2>

<h3> Usuarios sem ROLEs </h3>
<img src="https://user-images.githubusercontent.com/81486915/192190096-d2f56452-ac48-4225-ac36-cb36ddcfa837.png" width="550" height="290">

<h3> Dando permissão a usuários </h3>

<img src="https://user-images.githubusercontent.com/81486915/192190534-dc18ec9a-562a-4471-9bb9-67ae500b1bb6.png" width="550" height="290">




