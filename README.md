# aula1-JavaAPI
API Desenvolvida nas aulas de Java &amp; Web Technologies (Reskilling Brasil)

No pacote aula1 é onde se encontra as atividades: 
- Implemente uma sobrecarga de métodos.
- Implemente uma calculadora, onde cada operação deve ser um método.

No pacote aula é onde se encontra a continuação das Atividades e a Avaliação final.

*Continuação das atividades:
- Implemente uma classe Java utilizando o Spring Boot que receba requisições do tipo GET, POST, PUT, DELETE, para cada requisição deve ser informado os valores de formas distintas,
  exemplo: requisição do tipo POST, as informações devem ser pegas do corpo(body) da requisição. 
- Implemente o relacionamento das entidades carro e marca em Java utilizando o Spring Boot.

  *Avaliação final
  Aplicação deve ser inicada no arquivo AulasApplication.

  Exemplo de requisção GET: http://localhost:8080/carros

  Exemplo de requisição DELETE: http://localhost:8080/carros/25

  Exemplo de requição POST:
  ```json
  {
    "nome": "Lancer",
    "anoFabricacao": 2023,
    "anoModelo": 2024,
    "modelo": "Hatch",
    "marca": { "id": 2 },
    "cores": [
      { "cor": { "id": 1 } },
      { "cor": { "id": 2 } }
    ]
  }

Exemplo de requisição PUT:
```json
{
 "id": 25,
  "nome": "Lancer",
  "anoFabricacao": 2023,
  "anoModelo": 2024,
  "modelo": "Sedã",
  "marca": { "id": 2 },
  "cores": [
    { "cor": { "id": 1 } },
    { "cor": { "id": 2 } },
    { "cor": { "id": 3 } }
  ]
}






