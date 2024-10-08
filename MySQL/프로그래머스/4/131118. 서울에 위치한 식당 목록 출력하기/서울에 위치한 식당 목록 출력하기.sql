WITH REVIEW_SCORE AS (
    SELECT REST_ID, ROUND(AVG(REVIEW_SCORE), 2) SCORE
    FROM REST_REVIEW
    GROUP BY REST_ID
)

# SELECT *
SELECT I.REST_ID, I.REST_NAME, I.FOOD_TYPE, I.FAVORITES, I.ADDRESS, S.SCORE
FROM REST_INFO I
JOIN REVIEW_SCORE S ON I.REST_ID = S.REST_ID
WHERE I.ADDRESS LIKE '서울%'
ORDER BY S.SCORE DESC, I.FAVORITES DESC





# SELECT I.REST_ID, I.REST_NAME, I.FOOD_TYPE, I.FAVORITES, I.ADDRESS, R.SCORE
# FROM REST_INFO I JOIN (SELECT REST_ID, ROUND(AVG(REVIEW_SCORE),2) SCORE
#                       FROM REST_REVIEW
#                       GROUP BY REST_ID) R USING(REST_ID)
# WHERE I.ADDRESS LIKE '서울%'
# ORDER BY R.SCORE DESC, I.FAVORITES DESC