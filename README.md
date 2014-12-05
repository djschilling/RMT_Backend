RMT_Backend
===========

[![Build Status](https://travis-ci.org/pongo710/RMT_Backend.svg?branch=master)](https://travis-ci.org/pongo710/RMT_Backend)

Required
--------
* mongodb on localhost
* mvn

Run
---
* ```mvn jetty:run```


API-Documentation
---
Default entry point: /api

Documentation about the REST-API can allways be found at /api-doc in a running version of this application.
An instance of this documentation is published at: http://rmt.davidschilling.de/v2/api-doc/

Authentication
---

Authentication is done with Basic-Authentication.

If an API is used unauthenticated which needs authentication a status code of 401(Unauthorized) is returned.

When first requesting the REST-API, you get a COOKIE. This cookie is used to identify users. By sending this cookie the application knows what your status is. (logged in/logged out)
If you want to authenticate yourself, send a HTTP-Request with your credentials as Basic-Authentication in the Authentication-header to a protected endpoint. 
For initial authentication /api/login is the best choice.

Example of login with curl:

```curl -u ${USERNAME}:${PASSWORD} http://${APP_HOST}/api/login```