Insert into library.reader (ID, SURNAME,NAME,PATRONYMIC,PHONE_NUMBER) values (1, "Иванов","Иван","Иванович","89091111111");
Insert into library.reader (ID, SURNAME,NAME,PATRONYMIC,PHONE_NUMBER) values (2, "Петров","Петр","Петрович","89091111122");
insert into library.author (ID, SURNAME, NAME, PATRONYMIC) values(1, "Толстой","Лев","Николаевич");
insert into library.author (ID, SURNAME, NAME) values(2, "Рэй","Брэдбери");
Insert into library.book (ID, TITLE, ISBN,ID_AUTHOR) values (1, "Война и мир", "978-5-9268-2585-2", 1);
Insert into library.book (ID, TITLE, ISBN,ID_AUTHOR) values (2, "Анна Каренина", "978-5-9268-2544-9", 1);
Insert into library.book (ID, TITLE, ISBN,ID_AUTHOR) values (3, "Вино из одуванчиков", "978-5-699-94693-8", 2);
Insert into library.book (ID, TITLE, ISBN,ID_AUTHOR) values (4, "451' по Фаренгейту", "978-5-04-104527-2", 2);
insert into library.issued_books (ID, ID_READER,ID_BOOK,ISSUE_DATE) values (1, 1,4,"2020-07-01 00:00:00");
insert into library.issued_books (ID, ID_READER,ID_BOOK,ISSUE_DATE) values (2, 2,1,"2020-07-01 00:00:00");
insert into library.issued_books (ID, ID_READER,ID_BOOK,ISSUE_DATE) values (3, 2,2,"2020-07-01 00:00:00");
insert into library.issued_books (ID,ID_READER,ID_BOOK,ISSUE_DATE) values (4,1,2,"2020-07-01 00:00:00");


