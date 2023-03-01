CREATE SEQUENCE hibernate_sequence START WITH 1 INCREMENT BY 1;
CREATE TABLE tb_users (
    user_id BIGINT NOT NULL,
    username VARCHAR(100) NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    account_number VARCHAR(50),
    CONSTRAINT pk_tb_users PRIMARY KEY (user_id)
);
ALTER TABLE tb_users ADD CONSTRAINT uc_tb_users_account_number UNIQUE (account_number);
ALTER TABLE tb_users ADD CONSTRAINT uc_tb_users_user UNIQUE (user_id);
ALTER TABLE tb_users ADD CONSTRAINT uc_tb_users_username UNIQUE (username);
CREATE INDEX idx_userentity_user_id ON tb_users(user_id, username, account_number);

CREATE TABLE tb_transaction_type (
  transaction_type_id BIGINT NOT NULL,
   transaction_code VARCHAR(50) NOT NULL,
   transaction_name VARCHAR(255) NOT NULL,
   CONSTRAINT pk_tb_transaction_type PRIMARY KEY (transaction_type_id)
);

ALTER TABLE tb_transaction_type ADD CONSTRAINT uc_tb_transaction_type_transaction_code UNIQUE (transaction_code);
ALTER TABLE tb_transaction_type ADD CONSTRAINT uc_tb_transaction_type_transaction_type UNIQUE (transaction_type_id);
CREATE INDEX idx_transactiontype ON tb_transaction_type(transaction_type_id, transaction_code, transaction_name);

CREATE TABLE tb_transaction_history (
  transaction_history_id BIGINT NOT NULL,
   activity_date TIMESTAMP NOT NULL,
   amount BIGINT NOT NULL,
   user_id BIGINT,
   transaction_type_id BIGINT,
   CONSTRAINT pk_tb_transaction_history PRIMARY KEY (transaction_history_id)
);
ALTER TABLE tb_transaction_history ADD CONSTRAINT uc_transactionhistory UNIQUE (transaction_history_id);
ALTER TABLE tb_transaction_history ADD CONSTRAINT FK_TB_TRANSACTION_HISTORY_ON_TRANSACTION_TYPE FOREIGN KEY (transaction_type_id) REFERENCES tb_transaction_type (transaction_type_id);
ALTER TABLE tb_transaction_history ADD CONSTRAINT FK_TB_TRANSACTION_HISTORY_ON_USER FOREIGN KEY (user_id) REFERENCES tb_users (user_id);

INSERT INTO tb_users (user_id, username, password_hash, account_number)
VALUES
  (1, 'user 1', '$2a$10$uVIIvVx3B6BvViBT5kyJ1uH3d.iGyom52AqqMuNm4oTcWA1mcKbty', '1234567890'),
  (2, 'user 2', '$2a$10$83lqTeUR9gph734/u89OvudV77Sd9EukKDE5mL6FKL6MjF0blciaO', '0987654321');

INSERT INTO tb_transaction_type (transaction_type_id, transaction_code, transaction_name)
VALUES
  (3, '0001DEBIT', 'DEBIT ACCOUNT'),
  (4, '0002KREDIT', 'KREDIT ACCOUNT');

INSERT INTO tb_transaction_history (transaction_history_id, activity_date, amount, user_id, transaction_type_id)
VALUES
  (NEXTVAL('hibernate_sequence'), NOW(), 500000, 1, 3),
  (NEXTVAL('hibernate_sequence'), NOW(), 400000, 1, 3),
  (NEXTVAL('hibernate_sequence'), NOW(), 100000, 1, 4),
  (NEXTVAL('hibernate_sequence'), NOW(), 200000, 1, 4);