ALTER TABLE task ADD COLUMN user_id BIGINT;

ALTER TABLE task ADD CONSTRAINT task_user_id_fk FOREIGN KEY (user_id) REFERENCES "user";



