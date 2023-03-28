package app;

import java.util.Comparator;

public class ComparatoNota implements Comparator<NotaFiscal> {

    @Override
    public int compare(NotaFiscal nf1, NotaFiscal nf2) {
        if (nf1.getValor() < nf2.getValor()) {
            System.out.println("nf1 maior que nf2");
            return -1;
        }
        else if (nf1.getValor() > nf2.getValor()) {
            System.out.println("nf1 menor que nf2");
            return 1;
        }
        return 0;
    }



}