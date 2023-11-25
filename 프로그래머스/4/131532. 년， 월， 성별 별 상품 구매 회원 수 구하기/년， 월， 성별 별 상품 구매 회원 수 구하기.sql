SELECT YEAR(S.SALES_DATE) AS YEAR, MONTH(S.SALES_DATE) AS MONTH, I.GENDER, COUNT(DISTINCT I.USER_ID) AS USERS
FROM USER_INFO AS I
JOIN ONLINE_SALE AS S
ON I.USER_ID = S.USER_ID
WHERE I.GENDER IS NOT NULL
GROUP BY YEAR, MONTH, GENDER
ORDER BY YEAR, MONTH, GENDER;
