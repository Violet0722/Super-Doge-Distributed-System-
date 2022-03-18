# Super-Doge-Distributed-System-
The team project I participated in during my master's study.
## Environment setup:

docker

node:v17.0.1

npm:8.1.0

vue/cli:4.5.15

(local running requires jdk and maven)

## Running steps:

Above running steps video includes all the steps and introduction of project structure.
Below is summary:

1 Database:

In database folder, there are two .sql files. import them to create databases.


2 Services:

Update database configuration in application.properties of Doge and Nike module.

Run `mvn clean install` at super-doge/services/super-doge folder

Run `docker-compose up` at super-doge/services/super-doge folder

This may need some time, after all the containers are up, go to [eureka dashboard](http://localhost:8686/) to check services status.

3 Client:

Run `npm i` at super-doge/client/super-doge-client folder

Run `npm run serve` at super-doge/client/super-doge-client folder
Then go to [super-doge-client](http://localhost:3000/) to open the web page

## Contact:

If you have any question, feel free to contact us.

Email: yunqi.li@ucdconnect.ie; yu.cao2@ucdconnect.ie
