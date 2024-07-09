# Genaaa

![logo Genaaa](https://github.com/JonathanStevenCM/LiterAlura/assets/74932904/8e2bb5a3-0a5e-42a5-a8f5-a5011dd38003)

Un mecanismo de busqueda y clasificacion de libros utilizando la api del proyecto gutenberg (https://gutendex.com).
Tambien recordar que la clasificacion se hace mediante nuestra base de datos la cual fue credad con postgresql mediante
las librerias de spring data jpa.

## Índice

* [Genaaa](#Genaaa)

- [Índice](#índice)

- [Funcionalidades del proyecto](#Funcionalidades-del-proyecto)

- [Como usar el programa](#Como-usar-el-programa)

- [Partes del codigo](#Partes-del-codigo)

- [Tecnologías](#Tecnologías)

## :hammer:Funcionalidades del proyecto

- `Funcionalidad 1`: Buscar libros mediante la api del proyecto gutenberg.
- `Funcionalidad 2`: Clasificar los libros que hemos almacenado en nuestra base de datos.

## Como usar el programa
Descargas el proyecto de github y lo abres en tu id.

Abrimos nuestro gestor de base de datos en este caso yo utilizo postgresql.

Despues nos vamos a variables de entorno del sistema en nuestro buscador mediante nuestro buscador de windows.
![variables de entorno](https://github.com/JonathanStevenCM/LiterAlura/assets/74932904/f84675f7-1e15-4c48-b8c9-938ed1421276)

Daremos click en la opcion Editar las variables de entorno del sistema y al darle click nos abrirá 
una ventana que dice Propiedades del sistema en la etiqueta de Opciones avanzadas nos dirigiremos al ultimo boton
con nombre Variables de entorno, daremos click, en dicho instante no abrirá otra venta con nombre de titulo
Variables de entorno nos dirigiremos al primer recuadro cuyo nombre es Variables de usuario para (el nombre de tu pc),
Nos dirigimos al boton que dice Nuevo y ahi generaremos un nombre para Nuestra base de datos en mi caso coloque DB_NAMA y
en la parte de abajo de Valor de la ira el nombre de nuestra base de datos en PostgreSQL, Lo mismo haremos para el HOST,
para nuestra contraseña de PostgreSQL  y para el nombre el usuario de nuestro PostgreSQL cuenta.

Ahora nos dirigimos a la carpeta resources de nuestro proyecto, abrimos el archivo application.properties y en las siquientes lineas
colocaras el nombre de las variables entre corchetes que anteriormente seleccionastes para todas tus variables de sistema
```
spring.datasource.url=jdbc:postgresql://${DB_HOST}/${DB_NAME}
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASSWORD}
```

y despues solo tienes que irte a la clase LiterAluraApplication Para correr el codigo creado.

## Partes del codigo


### Clase principal

La clase principal es la parte donde se consumen todas las clases creadas y donde se desarrolla la busqueda en la api para 
generear nuestros objetos, ademas de ejecutar los metodos de clasificacion que se consume de nuetro repositorio y tambien
es la generadora de nuestra selecciones.

### Clase LibroCont

Es basicamente la clase donde se guardan los datos que pedimos a la api y los combierte en objetos de esta misma

### Clase Person

Es la clase donde se guardan los autores y los diversos mecanismos que este tiene para gestionarse en si

### Interfaz repository

Ahi se encuentra la interfaz que se encarga de la conexcion con nuestra base de datos tanto de enviar como
de extraer los datos de esta.

### Otros archivos record

Estos son los encargados de al generarse la etiquetacion de los datos de la api gutendex para luego 
convertirse en objetos con nuestras clases.

### Archivos dentro de la carpeta service

Esos archivos se encargan de generar la peticion a la api gutendex los cuales despues seran consumidos
en la clase Principal.



## Tecnologías

- java 17
- Jackson
- PostGreSQL
- Spring Data JPA

