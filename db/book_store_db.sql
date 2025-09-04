USE book_store_db;

SHOW tables;

SELECT * FROM book;

ALTER TABLE book 
MODIFY COLUMN author VARCHAR(255) AFTER book_name;

ALTER TABLE book
MODIFY COLUMN price DECIMAL(10,2) AFTER author;

INSERT INTO book (book_name, author, price, existence) VALUES ("Dune", "Frank Herbert", 15, 10);
INSERT INTO book (book_name, author, price, existence) VALUES ("1984", "George Orwell", 12, 8);
INSERT INTO book (book_name, author, price, existence) VALUES ("Brave New World", "Aldous Huxley", 14, 6);
INSERT INTO book (book_name, author, price, existence) VALUES ("Fahrenheit 451", "Ray Bradbury", 11, 7);
INSERT INTO book (book_name, author, price, existence) VALUES ("The Hobbit", "J.R.R. Tolkien", 18, 12);
INSERT INTO book (book_name, author, price, existence) VALUES ("The Lord of the Rings", "J.R.R. Tolkien", 25, 5);
INSERT INTO book (book_name, author, price, existence) VALUES ("The Silmarillion", "J.R.R. Tolkien", 20, 4);
INSERT INTO book (book_name, author, price, existence) VALUES ("The Catcher in the Rye", "J.D. Salinger", 13, 9);
INSERT INTO book (book_name, author, price, existence) VALUES ("To Kill a Mockingbird", "Harper Lee", 16, 10);
INSERT INTO book (book_name, author, price, existence) VALUES ("Moby Dick", "Herman Melville", 17, 3);
INSERT INTO book (book_name, author, price, existence) VALUES ("War and Peace", "Leo Tolstoy", 22, 2);
INSERT INTO book (book_name, author, price, existence) VALUES ("Crime and Punishment", "Fyodor Dostoevsky", 19, 4);
INSERT INTO book (book_name, author, price, existence) VALUES ("The Brothers Karamazov", "Fyodor Dostoevsky", 21, 3);
INSERT INTO book (book_name, author, price, existence) VALUES ("The Great Gatsby", "F. Scott Fitzgerald", 15, 11);
INSERT INTO book (book_name, author, price, existence) VALUES ("Animal Farm", "George Orwell", 10, 14);
INSERT INTO book (book_name, author, price, existence) VALUES ("The Alchemist", "Paulo Coelho", 12, 10);
INSERT INTO book (book_name, author, price, existence) VALUES ("Don Quixote", "Miguel de Cervantes", 23, 6);
INSERT INTO book (book_name, author, price, existence) VALUES ("Dracula", "Bram Stoker", 14, 7);
INSERT INTO book (book_name, author, price, existence) VALUES ("Frankenstein", "Mary Shelley", 13, 8);
INSERT INTO book (book_name, author, price, existence) VALUES ("The Odyssey", "Homer", 20, 5);

