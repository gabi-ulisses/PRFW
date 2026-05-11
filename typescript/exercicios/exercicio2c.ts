interface Produto {
  name: string;
  preco: number;
  emEstoque: boolean;
}

class ItemCarrinho {
  name: string;
  preco: number;
  emEstoque: boolean;

  constructor(name: string, preco: number, emEstoque: boolean) {
    this.name = name;
    this.preco = preco;
    this.emEstoque = emEstoque;
  }

}

const item: Produto = new ItemCarrinho("Lápis", 10.0, true);

console.log(`${item.name}, ${item.preco}, ${item.emEstoque}`);

