create view CUSTOMER_DATA_VIEW as

SELECT
    ROW_NUMBER() OVER () AS row_num,
    gps.TRXN_TIMESTAMP AS TRXN_Timestamp,
    gps.CAR_DRIVING_STATUS AS Car_Driving_Status,
    gps.CURRENT_LONGITUDE AS Current_Longitude,
    gps.CURRENT_LATITUDE AS Current_Latitude,
    gps.CURRENT_AREA AS Current_Area,
    gps.KM AS KM,
    st.AMOUNT AS Amount,
    cd.MOBILE_NO AS customer_mobile_no,
    cd.ANONYMIZED_MOBILE_NO as customer_anonymized_mobile_no,
    cd.NAME AS Customer_Name,
    cd.GENDER AS Customer_Gender,
    cd.AGE AS Customer_Age,
    CASE
        WHEN cd.AGE < 18 THEN '<18'
        WHEN cd.AGE BETWEEN 19 AND 30 THEN '19-30'
        WHEN cd.AGE BETWEEN 31 AND 50 THEN '31-50'
        ELSE '51+'
    END AS Customer_Age_Band,
    cd.NATIONALITY AS Customer_Nationality,
    cd.PASSPORT_NO AS Customer_Passport_No,
    cd.ID_NO AS Customer_Id_No,
    cd.HOME_ADDRESS AS Customer_Home_address,
    cd.LEASE_START_DATE AS Customer_Lease_Start_Date,
    cd.LEASE_PERIOD AS Customer_Lease_Period,
    car.CAR_MAKE AS Car_Make,
    car.CAR_MODEL AS Car_Model,
    car.PLATE_NO AS Car_Plate_No,
    car.REGISTRATION_DATE AS Car_Registration_Date,
    car.REGISTRATION_EXPIRY_DATE AS Car_Registration_Expiry_Date,
    obd.MOBILE_NO AS Office_Mobile_No,
    obd.ANONYMIZED_MOBILE_NO as office_anonymized_mobile_no,
    obd.AREA AS Office_Area,
    obd.OFFICE_NO AS Office_Office_No,
    obd.WORKING_HOURS AS Office_Working_Hours,
    sgd.MOBILE_NO AS Agent_Mobile_No,
    sgd.ANONYMIZED_MOBILE_NO as agent_anonymized_mobile_no,
    sgd.NAME AS Agent_Name,
    sgd.GENDER AS Agent_Gender,
    sgd.AGE AS Agent_Age,
    CASE
        WHEN sgd.AGE < 18 THEN '<18'
        WHEN sgd.AGE BETWEEN 19 AND 30 THEN '19-30'
        WHEN sgd.AGE BETWEEN 31 AND 50 THEN '31-50'
        ELSE '51+'
    END AS Agent_Age_Band,
    sgd.NATIONALITY AS Agent_Nationality
FROM
    GPS_TRANSACTIONS gps
JOIN
    CAR_DATA car ON car.CAR_ID = gps.CAR_ID
JOIN
    SALES_AGENT_DATA sgd ON sgd.AGENT_ID = gps.AGENT_ID
JOIN
    CUSTOMER_DATA cd ON cd.CUSTOMER_ID = gps.CUSTOMER_ID
JOIN
    OFFICE_BRANCH_DATA obd ON obd.OFFICE_ID = gps.OFFICE_ID
JOIN
    SALES_TRANSACTIONS st ON st.CUSTOMER_ID = gps.CUSTOMER_ID
    AND st.CAR_ID = gps.CAR_ID
    AND st.OFFICE_ID = gps.OFFICE_ID
    AND st.AGENT_ID = gps.AGENT_ID;