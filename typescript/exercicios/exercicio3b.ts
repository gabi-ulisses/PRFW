interface Produto {
  name: string;
  preco: number;
  emEstoque: boolean;
}

function apresentar(p: Produto){
  console.log(`${p.name}, ${p.preco}, ${p.emEstoque}`);
}

const item = {name:"Lápis", preco:10.0, emEstoque:true};
apresentar(item);
