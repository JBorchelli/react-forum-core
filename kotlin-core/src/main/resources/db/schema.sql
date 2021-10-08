DROP TABLE IF EXISTS users_groups;
DROP TABLE IF EXISTS posts;
DROP TABLE IF EXISTS discussions;
DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS groups;

CREATE TABLE groups (
    id INTEGER PRIMARY KEY,
    group_name text NOT NULL
);

CREATE TABLE users (
    id INTEGER PRIMARY KEY,
    username TEXT NOT NULL
);

CREATE TABLE users_groups (
    group_id INTEGER,
    user_id INTEGER,
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
    id INTEGER PRIMARY KEY,
    title TEXT NOT NULL,
    group_id INTEGER,
    CONSTRAINT fk_categories_group_id
        FOREIGN KEY(group_id)
            REFERENCES groups(id) ON DELETE CASCADE
);

CREATE TABLE discussions (
    id INTEGER PRIMARY KEY,
    heading TEXT NOT NULL,
    sub TEXT,
    category_id INTEGER,
    user_id INTEGER,
    CONSTRAINT fk_discussions_category_id
        FOREIGN KEY(category_id)
            REFERENCES categories(id) ON DELETE CASCADE,
    CONSTRAINT fk_discussions_user_id
        FOREIGN KEY(user_id)
            REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE posts (
    id INTEGER PRIMARY KEY,
    content TEXT NOT NULL,
    user_id INTEGER,
    discussion_id INTEGER,
    CONSTRAINT fk_posts_discussion_id
        FOREIGN KEY(discussion_id)
            REFERENCES discussions(id) ON DELETE CASCADE,
    CONSTRAINT fk_posts_user_id
        FOREIGN KEY(user_id)
            REFERENCES users(id) ON DELETE CASCADE
);
