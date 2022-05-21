# language: es
Característica: Verificar la creacion de un usuario por medio de la APIREST REQREST
  Yo como usuario de la aplicacion REQREST deseo verificar que la creacion de un usuario por medio de una
  peticion POST funciona correctamente

  @creacionusuarioPOST
  Esquema del escenario: realizar una peticion POST para verificar que la creacion de un usuario fue satisfactoria
    Dado que el usuario crea una peticion con la informacion inicial
      |name|job|
      |<name>|<job>|
    Cuando el usuario realice una peticion de tipo POST sobre el endpoint /api/users
    Entonces verifica la creacion de usuario por medio de una respuesta 201 y con la informacion inicial
    Ejemplos:
    |name                | job           |
    |alejandro Serrate x | automatizator |
    |juan camilo herrera | developer     |

  @listadousuariosGET
  Esquema del escenario: realizar una peticion GET para verificar la existencia de usuarios previamente creados
    Dado que el usuario desea consultar la existencia de un usuario previamente creado con datos
      |id|email|first_name|last_name|avatar|
      |<id>|<email>|<first_name>|<last_name>|<avatar>|
    Cuando el usuario realice una peticion de tipo GET sobre el endpoint /api/users?page=2
    Entonces verifica la existencia de los usuarios por medio de una respuesta 200 y con la informacion inicial
    Ejemplos:
      | id | email                      | first_name | last_name | avatar                                   |
      | 10 | byron.fields@reqres.in     | Byron      | Fields    | https://reqres.in/img/faces/10-image.jpg |
      | 8  | lindsay.ferguson@reqres.in | Lindsay    | Ferguson  | https://reqres.in/img/faces/8-image.jpg  |


  @obtenerusuarioGET
  Esquema del escenario: realizar una peticion GET para verificar la existencia de un usuario previamente creado por su id
    Dado que el usuario desea consultar la existencia de un usuario previamente creado con datos
      |id|email|first_name|last_name|avatar|
      |<id>|<email>|<first_name>|<last_name>|<avatar>|
    Cuando el usuario realice una peticion de tipo GET sobre un usuario usando el endpoint /api/users/
    Entonces verifica la existencia del usuario por medio de una respuesta 200 y con la informacion inicial
    Ejemplos:
      | id | email                      | first_name | last_name | avatar                                   |
      | 12 | rachel.howell@reqres.in    | Rachel     | Howell    | https://reqres.in/img/faces/12-image.jpg |
      | 8  | lindsay.ferguson@reqres.in | Lindsay    | Ferguson  | https://reqres.in/img/faces/8-image.jpg  |


  @eliminarusuarioDELETE
  Esquema del escenario: realizar una peticion DELETE para eliminar un usuario existente
    Dado que se desea eliminar un usuario previamente creado con <id>
    Cuando el usuario realice una peticion de tipo DELETE sobre un usuario usando el endpoint /api/users/
    Entonces verifica la existencia del usuario por medio de una respuesta 204
    Ejemplos:
      | id |
      | 12 |
      | 8  |







