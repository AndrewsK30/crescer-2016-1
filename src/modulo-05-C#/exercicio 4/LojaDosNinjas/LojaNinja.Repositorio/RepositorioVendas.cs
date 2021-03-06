﻿using LojaNinja.Dominio;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LojaNinja.Repositorio
{
    public class RepositorioVendas
    {
        //TODO:Refactory nas classes.
        private string PATH_ARQUIVO = @"C:\Users\Andrews\Documents\crescer-2016-1\src\modulo-05-C#\exercicio 4\LojaDosNinjas\vendas.txt";
        //private string PATH_ARQUIVO = @"C:\Users\andrews.silva\Documents\crescer-2016-1\src\modulo-05-C#\exercicio 4\LojaDosNinjas\vendas.txt";
        private static readonly object objetoLock = new object();

        private List<string> ObterDados()
        {
            return File.ReadAllLines(PATH_ARQUIVO, Encoding.UTF8).ToList();
        }
        public List<Pedido> ObterPedidos(string cliente = null, string produto = null)
        {
            var linhasArquivo = ObterDados();
            var linhasConvertidas = ConverteLinhasEmPedidos(linhasArquivo);
            if (!string.IsNullOrEmpty(cliente))
                linhasConvertidas = linhasConvertidas.Where(x => x.NomeCliente.ToLower() == cliente.ToLower()).ToList();
            if (!string.IsNullOrEmpty(produto))
                linhasConvertidas = linhasConvertidas.Where(x => x.NomeProduto.ToLower() == produto.ToLower()).ToList();
            return linhasConvertidas;
        }

        public Pedido ObterPedidoPorId(int id)
        {
            return this.ObterPedidos().FirstOrDefault(x => x.Id == id);
        }

        public void IncluirPedido(Pedido pedido)
        {
            lock (objetoLock)
            {
                var utlimoId = this.ObterPedidos().Max(x => x.Id);
                var idGerado = utlimoId + 1;
                var novaLinha = ConvertePedidoEmLinhaCSV(pedido, idGerado,true);

                File.AppendAllText(PATH_ARQUIVO, novaLinha);

                pedido.AtualizarId(idGerado);
            }
        }

        private string ConvertePedidoEmLinhaCSV(Pedido pedido, int proximoId,bool precisaNovaLinha)
        {
            var novaLinha= precisaNovaLinha ? Environment.NewLine:"";
            return string.Format(novaLinha + "{0};{1};{2};{3};{4};{5};{6};{7};{8};{9}",
                                proximoId,
                                pedido.DataPedido.ToString("dd/MM/yyyy"),
                                pedido.DataEntregaDesejada.ToString("dd/MM/yyyy"),
                                pedido.NomeProduto,
                                pedido.Valor,
                                pedido.TipoDePagamento,
                                pedido.NomeCliente,
                                pedido.Cidade,
                                pedido.Estado,
                                pedido.PedidoUrgente);
        }

        public void AtualizarPedido(Pedido pedido)
        {
            string linha;
            string IdDoPedido = pedido.Id.ToString();
            using (StreamReader reader = new StreamReader(PATH_ARQUIVO))
            {
                linha = reader.ReadLine();
                while ((linha = reader.ReadLine()) != null)
                {                 
                    if (linha.Split(';')[0] == IdDoPedido)
                        break;


                }
            }
            var g = File.ReadAllText(PATH_ARQUIVO);
            var gReplace = g.Replace(linha, ConvertePedidoEmLinhaCSV(pedido, pedido.Id,false));
            File.WriteAllText(PATH_ARQUIVO, gReplace);

        }

        public void ExcluirPedido(int id)
        {
            string idString = id.ToString();
            var linhas = ObterDados().Where(linha => linha.Split(';')[0] != idString).ToList();
            File.WriteAllText(PATH_ARQUIVO, string.Join("\n", linhas.ToArray()));

        }

        private List<Pedido> ConverteLinhasEmPedidos(List<string> linhasArquivo)
        {
            var listaPedidos = new List<Pedido>();

            //Remove linha do cabeçalho
            linhasArquivo.RemoveAt(0);

            foreach (var linha in linhasArquivo)
            {
                var id = Convert.ToInt32(linha.Split(';')[0]);
                var dataPedido = Convert.ToDateTime(linha.Split(';')[1]);
                var dataEntregaDesejada = Convert.ToDateTime(linha.Split(';')[2]);
                var nomeProduto = linha.Split(';')[3];
                var valorVenda = Convert.ToDecimal(linha.Split(';')[4]);
                TipoPagamento tipoPagamento;
                Enum.TryParse(linha.Split(';')[5], out tipoPagamento);
                var nomeCliente = linha.Split(';')[6];
                var cidade = linha.Split(';')[7];
                var estado = linha.Split(';')[8];
                var urgente = Convert.ToBoolean(linha.Split(';')[9]);

                var pedido = new Pedido(id, dataPedido, dataEntregaDesejada, nomeProduto, valorVenda, tipoPagamento, nomeCliente, cidade, estado, urgente);
                listaPedidos.Add(pedido);
            }

            return listaPedidos;
        }
    }
}
