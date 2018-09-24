# Spring Data JDBC use case tests

## prerequisites
* installed and running docker (get the latest from https://www.docker.com/get-started)
* use of testcontainers (https://www.testcontainers.org/usage.html)
* temporary database containers (https://www.testcontainers.org/usage/database_containers.html)

## important notes
* docker: settings - general: activate "Expose daemon on ... "
* docker: settings - shared drives:  c drive
* init script testcontainers: there is a need of annotating one´s tests with `@Sql(scripts = "classpath:schema.sql")`
otherwise init sql commands will not be executed for some reason
* init script for postgres: `CREATE TABLE IF NOT EXISTS public.order_entity (order_id SERIAL PRIMARY KEY, order_recipient character varying NOT NULL, order_sender character varying NOT NULL,order_date date NOT NULL DEFAULT ('now'::text)::date, order_state character varying);`

## taken from
https://github.com/spring-projects/spring-data-examples/tree/master/jdbc/basics

## documentation here
https://github.com/spring-projects/spring-data-jdbc

## notable aspects (with answers from Jens Schauder)
* why is there no kind of `@Column` Annotation for entities? 
What do i do if i want to specify a column as obligatory like `@Column(nullable = false, length = 128)`?
> Das ist Out of Scope für Spring Data JDBC für Validation kann man wenn man möchte den Standard für Beans Validation verwenden. (d.h. de facto Hibernate Validation wenn ich das richtig sehe). Hat aber erstmal nichts mit Persistenz zu tun.

* why is there no use of `@NotNull` or other validation rules in the examples? Should validation of entities done by database rules?
> Das ist im wesentlichen die gleiche Frage, wenn ich das richtig sehe, oder? Validierung kann Java seitig passieren, und/oder in der Datenbank. Ist SD-JDBC prinzipiell egal.

* how is auto-generation of the datasource done?
> Ich weiß zwar nicht genau was du meinst, aber die Antwort lautet: gar nicht.
  Variante a) anlegen von Tabellen und dergleichen: Werden wir sicherlich irgendwann mal machen, hat aber keine so hohe Priorität
  b) Konfiguration der Datasource(URL, user, passwort): Spring Data JDBC benötigt die einfach (bzw. genau genommen eine NamedParameterJdbcOperation); Es gibt noch keinen Spring Boot Support ich weiß aber nicht, was Spring Boot alleine dadurch tut, dass ein JDBC Treiber auf dem Klassenpfad ist.

* an enum gets not auto-converted when being inserted. see test case `TestOrderEntity`

## possible improvements
* enum mapping to int
> Enums get mapped to their name.

see: https://docs.spring.io/spring-data/jdbc/docs/1.0.0.RC2/reference/html/#jdbc.entity-persistence.types