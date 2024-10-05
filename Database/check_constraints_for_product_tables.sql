-- MANUÁLISAN MEGÍRT CHECK CONSTRAINT-EK
-- ORACLE ADATBÁZIS HASZNÁLATÁNÁL TANULTAM, HA EGY MEZŐ ÉRTÉKÉT EGYEDI SZABÁLYOK ALAPJÁN KELL VÉDENI
-- TRIGGER-EL ELENTÉTBEN, NEM KELL BEFORE INSERT-RE ÉS UPDATE-RE KÉTSZER MEGÍRNI UGYANAZT ÉS NEM KELL EGYEDI HIBAÜZENETEKET IROGATNI

-- MYSQL-BEN 8.0.22 -TŐL HASZNÁLHATÓ JÓL, HA JÓL ÉRTESÜLTEM, EZ A LEGELEGÁNSABB MEGOLDÁS SZERINTEM
SELECT VERSION();

-- A TÉNYLEGES CONSTRAINT-EK
ALTER TABLE DURABLE_PRODUCT
ADD CONSTRAINT check_article_number_dp CHECK (article_number REGEXP '^[A-Z]{2}[0-9]{8}$'),
ADD CONSTRAINT check_netto_price_dp CHECK (netto_price >= 0),
ADD CONSTRAINT check_quantity_dp CHECK (quantity >= 0),
ADD CONSTRAINT check_gross_weight CHECK (gross_weight >= 0);

ALTER TABLE PERISHABLE_PRODUCT
ADD CONSTRAINT check_article_number_pp CHECK (article_number REGEXP '^[A-Z]{2}[0-9]{8}$'),
ADD CONSTRAINT check_netto_price_pp CHECK (netto_price >= 0),
ADD CONSTRAINT check_quantity_pp CHECK (quantity >= 0);

ALTER TABLE STATE_SALES_TAX
ADD CONSTRAINT check_tax_key_sst CHECK (tax_key >= 0 AND tax_key < 100);

-- A STATE_SALES_TAX TÁBLÁRA TRIGGEREKET HOZOK LÉTRE, OTT UGYANIS A KONKRÉT ÉRTÉKEKET A PRIMARY KEY ALAPJÁN KELL LÉTREHOZNI, ÍGY A LEGEGYSZERŰBB TRIGGEREK SEGÍTSÉGÉVEL EGYBŐL FELÜLÍRNI A KÉT KÉRDÉSES MEZŐT

-- TESZT:

-- A TESZTELÉS ELŐTT EGY PRÓBA ÉRTÉKET HOZZÁ KELL ADNI A STATE_SALES_TAX TÁBLÁHOZ, HOGY A FOREIGN KEY CONSTRAINT NE SÉRÜLJÖN
-- A TESZTELÉS VÉGÉN TÖRÖLJÜK A STATE_SALES_TAX ADATAIT, A TÁBLÁK FELTÖLTÉSE MÁSIK SCRIPTBŐL TÖRTÉNIK
INSERT INTO state_sales_tax (
	tax_key,
    description,
    multiplier)
    VALUES(
		5,
		'5%',
		1.05);
        
DELETE FROM state_sales_tax WHERE tax_key = 5;

-- EZEK A DURABLE_PRODUCT TÁBLÁRA VONATKOZÓ INSERTEK NEM MŰKÖDHETNEK HA A CONSTRAINT-EK MEGFELELŐEN VÉDIK A MEZŐKET:

-- EZ MEGSÉRTI AZ ARTICLE_NUMBER OSZLOP FORMAI ELŐÍRÁSÁT:
INSERT INTO durable_product (
	article_number,
    name,
    brand,
    family,
    netto_price,
    tax_id,
    quantity,
    amount_units,
    critical_quantity,
    waranty_period,
    gross_weight)
    VALUES(
		'ROSSZID1',
        'Teszt Termék',
        'Teszt Márka',
        'Teszt Típus',
        10000,
        5,
        1,
        'db',
        5,
        24,
        10);
        
-- EZ MEGSÉRTI A NETTO_PRICE OSZLOP ELŐÍRÁSÁT MISZERINT NEM LEHET NEGATÍV:
INSERT INTO durable_product (
	article_number,
    name,
    brand,
    family,
    netto_price,
    tax_id,
    quantity,
    amount_units,
    critical_quantity,
    waranty_period,
    gross_weight)
    VALUES(
		'AA01234567',
        'Teszt Termék',
        'Teszt Márka',
        'Teszt Típus',
        -10000,
        5,
        1,
        'db',
        5,
        24,
        10);
        
-- EZ MEGSÉRTI A QUANTITY OSZLOP ELŐÍRÁSÁT MISZERINT NEM LEHET NEGATÍV:
INSERT INTO durable_product (
	article_number,
    name,
    brand,
    family,
    netto_price,
    tax_id,
    quantity,
    amount_units,
    critical_quantity,
    waranty_period,
    gross_weight)
    VALUES(
		'AA01234567',
        'Teszt Termék',
        'Teszt Márka',
        'Teszt Típus',
        10000,
        5,
        -1,
        'db',
        5,
        24,
        10);
        
-- EZ MEGSÉRTI A GROSS_WEIGHT OSZLOP ELŐÍRÁSÁT MISZERINT NEM LEHET NEGATÍV:
INSERT INTO durable_product (
	article_number,
    name,
    brand,
    family,
    netto_price,
    tax_id,
    quantity,
    amount_units,
    critical_quantity,
    waranty_period,
    gross_weight)
    VALUES(
		'AA01234567',
        'Teszt Termék',
        'Teszt Márka',
        'Teszt Típus',
        10000,
        5,
        1,
        'db',
        5,
        24,
        -10);

-- EZEK A PERISHABLE_PRODUCT TÁBLÁRA VONATKOZÓ INSERTEK NEM MŰKÖDHETNEK HA A CONSTRAINT-EK MEGFELELŐEN VÉDIK A MEZŐKET:

-- EZ MEGSÉRTI AZ ARTICLE_NUMBER OSZLOP FORMAI ELŐÍRÁSÁT:
INSERT INTO perishable_product (
	article_number,
    name,
    brand,
    family,
    netto_price,
    tax_id,
    quantity,
    amount_units,
    critical_quantity,
    expiration_date,
    production_date)
    VALUES(
		'ROSSZID1',
        'Teszt Termék',
        'Teszt Márka',
        'Teszt Típus',
        10000,
        5,
        1,
        'db',
        5,
        current_date(),
        current_date());

-- EZ MEGSÉRTI A NETTO_PRICE OSZLOP ELŐÍRÁSÁT MISZERINT NEM LEHET NEGATÍV:
INSERT INTO perishable_product (
	article_number,
    name,
    brand,
    family,
    netto_price,
    tax_id,
    quantity,
    amount_units,
    critical_quantity,
    expiration_date,
    production_date)
    VALUES(
		'AA01234567',
        'Teszt Termék',
        'Teszt Márka',
        'Teszt Típus',
        -10000,
        5,
        1,
        'db',
        5,
        current_date(),
        current_date());

-- EZ MEGSÉRTI A QUANTITY OSZLOP ELŐÍRÁSÁT MISZERINT NEM LEHET NEGATÍV:
INSERT INTO perishable_product (
	article_number,
    name,
    brand,
    family,
    netto_price,
    tax_id,
    quantity,
    amount_units,
    critical_quantity,
    expiration_date,
    production_date)
    VALUES(
		'AA01234567',
        'Teszt Termék',
        'Teszt Márka',
        'Teszt Típus',
        10000,
        5,
        -1,
        'db',
        5,
        current_date(),
        current_date());
        
-- EZ MEGSÉRTI A TAX_KEY OSZLOP ELŐÍRÁSÁT MISZERINT NEM LEHET NEGATÍV VAGY 99-NÉL MAGASABB ÉRTÉK
INSERT INTO state_sales_tax (
	tax_key,
    description,
    multiplier)
    VALUES(
		-1,
		'-1%',
		0.99);

-- TESZT VÉGE, HA A FENTI KÓOK A MEGFELELŐ CHECK CONSTRAINT VIOLATION ERROR-T DOBJÁK, AKKOR A TESZT SIKERES
		