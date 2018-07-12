drop table trade if exists;
drop table traders if exists;
CREATE TABLE trade
(
     orderId int(11) NOT NULL AUTO_INCREMENT,
     ticker varchar(25) NOT NULL,
     traderId int(11) NOT NULL,
     quantity int(3) NOT NULL,
     price int(5) NOT NULL,
     validity int(10000) NOT NULL,
     orderType int(1),
     orderStatus int(1) NOT NULL,
     buySell int(1) NOT NULL,
     times date DEFAULT GETDATE(),
     PRIMARY KEY(orderId)
     
  );
  
  CREATE TABLE traders
(
	traderId int(11) NOT NULL,
	firstName varchar (100) NOT NULL,
	lastName varchar (100) NOT NULL,
	contact int (12) NOT NULL,
	email varchar(50) NOT NULL,
	address varchar(150) NOT NULL,
	PRIMARY KEY (traderId)

);