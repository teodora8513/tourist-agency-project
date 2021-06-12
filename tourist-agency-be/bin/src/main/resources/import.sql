/*Insert STATE values*/
insert into state (name) values ("Italija");
insert into state (name) values ("Bugarska");
insert into state (name) values ("Hrvatska");
insert into state (name) values ("Albanija");
insert into state (name) values ("Turska");
insert into state (name) values ("Francuska");
insert into state (name) values ("Engleska");
insert into state (name) values ("Srbija");
insert into state (name) values ("Kipar");

/*Insert DESTINATION values*/
/*Italija*/
insert into destination (postal_code, state_id, name) values (12001, 1, "Milano");
insert into destination (postal_code, state_id, name) values (12002, 1, "Verona");
insert into destination (postal_code, state_id, name) values (12003, 1, "Venecija");
/*Bugarska*/
insert into destination (postal_code, state_id, name) values (12301, 2, "Suncev breg");
insert into destination (postal_code, state_id, name) values (12302, 2, "Sofija");
/*Hrvatska*/
insert into destination (postal_code, state_id, name) values (12401, 3, "Pula");
insert into destination (postal_code, state_id, name) values (12402, 3, "Zagreb");
insert into destination (postal_code, state_id, name) values (12403, 3, "Split");


/*Insert TRANSPORTATION values*/
insert into transportation (type, price, season, start, end) values ("BUS", 50, "WINTER", 1,2);
insert into transportation (type, price, season, start, end) values ("CAR", 0, "AUTUMN", 1,2);
insert into transportation (type, price, season, start, end) values ("PLANE", 150, "WINTER", 1,3);
insert into transportation (type, price, season, start, end) values ("BUS", 50, "SUMMER", 2,3);
insert into transportation (type, price, season, start, end) values ("MINI_BUS", 100, "WINTER", 2,4);
insert into transportation (type, price, season, start, end) values ("CAR", 0, "SPRING", 3,4);
insert into transportation (type, price, season, start, end) values ("PLANE", 150, "SUMMER", 4,5);