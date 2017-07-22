# CRUD
Проект собирается с помощью maven
Тестировался на GlassFish

Для запуска необходимо создать таблицу "public"."app_user" в базе данных 
Таблица со следующими полями:

login - varchar Primary Key
password - varchar, not null
name - varchar, not null
surname - varchar, not null
birthday - date, not null
about -varchar
address - varchar

Для подключения к базе данных использовались следующие настройки:

<property name="driverClassName" value="org.postgresql.Driver" />
<property name="url" value="jdbc:postgresql://localhost:5432/postgres" />
<property name="username" value="postgres" />
<property name="password" value="123456" />

При желании их можно поменять в файле spring-servlet.xml
   
