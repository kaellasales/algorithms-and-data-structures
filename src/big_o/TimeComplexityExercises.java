package big_o;

public class TimeComplexityExercises {

    /**
     * Complexidade de Tempo: O(1) - Constante.
     * O tempo de execução não muda, independentemente do tamanho da entrada.
     * É apenas uma operação matemática direta.
     */
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    /**
     * Complexidade de Tempo: O(log n) - Logarítmica.
     * Divide e Conquista - Não é como se você tivesse que percorrer toda entrada para achar o alvo.
     * Em vez de percorrer toda a entrada, o algoritmo corta o conjunto de dados
     * restante pela metade a cada iteração. Extremamente eficiente para grandes volumes.
     */
    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target)
                return mid;  // Encontrou!

            if (array[mid] < target)
                left = mid + 1;  // Procura na metade direita
            else
                right = mid - 1;  // Procura na metade esquerda
        }

        return -1;  // Não encontrou
    }

    /**
     * Complexidade de Tempo: O(n) - Linear.
     * O tempo de execução cresce de forma diretamente proporcional ao tamanho da entrada.
     * Assume-se que, no pior dos casos, o algoritmo precisará iterar sobre cada um dos N elementos.
     */
    public static int findMax(int[] array) {
        int maxNumber = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxNumber) {
                maxNumber = array[i];
            }
        }
        return maxNumber;
    }

    /**
     * Complexidade de Tempo: O(n log n) - Loglinear.
     * Esse é o clássico do Merge Sort. Acontecem duas coisas juntas:
     * 1. A divisão: O array é dividido pela metade várias vezes (isso é o log n).
     * 2. A união (Merge): Para cada nível de divisão, a função merge precisa
     * percorrer TODOS os N elementos para costurá-los de volta em ordem (isso é o N).
     * Multiplicando o trabalho de dividir pelo trabalho de juntar, temos O(n log n).
     */
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            // FASE 1: Divide e Conquista -> O(log n)
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            // FASE 2: Junta tudo percorrendo os N itens -> O(n)
            mergeMock(array, left, mid, right);
        }
    }

    // Função mock só pro código acima não dar erro, já que estamos apenas estudando análise de complexidade
    private static void mergeMock(int[] array, int left, int mid, int right) {
        // Na teoria do Big O, sabemos que isso aqui custaria O(n)
    }

    public static void main(String[] args) {
        System.out.printf("Testing O(1) complexity [isEven]: %b\n", isEven(2));

        int[] sortedArray = {0, 1, 3, 7, 8};
        int target = 9;
        System.out.printf("Testing O(log n) complexity [binarySearch]: %d\n", binarySearch(sortedArray, target));


        System.out.printf("Testing O(n) complexity [findMax]: %d\n", findMax(sortedArray));
    }
}