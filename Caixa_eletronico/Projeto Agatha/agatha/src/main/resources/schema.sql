DROP TABLE IF EXISTS CLIENTE;
 
CREATE TABLE CLIENTE (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    saldo INT NOT NULL
);
