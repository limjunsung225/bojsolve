SELECT A.REST_ID, A.REST_NAME, A.FOOD_TYPE, A.FAVORITES, A.ADDRESS, 
       ROUND(AVG(B.REVIEW_SCORE),2) as SCORE
FROM REST_INFO AS A
INNER JOIN REST_REVIEW AS B
ON A.REST_ID = B.REST_ID
GROUP BY A.REST_ID
HAVING A.ADDRESS LIKE ("서울%")
ORDER BY SCORE DESC, FAVORITES DESC;