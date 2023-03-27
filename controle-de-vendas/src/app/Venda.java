package app;

import java.util.Set;

public interface Venda {
    public abstract boolean cadastrarVenda(Set<NotaFiscal> setNotasFiscais);

    public abstract NotaFiscal pesquisarVenda(Set<NotaFiscal> setNotasFiscais);

    public abstract int calcularTotalVendasMes(Set<NotaFiscal> setNotasFiscais);

    public abstract void listarVendas(Set<NotaFiscal> setNotasFiscais);

    public abstract double calcularValorMedioVendas(Set<NotaFiscal> setNotasFiscais);
}   