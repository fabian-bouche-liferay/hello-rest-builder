# Greetings

Returns HTTP 200
http://localhost:8080/o/hello/1.0.0/greet?person=Fabian

Returns HTTP 402
http://localhost:8080/o/hello/1.0.0/greet?person=Lady%20Gaga

Returns HTTP 403
http://localhost:8080/o/hello/1.0.0/greet?person=James%20Bond

Returns HTTP 404
http://localhost:8080/o/hello/1.0.0/greet?person=Wally

Returns HTTP 410
http://localhost:8080/o/hello/1.0.0/greet?person=The%20Invisible%20Man

Returns HTTP 413
http://localhost:8080/o/hello/1.0.0/greet?person=ABCDEFGHIJKLMNOPQRSTUVWXYZ

Returns HTTP 500
http://localhost:8080/o/hello/1.0.0/greet?person=oops