# wopg4230
Demonstrate bug in postgresql jdbc driver v 42.3.0 when used with WebObjects

- First create a database in Postgresql replacing YOUR_PASSWORD with your actual password
```
    psql
    create role wopg4230 login password 'YOUR_PASSWORD';
    create database wopg4230 with encoding='UTF-8' OWNER=wopg4230;
    \q
```
- Import project into Eclipse
- Open model Pg4230Model and enter your actual password into Default deployment profile
- Right click on project and say "Run as... WOApplication"
- Select  "Application - com.triptera.demo.wopg4230.app"
- In web browser, check dollar amount is a multiple of $10,000 (edit it if it is not)
- Repeatedly click "edit" "save" "edit" "save" about 6 times and eventually value will lose last 4 zeroes
- Now repeat all of above after changing pom.xml to use version 42.2.24 of jdbc driver
