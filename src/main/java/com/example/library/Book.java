package com.example.library;

import java.util.Objects;

/**
 * Класс, представляющий книгу.
 * <p>
 * Содержит основную информацию о книге: название, автора и год написания.
 * Экземпляры класса используются в коллекциях {@link Library}.
 * </p>
 *
 * @author Student
 * @version 1.0
 */
public class Book {

    /** Название книги. */
    private String title;

    /** Автор книги. */
    private String author;

    /** Год написания книги. */
    private int year;

    /**
     * Конструктор по умолчанию.
     * <p>
     * Создаёт пустой объект книги без заданных полей.
     * </p>
     */
    public Book() {
    }

    /**
     * Создаёт объект книги с заданными параметрами.
     *
     * @param title  название книги
     * @param author автор книги
     * @param year   год написания книги
     */
    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    /**
     * Возвращает название книги.
     *
     * @return название книги
     */
    public String getTitle() {
        return title;
    }

    /**
     * Устанавливает название книги.
     *
     * @param title название книги
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Возвращает автора книги.
     *
     * @return автор книги
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Устанавливает автора книги.
     *
     * @param author автор книги
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Возвращает год написания книги.
     *
     * @return год написания
     */
    public int getYear() {
        return year;
    }

    /**
     * Устанавливает год написания книги.
     *
     * @param year год написания
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Сравнивает книги по названию, автору и году написания.
     * <p>
     * Две книги считаются равными, если совпадают все три поля:
     * {@code title}, {@code author} и {@code year}.
     * </p>
     *
     * @param o объект для сравнения
     * @return {@code true}, если объекты равны; {@code false} — в противном случае
     */
    @Override
    public boolean equals(Object o) {
        // Проверка на сравнение объекта с самим собой
        if (this == o) return true;

        // Проверка на null и совпадение классов
        if (o == null || getClass() != o.getClass()) return false;

        // Приведение типа и сравнение всех значимых полей
        Book book = (Book) o;
        return year == book.year
                && Objects.equals(title, book.title)
                && Objects.equals(author, book.author);
    }

    /**
     * Возвращает хэш-код книги.
     * <p>
     * Хэш-код вычисляется на основе полей {@code title}, {@code author} и {@code year},
     * чтобы согласовать его с реализацией {@link #equals(Object)}.
     * </p>
     *
     * @return хэш-код книги
     */
    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }

    /**
     * Возвращает строковое представление книги.
     * <p>
     * Формат вывода: {@code Книга: "<название>", автор: <автор>, год: <год>}.
     * </p>
     *
     * @return строка с информацией о книге
     */
    @Override
    public String toString() {
        return String.format("Книга: \"%s\", автор: %s, год: %d",
                title, author, year);
    }
}