-- [사용자 테이블]
create table member(
	user_id INT AUTO_INCREMENT PRIMARY KEY COMMENT '사용자 식별ID',
	member_id VARCHAR(50) NOT NULL UNIQUE COMMENT '로그인 아이디',
	member_pw VARCHAR(255) COMMENT '로그인 비밀번호',
	name VARCHAR(50) COMMENT '성명',
	phone VARCHAR(20) COMMENT '휴대폰번호',
	role VARCHAR(20) DEFAULT 'USER' COMMENT '일반유저,관리자 식별용',
	cre_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '생성일자'
);

-- [영화 목록 테이블]
create table movie(
	movie_id INT AUTO_INCREMENT PRIMARY KEY COMMENT '영화 아이디',
	title VARCHAR(200) NOT NULL COMMENT '제목',
	summary TEXT COMMENT '줄거리',
	director VARCHAR(50) COMMENT '감독',
	release_dt DATE COMMENT '개봉일',
	age_rating VARCHAR(10) COMMENT '관람가',
	type VARCHAR(20) COMMENT 'MOVIE',
	cre_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '생성일자'
);


-- [리뷰 게시글 테이블]
create table review(
	review_id INT AUTO_INCREMENT PRIMARY KEY COMMENT '리뷰 게시판 아이디',
	movie_id INT NOT NULL COMMENT '영화 아이디',
	user_id INT NOT NULL COMMENT '작성자 아이디(FK)',
	review_title VARCHAR(200) COMMENT '제목',
	review_content TEXT COMMENT '내용',
	cre_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '작성날짜',
	update_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
	ON UPDATE CURRENT_TIMESTAMP COMMENT '업데이트 날짜',
	rating INT NOT NULL COMMENT '평점(별점)' CHECK (rating BETWEEN 1 AND 5) ,
	view_count INT DEFAULT 0 COMMENT '조회수',
	-- [제약선언]
	FOREIGN KEY (user_id) REFERENCES member(user_id),
	FOREIGN KEY (movie_id) REFERENCES movie(movie_id)
);

-- [리뷰 댓글 테이블]
create table comments(
	comments_id INT AUTO_INCREMENT PRIMARY KEY COMMENT '리뷰 댓글 번호',
	review_id INT NOT NULL COMMENT '리뷰 아이디(FK)',
	user_id INT NOT NULL COMMENT '사용자 아이디',
	content TEXT COMMENT '내용',
	cre_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '작성일자',
	-- [제약 선언]
	FOREIGN KEY (review_id) REFERENCES review(review_id),
	FOREIGN KEY (user_id) REFERENCES member(user_id)
);

-- [첨부파일 테이블]
create table attach(
	file_id INT AUTO_INCREMENT PRIMARY KEY COMMENT '리뷰 파일 아이디',
	review_id INT NOT NULL COMMENT '리뷰 게시판 아이디',
	file_name VARCHAR(200) COMMENT '파일명',
	file_path VARCHAR(500) COMMENT '파일 경로',
	cre_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '생성일자',
  -- [제약 선언]
	FOREIGN KEY (review_id) REFERENCES review(review_id)
);

-- [장르 테이블]
create table genre(
	genre_id INT AUTO_INCREMENT PRIMARY KEY COMMENT '장르 아이디',
	genre_name VARCHAR(50) UNIQUE COMMENT '장르 이름'
);

-- [테이블 + 장르연결 테이블]
create table movie_genre(
	movie_id INT COMMENT '영화 아이디',
	genre_id INT COMMENT '장르 아이디',
	PRIMARY KEY (movie_id, genre_id),
	FOREIGN KEY (movie_id) REFERENCES movie(movie_id),
	FOREIGN KEY (genre_id) REFERENCES genre(genre_id)
);
