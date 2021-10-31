# mybatis-plus 简介
<img src="https://mp.baomidou.com/img/relationship-with-mybatis.png" width="80%">
 
**mybatis-plus** 是一个 Mybatis 的增强工具，在 Mybatis 的基础上只做增强不做改变，为简化开发、提高效率而生。这是官方给的定义，关于mybatis-plus的更多介绍及特性，可以参考mybatis-plus官网。那么它是怎么增强的呢？其实就是它已经封装好了一些crud方法，我们不需要再写xml了，直接调用这些方法就行，就类似于JPA。
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
* **mysql**，**oracle**，**db2**，**h2**，hsql，sqlite，postgresql，sqlserver，Phoenix，Gauss ，clickhouse，Sybase，OceanBase，Firebird，cubrid，goldilocks，csiidb
* 达梦数据库，虚谷数据库，人大金仓数据库，南大通用(华库)数据库，南大通用数据库，神通数据库，瀚高数据库

## 框架结构
<img src="https://mp.baomidou.com/img/mybatis-plus-framework.jpg" width="80%">

## [MybatisX 快速开发插件](https://mp.baomidou.com/guide/mybatisx-idea-plugin.html#%E5%8A%9F%E8%83%BD)
MybatisX 是一款基于 IDEA 的快速开发插件，为效率而生。

安装方法：打开 IDEA，进入 File -> Settings -> Plugins -> Browse Repositories，输入 mybatisx 搜索并
在工程tools文件下有最新的MybatisX插件包和idea重置IDEA插件

支持以下功能：
* XML和Dao层直之间方法跳转，可生成对应的代码
* 根据数据库表生成代码(需先在idea配置Database配置数据源)
* JPA提示生成xml的SQL语句（写代码就和jpa一样，支持修改语句，比JPA更便捷易用）
## 使用
现有一张 User 表，其表结构如下：

|  id	|  name   | age  |    	email          |
|  ---- | ----    | ---- |        ----         |
| 1     |  Jone	  |  18  |	test1@baomidou.com |
| 2     |  Jack	  |  20  |	test2@baomidou.com |
| 3     |  Tom	  |  28  |	test3@baomidou.com |
| 4     |  Sandy  |  21  |	test4@baomidou.com |
| 5     |  Billie |  24  |	test5@baomidou.com |

其对应的数据库 Schema 脚本如下：
```
DROP TABLE IF EXISTS user;

CREATE TABLE user
(
id BIGINT(20) NOT NULL COMMENT '主键ID',
name VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
age INT(11) NULL DEFAULT NULL COMMENT '年龄',
email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
PRIMARY KEY (id)
);
```
其对应的数据库 Data 脚本如下：
```
DELETE FROM user;

INSERT INTO user (id, name, age, email) VALUES
(1, 'Jone', 18, 'test1@baomidou.com'),
(2, 'Jack', 20, 'test2@baomidou.com'),
(3, 'Tom', 28, 'test3@baomidou.com'),
(4, 'Sandy', 21, 'test4@baomidou.com'),
(5, 'Billie', 24, 'test5@baomidou.com');
```
#### 添加依赖
引入 Spring Boot Starter 父工程：
现在最新：spring-latest-version=3.5.1
```
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>spring-latest-version</version>
    <relativePath/>
</parent>
```

引入 spring-boot-starter、spring-boot-starter-test、mybatis-plus-boot-starter、mysql-jdbc-connect 等依赖：
```
<dependencies>
        <!--freemarker-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-freemarker</artifactId>
        </dependency>
        <!--spring-boot-web-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <!--mysql-connector-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
        </dependency>
        <!--mybatis-plus依赖包-->
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-boot-starter</artifactId>
            <version>3.4.3.4</version>
        </dependency>
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-generator</artifactId>
            <version>3.5.1</version>
        </dependency>
        <!--lombok-->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <!--alibaba fastjson-->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>fastjson</artifactId>
            <version>1.2.74</version>
        </dependency>
        <!--spring test-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <excludes>
                        <exclude>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                        </exclude>
                    </excludes>
                </configuration>
            </plugin>
        </plugins>
        <resources>
            <resource>
                <directory>src/main/java</directory>
                <includes>
                    <include>**/*.xml</include>
                </includes>
            </resource>
            <resource>
                <directory>src/main/java/resource</directory>
            </resource>
        </resources>
    </build>
```

#### 配置
##### DataSource Config
```
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://127.0.0.1:3306/mybaties-plus-demo?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true
    username: root
    password: root


mybatis-plus:
  mapper-locations: classpath*:mapper/**/*Mapper.xml
  configuration:
    map-underscore-to-camel-case: true
    auto-mapping-behavior: full
  global-config:
    db-config:
      logic-delete-value: 0
      logic-not-delete-value: 1
  type-aliases-package: cn.kuaishang.mybatiesplus.entity
 ```
#### 配置分页插件
~~~
@Configuration
@MapperScan("cn.kuaishang.mybatiesplus.mapper")
public class MybatisPlusConfig {

    /**
     * 配置分页插件
     *
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        PaginationInnerInterceptor paginationInterceptor = new PaginationInnerInterceptor(DbType.MYSQL);
        // 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
        // paginationInterceptor.setOverflow(false);
        // 设置最大单页限制数量，默认 500 条，-1 不受限制
        // paginationInterceptor.setMaxLimit(500L);
        interceptor.addInnerInterceptor(paginationInterceptor);
        return interceptor;
    }
}
~~~

#### 编码
创建Entity
~~~
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
~~~

创建Mapper
~~~
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
~~~

创建Service
~~~
public interface IUserService extends IService<User> {

}

~~~
创建ServiceImpl
~~~
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
~~~
#### 开始使用
具体范围官方文档：

* [Service CRUD 接口](https://mp.baomidou.com/guide/crud-interface.html)

* [Mapper CRUD 接口](https://mp.baomidou.com/guide/crud-interface.html#mapper-crud-%E6%8E%A5%E5%8F%A3)

* [mapper 层 选装件](https://mp.baomidou.com/guide/crud-interface.html#mapper-%E5%B1%82-%E9%80%89%E8%A3%85%E4%BB%B6)
插入数据

~~~
// 插入一条记录（选择字段，策略插入）
boolean save(T entity);
// 插入（批量）
boolean saveBatch(Collection<T> entityList);
// 插入（批量）
boolean saveBatch(Collection<T> entityList, int batchSize);
~~~

参数说明

| 类型 |	参数名 |	描述 | 
|  ---- | ----    | ---- | 
| T | entity |	实体对象 | 
| Collection<T> | entityList | 实体对象集合 |
| int |	batchSize | 插入批次数量 |
~~~
@SpringBootTest
public class SaveWrapperTest {

    @Autowired
    private UserService userService;

    /**
     * Save
     */
    @Test
    public void tests() {

        User user1 = new User();
        user1.setAge(29);
        user1.setName("Join");
        user1.setEmail("test1@baomidou.com");

        User user2 = new User();
        user2.setAge(12);
        user2.setName("Sam");
        user2.setEmail("test2@baomidou.com");

        User user3 = new User();
        user3.setAge(11);
        user3.setName("Lily");
        user3.setEmail("test3@baomidou.com");

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        // 插入一条记录（选择字段，策略插入）
        userService.save(user1);
        // 插入（批量）
        userService.saveBatch(userList);
        // 插入（批量）
        userService.saveBatch(userList,2);
    }
}
~~~

保存或更新
~~~
// TableId 注解存在更新记录，否插入一条记录
boolean saveOrUpdate(T entity);
// 根据updateWrapper尝试更新，否继续执行saveOrUpdate(T)方法
boolean saveOrUpdate(T entity, Wrapper<T> updateWrapper);
// 批量修改插入
boolean saveOrUpdateBatch(Collection<T> entityList);
// 批量修改插入
boolean saveOrUpdateBatch(Collection<T> entityList, int batchSize);
~~~

| 类型 |	参数名 |	   描述   |
|  ---- | ----    |   ----   | 
| T | entity |	实体对象
| Wrapper<T> |	updateWrapper |	实体对象封装操作类 UpdateWrapper
| Collection<T> |	entityList |	实体对象集合
| int |	batchSize |	插入批次数量

~~~
@SpringBootTest
public class SaveOrUpdateWrapperTest {
    @Autowired
    private UserService userService;
    /**
     * 
     */
    @Test
    public void tests() {

        //方式一：
        User user = new User();
        user.setId(1L);
        user.setAge(29);
        user.setEmail("test3update@baomidou.com");

        User user2 = new User();
        user2.setId(2L);
        user2.setAge(29);
        user2.setEmail("test3update@baomidou.com");

        User user3 = new User();
        user3.setId(3L);
        user3.setAge(29);
        user3.setEmail("test3update@baomidou.com");

        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(user2);
        userList.add(user3);
        //通过ID修改
        userService.updateById(user);
        //批量通过ID更新
        userService.updateBatchById(userList);
        //保存或者更新
        userService.saveOrUpdate(user);
        //批量保存更新
        userService.saveOrUpdateBatch(userList);
    }
}

~~~

更新数据
~~~
// 根据 UpdateWrapper 条件，更新记录 需要设置sqlset
boolean update(Wrapper<T> updateWrapper);
// 根据 whereWrapper 条件，更新记录
boolean update(T updateEntity, Wrapper<T> whereWrapper);
// 根据 ID 选择修改
boolean updateById(T entity);
// 根据ID 批量更新
boolean updateBatchById(Collection<T> entityList);
// 根据ID 批量更新
boolean updateBatchById(Collection<T> entityList, int batchSize);
~~~

| 类型 |	参数名 |	   描述   |
|  ---- | ----    |   ----   | 
| T | entity |	实体对象
| Wrapper<T> |	updateWrapper |	实体对象封装操作类 UpdateWrapper
| Collection<T> |	entityList |	实体对象集合
| int |	batchSize |	插入批次数量

~~~

@SpringBootTest
public class UpdateWrapperTest {
    @Autowired
    private UserService userService;

    /**
     * UPDATE user SET age=?, email=? WHERE (name = ?)
     */
    @Test
    public void tests() {

        //方式一：
        User user = new User();
        user.setAge(29);
        user.setEmail("test3update@baomidou.com");

        userService.update(user,new UpdateWrapper<User>().eq("name","Tom"));

        //方式二：
        //不创建User对象
        userService.update(null,new UpdateWrapper<User>()
                .set("age",29).set("email","test3update@baomidou.com").eq("name","Tom"));

    }

    /**
     * 使用lambda条件构造器
     * UPDATE user SET age=?, email=? WHERE (name = ?)
     */
    @Test
    public void testLambda() {

        //方式一：
        User user = new User();
        user.setAge(29);
        user.setEmail("test3update@baomidou.com");

        userService.update(user,new LambdaUpdateWrapper<User>().eq(User::getName,"Tom"));

        //方式二：
        //不创建User对象
        userService.update(null,new LambdaUpdateWrapper<User>()
                .set(User::getAge,29).set(User::getEmail,"test3update@baomidou.com").eq(User::getName,"Tom"));
    }
}
~~~

删除数据
~~~
// 根据 entity 条件，删除记录
boolean remove(Wrapper<T> queryWrapper);
// 根据 ID 删除
boolean removeById(Serializable id);
// 根据 columnMap 条件，删除记录
boolean removeByMap(Map<String, Object> columnMap);
// 删除（根据ID 批量删除）
boolean removeByIds(Collection<? extends Serializable> idList);
~~~

| 类型 |	参数名 |	   描述   |
|  ---- | ----    |   ----   | 
| Wrapper<T> | queryWrapper |	实体包装类 | QueryWrapper | 
| Serializable |	id |	主键ID |
| Map<String, Object> | 	columnMap |	表字段 map 对象 |
| Collection<? extends Serializable> |	idList |	主键ID列表 |


~~~
@SpringBootTest
public class RemoveWrapperTest {
    @Autowired
    private UserService userService;

    /**
     * UPDATE user SET age=?, email=? WHERE (name = ?)
     */
    @Test
    public void tests() {

        //方式一：条件删除
        //通过QueryWrapper
        userService.remove(new QueryWrapper<User>().eq("id","1"));

        //通过LambdaUpdateWrapper
        userService.remove(new LambdaUpdateWrapper<User>().eq(User::getId,"1"));

        //方式二：实体ID删除
        User user = new User();
        user.setId(1L);
        user.setAge(29);
        user.setEmail("test3update@baomidou.com");
        userService.removeById(user);

        //方式三：ID删除
        userService.removeById(1L);
        
        //方式四：批量ID删除
        List<Long> ids = Arrays.asList(1L, 2L, 3L);
        userService.removeByIds(ids);

    }
    
}
~~~

查询单个

~~~
// 根据 ID 查询
T getById(Serializable id);
// 根据 Wrapper，查询一条记录。结果集，如果是多个会抛出异常，随机取一条加上限制条件 wrapper.last("LIMIT 1")
T getOne(Wrapper<T> queryWrapper);
// 根据 Wrapper，查询一条记录
T getOne(Wrapper<T> queryWrapper, boolean throwEx);
// 根据 Wrapper，查询一条记录
Map<String, Object> getMap(Wrapper<T> queryWrapper);
// 根据 Wrapper，查询一条记录
<V> V getObj(Wrapper<T> queryWrapper, Function<? super Object, V> mapper);
~~~
| 类型 |	参数名 |	   描述   |
|  ---- | ----    |   ----   | 
| Wrapper<T> |	queryWrapper |	实体对象封装操作类 | QueryWrapper |
| Collection<? extends Serializable> |	idList |	主键ID列表 |
| Map<?String, Object> |	columnMap |	表字段 map 对象 |
| Function<? super Object, V> |	mapper |	转换函数 |

~~~
~~~

查询集合
~~~
// 查询所有
List<T> list();
// 查询列表
List<T> list(Wrapper<T> queryWrapper);
// 查询（根据ID 批量查询）
Collection<T> listByIds(Collection<? extends Serializable> idList);
// 查询（根据 columnMap 条件）
Collection<T> listByMap(Map<String, Object> columnMap);
// 查询所有列表
List<Map<String, Object>> listMaps();
// 查询列表
List<Map<String, Object>> listMaps(Wrapper<T> queryWrapper);
// 查询全部记录
List<Object> listObjs();
// 查询全部记录
<V> List<V> listObjs(Function<? super Object, V> mapper);
// 根据 Wrapper 条件，查询全部记录
List<Object> listObjs(Wrapper<T> queryWrapper);
// 根据 Wrapper 条件，查询全部记录
<V> List<V> listObjs(Wrapper<T> queryWrapper, Function<? super Object, V> mapper);
~~~

| 类型 |	参数名 |	   描述   |
|  ---- | ----    |   ----   | 
| Wrapper<T> |	queryWrapper |	实体对象封装操作类  |	QueryWrapper |	
| Collection<? extends Serializable> |		idList |		主键ID列表 |	
| Map<?String, Object>	columnMap |		表字段 |	 map 对象 |	
| Function<? super Object, V> |		mapper |		转换函数 |	

分页查询

~~~
// 无条件分页查询
IPage<T> page(IPage<T> page);
// 条件分页查询
IPage<T> page(IPage<T> page, Wrapper<T> queryWrapper);
// 无条件分页查询
IPage<Map<String, Object>> pageMaps(IPage<T> page);
// 条件分页查询
IPage<Map<String, Object>> pageMaps(IPage<T> page, Wrapper<T> queryWrapper);
~~~

| 类型 |	参数名 |	   描述   |
|  ---- | ----    |   ----   | 
| IPage<T>| 	page| 	翻页对象| 
| Wrapper<T>| 	queryWrapper| 	实体对象封装操作类|  QueryWrapper| 

Count
~~~
// 查询总记录数
int count();
// 根据 Wrapper 条件，查询总记录数
int count(Wrapper<T> queryWrapper);
~~~

| 类型 |	参数名 |	   描述   |
|  ---- | ----    |   ----   | 
|Wrapper<T>	queryWrapper|	实体对象封装操作类 | QueryWrapper |



#### Chain

query
~~~
// 链式查询 普通
QueryChainWrapper<T> query();
// 链式查询 lambda 式。注意：不支持 Kotlin
LambdaQueryChainWrapper<T> lambdaQuery(); 

// 示例：
query().eq("column", value).one();
lambdaQuery().eq(Entity::getId, value).list();
~~~

update
~~~
// 链式更改 普通
UpdateChainWrapper<T> update();
// 链式更改 lambda 式。注意：不支持 Kotlin 
LambdaUpdateChainWrapper<T> lambdaUpdate();

// 示例：
update().eq("column", value).remove();
lambdaUpdate().eq(Entity::getId, value).update(entity);
~~~