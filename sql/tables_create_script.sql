-- Table: scorer.team

-- DROP TABLE scorer.team;

CREATE TABLE scorer.team
(
    team_no integer NOT NULL,
    team_name text COLLATE pg_catalog."default" NOT NULL,
    match_pts integer,
    CONSTRAINT "Team_pkey" PRIMARY KEY (team_no)
)

TABLESPACE pg_default;

ALTER TABLE scorer.team
    OWNER to postgres;

-- Table: scorer.player

-- DROP TABLE scorer.player;

CREATE TABLE scorer.player
(
    player_no integer NOT NULL,
    player_name text COLLATE pg_catalog."default" NOT NULL,
    team integer NOT NULL,
    CONSTRAINT "Player_pkey" PRIMARY KEY (player_no),
    CONSTRAINT player_team_fk FOREIGN KEY (player_no)
        REFERENCES scorer.team (team_no) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE scorer.player
    OWNER to postgres;
	


-- Table: scorer.match

-- DROP TABLE scorer.match;

CREATE TABLE scorer.match
(
    "time" text COLLATE pg_catalog."default" NOT NULL,
    match_no integer NOT NULL,
    date text COLLATE pg_catalog."default" NOT NULL,
    team_a integer,
    team_b integer,
    team_win integer,
    umpire_team integer NOT NULL,
    venue text COLLATE pg_catalog."default",
    CONSTRAINT "Match_pkey" PRIMARY KEY (match_no),
    CONSTRAINT match_team_win_pk FOREIGN KEY (team_win)
        REFERENCES scorer.team (team_no) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT match_teama_fk FOREIGN KEY (team_a)
        REFERENCES scorer.team (team_no) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT match_teamb_fk FOREIGN KEY (team_b)
        REFERENCES scorer.team (team_no) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT match_umpteam_fk FOREIGN KEY (umpire_team)
        REFERENCES scorer.team (team_no) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE scorer.match
    OWNER to postgres;
-- Index: fki_match_team_win_pk

-- DROP INDEX scorer.fki_match_team_win_pk;

-- Table: scorer.matchplayer

-- DROP TABLE scorer.matchplayer;

CREATE TABLE scorer.matchplayer
(
    player_match_no integer NOT NULL,
    match_no integer NOT NULL,
    player_no integer NOT NULL,
    runs_taken integer,
    balls_faced integer,
    runs_given integer,
    balls_bowled integer,
    fours integer,
    sixes integer,
    wides integer,
    no_balls integer,
    byes integer,
    wickets integer,
    CONSTRAINT "MatchPlayer_pkey" PRIMARY KEY (player_match_no),
    CONSTRAINT player_match_match_fk FOREIGN KEY (match_no)
        REFERENCES scorer.match (match_no) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT player_match_player_pk FOREIGN KEY (player_no)
        REFERENCES scorer.player (player_no) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE scorer.matchplayer
    OWNER to postgres;
-- Index: fki_player_match_match_fk

-- DROP INDEX scorer.fki_player_match_match_fk;



CREATE INDEX fki_player_match_match_fk
    ON scorer.matchplayer USING btree
    (match_no ASC NULLS LAST)
    TABLESPACE pg_default;

CREATE INDEX fki_match_team_win_pk
    ON scorer.match USING btree
    (team_win ASC NULLS LAST)
    TABLESPACE pg_default;
-- Index: fki_match_teama_fk

-- DROP INDEX scorer.fki_match_teama_fk;

CREATE INDEX fki_match_teama_fk
    ON scorer.match USING btree
    (team_a ASC NULLS LAST)
    TABLESPACE pg_default;
-- Index: fki_match_teamb_fk

-- DROP INDEX scorer.fki_match_teamb_fk;

CREATE INDEX fki_match_teamb_fk
    ON scorer.match USING btree
    (team_b ASC NULLS LAST)
    TABLESPACE pg_default;
-- Index: fki_match_umpteam_fk

-- DROP INDEX scorer.fki_match_umpteam_fk;

CREATE INDEX fki_match_umpteam_fk
    ON scorer.match USING btree
    (umpire_team ASC NULLS LAST)
    TABLESPACE pg_default;