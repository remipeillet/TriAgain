DROP TABLE IF EXISTS dechets;
CREATE TABLE dechets (id_dechet INTEGER primary key,nomFR TEXT,nomEN TEXT,nomImage TEXT,type TEXT);
INSERT INTO dechets VALUES(0,"Barquette confiture","Jam tray","menager_barquette_plastique_confiture","menager");
INSERT INTO dechets VALUES(1,"Sac plastique","Bag","menager_sacplastique","menager");
INSERT INTO dechets VALUES(2,"Journaux","News papers","recyclable_journaux","recyclable");
