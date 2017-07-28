DELETE FROM restaurant;

ALTER SEQUENCE global_seq RESTART WITH 1;

INSERT INTO restaurant (id, name) VALUES
  (0,'Admin'),
  (1, 'Astoria')


