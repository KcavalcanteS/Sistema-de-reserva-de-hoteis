-- phpMyAdmin SQL Dump
-- version 4.0.4.2
-- http://www.phpmyadmin.net
--
-- Máquina: localhost
-- Data de Criação: 13-Jun-2025 às 20:36
-- Versão do servidor: 5.6.13
-- versão do PHP: 5.4.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de Dados: `sistema-de-reserva-de-hoteis`
--
DROP DATABASE IF EXISTS `sistema-de-reserva-de-hoteis`;
CREATE DATABASE IF NOT EXISTS `sistema-de-reserva-de-hoteis` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `sistema-de-reserva-de-hoteis`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `telacadastrofuncionarios`
--

CREATE TABLE IF NOT EXISTS `telacadastrofuncionarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `cargo` varchar(30) NOT NULL,
  `login` varchar(20) NOT NULL,
  `senha` varchar(50) NOT NULL,
  `telefone` varchar(15) NOT NULL,
  `data_nascimento` date DEFAULT NULL,
  `rua`varchar(30) NOT NULL,
  `numero` varchar(5) NOT NULL,
  `bairro` varchar(30) NOT NULL,
  `cidade` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `telacadastrofuncionarios`
--

INSERT INTO `telacadastrofuncionarios` (`id`, `nome`, `cpf`, `cargo`, `login`, `senha`) VALUES
(1, 'Maria', '987.654.321-00', 'Recepcionista', 'maria', 'senha456');

-- --------------------------------------------------------

--
-- Estrutura da tabela `telacadastrousuarios`
--

CREATE TABLE IF NOT EXISTS `telacadastroclientes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `telefone` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `numero` varchar(10) NOT NULL,
  `tipo` varchar(20) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `valor_diaria` double DEFAULT NULL,
  `data_checkin` date DEFAULT NULL,
  `data_checkout` date DEFAULT NULL,
  `data_pagamento` date DEFAULT NULL,
  `valor_total` double DEFAULT NULL,
  `metodo_pagamento` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `telacadastrousuarios`
--

INSERT INTO `telacadastroclientes` (`id`, `nome`, `cpf`, `telefone`, `email`, `numero`, `tipo`, `status`, `valor_diaria`, `data_checkin`, `data_checkout`, `data_pagamento`, `valor_total`, `metodo_pagamento`) VALUES
(1, 'João Silva', '123.456.789-00', '(11)987654321', 'joao@email.com', '101', 'Padrão', 'Reservado', 150.5, '2025-06-15', '2025-06-20', '2025-06-14', 752.5, 'Cartão de Crédito');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `senha` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `usuarios`
--

INSERT INTO `usuarios` (`id`, `username`, `senha`) VALUES
(1, 'hotel', 'admin123');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
