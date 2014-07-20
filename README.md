RMT_Backend
===========

[![Build Status](https://travis-ci.org/pongo710/RMT_Backend.svg?branch=master)](https://travis-ci.org/pongo710/RMT_Backend)

Required
--------
* mongodb on localhost
* mvn

Run
---
* mvn jetty:run


API
---
Default entry point: http://localhost:8080/api

* Create Tree: POST to /trees with json content
* Get Tree By Id: GET to /trees/{id}
* Get Trees By Votes: GET to /trees
* Vote for Tree: POST to /trees/{id}/vote
