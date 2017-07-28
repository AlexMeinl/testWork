DROP TABLE IF EXISTS restaurant;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 1;

CREATE TABLE restaurant
(
  id         SERIAL,
  name       VARCHAR NOT NULL
)
