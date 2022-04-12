
let navbar = document.querySelector('.navbar')

document.querySelector('#menu-btn').onclick = () => {
	navbar.classList.toggle('active');
	searchForm.classList.remove('active');
	cartItem.classList.remove('active');
}

$('select[data-value]').each(function(index, el) {
	const $el = $(el);

	const defaultValue = $el.attr('data-value').trim();

	if (defaultValue.length > 0) {
		$el.val(defaultValue);
	}

});
