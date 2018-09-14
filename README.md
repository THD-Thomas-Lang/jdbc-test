# Spring Data JDBC use case tests

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

* Schema changes? How are schema changes to the model handled by Spring Data JDBC? Do i have to mirror the changes on to the database?
