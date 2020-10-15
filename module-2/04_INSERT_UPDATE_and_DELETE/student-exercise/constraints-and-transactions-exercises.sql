-- Write queries to return the following:
-- The following changes are applied to the "dvdstore" database.**

-- 1. Add actors, Hampton Avenue, and Lisa Byway to the actor table.

SELECT * FROM actor WHERE last_name IN ('AVENUE', 'BYWAY');

INSERT INTO actor (first_name, last_name)
VALUES ('HAMPTON','AVENUE'), ('LISA','BYWAY');


--DON'T HAVE TO SPECIFY AN ACTOR ID B/C IT WILL BE AUTO-CREATED

-- 2. Add "Euclidean PI", "The epic story of Euclid as a pizza delivery boy in
-- ancient Greece", to the film table. The movie was released in 2008 in English.
-- Since its an epic, the run length is 3hrs and 18mins. There are no special
-- features, the film speaks for itself, and doesn't need any gimmicks.

INSERT INTO film (title, description, release_year, language_id, length)
VALUES ('Euclidean PI', 'The epic story of Euclid as a pizza delivery boy in
-- ancient Greece', 2008, (SELECT language_id FROM language WHERE name = 'English'), 198);

SELECT * FROM film WHERE title = 'Euclidean PI';

-- 3. Hampton Avenue plays Euclid, while Lisa Byway plays his slightly
-- overprotective mother, in the film, "Euclidean PI". Add them to the film.
INSERT INTO film_actor (film_id, actor_id)
VALUES ((SELECT film_id FROM film WHERE title = 'Euclidean PI'), (SELECT actor_id FROM actor WHERE first_name = 'HAMPTON' AND last_name = 'AVENUE')),
((SELECT film_id FROM film WHERE title = 'Euclidean PI'), (SELECT actor_id FROM actor WHERE first_name = 'LISA' AND last_name = 'BYWAY'));

SELECT title 
FROM film
JOIN film_actor ON film.film_id = film_actor.film_id
JOIN actor ON film_actor.actor_id = actor.actor_id
WHERE first_name = 'LISA' AND last_name = 'BYWAY';


-- 4. Add Mathmagical to the category table.
INSERT INTO category (name)
VALUES ('Mathmagical');

SELECT * FROM category;

-- 5. Assign the Mathmagical category to the following films, "Euclidean PI",
-- "EGG IGBY", "KARATE MOON", "RANDOM GO", and "YOUNG LANGUAGE" --THIS MEANS ADD TO EXISTING CATEGORIES (insert, not update)


INSERT INTO film_category (film_id, category_id)
VALUES ((Select film_id FROM film WHERE title = 'Euclidean PI'), (SELECT category_id FROM category WHERE name = 'Mathmagical')),
((Select film_id FROM film WHERE title ='EGG IGBY'), (SELECT category_id FROM category WHERE name = 'Mathmagical')),
((Select film_id FROM film WHERE title = 'KARATE MOON'), (SELECT category_id FROM category WHERE name = 'Mathmagical')),
((Select film_id FROM film WHERE title = 'RANDOM GO'), (SELECT category_id FROM category WHERE name = 'Mathmagical')),
((Select film_id FROM film WHERE title = 'YOUNG LANGUAGE'), (SELECT category_id FROM category WHERE name = 'Mathmagical')); 



-- 6. Mathmagical films always have a "G" rating, adjust all Mathmagical films
-- accordingly.
-- (5 rows affected)


UPDATE film
SET rating = 'G'
WHERE film_id IN (SELECT film_id FROM film_category WHERE category_id = (SELECT category_id FROM category WHERE category.name = 'Mathmagical'));


  

-- 7. Add a copy of "Euclidean PI" to all the stores.


INSERT INTO inventory (film_id, store_id)
VALUES ((SELECT film_id FROM film WHERE title = 'Euclidean PI'), 1), ((SELECT film_id FROM film WHERE title = 'Euclidean PI'), 2);



-- 8. The Feds have stepped in and have impounded all copies of the pirated film,
-- "Euclidean PI". The film has been seized from all stores, and needs to be
-- deleted from the film table. Delete "Euclidean PI" from the film table.
-- (Did it succeed? Why?)
-- <YOUR ANSWER HERE> --It does not succeed because it violates a foreign key constraint. That film is referenced via film id by the film_category table



DELETE FROM film
WHERE title = 'Euclidean PI';




-- 9. Delete Mathmagical from the category table.
-- (Did it succeed? Why?)
-- <YOUR ANSWER HERE> --It does not succeed for the same reason the one above failed. The category id for Mathmagical is referenced in the table film_category so it violates the foreign key constraint

DELETE FROM category
WHERE name = 'Mathmagical';




-- 10. Delete all links to Mathmagical in the film_category tale.
-- (Did it succeed? Why?)
-- <YOUR ANSWER HERE> -- it does succeed b/c any instance of Mathmagical in film_category is not related to any other table


DELETE FROM film_category
WHERE category_id = (SELECT category_id FROM category WHERE name = 'Mathmagical');



-- 11. Retry deleting Mathmagical from the category table, followed by retrying
-- to delete "Euclidean PI".
-- (Did either deletes succeed? Why?)
-- <YOUR ANSWER HERE> -- Mathmagical is no longer a foreign key in the database in any other table, so you can delete it from category. Euclidean PI is still a foreign key or related to a foreign key in several other tables (inventory, store, etc) so you cannot delete it

START TRANSACTION;
DELETE FROM category
WHERE name = 'Mathmagical';
ROLLBACK;

START TRANSACTION;
DELETE FROM film
WHERE title = 'Euclidean PI';
ROLLBACK;


-- 12. Check database metadata to determine all constraints of the film id, and
-- describe any remaining adjustments needed before the film "Euclidean PI" can
-- be removed from the film table.

--We would have to delete any instances of Euclidean PI from inventory, film_category, and film_actor because they all have foreign keys that point to the film table
