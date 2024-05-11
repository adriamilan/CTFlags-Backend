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
    profile_pic VARCHAR(255), 
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
    imagen_base64 TEXT, 
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

INSERT INTO Users (username, email, profile_pic, role_id) VALUES ('milan', 'milan@ctflags.com', '/path/to/profile_pic1.jpg', 5);
INSERT INTO Users (username, email, profile_pic, role_id) VALUES ('moha', 'moha@ctflags.com', '/path/to/profile_pic2.jpg', 5);
INSERT INTO Users (username, email, profile_pic, role_id) VALUES ('alex', 'alex@ctUsersflags.com', '/path/to/profile_pic3.jpg', 5);

-- Inserciones de desafíos
INSERT INTO Challenges (name, description, flag, points, difficulty) VALUES ('Test', '#test', 'flagtest', 1000, 'Easy');

-- Inserciones de carreras vinculadas a los desafíos existentes
INSERT INTO Careers (name, description, company_name, fecha, provincia, teletrabajo, presencial, hibrido, salario, experiencia, jornada_laboral, tipo_contrato, imagen_base64, role_id, challenge_id)
VALUES 
('Desarrollador Web Remoto', 'Desarrollo de aplicaciones web utilizando tecnologías modernas como HTML, CSS, JavaScript y frameworks como React o Angular.', 'Tech Solutions Inc.', '2024-05-07', 'Madrid', TRUE, FALSE, FALSE, 60000, 3, 'Tiempo completo', 'Contrato permanente', 'imagen_en_base64_1', 1, 1),
('Analista de Datos', 'Análisis y procesamiento de grandes volúmenes de datos utilizando herramientas como SQL, Python y Tableau.', 'Data Insights Ltd.', '2024-05-08', 'Barcelona', FALSE, TRUE, FALSE, 55000, 2, 'Tiempo completo', 'Contrato indefinido', 'imagen_en_base64_2', 2, 1),
('Diseñador Gráfico Híbrido', 'Creación de elementos visuales para campañas de marketing y desarrollo de branding corporativo.', 'Design Innovations SL', '2024-05-09', 'Valencia', TRUE, TRUE, TRUE, 45000, 4, 'Tiempo completo', 'Contrato temporal', 'imagen_en_base64_3', 3, 1),
('Ingeniero de Software', 'Desarrollo de aplicaciones empresariales utilizando tecnologías como Java, Spring y bases de datos relacionales.', 'Code Wizards SL', '2024-05-10', 'Madrid', FALSE, TRUE, FALSE, 70000, 5, 'Tiempo completo', 'Contrato permanente', 'imagen_en_base64_4', 1, 1),
('Especialista en Marketing Digital', 'Planificación y ejecución de estrategias de marketing online, incluyendo SEO, SEM y redes sociales.', 'Digital Ventures Ltd.', '2024-05-11', 'Barcelona', TRUE, TRUE, TRUE, 60000, 3, 'Tiempo completo', 'Contrato indefinido', 'imagen_en_base64_5', 4, 1),
('Administrador de Sistemas', 'Mantenimiento y configuración de servidores y redes, asegurando la disponibilidad y seguridad de los sistemas informáticos.', 'SysAdmin Solutions SL', '2024-05-12', 'Valencia', TRUE, FALSE, FALSE, 65000, 4, 'Tiempo completo', 'Contrato temporal', 'imagen_en_base64_6', 5, 1);


-- Inserciones de desafíos vinculados a carreras existentes

-- Desafío vinculado a la carrera "Desarrollador Web Remoto"
INSERT INTO Challenges (name, description, flag, points, difficulty) VALUES ('Desafío Desarrollo Web', 'Desafío de desarrollo web remoto para Tech Solutions Inc.', 'webdevchallenge', 1500, 'Medium');

-- Desafío vinculado a la carrera "Analista de Datos"
INSERT INTO Challenges (name, description, flag, points, difficulty) VALUES ('Desafío de Análisis de Datos', 'Desafío de análisis de datos para Data Insights Ltd.', 'datanalysistask', 1200, 'Hard');

-- Desafío vinculado a la carrera "Diseñador Gráfico Híbrido"
INSERT INTO Challenges (name, description, flag, points, difficulty) VALUES ('Desafío de Diseño Gráfico', 'Desafío de diseño gráfico híbrido para Design Innovations SL.', 'graphicdesignchallenge', 1000, 'Easy');

-- Desafío vinculado a la carreira "Ingeniero de Software"
INSERT INTO Challenges (name, description, flag, points, difficulty) VALUES ('Desafío de Ingeniería de Software', 'Desafío de ingeniería de software para Code Wizards SL.', 'softwareengineeringtask', 2000, 'Hard');

-- Desafío vinculado a la carrera "Especialista en Marketing Digital"
INSERT INTO Challenges (name, description, flag, points, difficulty) VALUES ('Desafío de Marketing Digital', 'Desafío de marketing digital para Digital Ventures Ltd.', 'digitalmarketingchallenge', 1800, 'Medium');

-- Desafío vinculado a la carrera "Administrador de Sistemas"
INSERT INTO Challenges (name, description, flag, points, difficulty) VALUES ('Desafío de Administración de Sistemas', 'Desafío de administración de sistemas para SysAdmin Solutions SL.', 'sysadminchallenge', 1600, 'Hard');


-- Inserciones de soluciones para los desafíos creados

-- Soluciones para el desafío de desarrollo web
INSERT INTO Solutions (user_id, challenge_id, solution, language) VALUES (1, 2, 'Aquí está mi solución para el desafío de desarrollo web.', 'JavaScript');
INSERT INTO Solutions (user_id, challenge_id, solution, language) VALUES (2, 2, 'Esta es mi solución para el desafío de desarrollo web.', 'HTML/CSS');

-- Soluciones para el desafío de análisis de datos
INSERT INTO Solutions (user_id, challenge_id, solution, language) VALUES (1, 3, 'Aquí está mi solución para el desafío de análisis de datos.', 'Python');
INSERT INTO Solutions (user_id, challenge_id, solution, language) VALUES (3, 3, 'Esta es mi solución para el desafío de análisis de datos.', 'SQL');

-- Soluciones para el desafío de diseño gráfico
INSERT INTO Solutions (user_id, challenge_id, solution, language) VALUES (2, 4, 'Aquí está mi solución para el desafío de diseño gráfico.', 'Photoshop');
INSERT INTO Solutions (user_id, challenge_id, solution, language) VALUES (3, 4, 'Esta es mi solución para el desafío de diseño gráfico.', 'Illustrator');

-- Soluciones para el desafío de ingeniería de software
INSERT INTO Solutions (user_id, challenge_id, solution, language) VALUES (1, 5, 'Aquí está mi solución para el desafío de ingeniería de software.', 'Java');
INSERT INTO Solutions (user_id, challenge_id, solution, language) VALUES (2, 5, 'Esta es mi solución para el desafío de ingeniería de software.', 'Spring');

-- Soluciones para el desafío de marketing digital
INSERT INTO Solutions (user_id, challenge_id, solution, language) VALUES (1, 6, 'Aquí está mi solución para el desafío de marketing digital.', 'SEO');
INSERT INTO Solutions (user_id, challenge_id, solution, language) VALUES (3, 6, 'Esta es mi solución para el desafío de marketing digital.', 'SEM');

-- Soluciones para el desafío de administración de sistemas
INSERT INTO Solutions (user_id, challenge_id, solution, language) VALUES (2, 7, 'Aquí está mi solución para el desafío de administración de sistemas.', 'Linux');
INSERT INTO Solutions (user_id, challenge_id, solution, language) VALUES (3, 7, 'Esta es mi solución para el desafío de administración de sistemas.', 'Windows');
