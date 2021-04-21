INSERT INTO public.author(name) VALUES
    ('J. R. R. Tolkien'),
    ('Henry Fielding'),
    ('Jane Austen'),
    ('Marie-Henri Beyle'),
    ('Honoré de Balzac'),
    ('Charles Dickens'),
    ('Gustave Flaubert'),
    ('Herman Melville'),
    ('Emily Brontë'),
    ('Fyodor Mikhailovich Dostoevsky'),
    ('Lev Nikolayevich Tolstoy');

INSERT INTO public.book(description, genre, name) VALUES
    ('description...', 'FANTASY', 'The Lord of the Rings'),
    (NULL, 'FANTASY', 'The Hobbit, or There and Back Again'),
    ('description...', 'NOVEL', 'The History of Tom Jones, a Foundling'),
    (NULL, 'NOVEL', 'Pride and Prejudice, or There and Back Again'),
    ('description...', 'NOVEL', 'The Red and the Black'),
    (NULL, 'NOVEL', 'Father Goriot'),
    ('description...', 'NOVEL', 'David Copperfield'),
    (NULL, 'NOVEL', 'Madame Bovary'),
    ('description...', 'ADVENTURE', 'Moby-Dick'),
    (NULL, 'TRAGEDY', 'Wuthering Heights'),
    ('description...', 'NOVEL', 'The Brothers Karamazov'),
    (NULL, 'NOVEL', 'War and Peace');


INSERT INTO public.book_authors(book_id, author_id) VALUES
    (1, 1),
    (2, 1),
    (3, 2),
    (4, 3),
    (5, 4),
    (6, 5),
    (7, 6),
    (8, 7),
    (9, 8),
    (10, 9),
    (11, 10),
    (12, 11);

INSERT INTO public."user"(name, type) VALUES
    ('User1', 'USER'),
    ('User2', 'USER'),
    ('User3', 'USER'),
    ('User4', 'USER'),
    ('User5', 'USER'),
    ('User6', 'USER'),
    ('User7', 'USER'),
    ('Admin', 'ADMIN');

INSERT INTO public.review(text, book_id, user_id) VALUES
    ('My favorite book!', 1, 1),
    ('I love it!', 2, 1),
    ('Hate it!', 1, 3),
    ('My favorite book!', 5, 5),
    ('I love it!', 7, 7),
    ('Hate it!', 4, 3),
    ('My favorite book!', 11, 6),
    ('I love it!', 12, 5),
    ('Hate it!', 8, 4);