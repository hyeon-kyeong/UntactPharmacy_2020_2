DROP TABLE Post CASCADE CONSTRAINTS;
DROP TABLE Reservation CASCADE CONSTRAINTS;

DROP SEQUENCE post_id_seq;
DROP SEQUENCE reserv_id_seq;

CREATE TABLE Post (
    post_id     NUMBER(4)		PRIMARY KEY, 
    user_id     VARCHAR2(20), 
	med_id		VARCHAR2(20),
	post_date	VARCHAR2(20),
	title		VARCHAR2(100),
	content		VARCHAR2(700)	NOT NULL,
    ingestion_start VARCHAR2(20),
    ingestion_end VARCHAR2(20)
);

CREATE TABLE Reservation (
    reserv_id   NUMBER(4)        PRIMARY KEY,
    user_id     VARCHAR2(20),
    med_id      VARCHAR2(20), 
    pharm_name  VARCHAR2(100),       
    reserv_date VARCHAR2(20), 
    address     VARCHAR2(100)
);

CREATE SEQUENCE post_id_seq
	START WITH 1
	INCREMENT BY 1;

CREATE SEQUENCE reserv_id_seq
	START WITH 1
	INCREMENT BY 1;
    
alter sequence post_id_seq nocache;

alter sequence reserv_id_seq nocache;