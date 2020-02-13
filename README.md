# How to start

### 1. Start containers
```shell script
cd containers
docker-compose up -d
```

### 2. Register kafka and postgres in consul
```shell script
cd containers
./register.sh
```

### 3. Migrate schema
```shell script
cd flyway
mvn flyway:migrate
```

### 4. Run app
If you are running app in IntelliJ IDEA, open Run Configuration for ProducerApplication and set **Working Directory** to `$MODULE_WORKING_DIR$`

### 5. Copy files for producer app
Download [data from here](https://www.kaggle.com/jackywangkaggle/hard-drive-data-and-stats/data) or take some files from `data/archive` folder and move it to `data/inbound`.
Files should be catched by producer app and published to the Kafka broker.
Consumer should receive them and save to the database

### 6. After database filled with some data, run batch job by opening this url:
```
http://localhost:11003/job/analytics/ST12000NM0007

ST12000NM0007 - is a model number 
```

### 7. Check `analytics_by_model` table
It should contain average value for all HDD S.M.A.R.T. reports by model (in our case - `ST12000NM0007`)

### Metrics
http://localhost:11002/actuator/metrics/reportsAdded
http://localhost:11002/actuator/metrics/reportsIgnored