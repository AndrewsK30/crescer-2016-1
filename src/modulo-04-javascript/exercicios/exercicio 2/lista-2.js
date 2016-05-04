'use strict'
Number.prototype.precisaoDeDois = function () {
    return Math.round(this * 100) / 100;
}

Number.prototype.lbParaKg = function () {
    return this * 0.4536;
}

Number.prototype.cmParaM = function () {
    return this * 0.01;
}

Array.prototype.filtroSemPeso = function () {
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
        , meses = ["Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"]
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
    }) / goldSaints.length).cmParaM().precisaoDeDois();
}

function obterAlturaMediana() {
    var goldSaintsOrdenados = goldSaints.concat().sort(function (a, b) {
        return a.alturaCm - b.alturaCm;
    });
    var itemDoMeio = goldSaintsOrdenados.length / 2;
    return ((goldSaintsOrdenados[itemDoMeio].alturaCm + goldSaintsOrdenados[itemDoMeio - 1].alturaCm) / 2).cmParaM().precisaoDeDois();
}

function obterPesoMedio(cavaleiros) {
    var arrayOrdenadoFiltrado = (cavaleiros || goldSaints).filtroSemPeso().map(function (item) {
        return item.pesoLb;
    });

    return (arrayOrdenadoFiltrado.reduce(function (x, y) {
        return x + y;
    }) / arrayOrdenadoFiltrado.length).lbParaKg().precisaoDeDois();
}

function obterPesoMedioDoadores() {
    return obterPesoMedio(obterDoadores());
}

function obterIMC() {
    return goldSaints.filtroSemPeso().map(function (item) {
        return ((item.pesoLb.lbParaKg()) / Math.pow(item.alturaCm.cmParaM(), 2)).precisaoDeDois();
    });
}

function obterSobrepeso() {
    var arrayIMC = obterIMC();
    return goldSaints.filtroSemPeso().filter(function (item, index) {
        return arrayIMC[index] >= 25 && arrayIMC[index] < 30;
    });
}
//extra
function gerarPalavras(obj) {
    function combinacaoletras(array) {
        var retorno = [];
        for (var i = 0; i < array.length; i++)
            for (var j = 0; j < array.length; j++)
                for (var k = 0; k < array.length; k++) {
                    if (i !== j && i !== k && j !== k)
                        retorno.push(array[i] + array[j] + array[k]);
                }
        return retorno.sort();
    }


    var arrayLetras = '';
    for (var campo in obj) {
        for (var i = 0; i < obj[campo].length; i++) {
            arrayLetras += obj[campo][i].repeat(campo);
        }
    }
    arrayLetras = arrayLetras.split("");
    return combinacaoletras(arrayLetras);

}