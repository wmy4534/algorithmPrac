-- 코드를 입력하세요
# 식품분류별로 가격이 제일 비싼 식품의 분류, 가격, 이름을 조회
# 식품분류가 '과자', '국', '김치', '식용유'인 경우만 출력
# 식품 가격을 기준으로 내림차순
SELECT
    A.CATEGORY, A.PRICE AS MAX_PRICE, A.PRODUCT_NAME
FROM FOOD_PRODUCT AS A
JOIN (
    SELECT CATEGORY, MAX(PRICE) AS MAX_PRICE
    FROM FOOD_PRODUCT
    WHERE CATEGORY IN ('과자', '국', '김치', '식용유')
    GROUP BY CATEGORY
) AS B ON B.CATEGORY = A.CATEGORY AND B.MAX_PRICE = A.PRICE
ORDER BY A.PRICE DESC;