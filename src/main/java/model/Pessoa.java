package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Pessoa {
    private String nome;
    private LocalDate dtNascimento;

    public Pessoa(String nome, LocalDate dtNascimento) {
        this.nome = nome;
        this.dtNascimento = dtNascimento;
    }

    @Override
    public String toString() {
        return "nome=" + nome +
                ", dtNascimento=" + dtNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(nome, pessoa.nome) && Objects.equals(dtNascimento, pessoa.dtNascimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, dtNascimento);
    }

    public LocalDate getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(LocalDate dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
