# Trip Reservation System

This is a microservices based architecture for an online trip reservation system.
You can find the architecture document, explaining some of the patterns to be used to build the system.
Each microservice can be deployed independently.
The backend database is mongodb.

## To build the system on a linux box you can:
1. Install virtualbox.
2. Install vagrant, in order to provision the application environment.

Once you have installed vagrant, from a command line, run the following command: vagrant up.

The linux box will be downloaded, and provisioned with the all the dependencies required to deploy the services.
There are two provisioners configured in the VagrantFile, the shell provisioner and the puppet provisioner.

## In the DEPLOYMENT folder you can find:
The provision.sh file, which is a shell provisioner to install all the main dependencies in the box.
The deploy.sh file, which is a shell provisioner to populate an initial set of users with a mongodb script, and build and deploy the services.
The folder "puppet", containing the puppet modules to install and configure mongodb.

Once the provisioner has finished, you will have a ready-to-go environment, and the services deployed and running in background, ready to be used.

The guest machine is configured with the ip 192.168.33.10.

The solution is shipped with some REST clients, to perform tests. You can find the clients in the folder /CODE/clients

These are the URLs of the micro services deployed in the box:

http://192.168.33.10:5673/login

http://192.168.33.10:5676/postRoom

http://192.168.33.10:5677/postTripProgram

http://192.168.33.10:5672/saveReservation

http://192.168.33.10:5671/searchReservationsHistory

http://192.168.33.10:5674/getRooms

http://192.168.33.10:5675/getTripPackages

If you deploy the solution in a different enviroment, you have to change the host name, and modify the port in the URL.

## If you want to build and deploy the solution on a windows or linux machine, you need:

Install java 1.7
Install maven.
Install mongo db, and set it to run in the default port.
Run the script to create a set of initial users for testing in the database, by running the command: 
mongo tripsreservations < /scripts/mongoProvision.js

Go to the folder CODE/TripReservationSystem and run the command to build the services: mvn clean package
Once you build the micro services, you can deploy and run them individually, in this way (the port number is up to you, you can change it):

java -jar search-reservations-history-service/target/search-reservations-*.jar 5671 

java -jar reserve-room-program-service/target/reserve-room-*.jar 5672 

java -jar login-service/target/login-*.jar 5673 

java -jar search-rooms-service/target/search-rooms-*.jar 5674 

java -jar search-trip-packages-service/target/search-trip-*.jar 5675 

java -jar post-rooms-service/target/post-rooms-*.jar 5676 

java -jar post-trip-program-service/target/post-trip-*.jar 5677 
