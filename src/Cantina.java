import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
public class Cantina {
    public static void main(String[] args){
        String nome = JOptionPane.showInputDialog(null,
                "Informe o nome do cliente: ", "Nome"
                , JOptionPane.PLAIN_MESSAGE);
        String massaNome = JOptionPane.showInputDialog(null, "Informe
                o nome da massa: ", "Massa"
                , JOptionPane.PLAIN_MESSAGE);
        double valor =
                Double.parseDouble(JOptionPane.showInputDialog(null, "Informe o valor
                        da massa: "
                , "Massa", JOptionPane.PLAIN_MESSAGE));
        Cliente c = new Cliente();
        c.setNome(nome);
        Massa m = new Massa();
        m.setTipo(massaNome);
        m.setValor(valor);
        List<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
        int opcao = 0;
        Ingrediente i;
        while (opcao != 5) {
            String opcaoStr = JOptionPane.showInputDialog(null,
                    "Informe os ingredientes escolhidos: \n1 -
                    Bacon\n2 - Mussarela\n3 - Tomate\n4 - Queijo\n5 - Sair"
                    , "Ingredientes: ", JOptionPane.PLAIN_MESSAGE);
            opcao = Integer.parseInt(opcaoStr);
            switch (opcao) {
                case 1:
                    i = new Ingrediente();
                    i.setNome("Bacon");
                    ingredientes.add(i);
                    break;
                case 2:
                    i = new Ingrediente();
                    i.setNome("Mussarela");
                    ingredientes.add(i);
                    break;
                case 3:
                    i = new Ingrediente();
                    i.setNome("Tomate");
                    ingredientes.add(i);
                    break;
                case 4:
                    i = new Ingrediente();
                    i.setNome("Queijo");
                    ingredientes.add(i);
                    break;
                case 5:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Número
                            inválido", "Valor do pedido:"
                        , JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }
        Pedido pedido = new Pedido();
        pedido.setCliente(c);
        pedido.setMassa(m);
        pedido.setIngredientes(ingredientes);
        String mensagem = "Pedido feito para " +
                pedido.getCliente().getNome() + "!\n" +
                pedido.getMassa().getTipo() + " com ";
        if (pedido.getIngredientes().size() > 0) {
            for (int a = 0; a < pedido.getIngredientes().size(); a++)
            {
                mensagem += pedido.getIngredientes().get(a).getNome();
                if (a < pedido.getIngredientes().size() - 2) {
                    mensagem += ", ";
                } else
                    mensagem += " e ";
            }
        } else
            mensagem += "nenhum acréscimo e";
        mensagem += " \no valor ficou em: R$" + String.format("%.2f",
                pedido.CalculaValor()) + " reais";
        JOptionPane.showMessageDialog(null, mensagem, "Valor do
                pedido:", JOptionPane.PLAIN_MESSAGE);
    }
}