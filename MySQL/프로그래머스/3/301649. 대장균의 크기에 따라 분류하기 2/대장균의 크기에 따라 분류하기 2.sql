WITH E AS (
    SELECT ID, RANK() OVER (ORDER BY SIZE_OF_COLONY desc) as R
    FROM ECOLI_DATA
)

SELECT ID, 
    CASE
        WHEN R <= (SELECT COUNT(*) FROM E) * 0.25 THEN 'CRITICAL'
        WHEN R <= (SELECT COUNT(*) FROM E) * 0.5 THEN 'HIGH'
        WHEN R <= (SELECT COUNT(*) FROM E) * 0.75 THEN 'MEDIUM'
        ELSE 'LOW'
    END AS COLONY_NAME
FROM E
ORDER BY ID;