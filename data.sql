
USE `database`;
INSERT INTO users VALUE ("user1","1001526202","SM","SM","password","U","1121 UTA","Arlington","TX","76010","1001526202","sm@uta.edu");
INSERT INTO users VALUE ("usr1","1001526202","SM","SM","password","U","1121 UTA","Arlington","TX","76010","1001526202","sm@uta.edu");
INSERT INTO users VALUE ("rep1","1001526202","SM","SM","password","R","1121 UTA","Arlington","TX","76010","1001526202","sm@uta.edu");
INSERT INTO users VALUE ("rep2","1001526202","SM","SM","password","R","1121 UTA","Arlington","TX","76010","1001526202","sm@uta.edu");
INSERT INTO users VALUE ("rep3","1001526202","SM","SM","password","R","1121 UTA","Arlington","TX","76010","1001526202","sm@uta.edu");
INSERT INTO users VALUE ("rep4","1001526202","SM","SM","password","R","1121 UTA","Arlington","TX","76010","1001526202","sm@uta.edu");

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
INSERT INTO mar VALUE ("11",curdate(),"BMC","BMC1","des","Ma","usr1","rep3",CURDATE() + INTERVAL 2 DAY,"1D"); 
INSERT INTO mar VALUE ("12",curdate(),"BMC","BMC1","des","Ma","usr1","rep3",CURDATE() + INTERVAL 2 DAY,"1D"); 
INSERT INTO mar VALUE ("21",CURDATE() - INTERVAL 1 DAY,"BMC","BMC1","des","Ma","usr1","rep4",CURDATE() - INTERVAL 1 DAY,"1D"); 
INSERT INTO mar VALUE ("22",CURDATE() - INTERVAL 1 DAY,"BMC","BMC1","des","Ma","usr1","rep4",CURDATE() - INTERVAL 1 DAY,"1D"); 
INSERT INTO mar VALUE ("23",CURDATE() - INTERVAL 1 DAY,"BMC","BMC1","des","Ma","usr1","rep4",CURDATE() - INTERVAL 1 DAY,"1D"); 
INSERT INTO mar VALUE ("24",CURDATE() - INTERVAL 1 DAY,"BMC","BMC1","des","Ma","usr1","rep4",CURDATE() - INTERVAL 1 DAY,"1D"); 
INSERT INTO mar VALUE ("25",CURDATE() - INTERVAL 1 DAY,"BMC","BMC1","des","Ma","usr1","rep4",CURDATE() - INTERVAL 1 DAY,"1D"); 
