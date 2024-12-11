CREATE TABLE users (
    user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE profiles (
    profile_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE user_profile (
    user_id BIGINT NOT NULL,
    profile_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, profile_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (profile_id) REFERENCES profile(profile_id) ON DELETE CASCADE
);

CREATE TABLE courses (
    course_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    category ENUM(
          "PROGRAMMING",
          "LANGUAGE",
          "MATH",
          "ENGINEERING",
          "DATA_SCIENCE",
          "BACK_END",
          "FRONT_END",
          "BUSINESS",
          "INNOVATION",
          "DEV_OPS",
          "OFF_TOPIC"
    ) DEFAULT "OFF_TOPIC"
);

CREATE TABLE topics (
    topic_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    message TEXT NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    status ENUM(
        "SOLVED",
        "DISCUSSED",
        "ACTIVE"
    ) DEFAULT 'ACTIVE',
    author BIGINT NOT NULL,
    course BIGINT NOT NULL,
    FOREIGN KEY (author) REFERENCES authors(author_id) ON DELETE CASCADE,
    FOREIGN KEY (course) REFERENCES courses(course_id) ON DELETE CASCADE
);

CREATE TABLE replies (
    reply_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    message TEXT NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    solution BOOLEAN DEFAULT FALSE,
    author BIGINT NOT NULL,
    topic BIGINT NOT NULL,
    FOREIGN KEY (author) REFERENCES users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (topic) REFERENCES topics(topic_id) ON DELETE CASCADE
);
