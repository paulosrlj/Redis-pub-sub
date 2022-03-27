# Redis-pub-sub

## Grupo
-> Paulo Sérgio Rodrigues Leite Junior <br>
-> Luciana Ferreira Miranda


## Requisitos para executar
-> Java <br>
-> Maven <br>
-> Redis (e configurar a porta dentro do código caso necessário)

## Como executar

### Compilar 
<ul>
  <li>Baixar o projeto</li>
  <li>Verificar se o redis está na porta certa</li>
  <li>No diretório raiz do projeto, rodar: <code>mvn clean package</code><mvn>
</ul>
    
### Primeiro, rodar como subscriber para entrar em um canal 
<ul>
  <li><code>java -cp target\redis-pub-sub-jar-with-dependencies.jar br.com.ifpb.socket.ChannelSubscribe</code></li>
</ul>
    
 ### Depois, basta entrar no canal como publisher em outro terminal e enviar mensagems
<ul>
  <li><code>java -cp  target\redis-pub-sub-jar-with-dependencies.jar br.com.ifpb.socket.ChannelPublish</code></li>
</ul>
