package com.example.library;

import java.util.List;

/**
 * Демонстрационное консольное приложение для работы с библиотеками.
 * <p>
 * Создаёт несколько объектов {@link Library} и {@link DigitalLibrary},
 * наполняет их книгами {@link Book}, выполняет поиск книг по автору
 * и выводит полную информацию по всем книгам каждой библиотеки.
 * </p>
 *
 * @author Student
 * @version 1.0
 * @see Library
 * @see DigitalLibrary
 * @see Book
 */
public class App {

    /**
     * Конструктор по умолчанию.
     * <p>
     * Создаёт экземпляр приложения. Класс не хранит состояния,
     * поэтому все методы демонстрации объявлены статическими.
     * </p>
     */
    public App() {
        // Конструктор намеренно оставлен пустым
    }

    /**
     * Точка входа в приложение.
     * <p>
     * Последовательно выполняет следующие шаги:
     * <ol>
     *     <li>Создаёт три библиотеки: городскую, школьную и цифровую.</li>
     *     <li>Добавляет в каждую из них несколько книг.</li>
     *     <li>Ищет и выводит книги заданного автора
     *         из каждой библиотеки.</li>
     *     <li>Выводит полную информацию обо всех книгах
     *         каждой библиотеки.</li>
     * </ol>
     * </p>
     *
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        // Создание библиотек
        Library cityLibrary = new Library("Городская библиотека №1");
        Library schoolLibrary = new Library("Школьная библиотека");
        DigitalLibrary digitalLibrary =
                new DigitalLibrary("Национальная электронная библиотека",
                        "https://example.com/elib");

        // Добавление книг в первую библиотеку
        cityLibrary.addBook(new Book("Война и мир", "Лев Толстой", 1869));
        cityLibrary.addBook(new Book("Анна Каренина", "Лев Толстой", 1877));
        cityLibrary.addBook(new Book("Преступление и наказание", "Фёдор Достоевский", 1866));
        cityLibrary.addBook(new Book("Мастер и Маргарита", "Михаил Булгаков", 1967));

        // Добавление книг во вторую библиотеку
        schoolLibrary.addBook(new Book("Детство", "Лев Толстой", 1852));
        schoolLibrary.addBook(new Book("Мёртвые души", "Николай Гоголь", 1842));
        schoolLibrary.addBook(new Book("Отцы и дети", "Иван Тургенев", 1862));

        // Добавление книг в цифровую библиотеку
        digitalLibrary.addBook(new Book("1984", "Джордж Оруэлл", 1949));
        digitalLibrary.addBook(new Book("Скотный двор", "Джордж Оруэлл", 1945));

        // 1. Вывод всех книг одного автора из каждой библиотеки
        String targetAuthor = "Лев Толстой";
        System.out.println("### Поиск книг автора: " + targetAuthor + " ###\n");

        printBooksByAuthor(cityLibrary, targetAuthor);
        printBooksByAuthor(schoolLibrary, targetAuthor);
        printBooksByAuthor(digitalLibrary, targetAuthor);

        System.out.println();

        // 2. Вывод всей информации по каждой книге в каждой библиотеке
        System.out.println("### Полная информация по всем книгам ###\n");
        cityLibrary.printAllBooks();
        System.out.println();
        schoolLibrary.printAllBooks();
        System.out.println();
        digitalLibrary.printInfo();
    }

    /**
     * Выводит книги заданного автора из указанной библиотеки.
     * <p>
     * Если книг указанного автора в библиотеке нет, выводится
     * соответствующее сообщение. Поиск выполняется без учёта регистра.
     * </p>
     *
     * @param library библиотека, в которой выполняется поиск
     * @param author  имя автора, по которому выполняется поиск
     */
    private static void printBooksByAuthor(Library library, String author) {
        List<Book> found = library.findBooksByAuthor(author);
        System.out.println("Библиотека \"" + library.getName() + "\":");
        if (found.isEmpty()) {
            System.out.println("  Книг автора \"" + author + "\" не найдено.");
        } else {
            found.forEach(b -> System.out.println("  " + b));
        }
        System.out.println();
    }
}