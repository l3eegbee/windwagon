
-- ###
-- ###
-- ### KNIGHTS
-- ###
-- ###

--
-- ww_jarfile
--

CREATE TABLE ww_jarfile (
    id          BIGINT NOT NULL,
    path        VARCHAR NOT NULL,
    checksum    VARCHAR NOT NULL,
    description VARCHAR
);

ALTER TABLE ww_jarfile
    ADD CONSTRAINT pk_ww_jarfile PRIMARY KEY (id);

CREATE INDEX idx_jarfile__checksum ON ww_jarfile(checksum);

--
-- ww_component_class
--

CREATE TABLE ww_component_class (
    id          BIGINT NOT NULL,
    main_class  VARCHAR NOT NULL,
    description TEXT,
    official_id VARCHAR
);

ALTER TABLE ww_component_class
    ADD CONSTRAINT pk_ww_component_class PRIMARY KEY (id);

CREATE UNIQUE INDEX idx_component_class__main_class ON ww_component_class(main_class);

--
-- ww_componentclass_types
--

CREATE TABLE ww_componentclass_types (
    component_class BIGINT NOT NULL,
    type            VARCHAR NOT NULL
);

ALTER TABLE ww_componentclass_types
    ADD CONSTRAINT fk_componentclass_types__component_class FOREIGN KEY (component_class) REFERENCES ww_component_class(id);

CREATE INDEX idx_componentclass_types__component_class ON ww_componentclass_types(component_class);

--
-- ww_componentclass_jarfiles
--

CREATE TABLE ww_componentclass_jarfiles (
    component_class BIGINT NOT NULL,
    jarfile         BIGINT NOT NULL
);

ALTER TABLE ww_componentclass_jarfiles
    ADD CONSTRAINT fk_componentclass_jarfiles__component_class FOREIGN KEY (component_class) REFERENCES ww_component_class(id);

ALTER TABLE ww_componentclass_jarfiles
    ADD CONSTRAINT fk_componentclass_jarfiles__jarfile FOREIGN KEY (jarfile) REFERENCES ww_jarfile(id);

CREATE INDEX idx_componentclass_jarfiles__component_class ON ww_componentclass_jarfiles(component_class);

CREATE INDEX idx_componentclass_jarfiles__jarfile ON ww_componentclass_jarfiles(jarfile);

--
-- ww_component
--

CREATE TABLE ww_component (
    id              BIGINT NOT NULL,
    name            VARCHAR NOT NULL,
    description     TEXT,
    component_class BIGINT NOT NULL,
);

ALTER TABLE ww_component
    ADD CONSTRAINT pk_ww_component PRIMARY KEY (id);

ALTER TABLE ww_component
    ADD CONSTRAINT fk_component__component_class FOREIGN KEY (component_class) REFERENCES ww_component_class(id);

CREATE UNIQUE INDEX idx_component__name ON ww_component(name);

CREATE INDEX idx_component__component_class ON ww_component(component_class);

--
-- ww_constant
--

CREATE TABLE ww_constant (
    id           BIGINT NOT NULL,
    name         VARCHAR,
    description  TEXT,
    attribute    TEXT,
    type_value   CHARACTER VARYING(15) NOT NULL,
    constraints  VARCHAR,
    value        TEXT,
    order_value  INTEGER NOT NULL,
    final_value  BOOLEAN NOT NULL,
    hidden_value BOOLEAN NOT NULL,
    component    BIGINT NOT NULL
);

ALTER TABLE ww_constant
    ADD CONSTRAINT pk_ww_constant PRIMARY KEY (id);

ALTER TABLE ww_constant
    ADD CONSTRAINT fk_constant__component FOREIGN KEY (component) REFERENCES ww_component(id);

--
-- ww_official_knight
--

CREATE TABLE ww_official_knight (
    id            BIGINT NOT NULL,
    name          VARCHAR NOT NULL,
    description   TEXT,
    component     BIGINT NOT NULL,
    serialization TEXT
);

ALTER TABLE ww_official_knight
    ADD CONSTRAINT pk_ww_official_knight PRIMARY KEY (id);

ALTER TABLE ww_official_knight
    ADD CONSTRAINT fk_official_knight__component FOREIGN KEY (component) REFERENCES ww_component(id);

CREATE INDEX idx_official_knight__name ON ww_official_knight(name);

--
-- ww_knight
--

CREATE TABLE ww_knight (
    id            BIGINT NOT NULL,
    name          VARCHAR,
    description   TEXT,
    component     BIGINT NOT NULL
);

ALTER TABLE ww_knight
    ADD CONSTRAINT pk_ww_knight PRIMARY KEY (id);

ALTER TABLE ww_knight
    ADD CONSTRAINT fk_knight__component FOREIGN KEY (component) REFERENCES ww_component(id);

--
-- ww_page
--

CREATE TABLE ww_page (
    id            BIGINT NOT NULL,
    name          VARCHAR NOT NULL,
    description   TEXT,
    component     BIGINT NOT NULL
);

ALTER TABLE ww_page
    ADD CONSTRAINT pk_ww_page PRIMARY KEY (id);

ALTER TABLE ww_page
    ADD CONSTRAINT fk_page__component FOREIGN KEY (component) REFERENCES ww_component(id);

CREATE UNIQUE INDEX idx_page__name ON ww_page(name);

--
-- ww_brotherhood
--

CREATE TABLE ww_brotherhood (
   id           BIGINT NOT NULL,
   name         VARCHAR NOT NULL,
   description  TEXT,
   component    BIGINT NOT NULL,
);

ALTER TABLE ww_brotherhood
    ADD CONSTRAINT pk_ww_brotherhood PRIMARY KEY (id);

ALTER TABLE ww_brotherhood
    ADD CONSTRAINT fk_brotherhood__component FOREIGN KEY (component) REFERENCES ww_component(id);

CREATE UNIQUE INDEX idx_brotherhood__name ON ww_brotherhood(name);

--
-- ww_fencingmaster
--

CREATE TABLE ww_fencingmaster (
    id          BIGINT NOT NULL,
    name        VARCHAR,
    description TEXT,
    component   BIGINT NOT NULL,
    knight      BIGINT NOT NULL,
    brotherhood BIGINT NOT NULL
);

ALTER TABLE ww_fencingmaster
    ADD CONSTRAINT pk_ww_fencingmaster PRIMARY KEY (id);

ALTER TABLE ww_fencingmaster
    ADD CONSTRAINT fk_fencingmaster__component FOREIGN KEY (component) REFERENCES ww_component(id);

ALTER TABLE ww_fencingmaster
    ADD CONSTRAINT fk_fencingmaster__knight FOREIGN KEY (knight) REFERENCES ww_knight(id);

ALTER TABLE ww_fencingmaster
    ADD CONSTRAINT fk_fencingmaster__brotherhood FOREIGN KEY (brotherhood) REFERENCES ww_brotherhood(id);

CREATE INDEX idx_fencingmaster__name ON ww_fencingmaster(name);

--
-- ww_scribe
--

CREATE TABLE ww_scribe (
    id           BIGINT NOT NULL,
    name         VARCHAR NOT NULL,
    description  TEXT,
    component    BIGINT NOT NULL,
);

ALTER TABLE ww_scribe
    ADD CONSTRAINT pk_ww_scribe PRIMARY KEY (id);

ALTER TABLE ww_scribe
    ADD CONSTRAINT fk_scribe__component FOREIGN KEY (component) REFERENCES ww_component(id);

CREATE UNIQUE INDEX idx_scribe__name ON ww_scribe(name);

--
-- ww_cycle
--

CREATE TABLE ww_cycle (
    id          BIGINT NOT NULL,
    creation    DATE,
    description TEXT
);

ALTER TABLE ww_cycle
    ADD CONSTRAINT pk_ww_cycle PRIMARY KEY (id);

CREATE INDEX idx_cycle__creation ON ww_cycle(creation);

--
-- ww_raceset
--

CREATE TABLE ww_raceset (
    id          BIGINT NOT NULL,
    name        VARCHAR NOT NULL,
    description TEXT,
    cycle       BIGINT NOT NULL
);

ALTER TABLE ww_raceset
    ADD CONSTRAINT pk_ww_raceset PRIMARY KEY (id);

ALTER TABLE ww_raceset
    ADD CONSTRAINT fk_raceset__cycle FOREIGN KEY (cycle) REFERENCES ww_cycle(id);

CREATE INDEX idx_raceset__name_cycle ON ww_raceset(name,cycle);

--
-- ww_raceset_races
--

CREATE TABLE ww_raceset_races (
    raceset  BIGINT NOT NULL,
    race     BIGINT NOT NULL
);

ALTER TABLE ww_raceset_races
    ADD CONSTRAINT fk_raceset_races__raceset FOREIGN KEY (raceset) REFERENCES ww_raceset(id);

ALTER TABLE ww_raceset_races
    ADD CONSTRAINT fk_raceset_races__race FOREIGN KEY (race) REFERENCES ww_race(id);

CREATE INDEX idx_raceset_races__raceset ON ww_raceset_races(raceset);

--
-- ww_brotherhood_run
--

CREATE TABLE ww_brotherhood_run (
    id                 BIGINT NOT NULL,
    cycle              BIGINT NOT NULL,
    status             CHARACTER VARYING(15) NOT NULL,
    execution_duration BIGINT,
    serialization      TEXT,
    brotherhood        BIGINT NOT NULL,
    selected           BIGINT,
);

ALTER TABLE ww_brotherhood_run
    ADD CONSTRAINT pk_ww_brotherhood_run PRIMARY KEY (id);

ALTER TABLE ww_brotherhood_run
    ADD CONSTRAINT fk_brotherhood_run__cycle FOREIGN KEY (cycle) REFERENCES ww_cycle(id);

ALTER TABLE ww_brotherhood_run
    ADD CONSTRAINT fk_brotherhood_run__brotherhood FOREIGN KEY (brotherhood) REFERENCES ww_brotherhood(id);

CREATE INDEX idx_brotherhood_run__cycle ON ww_brotherhood_run(cycle);

--
-- ww_fencingmaster_run
--

CREATE TABLE ww_fencingmaster_run (
    id                   BIGINT NOT NULL,
    cycle                BIGINT NOT NULL,
    status               CHARACTER VARYING(15) NOT NULL,
    execution_duration   BIGINT,
    serialization        TEXT,
    fencingmaster        BIGINT NOT NULL,
    brotherhood          BIGINT NOT NULL,
    knight_serialization TEXT
);

ALTER TABLE ww_fencingmaster_run
    ADD CONSTRAINT pk_ww_fencingmaster_run PRIMARY KEY (id);

ALTER TABLE ww_fencingmaster_run
    ADD CONSTRAINT fk_fencingmaster_run__cycle FOREIGN KEY (cycle) REFERENCES ww_cycle(id);

ALTER TABLE ww_fencingmaster_run
    ADD CONSTRAINT fk_fencingmaster_run__fencingmaster FOREIGN KEY (fencingmaster) REFERENCES ww_fencingmaster(id);

ALTER TABLE ww_fencingmaster_run
    ADD CONSTRAINT fk_fencingmaster_run__brotherhood_run FOREIGN KEY (brotherhood) REFERENCES ww_brotherhood_run(id);

CREATE INDEX idx_fencingmaster_run__cycle ON ww_fencingmaster_run(cycle);

CREATE INDEX idx_fencingmaster_run__fencingmaster ON ww_fencingmaster_run(fencingmaster);

CREATE INDEX idx_fencingmaster_run__brotherhood_run ON ww_fencingmaster_run(brotherhood);

-- brotherhood selection
ALTER TABLE ww_brotherhood_run
    ADD CONSTRAINT fk_brotherhood_run__selected FOREIGN KEY (selected) REFERENCES ww_fencingmaster_run(id);

--
-- ww_scribe_run
--

CREATE TABLE ww_scribe_run (
    id                 BIGINT NOT NULL,
    cycle              BIGINT NOT NULL,
    status             CHARACTER VARYING(15) NOT NULL,
    execution_duration BIGINT,
    serialization      TEXT,
    scribe             BIGINT NOT NULL
);

ALTER TABLE ww_scribe_run
    ADD CONSTRAINT pk_ww_scribe_run PRIMARY KEY (id);

ALTER TABLE ww_scribe_run
    ADD CONSTRAINT fk_scribe_run__cycle FOREIGN KEY (cycle) REFERENCES ww_cycle(id);

ALTER TABLE ww_scribe_run
    ADD CONSTRAINT fk_scribe_run__scribe FOREIGN KEY (scribe) REFERENCES ww_scribe(id);

CREATE INDEX idx_scribe_run__cycle ON ww_scribe_run(cycle);

