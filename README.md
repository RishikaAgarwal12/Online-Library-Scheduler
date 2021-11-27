# Online Library Scheduler
Library Scheduler developed in Spring Boot.


#### What does it offer?
1)It allows users(Student) to allot seats and books in library.

2)It allows users(Librarian) to manage Members, Categories, Books and Issueing Books.


### Setup project
#### Setup database
1)Project requires MySql database. The version of the database is prefered to be 8.0 or later.

2)Before running project you first need to create database of name 'olsdb' in you device.

3)You also need to provide your Mysql credential in application.properties

      spring.datasource.username = root(provide your Mysql username)
   
      spring.datasource.password = Rishika2405(provide your Mysql password)




### Login
1. For login as a Librarian user you may use username as 'librarian' and password as 'librarian1' for using activities of librarian.
2. For login as a Student user you may use username as 'Rishika' and password as 'Rishika2'.
3. If Librarian add any new member then member's username will be its FirstName and password will be its FirstName+ID; here ID will be provided to member when librarian added new member. 

### Add New Member
Date format : dd-mmm-yyyy  example: 05-DEC-2000


 



