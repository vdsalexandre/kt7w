## MyCocktail kotlin

### Application to find a cocktail from ingredients

#### Example of use application :

| METHOD | URL                                                    | RESULT                                         |
|--------|--------------------------------------------------------|------------------------------------------------|
| GET    | http://localhost:9090/mycocktail/cocktail/all          | find all cocktails                             |
| GET    | http://localhost:9090/mycocktail/cocktail/5020         | find cocktail with **id**                      |
| GET    | http://localhost:9090/mycocktail/ingredient/all        | find all existing ingredients                  |
| GET    | http://localhost:9090/mycocktail/ingredient/all/soft   | find all ingredients by **type**               |
| POST   | http://localhost:9090/mycocktail/ingredient/add        | add new ingredient using @RequestBody          |
| DELETE | http://localhost:9090/mycocktail/ingredient/del/45     | delete ingredient by **id**                    |