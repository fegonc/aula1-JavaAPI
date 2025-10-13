package br.com.aula1;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public String teste1(String nome){
        return nome;
    }
    public String teste1(char nome[]){
        String nomeFinal = new String(nome);
        return nomeFinal;
    }

    public static List<Double> entrada(){
        System.out.println("Informe o primeiro numero: ");
        Scanner scanner = new Scanner(System.in);
        double numero1 = scanner.nextDouble();
        System.out.println("Informe o segundo numero: ");
        double numero2 = scanner.nextDouble();
        return Arrays.asList(numero1, numero2);
    }

    public static void main(String[] args) {
        //Atividade 1: Exercico de sobreescrita de metodo
        Main main = new Main();
        String nome = main.teste1("Felipe");
        String nome2 = main.teste1(new char[]{'f','e','l', 'i', 'p', 'e'});
        System.out.println(nome);
        System.out.println(nome2);


        //Atividade 2: Calculadora
        System.out.println("===========CALCULADORA================");
        Scanner scanner = new Scanner(System.in);
        Calculadora calc1 = new Calculadora();

        int opcao = 0;
        do{
            System.out.println("Selecione uma opcap ou digite 0 para sair");
            System.out.println("1 - adicao");
            System.out.println("2 - subtracao");
            System.out.println("3 - divisao");
            System.out.println("4 - multiplicacao");
            opcao = scanner.nextInt();

            double n1, n2;
            List<Double> numeros;

            switch (opcao){
                case 1:
                    numeros = entrada();
                    n1 = numeros.get(0);
                    n2 = numeros.get(1);
                    double soma1 = calc1.soma(n1,n2);
                    System.out.println("A soma eh igual a: "+soma1);
                    break;
                case 2:
                    numeros = entrada();
                    n1 = numeros.get(0);
                    n2 = numeros.get(1);
                    double sub1 = calc1.subtracao(n1,n2);
                    System.out.println("A subtracao eh igual a: "+sub1);
                    break;

                case 3:
                    numeros = entrada();
                    n1 = numeros.get(0);
                    n2 = numeros.get(1);
                    double divi = calc1.divisao(n1,n2);
                    System.out.println("A divisao eh igual a: "+divi);
                    break;
                case 4:
                    numeros = entrada();
                    n1 = numeros.get(0);
                    n2 = numeros.get(1);
                    double multi = calc1.multiplicacao(n1,n2);
                    System.out.println("A multilicacao eh igual a: "+multi);
                    break;

            }
        }while(opcao != 0);


    }


}
