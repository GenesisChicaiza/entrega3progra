package src.mates;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Funciones {



    //12
    /*
    * Una función lambda es una función anónima, que permite definir un comportamiento sin necesidad de declarar una clase o método explícito.
    */


    // Ejercicio 13:
    public static Function<Double, Function<Double, Function<Double, Function<Function<Double, Double>, Double>>>> integral =
            (a) -> (b) -> (h) -> (funcion) -> calcularIntegral(a, b, h, funcion);

    public static double calcularIntegral(double a, double b, double h, Function<Double, Double> funcion) {
        if (a >= b) return 0.0;
        return funcion.apply(a) * h + calcularIntegral(a + h, b, h, funcion);
    }

    
    public static void generarStreams() {
        System.out.println("Stream usando of:");
        IntStream.of(1, 2, 3, 4, 5).forEach(System.out::println);

        System.out.println("\nStream usando range:");
        IntStream.range(1, 6).forEach(System.out::println);

        System.out.println("\nStream usando iterate:");
        IntStream.iterate(1, n -> n + 2).limit(5).forEach(System.out::println);

        System.out.println("\nStream de números aleatorios:");
        new Random().ints(5, 0, 100).forEach(System.out::println);
    }

    //1
    public static int sumaN(int n) {
        return IntStream.rangeClosed(0,n).sum();
    }

    //2
    public static int factorial(int n){

       return IntStream.rangeClosed(0,n)
        .reduce(1,(a,b) -> a*b);

    }

    //3
    public static int potencia(int base, int exponente) {
        return IntStream.range(0,exponente)
                .reduce(1,(a,b) -> a * base);

    }

    //4

    public static int sumaLista(List<Integer> lista){
        return lista.stream()
                .mapToInt(Integer::intValue).sum();
    }

    //5  media aritmetica de una lista de numeros.

    public static double media(List<Integer> lista){
        return lista.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);

    }

    //6

    public static double desviacionTipica(List<Integer> numeros) {
        double media = media(numeros);
        return Math.sqrt(
                numeros.stream()
                        .mapToDouble(num -> Math.pow(num - media, 2))
                        .average()
                        .orElse(0.0)
        );
    }

    //7

    public static int sumapares(int n){
        return IntStream.rangeClosed(0,n)
                .filter(x -> x%2== 0).sum();

    }

    //8 suma de elementos pares de una lista de enteros

    public static int pares(List<Integer>numeros){
        return numeros.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue).sum();
    }

    //9

    public static List<Integer> listapar(List<Integer>numeros) {

        return numeros.stream()
                .filter(num -> num % 2 == 0 && num >=2)
                .collect(Collectors.toList());

    }


    // 10. Lista de los primeros números pares hasta n (n ≥ 2)
    public static List<Integer> listaPar(int n) {
        return IntStream.rangeClosed(2,n)
                .filter(x -> x % 2 == 0)
                .boxed()
                .collect(Collectors.toList());
    }

    // 11.

    public static int calcularProductoEscalar(List<Integer> lista1, List<Integer> lista2) {
        return IntStream.range(0, lista1.size())
                .map(i -> lista1.get(i) * lista2.get(i))
                .sum();
    }

    // 12

    public static int fibonacci(int n) {
        return IntStream.rangeClosed(1, n) // Genera un rango de 1 a n
                .reduce((a, b) -> b + a) // Calcula Fibonacci iterativamente
                .orElse(0); // Si n es 0, devuelve 0
    }

    // 16

    public static double integralConStreams(double a, double b, double h, Function<Double, Double> funcion) {
        return DoubleStream.iterate(a, x -> x + h)
                .limit((long) ((b - a) / h))
                .map(funcion::apply)
                .sum() * h;
    }

    // 17

    public static class Persona {
        public String nombre;
        LocalDate fechaNacimiento;

        public Persona(String nombre, LocalDate fechaNacimiento) {
            this.nombre = nombre;
            this.fechaNacimiento = fechaNacimiento;
        }

        public long calcularEdad() {
            return Period.between(fechaNacimiento, LocalDate.now()).getYears();

        }
    }

        // 17

        public static class Personas{

        List<Persona> lista = new ArrayList<>();

        public void addPerson(Persona persona){
            lista.add(persona);
        }

        public Persona elMasJoven(){
            return lista.stream().min(Comparator.comparing(Persona::calcularEdad)).orElse(null);
        }

        public long calcularSumaEdades(){
            return lista.stream().mapToLong(Persona::calcularEdad).sum();

        }

            public long calcularEdadMinima() {
                return lista.stream().mapToLong(Persona::calcularEdad).min().orElse(0);
            }

            public double calcularMediaDeEdad() {
                return lista.stream().mapToLong(Persona::calcularEdad).average().orElse(0);
            }


    }










}
