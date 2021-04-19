CREATE DATABASE BlogMG;
USE BlogMG;

CREATE TABLE Users (   
Id   INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
firstName VARCHAR(100)  NULL,
lastName VARCHAR(100) NULL,
mobile BIGINT(100) NULL,
email VARCHAR(50) NULL,
passworded VARCHAR(16)  NULL,
registeres DATETIME NOT NULL,
intro TINYTEXT NULL,
proflie TEXT NULL
);

ALTER TABLE Users
ADD CONSTRAINT unique_mobile UNIQUE(mobile);

ALTER TABLE Users
ADD CONSTRAINT unique_email UNIQUE(email);

CREATE TABLE post(
Id   INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
authorId INT NOT NULL REFERENCES Users(Id),
title VARCHAR(100) NOT NULL,
metaTitle  VARCHAR(100) NOT NULL,
parentId INT NOT NULL,
sulg VARCHAR(128) NOT NULL,
summary TINYTEXT NULL,
created DATETIME NOT NULL,
updated DATETIME NOT NULL,
publish TINYINT(10) NOT NULL DEFAULT 0,
published  DATETIME NOT NULL,
content  TEXT  NOT NULL
);

ALTER TABLE post
ADD CONSTRAINT  fk_post_parentId 
  FOREIGN KEY (parentId)
  REFERENCES post(Id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
CREATE TABLE post_meta(
 Id  INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
 postId  INT NOT NULL REFERENCES post(Id),
 keyPost VARCHAR(100) NOT NULL,
 content  TEXT  NOT NULL
);

CREATE TABLE  post_comment(
Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
postId  INT NOT NULL REFERENCES post(Id),
parentId INT NOT NULL,
title VARCHAR(100) NOT NULL,
publish TINYINT(10) NOT NULL DEFAULT 0,
published  DATETIME NOT NULL,
content  TEXT  NOT NULL
);

ALTER TABLE  post_comment
ADD CONSTRAINT  fk_comment_parentId
  FOREIGN KEY (parentId)
  REFERENCES post_comment(Id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
CREATE TABLE category(
Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
parentId INT NOT NULL,
title VARCHAR(100) NOT NULL,
metaTitle  VARCHAR(100) NOT NULL,
sulg VARCHAR(128) NOT NULL,
content  TEXT  NOT NULL
);

ALTER TABLE category
ADD CONSTRAINT fk_category_parentId
   FOREIGN KEY (parentId)
   REFERENCES category(Id)
   ON DELETE NO ACTION
   ON UPDATE NO ACTION;
   
CREATE TABLE post_category(
categoryId  INT NOT NULL,
postId  INT NOT NULL,
FOREIGN KEY (postId)
REFERENCES post(Id),
FOREIGN KEY(categoryId )
REFERENCES category(Id)
);

CREATE TABLE tag(
Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
postId  INT NOT NULL REFERENCES post(Id),
title VARCHAR(100) NOT NULL,
metaTitle  VARCHAR(100) NOT NULL,
sulg VARCHAR(128) NOT NULL,
content  TEXT  NOT NULL
);

CREATE TABLE post_tag(
tagId INT NOT NULL,
postId  INT NOT NULL ,
FOREIGN KEY (postId)
REFERENCES post(Id),

FOREIGN KEY(tagId )
REFERENCES tag(Id)
);


      ---------------------------------- insert and update ------------------------------
        DELIMITER $$ 
	CREATE PROCEDURE upload_blog 
			(IN new_Id INT, IN new_metaTitle VARCHAR (100), IN new_authorId INT, IN new_title VARCHAR (100), IN new_summary TINYTEXT, IN new_create DATETIME, IN new_content TEXT)
	    BEGIN
		INSERT INTO post (Id, metaTitle, authorId, title, summary, created, content) 
		VALUES ('new_id', 'new_meta_title', 'new_athorID', 'new_title', 'new_summary', 'new_create', 'new_content'); 
          END $$ 
        DELIMITER;
        
        --------------a new category helps us has an overarching group ---------------------

	DELIMITER $$
	CREATE PROCEDURE newcategory
			(IN new_Id INT, IN new_metaTitle VARCHAR (100), IN new_title VARCHAR (100), IN new_slug VARCHAR (128), IN new_content TEXT)
	     BEGIN
		    INSERT INTO post (Id, metaTitle, title, slug, content)
		    VALUES ('new_id', 'new_meta_title', 'new_title', 'new_slug', 'new_content');
         END $$
     DELIMITER;
    
    -----------Upload a new the tag will help readers ---------------
    
	DELIMITER $$
	CREATE PROCEDURE newtag (IN new_Id INT, IN new_slug VARCHAR (128))
	  BEGIN
		INSERT INTO tag (Id, slug)
		VALUES ('new_ID','new_slug');
	  END $$ 
     DELIMITER;
     
       --------Create new account, reader’s id is automatically assigned------------
	
         DELIMITER $$
	CREATE PROCEDURE new_reader_account 
		INSERT INTO Users (Id, firstName, lastName, mobile, email)
		VALUES ('new_Id','new_firstname','new_lastname','new-mobile','new_email');
   DELIMITER;
   
-------new profile that matches --------
  
   DELIMITER $$
	CREATE PROCEDURE new_reader_personal
		INSERT INTO Users (firstname, lastname, mobile, email)
		VALUES('new_id','new_firstName','new_lastName','new_mobile','new_email','new_profile');
  
    DELIMITER;
    
    ---------a new comment under a blog-------
    
	DELIMITER $$
	  CREATE PROCEDURE add_comment
		 INSERT INTO post_comment ( Id, title, created, publish, content)
		 VALUES ('new_Id','new_title','new_create','new_publish','new_content');
         DELIMITER;
         
         -----------Update the comment of someone:----------
         DELIMITER $$
		CREATE PROCEDURE update_comment 
			(IN post_comment TEXT , IN Id   INT)
		BEGIN
			UPDATE comment SET upvote = upvote + 1
			WHERE Id = post_comment. Id;
		END $$
              DELIMITER;
              
	-------------DELETE-----------
    ------Delete a post with all of its comments:
          DELIMITER $$
        CREATE PROCEDURE del_post (IN Id INT)
	 BEGIN
		DELETE FROM post WHERE post.Id=Id;
		DELETE FROM post_meta WHERE post_meta. postId=Id;
		DELETE FROM post_comment WHERE post_comment.postId=Id;
		DELETE FROM post_category WHERE post_category.postId = Id;
	DELETE FROM post_tag WHERE post_tag.postId = Id;
    END $$
    DELIMITER;
    
    ----------------Delete a comment:---------
	DELIMITER $$
	CREATE PROCEDURE del_comment (IN comment_id INT)
	    BEGIN
        DELETE FROM post_comment
	  WHERE Id= post_comment.Id;
        END $$
       DELIMITER;

		----------------------------
                  DELIMITER $$
             CREATE PROCEDURE del_user (IN id INT)
	     BEGIN
		 DELETE FROM Users WHERE Users.Id=Id;
		 DELETE FROM post_comment WHERE post_comment.Id = Id;
           END $$
     
         

        


       
       

    
    

