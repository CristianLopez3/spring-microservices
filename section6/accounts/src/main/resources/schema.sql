CREATE TABLE IF NOT EXISTS `customers` (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    name varchar(100) NOT NULL,
    email varchar(100) NOT NULL,
    mobile_number varchar(100) NOT NULL,
    created_at date NOT NULL,
    created_by varchar(100) NOT NULL,
    updated_at date DEFAULT NULL,
    updated_by varchar(100) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS `accounts` (
    customer_id INT NOT NULL,
    account_number INT AUTO_INCREMENT PRIMARY KEY,
    account_type varchar(100) NOT NULL,
    branch_address varchar(100) NOT NULL,
    created_at date NOT NULL,
    created_by varchar(100) NOT NULL,
    updated_at date DEFAULT NULL,
    updated_by varchar(100) DEFAULT NULL
);