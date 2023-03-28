package app;

public class Menu {
    private static void exibirOpcoes() {
        System.out.println("\n________MENU________");
        System.out.println("1 - Cadastrar venda");
        System.out.println("2 - Pesquisar venda");
        System.out.println("3 - Listar vendas");
        System.out.println("4 - Total de vendas de um determinado mês");
        System.out.println("5 - Valor médio das vendas");
        System.out.println("6 - Encerrar\n");
    }

    public static void exibirPergunta() {
        Menu.exibirOpcoes();
        System.out.print("Informe o número correspondente a opção desejada: ");
    }
}