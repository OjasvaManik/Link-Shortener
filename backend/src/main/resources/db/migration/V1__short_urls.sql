CREATE TABLE short_urls (
                            id SERIAL PRIMARY KEY,
                            short_url VARCHAR(255) NOT NULL UNIQUE,
                            long_url VARCHAR(2048) NOT NULL
);
