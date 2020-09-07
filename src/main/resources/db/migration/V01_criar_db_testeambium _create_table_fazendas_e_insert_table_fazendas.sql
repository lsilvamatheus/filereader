create database  testeambium;

use testeambium;

create table fazendas(
	chave 			int auto_increment primary key,
    car 			varchar(100) not null,
	fazenda         varchar(100) not null,
    municipio	 	varchar(100) not null,
    area 			float4,
    anexo 			blob  null
);

insert into fazendas (car,fazenda,municipio,area) 
	values ('SP-3500550-A6DBBBDB42154A9EA3CAC74ABA72820D', 'FazendaA', 'Águas de Santa Bárbara', 126.9860),
		   ('SP-3500709-03FB464FCF764B3BA0F04A9E8719A019',  'FazendaB', 'Agudos', 523.5187),
		   ('SP-3500709-11D4EC791BC2428885EE85E57A229C00', 'FazendaC', 'Agudos', 195.4090),
		   ('SP-3500709-91DF76C8F3FE479CB1F32F1E885CC4D7', 'FazendaD', 'Agudos', 40.8893),
		   ('SP-3526803-A79BF84BF955469EA2DDA3F7E193C471', 'FazendaE', 'Lençóis Paulista', 62.9634),
		   ('SP-3526803-A7DD4191ABEC4151AF5FCE321E8C802A', 'FazendaF', 'Lençóis Paulista', 47.3234),
		   ('SP-3540002-D6C315DC7FE643A5A1D5125D6D8B7301', 'FazendaG', 'Pompéia', 2837.4167),
		   ('SP-3536703-110FFF542B1B4041AAAB2788A779E92C', 'FazendaH', 'Pederneiras', 62.2305),
		   ('SP-3535507-F74449650E50427EAA3CF3C3DB8103B9', 'FazendaI', 'Paraguaçu Paulista', 320.4603),
		   ('SP-3555000-D9C6EFF1C6DF47C893F7CA2A0842FDFD', 'FazendaJ', 'Tupã', 206.9556);

