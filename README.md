# SpringMVCFilmSite

## Description
This is a full-stack Spring MVC web application that allows users to retrieve and search through films inside of a database.


## Technologies Used
Java, OOP, Eclipse, mySQL, MAMP, JDBC,

## Lessons Learned

During this project, I became more familiar with a few things.

The `taglib` is an important tool if you want to be able to use `<c:>` when checking potential outcomes. For a while I was stuck wondering why I was getting red all over my .jsp files.

I also learned that when using `${xxx}`, the `.` operator is using the object's fields instead of the databases' names. There were many moments fields would show up null at the end and I was checking every connection. It felt like a big no brainer once I found that.

My second biggest struggle was with the `int filmID` parameter within the `getFilmByID` method. After countless tests of no results, I found that I had not instantiated a `new FilmDaoJdbcImpl()` . This meant a filmID was never being passed in the first place to be converted into an int. The server was throwing my error codes one after the next with nulls.

The largest struggle is with the AWS deployment. I attempted export my files to a `.war` and deploy them to the server, add a tomcat and a MariaDB, but in the end my server would not display anything passed "it worked!". Once the issue is solved, I'll get it deployed.

-Parris