# ICEVOS - Escalonador de Processos

Descrição
---------
Projeto do trabalho prático P1 da disciplina Algoritmos e Estruturas de Dados I.
Implementa um escalonador de processos com três níveis de prioridade, prevenção
de inanição e gerenciamento de bloqueio por recurso (DISCO). Todas as listas
foram implementadas "do zero" (lista duplamente encadeada).

Disciplina: Algoritmos e Estruturas de Dados I
Professor: Dimmy Magalhães 

Autores
-------
Aluno:Rhuan Douglas Martins e silva
Matrícula:0030746

Arquivos do projeto
-------------------
- Main.java
- Scheduler.java
- ListaDeProcessos.java
- Node.java
- Processo.java
- processos.csv (exemplo de entrada)

Formato do arquivo de entrada
-----------------------------
Arquivo CSV com o formato:
id,nome,prioridade,ciclos,recurso

Exemplo (processos.csv):
id,nome,prioridade,ciclos,recurso
1,P1,1,4,
2,P2,1,3,DISCO
3,P3,2,5,
4,P4,3,6,
5,P5,1,2,
6,P6,1,1,DISCO

Compilar e executar (linha de comando)
--------------------------------------
1. Compile:
   javac *.java

2. Execute (passando o nome do arquivo de entrada):
   java Main processos.csv

   Se nenhum argumento for passado, o programa tenta ler "processos.csv".

Saída esperada
--------------
A cada ciclo o programa imprime:
- Estado das filas (alta/média/baixa/bloqueados)
- Eventos de desbloqueio
- Processo em execução e resultado (ciclos restantes)
- Evento de término de processo

Observações / Regras do trabalho
-------------------------------
- Não foram usadas coleções prontas (ArrayList, LinkedList, etc.).
- As listas foram implementadas via nós (Node) e referências.
- Para apresentação, sugerimos demonstrar o arquivo `processos.csv` e rodar alguns ciclos.

Como contribuir / commits
-------------------------
Recomendamos commits pequenos e descritivos, por exemplo:
- "Adicionar classe Processo"
- "Implementar ListaDeProcessos"
- "Implementar leitura CSV e execução de ciclos"
- "Ajustes de logs"

Licença
-------
Projeto para fins acadêmicos.

