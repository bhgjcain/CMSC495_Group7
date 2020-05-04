--Table to hold guest information
CREATE TABLE guest (
id INTEGER PRIMARY KEY,
first_name VARCHAR(50),
last_name VARCHAR(50) NOT NULL,
email  VARCHAR(75) NOT NULL UNIQUE,
);

--Table for room configuration
CREATE TABLE room_type (
type_id INTEGER PRIMARY KEY,
max_guest INTEGER,
number_of_beds INTEGER,
room_description VARCHAR(150)
);

--Table to hold room number and attributes
CREATE TABLE room (
room_id INTEGER PRIMARY KEY,
room_number INTEGER,
isSmokeFriendly BOOLEAN,
isPetFriendly BOOLEAN,
CONSTRAINT room_type_id FOREIGN KEY (type_id) 
references  room_type(type_id) on delete cascade 
);

--Table to hold reservation
CREATE TABLE reservation (
id INTEGER PRIMARY KEY,
checkInDate DATE,
checkOutDate DATE,
special_note VARCHAR(150),
CONSTRAINT guest_id FOREIGN KEY (id)
references guest(id) on delete cascade
);

--Table holding the room reservation
CREATE TABLE reserved_room (
id INTEGER PRIMARY KEY,
isReserved BOOLEAN,
CONSTRAINT room_type_id FOREIGN KEY (type_id) 
references  room_type(type_id) on delete cascade,
CONSTRAINT reservation_id FOREIGN KEY (id) 
references  reservation(id) on delete cascade 
);

--Table for guest is checked in and out 
CREATE TABLE occupied_room (
id INTEGER PRIMARY KEY,
check_in_time TIMESTAMP,
check_out_time TIMESTAMP,
CONSTRAINT reservation_id FOREIGN KEY (id) 
references  reservatioin(id) on delete cascade,
CONSTRAINT occupied_room_id FOREIGN KEY (room_id) 
references  room(room_id) on delete cascade
);

--Table to track guest history
CREATE TABLE stay_history (
id INTEGER PRIMARY KEY,
CONSTRAINT guest_id FOREIGN KEY (id)
references guest(id) on delete cascade,
CONSTRAINT occupied_room_id FOREIGN KEY (id) 
references  occupied_room(id) on delete cascade
);


