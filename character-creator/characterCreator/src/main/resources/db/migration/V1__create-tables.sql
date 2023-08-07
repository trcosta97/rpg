CREATE TABLE player (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    sign_date DATE NOT NULL,
    status BIT NOT NULL
);

CREATE TABLE player_character (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    gender VARCHAR(20) NOT NULL,
    age INT NOT NULL,
    player_id BIGINT NOT NULL,
    race VARCHAR(20) NOT NULL,
    class VARCHAR(20) NOT NULL,
    status BIT NOT NULL,
    creation_date DATE NOT NULL,
    FOREIGN KEY (player_id) REFERENCES player(id)
);

CREATE TABLE stats (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    intelligence INT NOT NULL,
    strength INT NOT NULL,
    dexterity INT NOT NULL,
    constitution INT NOT NULL,
    charisma INT NOT NULL,
    luck INT NOT NULL,
    player_character_id BIGINT NOT NULL UNIQUE,
    FOREIGN KEY (player_character_id) REFERENCES player_character(id)
);
