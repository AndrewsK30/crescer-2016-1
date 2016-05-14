using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LojaNinja.Dominio
{
    public class Pedido
    {

        public int Id { get; private set; }
        public DateTime DataPedido { get; private set; }
        public DateTime DataEntregaDesejada { get; private set; }
        public string NomeProduto { get; private set; }
        public decimal Valor { get; private set; }
        public TipoPagamento TipoDePagamento { get; private set; }
        public string NomeCliente { get; private set; }
        public string Cidade { get; private set; }
        public string Estado { get; private set; }
        public bool PedidoUrgente { get; private set; }
        /// <summary>
        /// Construtor utilizado para montar pedidos novos
        /// </summary>
        public Pedido(int id, DateTime dataEntregaDesejada, string nomeProduto, decimal valor, TipoPagamento tipoPagamento, string nomeCliente, string cidade, string estado)
        {
            DataEntregaDesejada = dataEntregaDesejada;
            NomeProduto = nomeProduto;
            Valor = valor;
            TipoDePagamento = tipoPagamento;
            NomeCliente = nomeCliente;
            Cidade = cidade;
            Estado = estado;
            Id = id;

            //DateTime.Now contaria as horas, minutos e segundos, isso inviabliziaria algumas validações a seguir
            DataPedido = DateTime.Today;

            var diasRestantesParaConcluirEntrega = (dataEntregaDesejada - DataPedido).TotalDays;
            ValidaPossibilidadeEntrega(diasRestantesParaConcluirEntrega);
            DefineUrgenciaDoPedido(diasRestantesParaConcluirEntrega);
        }

        /// <summary>
        /// Construtor utilizado para montar pedidos recuperados do repositório
        /// </summary>
        public Pedido(int id, DateTime dataPedido, DateTime dataEntregaDesejada, string nomeProduto, decimal valor, TipoPagamento tipoPagamento, string nomeCliente, string cidade, string estado, bool pedidoUrgente)
        {
            Id = id;
            DataEntregaDesejada = dataEntregaDesejada;
            NomeProduto = nomeProduto;
            Valor = valor;
            TipoDePagamento = tipoPagamento;
            NomeCliente = nomeCliente;
            Cidade = cidade;
            Estado = estado;
            DataPedido = dataPedido;
            PedidoUrgente = pedidoUrgente;
        }
     

        private void ValidaPossibilidadeEntrega(double diasRestantesParaConcluirEntrega)
        {
            if (diasRestantesParaConcluirEntrega < 1)
                throw new ArgumentException("A data de entrega desejada deve ser no mínimo 1 dia maior do que a data atual.");
        }

        private void DefineUrgenciaDoPedido(double diasRestantesParaConcluirEntrega)
        {
            PedidoUrgente = diasRestantesParaConcluirEntrega < 7;
        }

        public void AtualizarId(int id)
        {
            if (Id != 0)
                throw new InvalidOperationException("Esse objeto já possuia Id, portanto ele já havia sido salvo no banco. Não é possível alterar esse valor.");

            Id = id;
        }
    }
}
