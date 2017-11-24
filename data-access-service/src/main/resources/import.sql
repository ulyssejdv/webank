
----Data table Transaction Type

INSERT INTO transactiontype(id, transaction_type_name) VALUES (1,'Transaction');
INSERT INTO transactiontype(id, transaction_type_name) VALUES (2,'Virement');

INSERT INTO transactiontype(id, transaction_type_name) VALUES (3,'Chèque');


--Data table customer

INSERT INTO customers(id,address, birthday, email, firstname, lastname, phonenumber) VALUES (1, 'Choisy', '30/12/2000', 'tata@gmail.com', 'Aaron', 'Lellouche', '0125487987');

INSERT INTO customers(id, address, birthday, email, firstname, lastname, phonenumber) VALUES (2, 'M-A', '03/08/1283', 'ruben@gmail.com', 'ruben', 'edery', '0125487987');

INSERT INTO customers(id, address, birthday, email, firstname, lastname, phonenumber) VALUES (3, 'M-A', '03/08/1283', 'edery@gmail.com', 'rudedeben', 'edery', '0125487987');




--Data table balance

INSERT INTO public.balance(id, balance, last_date_balance) VALUES (1, 300, '2014/05/12');
--Data table account
INSERT INTO account(id, account_number, date, type, balance_id, customer_id) VALUES (1, 1, '2014/05/12', 'courant', 1, 1);

INSERT INTO account(id, account_number, date, type, customer_id) VALUES (2,2, '2014/05/12', 'courant', 2);
--Data table transaction
INSERT INTO transaction(amount, date_transac, to_account_id,from_account_id, type_transac) VALUES (123,null, 1, 2, 1);


INSERT INTO transaction(amount, date_transac, to_account_id,from_account_id, type_transac) VALUES (123,null, 1, 2, 2);


INSERT INTO transaction(amount, date_transac, to_account_id,from_account_id, type_transac) VALUES (123,null, 1, 2, 3);
