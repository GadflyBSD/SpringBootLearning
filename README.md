# SpringBootLearning
SpringBoot 学习课程

## <center>云南汉王科技`Java8 SpringBoot`框架开发培训</center>

&emsp;&emsp;本次培训将通过`IntelliJ IDEA`编程语言开发的集成环境创建一个`SpringBoot`项目，在该项目中整合`MyBatis Plus`、`Lombok`和`Swagger2`现实一个标准的有两张数据库表（用户资料表、文章信息表）的简易个人博客的服务器端`RESTful API`开发。

## 一、预备知识

* ### `RESTful API`
  > 是目前最流行的 API 设计规范，用于 Web 数据接口的设计。具体参看[《阮一峰：RESTful API 最佳实践》](http://www.ruanyifeng.com/blog/2018/10/restful-api-best-practices.html)
* ### `SpringBoot`
  * [Spring Boot 官网](https://spring.io/projects/spring-boot/)
  * [Spring Boot 百度百科](https://baike.baidu.com/item/Spring%20Boot/20249767?fr=aladdin)
  * Spring Boot是一个简化Spring开发的框架。通过简化配置来进一步简化了Spring应用的整个搭建和开发过程。
  * 在使用Spring Boot时只需要配置相应的Spring Boot就可以用所有的Spring组件，简单的说，spring boot就是整合了很多优秀的框架，不用我们自己手动的去写一堆xml配置然后进行配置。从本质上来说，Spring Boot就是Spring,它做了那些没有它你也会去做的Spring Bean配置。
* ### `MyBatis Plus`
  > 使用Mybatis发现需要在mapper.xml中写很多重复的简单CRUD（增删改查），使用MybatisPlus可以大大简化这部分代码，在` MyBatis` 的基础上只做增强不做改变，为简化开发、提高效率而生。 
  * [MyBatis Plus 官网](https://mp.baomidou.com/)
  * 特性
    * 无侵入
      > 只做增强不做改变，引入它不会对现有工程产生影响，如丝般顺滑
    * 损耗小
      > 启动即会自动注入基本 CURD，性能基本无损耗，直接面向对象操作
    * 强大的 CRUD 操作
      > 内置通用 Mapper、通用 Service，仅仅通过少量配置即可实现单表大部分 CRUD 操作，更有强大的条件构造器，满足各类使用需求
    * 支持 Lambda 形式调用
      > 通过 Lambda 表达式，方便的编写各类查询条件，无需再担心字段写错,Java8中让人又爱又恨的Lambda表达式
    * 支持多种数据库
      > 支持 MySQL、MariaDB、Oracle、DB2、H2、HSQL、SQLite、Postgre、SQLServer2005、SQLServer 等多种数据库
    * 支持主键自动生成
      > 支持多达 4 种主键策略（内含分布式唯一 ID 生成器 - Sequence），可自由配置，完美解决主键问题
    * 支持 XML 热加载
      > Mapper 对应的 XML 支持热加载，对于简单的 CRUD 操作，甚至可以无 XML 启动
    * 支持 ActiveRecord 模式
      > 支持 ActiveRecord 形式调用，实体类只需继承 Model 类即可进行强大的 CRUD 操作
    * 支持自定义全局通用操作
      > 支持全局通用方法注入（ Write once, use anywhere ）
    * 支持关键词自动转义
      > 支持数据库关键词（order、key……）自动转义，还可自定义关键词
    * 内置代码生成器
      > 采用代码或者 Maven 插件可快速生成 Mapper 、 Model 、 Service 、 Controller 层代码，支持模板引擎，更有超多自定义配置等您来使用
    * 内置分页插件
      > 基于 MyBatis 物理分页，开发者无需关心具体操作，配置好插件之后，写分页等同于普通 List 查询
    * 内置性能分析插件
      > 可输出 Sql 语句以及其执行时间，建议开发测试时启用该功能，能快速揪出慢查询
    * 内置全局拦截插件
      > 提供全表 delete 、 update 操作智能分析阻断，也可自定义拦截规则，预防误操作
    * 内置 Sql 注入剥离器
      > 支持 Sql 注入剥离，有效预防 Sql 注入攻击
  * 核心功能
    * 代码生成器
      > AutoGenerator 是 MyBatis-Plus 的代码生成器，通过 AutoGenerator 可以快速生成 Entity、Mapper、Mapper XML、Service、Controller等各个模块的代码，极大的提升了开发效率。
    * CRUD 接口
      > 即增删改查数据库接口
    * 条件构造器
      > 几乎涵盖所有的数据库查询where条件，并支持原始sql。
    * 分页插件
      > 可通过mybatis-plus 自动分页。
    * Sequence主键
      > 实体主键支持Sequence，自动生成主键。
  * 扩展插件
    * 通用枚举
      > 解决了繁琐的配置，让 mybatis 优雅的使用枚举属性！
    * 性能分析插件
      > 性能分析拦截器，用于输出每条 SQL 语句及其执行时间
    * 动态数据源
      > 基于springboot的快速集成多数据源
    * 分布式事务
      > 支持 rabbit 实现可靠消息分布式事务
* ### `Lombok`
  * [Lombok 官网](https://projectlombok.org/)
  * [Lombok简介、使用、工作原理、优缺点](https://blog.csdn.net/ThinkWon/article/details/101392808)
  * Lombok能以简单的注解形式来简化java代码，提高开发人员的开发效率。例如开发中经常需要写的javabean，都需要花时间去添加相应的getter/setter，也许还要去写构造器、equals等方法，而且需要维护，当属性多时会出现大量的getter/setter方法，这些显得很冗长也没有太多技术含量，一旦修改属性，就容易出现忘记修改对应方法的失误。
  * Lombok能通过注解的方式，在编译时自动为属性生成构造器、getter/setter、equals、hashcode、toString方法。出现的神奇就是在源码中没有getter和setter方法，但是在编译生成的字节码文件中有getter和setter方法。这样就省去了手动重建这些代码的麻烦，使代码看起来更简洁些。
* ### `Swagger2`
  * [Swagger2 官网](https://swagger.io/)
  * 自动生成在线API接口文档
  * 由于Spring Boot能够快速开发、便捷部署等特性，相信有很大一部分Spring Boot的用户会用来构建RESTful API。而我们构建RESTful
  * API的目的通常都是由于多终端的原因，这些终端会共用很多底层业务逻辑，因此我们会抽象出这样一层来同时服务于多个移动端或者Web前端。

## 一、培训课程内容
### 1. Learn-01: [RestFUL API Demo project for Spring Boot（RestFUL API的初步搭建）](./restful/Readme.md)

### 2. Learn-02: [MyBatis plus Auto GMyBatis plus Auto Generator Demo project for Spring Boot Demo project for Spring Boot（使用代码生成器自动生成代码）](./generator/Readme.md)

### 3. Learn-03: