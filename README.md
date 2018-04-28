# file-reader
Descripción
File reader es una aplicación que permite la lectura, indexación y envío de información de facturas
en PDF. Permite subir archivos a la plataforma, los cuales son leídos y posteriormente, junto
con el script de implementación, esta información puede enviarse a cualquier sitio para que este 
maneje esta informacion en sus formularios y sea enviado a su base de datos.

Problema identificado
Los proveedores de nuestro cliente le envian facturas al departamento de gestion de documebtos,
el cual realiza manualmente el indexado de facturas, en este proceso se pudo notar que se pierde mucho tiempo
en tener que estar analizando individualmente cada una de las facturas para sacar la información importante,
introducirla en los formulario de la aplicación para luego subirla a la base de datos. Es un proceso muy tardado.

Solución
Identificamos que una solución viable sería intervenir justo en el indexado de las facturas. Los proveedores de nuestro cliente enviarán facturas basadas en una plantilla predeterminada por nosotros, la cual posteriormente llenarán con los datos necesarios y la envoarán al departamente de gestion de documentos. Estas plantillas contendrán llaves las cuales nos permitirán extraer información fácilmente. Una vez que la factura llega al departamento de gestion de documentos, estos utilizarán el programa para leer rápidamente todas las facturas y que automáticamente se suba la información a la base de datos. Ahorrando mucho tiempo.

Arquitectura.
La arquitectura de la aplicación será cliente servidor para toda la parte de autenticación de usuarios, ademas de que se estará manejando la subida de templates al servidor, la recuperación de contraseñas y otros archivos. Se estará manejando un java web project con servlets, jsps, html, mysql, css y js.

Tabla de contenidos (ToC) con enlaces.
1.-Requerimientos
2.-Paquetes Adicionales
3.-Instalacion
4.-Configuracion
5.-Uso
6.-Contribucion
7.-Roadmap


# Requerimientos:
Servidores de aplicación
Apache Tomcat
8.0.27

Bases de datos
MariaDB
10.1.29-MariaDB

# Paquetes adicionales.
JDK 1.8
mysqlconnector
preflightapp
PDFbox
xmpbox
fontbox

Fonts:
Google Fonts

# Instalación:
¿Cómo instalar el ambiente de desarrollo?
-Opcion 1
Clonar este repositorio de github.
Asegurarse que el servidor al que se subirá cumple con los requisitos necesarios para la aplicación.
Asegurarse que todos los driver y dependencias están y son compatibles con el entorno en el que se implementará
Subir el programa a su servidor.
Listo

2.-Opcion 2
Descargar el archivo jar/war
Asegurarse que se tienen los comandos para ejecucion de estos archivos
Correr el archivo.
Listo

¿Cómo ejecutar pruebas manualmente?
Se puede hacer la utilización de la herramienta JUNIT
-Se pueden probar los módulos por separado si se desea.
-Se coloca localmente los archivos de este repositorio en su máquina
-Con la utilización de un IDE de su preferencia, subir el proyecto
-Asegurarse que todas las dependencias y modulos estan incluidos en el proyecto
-Probar los diferentes módulos por separado o todo el sistema.
-Listo

¿Cómo implementar la solución en producción en un ambiente local o en la nube como Heroku?
1.- En ambiente local
Descargar los archivos de este repositorio
Utilizar un servidor local como lo es XAMPP
Configurarlo y comenzarlo (Apache - Mysql).
Poner los archidos del proyecto dentro de las carpetas htdocs
Establecer la base de datos
Acceder al programa mediante un browser como Google Chrome.
Listo

2.- En la nube
Descargar los archivos de este repositorio.
Configurar el servidor de la nube con las características y configuraciones necesarias para correr este programa
Establecer la base de datos para el almacenamiento de usuarios y archivos.
Subir los archivos al servidor.
Listo

# Configuración:
Configuración del producto (archivos de configuración).
web.xml
Dentro de este archivos se establecen los servlets y rutas que se estarán manejando en la aplicación, asi como algunos atributos de la session del usuario. La version, el juego de caracteres, la locacion, el locale, entre otras cosas.

upload.java
Este archivo será principalmente utilizado por el desarrollador del programa para agregar nuevos templates y maneras de manejar los datos de los archivos pdfs que se estarán subiendo a la plataforma.

login.java
Este archivo contiene la información de la conexion a la base de datos, si se requiere hacer un cambio de locacion es importante cambiar los contenidos de este archivo para que todo funcione correctamente.

Configuración de los requerimientos.
En caso de que sea local se deben de establecer los archivos config.ini para decidir cuales son las rutas y los puertos a los que se les estará llamando para llegar a la aplicación, es muy importante que no existan 2 puertos que lleven al mismo lugar para que no haya proeblemas. Por defecto se establece :8000 para apache y 3060 para mysql.

Para establecerlo en la nube es igual, debemos cuidar dentro de nuestro servidor que las rutas estén correctas y que al momento de subir nuestra aplicación y ponerla en producción, las direcciones y las bases de datos estén establecidas correctamente.

# Uso:
Sección de referencia para usuario final. Manual que se hará referencia para usuarios finales.
Paso 1: Acceder
Dirigirse a http://localhost:8084/FileReader/ o si está en la nube http://yourdomain/FileReader/
Esto nos redirigirá a la pantalla de login.
Paso 2: Registro
Dar cick en registro e introducir nuestro nombre, email, password y pregunta de rescate.
Paso 3: Login
Acceder a la aplicación con nuestras credenciales.
Paso 4: Ver templates
Hecha un vistazo a los templates disponibles que se pueden utilizar para la app
Paso 5: Ve tus archivos
Esta página estará vacia, es para que despues puedas ingresar tus archivos y no perderlos.
Paso 6: Leer Archivos
El proposito principalde la aplicación. Simplemente introduce tu archivo y el programa hará el resto. Podrás ver la información importante extraida y podrá ser enviada a otra página.
Paso 7: Log Out
Presiona log out para salirte se la aplicación.

Sección de referencia para usuario administrador.
Como usuario administrador puedes:
- Subir nuevos templates. Revisa upload.java
- Agregar nuevos métodos de lectura de archivos.
- Ver nuevos usuarios
- Ver el uso de la aplicacion
- Cambiar información en la base de datos.

# Contribución:
Guía de contribución para usuarios.

En tu cuenta de github crea un nuevo repositorio, llamalo filereaderpdf.
Crea un nuevo branch dev a partir del branch master.
Entra al branch dev y clona este repositorio en el branch
Crea un pull request desde master a dev.
Haz el merge.
Listo

# Roadmap:
Requerimientos que se implementarán en un futuro.
Algunas actualizaciones futuras serán principalmente de diseño sinembargo:
- Se actualizará a las nuevas versiones de java.
- Se actualizará el programa para funcionar con las nuevas versiones de los paquetes externos que utilizamos.
- Se creará un sistema más complejo de usuarios y archivos.
- Se implementará una interfaz para la creación de templates.
- Proveerán de opciones para manejar diversos tipos de archivos y templates.
