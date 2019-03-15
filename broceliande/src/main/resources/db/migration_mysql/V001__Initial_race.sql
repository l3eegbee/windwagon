
--
-- ww_sequence_id
--

CREATE SEQUENCE ww_sequence_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

-- ###
-- ###
-- ### RACES
-- ###
-- ###

--
-- ww_horseid
--

CREATE TABLE ww_horseid (
    id        BIGINT NOT NULL,
    name      CHARACTER VARYING(30),
    birth     DATE,
    sex       CHARACTER VARYING(10),
    gelding   DATE,
    father    CHARACTER VARYING(255),
    mother    CHARACTER VARYING(255),
    fiability INTEGER,
    breed     CHARACTER VARYING(30),
    coat      CHARACTER VARYING(30)
);

ALTER TABLE ww_horseid
    ADD CONSTRAINT pk_ww_horseid PRIMARY KEY (id);

CREATE INDEX idx_horseid__natural_ids ON ww_horseid(name,birth,sex,father,mother);

CREATE INDEX idx_horseid__parent_ids ON ww_horseid(name,sex,birth);

--
-- ww_jockey
--

CREATE TABLE ww_jockey (
    id   BIGINT NOT NULL,
    name CHARACTER VARYING(50)
);

ALTER TABLE ww_jockey
    ADD CONSTRAINT pk_ww_jockey PRIMARY KEY (id);

CREATE INDEX idx_jockey__natural_ids ON ww_jockey(name);

--
-- ww_owner
--

CREATE TABLE ww_owner (
    id   BIGINT NOT NULL,
    name CHARACTER VARYING(50)
);

ALTER TABLE ww_owner
    ADD CONSTRAINT pk_ww_owner PRIMARY KEY (id);

CREATE INDEX idx_owner__natural_ids ON ww_owner(name);

--
-- ww_rancher
--

CREATE TABLE ww_rancher (
    id   BIGINT NOT NULL,
    name CHARACTER VARYING(50)
);

ALTER TABLE ww_rancher
    ADD CONSTRAINT pk_ww_rancher PRIMARY KEY (id);

CREATE INDEX idx_rancher__natural_ids ON ww_rancher(name);

--
-- ww_trainer
--

CREATE TABLE ww_trainer (
    id   BIGINT NOT NULL,
    name CHARACTER VARYING(50)
);

ALTER TABLE ww_trainer
    ADD CONSTRAINT pk_ww_trainer PRIMARY KEY (id);

CREATE INDEX idx_trainer__natural_ids ON ww_trainer(name);

--
-- ww_racecourse
--

CREATE TABLE ww_racecourse (
    id      BIGINT NOT NULL,
    name    CHARACTER VARYING(50),
    country CHARACTER VARYING(30)
);

ALTER TABLE ww_racecourse
    ADD CONSTRAINT pk_ww_racecourse PRIMARY KEY (id);

CREATE INDEX idx_racecourse__natural_ids ON ww_racecourse(name,country);

--
-- ww_meeting
--

CREATE TABLE ww_meeting (
    id             BIGINT NOT NULL,
    date           DATE,
    racecourse     BIGINT,
    number         INTEGER,
    wind_speed     DOUBLE PRECISION,
    wind_direction CHARACTER VARYING(10),
    temperature    DOUBLE PRECISION,
    climat         CHARACTER VARYING(30),
    field          CHARACTER VARYING(15)
);

ALTER TABLE ww_meeting
    ADD CONSTRAINT pk_ww_meeting PRIMARY KEY (id);

ALTER TABLE ww_meeting
    ADD CONSTRAINT fk_meeting__racecourse FOREIGN KEY (racecourse) REFERENCES ww_racecourse(id);

CREATE INDEX idx_meeting__natural_ids ON ww_meeting(date,number);

--
-- ww_race
--

CREATE TABLE ww_race (
    id           BIGINT NOT NULL,
    meeting      BIGINT,
    number       INTEGER,
    name         CHARACTER VARYING(80),
    status       CHARACTER VARYING(10),
    start        TIMESTAMP,
    real_start   TIMESTAMP,
    distance     DOUBLE PRECISION,
    benefit      DOUBLE PRECISION,
    discipline   CHARACTER VARYING(15),
    duration     INTEGER,
    stopped      CHARACTER VARYING(255),
    disqualified CHARACTER VARYING(255),
    fallen       CHARACTER VARYING(255)
);

ALTER TABLE ww_race
    ADD CONSTRAINT pk_ww_race PRIMARY KEY (id);

ALTER TABLE ww_race
    ADD CONSTRAINT fk_race__meeting FOREIGN KEY (meeting) REFERENCES ww_meeting(id);

CREATE INDEX idx_race__natural_ids ON ww_race(meeting,number);

--
-- ww_racetypes
--

CREATE TABLE ww_racetypes (
    race  BIGINT NOT NULL,
    types CHARACTER VARYING(25)
);

ALTER TABLE ww_racetypes
    ADD CONSTRAINT fk_racetypes__race FOREIGN KEY (race) REFERENCES ww_race(id);

CREATE INDEX idx_racetypes__natural_ids ON ww_racetypes(race);

--
-- ww_racebets
--

CREATE TABLE ww_racebets (
    race BIGINT NOT NULL,
    bets CHARACTER VARYING(20)
);

ALTER TABLE ww_racebets
    ADD CONSTRAINT fk_racebets__race FOREIGN KEY (race) REFERENCES ww_race(id);

CREATE INDEX idx_racebets__natural_ids ON ww_racebets(race);

--
-- ww_odds
--

CREATE TABLE ww_odds (
    id    BIGINT NOT NULL,
    race  BIGINT,
    date  TIMESTAMP,
    total DOUBLE PRECISION
);

ALTER TABLE ww_odds
    ADD CONSTRAINT pk_ww_odds PRIMARY KEY (id);

ALTER TABLE ww_odds
    ADD CONSTRAINT fk_odds__race FOREIGN KEY (race) REFERENCES ww_race(id);

CREATE INDEX idx_odds__natural_ids ON ww_odds(race,date);

--
-- ww_simple
--

CREATE TABLE ww_simple (
    id     BIGINT NOT NULL,
    odds   BIGINT,
    number CHARACTER VARYING(3),
    simple DOUBLE PRECISION
);

ALTER TABLE ww_simple
    ADD CONSTRAINT pk_ww_simple PRIMARY KEY (id);

ALTER TABLE ww_simple
    ADD CONSTRAINT fk_simple__odds FOREIGN KEY (odds) REFERENCES ww_odds(id);

CREATE INDEX idx_simple__natural_ids ON ww_simple(odds,number);

--
-- ww_place
--

CREATE TABLE ww_place (
    id       BIGINT NOT NULL,
    race     BIGINT,
    number   INTEGER,
    distance CHARACTER VARYING(255),
    duration INTEGER,
    horse    INTEGER
);

ALTER TABLE ww_place
    ADD CONSTRAINT pk_ww_place PRIMARY KEY (id);

ALTER TABLE ww_place
    ADD CONSTRAINT fk_place__race FOREIGN KEY (race) REFERENCES ww_race(id);

CREATE INDEX idx_place__natural_ids ON ww_place(race,number,horse);

--
-- ww_price
--

CREATE TABLE ww_price (
    id        BIGINT NOT NULL,
    race      BIGINT,
    bet       CHARACTER VARYING(20),
    pricename CHARACTER VARYING(15),
    price     DOUBLE PRECISION,
    ticket    CHARACTER VARYING(255)
);

ALTER TABLE ww_price
    ADD CONSTRAINT pk_ww_price PRIMARY KEY (id);

ALTER TABLE ww_price
    ADD CONSTRAINT fk_price__race FOREIGN KEY (race) REFERENCES ww_race(id);

CREATE INDEX idx_price__natural_ids ON ww_price(race,bet,pricename,ticket);

--
-- ww_horse
--

CREATE TABLE ww_horse (
    id                   BIGINT NOT NULL,
    race                 BIGINT,
    horse_id             BIGINT,
    number               INTEGER,
    runner               BOOLEAN,
    supplemented         BOOLEAN,
    pregnant             BOOLEAN,
    stall                INTEGER,
    stable               CHARACTER VARYING(3),
    weight               DOUBLE PRECISION,
    distance             DOUBLE PRECISION,
    career_profit        DOUBLE PRECISION,
    previous_year_profit DOUBLE PRECISION,
    victory_profit       DOUBLE PRECISION,
    place_profit         DOUBLE PRECISION,
    year_profit          DOUBLE PRECISION,
    horseshoe            CHARACTER VARYING(15),
    blinder              CHARACTER VARYING(15),
    trainer              BIGINT,
    owner                BIGINT,
    rancher              BIGINT,
    jockey               BIGINT
);

ALTER TABLE ww_horse
    ADD CONSTRAINT pk_ww_horse PRIMARY KEY (id);

ALTER TABLE ww_horse
    ADD CONSTRAINT fk_horse__horse_id FOREIGN KEY (horse_id) REFERENCES ww_horseid(id);

ALTER TABLE ww_horse
    ADD CONSTRAINT fk_horse__jockey FOREIGN KEY (jockey) REFERENCES ww_jockey(id);

ALTER TABLE ww_horse
    ADD CONSTRAINT fk_horse__owner FOREIGN KEY (owner) REFERENCES ww_owner(id);

ALTER TABLE ww_horse
    ADD CONSTRAINT fk_horse__rancher FOREIGN KEY (rancher) REFERENCES ww_rancher(id);

ALTER TABLE ww_horse
    ADD CONSTRAINT fk_horse__trainer FOREIGN KEY (trainer) REFERENCES ww_trainer(id);

ALTER TABLE ww_horse
    ADD CONSTRAINT fk_horse__race FOREIGN KEY (race) REFERENCES ww_race(id);

CREATE INDEX idx_horse__natural_ids ON ww_horse(race,number);

