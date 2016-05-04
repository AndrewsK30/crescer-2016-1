'use strict'
Number.prototype.precisaoDeDois = function () {
    return Number(this.toFixed(2));
}

Array.prototype.filtroSemPeso = function (){
    return this.filter(function (item) {
        return 'pesoLb' in item
    });
}

function obterDoadores() {
    return goldSaints.filter(function (obj) {
        return obj.tipoSanguineo === 'O';
    });
}

function obterCavaleiroComMaisGolpes() {
    var maisGolpes = goldSaints[0];
    for (var i = 1; i < goldSaints.length; i++) {
        if (maisGolpes.golpes.length <= goldSaints[i].golpes.length)
            maisGolpes = goldSaints[i];
    }
    return maisGolpes;
}

function obterMesesComMaisAniversarios() {
    var contador = {}
        , meses = ["Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho"


            
            , "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"]
        , retorno = [];
    goldSaints.forEach(function (obj) {
        var mes = new Date(obj.dataNascimento).getMonth();
        contador[mes] = (contador[mes] || 0) + 1;
    })
    var maior = Math.max.apply(Math, Object.keys(contador).map(function (campo) {
        return contador[campo];
    }));

    Object.keys(contador).filter(function (campo) {
        return contador[campo] === maior;
    }).forEach(function (item) {
        retorno.push(meses[item]);
    });
    return retorno;
}

function obterAlturaMedia() {
    return (goldSaints.map(function (item) {
        return item.alturaCm;
    }).reduce(function (x, y) {
        return x + y;
    }) / (goldSaints.length * 100)).precisaoDeDois();
}

function obterAlturaMediana() {
    return (function () {
        var metade = Math.floor(goldSaints.length / 2)
            , arrayOrdenado = goldSaints.map(function (item) {
                return item.alturaCm;
            }).sort(function (x, y) {
                return x - y;
            });
        return (arrayOrdenado.length % 2 ? arrayOrdenado[metade] :
            (arrayOrdenado[metade - 1] + arrayOrdenado[metade]) / 2.0) / 100;
    })().precisaoDeDois();
}

function obterPesoMedio() {
    var arrayOrdenadoFiltrado = goldSaints.filtroSemPeso().map(function (item) {
        return item.pesoLb;
    });

    return ((arrayOrdenadoFiltrado.reduce(function (x, y) {
        return x + y;
    }) / arrayOrdenadoFiltrado.length) * 0.4536).precisaoDeDois();
}

function obterPesoMedioDoadores() {
    var arrayOrdenadoFiltrado = obterDoadores().filtroSemPeso().map(function (item) {
        return item.pesoLb;
    })


    return ((arrayOrdenadoFiltrado.reduce(function (x, y) {
        return x + y;
    }) / arrayOrdenadoFiltrado.length) * 0.4536).precisaoDeDois();
}

function obterIMC() {
    var listaDeImc = [];
    goldSaints.filtroSemPeso().forEach(function (item) {
        listaDeImc.push(((item.pesoLb * 0.4536) / Math.pow(item.alturaCm * 0.01, 2)).precisaoDeDois());
    });
    return listaDeImc;
}

function obterSobrepeso() {
    var arrayIMC = obterIMC();
    return goldSaints.filtroSemPeso().filter(function (item,index) {
                return arrayIMC[index] >= 25 && arrayIMC[index] <= 29.99;
           });
}