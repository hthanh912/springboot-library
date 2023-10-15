select * from authors

select * from users

select * from books

select * from genres

select * from book_genre

ALTER TABLE books RENAME COLUMN sum_of_rating TO sum_of_ratings;  

ALTER TABLE genres ALTER COLUMN description TYPE varchar(2048)

SELECT * FROM reviews

INSERT INTO reviews(review_id, user_id, book_book_id, content, rate, created_at, updated_at)
VALUES(gen_random_uuid(), '899c46f1-1358-4869-a7bd-635f747b5cb9', '7ba0e0b2-6176-427a-8212-da414d7e6edb', null, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)


UPDATE books b
SET number_of_ratings = (SELECT COUNT(book_book_id)
						FROM reviews r
						WHERE r.book_book_id = '7ba0e0b2-6176-427a-8212-da414d7e6edb'),
	average_rate = (SELECT AVG(rate)
						FROM reviews r
						WHERE r.book_book_id = '7ba0e0b2-6176-427a-8212-da414d7e6edb'),
	number_of_reviews = (SELECT COUNT(book_book_id)
						FROM reviews r
						WHERE r.book_book_id = '7ba0e0b2-6176-427a-8212-da414d7e6edb' and r.content is not null)
WHERE b.book_id = '7ba0e0b2-6176-427a-8212-da414d7e6edb'

SELECT COUNT(book_book_id)
						FROM reviews r
						WHERE r.book_book_id = '7ba0e0b2-6176-427a-8212-da414d7e6edb' and r.content is not null

7ba0e0b2-6176-427a-8212-da414d7e6edb

ALTER TABLE books ALTER COLUMN description TYPE varchar(2048)


SELECT a.author_id, a.name, a.description, a.born, a.photo_url, a.created_at, a.updated_at,
	sum(b.number_of_ratings) AS numberOfRatings, 
	sum(b.number_of_reviews) AS numberOfReviews,
	sum(b.number_of_ratings * b.average_rate)/sum(b.number_of_ratings) AS averageRate,
	array_agg(distinct(b_g.genre_id)) AS genres,
	json_agg(jsonb_build_object('id', b_g.genre_id, 'name', g.name))
FROM authors a
LEFT JOIN books b ON a.author_id = b.author_author_id
INNER JOIN book_genre b_g ON b_g.book_id = b.book_id
LEFT JOIN genres g ON g.genre_id = b_g.genre_id
WHERE a.author_id = '6a39b1d5-5f57-4781-b7e8-06584792e40e'
GROUP BY a.author_id

{4070427f-eab6-41d5-84d0-fdf58a783e7f,
41053c4e-e7f2-462f-9dd6-8755704691f6,
4070427f-eab6-41d5-84d0-fdf58a783e7f}
{4070427f-eab6-41d5-84d0-fdf58a783e7f,41053c4e-e7f2-462f-9dd6-8755704691f6}
