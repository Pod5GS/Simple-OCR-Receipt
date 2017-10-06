CREATE TABLE receipts (
  id INT UNSIGNED AUTO_INCREMENT,
  uploaded TIME DEFAULT CURRENT_TIME(),
  merchant VARCHAR(255),
  amount DECIMAL(12,2),
  receipt_type INT UNSIGNED,
  base64_string VARCHAR(MAX),
  PRIMARY KEY (id)
);

CREATE TABLE tags (
  id INT UNSIGNED AUTO_INCREMENT,
  receipt_id INT UNSIGNED,
  name VARCHAR(255),

  PRIMARY KEY (id)
);