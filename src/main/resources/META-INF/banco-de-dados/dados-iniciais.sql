insert into pet (pet_id, pet_nome, raca, tipo, idade, sexo, status) values (1, 'Guga', 'buldog', 'cachorro', date_sub(sysdate(), interval 1 day ), 'MASCULINO', 'DISPONIVEL');
insert into usuario (usuario_id, usuario_nome, email, idade, sexo) values (1, 'Davi', 'davi@davi.com', date_sub(sysdate(), interval 1 day ), 'MASCULINO');