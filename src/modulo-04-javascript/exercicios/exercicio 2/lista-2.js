'use strict'

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
    var contador = {};
    goldSaints.forEach(function (obj) {
        var mes = new Date(obj.dataNascimento).getMonth();
        contador[mes] = (contador[mes] || 0) + 1;
    })
    return Math.max.apply(null, Object.keys(contador).map(function (campo) {
        return obj[campo];
    }));
}