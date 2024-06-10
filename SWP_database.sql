create database SWP391;

use  SWP391;

CREATE TABLE Student
(
  IdStudent INT auto_increment NOT NULL,
  NameStudent VARCHAR(32),
    Email VARCHAR(32),
      `password` VARCHAR(32),
  Phone VARCHAR(10),
  Gender INT,
  Dob DATE,
  DateCreate DATE,
  DateModify DATE,
  `Status` INT default 1,
  `Role` INT default 0,
  Image VARCHAR(255),
  PRIMARY KEY (IdStudent)
);

CREATE TABLE Club
(
  IdClub INT auto_increment NOT NULL,
  NameClub VARCHAR(32),
  `Point` INT,
  DateCreate DATE,
  DateModify DATE,
  `Status` INT default 1,
  PRIMARY KEY (IdClub)
);

CREATE TABLE Role
(
  IdRole INT AUTO_INCREMENT NOT NULL,
  NameRole NVARCHAR(32),
  Status INT,
  PRIMARY KEY (IdRole)
);

CREATE TABLE StudentClub
(
  `Point` INT default 100,
  DateCreate DATE,
  DateModify DATE,
  `Status` INT default 1,
  IdStudent INT NOT NULL,
  IdClub INT NOT NULL,
  IdRole INT,
  PRIMARY KEY (IdStudent, IdClub),
  FOREIGN KEY (IdStudent) REFERENCES Student(IdStudent),
  FOREIGN KEY (IdClub) REFERENCES Club(IdClub),
  FOREIGN KEY (IdRole) REFERENCES Role(IdRole)
);

CREATE TABLE EventType
(
  IdEventType int NOT NULL,
  NameEvent NVARCHAR(255),
  PRIMARY KEY (IdEventType)
);

CREATE TABLE Event
(
  IdEvent INT auto_increment NOT NULL,
  NameEvent VARCHAR(32),
  DateCreate DATE,
  DateModify DATE,
  `Status` INT default 1,
  Addreess VARCHAR(32),
  DateEnd DATE ,
  IdClub INT,
  DateStart DATE,
  Image NVARCHAR(255),
  PRIMARY KEY (IdEvent),
   IdEventType int,
  FOREIGN KEY (IdClub) REFERENCES Club(IdClub),
  FOREIGN KEY (IdEventType) REFERENCES EventType(IdEventType)
);

CREATE TABLE Task
(
  IdTask INT auto_increment NOT NULL,
  NameTask VARCHAR(32),
  DateCreate DATE,
  DateEnd DATE,
  `Status` INT default 1,
  IdClub INT,
  IdEvent INT,
  IdStudent INT NOT NULL,
  PRIMARY KEY (IdTask),
  FOREIGN KEY (IdClub) REFERENCES Club(IdClub),
  FOREIGN KEY (IdEvent) REFERENCES Event(IdEvent),
  FOREIGN KEY (IdStudent, IdClub) REFERENCES StudentClub(IdStudent, IdClub)
);

CREATE TABLE BlogType
(
  IdBlogType int NOT NULL,
  NameBlogType NVARCHAR(255),
  PRIMARY KEY (IdBlogType)
);

CREATE TABLE Blog
(
  IdBlog INT auto_increment NOT NULL,
  TittleBlog VARCHAR(32),
  Image VARCHAR(255),
  `Description`text,
  Content text,
  DateCreate DATE,
  DateModify DATE,
   IdBlogType int,
    IdClub INT,
  `Show` INT,
  `Status` INT ,
  PRIMARY KEY (IdBlog),
  FOREIGN KEY (IdClub) REFERENCES Club(IdClub),
  FOREIGN KEY (IdBlogType) REFERENCES BlogType(IdBlogType)
);

CREATE TABLE Form
(
  IdForm INT auto_increment NOT NULL,
    FullName VARCHAR(32),
  TittleForm VARCHAR(32),
  Content VARCHAR(1000),
  DateCreate Date,
  Email VARCHAR(32),
  `Status` INT default 1,
  isRead INT default 0,
  PRIMARY KEY (IdForm)
);

CREATE TABLE RegisterClub
(
  IdClubRegister INT auto_increment NOT NULL,
  NameClub VARCHAR(32) NOT NULL,
  Reason VARCHAR(1000) NOT NULL,
  `Member` INT NOT NULL,
  IdStudent INT NOT NULL,
  PRIMARY KEY (IdClubRegister),
  FOREIGN KEY (IdStudent) REFERENCES Student(IdStudent)
);



INSERT INTO `club` VALUES (1,'Football Club',100,'2023-01-01','2023-01-02',1),(2,'Choir Club',100,'2023-01-03','2023-01-04',1),(3,'Painting Club',100,'2023-01-05','2023-01-06',1),(4,'Robotics Club',100,'2023-01-07','2023-01-08',1),(5,'Astronomy Club',100,'2023-01-09','2023-01-10',1);


INSERT INTO `form` VALUES (1,'John Doe','Issue with Match','There was an issue during the football match.','2023-01-01','issue@example.com',0,0),(2,'Jane Smith','Feedback on Performance','The choir performance was excellent.','2023-01-03','feedback@example.com',0,0),(3,'David Nguyen','Complaint about Art Exhibition','The art exhibition lacked variety in artworks.','2023-01-07','complaint@example.com',0,0),(4,'Elena Tran','Praise for Stargazing Night','The stargazing night was a wonderful experience!','2023-01-09','praise@example.com',1,1),(5,'Frank Lin','Feedback on Robotics Competition','The robotics competition was challenging and well-organized.','2023-01-12','feedback@example.com',1,1);

INSERT INTO `registerclub` VALUES (1,'New Dance Club','We need a dance club to promote physical fitness.',10,1),(2,'Drama Club','Drama club to explore and enhance acting skills.',15,2),(3,'Debate Club','A platform to enhance public speaking and critical thinking.',12,3),(4,'Music Club','To bring together music enthusiasts and performers.',8,4),(5,'Photography Club','For students interested in learning and practicing photography.',20,5);

INSERT INTO `student` VALUES (1,'Alice Nguyen','alice@example.com','b8dc042d8cf7deefb0ec6a264c930b02','0912345678',0,'2000-01-01','2023-01-01','2023-01-02',1,1,'img1.jpg'),(2,'Bob Tran','bob@example.com','b8dc042d8cf7deefb0ec6a264c930b02','0912345679',1,'1999-05-15','2023-01-03','2023-01-04',1,0,'img2.jpg'),(3,'Charlie Pham','charlie@example.com','b8dc042d8cf7deefb0ec6a264c930b02','0912345680',1,'1998-08-20','2023-01-05','2023-01-06',1,0,'img3.jpg'),(4,'David Vu','david@example.com','b8dc042d8cf7deefb0ec6a264c930b02','0912345681',1,'2001-11-25','2023-01-07','2023-01-08',1,0,'img4.jpg'),(5,'Eve Le','eve@example.com','b8dc042d8cf7deefb0ec6a264c930b02','0912345682',0,'2002-02-28','2023-01-09','2023-01-10',1,0,'img5.jpg');

INSERT INTO `studentclub` VALUES (100,'2023-01-01','2023-01-02',1,1,1,1),(100,'2023-01-03','2023-01-04',1,2,2,2),(100,'2023-01-05','2023-01-06',1,3,3,3),(100,'2023-01-07','2023-01-08',1,4,4,4),(100,'2023-01-09','2023-01-10',1,5,5,5);

INSERT INTO `task` VALUES (1,'Organize Match','2023-01-01','2023-01-10',1,1,1,1),(2,'Prepare Performance','2023-01-03','2023-01-12',1,2,1,2),(3,'Set Up Exhibition','2023-01-05','2023-01-14',1,3,1,3),(4,'Build Robot','2023-01-07','2023-01-16',1,4,1,4),(5,'Arrange Stargazing','2023-01-09','2023-01-18',1,5,1,5);

-- Chèn dữ liệu mẫu vào bảng Role
INSERT INTO Role (NameRole, Status) 
VALUES 
('President', 1),
('Vice President', 1),
('Secretary', 1),
('Treasurer', 1),
('Member', 1);

-- Cập nhật bảng StudentClub để thiết lập IdRole
UPDATE StudentClub SET IdRole = 1 WHERE IdStudent = 1 AND IdClub = 1;
UPDATE StudentClub SET IdRole = 2 WHERE IdStudent = 2 AND IdClub = 2;
UPDATE StudentClub SET IdRole = 3 WHERE IdStudent = 3 AND IdClub = 3;
UPDATE StudentClub SET IdRole = 4 WHERE IdStudent = 4 AND IdClub = 4;
UPDATE StudentClub SET IdRole = 5 WHERE IdStudent = 5 AND IdClub = 5;

