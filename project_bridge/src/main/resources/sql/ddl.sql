INSERT INTO bridge.user (birth, score, state, email, introduction, login_id, name, nickname, password, gender_code) VALUES ('2024-05-23', 80, 1, 'wqe', 'qwe', 'qwe', '123', 'ads', 'dg', 'MALE');
INSERT INTO bridge.user (birth, score, state, email, introduction, login_id, name, nickname, password, gender_code) VALUES ('2024-05-02', 24, 1, 'sdfsdf', 'wtesfd', 'fvbc', 'ertert', 'cvb', 'dfg', 'FEMALE');
INSERT INTO bridge.post (state, view_count, created_at, end_time, start_time, user_id, content, title) VALUES (1, 21, '2024-05-12 15:40:21.000000', '2024-05-12 15:40:28.000000', '2024-05-12 15:40:31.000000', 1, 'asd', 'qweqe');
INSERT INTO bridge.template (score, content) VALUES (2, '이 집 잘하네');
INSERT INTO bridge.template (score, content) VALUES (10, '밥경찰');

INSERT INTO Hashtag (hashtag_name) VALUES ('#푸바오');
INSERT INTO Hashtag (hashtag_name) VALUES ('#리자몽');
INSERT INTO Hashtag (hashtag_name) VALUES ('#한글태그');
INSERT INTO Hashtag (hashtag_name) VALUES ('#서울');
INSERT INTO Hashtag (hashtag_name) VALUES ('#사랑');

INSERT INTO bridge.post_hash(post_id, hashtag_id) VALUES (1, 1);
INSERT INTO bridge.post_hash (post_id, hashtag_id) VALUES (1, 2);
INSERT INTO bridge.post_hash (post_id, hashtag_id) VALUES (1, 3);


INSERT INTO Comment (content, created_at, user_id, post_id) VALUES ('첫 번째 댓글 - 유저 1', '2023-05-13T10:15:30', 1, 1);
INSERT INTO Comment (content, created_at, user_id, post_id) VALUES ('두 번째 댓글 - 유저 1', '2023-05-13T10:20:30', 1, 1);
INSERT INTO Comment (content, created_at, user_id, post_id) VALUES ('첫 번째 댓글 - 유저 2', '2023-05-13T10:25:30', 2, 1);
INSERT INTO Comment (content, created_at, user_id, post_id) VALUES ('두 번째 댓글 - 유저 2', '2023-05-13T10:30:30', 2, 1);
