CREATE TABLE auth_rbac.inner_email
(
  mail_id      INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  mail_from    INT             NOT NULL,
  mail_to      INT             NOT NULL,
  mail_title   VARCHAR(100)    NOT NULL,
  mail_content VARCHAR(1000)   NOT NULL,
  mail_extra   VARCHAR(100)
);
CREATE UNIQUE INDEX inner_email_mail_id_uindex ON auth_rbac.inner_email (mail_id);
CREATE INDEX inner_email_to_index ON auth_rbac.inner_email (mail_to);
CREATE INDEX inner_email_from_index ON auth_rbac.inner_email (mail_from);
ALTER TABLE auth_rbac.inner_email COMMENT = '内部邮件表';