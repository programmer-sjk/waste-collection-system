INSERT INTO collection_history (partner_company_id, amount, box_count, thumbnail_count, note, collected_at) VALUES(1, 450, 4, 3, '새벽 수거 해야함', '2021-11-03 01:15:13');
INSERT INTO collection_history (partner_company_id, amount, box_count, thumbnail_count, note, collected_at) VALUES(2, 110, 1, 1, '없음', '2021-11-03 13:25:36');
INSERT INTO collection_history (partner_company_id, amount, box_count, thumbnail_count, note, collected_at) VALUES(3, 362, 3, 2, '하루 2번 수거', '2021-11-03 12:25:14');
INSERT INTO collection_history (partner_company_id, amount, box_count, thumbnail_count, note, collected_at) VALUES(4, 651, 6, 1, '매일 수거', '2021-11-04 01:10:13');

INSERT INTO collection_thumbnail (file_path, extension, history_id, created_at, updated_at) VALUES('맘스터치_01', 'jpg', 1, '2021-11-03 01:15:13', '2021-11-03 01:15:13');
INSERT INTO collection_thumbnail (file_path, extension, history_id, created_at, updated_at) VALUES('맘스터치_02', 'jpg', 1, '2021-11-03 01:15:14', '2021-11-03 01:15:14');
INSERT INTO collection_thumbnail (file_path, extension, history_id, created_at, updated_at) VALUES('맘스터치_03', 'jpg', 1, '2021-11-03 01:15:15', '2021-11-03 01:15:15');
INSERT INTO collection_thumbnail (file_path, extension, history_id, created_at, updated_at) VALUES('롯데리아_01', 'png', 2, '2021-11-03 13:25:36', '2021-11-03 13:25:36');
INSERT INTO collection_thumbnail (file_path, extension, history_id, created_at, updated_at) VALUES('베스킨라빈스_01', 'jpeg', 3, '2021-11-03 12:25:14', '2021-11-03 12:25:14');
INSERT INTO collection_thumbnail (file_path, extension, history_id, created_at, updated_at) VALUES('베스킨라빈스_02', 'jpeg', 3, '2021-11-03 12:25:20', '2021-11-03 12:25:20');
INSERT INTO collection_thumbnail (file_path, extension, history_id, created_at, updated_at) VALUES('본죽_01', 'jpg', 4, '2021-11-04 01:10:13', '2021-11-04 01:10:13');

INSERT INTO partner_company (name, location, started_at, business_name) VALUES('맘스터치', '강남', '2021-10-01', '김맘스');
INSERT INTO partner_company (name, location, started_at, business_name) VALUES('롯데리아', '서초', '2021-11-01', '박롯데');
INSERT INTO partner_company (name, location, started_at, business_name) VALUES('베스킨라빈스', '역삼', '2021-11-05', '베스킨');
INSERT INTO partner_company (name, location, started_at, business_name) VALUES('본죽', '삼성', '2021-11-03', '최본죽');
