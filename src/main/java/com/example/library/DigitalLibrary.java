package com.example.library;

import java.util.Objects;

/**
 * Класс, представляющий цифровую (электронную) библиотеку.
 * <p>
 * Расширяет {@link Library}, добавляя URL-адрес электронного ресурса.
 * Наследует все методы родительского класса: {@code addBook()},
 * {@code findBooksByAuthor()}, {@code printAllBooks()} и др.
 * </p>
 *
 * @author Student
 * @version 1.0
 * @see Library
 */
public class DigitalLibrary extends Library {

    /** URL-адрес электронной библиотеки. */
    private String url;

    /**
     * Конструктор по умолчанию.
     * <p>
     * Создаёт цифровую библиотеку без названия и без URL-адреса.
     * Коллекция книг инициализируется в родительском конструкторе.
     * </p>
     */
    public DigitalLibrary() {
        super();
    }

    /**
     * Создаёт цифровую библиотеку с заданными параметрами.
     *
     * @param name название библиотеки
     * @param url  URL-адрес электронного ресурса
     */
    public DigitalLibrary(String name, String url) {
        super(name);
        this.url = url;
    }

    /**
     * Возвращает URL-адрес библиотеки.
     *
     * @return URL-адрес электронного ресурса
     */
    public String getUrl() {
        return url;
    }

    /**
     * Устанавливает URL-адрес библиотеки.
     *
     * @param url URL-адрес электронного ресурса
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Выводит информацию о цифровой библиотеке.
     * <p>
     * Сначала печатается название и URL, затем — список всех книг
     * (через унаследованный метод {@link Library#printAllBooks()}).
     * </p>
     */
    public void printInfo() {
        System.out.println("Цифровая библиотека: " + getName() + " (" + url + ")");
        printAllBooks();
    }

    /**
     * Сравнивает цифровые библиотеки по названию, коллекции книг и URL-адресу.
     * <p>
     * Две цифровые библиотеки считаются равными, если совпадают
     * все три характеристики: название, коллекция книг и URL.
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

        // Проверка равенства родительской части (название + книги)
        if (!super.equals(o)) return false;

        // Приведение типа и сравнение URL
        DigitalLibrary that = (DigitalLibrary) o;
        return Objects.equals(url, that.url);
    }

    /**
     * Возвращает хэш-код цифровой библиотеки.
     * <p>
     * Хэш-код учитывает поля родительского класса и поле {@code url},
     * чтобы быть согласованным с реализацией {@link #equals(Object)}.
     * </p>
     *
     * @return хэш-код цифровой библиотеки
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), url);
    }

    /**
     * Возвращает строковое представление цифровой библиотеки.
     * <p>
     * Формат вывода:
     * {@code DigitalLibrary{name='<название>', url='<url>', books=<количество>}}.
     * </p>
     *
     * @return строка с названием, URL и количеством книг
     */
    @Override
    public String toString() {
        return String.format("DigitalLibrary{name='%s', url='%s', books=%d}",
                getName(), url, getBooks().size());
    }
}