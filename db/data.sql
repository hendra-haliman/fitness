SELECT 'CREATE DATABASE fitness'
WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'fitness')\gexec

\c fitness;

drop table if exists peserta;

create table peserta (
    id      bigserial primary key,     
    nama    varchar(255) not null,
    email   varchar(100) not null,
    passwd  varchar(100),
    nohp    varchar(30),
    status  varchar(30),
    OTP     int,
    nomor_kartu varchar(255),
    cvv         varchar(255),
    expiry_date varchar(255),
    nama_pemegang_kartu varchar(255)
);

drop table  if exists kartu_kredit;

create table kartu_kredit (
    id                  bigserial primary key,
    nomor_kartu         varchar(255),
    cvv                 varchar(255),
    expiry_date         varchar(255),
    nama_pemegang_kartu varchar(255)
);

