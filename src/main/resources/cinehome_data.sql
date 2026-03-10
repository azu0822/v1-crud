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

-- [영화 리뷰 샘플]
INSERT INTO review(movie_id, user_id, review_title, review_content, rating)
VALUES (1, 1, '영화와 함께 사는 남자', '영화를 좋아해서 극장에 혼자 가 영화를 보는게 저의 낙입니다. 그 많은 영화를 보고 평을 남기는건 처음인것같은데 영화가 끝난뒤에도 마음이 먹먹하더라구요 믿고 보는 배우들 이어서 줄거리를 잘 모르고 갔는데 엄청나네요.. 유지태님 캐릭터를 위해 살을 찌우신거같은데 등장할때마다 위압감이 엄청 나고 유해진님은 원래 말할것도 없이 캐릭터 그 자체가 되셔서 보며 웃고울었습니다박지훈님은 약한영웅때 연기 잘 하시는건 알고있었는데 왜 노산이 박지훈님인지 알겠더라구요한없이 연약해보이다가도 끌어들이는 무언가가 있고 알에서 깨고나온것처럼 단단해졌을때 저도 같이 전율이 일어났습니다영화 잘 봤습니다.', 5);
INSERT INTO review(movie_id, user_id, review_title, review_content, rating)
VALUES (1, 1, '최고의배우…', '방금 보고 나왔어요 유해진분 역이 실존인물이었다는 점이 가슴을 더 울리네요ㅠㅠ', 5);
INSERT INTO review(movie_id, user_id, review_title, review_content, rating)
VALUES (2, 1, '다소 아쉽습니다.', '류승완 감독의 첩보물은 믿고보는 편인데 이번작품은 다소 아쉽다. 어느정도 예측 가능한 스토리로 첩보물의 긴장감이 충분히 녹아들지 않았고, 또 다시 북한출신 캐릭터를 다수 설정해서 신선함이 부족했다. 너무 작위적이고 신파스러운 부분이 많아 억지스러운 느낌이 있다. ', 3);