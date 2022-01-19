/* Stored procedure for PAYROLL table */
USE `CSCI5308_9_DEVINT`;
DROP procedure IF EXISTS `create_payroll`;

DELIMITER $$
USE `CSCI5308_9_DEVINT`$$
CREATE PROCEDURE `create_payroll` ()
BEGIN
CREATE TABLE `PAYROLL` (
                           `Payroll_ID` int(11) NOT NULL AUTO_INCREMENT,
                           `Doctor_ID` int(11) NOT NULL,
                           `Amount` decimal(10,2) NOT NULL,
                           `Age` int(11) NOT NULL,
                           `Attendence` varchar(45) NOT NULL,
                           `Pending_Amount` decimal(10,2) NOT NULL,
                           `Overtime_Amount` decimal(10,2) NOT NULL,
                           `Profit_Sharing_Incentive` decimal(10,2) NOT NULL,
                           `Tax_Deducted` decimal(10,2) NOT NULL,
                           `Total_Amount` decimal(10,2) NOT NULL,
                           PRIMARY KEY (`Payroll_ID`),
                           UNIQUE KEY `Payroll_ID_UNIQUE` (`Payroll_ID`),
                           KEY `DoctorID_FK_idx` (`Doctor_ID`),
                           CONSTRAINT `DoctorID_FK` FOREIGN KEY (`Doctor_ID`) REFERENCES `DOCTOR` (`Doctor_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
);
END$$

DELIMITER ;

/* call stored procedure to create PAYROLL table */
CALL CSCI5308_9_DEVINT.create_payroll();


/* Stored procedure for COUPONS table */
USE `CSCI5308_9_DEVINT`;
DROP procedure IF EXISTS `create_coupons`;

DELIMITER $$
USE `CSCI5308_9_DEVINT`$$
CREATE PROCEDURE `create_coupons` ()
BEGIN
CREATE TABLE `COUPONS` (
                           `Coupon_ID` int(11) NOT NULL AUTO_INCREMENT,
                           `Coupon_Code` varchar(45) NOT NULL,
                           `Coupon_Discount` decimal(10,2) NOT NULL,
                           PRIMARY KEY (`Coupon_ID`)
);
END$$

DELIMITER ;

/* call stored procedure to create PAYROLL table */
CALL CSCI5308_9_DEVINT.create_coupons();

/* Stored procedure for getting feedback from PATIENTS table */
USE `CSCI5308_9_DEVINT`;
DROP procedure IF EXISTS `getFeedback`;

DELIMITER $$
USE `CSCI5308_9_DEVINT`$$
CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `getFeedback`(IN Doctor_ID int(11))
BEGIN
SELECT Feedback AS Doctor_Feedback FROM CASES WHERE Doctor_ID = IN_Doctor_ID;
END$$

DELIMITER ;


/* Stored procedure for setting the effienciecy in Doctor table */
USE `CSCI5308_9_DEVINT`;
DROP procedure IF EXISTS `setEfficiencyIndex`;

DELIMITER $$
USE `CSCI5308_9_DEVINT`$$
CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `setEfficiencyIndex`(IN Doc_ID int(11), IN EF_INDEX decimal(10,2))
BEGIN
UPDATE DOCTOR set Efficiency_Index = EF_INDEX  WHERE Doctor_ID = Doc_ID;
END$$

DELIMITER ;


/* Stored procedure for getting everything from Doctor table */
USE `CSCI5308_9_DEVINT`;
DROP procedure IF EXISTS `allPayroll`;

DELIMITER $$
CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `allPayroll`()
BEGIN
Select * from PAYROLL;
END$$
DELIMITER ;


/* Stored procedure for getting everything from COUPON table */
USE `CSCI5308_9_DEVINT`;
DROP procedure IF EXISTS `allCoupon`;

DELIMITER $$
CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `allCoupon`()
BEGIN
SELECT * FROM Coupons;
END$$
DELIMITER ;
/* Stored procedure for CASES table */
USE `CSCI5308_9_DEVINT`;
DROP procedure IF EXISTS `create_cases`;

DELIMITER $$
USE `CSCI5308_9_DEVINT`$$
CREATE PROCEDURE `create_cases` ()
BEGIN
CREATE TABLE `CASES` (
                         `Case_ID` int(11) NOT NULL AUTO_INCREMENT,
                         `Patient_ID` int(11) NOT NULL,
                         `Case_Description` mediumtext NOT NULL,
                         `Disease_ID` int(11) NOT NULL,
                         `Feedback` decimal(2,1) NOT NULL,
                         `Reference_ID` int(11) DEFAULT NULL,
                         `Policy_ID` int(11) DEFAULT NULL,
                         `Amount` int(11) NOT NULL,
                         `Date` date NOT NULL,
                         `Doctor_ID` int(11) NOT NULL,
                         PRIMARY KEY (`Case_ID`),
                         KEY `FK_CASES_DISEASE` (`Disease_ID`),
                         KEY `FK_CASES_DOCTOR` (`Reference_ID`),
                         KEY `FK_CASES_INSURANCE` (`Policy_ID`),
                         KEY `FK_CASES_PATIENTS` (`Patient_ID`),
                         KEY `FK_CASES_DOCTOR_APP` (`Doctor_ID`),
                         CONSTRAINT `FK_CASES_DISEASE` FOREIGN KEY (`Disease_ID`) REFERENCES `DISEASE` (`Disease_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
                         CONSTRAINT `FK_CASES_DOCTOR` FOREIGN KEY (`Reference_ID`) REFERENCES `DOCTOR` (`Doctor_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
                         CONSTRAINT `FK_CASES_DOCTOR_APP` FOREIGN KEY (`Doctor_ID`) REFERENCES `DOCTOR` (`Doctor_ID`),
                         CONSTRAINT `FK_CASES_INSURANCE` FOREIGN KEY (`Policy_ID`) REFERENCES `INSURANCE` (`Policy_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1
END$$

DELIMITER ;

/* call stored procedure to create CASES table */
CALL CSCI5308_9_DEVINT.create_cases();

/* Stored procedure for DISEASE table */
USE `CSCI5308_9_DEVINT`;
DROP procedure IF EXISTS `create_disease`;

DELIMITER $$
USE `CSCI5308_9_DEVINT`$$
CREATE PROCEDURE `create_disease` ()
BEGIN
CREATE TABLE `DISEASE` (
                           `Disease_ID` int(11) NOT NULL AUTO_INCREMENT,
                           `Name` mediumtext NOT NULL,
                           `Description` mediumtext NOT NULL,
                           `Fatality_Risk_Factor` decimal(2,1) DEFAULT NULL,
                           `Contagious_Risk_Factor` decimal(2,1) DEFAULT NULL,
                           PRIMARY KEY (`Disease_ID`)
);
END$$

DELIMITER ;

/* call stored procedure to create DISEASE table */
CALL CSCI5308_9_DEVINT.create_disease();

/* Create addCase procedure to insert record */

CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `addCase`(IN PatientID
int, IN Description MEDIUMTEXT, IN DiseaseID int, IN Feedback decimal(2,1), IN ReferenceID int, IN PolicyID int, IN Amount int, IN Date date)
BEGIN
    INSERT INTO CASES(Patient_ID, Doctor_ID,Case_Description, Disease_ID, Feedback, Reference_ID, Policy_ID, Amount, Date) VALUES (PatientID, DoctorID, Description, DiseaseID, Feedback, ReferenceID, PolicyID, Amount, Date);
    SELECT LAST_INSERT_ID() AS Case_ID;
END

/* Create allCases procedure to select all records */

CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `allCases`()
BEGIN
SELECT * FROM CASES;
END

/* Create addDisease procedure to insert record */

CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `addDisease`(IN Name
MEDIUMTEXT, IN Description MEDIUMTEXT, IN FatalityRiskFactor decimal(2,1), IN
ContagiousRiskFactor decimal(2,1))
BEGIN
INSERT INTO DISEASE(Name, Description, Fatality_Risk_Factor, Contagious_Risk_Factor) VALUES (Name, Description, FatalityRiskFactor, ContagiousRiskFactor);
SELECT LAST_INSERT_ID() AS Disease_ID;
END

/* Create allDisease procedure to select all records */

CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `allDisease`()
BEGIN
SELECT * FROM DISEASE;
END

/* Create getDiseaseInRange procedure to get count of total cases per disease for a given range of days */

CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `getDiseasesInRange`(IN startDate date, IN endDate date)
BEGIN
SELECT Disease_ID, count(*) AS Total_Cases FROM CASES WHERE Date BETWEEN startDate AND endDate GROUP BY Disease_ID;
END


/* Stored procedure for adding a coupon entry to COUPON table */
USE `CSCI5308_9_DEVINT`;
DROP procedure IF EXISTS `addCoupon`;

DELIMITER $$
CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `addCoupon`(IN Coupon_Code varchar(45) , IN Coupon_Discount decimal(10,2))
BEGIN
INSERT INTO COUPONS(Coupon_Code, Coupon_Discount) VALUES(Coupon_Code, Coupon_Discount);
END$$
DELIMITER ;

/* Stored procedure for adding a payroll entry to PAYROLL table */
USE `CSCI5308_9_DEVINT`;
DROP procedure IF EXISTS `addPayroll`;

DELIMITER $$
CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `addPayroll`(IN Doctor_ID int(11) , IN Amount decimal(10,2) , IN Age int(11) , IN Attendence varchar(45) ,IN Pending_Amount decimal(10,2),IN Overtime_Amount decimal(10,2), IN Profit_Sharing_Incentive decimal(10,2), IN Tax_Deducted decimal(10,2), IN Total_Amount decimal(10,2))
BEGIN
INSERT INTO PAYROLL(Doctor_ID, Amount, Age, Attendence, Pending_Amount, Overtime_Amount, Profit_Sharing_Incentive, Tax_Deducted, Total_Amount) VALUES (Doctor_ID, Amount, Age, Attendence, Pending_Amount, Overtime_Amount, Profit_Sharing_Incentive, Tax_Deducted, Total_Amount);
END$$
DELIMITER ;


USE CSCI5308_9_DEVINT;

/* Create Doctor Table */
CREATE TABLE `DOCTOR` (
                          `Doctor_ID` int(11) NOT NULL AUTO_INCREMENT,
                          `Full_Name` varchar(45) NOT NULL,
                          `Gender` varchar(45) NOT NULL,
                          `Address` varchar(45) NOT NULL,
                          `Contact_No` int(11) NOT NULL,
                          `DOB` date NOT NULL,
                          `Speciality` varchar(45) NOT NULL,
                          `Status` varchar(45) NOT NULL,
                          `Working_Hours` decimal(10,2) NOT NULL,
                          `Efficiency_Index` decimal(10,2) DEFAULT NULL,
                          `Expertness_Index` decimal(10,2) DEFAULT NULL,
                          PRIMARY KEY (`Doctor_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1

/* Create Package Table */
CREATE TABLE `PACKAGE` (
                           `Package_ID` int(11) NOT NULL AUTO_INCREMENT,
                           `Name` varchar(45) NOT NULL,
                           `Description` varchar(45) NOT NULL,
                           `Validity` datetime NOT NULL,
                           `Amount` decimal(10,2) NOT NULL,
                           `Coupon_Code` varchar(45) NOT NULL,
                           PRIMARY KEY (`Package_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1

/* Insert details in Doctor */
CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `addDoctor`(IN Full_Name VARCHAR(45), IN Gender varchar(45), IN Address varchar(45), IN Contact_No INT(11), IN DOB DATE, IN Speciality varchar(45), IN Status varchar(45), IN Working_Hours DECIMAL(10,2), IN Efficiency_Index DECIMAL(10,2), IN Expertness_Index DECIMAL(10,2))
BEGIN
INSERT INTO DOCTOR(Full_Name, Gender, Address, Contact_No, DOB, Speciality, Status, Working_Hours, Efficiency_Index, Expertness_Index) VALUES (Full_Name, Gender, Address, Contact_No, DOB, Speciality, Status, Working_Hours, Efficiency_Index, Expertness_Index);
END

/* Insert details in Package */
CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `addPackage`(IN Name VARCHAR(45), IN Description VARCHAR(45), IN Validity DATETIME, IN Amount DECIMAL(10,2), IN CouponCode VARCHAR(45))
BEGIN
INSERT INTO PACKAGE(Name, Description, Validity, Amount, Coupon_Code) VALUES (Name, Description, Validity, Amount, Coupon_Code);
END

/* Select all Doctor Details */
CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `allDoctor`()
BEGIN
SELECT * FROM DOCTOR;
END

/* Select all Package Details */
CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `allPackage`()
BEGIN
SELECT * FROM PACKAGE;
END

/* Get specific revenue details */
CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `getRevenue`(IN Revenue_ID int)
BEGIN
SELECT Revenue_Generated  FROM REVENUE WHERE Revenue_ID = Revenue_ID;
END

/* Get specific doctor details */
CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `getSpecificDoctor`(IN Doctor_ID int)
BEGIN
SELECT DOB FROM DOCTOR WHERE Doctor_ID = Doctor_ID;
END

/* Stored procedure for Payment table */
USE `CSCI5308_9_DEVINT`;

/* Stored Procedure to create Payment table */

CREATE TABLE `PAYMENT` (
                           `Payment_ID` int(11) NOT NULL AUTO_INCREMENT,
                           `Patient_ID` int(11) NOT NULL,
                           `Amount` decimal(10,2) NOT NULL,
                           `Payment_Mode` varchar(45) NOT NULL,
                           `Payment_Status` varchar(45) NOT NULL,
                           `Discount_Applied` varchar(45) DEFAULT NULL,
                           `Insurance_Applied` varchar(45) DEFAULT NULL,
                           `Final_Amount` double DEFAULT NULL,
                           PRIMARY KEY (`Payment_ID`),
                           UNIQUE KEY `Payment_ID_UNIQUE` (`Payment_ID`),
                           KEY `Patient_ID_FK_idx` (`Patient_ID`),
                           CONSTRAINT `Patient_ID_FK` FOREIGN KEY (`Patient_ID`) REFERENCES `PATIENTS` (`Patient_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1

/* Stored Procedure to create Revenue table */

CREATE TABLE `REVENUE` (
                           `Revenue_ID` int(11) NOT NULL AUTO_INCREMENT,
                           `From_Date` date NOT NULL,
                           `To_Date` date NOT NULL,
                           `Revenue_Generated` double NOT NULL,
                           PRIMARY KEY (`Revenue_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1

/* Create addPayment procedure to insert record */

CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `addPayment`(IN PatientId int(11), IN Amount decimal(10,2), IN PaymentMode varchar(45), IN Payment_Status varchar(45), IN Discount_Applied varchar(45), IN Insurance_Applied varchar(45))
BEGIN
INSERT INTO PAYMENT(Patient_ID, Amount, Payment_Mode, Payment_Status, Discount_Applied, Insurance_Applied) VALUES (PatientId, Amount, PaymentMode, Payment_Status, Discount_Applied, Insurance_Applied);
END

/* Create allPayment procedure to select all records */

CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `allPayment`()
BEGIN
SELECT * FROM PAYMENT;
END

/* Create getAge procedure to get age from Patient table*/

CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `getAge`(IN patientId int(11))
BEGIN
SELECT Age FROM PATIENTS WHERE Patient_ID = patientId;
END

/* Create getAmount procedure to get age from Cases table*/

CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `getAmount`(IN PatientId int(11))
BEGIN
SELECT amount from CASES where patient_id = PatientId;
END

/* Create getPolicyEndDate procedure to get Policy End Date from Insurance table*/

CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `getPolicyEndDate`(policyId int(11))
BEGIN
SELECT Policy_End_Date FROM INSURANCE WHERE Policy_Id = policyId;
END

/* Create getPolicyId procedure to get from Patient table*/

CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `getPolicyId`(IN patientId int)
BEGIN
SELECT Policy_Id FROM PATIENTS WHERE Patient_ID = patientId;
END

/* Create getAmountCovered procedure to get from Insurance table*/

CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `getAmountCovered`(IN policyId int)
BEGIN
SELECT Amount_Covered FROM INSURANCE WHERE Policy_Id = policyId;
END

/* Create setFinalAmount procedure to set Final Amount to Payment table*/

CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `setFinalAmount`(IN finalAmount double, IN patientId int)
BEGIN
UPDATE PAYMENT SET Final_Amount = finalAmount WHERE Patient_ID = patientId;
END

/* Create getDistinctDiseasesInRange to get distinct diseases for patients in given range of days */
CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `getDistinctDiseasesInRange`(IN startDate DATE, IN endDate DATE)
BEGIN
SELECT DISTINCT Patient_ID, Disease_ID FROM CASES WHERE Date BETWEEN startDate AND endDate;
END

/* Create getMostCausedDiseaseInRange to get all the disease in Range using start and End date */

CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `getMostCausedDiseaseInRange`(IN startDate date, IN endDate date)
BEGIN
SELECT D.Name, count(C.Disease_ID) AS Total_Cases
FROM CASES C
         inner join DISEASE D
                    on C.Disease_ID = D.Disease_ID
WHERE Date BETWEEN
    startDate AND endDate GROUP BY C.Disease_ID
order by Total_Cases desc;
END


/* Create getMostCausedDiseaseInRange to get all the risk factors of a disease */
USE `CSCI5308_9_DEVINT`;
DROP procedure IF EXISTS `getRiskFactors`;

DELIMITER $$
CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `getRiskFactors`(IN IN_Disease_ID int(11))
BEGIN
select Fatality_Risk_Factor, Contagious_Risk_Factor  from DISEASE where Disease_ID = IN_Disease_ID;
END$$
DELIMITER ;

/* Create getSpecificDoctorJoiningDate procedure to get DateOf_Working*/
CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `getSpecificDoctorJoiningDate`(IN Doctor_ID int)
BEGIN
SELECT DateOf_Working FROM DOCTOR WHERE Doctor_ID = Doctor_ID;
END;

/* Creating stored procedure to add insurance policy */
DELIMITER $$
USE `CSCI5308_9_DEVINT`$$
CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `addInsurance`(IN PolicyName MEDIUMTEXT, IN PolicyDescription MEDIUMTEXT, IN AmountCovered int(11), IN PolicyStartDate Date, IN PolicyEndDate Date, IN PolicyType int(1))
BEGIN
INSERT INTO INSURANCE
(Policy_Name,
Policy_Description,
Amount_Covered,
Policy_Start_Date,
Policy_End_Date,
Policy_Type)
VALUES
(PolicyName, PolicyDescription, AmountCovered, PolicyStartDate, PolicyEndDate, PolicyType);
SELECT LAST_INSERT_ID() AS Policy_ID;
END$$
DELIMITER ;

/* creating stored procedure to get insurance policy by id */
DELIMITER $$
USE `CSCI5308_9_DEVINT`$$
CREATE PROCEDURE `getInsurance` (IN PolicyID int)
BEGIN
	SELECT * FROM INSURANCE WHERE Policy_ID = PolicyID;
END$$

DELIMITER ;


/* create stored procedure for get best doctors */
DELIMITER $$
CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `getExpertDoctor`(in In_Disease_ID int(11))
BEGIN
select c.doctor_ID, d.Full_Name, count(c.case_ID) as casesSolved
from CASES c
         inner join DOCTOR d
                    on c.Doctor_ID = d.Doctor_ID
group by doctor_ID, disease_ID
having disease_ID = In_Disease_ID
order by casesSolved desc limit 3;
END$$
DELIMITER ;

DROP procedure IF EXISTS `CSCI5308_9_DEVINT`.`getDiseases`;

/* This procedure gets disease by id from the disease table */
DELIMITER $$
USE `CSCI5308_9_DEVINT`$$
CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `getDisease`(IN DiseaseID int)
BEGIN
	SELECT * FROM DISEASE WHERE Disease_ID = DiseaseID;
END$$

DELIMITER ;

/* This procedure updates disease in the database */
DELIMITER $$
USE `CSCI5308_9_DEVINT`$$
CREATE PROCEDURE `updateDisease` (IN DiseaseID int,IN Name MEDIUMTEXT, IN Description MEDIUMTEXT, IN FatalityRiskFactor decimal(2,1), IN ContagiousRiskFactor decimal(2,1))
BEGIN
	UPDATE DISEASE SET `Name` = Name, `Description` = Description, `Fatality_Risk_Factor` = FatalityRiskFactor, `Contagious_Risk_Factor` = ContagiousRiskFactor WHERE `Disease_ID` = DiseaseID;
END$$

DELIMITER ;

/* This procedure retrieves specific case from the table */
DELIMITER $$
USE `CSCI5308_9_DEVINT`$$
CREATE PROCEDURE `getCase` (IN CaseID int)
BEGIN
	SELECT * FROM `CASES` WHERE `Case_ID` = CaseID;
END$$

DELIMITER ;

/* This procedure updates cases in cases table */
DELIMITER $$
USE `CSCI5308_9_DEVINT`$$
CREATE PROCEDURE `updateCase` (IN CaseID int, IN PatientID int, IN Description MEDIUMTEXT, IN DiseaseID int, IN Feedback decimal(2,1), IN ReferenceID int, IN PolicyID int, IN Amount int, IN Date date, IN DoctorID int)
BEGIN
	UPDATE `CASES` SET `Patient_ID` = PatientID, `Case_Description` = Description, `Disease_ID` = DiseaseID, `Feedback` = Feedback, `Reference_ID` = ReferenceID, `Policy_ID` = PolicyID, `Amount` = Amount, `Date` = Date, `Doctor_ID` = DoctorID WHERE `Case_ID` = CaseID;
END$$

DELIMITER ;


CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `updatePackage`(IN PackageID int, IN name_in varchar(45), IN description_in varchar(45), IN validity_in date, IN amount_in decimal(10,2), IN coupon_code_in varchar(45))
BEGIN
update PACKAGE set Name = name_in, Description = description_in, Validity = validity_in, Amount = amount_in, Coupon_Code = coupon_code_in where Package_ID = PackageID;
END
END

/* This stored procedure updates insurance record */
DELIMITER $$
USE `CSCI5308_9_DEVINT`$$
CREATE PROCEDURE `updateInsurance` (IN ID int, IN PolicyName varchar(255), IN Description varchar(255), IN Amount int, IN StartDate date, IN EndDate date, IN PolicyType int)
BEGIN
	UPDATE `INSURANCE` SET `Policy_Name` = PolicyName, `Policy_Description` = Description, `Amount_Covered` = Amount, `Policy_Start_Date` = StartDate, `Policy_End_Date` = EndDate, `Policy_Type` = PolicyType WHERE `Policy_Id` = ID;
END$$

DELIMITER ;

/* Update Payroll Table */
CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `updatePayroll`(IN Doctor_ID_IN int(11) , IN Amount_IN decimal(10,2) , IN Age_IN int(11) , IN Attendence_IN varchar(45) ,IN Pending_Amount_IN decimal(10,2),IN Overtime_Amount_IN decimal(10,2), IN Profit_Sharing_Incentive_IN decimal(10,2), IN Tax_Deducted_IN decimal(10,2), IN Total_Amount_IN decimal(10,2))
BEGIN
UPDATE PAYROLL SET
                   `Amount` = Amount_IN,
                   `Age`= Age_IN,
                   `Attendence` = Attendence_IN,
                   `Pending_Amount` = Pending_Amount_IN,
                   `Overtime_Amount` = Overtime_Amount_IN,
                   `Profit_Sharing_Incentive` = Profit_Sharing_Incentive_IN,
                   `Tax_Deducted` = Tax_Deducted_IN,
                   `Total_Amount` = Total_Amount_IN
WHERE `Doctor_ID`= Doctor_ID_IN;
END


DELIMITER $$
CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `viewPayment`(IN paymentId int(11))
BEGIN
SELECT * FROM PAYMENT WHERE Payment_ID = paymentId;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `updatePayroll`(IN Doctor_ID_IN int(11) , IN Amount_IN decimal(10,2) , IN Age_IN int(11) , IN Attendence_IN varchar(45) ,IN Pending_Amount_IN decimal(10,2),IN Overtime_Amount_IN decimal(10,2), IN Profit_Sharing_Incentive_IN decimal(10,2), IN Tax_Deducted_IN decimal(10,2), IN Total_Amount_IN decimal(10,2))
BEGIN
UPDATE PAYROLL SET
                   `Amount` = Amount_IN,
                   `Age`= Age_IN,
                   `Attendence` = Attendence_IN,
                   `Pending_Amount` = Pending_Amount_IN,
                   `Overtime_Amount` = Overtime_Amount_IN,
                   `Profit_Sharing_Incentive` = Profit_Sharing_Incentive_IN,
                   `Tax_Deducted` = Tax_Deducted_IN,
                   `Total_Amount` = Total_Amount_IN
WHERE `Doctor_ID`= Doctor_ID_IN;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `updatePatient`(IN Patient_ID_In int(11),
IN Assigned_Doctor_ID_In int(11),
IN Patient_Full_Name_In varchar(45),
IN Address_In varchar(90),
IN Gender_In varchar(6),
IN Age_In int(11),
IN Blood_Group_In varchar(4),
IN Arrival_Date_In date,
IN Contact_No_In int(11),
IN Disease_In varchar(45),
IN BPL_Info_In varchar(45),
IN Annual_Income_In double,
IN Feedback_In int(11),
IN Policy_ID_In int(11),
IN Government_Scheme_In varchar(45),
IN Package_ID_In int(11))
BEGIN
UPDATE PATIENTS SET Assigned_Doctor_ID = Assigned_Doctor_ID_In,
                    Patient_Full_Name = Patient_Full_Name_In,
                    Address = Address_In,
                    Gender = Gender_In,
                    Age = Age_In,
                    Blood_Group = Blood_Group_In,
                    Arrival_Date = Arrival_Date_In,
                    Contact_No = Contact_No_In,
                    Disease = Disease_In,
                    BPL_Info = BPL_Info_In,
                    Annual_Income = Annual_Income_In,
                    Feedback = Feedback_In,
                    Policy_ID = Policy_ID_In,
                    Government_Scheme = Government_Scheme_In,
                    Package_ID = Package_ID_In
WHERE PATIENT_ID = Patient_ID_In;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `updatePackage`(IN PackageID int, IN name_in varchar(45), IN description_in varchar(45), IN validity_in date, IN amount_in decimal(10,2), IN coupon_code_in varchar(45))
BEGIN
update PACKAGE set Name = name_in, Description = description_in, Validity = validity_in, Amount = amount_in, Coupon_Code = coupon_code_in where Package_ID = PackageID;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `updateInsurance`(IN ID int, IN PolicyName varchar(255), IN Description varchar(255), IN Amount int, IN StartDate date, IN EndDate date, IN PolicyType int)
BEGIN
UPDATE `INSURANCE` SET `Policy_Name` = PolicyName, `Policy_Description` = Description, `Amount_Covered` = Amount, `Policy_Start_Date` = StartDate, `Policy_End_Date` = EndDate, `Policy_Type` = PolicyType WHERE `Policy_Id` = ID;
END$$
DELIMITER ;


DELIMITER $$
CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `updateDisease`(IN DiseaseID int,IN Name MEDIUMTEXT, IN Description MEDIUMTEXT, IN FatalityRiskFactor decimal(2,1), IN ContagiousRiskFactor decimal(2,1))
BEGIN
UPDATE DISEASE SET `Name` = Name, `Description` = Description, `Fatality_Risk_Factor` = FatalityRiskFactor, `Contagious_Risk_Factor` = ContagiousRiskFactor WHERE `Disease_ID` = DiseaseID;
END$$
DELIMITER ;


DELIMITER $$
CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `updateCoupon`(IN Coupon_ID_IN int(11), IN Coupon_Code_IN varchar(45), IN Coupon_Discount_IN decimal(10,2))
BEGIN
UPDATE COUPONS
SET Coupon_Code = Coupon_Code_IN,
    Coupon_Discount = Coupon_Discount_IN
where Coupon_ID = Coupon_ID_IN;
END$$
DELIMITER ;


DELIMITER $$
CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `updateCase`(IN CaseID int, IN PatientID int, IN Description MEDIUMTEXT, IN DiseaseID int, IN Feedback decimal(2,1), IN ReferenceID int, IN PolicyID int, IN Amount int, IN Date date, IN DoctorID int)
BEGIN
UPDATE `CASES` SET `Patient_ID` = PatientID, `Case_Description` = Description, `Disease_ID` = DiseaseID, `Feedback` = Feedback, `Reference_ID` = ReferenceID, `Policy_ID` = PolicyID, `Amount` = Amount, `Date` = Date, `Doctor_ID` = DoctorID WHERE `Case_ID` = CaseID;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `setOvertime`(in Doctor_IN int(11), in Overtime_IN decimal(10,2))
BEGIN
UPDATE DOCTOR SET Overtime_Hours = Overtime_IN where Doctor_ID = Doctor_IN;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `setInsuranceToDoctor`(IN Doc_ID int(11))
BEGIN
UPDATE DOCTOR set Policy_Id_Doc = 3  WHERE Doctor_ID = Doc_ID;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `setFinalAmount`(IN finalAmount double, IN patientId int)
BEGIN
UPDATE PAYMENT SET Final_Amount = finalAmount WHERE Patient_ID = patientId;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `setEfficiencyIndex`(IN Doc_ID int(11), IN EF_INDEX decimal(10,2))
BEGIN
UPDATE DOCTOR set Efficiency_Index = EF_INDEX  WHERE Doctor_ID = Doc_ID;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `setAttendance`(IN Doc_ID int(11), IN Attendance_In decimal(10,2))
BEGIN
UPDATE PAYROLL set Attendence = Attendance_In  WHERE Doctor_ID = Doc_ID;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `getSpecificDoctorJoiningDate`(IN Doctor_ID int)
BEGIN
SELECT DateOf_Working FROM DOCTOR WHERE Doctor_ID = Doctor_ID;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `getSpecificDoctor`(IN Doctor_ID int)
BEGIN
SELECT DOB FROM DOCTOR WHERE Doctor_ID = Doctor_ID;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `getRiskFactors`(IN IN_Disease_ID int(11))
BEGIN
select Fatality_Risk_Factor, Contagious_Risk_Factor  from DISEASE where Disease_ID = IN_Disease_ID;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `getRevenue`(IN Revenue_ID int)
BEGIN
SELECT Revenue_Generated  FROM REVENUE WHERE Revenue_ID = Revenue_ID;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `getPolicyId`(IN patientId int)
BEGIN
SELECT Policy_Id FROM PATIENTS WHERE Patient_ID = patientId;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `getPolicyEndDate`(policyId int(11))
BEGIN
SELECT Policy_End_Date FROM INSURANCE WHERE Policy_Id = policyId;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `getOnePayroll`(in docId int(11))
BEGIN
select * from PAYROLL where Doctor_ID = docId;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `getOnePatientDetail`(in patientid_in int(11))
BEGIN
Select * from PATIENTS where  PATIENT_ID = patientid_in;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `getOneDocDetail`(in doctorid_in int(11))
BEGIN
Select * from DOCTOR where Doctor_ID = doctorid_in;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `getMostCausedDiseaseInRange`(IN startDate date, IN endDate date)
BEGIN
SELECT D.Name, count(C.Disease_ID) AS Total_Cases
FROM CASES C
         inner join DISEASE D
                    on C.Disease_ID = D.Disease_ID
WHERE Date BETWEEN
    startDate AND endDate GROUP BY C.Disease_ID
order by Total_Cases desc;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `getHours`(IN Doctor_IN int)
BEGIN
SELECT Working_Hours, Overtime_Hours FROM DOCTOR WHERE Doctor_ID = Doctor_IN;
END$$
DELIMITER ;
