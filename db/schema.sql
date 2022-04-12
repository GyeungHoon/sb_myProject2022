# DB 생성
DROP DATABASE IF EXISTS jpaBoard;
CREATE DATABASE jpaBoard;
USE jpaBoard;

# 회원 테이블 생성
CREATE TABLE `user` (
    id BIGINT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    regDate DATETIME NOT NULL,
    updateDate DATETIME NOT NULL,
    email VARCHAR(100) NOT NULL,
    `password` VARCHAR(150) NOT NULL,
    `name` CHAR(50) NOT NULL
);

# 회원데이터 생성
INSERT INTO `user`
SET regDate = NOW(),
updateDate = NOW(),
email = 'use1@test.com',
`password` = '1234',
`name` = '유저1';

INSERT INTO `user`
SET regDate = NOW(),
updateDate = NOW(),
email = 'use2@test.com',
`password` = '1234',
`name` = '유저2';

INSERT INTO `user`
SET regDate = NOW(),
updateDate = NOW(),
email = 'use3@test.com',
`password` = '1234',
`name` = '유저3';

# 게시물 테이블 생성
CREATE TABLE `article` (
    id BIGINT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    regDate DATETIME NOT NULL,
    updateDate DATETIME NOT NULL,
    title VARCHAR(100) NOT NULL,
    `body` TEXT NOT NULL,
    `userId` BIGINT UNSIGNED NOT NULL
);

# 게시물데이터 생성
INSERT INTO `article`
SET regDate = NOW(),
updateDate = NOW(),
title = '제목 1',
`body` = '내용 1',
`userId` = 1;

INSERT INTO `article`
SET regDate = NOW(),
updateDate = NOW(),
title = '제목 2',
`body` = '내용 2',
`userId` = 2;

INSERT INTO `article`
SET regDate = NOW(),
updateDate = NOW(),
title = '제목 3',
`body` = '내용 3',
`userId` = 3;