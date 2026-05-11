function calcularDesconto(preco: number, percDesconto: number) {
  const desconto: number = (preco * percDesconto)/100;
  return desconto;
}

const p: number = 100;
const perc: number = 10;

console.log(`Preço: ${p}, Desconto: ${perc}%`);
console.log(`${calcularDesconto(p, perc)} reais de desconto.`);
