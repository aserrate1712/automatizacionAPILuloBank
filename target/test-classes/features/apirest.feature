# language: es
Característica: Verificar la creacion de un usuario por medio de la APIREST REQREST
  Yo como usuario de la aplicacion REQREST deseo verificar que la creacion de un usuario por medio de una
  peticion POST funciona correctamente

  @creacionpacientePOST
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