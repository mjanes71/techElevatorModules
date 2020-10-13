-- ORDERING RESULTS

-- Populations of all countries in descending order (ascending would be default, or ASC
SELECT name, population FROM country ORDER BY population DESC;

--Names of countries and continents in ascending order -alphabetizes first by continent, then by name

SELECT name, continent 
FROM country 
ORDER BY continent, name ASC;

-- Ordering allows columns to be displayed in ascending order, or descending order (Look at Arlington)
SELECT name, population
FROM city
WHERE countrycode = 'USA'
ORDER BY name, population DESC;

-- LIMITING RESULTS

-- The 10 largest countries in the world
SELECT name, surfacearea
FROM country
ORDER BY surfacearea DESC
LIMIT 10;

-- The name and average life expectancy of the countries with the 10 highest life expectancies.
SELECT name, lifeexpectancy
FROM country
WHERE lifeexpectancy IS NOT NULL
ORDER BY lifeexpectancy DESC, name --order by LE, then name if there is a tie
LIMIT 10;

-- Limiting results allows rows to be returned in 'limited' clusters,where LIMIT says how many, and OFFSET (optional) specifies the number of rows to skip
SELECT name, lifeexpectancy
FROM country
WHERE lifeexpectancy IS NOT NULL
ORDER BY lifeexpectancy DESC, name --order by LE, then name if there is a tie
LIMIT 10 OFFSET 10; --offset tells us to skip a certain number or results before our display

-- CONCATENATING OUTPUTS

-- Most database platforms provide string functions that can be useful for working with string data. In addition to string functions, string concatenation is also usually supported, which allows us to build complete sentences if necessary.
SELECT (language || ' is spoken in the country with code ' ||  countrycode) AS Spoken_Language
FROM countrylanguage;

-- The name & state of all cities in California, Oregon, or Washington.
-- "city, state", sorted by state then city
SELECT (name || ', ' || district) AS city_state
FROM city
WHERE district IN ('California', 'Oregon', 'Washington')
ORDER BY district, name;

-- AGGREGATE FUNCTIONS (count avg sum min max)

-- Aggregate functions provide the ability to COUNT, SUM, and AVG, as well as determine MIN and MAX. Only returns a single row of value(s) unless used with GROUP BY.

-- Counts the number of rows in the city table
SELECT COUNT(*) FROM city; --TELLS YOU HOW MANY ROWS THERE ARE


-- Also counts the number of rows in the city table
SELECT COUNT(name) FROM city; --TELLS YOU HOW MANY ROWS THERE ARE b/c every row has a name (WOULD BE DIFFERENT IF THERE WERE NULLS)

-- Average Life Expectancy in the World
SELECT AVG(lifeexpectancy) AS average_life_expectancy_in_world
FROM country;

-- Total population in Ohio
SELECT SUM(population) AS total_population_Ohio --if you use an aggregator, you can't SELECT something that's not aggregated
FROM city
WHERE district = 'Ohio';

-- The surface area of the smallest country in the world
SELECT MIN(surfacearea) FROM country;

-- The number of countries who declared independence in 1991
SELECT COUNT(name) 
FROM country
WHERE indepyear = 1991;

-- Gets the SUM of the population field in the city table, as well as
-- the AVG population, and a COUNT of the total number of rows.
SELECT SUM(population), round(AVG(population), 2), COUNT(name) --round syntax is round(valueToBeRounded, numberOfDecimalPlaces)
FROM city;

-- Gets the MIN population and the MAX population from the city table.
SELECT MIN(population), MAX(population)
FROM city;

-- GROUP BY

-- Using a GROUP BY with aggregate functions allows us to summarize information for a specific column. For instance, we are able to determine the MIN and MAX population for each countrycode in the city table.
SELECT countrycode, MIN(population), MAX(population)
FROM city
GROUP BY countrycode; --by adding a group by, we can now see a countrycode associated with each min/max aggregate

-- Count the number of countries where each language is spoken, ordered from most countries to least
SELECT language, COUNT(countrycode) AS country_count
FROM countrylanguage
GROUP BY language
ORDER BY country_count DESC;

-- Count the number of official languages and the number of unofficial languages per country
SELECT countrycode, isofficial, COUNT(language)
FROM countrylanguage
GROUP BY countrycode, isofficial
ORDER BY countrycode;

-- Average life expectancy of each continent ordered from highest to lowest
SELECT continent, AVG(lifeexpectancy) AS avg_life_expectancy
FROM country
WHERE lifeexpectancy IS NOT NULL
GROUP BY continent
ORDER BY avg_life_expectancy DESC;

-- Exclude Antarctica from consideration for average life expectancy

-- Sum of the population of cities in each state in the USA ordered by state name
SELECT district, SUM(population) AS total_population
FROM city
WHERE countrycode = 'USA'
GROUP BY district
ORDER BY district;

-- The average population of cities in each state in the USA ordered by state name
SELECT district AS state, round(AVG(population)) AS average_population --can round without specifying a number of decimals to round to nearest integer
FROM city
WHERE countrycode = 'USA'
GROUP BY district
HAVING AVG(population) > 300000 --only shows states that have avg population greater than 300000 (allows you to group by an aggregated data set
ORDER BY district;


-- SUBQUERIES
-- Find the names of cities under a given government leader
SELECT name
FROM city
WHERE countrycode IN (SELECT code FROM country WHERE headofstate = 'Elisabeth II'); --A QUERY IN A QUERY (when referencing multiple tables) 



-- Find the names of cities whose country they belong to has not declared independence yet
SELECT name
FROM city
WHERE countrycode IN (SELECT code FROM country WHERE indepyear IS NULL);



















