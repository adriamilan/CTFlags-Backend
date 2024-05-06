DROP DATABASE IF EXISTS db_ctflags;
CREATE DATABASE db_ctflags;

USE db_ctflags;

CREATE TABLE Roles (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE Users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255),
    email VARCHAR(255),
    points INT DEFAULT 0,
    role_id INT DEFAULT 1,
    UNIQUE(id, username),
    FOREIGN KEY (role_id) REFERENCES Roles(id)
);

CREATE TABLE Challenges (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    description TEXT,
    flag VARCHAR(255),
    points INT,
    difficulty VARCHAR(255)
);

CREATE TABLE Users_Challenges (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    challenge_id INT,
    FOREIGN KEY (user_id) REFERENCES Users(id),
    FOREIGN KEY (challenge_id) REFERENCES Challenges(id)
);

CREATE TABLE Solutions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    challenge_id INT,
    solution TEXT,
    language VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES Users(id),
    FOREIGN KEY (challenge_id) REFERENCES Challenges(id)
);

CREATE TABLE Careers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    description TEXT,
    company_name VARCHAR(255),
    fecha DATE,
    provincia VARCHAR(255),
    teletrabajo BOOLEAN,
    presencial BOOLEAN,
    hibrido BOOLEAN,
    salario INT,
    experiencia INT,
    jornada_laboral VARCHAR(255),
    tipo_contrato VARCHAR(255),
    role_id INT,
    challenge_id INT,
    FOREIGN KEY (role_id) REFERENCES Roles(id),
    FOREIGN KEY (challenge_id) REFERENCES Challenges(id) ON DELETE CASCADE
);


INSERT INTO Roles (name) VALUES ('Bronze');
INSERT INTO Roles (name) VALUES ('Plata');
INSERT INTO Roles (name) VALUES ('Oro');
INSERT INTO Roles (name) VALUES ('Diamante');
INSERT INTO Roles (name) VALUES ('Admin');

INSERT INTO Users (username, email, role_id) VALUES ('milan', 'milan@ctflags.com', 5);
INSERT INTO Users (username, email, role_id) VALUES ('moha', 'moha@ctflags.com', 5);
INSERT INTO Users (username, email, role_id) VALUES ('alex', 'alex@ctUsersflags.com', 5);

INSERT INTO Challenges (name, description, flag, points, difficulty) VALUES ('Test', '#test', 'flagtest', 1000, 'Easy');