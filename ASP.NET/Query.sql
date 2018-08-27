
use dbLojaWeb
drop database dbLojaWeb

SELECT* FROM Usuario
SELECT* FROM Produto
SELECT* FROM CategoriaProduto

insert into CategoriaProduto(Nome, Descricao)
values('CatTeste', 'Desc da Cat')
go
insert into Produto(Nome, Descricao, Preco, Quantidade, CategoriaID)
values('ProdutoTeste', 'Desc do Prod', 123.23, 12, 1)

truncate table Usuario

truncate table Produto

truncate table CategoriaProduto

/*Name	Pass
Aluno	12345678
Lobo Mau	12345678
Chico Tripa	12345678
Coco Verde	12345678
Fim do Feriado	21345678
Bob Esponja	13245678
Capeta	1234567
Anjo Miguel	1234567
*/

insert into Usuario(Nome, Senha)
values('Aluno', 12345678),
('Lobo Mau', 12345678),
('Chico Tripa', 12345678),
('Coco Verde', 12345678),
('Fim do Feriado', 21345678),
('Bob Esponja', 12345678),
('Anjo Miguel',	1234567),
('Capeta', 1234567)
