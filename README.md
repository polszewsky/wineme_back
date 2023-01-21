# wineme_back

Wine&Me backend application created to cover basic stack technologies.

Wine&Me is personal library (Vivino-style) app for building personal wine library and sharing them with other
friends/users.

# tech stack

- Java 17
- SpringBoot 3
- SpringSecurity 6 + Role/Privilege based auth
- Docker
- Hibernate 6 (ORM/JPA)
- Criteria Builder (Hibernate JPAModel)
- GitHub / CI
- PostgreSQL / H2 Database
- REST API + JsonSerialize
- JUnit + Mockito test
- DDD / CleanCode

# build / run

Database:
You need to run PostgreSQL DB on port 5432. Or You can use included docker implementation:

> cd ./scripts/postgres
>
> docker-compose up -d

Java App:
You need Java17 to run and compile.

please perform clean installation before running app
> ./mvnw clean install
