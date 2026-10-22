package com.example.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Класс, представляющий библиотеку.
 * <p>
 * Библиотека содержит название и коллекцию книг, а также методы
 * для добавления книг, поиска по автору и вывода информации.
 * Экземпляры класса могут использоваться как самостоятельные объекты,
 * так и в качестве базового класса для наследников
 * (например, {@link DigitalLibrary}).
 * </p>
 *
 * @author Student
 * @version 1.0
 */
public class Library {

    /** Название библиотеки. */
    private String name;

    /** Коллекция книг, хранящихся в библиотеке. */
    private List<Book> books;

    /**
     * Конструктор по умолчанию.
     * <p>
     * Создаёт библиотеку без названия и с пустой коллекцией книг.
     * </p>
     */
    public Library() {
        this.books = new ArrayList<>();
    }

    /**
     * Создаёт библиотеку с заданным названием.
     * <p>
     * Коллекция книг инициализируется пустым списком.
     * </p>
     *
     * @param name название библиотеки
     */
    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    /**
     * Возвращает название библиотеки.
     *
     * @return название библиотеки
     */
    public String getName() {
        return name;
    }

    /**
     * Устанавливает название библиотеки.
     *
     * @param name название библиотеки
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Возвращает коллекцию книг библиотеки.
     * <p>
     * <b>Внимание:</b> возвращается ссылка на внутренний список,
     * поэтому изменения в возвращённой коллекции отразятся на состоянии библиотеки.
     * </p>
     *
     * @return список книг библиотеки
     */
    public List<Book> getBooks() {
        return books;
    }

    /**
     * Добавляет книгу в библиотеку.
     * <p>
     * Если передан {@code null}, книга не добавляется.
     * </p>
     *
     * @param book книга для добавления
     */
    public void addBook(Book book) {
        if (book != null) {
            books.add(book);
        }
    }

    /**
     * Находит все книги заданного автора.
     * <p>
     * Поиск выполняется без учёта регистра. Если автор не найден,
     * возвращается пустой список.
     * </p>
     *
     * @param author имя автора
     * @return список книг указанного автора; пустой список, если книг нет
     */
    public List<Book> findBooksByAuthor(String author) {
        return books.stream()
                .filter(b -> b.getAuthor() != null && b.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    /**
     * Выводит в консоль информацию обо всех книгах библиотеки.
     * <p>
     * Формат вывода:
     * <pre>
     * === Библиотека: &lt;название&gt; ===
     *   &lt;книга 1&gt;
     *   &lt;книга 2&gt;
     * </pre>
     * Если книг нет, выводится сообщение {@code (нет книг)}.
     * </p>
     */
    public void printAllBooks() {
        System.out.println("=== Библиотека: " + name + " ===");
        if (books.isEmpty()) {
            System.out.println("  (нет книг)");
        } else {
            books.forEach(b -> System.out.println("  " + b));
        }
    }

    /**
     * Сравнивает библиотеки по названию и коллекции книг.
     * <p>
     * Две библиотеки считаются равными, если совпадают название
     * и содержимое коллекции книг.
     * </p>
     *
     * @param o объект для сравнения
     * @return {@code true}, если объекты равны; {@code false} — в противном случае
     */
    @Override
    public boolean equals(Object o) {
        // Сравнение объекта с самим собой
        if (this == o) return true;

        // Проверка на null и совпадение классов
        if (o == null || getClass() != o.getClass()) return false;

        // Приведение типа и сравнение полей
        Library library = (Library) o;
        return Objects.equals(name, library.name)
                && Objects.equals(books, library.books);
    }

    /**
     * Возвращает хэш-код библиотеки.
     * <p>
     * Хэш-код вычисляется на основе названия и коллекции книг,
     * чтобы согласовать его с реализацией {@link #equals(Object)}.
     * </p>
     *
     * @return хэш-код библиотеки
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, books);
    }

    /**
     * Возвращает строковое представление библиотеки.
     * <p>
     * Формат вывода: {@code Library{name='<название>', books=<количество>}}.
     * </p>
     *
     * @return строка с названием библиотеки и количеством книг
     */
    @Override
    public String toString() {
        return String.format("Library{name='%s', books=%d}", name, books.size());
    }
}