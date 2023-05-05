package model;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Objects;

public class Funcionario extends Pessoa{
    private BigDecimal salario;
    private String funcao;
    public Funcionario(String nome, LocalDate dtNascimento) {
        super(nome, dtNascimento);
    }

    public Funcionario(String nome, LocalDate dtNascimento, BigDecimal salario, String funcao) {
        super(nome, dtNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,###.00");
        return "Funcionario{" +
                "salario=" + df.format(salario) +
                ", funcao=" + funcao  +
                ", " + super.toString() + "} \n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Funcionario that = (Funcionario) o;
        return Objects.equals(salario, that.salario) && Objects.equals(funcao, that.funcao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), salario, funcao);
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
}
