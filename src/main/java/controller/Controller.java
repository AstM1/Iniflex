package controller;

import model.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

public class Controller {
    private Collection<Funcionario> funcionarios;
    private Map<Object, List<Funcionario>> funcionariosAgrupados;

    public Collection<Funcionario> inserirFuncionarios() {
        try {
            this.funcionarios = new ArrayList<>();
            Funcionario f;
            f = new Funcionario("Maria", LocalDate.of(2000, 10, 18), BigDecimal.valueOf(2009.44), "Operador");
            this.funcionarios.add(f);
            f = new Funcionario("João", LocalDate.of(1990, 5, 12), BigDecimal.valueOf(2284.38), "Operador");
            this.funcionarios.add(f);
            f = new Funcionario("Caio", LocalDate.of(1961, 5, 2), BigDecimal.valueOf(9836.14), "Coordenador");
            this.funcionarios.add(f);
            f = new Funcionario("Miguel", LocalDate.of(1988, 10, 14), BigDecimal.valueOf(19119.88), "Diretor");
            this.funcionarios.add(f);
            f = new Funcionario("Alice", LocalDate.of(1995, 1, 5), BigDecimal.valueOf(2234.68), "Recepcionista");
            this.funcionarios.add(f);
            f = new Funcionario("Heitor", LocalDate.of(1999, 11, 19), BigDecimal.valueOf(1582.72), "Operador");
            this.funcionarios.add(f);
            f = new Funcionario("Arthur", LocalDate.of(1993, 3, 31), BigDecimal.valueOf(4071.84), "Contador");
            this.funcionarios.add(f);
            f = new Funcionario("Laura", LocalDate.of(1994, 7, 8), BigDecimal.valueOf(3017.45), "Gerente");
            this.funcionarios.add(f);
            f = new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), BigDecimal.valueOf(1606.85), "Eletricista");
            this.funcionarios.add(f);
            f = new Funcionario("Helena", LocalDate.of(1996, 9, 2), BigDecimal.valueOf(2799.93), "Gerente");
            this.funcionarios.add(f);
            return this.funcionarios;
        } catch (Exception e) {
            return null;
        }
    }

    public void imprimirFuncionario() {
        System.out.println("Lista de todos os funcionários: " + this.funcionarios.toString() + "\n\n\n");
    }

    public boolean aumentoDezPorCento() {
        try {
            BigDecimal dez = new BigDecimal("10.00");
            BigDecimal cem = new BigDecimal("100.00");
            this.funcionarios.forEach(funcionario -> funcionario.setSalario(
                    funcionario.getSalario().add(
                            funcionario.getSalario().multiply(dez).divide(cem))));
            System.out.println("Aumento de 10% no salário de cada funcionário realizado com sucesso! \n\n\n");
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean removerFuncionario(String nomeFuncionario) {
        try {
            if (nomeFuncionario == null || nomeFuncionario.trim().isEmpty()) {
                return false;
            }
            if (this.funcionarios.stream().anyMatch(funcionario -> funcionario.getNome().equals(nomeFuncionario))) {
                this.funcionarios.removeIf(funcionario -> funcionario.getNome().equals(nomeFuncionario));
                System.out.println("Funcionário de nome: " + nomeFuncionario + " Removido com sucesso! \n\n\n");
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public boolean agruparFuncionariosFuncao() {
        try {
            this.funcionariosAgrupados = funcionarios.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void imprimirFuncionariosAgrupados() {
        System.out.println("Funcionários agrupados pela função: " + this.funcionariosAgrupados + "\n\n\n");
    }

    public void imprimirFuncionariosMes() {
        try {
            System.out.println("Funcionários que fazem aniversário no Mês 10: ");
            System.out.println(this.funcionarios.stream().anyMatch(funcionario -> funcionario.getDtNascimento().getMonth().getValue() == 10) ?
                    this.funcionarios.stream().filter(funcionario -> funcionario.getDtNascimento().getMonth().getValue() == 10).
                            collect(Collectors.toList()).toString()
                    : "Não existem funcionários que fazem aniversário no mês 10");

            System.out.println("Funcionários que fazem aniversário no Mês 12: ");
            System.out.println((this.funcionarios.stream().anyMatch(funcionario -> funcionario.getDtNascimento().getMonth().getValue() == 12)) ?
                    this.funcionarios.stream().filter(funcionario -> funcionario.getDtNascimento().getMonth().getValue() == 12).
                            collect(Collectors.toList()).toString()
                    : "Não existem funcionários que fazem aniversário no mês 12\n\n\n");
        } catch (Exception ignored) {
        }
    }

    public void imprimirMaisIdoso() {
        try {
            LocalDate dataNascimento = LocalDate.now();
            String nome = "";
            for (Funcionario f : this.funcionarios) {
                if (f.getDtNascimento().isBefore(dataNascimento)) {
                    dataNascimento = f.getDtNascimento();
                    nome = f.getNome();
                }
            }
            System.out.println("O Mais Idoso é: " + nome + " Com a idade :" + Period.between(dataNascimento, LocalDate.now()).getYears());
        } catch (Exception ignored) {
        }
    }

    public void imprimirOrdemAlfabetica() {
        try {
            System.out.println("Funcionarios em ordem alfabetica: " + this.funcionarios.stream().
                    sorted((o1, o2) -> o1.getNome().compareTo(o2.getNome())).
                    collect(Collectors.toList()).toString() + "\n\n\n");
        } catch (Exception ignored) {
        }
    }

    public void imprimirTotalSalarios() {
        try {
            System.out.println("Soma dos Salarios dos Funcionarios: " + this.funcionarios.stream().
                    map(funcionario -> funcionario.getSalario()).
                    reduce(BigDecimal.ZERO, BigDecimal::add) + "\n\n\n");

        } catch (Exception ignored) {
        }
    }

    public void imprimirSalariosMinimos() {
        try {
            List<Integer> collect = this.funcionarios.stream().map(funcionario -> funcionario.getSalario().intValue() / 1212).collect(Collectors.toList());
            Object[] objects = this.funcionarios.toArray();
            System.out.println("Quantidade de salário minimo de cada Funcionario: ");
            for (int i = 0; i < collect.size(); i++) {
                System.out.println("O funcionário : " + objects[i].toString() + "Recebe: " + collect.get(i) + " Salarios mínimos de R$ 1.212,00 \n");
            }
        } catch (Exception ignored) {
        }
    }

    //GETTERS & SETTERS
    public Collection<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public Map<Object, List<Funcionario>> getFuncionariosAgrupados() {
        return funcionariosAgrupados;
    }

    public void setFuncionariosAgrupados(Map<Object, List<Funcionario>> funcionariosAgrupados) {
        this.funcionariosAgrupados = funcionariosAgrupados;
    }

    public void setFuncionarios(Collection<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
}
