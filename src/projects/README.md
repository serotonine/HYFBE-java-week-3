# 📝 Projects ideas for Week 3

1. **Library Management System** 📚

    * Classes: `Library`, `Book`, `Member` (with `StudentMember`, `TeacherMember`).
    * Use **composition** (`Library HAS-A List<Book>`).
    * Store books in a `Map<ISBN, Book>`.
    * Features: add/remove books, search by title, list members.

---

2. **Banking Application** 💰

    * Classes: `BankAccount`, `CheckingAccount`, `SavingsAccount`.
    * Use **inheritance** for account types.
    * **Encapsulation** for balance (private + getters/setters).
    * Store accounts in a `Map<String, BankAccount>`.

---

3. **Student Management System** 🎓

    * Classes: `Student`, `Course`, `Teacher`.
    * A `Course` **HAS-A List<Student>`.
    * Store students in a `List<Student>`.
    * Features: enroll students, calculate GPA, print course rosters.

---

4. **E-Commerce Shopping Cart** 🛒

    * Classes: `Product`, `Cart`, `User`.
    * A `Cart` **HAS-A List<Product>`.
    * Use `Map<Product, Integer>` for product quantities.
    * Features: add/remove products, calculate total price.

---

5. **Zoo Management System** 🦁🐒🐧

    * Abstract class: `Animal` (method `makeSound()`).
    * Subclasses: `Lion`, `Monkey`, `Penguin`.
    * Store animals in a `List<Animal>` (demonstrating **polymorphism**).
    * Features: eat animals, display zoo inventory.

---

6. **Library of Music / Playlist Manager** 🎵

    * Classes: `Song`, `Playlist`, `Artist`.
    * A `Playlist` **HAS-A List<Song>`.
    * Use `List<String>`. check if the List contains a song before adding.
    * Features: add/remove songs, shuffle playlist.

---

7. **Employee Management System** 🏢

    * Abstract class: `Employee` (fields: name, salary).
    * Subclasses: `Developer`, `Manager`.
    * Store employees in a `List<Employee>`.
    * Features: print payroll, give raises, list managers separately.

---

8. **Library of Movies (Movie Catalog)** 🎬

    * Classes: `Movie`, `Actor`, `Director`.
    * Store movies in a `Map<String, Movie>` (key = movie title).
    * Features: add movies, search by genre, list movies by actor.

---

9. **Online Quiz System** ❓

    * Classes: `Question`, `ChoiceQuestion`, `TrueFalseQuestion`.
    * Store questions in a `List<Question>`.
    * Use **polymorphism**: `displayQuestion()` overridden in each subclass.
    * Features: ask questions, check answers, calculate score.

---

10. **School Library Borrowing System** 🏫

* Classes: `Book`, `Student`, `Teacher`, `Loan`.
* A `Loan` **HAS-A Book and Member**.
* Use a `Map<Member, List<Book>>` to track who borrowed what.
* Features: borrow/return books, list borrowed books by member.

---


1st project: ISBN can be String
3rd project: no calculation of GPA, print course students
4rd project: Cart doesn't have a list, only Map
5th project: instead of feedAnimals, 'eat' is better.
6th project: keep the whole music list, not a top 10 algorithm :)