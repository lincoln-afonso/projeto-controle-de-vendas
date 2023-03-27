package app;

import java.util.Comparator;

public class ComparatoNota implements Comparator<NotaFiscal> {

    @Override
    public int compare(NotaFiscal nf1, NotaFiscal nf2) {
        return nf1.getDataEmissao().compareTo(nf2.getDataEmissao());
    }

}