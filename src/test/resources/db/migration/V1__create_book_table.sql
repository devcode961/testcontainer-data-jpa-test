
create table book
(
    id      serial primary key,
    title   varchar(255),
    price     decimal(4,2),
    publish_date timestamp with time zone
);