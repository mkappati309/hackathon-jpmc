DROP TABLE IF EXISTS billionaires;
CREATE TABLE balances (
  account VARCHAR(250) NOT NULL,
  balance NUMERIC(20, 2) NOT NULL,
  status VARCHAR(10) NOT NULL
);
INSERT INTO balances (account, balance) VALUES
  ('1234567891', 12345.00, 'active');
  ('1234567890', 12345.00, 'active');
  ('1234564444', 12345., 'inactive');