CREATE TABLE users (
  id INTEGER PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  name VARCHAR(30),
  email  VARCHAR(50),
  birthday DATE
);

CREATE TABLE tickets (
  id INTEGER PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  event_id INTEGER,
  auditorium_name VARCHAR(50),
  user_id INTEGER ,
  seat_number INTEGER,
  show_date DATE,
  lucky BOOLEAN
);

CREATE TABLE event_show(
  id INTEGER PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  event_id INTEGER,
  auditorium_name VARCHAR(50),
  show_date DATE
);

CREATE TABLE events(
  id INTEGER PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  name VARCHAR(50),
  baseprice INTEGER,
  rating VARCHAR(50)
);

CREATE TABLE counters(
  name VARCHAR(200),
  counter_value INTEGER
);



