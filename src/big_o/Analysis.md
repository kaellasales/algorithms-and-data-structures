### Notação (o Big O)  descreve a taxa de crescimento de uma Métrica (Tempo de Execução ou Espaço na Memória)

#### A questão a seguir foi retirada do LeetCode. Realizando a análise assintótica da solução, podemos concluir que a complexidade é O(n^2).
```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if( nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
        }
    }
    return new int[]{};
}
```

#### O LeetCode, ao final do enunciado do problema nos faz a seguinte provocação:
"Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?"

#### Como faríamos isso ?

```java
import java.util.HashMap;

class Solution {
  public int[] twoSum(int[] nums, int target) {
    HashMap <Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < nums.length; i++){
      int complement = target - nums[i];
      if (map.containsKey(complement)){
        return new int[]{map.get(complement), i};
      }
      map.put(nums[i], i);
    }
    return new int[]{};
  }

}

```
### Interpretação do código:

 - Para cada iteração calculamos o complemento, que é basicamente o quão distante o número da vez está do alvo(target), posterior a isso verificamos se esse complemento(que no caso do hashmap é a chave) já foi mapeado, se sim retornamos o indice do número da vez e o valor armazenado para aquele complemento(chave; o valor será o indice em que o complemento está armazenado na lista). Caso o complemento não tenha sido hasheado, hasheamos o número atual como chave e seu índice como valor e o loop continua acontecendo até a ocorrência da condicional ou até a lista ser percorrida completamente.
### A solução seria usar HashMap
- o que é ?
  O funcionamento do HashMap é baseado em uma função hash, que transforma a chave em um índice na tabela onde o valor correspondente será armazenado. Quando um novo par chave-valor é adicionado, a função hash é aplicada à chave, gerando um índice que determina onde o valor será colocado.

- Dessa maneira, a complexidade da resolução do problema iria de O(n^2) para O(n).