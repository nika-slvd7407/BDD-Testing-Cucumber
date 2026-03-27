INSERT INTO users (id, username, password, first_name, last_name, zip)
VALUES (1, 'standard_user', 'secret_sauce', 'nika', 'ts', '1000'),
       (2, 'problem_user', 'secret_sauce', 'nika', 'ts', '200020002'),
       (3, 'performance_glitch_user', 'secret_sauce', 'nika', 'ts', '30003');

INSERT INTO orders (user_id, product_name)
VALUES (1, 'Sauce Labs Backpack'),
       (1, 'Sauce Labs Bike Light'),

       (2, 'Sauce Labs Bolt T-Shirt'),
       (2, 'Sauce Labs Fleece Jacket'),

       (3, 'Sauce Labs Onesie'),
       (3, 'Test.allTheThings() T-Shirt (Red)');