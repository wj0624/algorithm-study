SELECT f.flavor
FROM first_half f
LEFT JOIN icecream_info i ON f.flavor = i.flavor
WHERE total_order > 3000 
AND i.ingredient_type LIKE 'fruit%'
ORDER BY total_order DESC















# SELECT F.FLAVOR
# FROM FIRST_HALF F JOIN ICECREAM_INFO I
# ON F.FLAVOR = I.FLAVOR
# WHERE F.TOTAL_ORDER > 3000 AND I.INGREDIENT_TYPE = "fruit_based"
# ORDER BY F.TOTAL_ORDER DESC