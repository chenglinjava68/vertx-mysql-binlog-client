# MySQL Binlog Listener for Vert.x

A Vert.x client allowing applications tapping into MySQL replication stream.

# Getting Started

Please see the in source asciidoc documentation or the main documentation on the web-site for a full description:

* [Java in-source docs](../master/src/main/asciidoc/java/index.adoc)

# Running the tests

You can run tests with a specified MySQL instance:

```
% mvn test -Dbinlog.host=[host] -Dbinlog.port=[port] -Dbinlog.user=[user] -Dbinlog.password=[password] -Dbinlog.schema=[schema]
```

Be sure that the user has `ALL` privilege for the given schema.