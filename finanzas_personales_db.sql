-- Crear Base de Datos
CREATE DATABASE finanzas_personales CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE finanzas_personales;

-- Tabla Usuario
CREATE TABLE usuario (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         nombre VARCHAR(100) NOT NULL,
                         email VARCHAR(150) NOT NULL UNIQUE,
                         password VARCHAR(255) NOT NULL,
                         fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabla Tarjeta
CREATE TABLE tarjeta (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         usuario_id INT NOT NULL,
                         banco VARCHAR(100),
                         tipo ENUM('credito', 'debito') NOT NULL,
                         numero_tarjeta VARCHAR(20) NOT NULL,
                         fecha_corte INT, -- Día del mes del corte
                         fecha_pago INT,  -- Día del mes límite de pago
                         limite_credito DECIMAL(15,2), -- Aplicable solo a crédito
                         saldo_actual DECIMAL(15,2) DEFAULT 0,
                         FOREIGN KEY (usuario_id) REFERENCES usuario(id) ON DELETE CASCADE
);

-- Tabla Categoria
CREATE TABLE categoria (
                           id INT AUTO_INCREMENT PRIMARY KEY,
                           nombre VARCHAR(50) NOT NULL UNIQUE,
                           descripcion VARCHAR(255)
);

-- Tabla Transaccion (incluye cargos y abonos)
CREATE TABLE transaccion (
                             id INT AUTO_INCREMENT PRIMARY KEY,
                             tarjeta_id INT NOT NULL,
                             categoria_id INT, -- Opcional, puede haber transacciones sin categoría (ej. pagos o abonos)
                             tipo ENUM('cargo', 'abono') NOT NULL,
                             descripcion VARCHAR(255),
                             monto DECIMAL(15,2) NOT NULL,
                             fecha_transaccion DATE NOT NULL,
                             meses_sin_intereses INT DEFAULT 1, -- 1 indica cargo normal sin MSI, aplicable únicamente en cargos
                             FOREIGN KEY (tarjeta_id) REFERENCES tarjeta(id) ON DELETE CASCADE,
                             FOREIGN KEY (categoria_id) REFERENCES categoria(id)
);

create table mesesSinIntereses(
                                id INT AUTO_INCREMENT PRIMARY KEY,
                                transaccion_id INT,
                                numero_meses INT,
                                monto_mensual DECIMAL(15,2) NOT NULL,
                                FOREIGN KEY (transaccion_id) REFERENCES transaccion(id) ON DELETE CASCADE
);

)