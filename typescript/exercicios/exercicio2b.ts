interface Produto {
  name: string;
  preco: number;
  emEstoque: boolean;
}

const p: Produto = {name: "Lápis", preco:10.0};
console.log(`${p.name}, ${p.preco}}`);
