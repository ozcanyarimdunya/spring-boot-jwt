#### Without Authentication

----
`curl http://localhost:8080/task`

`curl http://localhost:8080/task/1`

`curl -H "Content-Type: application/json" -X POST -d '{"description": "Play football"}'  http://localhost:8080/task`

`curl -H "Content-Type: application/json" -X PUT -d '{"description": "Dont play football "}'  http://localhost:8080/task/1`

`curl -X DELETE http://localhost:8080/task/1`

#### With Authentication

----
`curl -H "Content-Type: application/json" -X POST -d '{"username": "admin","password": "password"}' http://localhost:8080/users/sign-up`

`curl -i -H "Content-Type: application/json" -X POST -d '{"username": "admin","password": "password"}' http://localhost:8080/login`

`curl -H "Content-Type: application/json" -H "Authorization: Bearer XXXXX" -X POST -d '{"description": "Play any sports"}'  http://localhost:8080/tasks`

`curl -H "Authorization: Bearer XXXXX" http://localhost:8080/tasks`