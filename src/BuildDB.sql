Create schema IF NOT EXISTS assetdatabase;
use assetdatabase;

DROP TABLE IF EXISTS Software;
CREATE TABLE `Software` (
    `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `employee` text NOT NULL,
    `software` text NOT NULL,
    `availability` text NOT NULL,
    `renewal` varchar(10) NOT NULL
);

DROP TABLE IF EXISTS Hardware;
CREATE TABLE `Hardware` (
    `ID` int(11) NOT NULL,
    `employee` text NOT NULL,
    `hardware` text NOT NULL,
    `availability` text NOT NULL,
    `checkin` varchar(12) NOT NULL
);

DROP TABLE IF EXISTS `User`;
CREATE TABLE `User` (
    `userNumber` int(11) NOT NULL,
    `accountType` text NOT NULL,
    `gender` text NOT NULL,
    `contactNumber` bigint(20) NOT NULL,
    `address` text NOT NULL,
    `email` text NOT NULL,
    `birthday` date DEFAULT NULL
);

INSERT INTO `Software` (`id`, `employee`, `software`, `availability`, `renewal`) VALUES
    (1, 'John Smith', 'Microsoft Office', 'Yes', '01-01-2023'),
    (2, 'Elliot Jones', 'Bloomberg Digital', 'Yes', '30-10-2023'),
    (3, 'Peter Parker', 'Notion', 'Yes', '01-08-2023'),
    (4, 'Wendy Richards', 'Jira', 'No', '20-09-2024'),
    (5, 'Erica Min', 'Microsoft 365', 'Yes', '04-11-2023'),
    (6, 'Richard Keys', 'Adobe Creative Cloud', 'Yes', '22-01-2024'),
    (7, 'Siobhan Haynes', 'Norton 360 Deluxe', 'Yes', '05-06-2023'),
    (8, 'Lilia Chang', 'Notion', 'No', '02-06-2024');

INSERT INTO `Hardware` (`id`, `employee`, `hardware`, `availability`, `checkin`) VALUES
    (4, 'Peter Parker', 'Laptop', 'no', '2022-06-12'),
    (5, 'Wendy Richards', 'Monitor', 'No', '2019-10-10'),
    (6, 'Eric Min', 'Monitor', 'Yes', '2024-01-20'),
    (7, 'Peter Johnson', 'Monitor', 'Yes', '20-01-2022'),
    (8, 'Billy Jones', 'Laptop', 'Yes', '01-12-2024'),
    (9, 'Annika Smith', 'Mouse', 'Yes', '01-12-2024'),
    (10, 'Bruce Tearlag', 'Mouse', 'Yes', '01-12-2024'),
    (11, 'Zak Nandag', 'Laptop', 'Yes', '01-12-2024'),
    (12, 'Aaron Torcull', 'Laptop', 'No', '01-12-2024'),
    (14, 'Rowan Leatherhead', 'Monitor', 'No', '20-04-2024'),
    (16, 'clive', 'mouse', 'yes', '2022-12-10');


INSERT INTO `User` (`userNumber`, `accountType`, `gender`, `contactNumber`, `address`, `email`, `birthday`) VALUES
    (1, 'admin', 'male', 898, '3 sharrold road, CF23 4FD', 'dave@bipSync.com', '1990-12-01'),
    (2, 'admin', 'female', 989, '44 Windy street CF10 2TV', 'lucy@bipSync.com', '1999-11-30'),
    (3, 'admin', 'non-binary', 771, '10 downing street WC1 9A1', 'callum@bipSync', '1910-03-01'),
    (4, 'SuperAdmin', 'male', 991, '45 leafy lane NP11 5E1', 'ben@bipSync.com', '1995-01-01'),
    (5, 'admin', 'female', 998, '1 high close CF12 4FS', 'daisy@bipSync.com', '1930-03-20'),
    (6, 'admin', 'male', 773, '99 high close CF12 4FA', 'boris@bipSync.com', '1980-01-30'),
    (7, 'admin', 'non-binary', 744, '80 mill lane SA1 0B9', 'ella@bipSync.com', '1999-04-22'),
    (8, 'admin', 'male', 945, '33 cold close NP32 4RE', 'John@bipSync.com', '1970-12-12'),
    (9, 'admin', 'female', 773, '101 dalmation close AL7 2TR', 'Cruella@bipSync.com', '1950-10-10');