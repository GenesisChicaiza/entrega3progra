package src.aplicacion;
import src.mates.Funciones;
import src.mates.Funciones.*;

import java.util.Arrays;
import java.util.List;

public class Principal {

    public static void main(String[] args) {
        int result = Funciones.sumaN(5);
        System.out.println("La suma es: " + result);

        int torial = Funciones.factorial(4);
        System.out.println("La suma de este factorial es: " + torial);


        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // 4
        int suma = Funciones.sumaLista(numeros);
        System.out.println("Suma de la lista: " + suma);

        // 5
        double media = Funciones.media(numeros);
        System.out.println("Media aritmética: " + media);

        // 6
        double desviacion = Funciones.desviacionTipica(numeros);
        System.out.println("Desviación típica: " + desviacion);

        // 7
        int n = 9;
        int sumaPares = Funciones.sumapares(n);
        System.out.println("Suma de los primeros pares hasta " + n + ": " + sumaPares);

        // 8
        int sumaElementosPares = Funciones.pares(numeros);
        System.out.println("Suma de los elementos pares de la lista: " + sumaElementosPares);

        // 9
        List<Integer> num = Arrays.asList(1, 2, 6, 11);
        List<Integer> listaPares = Funciones.listapar(numeros);
        System.out.println("Lista de números pares: " + listaPares);

        // 10

        List<Integer> listaParesHastaN = Funciones.listaPar(n);
        System.out.println("Lista de números pares hasta " + n + ": " + listaParesHastaN);

        // 11
        List<Integer> lista1 = Arrays.asList(1, 2, 3);
        List<Integer> lista2 = Arrays.asList(2, 4, 6);
        int productoEscalar = Funciones.calcularProductoEscalar(lista1, lista2);
        System.out.println("Producto escalar: " + productoEscalar);

        // 12
        int posicionFibonacci = 10;
        int resultadoFibonacci = Funciones.fibonacci(posicionFibonacci);
        System.out.println("El elemento " + posicionFibonacci + " de Fibonacci es: " + resultadoFibonacci);


    }
}