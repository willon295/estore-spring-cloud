# 简介

1. 采用微服务架构设计
2. 粗粒度，按服务对象划分： 客户服务、书本服务、购物车服务、订单服务
3. 使用 nginx 存放静态文件
4. 使用 nginx 代理服务，根据请求的不同进行请求转发
5. 数据库独立
6. 总体架构： **Reg 为注册中心**  

   ![structure]( /images/structure.png)


# 实现功能

1.   **注册信息 `实时检测注册` ，`用户信息管理` ， `自动登陆 ` ， `登陆验证 `** 
![namenotvalid]( /images/namenotvalid.png)
![namevalid]( /images/namevalid.png)
![checkpwd]( /images/checkpwd.png)
![userinfo]( /images/userinfo.png)


2. **JQery + Ajax 异步分页，书本信息展示** 
      ![index]( /images/index.png)
3. **关键字、价格动态搜索** 
   ![search]( /images/search.png)
4. **书本详情展示、购物车(异步修改数据)，自动重新统计** 
   ![cart]( /images/cart.png)
5. **订单** 

   ![orderlist]( /images/orderlist.png)

6. **支付宝扫玛支付** 

   ![alipay]( /images/alipay.png)

![orderdetail]( /images/orderdetail.png)

# 响应数据概览



1. 简单请求响应信息

   ```json
      {
          "msg": "OK",
          "data":  {
          		"id": 6,
          		"name": "Java 2核心技术（第6版） 卷I：基础知识",
          		"price": 75,
          		"author" : "叶乃文",
          		"publisher": "机械工业出版社/Prentice Hall PTR",
          		"pageNum": "691",
          		"desc": "本书是java技术经典参考书，多年畅销不衰，第7版在保留以前版本风格的基础上，涵盖java 2开发平台标准版j2se 5．0的基础知识，主要内容包括面向对象程序设计、反射与代理、接口与内部类、事件监听器模型、使用swing ui工具箱进行图形用户界面设计、异常处理、流输入/输出和对象序列化，泛型程序设计等。. ",
          "img": null,
          "type": "Java程序设计"
          }
      }
   ```

   

2. 分页数据

   ```json
   {
       "msg":"OK",
       "data":{
           "total":8,
           "list":[
               {
                   "id":6,
                   "name":"Java 2核心技术（第6版） 卷I：基础知识",
                   "price":75,
                   "author":"叶乃文",
                   "publisher":"机械工业出版社/Prentice Hall PTR",
                   "pageNum":"691",
                   "desc":"本书是java技术经典参考书，多年畅销不衰，第7版在保留以前版本风格的基础上，涵盖java 2开发平台标准版j2se 5．0的基础知识，主要内容包括面向对象程序设计、反射与代理、接口与内部类、事件监听器模型、使用swing ui工具箱进行图形用户界面设计、异常处理、流输入/输出和对象序列化，泛型程序设计等。.
   ",
                   "img":null,
                   "type":"Java程序设计"
               },
               {
                   "id":7,
                   "name":"Tomcat与Java Web开发技术详解",
                   "price":45,
                   "author":"孙卫琴",
                   "publisher":"电子工业出版社",
                   "pageNum":"452",
                   "desc":"《Tomcat与Java Web开发技术详解》编辑推荐：Jakarta Tomcat服务器是在SUN公司的JSWDK（JavaServer Web DevelopmentKit，SUN公司推出的小型Servlet/JSP调试工具）的基础上发展起来的一个优秀的Java Web应用容器，它是Apache-Jakarta的一个子项目。Tomcat被JavaWorld杂志的编辑选为2001年度最具创新的Java产品（Most Innovative Java Product），同时它又是SUN公司官方推",
                   "img":null,
                   "type":"程序设计"
               },
               {
                   "id":8,
                   "name":"Java与模式",
                   "price":88,
                   "author":"阎宏",
                   "publisher":"电子工业出版社",
                   "pageNum":"1024",
                   "desc":"本书是一本讲解设计原则以及最为常见的设计模式的实用教材，目的是为了工作繁忙的Java系统设计师提供一个快速而准确的设计原则和设计模式的辅导。",
                   "img":null,
                   "type":"程序设计"
               }
           ],
           "pageNum":2,
           "pageSize":5,
           "size":3,
           "startRow":6,
           "endRow":8,
           "pages":2,
           "prePage":1,
           "nextPage":0,
           "isFirstPage":false,
           "isLastPage":true,
           "hasPreviousPage":true,
           "hasNextPage":false,
           "navigatePages":8,
           "navigatepageNums":[
               1,
               2
           ],
           "navigateFirstPage":1,
           "navigateLastPage":2,
           "firstPage":1,
           "lastPage":2
       }
   }
   ```

    

3. 前台请求数据格式，服务器响应数据格式 如下

   ```json
   //发送数据
   {
   
     "id": 5,
     "num": 3,
     "customer": {
       "id": 6
     },
     "book": {
       "id": 2
     }
   
   }
   //接收用户的购物车信息（分页信息）
   {
       "msg":"OK",
       "data":{
           "total":2,
           "list":[
               {
                   "id":5,
                   "num":3,
                   "book":{
                       "id":2,
                       "price":39,
                   },
                   "customer":{
                       "id":6,
                       "orders":[
                       ]
                   }
               },
               {
                   "id":6,
                   "num":4,
                   "book":{
                       "id":5,
                       "price":95,
                   },
                   "customer":{
                       "id":6,
                       "orders":[
                       ]
                   }
               }
           ],
           "pageNum":1,
           "pageSize":5,
           "size":2,
           "startRow":1,
           "endRow":2,
           "pages":1,
           "prePage":0,
           "nextPage":0,
           "isFirstPage":true,
           "isLastPage":true,
           "hasPreviousPage":false,
           "hasNextPage":false,
           "navigatePages":8,
           "navigatepageNums":[
               1
           ],
           "navigateFirstPage":1,
           "navigateLastPage":1,
           "firstPage":1,
           "lastPage":1
       }
   }
   ```



# 分布式实现



## 节点/服务分配



| 服务器地址      | 提供服务   |
| --------------- | ---------- |
| 10.0.0.101:3306 | 数据库     |
| 10.0.0.102:8761 | 注册中心   |
| 10.0.0.111:8080 | 顾客服务   |
| 10.0.0.112:8080 | 书本服务   |
| 10.0.0.113:8080 | 购物车服务 |
| 10.0.0.114:8080 | 订单服务   |



## Nginx服务器配置



### 请求转发

```nginx
#数据库地址
upstream node-01{          
    server  10.0.0.101:3306;
}
#注册中心
upstream node-02{
    server 10.0.0.102:8761;
}
#顾客服务
upstream node-11{
    server 10.0.0.111:8080;
}
#书本服务
upstream node-12{
    server 10.0.0.112:8080 ;
}
#购物车服务
upstream node-13{
    server 10.0.0.113:8080 ;
}
#订单服务
upstream node-14{
    server 10.0.0.114:8080 ;
}
server{
        listen 80; 
        server_name test.com;
        location / { 
        root /www/test_com;
            index  index.html;
    }   
    location  /customer {
        proxy_pass http://node-11/customer;
    }   
    location  /book {
        proxy_pass http://node-12/book;
    }   
    location  /cart {
        proxy_pass http://node-13/cart;
    }   
    location  /order {
        proxy_pass http://node-14/order;
    }   
}

```



将 `静态文件`  放入站点根目录

## 修改 host映射

```
10.0.0.101   node-01
10.0.0.102   node-02
10.0.0.111   node-11
10.0.0.112   node-12
10.0.0.113   node-13
10.0.0.114   node-14
```



## 修改支付宝配置信息

`order-service`  项目中 `application-cluster.yml` 的  `alipay`  所有字段。



## 启动项目

1. 启动脚本：

   ```bash
   #!/bin/bash
   
   source /etc/profile
   #指定spring-boot 运行时配置文件为  cluster
   java -jar /root/estore/*.jar  --spring.profiles.active=cluster
   ```

2. 在每一台机器中执行,让程序不占用终端后台运行

   ```bash
   nohup  2>&1 ./start-estore.sh &
   ```

3. 启动顺序

   ```
   nginx -> mysql -> 注册中心 -> 其他服务
   ```

   





# 单机版实现

单机版实现主要通过端口分配，或者通过 docker实现

##  端口分配

| 服务       | IP/端口        |
| ---------- | -------------- |
| 书本服务   | localhost:9001 |
| 购物车服务 | localhost:9002 |
| 客户服务   | localhost:9003 |
| 订单服务   | localhost:9004 |
| 注册中心   | localhost:8761 |
| 数据库     | localhost:3306 |
| Nginx      | localhost:80   |



## 导入数据库信息



1. 建立数据库

   ```sql
   create database estore
   ```

2. 导入  `estore.sql`  

   ```bash
   mysql -uroot -p  estore  < estore.sql
   ```

   



## Nginx 站点配置/请求转发

1. 建站 `test.com`

   - 修改 `/etc/hosts`

     ```
     127.0.0.1  test.com 
     ```

   - 站点配置/ 请求转发

     ```nginx
     upstream node1{
         server 127.0.0.1:9001;
     }
     upstream node2{
         server 127.0.0.1:9002;
     }
     upstream node3{
         server 127.0.0.1:9003;
     }
     
     upstream node4{
         server 127.0.0.1:9004;
     }
     server{
             listen 80; 
             server_name test.com;
             location / {
             #站点根目录
             root /www/test_com;
                 index  index.html;
         }   
     
     
         location  /book {
             proxy_pass http://node1/book;
         }   
         location  /cart {
             proxy_pass http://node2/cart;
         }   
         location  /customer {
             proxy_pass http://node3/customer;
         }   
         location  /order {
             proxy_pass http://node4/order;
         }   
     }
     
     ```

     

2. 建站点根目录 `/www/test_com` ，并将静态文件放入 根目录

##  修改数据库信息

1. 每一个模块的 `application.yml` 

   ```
     datasource:
       url: jdbc:mysql://localhost:3306/estore?useSSL=false&useUnicode=true&characterEncoding=utf-8
       driver-class-name: com.mysql.jdbc.Driver
       username: root
       password: root
   ```

   



## 修改支付宝沙箱配置信息

`order-service` 中的 `application.yml` 的  `alipay`  所有字段



## 启动测试

1. 启动Nginx、mysql

   ```bash
   systemctl start nginx
   systemctl start mariadb
   ```


2. 启动注册中心

3. 启动其他服务

4. 浏览器访问 `http://test.com`

