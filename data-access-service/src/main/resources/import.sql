﻿--Data table customer
INSERT INTO public.customers(id, address, birthday, email, firstname, lastname, phonenumber) VALUES (1, 'Paris', '24/06/1965', 'test@gmail.com', 'aaron', 'lellouche', '0603181108');
INSERT INTO public.customers(id, address, birthday, email, firstname, lastname, phonenumber) VALUES (2, 'Choisy', '30/12/2000', 'tata@gmail.com', 'toto', 'tata', '0125487987');
--Data table account
INSERT INTO public.account(id, account_number, creation_date, type, customer_id) VALUES (1, 123, '2014/05/12', 'courant', 1);
--Data table balance
INSERT INTO public.balance(id, balance, date, account_id) VALUES (1, 300, '2017/12/25', 1);