
import java.util.Scanner

class Book(
    var title: String = "",
    var author: String = "",
    var rating: Double = 0.0
)

fun addBook(books: MutableList<Book>, scanner: Scanner) {

    println("введите название книги:")
    val title = scanner.nextLine()

    println("введите автора:")
    val author = scanner.nextLine()

    println("введите рейтинг книги от 0 до 5:")
    val rating = scanner.nextDouble()
    scanner.nextLine()

    if (rating >= 0 && rating <= 5) {

        val book = Book().apply {
            this.title = title
            this.author = author
            this.rating = rating
        }

        books.add(book)

        println("книга добавлена")
    } else {
        println("рейтинг должен быть от 0 до 5")
    }
}

fun removeBook(books: MutableList<Book>, scanner: Scanner) {

    println("введите название книги для удаления:")
    val title = scanner.nextLine()

    val book = books.find { it.title == title }

    if (book != null) {
        book.also {
            books.remove(it)
        }

        println("книга удалена")
    } else {
        println("книга не найдена")
    }
}

fun searchBook(books: MutableList<Book>, scanner: Scanner) {

    println("введите название книги для поиска:")
    val title = scanner.nextLine()

    val foundBooks = books.filter { it.title == title }

    if (foundBooks.isEmpty()) {
        println("книга не найдена")
    } else {
        println("найденные книги:")

        for (book in foundBooks) {
            println("название: ${book.title}")
            println("автор: ${book.author}")
            println("рейтинг: ${book.rating}")
            println("--------------------")
        }
    }
}

fun printCatalog(books: MutableList<Book>) {

    books.run {
        if (isEmpty()) {
            println("библиотека пуста")
        } else {
            println("КАТАЛОГ")

            for (book in this) {
                println("название: ${book.title}")
                println("автор: ${book.author}")
                println("рейтинг: ${book.rating}")
                println("--------------------")
            }
        }
    }
}

fun averageRating(books: MutableList<Book>) {

    val average = with(books) {

        if (isEmpty()) {
            0.0
        } else {

            var totalRating = 0.0

            for (book in this) {
                totalRating += book.rating
            }

            totalRating / size
        }
    }

    println("средний рейтинг книг: $average")
}

fun main() {

    val scanner = Scanner(System.`in`)
    val books: MutableList<Book> = mutableListOf()

    var choice = -1

    while (choice != 0) {

        println()
        println("БИБЛИОТЕКА")
        println("1. добавить книгу")
        println("2. удалить книгу")
        println("3. найти книгу")
        println("4. показать каталог")
        println("5. средний рейтинг книг")
        println("0. выход")
        println("выберите действие:")

        choice = scanner.nextInt()
        scanner.nextLine()

        when (choice) {
            1 -> addBook(books, scanner)
            2 -> removeBook(books, scanner)
            3 -> searchBook(books, scanner)
            4 -> printCatalog(books)
            5 -> averageRating(books)
            0 -> println("выход из программы")
            else -> println("неверный выбор")
        }
    }
}
