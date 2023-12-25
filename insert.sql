SET foreign_key_checks=1;

USE nexusdb;

INSERT INTO mst_user
(user_name, password, family_name, first_name, family_name_kana, first_name_kana, gender)
VALUES ('yamada@gmail.com', '111111', '山田', '太郎', 'やまだ', 'たろう', 0);

INSERT INTO mst_category (category_name,category_description)VALUES
('Hobby', '趣味、雑貨のカテゴリーです'),
('Food', '食べ物のカテゴリーです'),
('Sweets', 'スイーツのカテゴリーです'),
('Drink', '飲み物のカテゴリーです');

INSERT INTO mst_product(product_name,product_name_kana,product_description,category_id,price,image_full_path,release_date,release_company)VALUES 
('クリスマスツリー','くりすますつりー','クリスマスツリーをモチーフにした置物',1,1550,'/img/xmastree.png','2023/11/01','European general store'),
('スノードーム','すのーどーむ','ツリーに雪が降る風景が作れる',1,750,'/img/chrismas_snow_globe.png','2023/11/01','European general store'),
('サンタクロースマスク','さんたくろーすますく','サンタクロースに変装できるマスク',1,450,'/img/chrismas_fake_mustache.png','2023/11/01','ZAKKAYA'),
('フライドチキン','ふらいどちきん','骨ごと揚げたチキン',2,3500,'/img/chicken.png','2023/12/05','ケータリング東京'),
('ピザ','ぴざ','シーフードピザ',2,2200,'/img/pizza.png','2023/12/05','ケータリング東京'),
('フライドポテト','ふらいどぽてと','定番のフライドポテト',2,650,'/img/frenchfries.png','2023/12/05','ケータリング東京'),
('クリスマスケーキ','くりすますけーき','ストロベリーショートケーキ',3,2500,'/img/christmas_cake.png','2023/12/20','Sweets Factory'),
('シュトーレン','しゅとーれん','バターが入った生地にドライフルーツやナッツなどが練り込まれたパン菓子',3,850,'/img/stollen.png','2023/12/15','Sweets Factory'),
('ジンジャークッキー','じんじゃーくっきー','しょうがを練りこんだヨーロッパで伝統的なクッキー',3,650,'/img/cookie.png','2023/12/15','Sweets Factory'),
('シャンパン','しゃんぱん','フランスのシャンパーニュ地方特産のスパークリングワイン',4,4200,'/img/champagne.png','2023/12/01','ワインショップ Drue'),
('ホットワイン','ほっとわいん','ワインと香辛料などを温めて作るホット・カクテルの一種',4,1400,'/img/hotwine.png','2023/12/01','ワインショップ Drue');
