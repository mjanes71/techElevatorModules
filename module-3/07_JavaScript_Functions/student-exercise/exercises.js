/**
 *1)  Write a function called isAdmitted. It will check entrance
 * scores and return true if the student is admitted and
 * false if rejected. It takes three parameters:
 *
 *     * gpa
 *     * satScore (optional)
 *     * recommendation (optional)
 *
 * Admit them--return true--if:
 * gpa is above 4.0 OR
 * SAT score is above 1300 OR
 * gpa is above 3.0 and they have a recommendation OR
 * SAT score is above 1200 and they have a recommendation
 * OTHERWISE reject it
 *
 * @param {number} gpa the GPA of the student, between 4.2 and 1.0
 * @param {number} [satScore=0] the student's SAT score
 * @param {boolean} [recommendation=false] does the student have a recommendation
 * @returns {boolean} true if they are admitted
 */
function isAdmitted(gpa, satScore = 0, recommendation = false) {
    return gpa > 4.0 || satScore > 1300 || (gpa > 3.0 && recommendation) || (satScore > 1200 && recommendation);
}

/**
 *2)  Write a function called useParameterToFilterArray that takes an anonymous
 * function and uses that in the `unfilteredArray` filter function. Return the result.
 *
 * @param {function} filterFunction the function to filter with
 * @returns {number[]} the filtered array
 */
function useParameterToFilterArray(filterFunction) {
    let unfilteredArray = [1, 2, 3, 4, 5, 6];
    return unfilteredArray.filter(n => filterFunction(n));
}


/**
 * 3) Write a function called makeNumber that takes two strings
 * of digits, concatenates them together, and returns
 * the value as a number.
 *
 * So if two strings are passed in "42293" and "443", then this function
 * returns the number 42293443.
 *
 * @param {string} first the first string of digits to concatenate
 * @param {string} [second=''] the second string of digits to concatenate
 * @returns {number} the resultant number
 */

function makeNumber(first, second = '') {
    let str = `${first}${second}`;
    return Number(str);
}



/**
 * 4) Write a function called addAll that takes an unknown number of parameters
 * and adds all of them together. Return the sum.
 *
 * @param {...number} num a series of numbers to add together
 * @returns {number} the sum of all the parameters (or arguments)
 */

function addAll(...num) {
    let counter = 0;
    for (let i = 0; i < num.length; i++) {
        counter += num[i];
    }
    return counter;
}

/*
 * 5) Write and document a function called makeHappy that takes
 * an array and prepends 'Happy ' to the beginning of all the
 * words and returns them as a new array. Use the `map` function.
 */

/**
 * A function to make all the phrases in an array a bit happier
 * @param {string[]} arr word or phrases that need to be happified
 * @returns {string[]} all words predicated by happy
 */
function makeHappy(arr) {
    return arr.map(n => `Happy ${n}`);
}

/*
 * 6) Write and document a function called getFullAddressesOfProperties
 * that takes an array of JavaScript objects containing the
 * following keys:
 *     * streetNumber
 *     * streetName
 *     * streetType
 *     * city
 *     * state
 *     * zip
 *
 * and returns an array of strings that turns the JavaScript objects
 * into a mailing address in the form of:
 *     streetNumber streetName streetType city state zip
 *
 * Use `map` and an anonymous function.
 */
/**
 * Creating addresses for address labels for the Creepers-R-Us webpage display table
 * @param {object[]} arrOfObjects  array of objects containing the following keys: 
 *     *streetNumber
 *     * streetName
 *     * streetType
 *     * city
 *     * state
 *     * zip
 * @returns {string[]} A list of formatted address as an array of strings
 */
function getFullAddressesOfProperties(arrOfObjects) {
    return arrOfObjects.map(obj => `${obj.streetNumber} ${obj.streetName} ${obj.streetType} ${obj.city} ${obj.state} ${obj.zip}`);

}

/*
 * 7) Write and document a function called findLargest.
 *
 * Using `forEach`, find the largest element in an array.
 * It must work for strings and numbers.
 */

/**
 * Function to look through a list of values and find the largest one... FOR SCIENCE
 * @param {number[]} arr numbers randomly arranged, can also take a string[]
 * @returns {number} the largest value in the array as a number or a string
 */
function findLargest(arr) {
    let largest = arr[0];
    arr.forEach(item => {
        if (item > largest) {
            largest = item;
        }
    });
    return largest;
}

/*
 * CHALLENGE
 * 8) Write and document a function called getSumOfSubArrayValues.
 *
 * Take an array of arrays, adds up all sub values, and returns
 * the sum. For example, if you got this array as a parameter:
 * [
 *   [1, 2, 3],
 *   [2, 4, 6],
 *   [5, 10, 15]
 * ];
 *
 * The function returns 48. To do this, you will use two nested `reduce`
 * calls with two anonymous functions.
 *
 * Read the tests to verify you have the correct behavior.
 */

/**
 * A function that helps Joe figure out our total points from every module and every assignment in those modules
 * @param {Array[]} arr Lists of numbers as arrays
 * @returns {number} the sum of every number from all arrays
 */
function getSumOfSubArrayValues(arr = []) {
    return arr.reduce((sum, arrItem) => sum + (arrItem.reduce((total, num) => total + num)), 0);

}
