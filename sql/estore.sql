-- MySQL dump 10.16  Distrib 10.2.16-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: estore
-- ------------------------------------------------------
-- Server version	10.2.16-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `publisher` varchar(255) DEFAULT NULL,
  `pageNum` int(11) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `desc` varchar(255) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'精通Hibernate：Java对象持久化技术详解',59.00,'孙卫琴','电子工业出版社出版',299,'软件技术','本书在第一版基础上，理论内容更新，更加注重理论与实践的结合，有大量具有典型性和实用价值的Hibernate应用实例。全书将详细介绍运用目前最成熟的Hibernate 3.3版本',NULL),(2,'Effective Java中文版',39.00,'Joshua Bloch','机械工业出版社出版',287,'机械工程','《Effective Java中文版(第2版)》主要内容：在Java编程中78条极具实用价值的经验规则，这些经验规则涵盖了大多数开发人员每天所面临的问题的解决方案。通过对Java平台设计专家所使用的技术的全面描述，揭示了应该做什么，不应该做什么才能产生清晰、健壮和高效的代码。',NULL),(3,'精通Spring',39.00,'罗时飞','电子工业出版社',521,'程序设计','本书是关于Spring 2.5的权威教程，是Java/Java EE开发者必备的参考书。全书共分为5篇：第1篇为综述，主要围绕Java EE 5、Spring展开；第2篇介绍Spring 2.5核心技术，主要围绕Spring元框架进行阐述；第3篇介绍DAO层集成技术，主要围绕JDBC、Hibernate和JPA等持久化技术展开论述，针对Spring使能应用的事务管理和集成测试，也进行了相关介绍',NULL),(4,'深入浅出Hibernate',59.00,'夏昕','电子工业出版社',453,'程序设计','本书由互联网上影响广泛的开放文档OpenDoc系列自由文献首份文档“Hibernate开发指南”发展而来。在编写过程中，进行了重新构思与组织，同时对内容的深度与广度进行了重点强化。本书从持久层入手，引出对象/关系数据库映射的由来，接下来聚焦于目前最完善、最强悍的ORM产品—— Hibernate。',NULL),(5,' JAVA编程思想：第3版',95.00,'陈昊鹏、饶若','机械工业出版社',233,'编程思想','2003年《Software Development》杂志Jolt大奖、2001年《Java World》杂志编辑推荐图书奖、1999年《Java World》杂志读者选择最佳图书奖、1998年《Software Development》杂志Jolt大奖、1998年《Java Developer’s Journal》杂志编辑推荐最佳图书奖。',NULL),(6,'Java 2核心技术（第6版） 卷I：基础知识',75.00,'叶乃文','机械工业出版社/Prentice Hall PTR',691,'Java程序设计','本书是java技术经典参考书，多年畅销不衰，第7版在保留以前版本风格的基础上，涵盖java 2开发平台标准版j2se 5．0的基础知识，主要内容包括面向对象程序设计、反射与代理、接口与内部类、事件监听器模型、使用swing ui工具箱进行图形用户界面设计、异常处理、流输入/输出和对象序列化，泛型程序设计等。.\r\n',NULL),(7,'Tomcat与Java Web开发技术详解',45.00,'孙卫琴','电子工业出版社',452,'程序设计','《Tomcat与Java Web开发技术详解》编辑推荐：Jakarta Tomcat服务器是在SUN公司的JSWDK（JavaServer Web DevelopmentKit，SUN公司推出的小型Servlet/JSP调试工具）的基础上发展起来的一个优秀的Java Web应用容器，它是Apache-Jakarta的一个子项目。Tomcat被JavaWorld杂志的编辑选为2001年度最具创新的Java产品（Most Innovative Java Product），同时它又是SUN公司官方推',NULL),(8,'Java与模式',88.00,'阎宏','电子工业出版社',1024,'程序设计','本书是一本讲解设计原则以及最为常见的设计模式的实用教材，目的是为了工作繁忙的Java系统设计师提供一个快速而准确的设计原则和设计模式的辅导。',NULL),(9,'抗联薪火传',68.00,'老哲','网络小说',853,'军事小说','　　是谁在漫漫寒夜中点燃了一枚火种，在十四年间虽然有时大火燎天有时只是火星点点，可是火种未断永远相传！\r\n　　是哪支部队以四万没有支援没有补给的武装在白山黑水间与几十万日本侵略者缠斗，最后只剩下区区几百人？\r\n　　有一种精神叫不屈，有一支队伍叫抗联！\r\n　　别人都叫他雷小六，他从十六岁加入抗联，当抗战胜利他已人到中年，可是已经没有人知道管他叫雷小六了，因为知道这个名字的人都已魂系白山黑水间。',NULL),(10,'Agile Java 中文版',69.00,'JEFF LANGR','电子工业出版社',616,'Java编程入门类','本书语言浅显易懂，颇有趣味，覆盖了上述三方面的内容，准确地层示了如何将Java和TDD进行有效的整合；帮助开发者在整个软件生命周期中使用这些方法，以适应现代软件行业对高开发速度和高准确性的要求，对于希望使用Java 5．0作为开发工具的开发者而言，本书是一本很好的入门书籍。..',NULL),(11,'重构 改善既有代码的设计',73.00,'（美）福勒','中国电力出版社出版',431,'程序设计','本书的核心是一份完整的重构名录（catalog of refactoring），其中每一项都介绍一种经过实证的代码变换手法（code transformation）的动机和技术。某些项目如Extract Method和Move Field看起来可能很浅显，但不要掉以轻心，因为理解这类技术正是有条不紊地进行重构的关键。本书所提的这些重构准则将帮助你一次一小步地修改你的代码，这就减少了过程中的风险。很快你就会把这些重构准则和其名称加入自己的开发词典中，并且朗朗上口',NULL),(12,'测试驱动开发',65.00,'Kent Beck','电子工业出版社',231,'软件测试','Kent Beck先生最早在其极限编程（XP）方法论中，向大家推荐“测试驱动”这一最佳实践，还专门撰写了《测试驱动开发》一书，详细说明如何实现。经过几年的迅猛发展，测试驱动开发已经成长为一门独立的软件开发技术，其名气甚至盖过了极限编程。 [1] \r\n应用领域：新软件的开发，历史系统的维护',NULL),(13,'企业应用架构模式',59.00,'福勒','机械工业出版社',363,'架构设计','《企业应用架构模式》作者是当今面向对象软件开发的权威，他在一组专家级合作者的帮助下，将40多种经常出现的解决方案转化成模式，最终写成这本能够应用于任何一种企业应用平台的、关于解决方案的、不可或缺的手册。《企业应用架构模式》获得了2003年度美国软件开发杂志图书类的生产效率奖和读者选择奖。',NULL),(14,'敏捷软件开发：原则模式和实践',48.00,'马丁','人民邮电出版社',235,'程序开发','通过《敏捷软件开发:原则模式和实践(C#版)》你会发现，许多以前看起来非常枯燥费解的概念，忽然间都豁然开朗。变得鲜活生动起来。\r\n',NULL),(15,'UML精粹',59.00,'福勒','人民邮电出版社',207,'程序设计','《UML精粹:标准对象建模语言简明指南(第3版)》在紧迫的时间压力下，程序员很难通过紧跟技术创新的脚步来享受软件工程领域的最新成果。正因如此，殿堂级大师Martin Fowler这本旨在帮助专业人士提升效率的图书一问世，立即给软件工程社区带来巨大震撼。其前两版经年畅销，因行文精炼自然、见解透彻而广受称赞。',NULL),(16,'解析极限编程：拥抱变化',63.00,'贝克 (Kent beck)','机械工业出版社',167,'编程思想','内容简介编辑\r\n《解析极限编程:拥抱变化(原书第2版)》适用于中小型团队在需求不明确或者迅速变化的情况下进行软件开发的轻量级方法学。《解析极限编程:拥抱变化(原书第2版)》是XP宣言，也是第一本有关XP的图书。',NULL),(17,'快速软件开发',69.00,'（美）麦克康奈尔','电子工业出版社',356,'软件开发','进度失控，几乎是每一个软件开发项目挥之不去的噩梦。如何从容赶急，如何通过正确的开发策略和原则，避免典型错误，有效地进行风险管理，从多个方面贯彻执行快速软件开发，都可以从本书中找到答案。本书借助于实际案例和数据，阐述了快速软件开发方法的要领和精髓。\r\n',NULL),(18,'Head First设计模式',98.00,'Eric Freeman；ElElisabeth Freeman','中国电力出版社',170,'设计模式','《HeadFirst设计模式》(中文版)共有14章，每章都介绍了几个设计模式，完整地涵盖了四人组版本全部23个设计模式。前言先介绍这本书的用法；第1章到第11章陆续介绍的设计模式为Strategy、Observer、Decorator、AbstractFactory、FactoryMethod、Singleton，Command、Adapter、Facade、TemplateMethod、Iterator、Composite、State、Proxy。最后三章比较特别。',NULL),(19,'Effective Java中文版',64.00,'Joshua Bloch','机械工业出版社',287,'软件开发','《Effective Java中文版(第2版)》主要内容：在Java编程中78条极具实用价值的经验规则，这些经验规则涵盖了大多数开发人员每天所面临的问题的解决方案。通过对Java平台设计专家所使用的技术的全面描述，揭示了应该做什么，不应该做什么才能产生清晰、健壮和高效的代码。第2版反映了Java 5中最重要的变化，并删去了过时的内容。',NULL),(20,'Java并发编程实战',59.00,'（美）Brian Goetz等','机械工业出版社',312,'编程思想','《Java并发编程实战》是一本完美的Java并发参考手册。书中从并发性和线程安全性的基本概念出发，介绍了如何使用类库提供的基本并发构建块，用于避免并发危险、构造线程安全的类及验证线程安全的规则，如何将小的线程安全类组合成更大的线程安全类，如何利用线程来提高并发应用程序的吞吐量，如何识别可并行执行的任务，如何提高单线程子系统的响应性，如何确保并发程序执行预期任务，如何提高并发代码的性能和可伸缩性等内容，最后介绍了一些高级主题，如显式锁、原子变量、非阻塞算法以及如何开发自定义的同步工具类。',NULL),(21,'HTML5基础开发教程',45.00,'　范立锋 于合龙 孙丰伟 ','机械工业出版社',200,'前端开发','本书内容主要分为三大部分。第一部分介绍了HTML5的相关开发技术，包括HTML的发展，HTML5与之前版本的区别，HTML5的表单元素应用，HTML5的多媒体元素应用，HTML5的图像及动画应用，HTML5的元素拖曳技术，HTML5的数据存储技术，HTML5的离线应用及地理位置应用。第二部分介绍了CSS3的相关知识，包括CSS3选择器的应用，使用CSS3控制页面样式，使用CSS3在页面中插入信息，使用CSS3控制元素变形以及CSS3中的元素过渡应用。第三部分为HTML5与CSS3的综合应用实例。',NULL),(22,'图灵程序设计丛书:HTML5与CSS3设计模式',59.00,'(荷)Lubbers','人民邮电出版社',276,'前端开发','1、超级畅销书《HTML5高级程序设计》升级版\r\n　　2、引领下一代web开发潮流\r\n　　3、全面涵盖开创性html5api\r\n',NULL),(23,'高流量网站CSS开发技术',69.00,'Antony Kennedy  ','人民邮电出版社',344,'前端开发','不论是前端工程师还是后端工程师，编写CSS 可不只是码几行代码那么简单的事儿，他们需要面对的情况通常非常复杂。出色的CSS 开发人员知道如何应对和避免跨浏览器陷阱，懂得处理语义化、无障碍访问、搜索引擎优化，以及相关文档不完整带来的各种问题。\r\n　　一套优秀的CSS 框架可以显著提升网站性能，但如何创建一套优秀的CSS 框架呢？单纯使用一些新特性只会让情况变得更糟糕，要确保CSS 不会成为开发过程或网站性能的瓶颈，请遵循《高流量网站CSS开发技术》的指导！',NULL),(24,'CSS设计彻底研究',69.00,'前沿科技温谦','人民邮电出版社',365,'前端开发','本书详细介绍了css核心基础、盒子模型等知识，力求把原理和方法讲清楚，采用了“探索式”的讲解方法，对于一个问题，例如标准流、浮动、定位等规律，均通过一系列动手实验，使读者自己就能够非常自然地得出结论，使读者不仅知其然，而且知其所以然。 在本书中对设计中常用的网页元素和布局方式都给出详细的分类和归纳，并讲解了完整的解决方法，主要包括各种导航菜单(水平的、竖直的、固定宽度的、自适应宽度的、下拉的等)，Tab面板、伸缩面',NULL),(25,'CSS权威指南(第3版)',58.00,'(美)迈耶','中国电力出版社',321,'前端开发','《CSS权威指南》(第3版)是著名的CSS专家EricA.Meyer他招牌式的智慧和无与伦比的经验引领读者探索了CSS的各个部分，包括属性、标记、特性和实现。此外，他还就现实应用中的一些问题，例如浏览器的支持和设计方针，发表了看法。你所要知道的就是HTML4.0的知识，这样就可以创建整洁、易于维护的脚本，以与桌面出版系统同样的优雅和控制能力管理网站布局和分页。',NULL),(26,'JavaScript设计模式',45.00,'哈梅斯和迪亚斯','人民邮电出版社',456,'前端开发','《JavaScript设计模式》共有两部分。第一部分给出了实现具体设计模式所需要的面向对象特性的基础知识，主要包括接口、封装和信息隐藏、继承、单体模式等内容。第二部分则专注于各种具体的设计模式及其在JavaScript语言中的应用，主要介绍了工厂模式、桥接模式、组合模式、门面模式等几种常见的模式。',NULL),(27,'响应式Web设计:HTML5和​CSS3实战',45.00,'王永强 ','人民邮电出版社',357,'前端开发','移动互联网时代到来了。不仅讨论了媒体查询、流式布局、相对字体、响应式媒体，更将HTML5和CSS3的相关知识点一并讲解，是学习最新Web设计技术不可多得的佳作。 [1] \r\n',NULL),(28,'Web 2.0界面设计模式',49.00,'黄玮 王沛','电子工业出版社',245,'设计模式','本书集Web 2.0的发展及特点、Web 2.0界面设计模式基本理论、实际模式实践及代码实现等诸多内容于一身，具有很强的实用性。这些内容不是简单的顺序堆砌，而是以Web 2.0界面设计模式和应用为主线，其中完美地穿插了各种与之相关的Web 2.0设计理念、用户行为模式、用户体验及基于Dojo的实现方式等相关知识，真正做到将Web 2.0界面设计模式所需要的方方面面的知识有机地融为一个整体。',NULL),(29,'WebKit技术内幕',79.00,'朱永盛','电子工业出版社',456,'前端进阶','《WebKit技术内幕》从HTML5的基础知识入手，重点阐述目前应用最广的渲染引擎项目——WebKit。不仅着眼于系统描述WebKit 内部渲染HTML 网页的原理，并基于Chromium 的实现，向读者传授实现高性能Web 前端开发所需的宝贵经验。',NULL),(30,'Web性能权威指南',69.00,'李松峰','人民邮电出版社',317,'性能优化','《Web性能权威指南》是谷歌公司高性能团队核心成员的权威之作，堪称实战经验与规范解读完美结合的产物。《Web性能权威指南》目标是涵盖Web开发者技术体系中应该掌握的所有网络及性能优化知识。全书以性能优化为主线，从TCP、UDP和TLS协议讲起，解释了如何针对这几种协议和基础设施来优化应用。',NULL),(31,'TCP/IP详解',45.00,'范建华 ','机械工业出版社',423,'科普','大家知道，TCP/IP已成为计算机网络的事实上的标准。在关于TCP/IP的论著中，最有影响的就是两部著作。一部是Douglas E. Comer的《用TCP/IP进行网际互连》，\r\nTCP/IP详解系列\r\nTCP/IP详解系列(2张)\r\n 而另一部就是Stevens写的这3卷书。这两套巨著都很有名，各有其特点。无论是从事计算机网络的教师还是进行科研的技术人员，这两套书都应大家知道，TCP/IP已成为计算机网络的事实上的标准。',NULL);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `num` int(11) DEFAULT NULL,
  `customerid` int(11) DEFAULT NULL,
  `bookid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_customerid` (`customerid`),
  KEY `fk_bookid` (`bookid`),
  CONSTRAINT `fk_bookid` FOREIGN KEY (`bookid`) REFERENCES `book` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_customerid` FOREIGN KEY (`customerid`) REFERENCES `customer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=206 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `zip` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (6,'chen','chenlong','5555555','江西上饶金桥','188876666','willon@163.com'),(30,'2222','222222','','安徽','13344445555','');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderform`
--

DROP TABLE IF EXISTS `orderform`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderform` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cost` decimal(10,2) NOT NULL,
  `orderDate` datetime NOT NULL,
  `customerid` int(11) DEFAULT NULL,
  `state` varchar(255) DEFAULT 'pending',
  `payway` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `customerid` (`customerid`),
  CONSTRAINT `customerid` FOREIGN KEY (`customerid`) REFERENCES `customer` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=134 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderform`
--

LOCK TABLES `orderform` WRITE;
/*!40000 ALTER TABLE `orderform` DISABLE KEYS */;
INSERT INTO `orderform` VALUES (125,1554.00,'2018-07-21 17:37:00',30,'payed',1),(126,1309.00,'2018-07-21 19:17:45',30,'pending',NULL),(132,98.00,'2018-07-23 14:00:57',6,'payed',1),(133,508.00,'2018-07-24 16:21:57',6,'pending',NULL);
/*!40000 ALTER TABLE `orderform` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderline`
--

DROP TABLE IF EXISTS `orderline`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderline` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `num` int(11) NOT NULL,
  `orderid` int(11) DEFAULT NULL,
  `bookid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `bookid` (`bookid`),
  KEY `orderid` (`orderid`),
  CONSTRAINT `bookid` FOREIGN KEY (`bookid`) REFERENCES `book` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `orderid` FOREIGN KEY (`orderid`) REFERENCES `orderform` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=412 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderline`
--

LOCK TABLES `orderline` WRITE;
/*!40000 ALTER TABLE `orderline` DISABLE KEYS */;
INSERT INTO `orderline` VALUES (377,1,125,1),(378,1,125,2),(379,5,125,3),(380,7,125,4),(381,8,125,5),(382,1,125,8),(383,2,126,2),(384,2,126,1),(385,1,126,3),(386,5,126,4),(387,7,126,5),(388,1,126,26),(389,1,126,30),(402,1,132,1),(403,1,132,2),(404,1,133,1),(405,2,133,7),(406,1,133,24),(407,1,133,23),(408,1,133,22),(409,1,133,21),(410,1,133,25),(411,1,133,13);
/*!40000 ALTER TABLE `orderline` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-26 22:56:14
