create table teacher(
    id integer identity not null,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    subject varchar(255) not null,
    primary key(id)
);
