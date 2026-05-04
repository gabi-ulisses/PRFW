async function getProdutos(){
	const response = await fetch('http://localhost:8080/api/produto');
	
	if (response.ok) {
		const data = await response.json();
		return data;
	} else {
		console.error('Erro ao chamar endpoint');
	}
	
	return null;
	
}

function buildTable(data) {
	const template = document.querySelector('#table-row');
	const tbody  = document.querySelector('#table-produtos > tbody');

	for (let row of data) {
		let newRow = template.content.cloneNode(true);
		let td = newRow.querySelectorAll('td');
		td[0].textContent = row.id;
		td[1].textContent = row.descricao;
		td[2].textContent = row.preco;

		tbody.appendChild(newRow);
	}
	
}


async function onCarregarProdutos() {
	const data = await getProdutos();
	if (data) {
		buildTable(data);
	}
}

function init() {
	const btn = document.querySelector('#btn-carregar');
	btn.addEventListener('click', onCarregarProdutos);
}
init();

