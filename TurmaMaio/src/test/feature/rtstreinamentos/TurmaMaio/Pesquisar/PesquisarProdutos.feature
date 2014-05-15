#language:pt
@regressãoTotal
Funcionalidade: Pesquisar Produto
  Como cliente
  Para facilitar a compra de um produto
  Quero pesquisar um produto na loja

  @validação
  Cenário: Pesquisar pelo nome completo
    Dado que eu tenha um produto cadastrado
    Quando eu pesquiso por "Senhor dos Aneis - As Duas Torres"
    Então visualizo o resultado da pesquisa

  @validação @execuçãoManual
  Cenário: Pesquisar por parte do nome
    Dado que eu tenha dois filmes com pelo menos uma palavra igual
    Quando eu pesquiso por "Aneis"
    Então visualizo os resultados "Senhor dos Aneis - As Duas Torres" - "Senhor dos Anéis - Sociedade do Anel"

  @exceção
  Cenário: Pesquisar produto indisponível
    Dado que o produto "Thor" não está disponível em estoque
    Quando eu pesquiso por "Thor"
    Então visualizo mensagem de produto indisponível

  @exceção
  Cenário: Pesquisar produto inexistente
    Dado que o produto "Batman" não esteja cadastrado no sistema
    Quando eu pesquiso por "Batman"
    Então visualizo mensagem de produto inexistente

  @exceção
  Cenário: Pesquisar sem informar o produto
    Dado que eu tenha produtos cadastrados
    Quando eu pesquiso sem informar o produto
    Então visualizo todos os produtos
