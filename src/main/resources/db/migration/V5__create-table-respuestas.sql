CREATE TABLE answers (
     id BIGINT NOT NULL AUTO_INCREMENT,
     message VARCHAR(100) NOT NULL,
     date_creation DATETIME NOT NULL,
     solution VARCHAR(100) NOT NULL,
     user_id BIGINT NOT NULL,
     topic_id BIGINT NOT NULL,
     PRIMARY KEY (id),
     CONSTRAINT fk_user_answer
         FOREIGN KEY (user_id)
             REFERENCES users(id),
     CONSTRAINT fk_topic_answer
         FOREIGN KEY (topic_id)
             REFERENCES topics(id)
);
