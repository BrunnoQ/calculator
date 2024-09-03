package br.com.calculator.puzzles;

public class BinarySearch {

    public static void main(String args[]) {

        BinarySearch binarySearch = new BinarySearch();

        int[] a = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};

        int procurado = 13;

        int resultado = binarySearch.binarySearch(a, procurado);

        if (resultado == 0) {
            System.out.println("Elemento não encontrado");
        } else {
            System.out.println("Elemento encontrado na posição: " + resultado);
        }


    }


    int binarySearch(int[] a, int procurado) {

        int baixo = 0;
        int alto = a.length - 1;

        while (baixo <= alto) {

            int medio = (baixo + alto) / 2;
            int chute = a[medio];

            if (chute == procurado) {
                return medio;
            }

            if (chute > procurado) {
                alto = medio - 1;
            } else {
                baixo = medio + 1;
            }
        }

        return 0;
    }

}
