// @ts-nocheck

const itemList = document.getElementById('colors'); //setting the event listener one level above the list items so that even when new items are added to the list, the parent still hears the click and can trigger the response
itemList.addEventListener('click', event => {
	event.target.style.backgroundColor = event.target.innerText;
 //target is the thing that gets clicked on - target is not always the same thing that has event listener attached
});//allowing a parent to catch an event and then use it to do something to the child is called event delegation


function addOrange() {
	const orange = document.createElement('li');
	orange.innerText = 'Orange';
	colors.appendChild(orange);
}

document.addEventListener('DOMContentLoaded', () => {
	const button = document.getElementById('btnAddOrange');
	button.addEventListener('click', addOrange);
});