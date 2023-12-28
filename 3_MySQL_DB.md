# Human Friends Database

Инструкции и SQL-скрипты для создания базы данных "Human Friends". Структура базы данных отражает иерархию классов животных, согласно ООП.

## Инструкции по настройке базы данных

Следующие SQL-команды описывают процесс создания базы данных, таблиц и их наполнения данными, а также преобразования данных в соответствии с заданными критериями.

```sql
-- Создание базы данных "Human Friends"
mysql -u vladimir -p

CREATE DATABASE HumanFriends;
USE HumanFriends;

-- Создание таблицы "Pets"
CREATE TABLE Pets (
    ID INT PRIMARY KEY,
    Name VARCHAR(255),
    Type ENUM('Dog', 'Cat', 'Hamster'),
    BirthDate DATE,
    Commands TEXT
);

-- Создание таблицы "PackAnimals"
CREATE TABLE PackAnimals (
    ID INT PRIMARY KEY,
    Name VARCHAR(255),
    Type ENUM('Horse', 'Camel', 'Donkey'),
    BirthDate DATE,
    Commands TEXT
);

-- Заполнение таблицы "Pets" данными
INSERT INTO Pets (ID, Name, Type, BirthDate, Commands) VALUES 
(1, 'Fido', 'Dog', '2020-01-01', 'Sit, Stay, Fetch'),
(2, 'Whiskers', 'Cat', '2019-05-15', 'Sit, Pounce'),
(3, 'Hammy', 'Hamster', '2021-03-10', 'Roll, Hide'),
(4, 'Buddy', 'Dog', '2018-12-10', 'Sit, Paw, Bark'),
(5, 'Smudge', 'Cat', '2020-02-20', 'Sit, Pounce, Scratch'),
(6, 'Peanut', 'Hamster', '2021-08-01', 'Roll, Spin'),
(7, 'Bella', 'Dog', '2019-11-11', 'Sit, Stay, Roll'),
(8, 'Oliver', 'Cat', '2020-06-30', 'Meow, Scratch, Jump');

-- Заполнение таблицы "PackAnimals" данными
INSERT INTO PackAnimals (ID, Name, Type, BirthDate, Commands) VALUES 
(1, 'Thunder', 'Horse', '2015-07-21', 'Trot, Canter, Gallop'),
(2, 'Sandy', 'Camel', '2016-11-03', 'Walk, Carry Load'),
(3, 'Eeyore', 'Donkey', '2017-09-18', 'Walk, Carry Load, Bray'),
(4, 'Storm', 'Horse', '2014-05-05', 'Trot, Canter'),
(5, 'Dune', 'Camel', '2018-12-12', 'Walk, Sit'),
(6, 'Burro', 'Donkey', '2019-01-23', 'Walk, Bray, Kick'),
(7, 'Blaze', 'Horse', '2016-02-29', 'Trot, Jump, Gallop'),
(8, 'Sahara', 'Camel', '2015-08-14', 'Walk, Run');

-- Удаление записей о верблюдах.
DELETE FROM PackAnimals WHERE Type = 'Camel';

-- Создание таблицы "HorsesAndDonkeys" из существующих записей лошадей и ослов
CREATE TABLE HorsesAndDonkeys AS
SELECT ID, Name, Type, BirthDate, Commands FROM PackAnimals 
WHERE Type IN ('Horse', 'Donkey');

-- Создание таблицы "YoungAnimals" для животных в возрасте от 1 до 3 лет
CREATE TABLE YoungAnimals AS
SELECT *, TIMESTAMPDIFF(MONTH, BirthDate, CURDATE()) AS AgeInMonths FROM (
    SELECT * FROM Pets
    UNION ALL
    SELECT * FROM PackAnimals
) AS Combined
WHERE TIMESTAMPDIFF(YEAR, BirthDate, CURDATE()) BETWEEN 1 AND 3;

-- Объединение всех таблиц с сохранением информации о принадлежности к исходным таблицам
CREATE TABLE AllAnimals AS
SELECT 'Pet' AS Source, ID, Name, Type, BirthDate, Commands FROM Pets
UNION ALL
SELECT 'PackAnimal' AS Source, ID, Name, Type, BirthDate, Commands FROM HorsesAndDonkeys
UNION ALL
SELECT 'YoungAnimal' AS Source, ID, Name, Type, BirthDate, Commands FROM YoungAnimals;

