package br.edu.ifsp.list01;

import java.util.Locale;
import java.util.Scanner;

/*
    Faça um programa que leia um conjunto de valores que correspondem as idades de pessoas de uma comunidade. Quando
    o valor fornecido for um número negativo, significa que não existem mais idades para serem lidas. Após a leitura,
    o programa deve informar:

    A média das idades das pessoas (com duas casas decimais)
    A quantidade de pessoas maiores de idade
    A porcentagem de pessoas idosas (considere quem uma pessoa idosa tem mais de 75 anos) (com duas casas decimais)

    Exemplos de entrada e saída:
    | Entrada             | Saída          |
    | -------             | ------         |
    | 10 20 30 80 -1      | 35.00 3 25.00% |
    | 25 30 45 -1         | 33.33 3 0.00%  |
    => Exercício gentilmente cedido pelos profs. Jorge Cutigi (IFSP/SCL) e Adenilso Simão (ICMC/USP)
*/
public class Ex09 {

    public static void main(String[] args) {
        //Leia o input
        //Crie uma variável do tipo deste arquivo. Exemplo: Ex02 ex = new Ex02();
        //Escreva o resultado da chamada do método compute() aqui
        Ex09 ex = new Ex09();
        Scanner scanner = new Scanner(System.in);
        int[] idades = new int[100];
        int count =0;
        while(true) {
            int idade = scanner.nextInt();
            if(idade<0) break;
            idades[count]=idade;
            count++;
        }
        int[] input = new int[count];
        System.arraycopy(idades, 0, input, 0, count);
        System.out.println(ex.compute(input));

    }

    String compute(int[] input) {
        String output = null;
        //put your logic here
        int somaIdade =0;
        int maiorIdade =0;
        int idoso =0;
        int totalPessoas=0;
        for(int i = 0; i < input.length; i++) {
            if(input[i]>=0) totalPessoas++;
            if(input[i]>=0) somaIdade += input[i];
            if(input[i]>=18) maiorIdade++;
            if(input[i]>75) idoso++;
        }
        double mediaIdade = (double)somaIdade / totalPessoas;
        double porcentagemIdoso = ((double) idoso/totalPessoas)*100;

        return String.format(Locale.US, "%.2f %d %.2f%%",mediaIdade,maiorIdade, porcentagemIdoso);
    }
}
