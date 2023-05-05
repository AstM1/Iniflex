package org.example;

import controller.Controller;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        // 3.1 – Inserir todos os funcionários, na mesma ordem e informações da tabela acima.
        controller.inserirFuncionarios();

        //3.2 – Remover o funcionário “João” da lista.
        controller.removerFuncionario("João");

        /*3.3 – Imprimir todos os funcionários com todas suas informações, sendo que:
        • informação de data deve ser exibido no formato dd/mm/aaaa;
        • informação de valor numérico deve ser exibida no formatado com separador de milhar como ponto e decimal como vírgula.*/
        controller.imprimirFuncionario(); //essas formatações das informações foram feitas diretamente no metodo toString das entidades.


        //3.4 – Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor.
        controller.aumentoDezPorCento();

        //3.5 – Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”.
        controller.agruparFuncionariosFuncao();

        //3.6 – Imprimir os funcionários, agrupados por função.
        controller.imprimirFuncionariosAgrupados();

        //3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12.
        controller.imprimirFuncionariosMes();

        //3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.
        controller.imprimirMaisIdoso();

        //3.10 – Imprimir a lista de funcionários por ordem alfabética.
        controller.imprimirOrdemAlfabetica();

        //3.11 – Imprimir o total dos salários dos funcionários.
        controller.imprimirTotalSalarios();

        //3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.*/
        controller.imprimirSalariosMinimos();
    }
}