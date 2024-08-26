
highlightPage('/customer', document.querySelector('.customer-page'));


function highlightPage(pageUrl, page) {
	window.location.href.includes(pageUrl) ? page.classList.add('active') : page.classList.remove('active');

}