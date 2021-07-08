/*Insert STATE values*/
insert into state (name) values ("Italy");
insert into state (name) values ("Bulgaria");
insert into state (name) values ("Croatia");
insert into state (name) values ("Albania");
insert into state (name) values ("Turkey");
insert into state (name) values ("France");
insert into state (name) values ("England");
insert into state (name) values ("Serbia");
insert into state (name) values ("Cyprus");

/*Insert DESTINATION values*/
/*Italija*/
insert into destination (postal_code, state_id, name) values (12001, 1, "Milano");
insert into destination (postal_code, state_id, name) values (12002, 1, "Verona");
insert into destination (postal_code, state_id, name) values (12003, 1, "Venice");
/*Bugarska*/
insert into destination (postal_code, state_id, name) values (12301, 2, "Sunny beach");
insert into destination (postal_code, state_id, name) values (12302, 2, "Sofia");
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

/*Insert HOTEL values*/
insert into hotel (name, address, rating, destination_id) values ("Rosa Grand", "Piazza Fontana 3", 5, 1);
insert into hotel (name, address, rating, destination_id) values ("Blue", "Fontana 3", 5, 2);
insert into hotel (name, address, rating, destination_id) values ("Hotel Grand", "Piazza 3", 5, 3);
insert into hotel (name, address, rating, destination_id) values ("Lagunes", "Piazza Fontana 3", 2, 2);
insert into hotel (name, address, rating, destination_id) values ("Astrix Hotel", "Piazza Fontana 3", 3, 4);
insert into hotel (name, address, rating, destination_id) values ("Revlon", "Milanino 3", 4, 5);

/*Insert ROOM values*/
insert into room (room_number, description, price_per_night, room_type, available, hotel_id) values ("1A", "A standard king bed room has one standard size king bed and a pull out sofa bed with one bathroom and a small area with a coffee maker. It comes with a television and cable box.", 40, "king_room", TRUE, 1);
insert into room (room_number, description, price_per_night, room_type, available, hotel_id) values ("2A", "A standard king bed room has one standard size king bed and a pull out sofa bed with one bathroom and a small area with a coffee maker. It comes with a television and cable box.", 40, "small_room", TRUE, 2);
insert into room (room_number, description, price_per_night, room_type, available, hotel_id) values ("3A", "A standard king bed room has one standard size king bed and a pull out sofa bed with one bathroom and a small area with a coffee maker. It comes with a television and cable box.", 40, "king_room", TRUE, 3);
insert into room (room_number, description, price_per_night, room_type, available, hotel_id) values ("4A", "A standard king bed room has one standard size king bed and a pull out sofa bed with one bathroom and a small area with a coffee maker. It comes with a television and cable box.", 40, "king_room", TRUE, 1);
