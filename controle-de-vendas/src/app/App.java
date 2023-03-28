package app;

import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/*
 * Controle de vendas
 * Considere uma estrutura de dados para representar uma venda:*
 * • Número da Nota Fiscal
 * • Série da Nota fiscal
 * • Valor total da Nota Fiscal
 * • Data da emissão da Nota Fiscal
 * • Data da recepção das mercadorias pelo cliente
 * O programa deverá fornecer as seguintes funcionalidades:
 * a) Lançar os dados de vendas.
 * b) Pesquisar por uma venda a partir do número da nota fiscal.
 * c) Listar todas as vendas.
 * d) Total das vendas realizadas em um determinado mês.
 * e) Valor médio das vendas.
 */
public class App implements Venda {
    private Scanner leia;

    public App() {
        this.leia = new Scanner(System.in);
    }

    public Scanner getLeia() {
        return this.leia;
    }

    @Override
    public boolean cadastrarVenda(Set<NotaFiscal> setNotasFiscais) {
        NotaFiscal nf = new NotaFiscal();
        boolean eValido;
        String serieNotaFiscal;
        String numeroNotaFiscal;
        String valorNota;
        String dataEmissao;
        String dataRecepcao;
       
        do {
            eValido = false;
            try {
                System.out.print("Número da nota: ");
                numeroNotaFiscal = this.getLeia().nextLine();
                nf.setNumeroNotaFiscal(numeroNotaFiscal);

                eValido = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (eValido == false);

        do {
            eValido = false;
            try {
                System.out.print("Série da nota: ");
                serieNotaFiscal = this.getLeia().nextLine();
                nf.setSerieNotaFiscal(serieNotaFiscal);

                eValido = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (eValido == false);


        do {
            eValido = false;
            try {
                System.out.print("Data de emissão: ");
                dataEmissao = this.getLeia().nextLine();
                nf.setDataEmissao(dataEmissao);

                eValido = true;
            } catch (Exception e) {
                System.out.println("Data inválida: " + e.getMessage());
            }
        } while (eValido == false);

        do {
            eValido = false;
            try {
                System.out.print("Data de recepção: ");
                dataRecepcao = this.getLeia().nextLine();
                nf.setDataRecepcao(dataRecepcao);

                eValido = true;
            } catch (Exception e) {
                System.out.println("Data inválida: " + e.getMessage());
            }
        } while (eValido == false);

        do {
            eValido = false;
            try {
                System.out.print("Valor: ");
                valorNota = this.getLeia().nextLine();
                nf.setValor(valorNota);

                eValido = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (eValido == false);


        return setNotasFiscais.add(nf);
    }

    @Override
    public NotaFiscal pesquisarVenda(Set<NotaFiscal> setNotasFiscais) {
        NotaFiscal nf = new NotaFiscal();
        String numeroNotaFiscal;
        int posicao;
        List<NotaFiscal> listNotasFiscais = new ArrayList<>();

        listNotasFiscais.addAll(setNotasFiscais);

        do {
            try {
                System.out.print("Informe o número da nota fiscal: ");
                numeroNotaFiscal = this.getLeia().nextLine();
                nf.setNumeroNotaFiscal(numeroNotaFiscal);

                posicao = listNotasFiscais.indexOf(nf);
                if (posicao >= 0) 
                    return listNotasFiscais.get(posicao);
                else
                    return null;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    private int validarMes(String mes) throws Exception {
        int numeroMes = 0;

        numeroMes = Integer.parseInt(mes);
        if (numeroMes < 1 || numeroMes > 12)
            throw new Exception("Mês inválido!");
        return numeroMes;
    }

    @Override
    public double calcularTotalVendasMes(Set<NotaFiscal> setNotasFiscais) {
        String mes = "";
        int valorTotal = 0;
        NotaFiscal nf;
        boolean eValido = false;

        do {
            try {
                System.out.print("Informe o número do mês desejado: ");
                mes = this.getLeia().nextLine();

                this.validarMes(mes);
                Iterator<NotaFiscal> notaFiscal = setNotasFiscais.iterator();
                while (notaFiscal.hasNext()) {
                    nf = notaFiscal.next();
                    if (nf.getDataEmissao().getMonth().equals(Month.of(Integer.parseInt(mes))))
                        valorTotal += nf.getValor();
                }
                eValido = true;
            } catch (NumberFormatException e) {
                System.out.println("Informe um número inteiro correspondente ao mês!\n");
            } catch (Exception e) {
                System.out.println(e.getMessage() + "\n");
            } 
        } while (eValido == false);
        return valorTotal;
    }

    @Override
    public boolean listarVendas(Set<NotaFiscal> setNotasFiscais) {
        NotaFiscal nfl;

        if (setNotasFiscais.size() > 0) {
            Set<NotaFiscal> treeSetNotasFiscais = new TreeSet<>(new ComparatoNota());
            treeSetNotasFiscais.addAll(setNotasFiscais);

            Iterator<NotaFiscal> venda = treeSetNotasFiscais.iterator();
            System.out.println("Nº NOTA \tN° SERIE \t DATA EMISSAO \t DATA RECEPCAO \t VALOR");
            while (venda.hasNext()) {
                nfl = venda.next();
                System.out.print(nfl.getNumeroNotaFiscal() + "\t\t" + nfl.getSerieNotaFiscal() + " \t\t" + nfl.getDataEmissao());
                System.out.println("\t" +nfl.getDataRecepcao() + "\t R$ " + nfl.getValor());
            }
            return true;
        }
        System.out.println();
        return false;
    }

    @Override
    public double calcularValorMedioVendas(Set<NotaFiscal> setNotasFiscais) {
        double valorTotal = 0;
        double valorMedio = 0;
        NotaFiscal nf;

        Iterator<NotaFiscal> notaFiscal = setNotasFiscais.iterator();
        while (notaFiscal.hasNext()) {
            nf = notaFiscal.next();
            valorTotal += nf.getValor();
        }
        valorMedio = valorTotal / setNotasFiscais.size();
        return valorMedio;
    }

    public static void main(String[] args) throws Exception {
        String opcao = "";
        App app = new App();
        Set<NotaFiscal> setNotasFiscais = new HashSet<>();
        
        do {
            Menu.exibirPergunta();
            opcao = app.getLeia().nextLine();

            switch (opcao) {
            case "1":
                if (app.cadastrarVenda(setNotasFiscais) == true)
                    System.out.println("Venda cadastrada!");
                else
                    System.out.println("A nota fiscal informda já se encontra cadastrada!");
                break;
               
            
                case "2":
                NotaFiscal nf;
                List<NotaFiscal> listNotasFiscais = new ArrayList<>();

                nf = app.pesquisarVenda(setNotasFiscais);

                listNotasFiscais.addAll(setNotasFiscais);
                Collections.sort(listNotasFiscais, new ComparatoNota());
                if (nf != null) {
                    System.out.println("Nº NOTA FISCAL: " + nf.getNumeroNotaFiscal());
                    System.out.println("Nº SERIE: " + nf.getSerieNotaFiscal());
                    System.out.println("DATA RECEPCAO \t DATA EMISSAO \t VALOR");
                    System.out.println(nf.getDataRecepcao() + "\t" + nf.getDataEmissao() + "\t" + nf.getValor() + "\n");
                }
                else 
                    System.out.println("Nota fiscal não encontrada!\n");
                break;

            case "3":
                if (!app.listarVendas(setNotasFiscais))
                    System.out.println("Não há vendas cadastradas!\n");
                break;

            case "4":
                System.out.println("Total de vendas do mês informado: R$ " + app.calcularTotalVendasMes(setNotasFiscais) + "\n");
                break;

            case "5":
                System.out.println("Valor médio das vendas: R$ " + app.calcularValorMedioVendas(setNotasFiscais) + "\n");
                break;

            case "6":
                System.out.println("Programa encerrado!\n");
                break;

            default:
                System.out.println("Opção inválida!");
                break;
            }
        } while (!opcao.equals("6"));

    }
}