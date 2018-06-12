CREATE ROLE crm_role
  NOSUPERUSER
  INHERIT
  NOCREATEDB
  NOCREATEROLE
  NOREPLICATION;
CREATE ROLE crm_user
  LOGIN
  PASSWORD 'crm_user'
  NOSUPERUSER
  INHERIT
  NOCREATEDB
  NOCREATEROLE
  NOREPLICATION;
GRANT crm_role TO crm_user;

CREATE DATABASE users WITH OWNER = "crm_role" ENCODING 'UTF8';
GRANT ALL PRIVILEGES ON DATABASE users to "crm_role";


DROP TABLE IF EXISTS person;

CREATE TABLE person (
  id      BIGSERIAL PRIMARY KEY,
  name    TEXT        NOT NULL,
  surname TEXT        NOT NULL,
  date    TIMESTAMPTZ NOT NULL DEFAULT now()
);

ALTER TABLE person
  ADD COLUMN status TEXT DEFAULT 'DISABLED' NOT NULL;

ALTER TABLE person
  ADD COLUMN first_visit BOOLEAN DEFAULT FALSE NOT NULL;

ALTER TABLE person
  ADD COLUMN nip TEXT;
DROP FUNCTION IF EXISTS demographic_table_range();
CREATE OR REPLACE FUNCTION demographic_table_range()
  RETURNS INT4RANGE
AS $$ SELECT r.v
      FROM (VALUES ('(0,24]' :: INT4RANGE),
        ('[25,30]' :: INT4RANGE),
        ('[31,34]' :: INT4RANGE),
        ('[35,40]' :: INT4RANGE),
        ('[41,50]' :: INT4RANGE),
        ('[51,)' :: INT4RANGE)) AS r(v)
$$
LANGUAGE SQL
STABLE;
COMMENT ON FUNCTION demographic_table_range()
IS 'Zwraca tabelę przedzialów dla ustalonych grup wiekowych';

DROP TABLE IF EXISTS address;
CREATE TABLE address (
  id           BIGSERIAL PRIMARY KEY,
  person_id    BIGINT REFERENCES person,
  street       TEXT,
  house_number TEXT,
  flat_number  TEXT,
  city         TEXT,
  postal_code  TEXT,
  country      TEXT,
  region       TEXT,
  type         TEXT
);
ALTER TABLE address
  OWNER TO crm_role;