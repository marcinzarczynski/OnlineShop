DROP TABLE IF EXISTS items;
DROP TABLE IF EXISTS baskets;

CREATE TABLE baskets (
  basket_id int NOT NULL AUTO_INCREMENT,
  orderId varchar(50) NOT NULL,
  total_price FLOAT NOT NULL,
  item_id int,
  PRIMARY KEY (basket_id)
);

CREATE TABLE items (
    item_id int NOT NULL,
    name varchar(250) NOT NULL,
    price float NOT NULL,
    PRIMARY KEY (item_id)
);

