console.log('Outro script!!!');
console.log(hello);
//var somar (a,b) => a + b

function somar(a,b){
    return a + b;
}
var sub = function (a,b,fn){
    fn(a-b);
};

var funcoes = [ somar(1,1), sub];

funcoes[1](3,2,function (res){
    console.log('O resultado é : ', res);
});
console.log('sdsd');