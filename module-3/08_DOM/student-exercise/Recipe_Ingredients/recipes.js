// @ts-nocheck
const allRecipes = [
    {
        dish: 'Lasagna',
        ingredients: 'pasta sheets, marinara, mozarella cheese, ricotta cheese',
        directions: 'Preheat the oven to 325 F. Layer pasta, ricotta, and marinara over and over until you run out. Then put a mess of mozarella on top and bake it until you\'re too hungry to wait any longer. Dig in!'
    },

    {
        dish: 'Peanutbutter & Jelly Sandwich',
        ingredients:'peanutbutter, jelly- not grape cuz that is nasty, bread',
        directions: 'Preheat the sandwich-maker to hot hot hot. Put peanutbutter and jelly between two slices of bread with an exact 1:2 ratio of jelly to peanutbutter. Insert into the sandwich maker so your life can be revolutionzed by melty, peanut-butter goodness.'
    },
    {
        dish: 'Fish Tacos',
        ingredients: 'trash bags, fish of any type',
        directions: 'Open the trash and throw the fish away. All of it. I SAID ALL OF IT!!'
    },
    {
        dish: 'Milk and Cookies',
        ingredients: 'Oreos. None of that nasty double stuff though., Skim milk. No one should have to chew their milk.',
        directions: 'Take a fork. Skewer your oreo right through the cream. Dip that dude in your ice cold milk. If you drop it, you must disperse a rescue party- aka: your fork, with gusto. #noOreoLeftBehind'
    },
    {
        dish: 'Cranberry Chicken',
        ingredients: 'chicken breasts, whole cranberry sauce, french dressing, powdered onion soup mix',
        directions: 'Preheat your crockpot on low. Add a crockpot liner because no one likes to clean the crockpot. Add all ingredients and go find something to tinker with for 8 hours. Probably a coding problem. Then come back and enjoy the smells. You can even eat it!'
    }
];

function displayRecipeNames(){
    const listORecipes = document.getElementById('recipe-body');

    allRecipes.forEach(recipe => {
        const template = document.getElementById('recipes-template');
        const container = template.content.cloneNode(true);
        container.getElementById('recipe-name').innerText = recipe.dish;
        container.getElementById('needed-ingredients').innerText = `Ingredients: ${recipe.ingredients}`;
        container.getElementById('recipe-directions').innerText = `Directions: ${recipe.directions}`;
        
        listORecipes.appendChild(container);
    });
}

displayRecipeNames();