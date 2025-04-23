-- Create the database
CREATE DATABASE zumba;

-- Use the newly created database
USE zumba;

-- Create the batch table
CREATE TABLE batch (
    id INT AUTO_INCREMENT PRIMARY KEY,
    session VARCHAR(100) NOT NULL
);

-- Create the participant table
CREATE TABLE participant (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    phone VARCHAR(20),
    batch_id INT,
    FOREIGN KEY (batch_id) REFERENCES batch(id)
);
