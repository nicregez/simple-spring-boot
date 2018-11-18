simple-spring-boot
==================

Build and Test
--------------

    $ mvn package

Push
----

    $ cf push ssb -m 768mb  -p target/simple-spring-boot-0.1.0.jar --random-route
    $ cf app ssb

Use
---

Put the randomly generated route into variables DOMAIN and HOST for ease of use

    $ DOMAIN=scapp.io
    $ HOST=...
    $ curl http://${HOST}.${DOMAIN}/welcome -s | jq "."

blue/green (version upgrade)
----------------------------

Increase the release version to 0.2.0 in pom.xml after some modifications in the code

    $ cf rename ssb ssb-old
    $ cf push ssb -m 768mb -p target/simple-spring-boot-0.2.0.jar -d $DOMAIN -n $HOST
    $ cf delete ssb-old -f

Clean up
--------

Delete the application

    $ cf delete ssb -f

