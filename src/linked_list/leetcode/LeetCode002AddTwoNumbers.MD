### Add Two Numbers

> You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
>
> You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Essa questão está na lista de questões do LeetCode e foi a primeira questão de Linked List que resolvi por lá.

### Variáveis principais

Essas variáveis são mantidas durante toda a execução do algoritmo:

* `dummy` — nó sentinela utilizado para manter uma referência fixa ao início da lista resultante;
* `current` — referencia o último nó inserido na lista resultante;
* `carry` — armazena a dezena que deve ser carregada para a soma dos próximos nós;
* `l1` e `l2` — percorrem as duas listas de entrada.

Inicialmente:

```java
Node dummy = new Node(0);
Node current = dummy;
int carry = 0;
```

`dummy` e `current` referenciam o mesmo nó no início:

```text
dummy
  ↓
 [0]
  ↑
current
```

O valor `0` armazenado em `dummy` não faz parte do resultado final. Ele existe apenas para simplificar a construção da nova lista.

---

### Fluxo

O algoritmo utiliza:

```java
while (l1 != null || l2 != null)
```

Isso significa que o loop continua enquanto **pelo menos uma das listas ainda possuir um nó**.

O loop termina apenas quando:

```text
l1 == null
e
l2 == null
```

Isso também permite trabalhar com listas de tamanhos diferentes.

---

### Primeira iteração

Primeiro recuperamos os valores dos nós atuais:

```java
int x = (l1 != null) ? l1.value : 0;
int y = (l2 != null) ? l2.value : 0;
```

Caso uma das listas já tenha terminado, consideramos seu valor como `0`.

Depois realizamos:

```java
int sum = x + y + carry;
```

O `carry` contém a dezena proveniente da soma anterior.

Em seguida:

```java
carry = sum / 10;
```

Se:

```text
sum = 17
```

teremos:

```text
carry = 1
```

O dígito que realmente pertence ao nó atual é obtido por:

```java
sum % 10
```

Então criamos:

```java
Node newNode = new Node(sum % 10);
```

---

Como na primeira iteração:

```text
current == dummy
```

ao executarmos:

```java
current.next = newNode;
```

estamos alterando o `next` do próprio objeto referenciado por `dummy`.

Portanto:

```text
dummy
  ↓
 [0] → [newNode]
  ↑
current
```

Consequentemente:

```java
dummy.next
```

passa a referenciar o **primeiro nó real da lista resultante**.

Depois executamos:

```java
current = current.next;
```

Agora `current` deixa de referenciar o `dummy` e passa a referenciar o nó recém-criado:

```text
dummy
  ↓
 [0] → [newNode]
           ↑
        current
```

O `dummy`, entretanto, continua parado no início.

Por fim, avançamos nas listas de entrada:

```java
if (l1 != null) {
    l1 = l1.next;
}

if (l2 != null) {
    l2 = l2.next;
}
```

---

### Segunda iteração em diante

O processo de soma se repete:

```java
int x = (l1 != null) ? l1.value : 0;
int y = (l2 != null) ? l2.value : 0;

int sum = x + y + carry;

carry = sum / 10;

Node newNode = new Node(sum % 10);
```

A diferença importante aparece aqui:

```java
current.next = newNode;
```

Agora `current` referencia o **último nó da lista resultante**, e não mais o `dummy`.

Portanto, essa atribuição cria a ligação:

```text
nó anterior → novo nó
```

Visualmente:

```text
dummy
  ↓
 [0] → [7] → [0]
              ↑
           current
```

Após criar um novo nó:

```java
current.next = newNode;
```

temos:

```text
dummy
  ↓
 [0] → [7] → [0] → [8]
              ↑
           current
```

Depois:

```java
current = current.next;
```

fazemos `current` avançar:

```text
dummy
  ↓
 [0] → [7] → [0] → [8]
                    ↑
                 current
```

Esse ciclo se repete até que as duas listas de entrada tenham terminado.

---

### Após o loop

Mesmo depois que `l1` e `l2` terminam, ainda pode existir um valor em `carry`.

Por exemplo:

```text
9 + 9 = 18
```

O nó recebe:

```text
8
```

e:

```text
carry = 1
```

Se ao final:

```java
carry > 0
```

criamos mais um nó:

```java
if (carry > 0) {
    current.next = new Node(carry);
}
```

---

### Retorno

Não retornamos:

```java
dummy
```

porque ele é apenas o nó sentinela criado artificialmente.

Retornamos:

```java
return dummy.next;
```

`dummy.next` referencia o primeiro nó real da lista resultante.

Por exemplo:

```text
dummy
  ↓
 [0] → [7] → [0] → [8] → null
        ↑
    resultado
```

O retorno será:

```text
7 → 0 → 8 → null
```

---

### Complexidade

Se `m` é o tamanho de `l1` e `n` é o tamanho de `l2`, percorremos as listas até que a maior delas termine.

**Tempo:**

```text
O(max(m, n))
```

**Espaço:**

```text
O(max(m, n))
```

considerando a nova Linked List criada para armazenar a resposta.

Se considerarmos apenas espaço auxiliar além da própria saída:

```text
O(1)
```
