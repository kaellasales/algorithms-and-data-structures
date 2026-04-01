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

    public static void main(String[] args){
        System.out.printf("Testing O(1) complexity [isEven]: %b\n", isEven(2));
    }
}
