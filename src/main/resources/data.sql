INSERT INTO heroes (publicname, real_name, power, power_level) VALUES
('super dupond','jean dupond', 'biscottos', 50),
('baguettor','pierre pierre', 'pain', 75),
('chatounette','julia ford', 'fastorun', 70),
('mad dog','jules ford', 'megamoche', 99),
('super tutu','toto', 'blaguonulle', 25);

INSERT INTO categories (name) VALUES
('helmet'), ('crown'), ('armor'), ('clothes'), ('weapon'),('lighter'), ('purse'),('potion'), ('spell'), ('food');

INSERT INTO rpgitems (name, category_id, price, effect) VALUES
('conic helmet', (SELECT id FROM categories WHERE name = 'helmet'), 200.0, 'A+10'),
('great crown of apologia', (SELECT id FROM categories WHERE name = 'crown'), 200.0, 'A+20'),
('leather armor', (SELECT id FROM categories WHERE name = 'armor'), 100.0, 'A+10'),
('hauberk', (SELECT id FROM categories WHERE name = 'armor'), 500.0, 'A+40'),
('tuxedo', (SELECT id FROM categories WHERE name = 'clothes'), 600.0, 'L+1'),
('unicorn cosplay', (SELECT id FROM categories WHERE name = 'clothes'), 199.99, 'L+10'),
('dagger', (SELECT id FROM categories WHERE name = 'weapon'), 100.0, 'S+5'),
('long sword', (SELECT id FROM categories WHERE name = 'weapon'), 300.0, 'S+20'),
('torch', (SELECT id FROM categories WHERE name = 'lighter'), 2.5, ''),
('leather purse', (SELECT id FROM categories WHERE name = 'purse'), 10.31, ''),
('protection potion', (SELECT id FROM categories WHERE name = 'potion'), 100.0, 'a+10'),
('fireball', (SELECT id FROM categories WHERE name = 'spell'), 1000.0, ''),
('ice cone', (SELECT id FROM categories WHERE name = 'spell'), 1000.0, ''),
('apple', (SELECT id FROM categories WHERE name = 'food'), 1.1, 'l+1'),
('wine', (SELECT id FROM categories WHERE name = 'food'), 9.75, 'l+2');

INSERT INTO streets (name) VALUES
('street1'), ('street2');

INSERT INTO shops (name, street_id) VALUES
('shop1', (SELECT id FROM streets WHERE name = 'street1')),
('shop2', (SELECT id FROM streets WHERE name = 'street2'));
