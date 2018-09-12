# Spring Data JDBC use case tests

## taken from
https://github.com/spring-projects/spring-data-examples/tree/master/jdbc/basics

## documentation here
https://github.com/spring-projects/spring-data-jdbc

## notable aspects
* why is there no kind of `@Column` Annotation for entities? What do i do if i want to specify a column as obligatory like `@Column(nullable = false, length = 128)`
* why is there no use of `@NotNull` or other validation rules in the examples? Should validation of entities done by database rules?