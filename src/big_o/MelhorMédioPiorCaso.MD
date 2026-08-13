O `Big O` é pior caso de um algoritmo, você faz uma análise de quantos passos no máximo algo será usado para completar a tarefa.  
Ex.:  
– Se tivermos uma lista de N números e quisermos
encontrar algum deles, assume-se que a complexidade no
pior caso é O (N), pois assume-se que o número estaria,
no pior caso, no final da lista.

O `Big Omega Ω` é o melhor caso que aquilo executará.  
Ex.:  
    – Se tivermos uma lista de N números e quisermos
    encontrar algum deles assume-se que a complexidade
    no melhor caso é f(N) = Ω (1), pois assume-se que o
    número estaria logo na cabeça da lista.

O `Big Theta θ` quer saber a complexidade média de execução (não é que seja a média aritmética mesmo, ela fica entre as medidas anteriores, mas é algo que gera um valor menos previsível), então ele espera que esteja ente os dois conceitos anteriores. Em muitos casos a média (real) é o que queremos saber de verdade principalmente se a média ou próximo disto é o que mais acontecerá.

Existem algoritmos que o Big O estrito de muitos algoritmos são bem ruins, por exemplo a busca em uma tabela hash tem Big O real O(N), em geral até um pouco mais que isso, mas pouco, talvez um O(N+k) ou O(N+M) onde M é um número baixo que precisa ser calculado por outra fórmula. Em muitos casos o que se usa como Big O é na verdade o Big θ, ou algo próximo disso. Em outros só ignoram as exceções que pode acontecer (o exemplo que citei agora tem complexidade constante na maioria dos casos, em alguns tem um custo um pouco maior, que pode sim chegar em ser linear, mas que na prática nunca acontece, então se ignora isto para maioria das análises, mas não pode em todas.

Isso significa que comumente o Big O é usado como Big θ.

[Serei capaz de resolver essas questões um dia?](https://www.ime.usp.br/~pf/analise_de_algoritmos/aulas/Oh.html)
