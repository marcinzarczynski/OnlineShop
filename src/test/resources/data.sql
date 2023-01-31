DROP TABLE IF EXISTS item;
DROP TABLE IF EXISTS basket;

CREATE TABLE basket (
  basket_id int NOT NULL,
  orderId varchar(50) NOT NULL,
  total_price FLOAT NOT NULL,
  item_id int,
  PRIMARY KEY (basket_id)
);

CREATE TABLE item (
    item_id int NOT NULL,
    name varchar(250) NOT NULL,
    price float NOT NULL,
    PRIMARY KEY (item_id)
);


