DROP TABLE IF EXISTS groups;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS discussions;
DROP TABLE IF EXISTS posts;

CREATE TABLE groups (
    group_id SERIAL PRIMARY KEY,
    group_name text NOT NULL,
    
    
)
