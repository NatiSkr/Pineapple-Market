# Database with MySQL

## History

* Added letter 't' at end of the table's name to avoid use of restricted words of MySQL, Java or Spring dependencies (especially with users)

* Column password is now pass_word to avoid reserved keyword. Aditionally, replaces namesakes in java with pass_word or pass_Word.

* Table Orders & Product_has_Orders eliminated. Instead replaced with user id in products for last modification

* Removed uppercase from table header

* Columns named with under_score instead of camelCase

## Troubleshooting

- ER_ACCESS_DENIED_ERROR: Access denied for user 'root'@'localhost' (using password: YES)

Caused by password or user with special characters or uppercase letters. Recommend changing to a lowercase-only 
password to connect to server from root user, or create a new user. Do either from the MySQL Workbench: 
go to Server -> Users and privileges and apply changes. Then go to <application.properties> file and update username and password

- Cannot destructor property 'name' of 'undefined' as it is undefined

For some reason the extension SQL tools in Visual Studio Code does not like comments in sql scripts, remove them if you run into this error.

- You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near

If you are absolutely sure that you don't have a syntax error, chances are you name either a table or a column with a reserved word 
from sql, java or spring. Modify or add a letter both in database and in project models.