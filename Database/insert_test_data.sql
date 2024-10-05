-- FELTÖLTÉS ÉRVÉNYES TESZT ADATOKKAL

CALL INSERT_DURABLE_PRODUCT('AA00000000','Shocky', 'Sumsang', 'coffee machine', 23500, 27, 5, 'pieces', 2, 6, 2.5);
CALL INSERT_DURABLE_PRODUCT('AA00000001','Disgusto', 'Philice', 'coffee machine', 29000, 27, 5, 'pieces', 2, 6, 3);
CALL INSERT_DURABLE_PRODUCT('AA00000002','Burny', 'Sumsang', 'oven', 70000, 27, 4, 'pieces', 1, 24, 10);
CALL INSERT_DURABLE_PRODUCT('AA00000003','Smellsbad', 'Bish', 'oven', 62000, 27, 4, 'pieces', 1, 24, 9.3);
CALL INSERT_DURABLE_PRODUCT('AA00000004','Pixy', 'Sumsang', 'tv', 219999, 27, 10, 'pieces', 2, 12, 4.5);
CALL INSERT_DURABLE_PRODUCT('AA00000005','Lowdef', 'LGbt', 'tv', 149000, 27, 8, 'pieces', 1, 12, 5.6);
CALL INSERT_DURABLE_PRODUCT('AA00000006','Breaks2much', 'Dull', 'dishwasher', 55000, 27, 8, 'pieces', 3, 30, 8.2);
CALL INSERT_DURABLE_PRODUCT('AA00000007','Leaky', 'Bish', 'dishwasher', 74500, 27, 8, 'pieces', 3, 30, 7.7);
CALL INSERT_DURABLE_PRODUCT('AA00000008','HotPlate', 'Cantdy', 'microwave oven', 40000, 27, 15, 'pieces', 5, 12, 5.1);
CALL INSERT_DURABLE_PRODUCT('AA00000009','Short-circuit', 'Sumsang', 'microwave oven', 56499, 27, 8, 'pieces', 3, 12, 3.9);

CALL insert_perishable_product('AA00000000','BitterBarfy', 'BarfyBrew', 'beer', 550, 27, 48, 'cans', 12,'2024-12-31', current_date());
CALL insert_perishable_product('AA00000001','DarkBarfy', 'BarfyBrew', 'beer', 550, 27, 24, 'cans', 6,'2024-12-31', current_date());
CALL insert_perishable_product('AA00000002','RottenTomato', 'Guliver', 'ketchup', 1200, 5, 10, 'bottle', 3,'2025-12-31', current_date());
CALL insert_perishable_product('AA00000003','Way2sweet', 'Chinatown', 'ketchup', 699, 5, 15, 'bottle', 5,'2025-12-31', current_date());
CALL insert_perishable_product('AA00000004','GoSour', 'Cowtits', 'milk', 700, 18, 48, 'tetrapak', 12,'2024-10-31', current_date());
CALL insert_perishable_product('AA00000005','99%water', 'Moosolini', 'milk', 499, 18, 48, 'tetrapak', 12,'2024-10-31', current_date());
CALL insert_perishable_product('AA00000006','JustMouse', 'OrbanHunting', 'meat', 2200, 0, 2, 'kg', 0,'2024-10-12', current_date());
CALL insert_perishable_product('AA00000007','JustPigeon', 'OrbanHunting', 'meat', 4000, 0, 3, 'kg', 0,'2024-10-12', current_date());
CALL insert_perishable_product('AA00000008','Shinysprouts', 'ShinyBelgium', 'brussels sprout', 600, 99, 5, 'kg', 1,'2024-10-20', current_date());
CALL insert_perishable_product('AA00000009','Kingsprouts', 'BrusselOriginal', 'brussels sprout', 800, 99, 5, 'kg', 1,'2024-10-20', current_date());

-- STATE_SALES_TAX -BE NEM KELL KÜLÖN INSERTELNI, AUTOMATIKUSAN LÉTRJÖNNEK A RECORDOK A TÁROLT ELJÁRÁS-OK ÉS A TRIGGER-EK MIATT

-- TESZT
SELECT * FROM durable_product;
SELECT * FROM perishable_product;
SELECT * FROM state_sales_tax;