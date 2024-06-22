package ClassePrincipal;

import java.util.Date;

public class Livro {
    private String titulo;
    private String autor;
    private String isbn;
    private Date dataPublicacao;
    private int paginas;
    private String genero;
    private String editora;
    private boolean disponibilidade;

    public Livro(String titulo, String autor, String isbn, Date dataPublicacao, int paginas, String genero, String editora) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.paginas = paginas;
        this.genero = genero;
        this.editora = editora;
        this.disponibilidade = true; // Por padrão, o livro está disponível
    }

    // Getters e Setters para o atributo 'titulo'
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    // Getters e Setters para o atributo 'autor'
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    // Getters e Setters para o atributo 'isbn'
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    // Getters e Setters para o atributo 'dataPublicacao'
    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Date dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    // Getters e Setters para o atributo 'paginas'
    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    // Getters e Setters para o atributo 'genero'
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    // Getters e Setters para o atributo 'editora'
    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    // Getter e Setter para o atributo 'disponibilidade'
    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

	public static void add(Livro newLivro) {
		// TODO Auto-generated method stub
		
	}
}
