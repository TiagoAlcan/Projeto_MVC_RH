Comandos para usar no h2 para acionar a sequencia

insert into departamentos (id, nome) values (nextval('departamentos_seq'),'Vendas');

select * from departamentos;

Comando para subir uma imagem de um banco de dados no Docker (MySQL)
docker run -d \
    -e MYSQL_ROOT_PASSWORD=root_pwd \
    -e MYSQL_USER=new_user \
    -e MYSQL_PASSWORD=my_pwd \
    -p 3306:3306 \
    mysql