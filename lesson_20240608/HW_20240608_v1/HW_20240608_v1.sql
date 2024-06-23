CREATE DATABASE apiBd;
USE apiBd;

CREATE TABLE books (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    writer VARCHAR(255) NOT NULL
);

INSERT INTO books (name, writer)
VALUES
    ('The Enigma of Epsilon', 'J. K. Thorn'),
    ('Midnight Chronicles', 'L. R. Winter'),
    ('Echoes of Atlantis', 'S. M. Rivers'),
    ('Sapphire Skies', 'A. B. Stone'),
    ('Whispering Shadows', 'E. D. Frost'),
    ('Crimson Moon', 'G. V. Nightshade'),
    ('Stardust Serenade', 'P. Q. Nova'),
    ('Eternal Ember', 'R. S. Blaze'),
    ('Azure Dreams', 'T. U. Ocean'),
    ('Silent Nebula', 'V. W. Starling');
    
-- DROP TABLE books;
-- SELECT * FROM books;
-- TRUNCATE books;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    apiKey VARCHAR(8) NOT NULL
);

-- DROP TABLE users;
-- SELECT * FROM users;
-- TRUNCATE users;