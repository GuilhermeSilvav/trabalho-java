package ClassePrincipal;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CatalogoLivro {
    private List<Livro> livros;
    private int totalLivros;
    private int livrosDisponiveis;

    public CatalogoLivro() {
        this.livros = new ArrayList<>();
        this.totalLivros = 0;
        this.livrosDisponiveis = 0;
    }

    public void addLivro() {
        String titulo = JOptionPane.showInputDialog("Digite o título do livro:");
        String autor = JOptionPane.showInputDialog("Digite o autor do livro:");
        String isbn = JOptionPane.showInputDialog("Digite o ISBN do livro:");
        String dataPublicacaoStr = JOptionPane.showInputDialog("Digite a data de publicação (dd/MM/yyyy):");
        String paginasStr = JOptionPane.showInputDialog("Digite o número de páginas:");
        String genero = JOptionPane.showInputDialog("Digite o gênero do livro:");
        String editora = JOptionPane.showInputDialog("Digite a editora do livro:");
        
        // Convertendo e validando a data de publicação e o número de páginas
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dataPublicacao;
        int paginas;
        try {
            dataPublicacao = dateFormat.parse(dataPublicacaoStr);
            paginas = Integer.parseInt(paginasStr);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Data de publicação inválida. Por favor, use o formato dd/MM/yyyy.");
            return;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Número de páginas inválido.");
            return;
        }

        // Criando o objeto livro e adicionando ao catálogo
        Livro newLivro = new Livro(titulo, autor, isbn, dataPublicacao, paginas, genero, editora);
        livros.add(newLivro); // Corrigido aqui para adicionar à lista 'livros'
        totalLivros++;
        livrosDisponiveis++;

        JOptionPane.showMessageDialog(null, "Livro adicionado com sucesso!");
    }

    public void listaLivros() {
        if (livros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum livro cadastrado.");
            return;
        }

        StringBuilder bookList = new StringBuilder("Lista de Todos os Livros:\n");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        for (Livro livro : livros) {
            bookList.append("Título: ").append(livro.getTitulo()).append("\n")
                    .append("Autor: ").append(livro.getAutor()).append("\n")
                    .append("ISBN: ").append(livro.getIsbn()).append("\n")
                    .append("Data de Publicação: ").append(dateFormat.format(livro.getDataPublicacao())).append("\n")
                    .append("Número de Páginas: ").append(livro.getPaginas()).append("\n")
                    .append("Gênero: ").append(livro.getGenero()).append("\n")
                    .append("Editora: ").append(livro.getEditora()).append("\n")
                    .append("Disponível: ").append(livro.isDisponibilidade() ? "Sim" : "Não").append("\n\n");
        }

        JTextArea textArea = new JTextArea(bookList.toString());
        textArea.setEditable(false);
        textArea.setForeground(Color.BLACK); // Cor do texto
        textArea.setBackground(Color.WHITE); // Cor de fundo
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(500, 400));
        
        JOptionPane.showMessageDialog(null, scrollPane, "Lista de Todos os Livros", JOptionPane.INFORMATION_MESSAGE);
    }

    public void pesquisaIsbn() {
        String isbn = JOptionPane.showInputDialog("Digite o ISBN do livro que deseja buscar:");
        for (Livro livro : livros) {
            if (livro.getIsbn().equals(isbn)) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String detalhesLivro = "Detalhes do Livro:\n"
                        + "Título: " + livro.getTitulo() + "\n"
                        + "Autor: " + livro.getAutor() + "\n"
                        + "ISBN: " + livro.getIsbn() + "\n"
                        + "Data de Publicação: " + dateFormat.format(livro.getDataPublicacao()) + "\n"
                        + "Número de Páginas: " + livro.getPaginas() + "\n"
                        + "Gênero: " + livro.getGenero() + "\n"
                        + "Editora: " + livro.getEditora() + "\n"
                        + "Disponível: " + (livro.isDisponibilidade() ? "Sim" : "Não");
                JOptionPane.showMessageDialog(null, detalhesLivro);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Livro não encontrado.");
    }
}
