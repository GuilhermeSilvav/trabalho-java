package ClassePrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CatalogApp extends JFrame {

    private CatalogoLivro catalog;

    public CatalogApp() {
        super("Catalogador de Livros");

        // Inicializa o catálogo de livros
        catalog = new CatalogoLivro();

        // Configurações básicas do JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 300);
        setLocationRelativeTo(null); // Centraliza a janela na tela

        // Painel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10)); // Layout com 4 linhas, 1 coluna

        // Botões
        JButton btnAdicionarLivro = new JButton("Adicionar Livro");
        JButton btnBuscarLivro = new JButton("Buscar Livro");
        JButton btnListarLivros = new JButton("Listar Todos os Livros");
        JButton btnSair = new JButton("Sair");

        // Adiciona os botões ao painel
        panel.add(btnAdicionarLivro);
        panel.add(btnBuscarLivro);
        panel.add(btnListarLivros);
        panel.add(btnSair);

        // Adiciona o painel ao JFrame
        add(panel);

        // Configura ações para os botões
        btnAdicionarLivro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                catalog.addLivro();
            }
        });

        btnBuscarLivro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                catalog.pesquisaIsbn();
            }
        });

        btnListarLivros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                catalog.listaLivros();
            }
        });

        btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Exibe o JFrame
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CatalogApp();
            }
        });
    }
}
