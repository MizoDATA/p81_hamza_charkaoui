drop database if exists p81_hamza;
create database if not exists p81_hamza;

use p81_hamza;

drop table if exists veterinario;
create table if not exists veterinario(

	id_veterinario int not null,
    nif varchar(12) unique not null,
    nomvete varchar(50),
    dir varchar(150),
    telefono varchar(20),
    email varchar(50),
    
    constraint pk_idveterinario primary key (id_veterinario)
	
);

drop table if exists mascota;
create table if not exists mascota (

	id_mascota int not null,
    numchip int unique,
    nommasc varchar(30),
    peso decimal(6,2),
    fecnacim date,
    tipo enum('perro','gato','otros'),
    id_veterinario int null default null,
    
    constraint pk_idmascota primary key (id_mascota),
    
    constraint fk_mascota_veterinario foreign key (id_veterinario) references veterinario(id_veterinario) 
    on delete set null
    
);






insert into veterinario
values
(1,'00112233A','Mizo','Calle Fondo de Bikini','642074101','mizo@gmail.com'),
(2,'33445566B','Goro','Calle Memphis Bats',null,'goro@gmail.com'),
(3,'66778899C','Toshi','Calle Tokyo Warriors','642074102','toshi@gmail.com');


insert into mascota
values
(1,10,'rocky',45.5,'2012-01-01','perro',1),
(2,20,'shimizu',55.8,'2005-12-01','otros',2),
(3,30,'bate',5,'2000-01-01','otros',2),
(4,40,'rolo',30,'2025-11-11','gato',1),
(5,50,'money',60,'2010-01-10','perro',3);

select * from mascota;

select * from veterinario;
















