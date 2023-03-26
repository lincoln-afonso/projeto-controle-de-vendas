package br.com.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class NotaFiscal {
    private String numeroNotaFiscal;
    private String serieNotaFiscal;
    private double valor;
    private LocalDate dataEmissao;
    private LocalDate dataRecepcao;

    public NotaFiscal() {
    }

    public NotaFiscal(String numeroNotaFiscal, String serieNotaFiscal, String valorNota, String dataEmissao,
            String dataRecepcao) throws Exception, Exception {
        this.setDataRecepcao(dataEmissao);
        this.setDataRecepcao(dataRecepcao);
        this.setNumeroNotaFiscal(numeroNotaFiscal);
        this.setSerieNotaFiscal(serieNotaFiscal);
        this.setValor(valorNota);
       
    }

    public String getNumeroNotaFiscal() {
        return numeroNotaFiscal;
    }

    public void setNumeroNotaFiscal(String numeroNotaFiscal) throws Exception {
        if (numeroNotaFiscal.isEmpty())
            throw new Exception("Número da nota não foi informado!");
        this.numeroNotaFiscal = numeroNotaFiscal;
    }

    public String getSerieNotaFiscal() {
        return serieNotaFiscal;
    }

    public void setSerieNotaFiscal(String serieNotaFiscal) throws Exception {
        if (serieNotaFiscal.isEmpty())
            throw new Exception("Série da nota não foi informado!");
        this.serieNotaFiscal = serieNotaFiscal;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(String valorNota) throws Exception {
        if (valorNota.isEmpty())
            throw new Exception("Valor inválido!");
        this.valor = Double.parseDouble(valorNota);
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(String data) {
        LocalDate dataEmissao = this.converterData(data);
        this.dataEmissao = dataEmissao;
    }

    public LocalDate getDataRecepcao() {
        return dataRecepcao;
    }

    public void setDataRecepcao(String data) {
        LocalDate dataRecepcao = this.converterData(data);
        this.dataRecepcao = dataRecepcao;
    }

    private LocalDate converterData(String data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataFormatada = LocalDate.parse(data, formatter);
        return dataFormatada;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((numeroNotaFiscal == null) ? 0 : numeroNotaFiscal.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        NotaFiscal other = (NotaFiscal) obj;
        if (numeroNotaFiscal == null) {
            if (other.numeroNotaFiscal != null)
                return false;
        } else if (!numeroNotaFiscal.equals(other.numeroNotaFiscal))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "NotaFiscal [dataEmissao=" + dataEmissao + ", dataRecepcao=" + dataRecepcao + ", numeroNotaFiscal="
                + numeroNotaFiscal + ", serieNotaFiscal=" + serieNotaFiscal + ", valor=" + valor + "]\n";
    }
    
    
}