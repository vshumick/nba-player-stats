DO $$
BEGIN
    CREATE TABLE team (
        id SERIAL PRIMARY KEY,
        name VARCHAR(255) NOT NULL
    );

    CREATE TABLE player (
        id SERIAL PRIMARY KEY,
        name VARCHAR(255) NOT NULL,
        team_id INT REFERENCES team(id)
    );

    CREATE TABLE season (
        id SERIAL PRIMARY KEY,
        name VARCHAR(255) NOT NULL
    );

    CREATE TABLE game_type (
        id SERIAL PRIMARY KEY,
        name VARCHAR(255) NOT NULL,
        description TEXT
    );

    CREATE TABLE game (
        id SERIAL PRIMARY KEY,
        date TIMESTAMP NOT NULL,
        season_id INT REFERENCES season(id),
        home_team_id INT REFERENCES team(id),
        away_team_id INT REFERENCES team(id),
        type_id INT REFERENCES game_type(id)
    );

    CREATE TABLE statistics (
        id SERIAL PRIMARY KEY,
        player_id INT REFERENCES player(id),
        game_id INT REFERENCES game(id),
        point INT CHECK (point >= 0),
        rebound INT CHECK (rebound >= 0),
        assist INT CHECK (assist >= 0),
        steal INT CHECK (steal >= 0),
        block INT CHECK (block >= 0),
        foul INT CHECK (foul >= 0 AND foul <= 6),
        turnover INT CHECK (turnover >= 0),
        played_minute NUMERIC CHECK (played_minute >= 0 AND played_minute <= 48.0),
        CONSTRAINT unique_player_game UNIQUE (player_id, game_id)
    );


END $$;