USE `database`;
INSERT INTO users VALUE ("user1","1001526202","SM","SM","password","U","1121 UTA","Arlington","TX","76010","1001526202","sm@uta.edu");
INSERT INTO users VALUE ("usr1","1001526202","SM","SM","password","U","1121 UTA","Arlington","TX","76010","1001526202","sm@uta.edu");
INSERT INTO users VALUE ("rep1","1001526202","SM","SM","password","R","1121 UTA","Arlington","TX","76010","1001526202","sm@uta.edu");
INSERT INTO users VALUE ("rep2","1001526202","SM","SM","password","R","1121 UTA","Arlington","TX","76010","1001526202","sm@uta.edu");
INSERT INTO users VALUE ("rep3","1001526202","SM","SM","password","R","1121 UTA","Arlington","TX","76010","1001526202","sm@uta.edu");
INSERT INTO users VALUE ("rep4","1001526202","SM","SM","password","R","1121 UTA","Arlington","TX","76010","1001526202","sm@uta.edu");
INSERT INTO users VALUE ("rep","1001526202","SM","SM","password","R","1121 UTA","Arlington","TX","76010","1001526202","sm@uta.edu");
INSERT INTO users VALUE ("rep5","1001526202","SM","SM","password","R","1121 UTA","Arlington","TX","76010","1001526202","sm@uta.edu");


INSERT INTO mar VALUE ("71",curdate(),"BMC","BMC1","des","Ma","usr1",null ,null ,null); 
INSERT INTO mar VALUE ("72",curdate(),"BMC","BMC3","des","Ma","usr1",null,null,null); 
INSERT INTO mar VALUE ("73",curdate(),"BMC","BMC4","des","Ma","usr1",null,null,null); 
INSERT INTO mar VALUE ("74",curdate(),"BMC","BMC4","des","Ma","usr1",null,null,null); 
INSERT INTO mar VALUE ("75",curdate(),"BMC","BMC4","des","Ma","usr1",null,null,null); 


INSERT INTO mar VALUE ("101",curdate(),"BMC","BMC1","des","Ma","usr1","rep2",curdate(),"1D"); 
INSERT INTO mar VALUE ("102",curdate(),"BMC","BMC1","des","Ma","usr1","rep2",curdate(),"1D"); 
INSERT INTO mar VALUE ("103",curdate(),"BMC","BMC1","des","Ma","usr1","rep2",curdate(),"1D"); 
INSERT INTO mar VALUE ("104",curdate(),"BMC","BMC1","des","Ma","usr1","rep2",curdate(),"1D"); 
INSERT INTO mar VALUE ("105",curdate(),"BMC","BMC1","des","Ma","usr1","rep2",curdate(),"1D"); 

INSERT INTO mar VALUE ("106",curdate(),"BMC","BMC1","des","Ma","usr1","rep3",curdate(),"1D"); 
INSERT INTO mar VALUE ("107",curdate(),"BMC","BMC1","des","Ma","usr1","rep3",curdate(),"1D"); 
INSERT INTO mar VALUE ("108",curdate(),"BMC","BMC1","des","Ma","usr1","rep3",curdate(),"1D"); 
INSERT INTO mar VALUE ("109",curdate(),"BMC","BMC1","des","Ma","usr1","rep3",CURDATE() + INTERVAL 1 DAY,"1D"); 
INSERT INTO mar VALUE ("110",curdate(),"BMC","BMC1","des","Ma","usr1","rep3",CURDATE() + INTERVAL 1 DAY,"1D"); 
INSERT INTO mar VALUE ("111",curdate(),"BMC","BMC1","des","Ma","usr1","rep3",CURDATE() + INTERVAL 1 DAY,"1D"); 
INSERT INTO mar VALUE ("112",curdate(),"BMC","BMC1","des","Ma","usr1","rep3",CURDATE() + INTERVAL 2 DAY,"1D"); 
INSERT INTO mar VALUE ("113",curdate(),"BMC","BMC1","des","Ma","usr1","rep3",CURDATE() + INTERVAL 2 DAY,"1D"); 
INSERT INTO mar VALUE ("114",curdate(),"BMC","BMC1","des","Ma","usr1","rep3",CURDATE() + INTERVAL 2 DAY,"1D"); 
INSERT INTO mar VALUE ("115",curdate(),"BMC","BMC1","des","Ma","usr1","rep3",CURDATE() + INTERVAL 2 DAY,"1D"); 


INSERT INTO mar VALUE ("121",CURDATE() - INTERVAL 1 DAY,"BMC","BMC1","des","Ma","usr1","rep4",CURDATE() - INTERVAL 1 DAY,"1D"); 
INSERT INTO mar VALUE ("122",CURDATE() - INTERVAL 1 DAY,"BMC","BMC1","des","Ma","usr1","rep4",CURDATE() - INTERVAL 1 DAY,"1D"); 
INSERT INTO mar VALUE ("123",CURDATE() - INTERVAL 1 DAY,"BMC","BMC1","des","Ma","usr1","rep4",CURDATE() - INTERVAL 1 DAY,"1D"); 
INSERT INTO mar VALUE ("124",CURDATE() - INTERVAL 1 DAY,"BMC","BMC1","des","Ma","usr1","rep4",CURDATE() - INTERVAL 1 DAY,"1D"); 
INSERT INTO mar VALUE ("125",CURDATE() - INTERVAL 1 DAY,"BMC","BMC1","des","Ma","usr1","rep4",CURDATE() - INTERVAL 1 DAY,"1D");

INSERT INTO mar VALUE ("131",curdate(),"BMC","BMC1","des","Ma","usr1","rep5",curdate(),"1D"); 
INSERT INTO mar VALUE ("132",curdate(),"BMC","BMC1","des","Ma","usr1","rep5",curdate(),"1D"); 
INSERT INTO mar VALUE ("133",curdate(),"BMC","BMC1","des","Ma","usr1","rep5",curdate(),"1D"); 
INSERT INTO mar VALUE ("134",curdate(),"BMC","BMC1","des","Ma","usr1","rep5",CURDATE(),"1D"); 
INSERT INTO mar VALUE ("135",curdate(),"BMC","BMC1","des","Ma","usr1","rep5",CURDATE(),"1D"); 
INSERT INTO mar VALUE ("136",curdate(),"BMC","BMC1","des","Ma","usr1","rep5",CURDATE() + INTERVAL 1 DAY,"1D"); 
INSERT INTO mar VALUE ("137",curdate(),"BMC","BMC1","des","Ma","usr1","rep5",CURDATE() + INTERVAL 1 DAY,"1D"); 
INSERT INTO mar VALUE ("138",curdate(),"BMC","BMC1","des","Ma","usr1","rep5",CURDATE() + INTERVAL 1 DAY,"1D"); 
INSERT INTO mar VALUE ("139",curdate(),"BMC","BMC1","des","Ma","usr1","rep5",CURDATE() + INTERVAL 2 DAY,"1D"); 
INSERT INTO mar VALUE ("140",curdate(),"BMC","BMC1","des","Ma","usr1","rep5",CURDATE() + INTERVAL 2 DAY,"1D"); 


INSERT INTO facilityreservation VALUE("27", "BMC1", "BMC", "I", "rep", "2019-10-25", "2019-10-25 06:29:59", "2019-10-25 06:00:00");
INSERT INTO facilityreservation VALUE("30", "BMC1", "BMC", "I", "rep", "2019-10-25", "2019-10-25 12:59:59", "2019-10-25 12:30:00");


INSERT INTO users VALUE ("repTest","1001526202","SM","SM","password","R","1121 UTA","Arlington","TX","76010","1001526202","sm@uta.edu");
INSERT INTO mar VALUE ("50","2019-10-24","BMC","BMC1","des","Ma","usr1","repTest","2019-10-25","1D");
INSERT INTO mar VALUE ("52","2019-10-24","BMC","BMC1","des","Ma","usr1","repTest","2019-10-25","1D");
INSERT INTO mar VALUE ("51","2019-10-24","BMC","BMC1","des","Ma","usr1","repTest","2019-10-25","1D");
INSERT INTO mar VALUE ("53","2019-10-24","CR","CR1","des","Ma","usr1","repTest","2019-10-25","1D");
INSERT INTO mar VALUE ("54","2019-10-24","SCG","SCG","des","Ma","usr1","repTest","2019-10-25","1D");
INSERT INTO mar VALUE ("55","2019-10-24","OVBC","OVBC1","des","Ma","usr1","repTest","2019-10-25","1D");
INSERT INTO mar VALUE ("56","2019-10-24","MR","MR1","des","Ma","usr1","repTest","2019-10-25","1D");
INSERT INTO mar VALUE ("57","2019-10-24","IBBC","IBBC1","des","Ma","usr1","repTest","2019-10-25","1D");
INSERT INTO mar VALUE ("58","2019-10-24","IVBC","IVBC1","des","Ma","usr1","repTest","2019-10-25","1D");
INSERT INTO mar VALUE ("59","2019-09-08","OBBC","OBBC1","des","Ma","usr1","repTest","2019-09-09","1D");
INSERT INTO repairschedule VALUE ("repTest","52","2019-10-24");
INSERT INTO repairschedule VALUE ("repTest","50","2019-10-24");
INSERT INTO repairschedule VALUE ("repTest","51","2019-10-24");
INSERT INTO repairschedule VALUE ("repTest","53","2019-10-24");
INSERT INTO repairschedule VALUE ("repTest","54","2019-10-24");
INSERT INTO repairschedule VALUE ("repTest","55","2019-10-24");
INSERT INTO repairschedule VALUE ("repTest","56","2019-10-24");
INSERT INTO repairschedule VALUE ("repTest","57","2019-10-24");
INSERT INTO repairschedule VALUE ("repTest","58","2019-10-24");
INSERT INTO repairschedule VALUE ("repTest","59","2019-09-08");
INSERT INTO facilityreservation VALUE("52", "BMC1", "BMC", "I", "repTest", "2019-10-25", "2019-10-25 12:59:59", "2019-10-25 12:30:00");
INSERT INTO facilityreservation VALUE("50", "BMC1", "BMC", "I", "repTest", "2019-10-25", "2019-10-25 12:59:59", "2019-10-25 12:30:00");
