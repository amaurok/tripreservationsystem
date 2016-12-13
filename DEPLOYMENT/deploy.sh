#!/bin/bash

#Populate the database.
mongo tripsreservations < /scripts/mongoProvision.js


#Deploy and run the services.
cd /tripSystem/TripReservationSystem
mvn clean package
java -jar search-reservations-history-service/target/search-reservations-*.jar 5671 &
java -jar reserve-room-program-service/target/reserve-room-*.jar 5672 &
java -jar login-service/target/login-*.jar 5673 &
java -jar search-rooms-service/target/search-rooms-*.jar 5674 &
java -jar search-trip-packages-service/target/search-trip-*.jar 5675 &
java -jar post-rooms-service/target/post-rooms-*.jar 5676 &
java -jar post-trip-program-service/target/post-trip-*.jar 5677 &

