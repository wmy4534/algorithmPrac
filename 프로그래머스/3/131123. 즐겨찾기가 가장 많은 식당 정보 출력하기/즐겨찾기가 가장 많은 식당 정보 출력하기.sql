# 음식종류별로 즐겨찾기수가 가장 많은 식당의 음식 종류, ID, 식당 이름, 즐겨찾기수를 조회
# 음식 종류를 기준으로 내림차순
SELECT
    A.FOOD_TYPE, A.REST_ID, A.REST_NAME, A.FAVORITES
FROM
    REST_INFO AS A
JOIN (
    SELECT FOOD_TYPE, MAX(FAVORITES) AS MAX_FAVORITE
    FROM REST_INFO
    GROUP BY FOOD_TYPE
) AS B ON A.FOOD_TYPE = B.FOOD_TYPE AND A.FAVORITES = B.MAX_FAVORITE
ORDER BY A.FOOD_TYPE DESC;