'use strict'
function daisyGame(petalas){
    return petalas%2 ? 'Love me' : 'Love me not';
}

function maiorTexto(array){
    var maior = array[0];
    for (var i = 1 ; i < array.length ; i++) {
        if (maior.length < array[i].length){
            maior = array[i];
        }
    }
    return maior;
}

function imprime(array, fn){
    if(!(typeof fn ==='function'))return;
    array.forEach(function(item){
         fn(item);
    });
}

function adicionar(x){
    return function(y){
        return x+y;
    };   
}
//https://www.quora.com/What-is-the-sum-of-n-terms-of-a-Fibonacci-series
//Ultimo comentário.
function fiboSum(n) {
    if(n<=1) return 0|n;
    var raizDe5 = Math.sqrt(5),
        nMais2 = n+2,
        dividendo = Math.pow(1+raizDe5,nMais2)-Math.pow(1-raizDe5,nMais2),
        divisor = Math.pow(2,nMais2)*raizDe5;    
    return  (dividendo/divisor)-1;
}

function queroCafe(mascada,precos){
    return precos.filter(function(valor){
                return valor <= mascada;
           }).sort().toString();    
}

function contarPorTipo(obj,tipo){
    function qualTipo(v) {
        return v === null ? 'null' : typeof v !== 'undefined' && v.constructor === Array ? 'array' : typeof v;
    }
    var contador = 0;
    for (var campo in obj) {
        if (qualTipo(obj[campo]) === tipo) contador++;
    }
  return contador;
}


/* * Variaveis locais sempre tem prioridade do que as globais.
   * Definição de "hoisting"- por padrão o javascript leva todas as declarações para o topo do escopo atual(No topo do script ou da função).
   * Então concluido, na função revelarSaiyaman gohan é levado acima por ser variavel local, e não é definida até a linha 68, ou seja , fica undefined.
     goku (variável global) recebe 'Son Goku', e a variável local gohan recebe  'Son' + undefined, e retorna para onde foi chamado.

*/
var gohan = 'gohan', goku = 'Goku';
function revelarSaiyaman() {
  console.log(gohan);
  goku = 'Son Goku';
  var gohan = 'Son ' + gohan;
  return gohan;
}
console.log(revelarSaiyaman());
console.log(goku);