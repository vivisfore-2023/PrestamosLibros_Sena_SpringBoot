package com.example.demo.Entidad;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="libro")
public class Libro {

    @Id
    @Column(length = 30)
    private String isbn;
    @Column(nullable = false,length = 50)
    private String titulo;
    @Column(nullable = false,length = 50)
    private String  autor;
    @Column(nullable = false,length = 50)
    private String editorial;
    @Column(name = "no_pag")
    private int no_pag;
    @Column(name = "imagen")
    private String imagen;

    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Prestamo> prestamo;

    public Libro(String isbn, String titulo, String autor, String editorial, int no_pag) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.no_pag = no_pag;
    }

    public Libro(String isbn, String titulo, String autor, String editorial, int no_pag, String imagen) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.no_pag = no_pag;
        this.imagen = imagen;
    }

    public Libro() {
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getNo_pag() {
        return no_pag;
    }

    public void setNo_pag(int no_pag) {
        this.no_pag = no_pag;
    }

    public Set<Prestamo> getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Set<Prestamo> prestamo) {
        this.prestamo = prestamo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "isbn='" + isbn + '\'' +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", editorial='" + editorial + '\'' +
                ", no_pag=" + no_pag +
                '}';
    }
}
