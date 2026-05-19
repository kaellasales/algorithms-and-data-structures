### Add Two Numbers
"You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself."

#### - Essa questão está na lista de questões do LeetCode. Primeira questão de lista ligada que resolvo pelo LeetCode.

Analise o código enquanto olha essa explicação.

### Nós:

Não são resetados a cada iteração:
- dummy - aponta para o primeiro item da lista;
- current - referencia o último nó da lista;
- carry - o que sobra da soma para somarmos ao val do próximo nó.

### Fluxo:

- A função acontece envolta de um while no qual o loop só acaba quando o l1(lista ligada 1) ou l2(lista ligada 2) é diferente de null, ou seja, até as duas listas ligadas chegarem ao fim;


- Primeira iteração:
    - coletamos cada valor armazenado no nó atual de cada uma das listas(l1 e l2), se l1/l2 null x/y = 0;
    - somamos x(l1.val ou 0) + y(l2.val ou 0) + carry(sobra da soma do nó anterior);
    - atualizamos o carry, a soma pode ser > 9;
    - criamos um novo nó e atrubuimos o digito resultante da soma(newNode.val);
    - currente.next e dummy.next aponta para o newNode, ja na primeira iteração o current = dummy, é como alterar o próprio dummy(enquanto não atualizarmos o current);
    - atualizamos o current para apontar para o newNode(nesse momento current deixa de acessar o dummy);
    - avançamos na l1 e l2(l1/l2 = l2/l2.next).


- Segunda iteração:
    - coletamos cada valor armazenado no nó atual de cada uma das listas(l1 e l2), se l1/l2 null x/y = 0;
    - somamos x(l1.val ou 0) + y(l2.val ou 0) + carry(sobra da soma do nó anterior);
    - atualizamos o carry, a soma pode ser > 9;
    - criamos um novo nó e atrubuimos o digito resultante da soma(newNode.val);
    - currente.next(acessa o next do nó anterior; não atualizamos o current ainda para referenciar o newNode), desse modo, é nesse momento que o nó anterior referencia/linkamos o nó atual;
    - atualizamos o current para apontar para o newNode(nesse momento current referencia o nó atual, o link já foi garantido no passo anterior);
    - avançamos na l1 e l2(l1/l2 = l2/l2.next).


- Fora do loop
    - verificamos se o carry carrega algum valor > 0, se sim, criamos um novo nó e atribuímos o carry ao val do novo nó;
    - retornamos o primeiro item da lista.