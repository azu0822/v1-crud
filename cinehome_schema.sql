-- [사용자 테이블]
create table member(
	user_id INT AUTO_INCREMENT PRIMARY KEY,     -- 사용자 식별ID
	member_id VARCHAR(50) NOT NULL UNIQUE,      -- 로그인 아이디
	member_pw VARCHAR(255),                     -- 로그인 비밀번호
	name VARCHAR(50),                           -- 성명
	phone VARCHAR(20),                          -- 휴대폰번호
	role VARCHAR(20) DEFAULT 'USER',            -- 일반유저/관리자 식별용
	cre_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP  -- 생성일자
);

-- [영화 목록 테이블]
create table movie(
	movie_id INT AUTO_INCREMENT PRIMARY KEY,    -- 영화 아이디
	title VARCHAR(200) NOT NULL,                -- 제목
	summary TEXT,                               -- 줄거리
	director VARCHAR(50),                       -- 감독
	release_dt DATE,                            -- 개봉일
	age_rating VARCHAR(10),                     -- 관람가
	type VARCHAR(20),                           -- MOVIE
	cre_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP  -- 생성일자
);


-- [리뷰 게시글 테이블]
create table review(
	review_id INT AUTO_INCREMENT PRIMARY KEY,          -- 리뷰 게시판 아이디
	movie_id INT NOT NULL,                 -- 영화 아이디
	user_id INT NOT NULL,                  -- 작성자 아이디(FK)
	review_title VARCHAR(200),             -- 제목
	review_content TEXT,                   -- 내용
	cre_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,        -- 작성날짜
	update_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
	ON UPDATE CURRENT_TIMESTAMP,                       -- 업데이트 날짜
	rating INT NOT NULL CHECK (rating BETWEEN 1 AND 5),-- 평점(별점)
	view_count INT DEFAULT 0,       -- 조회수
	-- [제약선언]
	FOREIGN KEY (user_id) REFERENCES member(user_id),
	FOREIGN KEY (movie_id) REFERENCES movie(movie_id)
);

-- [리뷰 댓글 테이블]
create table comments(
	comments_id INT AUTO_INCREMENT PRIMARY KEY, -- 리뷰 댓글 번호
	review_id INT NOT NULL,                     -- 리뷰 아이디(FK)
	user_id INT NOT NULL,                       -- 사용자 아이디
	content TEXT,                               -- 내용
	cre_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 작성일자
	-- [제약 선언]
	FOREIGN KEY (review_id) REFERENCES review(review_id),
	FOREIGN KEY (user_id) REFERENCES member(user_id)
);

-- [첨부파일 테이블]
create table attach(
	file_id INT AUTO_INCREMENT PRIMARY KEY,     -- 리뷰 파일 아이디
	review_id INT NOT NULL,                     -- 리뷰 게시판 아이디
	file_name VARCHAR(200),                     -- 파일명
	file_path VARCHAR(500),                     -- 파일 경로
	cre_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- 생성일자
  -- [제약 선언]
	FOREIGN KEY (review_id) REFERENCES review(review_id)
);

-- [장르 테이블]
create table genre(
	genre_id INT AUTO_INCREMENT PRIMARY KEY,    -- 장르 아이디
	genre_name VARCHAR(50) UNIQUE               -- 장르 이름
);

-- [테이블 + 장르연결 테이블]
create table movie_genre(
	movie_id INT,
	genre_id INT,
	PRIMARY KEY (movie_id, genre_id),
	FOREIGN KEY (movie_id) REFERENCES movie(movie_id),
	FOREIGN KEY (genre_id) REFERENCES genre(genre_id)
);


-- [멤버 목록 임의생성]
INSERT INTO member (member_id, member_pw, name, phone, role)
VALUES ('hong', '1234', '홍길동', '010-1234-5678', 'USER');

-- [영화 목록 임의생성]
INSERT INTO movie (movie_id, title, director, release_dt, age_rating, type)
VALUES (1, '왕과 사는 남자', '장항준', '2026-02-04', '12세', 'movie');
INSERT INTO movie (movie_id, title, director, release_dt, age_rating, type)
VALUES (2, '휴민트', '류승완', '2026-02-11', '15세', 'movie');
INSERT INTO movie (movie_id, title, director, release_dt, age_rating, type)
VALUES (3, '호퍼스', '다니엘 총', '2026-03-04', '전체관람가', 'movie');

-- [영화 장르 임의생성]
INSERT INTO genre (genre_id, genre_name) VALUES (1, '액션');
INSERT INTO genre (genre_id, genre_name) VALUES (2, '드라마');
INSERT INTO genre (genre_id, genre_name) VALUES (3, '코메디');
INSERT INTO genre (genre_id, genre_name) VALUES (4, '로맨스');
INSERT INTO genre (genre_id, genre_name) VALUES (5, '판타지');
INSERT INTO genre (genre_id, genre_name) VALUES (6, '스릴러');

-- [영화 목록에 장르를 연결]
INSERT INTO movie_genre (movie_id, genre_id) VALUES (1, 2); --드라마
INSERT INTO movie_genre (movie_id, genre_id) VALUES (2, 1); --액션
INSERT INTO movie_genre (movie_id, genre_id) VALUES (2, 6); --스릴러
INSERT INTO movie_genre (movie_id, genre_id) VALUES (3, 3); --코메디
INSERT INTO movie_genre (movie_id, genre_id) VALUES (3, 5); --판타지