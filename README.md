# mybatis-plus 简介
<img src="https://mp.baomidou.com/img/relationship-with-mybatis.png" width="80%">
mybatis-plus 是一个 Mybatis 的增强工具，在 Mybatis 的基础上只做增强不做改变，为简化开发、提高效率而生。这是官方给的定义，关于mybatis-plus的更多介绍及特性，可以参考mybatis-plus官网。那么它是怎么增强的呢？其实就是它已经封装好了一些crud方法，我们不需要再写xml了，直接调用这些方法就行，就类似于JPA。
### 网站地址：[mybatis-plus](https://mp.baomidou.com/guide/)

## mybatis-plus 优点
* **无侵入：** Mybatis-Plus 在 Mybatis 的基础上进行扩展，只做增强不做改变，引入 Mybatis-Plus 不会对您现有的 Mybatis 构架产生任何影响，而且 MP 支持所有 Mybatis 原生的特性
* **依赖少：** 仅仅依赖 Mybatis 以及 Mybatis-Spring
* **损耗小：** 启动即会自动注入基本CURD，性能基本无损耗，直接面向对象操作
* **通用CRUD操作：** 内置通用 Mapper、通用 Service，仅仅通过少量配置即可实现单表大部分 CRUD 操作，更有强大的条件构造器，满足各类使用需求
* **多种主键策略：** 支持多达4种主键策略（内含分布式唯一ID生成器），可自由配置，完美解决主键问题
* **支持ActiveRecord：** 支持 ActiveRecord 形式调用，实体类只需继承 Model 类即可实现基本 CRUD 操作
* **支持代码生成：** 采用代码或者 Maven 插件可快速生成 Mapper 、 Model 、 Service 、 Controller 层代码，支持模板引擎，更有超多自定义配置等您来使用（P.S. 比 Mybatis 官方的 Generator 更加强大！）
* **支持自定义全局通用操作：** 支持全局通用方法注入( Write once, use anywhere )
* **内置分页插件：** 基于Mybatis物理分页，开发者无需关心具体操作，配置好插件之后，写分页等同于写基本List查询
* **内置性能分析插件：** 可输出Sql语句以及其执行时间，建议开发测试时启用该功能，能有效解决慢查询
* **内置全局拦截插件：** 提供全表 delete 、 update 操作智能分析阻断，预防误操作

## 支持数据库
* **mysql**，**oracle**，**db2**，**h**，hsql，sqlite，postgresql，sqlserver，Phoenix，Gauss ，clickhouse，Sybase，OceanBase，Firebird，cubrid，goldilocks，csiidb
* 达梦数据库，虚谷数据库，人大金仓数据库，南大通用(华库)数据库，南大通用数据库，神通数据库，瀚高数据库

## 框架结构
<img src="https://mp.baomidou.com/img/mybatis-plus-framework.jpg" width="80%">
