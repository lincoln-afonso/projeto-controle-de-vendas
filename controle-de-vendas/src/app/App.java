package app;

import br.com.dominio.NotaFiscal;
/*
 * Controle de vendas
 * Considere uma estrutura de dados para representar uma venda:*
 * • Número da Nota Fiscal
 * • Série da Nota fiscal
 * • Valor total da Nota Fiscal
 * • Data da emissão da Nota Fiscal
 * • Data da recepção das mercadorias pelo cliente
 * O programa deverá fornecer as seguintes funcionalidades:
 * a) Lançar os dados de, no máximo, 100 vendas.
 * b) Pesquisar por uma venda a partir do número da nota fiscal.
 * c) Listar as vendas realizadas em uma determinada data.
 * d) Total das vendas realizadas em um determinado mês.
 * e) Valor médio das vendas.
 */
public class App {
    public static void main(String[] args) throws Exception {
        NotaFiscal nf = new NotaFiscal();

        nf.setDataEmissao("12/12/2000");
        System.out.println(nf);
    }
}