DROP TABLE IF EXISTS booking;
DROP TABLE IF EXISTS bookings;
DROP TABLE IF EXISTS act_reqs;
DROP TABLE IF EXISTS activities;
DROP TABLE IF EXISTS req_names;
DROP TABLE IF EXISTS requirements;
DROP TABLE IF EXISTS instructors;
DROP TABLE IF EXISTS instructor;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS customer;

CREATE TABLE act_reqs
(
  id        INT AUTO_INCREMENT
    PRIMARY KEY,
  fk_act_id INT          NULL,
  fk_req_id INT          NULL,
  req_value VARCHAR(200) NULL,
  CONSTRAINT act_reqs_id_uindex
  UNIQUE (id)
)
  ENGINE = InnoDB;

CREATE INDEX act_id
  ON act_reqs (fk_act_id);

CREATE INDEX req_id
  ON act_reqs (fk_req_id);

CREATE TABLE activities
(
  id          INT AUTO_INCREMENT
    PRIMARY KEY,
  name        VARCHAR(200) NULL,
  equipment   VARCHAR(500) NULL,
  description VARCHAR(500) NULL,
  imagePath   VARCHAR(200) NULL,
  CONSTRAINT activities_id_uindex
  UNIQUE (id)
)
  ENGINE = InnoDB;

ALTER TABLE act_reqs
  ADD CONSTRAINT act_id
FOREIGN KEY (fk_act_id) REFERENCES activities (id)
  ON UPDATE CASCADE
  ON DELETE CASCADE;

CREATE TABLE bookings
(
  id                INT AUTO_INCREMENT
    PRIMARY KEY,
  date              DATETIME     NULL,
  customerID        INT          NOT NULL,
  numOfParticipants INT          NULL,
  description       VARCHAR(500) NULL,
  activityID        INT          NOT NULL,
  instructorID      INT          NOT NULL,
  CONSTRAINT bookings_id_uindex
  UNIQUE (id),
  CONSTRAINT bookings_activities_id_fk
  FOREIGN KEY (activityID) REFERENCES activities (id)
)
  ENGINE = InnoDB;

CREATE INDEX bookings_customers_id_fk
  ON bookings (customerID);

CREATE INDEX bookings_activities_id_fk
  ON bookings (activityID);

CREATE INDEX bookings_instructors_id_fk
  ON bookings (instructorID);

CREATE TABLE customers
(
  id          INT AUTO_INCREMENT
    PRIMARY KEY,
  name        VARCHAR(250) NULL,
  companyName VARCHAR(250) NULL,
  phone       VARCHAR(50)  NULL,
  CONSTRAINT customer_id_uindex
  UNIQUE (id)
)
  ENGINE = InnoDB;

ALTER TABLE bookings
  ADD CONSTRAINT bookings_customers_id_fk
FOREIGN KEY (customerID) REFERENCES customers (id);

CREATE TABLE instructors
(
  id   INT AUTO_INCREMENT
    PRIMARY KEY,
  name VARCHAR(250) NULL,
  CONSTRAINT instructor_id_uindex
  UNIQUE (id)
)
  ENGINE = InnoDB;

ALTER TABLE bookings
  ADD CONSTRAINT bookings_instructors_id_fk
FOREIGN KEY (instructorID) REFERENCES instructors (id);

CREATE TABLE requirements
(
  id   INT AUTO_INCREMENT
    PRIMARY KEY,
  name VARCHAR(250) NULL,
  CONSTRAINT requirements_id_uindex
  UNIQUE (id)
)
  ENGINE = InnoDB;

ALTER TABLE act_reqs
  ADD CONSTRAINT req_id
FOREIGN KEY (fk_req_id) REFERENCES requirements (id)
  ON UPDATE CASCADE
  ON DELETE CASCADE;