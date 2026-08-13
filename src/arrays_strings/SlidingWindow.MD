## Sliding Window
Sliding Window ou, traduzindo para o portugues, Janela deslizante, é uma janela que expande com uma dada condição e comprime com outra.

## Como identificar se um problema está pedindo sliding window ?
- Array
- Pede uma certa sequência ou um certo tamanho dentro de um array.
- Características de substring/subarray contínuo

### LeetCode003Substring 
A questão solicita que o usuário retorne o tamanho da maior substring que não possui caracteres repetidos.

#### Resolução
_int max_ -> armazena o tamanho da maior substing;  
_int left_ -> aponta para o primeiro caractere da substring válida;  
_window_ -> tabela hash que armazena os caracteres presentes na janela atual 

Iteramos sobre cada caractere da string por meio de um loop for, dentro deste é verificado se a tabela contém o caractere da vez:  
- Contém?  
Removeremos cada um dos caracteres da esquerda para a direita(o left entra em ação nesse momento) até que seja removido o caractere repetido  
- Não contém?  
Adiciona o item da vez na tabela hash e atualiza o valor do max  
- Como o max é calculado?  
o Math.max(arg1, arg2) é um método que retorna o maior de dois argumentos. Basic que sempre comparamos o max com o tamanho atual da window, tendo em vista que o while garante que a janela não tenha caracteres repetidos e fora de sequência continua.

