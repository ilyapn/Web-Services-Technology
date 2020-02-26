DROP TABLE IF EXISTS people;

CREATE TABLE people (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  surname VARCHAR(100),
  name VARCHAR(100),
  patronymic VARCHAR(100),
  age INT,
  weight INT
);

INSERT INTO people (surname, name, patronymic, age, weight,id) VALUES
  ('иванов', 'иван', 'иванович', 10, 20,-4),
  ('петров', 'петр', 'петрович', 20, 40,-3),
  ('алексеев', 'алексей', 'алексеевич', 30, 80,-2),
  ('ольгова', 'ольга', 'ольговна', 40, 160,-1);