CREATE TABLE user_profile (
    id BIGINT NOT NULL AUTO_INCREMENT,
    profile_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_profile_user
        FOREIGN KEY (profile_id)
            REFERENCES profiles(id),
    CONSTRAINT fk_user_profile
        FOREIGN KEY (user_id)
            REFERENCES users(id)
);
