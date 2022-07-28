# Password storage demo (without Spring Security)

Since there is no native implementation for SHA3 in Java (Spring security provides it though) we are using the PBKDF2 hashing algorithm that does have a native java implementation.  

To test it, run a postgres container with this creds:
```shell
docker run -p 5432:5432 -e POSTGRES_PASSWORD=admin postgres
```

Then run the app
```shell
./gradlew bootRun
```

Through the `/api/register` and `/api/login` endpoints we can add and verify users. 