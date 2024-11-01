-- 코드를 입력하세요
# 2022년 1월의 도서 판매 데이터
# 저자 별, 카테고리 별 매출액(TOTAL_SALES = 판매량 * 판매가) 을 구하여, 저자 ID(AUTHOR_ID), 저자명(AUTHOR_NAME), 카테고리(CATEGORY), 매출액(SALES) 리스트를 출력
# 결과는 저자 ID를 오름차순으로, 저자 ID가 같다면 카테고리를 내림차순
SELECT
    AUTHOR.AUTHOR_ID, AUTHOR.AUTHOR_NAME, BOOK.CATEGORY, SUM(BOOK_SALES.SALES * BOOK.PRICE) AS SALES
FROM BOOK
JOIN AUTHOR ON AUTHOR.AUTHOR_ID = BOOK.AUTHOR_ID
JOIN BOOK_SALES ON BOOK.BOOK_ID = BOOK_SALES.BOOK_ID
WHERE BOOK_SALES.SALES_DATE LIKE '2022-01-%'
GROUP BY AUTHOR.AUTHOR_ID, BOOK.CATEGORY
ORDER BY AUTHOR.AUTHOR_ID ASC, BOOK.CATEGORY DESC;