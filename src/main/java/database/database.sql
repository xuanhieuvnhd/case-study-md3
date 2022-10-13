CREATE database democasestudy;
use democasestudy;
CREATE TABLE products(
    id INT primary key,
    code NVARCHAR(100) unique not null ,
    name NVARCHAR(200) Not Null ,
    category NVARCHAR(100) NOT NULL ,
    quantity INT NOT NULL ,
    price DOUBLE NOT NULL ,
    pathImage NVARCHAR(200) NOT NULL

);
ALTER TABLE products MODIFY COLUMN id INT AUTO_INCREMENT;
insert into products (code,name,category,quantity,price,pathImage) VALUES ('vay1','vay xoe','dress',20,250000,'view/img/product/vay1.png');
SELECT * from products where name like '%vay%';
SELECT * from products where code = 'vay1';
SELECT * from products where category='dress';
SELECT * FROM products order by price ASC ;

CREATE TABLE users(
    id INT primary key AUTO_INCREMENT,
    userName NVARCHAR(100) UNIQUE NOT NULL ,
    password NVARCHAR(100) NOT NULL ,
    email NVARCHAR(200) NOT NULL ,
    address NVARCHAR(200) NOT NULL,
    phoneNumber int not null,
    role nvarchar(100)
);
INSERT INTO users (userName, password, email, address,phoneNumber) VALUES ('hieu','hieu','xuanhieuvn@gamil.com','ha noi','123456789');
select * from users;
