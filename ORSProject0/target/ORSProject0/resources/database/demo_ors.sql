/*
SQLyog Ultimate v9.02 
MySQL - 5.5.5-10.1.37-MariaDB : Database - demo_ors
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`demo_ors` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `demo_ors`;

/*Table structure for table `st_college` */

DROP TABLE IF EXISTS `st_college`;

CREATE TABLE `st_college` (
  `ID` bigint(20) NOT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `ADDRESS` varchar(255) DEFAULT NULL,
  `STATE` varchar(255) DEFAULT NULL,
  `CITY` varchar(255) DEFAULT NULL,
  `PHONE_NO` varchar(255) DEFAULT NULL,
  `CREATED_BY` varchar(255) DEFAULT NULL,
  `MODIFIED_BY` varchar(255) DEFAULT NULL,
  `CREATED_DATETIME` datetime DEFAULT NULL,
  `MODIFIED_DATETIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `st_college` */

insert  into `st_college`(`ID`,`NAME`,`ADDRESS`,`STATE`,`CITY`,`PHONE_NO`,`CREATED_BY`,`MODIFIED_BY`,`CREATED_DATETIME`,`MODIFIED_DATETIME`) values (1,'Medicapse','Rau bypass','M.P','Indore','0731-233211','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 10:36:33','2019-04-05 10:36:33'),(2,'change name','vv','M.P','Indore','0731-233122','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 10:37:07','2019-04-05 10:37:07'),(3,'IET DAVV','Khandwa Road','M.P','Indore','0731-233233','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 10:37:52','2019-04-05 10:37:52'),(4,'Acropolish','Rau Bypass','M.P','Indore','0731-233892','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 10:38:17','2019-04-05 10:38:17'),(5,'LNCT','Behind Aurvindoo','M.P','Indore','741578135',NULL,NULL,NULL,NULL),(6,'SRTS','Bypass Road Hoshangabad','M.P','Bhopal','0722-273902','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 10:39:40','2019-04-05 10:39:40'),(7,'ITM','Jhashi Road','M.P','Gwalior','0751-4758841','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 10:42:03','2019-04-05 10:42:03'),(8,'Gyan Ganga Institute','GP Road','M.P','Jabalpur','0755-233695','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 10:42:44','2019-04-05 10:42:44'),(9,'MPCT','Shiv Puri Road','M.P','Gwalior','0751-4758842','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 10:43:23','2019-04-05 10:43:23'),(10,'Oriental','Ujjain Road','M.P','Bhopal','0751-4758845','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 10:43:56','2019-04-05 10:43:56'),(11,'SVITS','Khandwa Road','M.P','Gwalior','731273906',NULL,NULL,NULL,NULL),(12,'MITS','Behind Aurvindo','M.P','Jabalpur','0766-236541','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 10:45:08','2019-04-05 10:45:08'),(13,'testt','borawan','mp','indore','073124244','Admin','Admin','2019-05-05 00:18:53','2019-05-05 00:18:53'),(14,'testing','dsafdsasdf','adsfdsdsfdfs','asfdasdffsdasdf','0731-273902','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-07-13 15:07:16','2019-07-13 15:07:16'),(15,'SVITS_test','hjgjhhgjh','aa','Khandwa','789123456',NULL,NULL,NULL,NULL),(16,'aSADAS','ASDASDF','ASDFASD','ASDFAS','123456789',NULL,NULL,NULL,NULL),(17,'SVITSzz','asdfdfs','asdffads','Indore','789123456',NULL,NULL,NULL,NULL),(18,'asdfsd','adsfdafs','asdffsada','asdfafsdsd','741578135',NULL,NULL,NULL,NULL),(19,'asdfsdd','adsfdafs','asdffsada','asdfafsdsd','741578135',NULL,NULL,NULL,NULL),(20,'SVITSdsafdsa','dsfadfas','sadfdsa','sdfadfsa','741578135',NULL,NULL,NULL,NULL),(21,'SVITStest','DAJKANKJ','aa','Indore','741578135','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-08-19 13:28:59','2019-08-19 13:28:59');

/*Table structure for table `st_course` */

DROP TABLE IF EXISTS `st_course`;

CREATE TABLE `st_course` (
  `ID` bigint(20) NOT NULL,
  `COURSENAME` varchar(45) DEFAULT NULL,
  `DESCRIPTION` varchar(45) DEFAULT NULL,
  `CREATED_BY` varchar(45) DEFAULT NULL,
  `MODIFIED_BY` varchar(45) DEFAULT NULL,
  `CREATED_DATETIME` datetime DEFAULT NULL,
  `MODIFIED_DATETIME` datetime DEFAULT NULL,
  `DURATION` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `st_course` */

insert  into `st_course`(`ID`,`COURSENAME`,`DESCRIPTION`,`CREATED_BY`,`MODIFIED_BY`,`CREATED_DATETIME`,`MODIFIED_DATETIME`,`DURATION`) values (1,'B.E','Bachekor of Engineering',NULL,NULL,NULL,NULL,'4 Year'),(2,'BCA','Bachelor of Computer Application',NULL,NULL,NULL,NULL,'3 Year'),(3,'MCA','Master of Computer Application',NULL,NULL,NULL,NULL,'3 Year'),(4,'M.Tec','Master of Technology',NULL,NULL,NULL,NULL,'2 Year'),(5,'M.E','Master of Engineering',NULL,NULL,NULL,NULL,'2 Year'),(6,'MSC','zxzxczx',NULL,NULL,NULL,NULL,'1 Year'),(7,'MSCd','asdfasdf',NULL,NULL,NULL,NULL,'2 Year'),(8,'Makeup Lipistic','dsadfadsfdsf',NULL,NULL,NULL,NULL,'6 Year'),(10,'MSC1','asdffad',NULL,NULL,NULL,NULL,'6 Year'),(11,'Fashion','Fashion\r\n',NULL,NULL,NULL,NULL,'1 Year'),(12,'MSCsfddfs','zsds','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-08-19 13:30:04','2019-08-19 13:30:04','1 Year');

/*Table structure for table `st_faculty` */

DROP TABLE IF EXISTS `st_faculty`;

CREATE TABLE `st_faculty` (
  `ID` bigint(20) NOT NULL,
  `First_Name` varchar(255) NOT NULL,
  `Last_Name` varchar(255) NOT NULL,
  `Login_Id` varchar(255) NOT NULL,
  `Date_Of_Joining` datetime NOT NULL,
  `Mobile_No` varchar(255) NOT NULL,
  `College_Name` varchar(255) NOT NULL,
  `College_Id` bigint(20) NOT NULL,
  `Subject_Name` varchar(255) NOT NULL,
  `Subject_Id` bigint(20) NOT NULL,
  `Created_By` varchar(255) NOT NULL,
  `Modified_By` varchar(255) NOT NULL,
  `Created_Datetime` datetime NOT NULL,
  `Modified_Datetime` datetime NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_CollegeId` (`College_Id`),
  KEY `fk_SubjectId` (`Subject_Id`),
  CONSTRAINT `fk_CollegeId` FOREIGN KEY (`College_Id`) REFERENCES `st_college` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_SubjectId` FOREIGN KEY (`Subject_Id`) REFERENCES `st_subject` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `st_faculty` */

insert  into `st_faculty`(`ID`,`First_Name`,`Last_Name`,`Login_Id`,`Date_Of_Joining`,`Mobile_No`,`College_Name`,`College_Id`,`Subject_Name`,`Subject_Id`,`Created_By`,`Modified_By`,`Created_Datetime`,`Modified_Datetime`) values (1,'Santosh','upadhyayy','san@gmail.com','2018-01-25 00:00:00','8120871155','SVITS',11,'Cloud Computing',13,'er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 10:56:45','2019-04-05 10:56:45'),(2,'Rahul','Sonway','sonway@gmail.com','2018-01-24 00:00:00','9977441975','SRTS',6,'Data Communication',14,'er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 10:57:27','2019-04-05 10:57:27'),(3,'Sanu','Gohar','sanu@gmail.com','2018-01-10 00:00:00','9977441998','ITM',7,'Data Structure',12,'er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 10:58:06','2019-04-05 10:58:06'),(4,'Abhishek','Rawal','abhi@gmail.com','2018-01-10 00:00:00','9977441998','IET DAVV',3,'Advance Mathematics',20,'er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 11:02:42','2019-04-05 11:02:42'),(5,'Bony','Patel','bony@gmile.com','2018-01-10 00:00:00','9920871155','IPS',2,'Algorithm',23,'er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 11:03:27','2019-04-05 11:03:27'),(6,'Salman','Khan','sallumiya@gmail.com','2018-01-09 00:00:00','9977441988','MITS',12,'Artificial Intelligence',21,'er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 11:03:54','2019-04-05 11:03:54'),(7,'Akshay','Kumar','akshay@gmail.com','2005-01-12 00:00:00','8120871165','Oriental',10,'Cloud Computing',13,'er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 11:04:33','2019-04-05 11:04:33'),(8,'Ashutosh','Kashiv','ashutosh@gmail.com','2018-01-16 00:00:00','8120871155','SRTS',6,'Digital Electronics',16,'er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 11:05:03','2019-04-05 11:05:03'),(9,'Dinesh','Singh','din@gmail.com','2018-10-10 00:00:00','8120871159','MPCT',9,'Basic Computer',15,'er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 11:05:52','2019-04-05 11:05:52'),(12,'Vivek','Yogi','viv@gmail.com','2018-01-17 00:00:00','9977441985','SRTS',6,'OOP Concept',24,'er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 11:08:08','2019-04-05 11:08:08'),(13,'Rahul','sharma','adi234@gmail.com','2018-01-06 00:00:00','9999991012','aSADAS',16,'Data Structure',12,'root','root','2019-08-17 02:56:38','2019-08-17 02:56:38'),(14,'Rahull','upadhyayy','sachine@gmail.com','2018-01-04 00:00:00','8120871156','SVITSzz',17,'Cloud Engineeering',27,'root','root','2019-08-17 02:59:50','2019-08-17 02:59:50'),(15,'Rahul','sharma','rambabu@gmail.com','2018-01-23 00:00:00','7415781251','Medicapse',1,'OOP Concept',24,'root','root','2019-08-17 11:03:01','2019-08-17 11:03:01'),(16,'Rahul','upadhyayy','mahi@gmai.com','2018-01-09 00:00:00','9977441980','testing',14,'Data Science',22,'root','root','2019-08-17 11:13:33','2019-08-17 11:13:33'),(17,'Rahul','sharma','mahii@gmai.com','2000-01-11 00:00:00','7415781251','MITS',12,'Modeling and Simulation',19,'root','root','2019-08-17 11:26:01','2019-08-17 11:26:01'),(18,'Rahul','sharma','swachine@gmail.com','2018-01-11 00:00:00','8120871155','aSADAS',16,'News Reading',26,'er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-08-19 13:29:33','2019-08-19 13:29:33');

/*Table structure for table `st_marksheet` */

DROP TABLE IF EXISTS `st_marksheet`;

CREATE TABLE `st_marksheet` (
  `ID` bigint(20) NOT NULL,
  `ROLL_NO` varchar(255) DEFAULT NULL,
  `STUDENT_ID` bigint(20) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `PHYSICS` varchar(11) DEFAULT NULL,
  `CHEMISTRY` varchar(11) DEFAULT NULL,
  `MATHS` varchar(11) DEFAULT NULL,
  `CREATED_BY` varchar(255) DEFAULT NULL,
  `MODIFIED_BY` varchar(255) DEFAULT NULL,
  `CREATED_DATETIME` datetime DEFAULT NULL,
  `MODIFIED_DATETIME` datetime DEFAULT NULL,
  `TOTAL` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_STUDENT_ID_idx` (`STUDENT_ID`),
  CONSTRAINT `fk_STUDENT_ID` FOREIGN KEY (`STUDENT_ID`) REFERENCES `student` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `st_marksheet` */

insert  into `st_marksheet`(`ID`,`ROLL_NO`,`STUDENT_ID`,`NAME`,`PHYSICS`,`CHEMISTRY`,`MATHS`,`CREATED_BY`,`MODIFIED_BY`,`CREATED_DATETIME`,`MODIFIED_DATETIME`,`TOTAL`) values (1,'101',1,'Aditya Pathak','65','85','66','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 11:08:29','2019-04-05 11:08:29',NULL),(2,'102',2,'Bhavesh Upadhyay','67','65','75','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 11:08:29','2019-04-05 11:09:27',NULL),(3,'103',3,'Charli Gujer','66','78','91','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 11:09:40','2019-04-05 11:09:40',NULL),(4,'104',4,'Deepshikha Bhatia','78','88','75','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 11:09:40','2019-04-05 11:09:54',NULL),(5,'105',11,'Khushboo verma','65','45','98','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 11:09:40','2019-04-05 11:10:04',NULL),(7,'107',12,'Nikita Sohani','92','65','75','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 11:09:40','2019-04-05 11:10:26',NULL),(8,'108',6,'Rahul Falke','75','46','59','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 11:09:40','2019-04-05 11:12:33',NULL),(9,'109',7,'Rahul jain','65','49','78','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 11:09:40','2019-04-05 11:10:46',NULL),(10,'110',9,'Santosh Bhorjar','65','75','64','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 11:09:40','2019-04-05 11:10:56',NULL),(12,'112',8,'Varsha Goyal','19','06','08','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 11:09:40','2019-04-05 11:11:22',NULL),(13,'113',5,'karan Patidar','22','19','05','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 11:09:40','2019-04-05 11:11:40',NULL),(14,'102EC101',1,'Aditya Pathak','78','78','78',NULL,NULL,NULL,NULL,234),(15,'101Ec101',2,'Bhavesh Upadhyay','86','87','15',NULL,NULL,NULL,NULL,188),(16,'1015555',17,'Rahul sharma','65','45','75','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-08-19 13:31:08','2019-08-19 13:31:08',185),(17,'101589',14,'RockinTesting asdfdafssdf',NULL,NULL,NULL,'er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-08-19 14:09:14','2019-08-19 14:09:14',NULL),(18,'101102',2,'Bhavesh Upadhyay','55','55','56','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-08-19 14:28:15','2019-08-19 14:28:57',NULL);

/*Table structure for table `st_role` */

DROP TABLE IF EXISTS `st_role`;

CREATE TABLE `st_role` (
  `ID` bigint(20) NOT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `CREATED_BY` varchar(255) DEFAULT NULL,
  `MODIFIED_BY` varchar(255) DEFAULT NULL,
  `CREATED_DATETIME` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `MODIFIED_DATETIME` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `st_role` */

insert  into `st_role`(`ID`,`NAME`,`DESCRIPTION`,`CREATED_BY`,`MODIFIED_BY`,`CREATED_DATETIME`,`MODIFIED_DATETIME`) values (1,'Admin','Administrator Role',NULL,NULL,NULL,NULL),(2,'Student','Student Role Test','Rahul Sahu','rahul.sahu@nenosystems.com','2014-07-19 17:19:09','2014-07-22 18:59:16'),(3,'College','College Role','Rahul Sahu','Rahul Sahu','2014-07-19 17:19:30','2014-07-19 17:19:30'),(4,'KIOSK','KIOSK Role','Rahul Sahu','pankaj.sahu@nenosystems.com','2014-07-19 17:19:48','2014-09-02 17:04:22'),(5,'Faculty','Faculty Role',NULL,NULL,NULL,NULL),(6,'Manager','Manager','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 10:53:49','2019-04-05 10:53:49'),(7,'Councler','For Councling','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 10:54:14','2019-04-05 10:54:14'),(8,'Director','Direcotor','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 10:54:27','2019-04-05 10:54:27'),(9,'Principal','Principal','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 10:54:43','2019-04-05 10:54:43'),(10,'CEO','CEO','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 10:55:12','2019-04-05 10:55:12'),(11,'Assistant Director','Assistant Director','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 10:55:28','2019-04-05 10:55:28'),(12,'SVITS','asdfsas',NULL,NULL,NULL,NULL),(15,'amdox','asdffdsads',NULL,NULL,NULL,NULL);

/*Table structure for table `st_subject` */

DROP TABLE IF EXISTS `st_subject`;

CREATE TABLE `st_subject` (
  `ID` bigint(20) NOT NULL,
  `course_Name` varchar(50) DEFAULT NULL,
  `Course_Id` bigint(20) DEFAULT NULL,
  `Subject_Name` varchar(50) DEFAULT NULL,
  `Subject_Id` bigint(20) DEFAULT NULL,
  `Description` varchar(50) DEFAULT NULL,
  `Created_By` varchar(50) DEFAULT NULL,
  `Modified_By` varchar(50) DEFAULT NULL,
  `Created_Datetime` datetime DEFAULT NULL,
  `Modified_Datetime` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_CourseId` (`Course_Id`),
  CONSTRAINT `fk_CourseId` FOREIGN KEY (`Course_Id`) REFERENCES `st_course` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `st_subject` */

insert  into `st_subject`(`ID`,`course_Name`,`Course_Id`,`Subject_Name`,`Subject_Id`,`Description`,`Created_By`,`Modified_By`,`Created_Datetime`,`Modified_Datetime`) values (12,'B.E',1,'Data Structure',0,'Related to Data','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 10:27:58','2019-04-05 10:27:58'),(13,'B.E',1,'Cloud Computing',0,'Related to Cloud Storage','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 10:28:43','2019-04-05 10:28:43'),(14,'B.E',1,'Data Communication',0,'Related to Data Transfer','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 10:29:39','2019-04-05 10:29:39'),(15,'BCA',2,'Basic Computer',0,'Basic Computer','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 10:58:28','2019-04-05 10:58:28'),(16,'BCA',2,'Digital Electronics',0,'Digital Electronics',NULL,NULL,NULL,NULL),(17,'BCA',2,'Information Technology',0,'Information Technology','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 10:59:36','2019-04-05 10:59:36'),(18,'M.E',5,'Digital Communication',0,'Digital Communication','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 10:59:57','2019-04-05 10:59:57'),(19,'M.E',5,'Modeling and Simulation',0,'Modeling and Simulation','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 11:00:18','2019-04-05 11:00:18'),(20,'M.E',5,'Advance Mathematics',0,'Advance Mathematics','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 11:00:34','2019-04-05 11:00:34'),(21,'M.Tec',4,'Artificial Intelligence',0,'Artificial Intelligence','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 11:01:00','2019-04-05 11:01:00'),(22,'M.Tec',4,'Data Science',0,'Data Science','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 11:01:13','2019-04-05 11:01:13'),(23,'MCA',3,'Algorithm',0,'Algorithm','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 11:01:27','2019-04-05 11:01:27'),(24,'MCA',3,'OOP Concept',0,'OOP Concept','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 11:01:43','2019-04-05 11:01:43'),(25,'B.E',1,'asdfsd',NULL,'xvfdsdsfsdfa',NULL,NULL,NULL,NULL),(26,'B.E',1,'News Reading',NULL,'asdffsd',NULL,NULL,NULL,NULL),(27,'BCA',2,'Cloud Engineeering',NULL,'adsadsfdsadfsa',NULL,NULL,NULL,NULL),(29,'MSC',6,'asdffadsa',NULL,'asddsaf',NULL,NULL,NULL,NULL),(30,'MSCsfddfs',12,'News Readinga',NULL,'dasas','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-08-19 13:30:21','2019-08-19 13:30:21');

/*Table structure for table `st_timetable` */

DROP TABLE IF EXISTS `st_timetable`;

CREATE TABLE `st_timetable` (
  `ID` bigint(20) NOT NULL,
  `course_name` varchar(50) DEFAULT NULL,
  `course_id` bigint(20) DEFAULT NULL,
  `subject_name` varchar(50) DEFAULT NULL,
  `subject_id` bigint(20) DEFAULT NULL,
  `exam_date` datetime DEFAULT NULL,
  `exam_time` varchar(255) DEFAULT NULL,
  `semester` varchar(50) DEFAULT NULL,
  `created_by` varchar(30) DEFAULT NULL,
  `modified_by` varchar(30) DEFAULT NULL,
  `created_datetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `modified_datetime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`ID`),
  KEY `FK_st_timetable` (`course_id`),
  KEY `fk_Subject_Id` (`subject_id`),
  CONSTRAINT `FK_st_timetable` FOREIGN KEY (`course_id`) REFERENCES `st_course` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_Subject_Id` FOREIGN KEY (`subject_id`) REFERENCES `st_subject` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `st_timetable` */

insert  into `st_timetable`(`ID`,`course_name`,`course_id`,`subject_name`,`subject_id`,`exam_date`,`exam_time`,`semester`,`created_by`,`modified_by`,`created_datetime`,`modified_datetime`) values (2,'B.E',1,'Cloud Computing',13,'2019-05-08 00:00:00','7:00 AM TO 10:00 AM','1st','root','root','2019-08-17 14:14:08','2019-08-17 14:14:08'),(3,'B.E',1,'Data Communication',14,'2019-05-10 00:00:00','7:00 AM TO 10:00 AM','2nd','root','root','2019-08-17 14:14:30','2019-08-17 14:14:30'),(4,'BCA',2,'Basic Computer',15,'2019-06-03 00:00:00','10:00 AM TO 1:00 PM','4th','root','root','2019-08-17 14:15:41','2019-08-17 14:15:41'),(5,'BCA',2,'Digital Electronics',16,'2019-06-05 00:00:00','1:00 PM TO 3:00 PM','4th','root','root','2019-08-17 14:15:50','2019-08-17 14:15:50'),(6,'BCA',2,'Information Technology',17,'2019-06-07 00:00:00','10:00 AM TO 1:00 PM','6th','root','root','2019-08-17 14:16:00','2019-08-17 14:16:00'),(7,'M.E',5,'Advance Mathematics',20,'2019-07-01 00:00:00','03:00 PM To 05:00 PM','1st','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-08-17 14:14:58','2019-04-05 11:16:49'),(8,'M.E',5,'Modeling and Simulation',19,'2019-07-03 00:00:00','03:00 PM To 05:00 PM','1st','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-08-17 14:14:56','2019-04-05 11:17:10'),(9,'M.E',5,'Digital Communication',18,'2019-07-05 00:00:00','03:00 PM To 05:00 PM','1st','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-08-17 14:14:55','2019-04-05 11:17:44'),(13,'MCA',3,'OOP Concept',24,'2019-04-25 00:00:00','12:00 PM To 02:00 PM','1st','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-08-17 14:14:54','2019-04-10 17:08:28'),(15,'M.Tec',4,'Data Communication',14,'2019-01-02 00:00:00','08:00 AM To 10:00 AM','1st','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-08-17 14:14:52','2019-05-01 18:34:51'),(16,'B.E',1,'OOP Concept',24,'2019-01-10 00:00:00','7:00 AM TO 10:00 AM','1st','root','root','2019-08-17 13:38:03','2019-08-17 13:38:03'),(17,'B.E',1,'Data Structure',12,'2019-01-09 00:00:00','7:00 AM TO 10:00 AM','1st','root','root','2019-08-17 13:41:47','2019-08-17 13:41:47'),(18,'BCA',2,'News Reading',26,'2019-01-08 00:00:00','10:00 AM TO 1:00 PM','4th','root','root','2019-08-17 14:21:38','2019-08-17 14:21:38'),(19,'B.E',1,'Data Structure',12,'2019-01-01 00:00:00','10:00 AM TO 1:00 PM','8th','root','root','2019-08-17 14:26:30','2019-08-17 14:26:30'),(20,'MSCsfddfs',12,'Cloud Engineeering',27,'2019-01-16 00:00:00','1:00 PM TO 3:00 PM','1st','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-08-19 13:30:43','2019-08-19 13:30:43');

/*Table structure for table `st_user` */

DROP TABLE IF EXISTS `st_user`;

CREATE TABLE `st_user` (
  `ID` bigint(20) NOT NULL,
  `FIRST_NAME` varchar(255) DEFAULT NULL,
  `LAST_NAME` varchar(255) DEFAULT NULL,
  `LOGIN` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `DOB` datetime DEFAULT NULL,
  `MOBILE_NO` varchar(255) DEFAULT NULL,
  `ROLE_ID` bigint(20) DEFAULT NULL,
  `UNSUCCESSFUL_LOGIN` int(11) DEFAULT NULL,
  `GENDER` varchar(255) DEFAULT NULL,
  `LAST_LOGIN` datetime DEFAULT NULL,
  `USER_LOCK` varchar(255) DEFAULT NULL,
  `REGISTERED_IP` varchar(255) DEFAULT NULL,
  `LAST_LOGIN_IP` varchar(255) DEFAULT NULL,
  `CREATED_BY` varchar(255) DEFAULT NULL,
  `MODIFIED_BY` varchar(255) DEFAULT NULL,
  `CREATED_DATETIME` datetime DEFAULT NULL,
  `MODIFIED_DATETIME` datetime DEFAULT NULL,
  `confirmPassword` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_ROLE_ID_idx` (`ROLE_ID`),
  CONSTRAINT `fk_ROLE_ID` FOREIGN KEY (`ROLE_ID`) REFERENCES `st_role` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `st_user` */

insert  into `st_user`(`ID`,`FIRST_NAME`,`LAST_NAME`,`LOGIN`,`PASSWORD`,`DOB`,`MOBILE_NO`,`ROLE_ID`,`UNSUCCESSFUL_LOGIN`,`GENDER`,`LAST_LOGIN`,`USER_LOCK`,`REGISTERED_IP`,`LAST_LOGIN_IP`,`CREATED_BY`,`MODIFIED_BY`,`CREATED_DATETIME`,`MODIFIED_DATETIME`,`confirmPassword`) values (1,'Rahul','Sahu','rahul123@gmail.com','admin@123','2014-07-24 00:00:00','8120871151',1,0,'M','2014-09-29 19:30:52','Inactive','0:0:0:0:0:0:0:1','192.168.1.17','Rahul Sahu','Rahul Sahu','2014-07-19 17:39:20','2014-07-19 18:29:23',NULL),(5,'vipin','chandore','vipin.chandore1452@gmail.com','admin@123','1991-08-08 00:00:00','8120871152',2,0,'Female',NULL,'Inactive',NULL,NULL,NULL,NULL,NULL,NULL,'admin@123'),(15,'rkj','ghgh','rahul.sahu12@nenosystems.com','rr','2014-08-18 00:00:00','1656689852',2,0,'Male',NULL,'Inactive','192.168.1.13','192.168.1.13','','','2014-08-26 20:01:18','2014-08-26 20:01:42',NULL),(16,'ranjit','choudhary','r@gmail.com','rr','1970-01-14 00:00:00','9456936545',2,0,'Male',NULL,'Inactive','192.168.1.13','192.168.1.13','rahul.sahu@nenosystems.com','rahul.sahu@nenosystems.com','2014-08-30 11:39:18','2014-08-30 12:23:40',NULL),(17,'ranjit','choudhary','ranjitchoudhary210@gmail.com','rr','2014-08-20 00:00:00','1234567890',2,0,'Male',NULL,'Inactive','192.168.1.13','192.168.1.13','rahul.sahu@nenosystems.com','rahul.sahu@nenosystems.com','2014-08-30 11:45:31','2014-08-30 12:24:41',NULL),(20,'Rajesh','gupta','ranjit@gmail.com','6969695656','2014-09-18 00:00:00','9977441989',1,0,'M',NULL,'Inactive',NULL,NULL,'root','rahul.sahu@nenosystems.com','2014-09-01 17:58:16','2014-09-01 18:41:20',NULL),(21,'Pankaj','Sahu','pankaj.sahu@nenosystems.com','karisma123','1986-11-07 00:00:00','9827568186',1,0,'M','2014-10-31 13:05:24','Inactive','','122.168.194.184','root','rahul.sahu@nenosystems.com','2014-09-01 19:50:04','2014-09-01 19:56:54',NULL),(22,'pankaj','sahu','sahu.pankaj07@gmail.com','123456@','1986-11-07 00:00:00','8887774523',1,0,'M',NULL,'Inactive',NULL,NULL,'er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2014-09-01 20:00:44','2019-04-26 20:52:45',NULL),(23,'MP','Online','ksahu044@gmail.com','123456','2010-02-11 00:00:00','9827568186',4,0,'M',NULL,'Inactive',NULL,NULL,'root','pankaj.sahu@nenosystems.com','2014-09-02 17:11:19','2014-09-02 17:15:58',NULL),(24,'test','test','test@gmail.com','pass1234','2014-09-03 00:00:00','9632587412',2,0,'M',NULL,'Inactive',NULL,NULL,'root','root','2014-09-04 19:17:46','2014-09-04 19:17:51',NULL),(25,'mohammed','imran','imranmohammed875@gmail.com','120891','1991-08-12 00:00:00','9981095676',2,0,'M',NULL,'Inactive',NULL,NULL,'root','root','2014-09-18 12:12:27','2014-09-18 12:12:27',NULL),(26,'arif','khan','khan123arif@gmail.com','newkhandon786','1985-05-08 00:00:00','8956231254',3,0,'M',NULL,'Inactive',NULL,NULL,'root','pankaj.sahu@nenosystems.com','2014-09-21 15:48:58','2014-10-30 18:59:25',NULL),(27,'richa','trivedi','trivedi.richa88@gmail.com','123456','1988-01-27 00:00:00','9865257412',2,0,'F',NULL,'Inactive',NULL,NULL,'root','root','2014-09-22 08:29:50','2014-09-22 08:29:50',NULL),(28,'HK','RK','hkrk@yahoo.com','qazxsw','1986-10-27 00:00:00','9784512367',2,0,'M',NULL,'Inactive',NULL,NULL,'root','root','2014-09-23 15:48:47','2014-09-23 15:49:20',NULL),(29,'Abhiraj Singh','Chouhan','abhiraj2201@gmail.com','Abhi_2201','1989-01-22 00:00:00','9966332211',2,0,'M',NULL,'Inactive',NULL,NULL,'root','root','2014-09-23 22:43:34','2014-09-23 22:43:34',NULL),(30,'Deepak','Prajapat','deepak.prajapat99@gmail.com','deepak','1992-09-23 00:00:00','123456987',2,0,'M',NULL,'Inactive',NULL,NULL,'root','root','2014-09-24 16:07:16','2014-09-24 16:07:16',NULL),(31,'Asheesh','Patel','asheesh.patel@gmail.com','123456789','1990-01-11 00:00:00',NULL,2,0,'M',NULL,'Inactive',NULL,NULL,'root','root','2014-09-26 12:19:03','2014-09-26 12:19:03',NULL),(32,'shubham','tiwari','shubhamtiwari@gmail.com','justbitit','2014-07-27 00:00:00',NULL,2,0,'M',NULL,'Inactive',NULL,NULL,'root','root','2014-09-27 14:06:08','2014-09-27 14:06:08',NULL),(33,'harsh','dubey','hdubey29@gmail.com','124','1993-07-29 00:00:00',NULL,2,0,'M',NULL,'Inactive',NULL,NULL,'root','root','2014-09-29 11:15:41','2014-09-29 11:15:41',NULL),(35,'Rajesh','gupta','deepeshgupta@gmail.com','6969695656','2000-09-24 00:00:00','9876543210',1,0,'M','2014-09-29 19:42:47','Inactive','192.168.1.17','192.168.1.17','rahul.sahu@nenosystems.com','rahul.sahu@nenosystems.com','2014-09-29 19:14:10',NULL,NULL),(36,'admin','admin','admin@gmail.com','pass1234','2000-09-24 00:00:00','9876543210',1,0,'Male','2014-09-29 19:34:18','Inactive','192.168.1.17','192.168.1.17','rahul.sahu@nenosystems.com','rahul.sahu@nenosystems.com','2014-09-29 19:14:10',NULL,NULL),(37,'jay','jay','jay@gmail.com','pass1234','2014-09-03 00:00:00','9876543210',2,0,'Male',NULL,'Inactive','192.168.1.17','192.168.1.17','superadmin@gmail.com','superadmin@gmail.com','2014-09-29 19:40:35','2014-09-29 19:40:35',NULL),(38,'dk','pandey','dk@gmail.com','pass1234','2000-09-09 00:00:00','9876543210',2,0,'Male',NULL,'Inactive','192.168.1.17','192.168.1.17','superadmin@gmail.com','superadmin@gmail.com','2014-09-29 19:41:43','2014-09-29 19:41:43',NULL),(39,'rahul','saxena','rahulsxn9666@gmail.com','1234','2014-12-09 00:00:00',NULL,2,0,'M',NULL,'Inactive',NULL,NULL,'root','pankaj.sahu@nenosystems.com','2014-09-30 19:27:26','2014-09-30 20:11:31',NULL),(40,'ashish','gupta','ashishgupta@gmail.com','123','2014-09-30 00:00:00',NULL,2,0,'M',NULL,'Inactive',NULL,NULL,'root','root','2014-09-30 20:08:30','2014-09-30 20:08:30',NULL),(41,'Ayush','Patidar','ayush.patidar1@gmail.com','9826754940','1990-11-18 00:00:00',NULL,2,0,'M',NULL,'Inactive',NULL,NULL,'root','root','2014-10-06 14:30:07','2014-10-06 14:30:07',NULL),(42,'dsdf','fdsf','sunilmca575@gmail.com','123','2014-10-15 00:00:00',NULL,2,0,'M',NULL,'Inactive',NULL,NULL,'root','root','2014-10-06 17:56:32','2014-10-06 17:57:25',NULL),(43,'salman','khan','salman172006@gmail.com','123456','1990-04-08 00:00:00',NULL,2,0,'M',NULL,'Inactive',NULL,NULL,'root','root','2014-10-11 18:59:13','2014-10-11 18:59:13',NULL),(44,'SANJAY','THAKUR','sanjay.thakurji@gmail.com','jaythakur','1989-11-10 00:00:00',NULL,2,0,'M',NULL,'Inactive',NULL,NULL,'root','root','2014-10-13 13:39:59','2014-10-13 13:39:59',NULL),(45,'Trilok','devda','tsd10101991@gmail.com','12345','1991-10-10 00:00:00',NULL,2,0,'M',NULL,'Inactive',NULL,NULL,'root','root','2014-10-25 15:59:48','2014-10-25 15:59:48',NULL),(46,'radhika','apte','radhika@gmail.com','abc@123@ABC','1990-01-17 00:00:00','7000095125',2,0,'M',NULL,NULL,NULL,NULL,'root','root','2019-02-11 16:19:46','2019-02-11 16:20:08',NULL),(47,'Ayush','joshi','joshiayush5550@gmail.com','pass1234','1995-01-18 00:00:00',NULL,2,0,'M',NULL,'Inactive',NULL,NULL,'root','root','2019-02-13 14:05:14','2019-02-13 14:05:43',NULL),(48,'Ayush','joshi','abc@gmail.com','pass1234','1995-01-17 00:00:00',NULL,2,0,'M',NULL,'Inactive',NULL,NULL,'root','root','2019-02-13 14:05:14','2019-02-13 14:07:12',NULL),(49,'shivi','yogi','shiv@gmail.com','shivi123','1993-01-13 00:00:00',NULL,2,0,'F',NULL,'Inactive',NULL,NULL,'root','root','2019-02-26 13:44:31','2019-02-26 13:44:31',NULL),(50,'Pawan','Sharma','er.pa1.sharma@gmail.com','admin@123','1993-02-16 00:00:00','7415781251',1,0,'Male',NULL,'Inactive',NULL,NULL,'sameerbhonsle2@gmail.com','sameerbhonsle2@gmail.com','2019-02-26 13:53:33','2019-07-03 21:17:57',NULL),(51,'Rahul','sharma','sameer@gmail.com','abc@123','2000-01-18 00:00:00',NULL,2,0,'M',NULL,'Inactive',NULL,NULL,'root','root','2019-03-13 16:01:53','2019-03-13 16:01:53',NULL),(52,'Rahul','sharma','sameer1223@gmail.com','abc@123','2000-01-18 00:00:00',NULL,2,0,'M',NULL,'Inactive',NULL,NULL,'root','root','2019-03-13 16:02:26','2019-03-13 16:02:34',NULL),(53,'Rahul','sharma','bhaveshupadhyayy3@gmail.com','abc@123','2000-01-19 00:00:00',NULL,2,0,'M',NULL,'Inactive',NULL,NULL,'root','root','2019-04-02 16:36:33','2019-04-02 16:36:39',NULL),(54,'PubG','Mobile','pubg2105@gmail.com','abc@123','2000-01-12 00:00:00',NULL,2,0,'M',NULL,'Inactive',NULL,NULL,'root','root','2019-04-02 23:27:44','2019-04-02 23:27:44',NULL),(55,'Sameer','Bhonsle','sameerbhonsle2@gmail.com','admin@123','1991-05-15 00:00:00',NULL,3,0,'M',NULL,'Inactive',NULL,NULL,'rahul123@gmail.com','rahul123@gmail.com','2019-04-03 13:18:18','2019-04-03 13:18:18',NULL),(56,'Bhavesh','Upadhyay','bhaveshupadhyay3@gmail.com','admin@123','2000-01-12 00:00:00',NULL,2,0,'M',NULL,'Inactive',NULL,NULL,'rahul123@gmail.com','rahul123@gmail.com','2019-04-03 13:19:10','2019-04-03 13:19:22',NULL),(59,'Rahul','sharma','rahul@gmail.com','admin@123','2000-01-12 00:00:00','7415781251',2,0,'Male',NULL,'Inactive',NULL,NULL,NULL,NULL,NULL,NULL,'admin@123'),(60,'Rahul','sharma','rahulG@gmail.com','admin@123','2000-01-12 00:00:00','7415781251',1,0,'Male',NULL,'Inactive',NULL,NULL,NULL,NULL,NULL,NULL,'admin@123'),(61,'barkha','sharma','barkha170589@gmail.com','admin@123','1989-05-17 00:00:00','7415781251',1,0,'Female',NULL,'Inactive',NULL,NULL,NULL,NULL,NULL,NULL,'admin@123'),(62,'Desvansh','sharma','dev@gmail.com','admin@123','2000-01-11 00:00:00','7415781251',2,0,'Female',NULL,'Inactive',NULL,NULL,NULL,NULL,NULL,NULL,'admin@123'),(63,'Rahul','sharma','sameerbhonsle@gmail.com','admin@123','1990-01-10 00:00:00','7415781251',1,0,'Male',NULL,'Inactive',NULL,NULL,NULL,NULL,NULL,NULL,'admin@123'),(64,'Rajesh','Kumar','raj@gmail.com','admin@123','1990-01-25 00:00:00','7415781251',2,0,'Female',NULL,'Inactive',NULL,NULL,NULL,NULL,NULL,NULL,'admin@123'),(65,'Rajesh','Kumar','raju@gmail.com','admin@123','1990-01-25 00:00:00','7415781251',2,0,'Male',NULL,'Inactive',NULL,NULL,NULL,NULL,NULL,NULL,'admin@123'),(66,'Rahul','sharma','pawan0881@gmail.com','admin@123','2000-01-12 00:00:00','7415781251',2,0,'Male',NULL,'Inactive',NULL,NULL,'root','root','2019-08-19 13:27:12','2019-08-19 13:27:12','admin@123');

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `ID` bigint(20) NOT NULL,
  `COLLEGE_ID` bigint(20) DEFAULT NULL,
  `COLLEGE_NAME` varchar(255) DEFAULT NULL,
  `FIRST_NAME` varchar(255) DEFAULT NULL,
  `LAST_NAME` varchar(255) DEFAULT NULL,
  `DATE_OF_BIRTH` datetime DEFAULT NULL,
  `MOBILE_NO` varchar(255) DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `CREATED_BY` varchar(255) DEFAULT NULL,
  `MODIFIED_BY` varchar(255) DEFAULT NULL,
  `CREATED_DATETIME` datetime DEFAULT NULL,
  `MODIFIED_DATETIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_COLLEGE_ID_idx` (`COLLEGE_ID`),
  CONSTRAINT `fk_COLLEGE_ID` FOREIGN KEY (`COLLEGE_ID`) REFERENCES `st_college` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `student` */

insert  into `student`(`ID`,`COLLEGE_ID`,`COLLEGE_NAME`,`FIRST_NAME`,`LAST_NAME`,`DATE_OF_BIRTH`,`MOBILE_NO`,`EMAIL`,`CREATED_BY`,`MODIFIED_BY`,`CREATED_DATETIME`,`MODIFIED_DATETIME`) values (1,4,'Acropolish','Aditya','Pathak','1994-01-19 00:00:00','7415781211','adi@gmail.com','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 10:46:13','2019-04-05 10:46:13'),(2,8,'Gyan Ganga Institute','Bhavesh','Upadhyay','1993-01-13 00:00:00','9977441980','bhavesh@gmail.com','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 10:46:41','2019-04-05 10:46:41'),(3,3,'IET DAVV','Charli','Gujer','1994-01-09 00:00:00','8120871156','charli@gmail.com','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 10:47:15','2019-04-05 10:47:15'),(4,3,'IET DAVV','Deepshikha','Bhatia','2000-01-21 00:00:00','9977441980','deep@gmail.com','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 10:47:39','2019-04-05 10:47:58'),(5,12,'MITS','karan','Patidar','2000-01-12 00:00:00','8120871156','karan@gmail.com','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 10:48:45','2019-04-05 10:48:45'),(6,12,'MITS','Rahul','Falke','2000-01-18 00:00:00','9977441981','rahulf@gmail.com','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 10:49:25','2019-04-05 10:49:32'),(7,6,'SRTS','Rahul','jain','2000-01-18 00:00:00','9977441998','rahul@gmail.com','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 10:49:57','2019-04-05 10:49:57'),(8,1,'Medicapse','Varsha','Goyal','1996-01-10 00:00:00','8120871156','versha@gmail.com','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 10:50:30','2019-04-05 10:50:30'),(9,10,'Oriental','Santosh','Bhorjar','2000-01-29 00:00:00','9977441975','santosh@gmail.com','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 10:51:05','2019-04-05 10:51:05'),(11,5,'LNCT','Khushboo','verma','2000-01-25 00:00:00','8120871169','khush@gmail.com','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 10:51:58','2019-04-05 10:51:58'),(12,5,'LNCT','Nikita','Sohani','2000-01-20 00:00:00','8120871157','nikita@gmail.com','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 10:52:26','2019-04-05 10:52:26'),(13,9,'MPCT','Sawan','Panwar','1997-07-16 00:00:00','9977441976','sawan@gmail.com','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-04-05 10:53:02','2019-04-05 10:53:02'),(14,2,NULL,'RockinTesting','asdfdafssdf','2000-01-18 00:00:00','7415781251','testing@gmail.com',NULL,NULL,NULL,NULL),(15,10,NULL,'tkelkjklejs','kaskljksdj','2000-01-19 00:00:00','7415781251','adfs@gmail.com',NULL,NULL,NULL,NULL),(16,1,NULL,'Rahul','sharma','2000-01-19 00:00:00','7415781251','rahulg@gmail.com',NULL,NULL,NULL,NULL),(17,1,NULL,'Rahul','sharma','2000-01-19 00:00:00','7415781251','arahulg@gmail.com',NULL,NULL,NULL,NULL),(18,1,NULL,'Rahul','sharma','2000-01-19 00:00:00','7415781251','brahulg@gmail.com',NULL,NULL,NULL,NULL),(19,1,NULL,'Rahul','sharma','2000-01-19 00:00:00','7415781251','crahulg@gmail.com',NULL,NULL,NULL,NULL),(21,17,NULL,'Rahul','sharma','2000-01-12 00:00:00','7415781251','er.pa1.sharma@gmail.com',NULL,NULL,NULL,NULL),(22,7,'ITM','asdsadfsad','sadfdsaf','2000-01-18 00:00:00','7415781251','save@dsaf.com',NULL,NULL,NULL,NULL),(23,7,'ITM','Rahul','sharma','2000-01-12 00:00:00','7415781251','pawan0881@gmail.com','er.pa1.sharma@gmail.com','er.pa1.sharma@gmail.com','2019-08-19 13:28:22','2019-08-19 13:28:22');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
