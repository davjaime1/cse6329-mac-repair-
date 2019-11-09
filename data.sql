
USE `database`;
INSERT INTO users VALUE ("user1","1001526202","SM","SM","password","U","1121 UTA","Arlington","TX","76010","1001526202","sm@uta.edu");
INSERT INTO users VALUE ("usr1","1001526202","SM","SM","password","U","1121 UTA","Arlington","TX","76010","1001526202","sm@uta.edu");
INSERT INTO users VALUE ("rep1","1001526202","SM","SM","password","R","1121 UTA","Arlington","TX","76010","1001526202","sm@uta.edu");
INSERT INTO users VALUE ("rep2","1001526202","SM","SM","password","R","1121 UTA","Arlington","TX","76010","1001526202","sm@uta.edu");
INSERT INTO users VALUE ("rep3","1001526202","SM","SM","password","R","1121 UTA","Arlington","TX","76010","1001526202","sm@uta.edu");
INSERT INTO users VALUE ("rep4","1001526202","SM","SM","password","R","1121 UTA","Arlington","TX","76010","1001526202","sm@uta.edu");
INSERT INTO users VALUE ("rep","1001526202","SM","SM","password","R","1121 UTA","Arlington","TX","76010","1001526202","sm@uta.edu");
INSERT INTO users VALUE ("rep5","1001526202","SM","SM","password","R","1121 UTA","Arlington","TX","76010","1001526202","sm@uta.edu");



INSERT INTO mar VALUE ("1",curdate(),"BMC","BMC1","des","Ma","usr1","rep2",curdate(),"1D"); 
INSERT INTO mar VALUE ("2",curdate(),"BMC","BMC1","des","Ma","usr1","rep2",curdate(),"1D"); 
INSERT INTO mar VALUE ("3",curdate(),"BMC","BMC1","des","Ma","usr1","rep2",curdate(),"1D"); 
INSERT INTO mar VALUE ("4",curdate(),"BMC","BMC1","des","Ma","usr1","rep2",curdate(),"1D"); 
INSERT INTO mar VALUE ("5",curdate(),"BMC","BMC1","des","Ma","usr1","rep2",curdate(),"1D"); 

INSERT INTO mar VALUE ("6",curdate(),"BMC","BMC1","des","Ma","usr1","rep3",curdate(),"1D"); 
INSERT INTO mar VALUE ("7",curdate(),"BMC","BMC1","des","Ma","usr1","rep3",curdate(),"1D"); 
INSERT INTO mar VALUE ("8",curdate(),"BMC","BMC1","des","Ma","usr1","rep3",curdate(),"1D"); 
INSERT INTO mar VALUE ("9",curdate(),"BMC","BMC1","des","Ma","usr1","rep3",CURDATE() + INTERVAL 1 DAY,"1D"); 
INSERT INTO mar VALUE ("10",curdate(),"BMC","BMC1","des","Ma","usr1","rep3",CURDATE() + INTERVAL 1 DAY,"1D"); 
INSERT INTO mar VALUE ("11",curdate(),"BMC","BMC1","des","Ma","usr1","rep3",CURDATE() + INTERVAL 1 DAY,"1D"); 
INSERT INTO mar VALUE ("12",curdate(),"BMC","BMC1","des","Ma","usr1","rep3",CURDATE() + INTERVAL 2 DAY,"1D"); 
INSERT INTO mar VALUE ("13",curdate(),"BMC","BMC1","des","Ma","usr1","rep3",CURDATE() + INTERVAL 2 DAY,"1D"); 
INSERT INTO mar VALUE ("14",curdate(),"BMC","BMC1","des","Ma","usr1","rep3",CURDATE() + INTERVAL 2 DAY,"1D"); 
INSERT INTO mar VALUE ("15",curdate(),"BMC","BMC1","des","Ma","usr1","rep3",CURDATE() + INTERVAL 2 DAY,"1D"); 


INSERT INTO mar VALUE ("21",CURDATE() - INTERVAL 1 DAY,"BMC","BMC1","des","Ma","usr1","rep4",CURDATE() - INTERVAL 1 DAY,"1D"); 
INSERT INTO mar VALUE ("22",CURDATE() - INTERVAL 1 DAY,"BMC","BMC1","des","Ma","usr1","rep4",CURDATE() - INTERVAL 1 DAY,"1D"); 
INSERT INTO mar VALUE ("23",CURDATE() - INTERVAL 1 DAY,"BMC","BMC1","des","Ma","usr1","rep4",CURDATE() - INTERVAL 1 DAY,"1D"); 
INSERT INTO mar VALUE ("24",CURDATE() - INTERVAL 1 DAY,"BMC","BMC1","des","Ma","usr1","rep4",CURDATE() - INTERVAL 1 DAY,"1D"); 
INSERT INTO mar VALUE ("25",CURDATE() - INTERVAL 1 DAY,"BMC","BMC1","des","Ma","usr1","rep4",CURDATE() - INTERVAL 1 DAY,"1D");

INSERT INTO mar VALUE ("31",curdate(),"BMC","BMC1","des","Ma","usr1","rep5",curdate(),"1D"); 
INSERT INTO mar VALUE ("32",curdate(),"BMC","BMC1","des","Ma","usr1","rep5",curdate(),"1D"); 
INSERT INTO mar VALUE ("33",curdate(),"BMC","BMC1","des","Ma","usr1","rep5",curdate(),"1D"); 
INSERT INTO mar VALUE ("34",curdate(),"BMC","BMC1","des","Ma","usr1","rep5",CURDATE(),"1D"); 
INSERT INTO mar VALUE ("35",curdate(),"BMC","BMC1","des","Ma","usr1","rep5",CURDATE(),"1D"); 
INSERT INTO mar VALUE ("36",curdate(),"BMC","BMC1","des","Ma","usr1","rep5",CURDATE() + INTERVAL 1 DAY,"1D"); 
INSERT INTO mar VALUE ("37",curdate(),"BMC","BMC1","des","Ma","usr1","rep5",CURDATE() + INTERVAL 1 DAY,"1D"); 
INSERT INTO mar VALUE ("38",curdate(),"BMC","BMC1","des","Ma","usr1","rep5",CURDATE() + INTERVAL 1 DAY,"1D"); 
INSERT INTO mar VALUE ("39",curdate(),"BMC","BMC1","des","Ma","usr1","rep5",CURDATE() + INTERVAL 2 DAY,"1D"); 
INSERT INTO mar VALUE ("40",curdate(),"BMC","BMC1","des","Ma","usr1","rep5",CURDATE() + INTERVAL 2 DAY,"1D"); 

INSERT INTO mar VALUE ("50","2019-10-24","BMC","BMC1","des","Ma","usr1","rep","2019-10-25","1D");
INSERT INTO mar VALUE ("51","2019-10-24","BMC","BMC1","des","Ma","usr1","rep","2019-10-25","1D");
INSERT INTO repairschedule VALUE ("rep","50","2019-10-24");
INSERT INTO repairschedule VALUE ("rep","51","2019-10-24");
INSERT INTO facilityreservation VALUE("50", "BMC1", "BMC", "I", "rep", "2019-10-25", "2019-10-25 06:29:59", "2019-10-25 06:00:00");
INSERT INTO facilityreservation VALUE("51", "BMC1", "BMC", "I", "rep", "2019-10-25", "2019-10-25 12:59:59", "2019-10-25 12:30:00");