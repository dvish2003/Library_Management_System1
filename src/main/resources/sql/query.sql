`-- Create the library database
CREATE DATABASE library_management;
USE library_management;

-- create the book_categories table
CREATE TABLE book_categories (
                                 category_id INT AUTO_INCREMENT PRIMARY KEY,
                                 category_name VARCHAR(100) NOT NULL
);

-- Create the books table
CREATE TABLE books (
                       book_id INT AUTO_INCREMENT PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       edition VARCHAR(50),
                       language VARCHAR(50),
                       available_copies INT DEFAULT 1,
                       shelf_location VARCHAR(50),
                       category_id INT,
                       FOREIGN KEY (category_id) REFERENCES book_categories(category_id)
);

-- Create the members table
CREATE TABLE members (
                         member_id INT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(100) NOT NULL,
                         email VARCHAR(255) UNIQUE NOT NULL,
                         phone_number VARCHAR(15),
                         address VARCHAR(255),
                         date_of_birth DATE,
                         join_date DATE NOT NULL,
                         membership_type VARCHAR(50)
);

-- Create the borrowing_transactions table
CREATE TABLE borrowing_transactions (
                                        transaction_id INT AUTO_INCREMENT PRIMARY KEY,
                                        book_id INT,
                                        FOREIGN KEY (book_id) REFERENCES books(book_id),
                                        member_id INT,
                                        FOREIGN KEY (member_id) REFERENCES members(member_id),
                                        borrow_date DATE NOT NULL,
                                        due_date DATE NOT NULL
);`