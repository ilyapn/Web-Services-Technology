DROP TABLE IF EXISTS people;

CREATE TABLE people (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  surname VARCHAR(100),
  name VARCHAR(100),
  patronymic VARCHAR(100),
  age INT,
  weight INT
);

INSERT INTO people (surname, name, patronymic, age, weight) VALUES
  ('иванов', 'иван', 'иванович', 10, 20),
  ('петров', 'петр', 'петрович', 20, 40),
  ('алексеев', 'алексей', 'алексеевич', 30, 80),
  ('ольгова', 'ольга', 'ольговна', 40, 160);