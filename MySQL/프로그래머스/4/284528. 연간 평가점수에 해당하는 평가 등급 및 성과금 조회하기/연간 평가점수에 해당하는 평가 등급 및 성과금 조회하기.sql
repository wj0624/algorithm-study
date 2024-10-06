WITH GR AS (
    SELECT EMP_NO,
    CASE 
        WHEN AVG(SCORE) >= 96 THEN 'S'
        WHEN AVG(SCORE) >= 90 THEN 'A'
        WHEN AVG(SCORE) >= 80 THEN 'B'
        ELSE 'C'
    END AS GRADE
    FROM HR_GRADE
    GROUP BY EMP_NO
)

SELECT 
    E.EMP_NO, E.EMP_NAME, G.GRADE, 
    CASE 
        WHEN G.GRADE = 'S' THEN E.SAL * 0.2
        WHEN G.GRADE = 'A' THEN E.SAL * 0.15
        WHEN G.GRADE = 'B' THEN E.SAL * 0.1
        ELSE 0
    END AS BONUS
FROM HR_EMPLOYEES E
JOIN GR G ON E.EMP_NO = G.EMP_NO
ORDER BY EMP_NO





# WITH G AS (
#     SELECT EMP_NO,
#            CASE WHEN AVG(SCORE) >= 96 THEN 'S'
#                 WHEN AVG(SCORE) >= 90 THEN 'A'
#                 WHEN AVG(SCORE) >= 80 THEN 'B'
#                 ELSE 'C' END AS GRADE
#     FROM HR_GRADE
#     GROUP BY EMP_NO)

# SELECT E.EMP_NO, E.EMP_NAME, G.GRADE, CASE G.GRADE WHEN 'S' THEN (E.SAL*0.2)
#                                                    WHEN 'A' THEN (E.SAL*0.15)
#                                                    WHEN 'B' THEN (E.SAL*0.1)
#                                                    ELSE 0 END AS BONUS
# FROM HR_EMPLOYEES E JOIN G USING(EMP_NO)
# ORDER BY EMP_NO