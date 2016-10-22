#Spring+SpringMVC+Spring Data JPA搭建快速开发环境

pring Data JPA提供了一整套数据访问层(DAO)的解决方案，致力于减少数据访问层的开发量，并支持云服务的开源框架。

Spring Data 作为SpringSource的其中一个父项目， 旨在统一和简化对各类型持久化存储， 而不拘泥于是关系型数据库还是NoSQL 数据存储。无论是哪种持久化存储， 数据访问对象（或称作为DAO，即Data Access Objects）通常都会提供对单一域对象的CRUD （创建、读取、更新、删除）操作、查询方法、排序和分页方法等。

Spring Data则提供了基于这些层面的统一接口（Repository、CrudRepository、PagingAndSortingRepository、JpaRepository）以及对持久化存储的实现。

JPA（Java Persistence API，Java持久化API）是sun提出的一个对象持久化规范，各JavaEE应用服务器自主选择实现，JPA的底层实现是一些流行的开源ORM(对象关系映射)框架（如Hibernate、OpenJPA、TopLink、Ibatis等等），因此JPA其实也就是java实体对象和关系型数据库建立起映射关系，通过面向对象编程的思想操作关系型数据库的规范。JPA定义了对象-关系映射以及实体对象持久化的标准接口。

![](https://github.com/silence940109/SSS/blob/master/image/JPA.png)

Spring Data Jpa是Spring Data对JPA提供的一套解决方案。Spring Data Jpa实现了大部分的持久层的逻辑代码，你需要做的只是声明持久层的接口，其他的都交给Spring Data Jpa完成。

Spring Data Jpa中Repository是一个空接口，CrudRepository： 继承Repository，实现了一组CRUD相关的方法 ，PagingAndSortingRepository： 继承CrudRepository，实现了一组分页排序相关的方法 ，JpaRepository：继承PagingAndSortingRepository，实现一组JPA规范相关的方法。

![](https://github.com/silence940109/SSS/blob/master/image/JPA1.png)

###软件
* JDK7+
* Maven3+
* Tomcat7+
* MySQL

###准备
在src/main/resources/db.properties配置文件中修改数据库的配置信息，包括url、user和password等。

###测试

使用[PostMan](https://github.com/silence940109/Java/tree/master/chrome_postman)对该URL进行请求测试：

GET请求
![](https://github.com/silence940109/SSS/blob/master/image/getCountByAge.png)

POST请求
![](https://github.com/silence940109/SSS/blob/master/image/delete.png)

分页请求
![](https://github.com/silence940109/SSS/blob/master/image/pagesort1.png)

![](https://github.com/silence940109/SSS/blob/master/image/pagesort2.png)