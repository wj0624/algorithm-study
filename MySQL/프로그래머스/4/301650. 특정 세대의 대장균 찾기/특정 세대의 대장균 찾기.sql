WITH RECURSIVE GENERATION AS (
    SELECT ID, 1 AS GEN
    FROM ECOLI_DATA
    WHERE PARENT_ID IS NULL
    UNION ALL
    SELECT E.ID, G.GEN + 1
    FROM ECOLI_DATA E
    JOIN GENERATION G ON E.PARENT_ID = G.ID
)

SELECT ID
FROM GENERATION
WHERE GEN = 3
ORDER BY ID