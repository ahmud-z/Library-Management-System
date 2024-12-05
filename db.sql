CREATE TABLE `admins` (
  `id` int(11) NOT NULL,
  `name` varchar(25) DEFAULT NULL,
  `password` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admins`
--

INSERT INTO `admins` (`id`, `name`, `password`) VALUES
(1, 'admin', '123'),
(2, 'lib admin', '123456'),
(105, 'admin main', 'am123'),
(303, 'admid-test', 'adminTest'),
(404, 'admin-pi', '12345');

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `id` int(11) NOT NULL,
  `name` varchar(25) DEFAULT NULL,
  `author` varchar(25) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`id`, `name`, `author`, `stock`) VALUES
(1, 'CSE', 'Tanim Mahmud', 8),
(2, 'History', 'Dr.Alexender', 9),
(3, 'GED', 'Prof.Ali Ahmed', 2),
(4, 'Acoounting', 'Dr.Zahid Hasan', 0),
(5, 'Finance', 'Prof.Shehzad Rahman', 0),
(6, 'xyz', 'abc', 10),
(7, 'Day of Judgement', 'Prof.Ahmudul Hossain', 799),
(8, 'Machine Learning', 'Prof.Bob Hensen', 124),
(9, 'The End of Earth', 'Prof. Dr. Mahmudul Hasan', 150),
(10, 'Engineering Economics', 'Albert Lian', 7),
(11, 'DC Motor', 'Alexender', 4),
(12, 'Database System', 'Dr. Fhizer Miller', 12),
(13, 'The History of C++', 'Ahmudul Hossain', 25),
(14, 'The Story of ChatGPT', 'Sam Altman', 15);

-- --------------------------------------------------------

--
-- Table structure for table `borrowed_books`
--

CREATE TABLE `borrowed_books` (
  `book_id` int(11) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `borrowed_at` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `borrowed_books`
--

INSERT INTO `borrowed_books` (`book_id`, `student_id`, `amount`, `borrowed_at`) VALUES
(2, 2, 1, '2023-12-09'),
(7, 2, 1, '2023-12-09'),
(6, 3, 1, '2023-12-09'),
(1, 3, 1, '2023-12-09'),
(7, 4, 1, '2023-12-09'),
(2, 3, 1, '2023-12-09'),
(1, 3, 1, '2023-12-09'),
(1, 4, 1, '2023-12-09'),
(1, 2, 1, '2023-12-09'),
(1, 2, 1, '2023-12-09'),
(11, 3, 1, '2023-12-09'),
(4, 2, 1, '2023-12-09'),
(1, 4, 1, '2023-12-25'),
(3, 10, 1, '2023-12-30'),
(5, 5, 1, '2023-12-30');

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `id` int(11) NOT NULL,
  `roll` int(11) DEFAULT NULL,
  `name` varchar(25) DEFAULT NULL,
  `password` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`id`, `roll`, `name`, `password`) VALUES
(2, 201, 'mahmud', '123A'),
(3, 202, 'tanim', '123B'),
(4, 203, 'Uncle Bob', '5412'),
(5, 204, 'John', '12345'),
(6, 205, 'Mike', '456'),
(7, 560, 'abc', '14852'),
(10, 200, 'sumsher', 'ahmud'),
(12, 505, 'Belayet', 'b123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admins`
--
ALTER TABLE `admins`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `borrowed_books`
--
ALTER TABLE `borrowed_books`
  ADD KEY `borrowed_books_ibfk_1` (`student_id`),
  ADD KEY `borrowed_books_ibfk_2` (`book_id`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admins`
--
ALTER TABLE `admins`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=405;

--
-- AUTO_INCREMENT for table `books`
--
ALTER TABLE `books`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `students`
--
ALTER TABLE `students`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `borrowed_books`
--
ALTER TABLE `borrowed_books`
  ADD CONSTRAINT `borrowed_books_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `students` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `borrowed_books_ibfk_2` FOREIGN KEY (`book_id`) REFERENCES `books` (`id`) ON DELETE CASCADE;
COMMIT;

SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `reduce_stock_trigger` AFTER INSERT ON `borrowed_books` FOR EACH ROW BEGIN
	UPDATE books SET stock = stock-1 WHERE id = NEW.book_id;
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;
