create table topicos(
    id bigint not null auto_increment,
    titulo varchar(255) not null,
    mensagem  varchar(255) not null,
    dataCriacao   datetime not null,
    status varchar(100),
    autor_id bigint not null,
    curso varchar(100) not null,
    resposta  varchar(255),

    primary key(id),
    constraint fk_topicos_autor_id foreign key(autor_id) references usuarios(id)

    ) engine=InnoDB default charset=utf8mb4;



