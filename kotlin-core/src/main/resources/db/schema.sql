DROP TABLE IF EXISTS users_groups;
DROP TABLE IF EXISTS posts;
DROP TABLE IF EXISTS discussions;
DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS groups;

CREATE TABLE groups (
    id BIGINT PRIMARY KEY,
    group_name text NOT NULL
);

CREATE TABLE users (
    id BIGINT PRIMARY KEY,
    username TEXT NOT NULL
);

CREATE TABLE users_groups (
    group_id BIGINT,
    user_id BIGINT,
    CONSTRAINT pk_user_groups
        PRIMARY KEY(group_id, user_id),
    CONSTRAINT fk_user_groups_group_id
        FOREIGN KEY(group_id)
            REFERENCES groups(id) ON DELETE CASCADE,
    CONSTRAINT fk_user_groups_user_id
        FOREIGN KEY(user_id)
            REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE categories (
    id BIGINT PRIMARY KEY,
    title TEXT NOT NULL,
    group_id BIGINT,
    CONSTRAINT fk_categories_group_id
        FOREIGN KEY(group_id)
            REFERENCES groups(id) ON DELETE CASCADE
);

CREATE TABLE discussions (
    id BIGINT PRIMARY KEY,
    heading TEXT NOT NULL,
    sub TEXT,
    category_id BIGINT,
    user_id BIGINT,
    CONSTRAINT fk_discussions_category_id
        FOREIGN KEY(category_id)
            REFERENCES categories(id) ON DELETE CASCADE,
    CONSTRAINT fk_discussions_user_id
        FOREIGN KEY(user_id)
            REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE posts (
    id BIGINT PRIMARY KEY,
    content TEXT NOT NULL,
    user_id BIGINT,
    discussion_id BIGINT,
    CONSTRAINT fk_posts_discussion_id
        FOREIGN KEY(discussion_id)
            REFERENCES discussions(id) ON DELETE CASCADE,
    CONSTRAINT fk_posts_user_id
        FOREIGN KEY(user_id)
            REFERENCES users(id) ON DELETE CASCADE
);
