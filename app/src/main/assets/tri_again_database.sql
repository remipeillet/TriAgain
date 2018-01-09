DROP TABLE IF EXISTS dechets;
CREATE TABLE dechets (id_dechet INTEGER primary key,nomFR TEXT,nomEN TEXT,nomImage TEXT,type TEXT);
INSERT INTO dechets VALUES(0,"Barquette confiture","Jam tray","menager_barquette_plastique_confiture","menager");
INSERT INTO dechets VALUES(1,"Sac plastique","Bag","menager_sacplastique","menager");
INSERT INTO dechets VALUES(2,"Journaux","News papers","recyclable_journaux","recyclable");
INSERT INTO dechets VALUES(3,"Gourde compote","stewed gourd","menager_compote","menager");
INSERT INTO dechets VALUES(4,"Couche bébé","baby diaper","menager_couche","menager");
INSERT INTO dechets VALUES(5,"Sachet de chips","bag of chips","menager_sachetchips","menager");
INSERT INTO dechets VALUES(6,"Boite de céréales","Cereal box","recyclable_boitecereale","recyclable");
INSERT INTO dechets VALUES(7,"Bouteille d'eau","bottle of water","recyclable_bouteilleeau","recyclable");
INSERT INTO dechets VALUES(8,"Canette de Soda","can of soda","recyclable_canettesoda","recyclable");
INSERT INTO dechets VALUES(9,"Conserve","canned food","recyclable_conserve","recyclable");


