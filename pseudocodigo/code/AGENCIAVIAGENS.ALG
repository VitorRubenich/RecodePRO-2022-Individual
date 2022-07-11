Algoritmo "AgenciaViagens"
// Trabalho    : Agencia de viagens
// Descrição   : Aqui você descreve o que o programa faz! (função)
// Autor(a)    : Vitor Rubenich
// Data de inicio  : 11/06/2022
// Data de termino : 11/07/2022
// inicio do programa



//funcoes
funcao menu: inteiro
var opcao: inteiro
Inicio
  escreval("  ###  Bem vindo - Escolha a sua opcao  ###  ")
  escreval("1 - Cadastro de Cliente")
  escreval("2 - Cadastro de Destino")
  escreval("3 - Consulta de Cadastros")
  escreval("4 - Consulta de Destinos")
  leia(opcao)
  retorne opcao
fimfuncao

funcao ler: caractere
var stringLidaFuncao: caractere
inicio
      leia(stringLidaFuncao)
      retorne  stringLidaFuncao
fimfuncao
Var
    opcaoLida: inteiro
    //nome, sobrenome, cpf, cidade,  estado
    matrizClientes: vetor[1..5,1..5] de caractere
    clienteMtz: vetor[1..5] de caractere
    auxMatrizClientes: inteiro
    stringLida: caractere
    i, j:inteiro
    matrizDestinos: vetor[1..5,1..2] de caractere
    auxMatrizDestinos: inteiro
    destinoMtz: vetor[1..2] de caractere
Inicio
    clienteMtz[1]<-"Nome:"
    clienteMtz[2]<-"Sobrenome:"
    clienteMtz[3]<-"Cpf:"
    clienteMtz[4]<-"Cidade:"
    clienteMtz[5]<-"Estado:"
    destinoMtz[1]<-"Destino:"
    destinoMtz[2]<-"Pais:"

    opcaoLida<-0
    auxMatrizClientes<-1
    auxMatrizDestinos<-1
    enquanto opcaoLida <> 9 faca
      opcaoLida<-menu()
      escolha opcaoLida
      caso 1
           escreval("Digite o nome: ")
           matrizClientes[auxMatrizClientes,1]<-ler()
           escreval("Digite o sobrenome: ")
           matrizClientes[auxMatrizClientes,2]<-ler()
           escreval("Digite o cpf: ")
           matrizClientes[auxMatrizClientes,3]<-ler()
           escreval("Digite a cidade: ")
           matrizClientes[auxMatrizClientes,4]<-ler()
           escreval("Digite o estado: ")
           matrizClientes[auxMatrizClientes,5]<-ler()
           auxMatrizClientes<-auxMatrizClientes + 1
      caso 2
           escreval("Escreva o destino: ")
           matrizDestinos[auxMatrizDestinos,1]<-ler()
           escreval("Escreva o pais do destino: ")
           matrizDestinos[auxMatrizDestinos,2]<-ler()
           auxMatrizDestinos<-auxMatrizDestinos + 1
           
      caso 3
           para i de 1 ate 5 faca
                para j de 1 ate 5 faca
                       escreva(clienteMtz[j])
                       escreval(matrizClientes[i,j])
                fimpara
           fimpara
      caso 4
           para i de 1 ate 5 faca
                para j de 1 ate 2 faca
                       escreva(destinoMtz[j])
                       escreval(matrizDestinos[i,j])
                fimpara
           fimpara
      outrocaso
           escreval("Numero nao cadastrado no menu")
      fimescolha
    fimenquanto

Fimalgoritmo
