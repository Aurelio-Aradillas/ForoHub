CREATE TABLE topics (
     id BIGINT NOT NULL AUTO_INCREMENT,
     title VARCHAR(100) NOT NULL unique ,
     message VARCHAR(100) NOT NULL unique ,
     date_creation DATETIME NOT NULL,
     status TINYINT NOT NULL,
     course_id BIGINT NOT NULL,
     user_id BIGINT NOT NULL,
     PRIMARY KEY (id),
     CONSTRAINT fk_course_topic
         FOREIGN KEY (course_id)
             REFERENCES courses(id),
     CONSTRAINT fk_user_topic
         FOREIGN KEY (user_id)
             REFERENCES users(id)
);
