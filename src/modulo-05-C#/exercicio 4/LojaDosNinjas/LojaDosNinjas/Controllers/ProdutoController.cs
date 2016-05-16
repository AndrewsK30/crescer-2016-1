using LojaNinja.Dominio;
using LojaNinja.MVC.Models;
using LojaNinja.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace LojaNinja.MVC.Controllers
{
    public class ProdutoController : Controller
    {
        private RepositorioVendas repositorio = new RepositorioVendas();
        // GET: Produto
        public ActionResult Index()
        {
            return View();
        }
        public ActionResult CadastrarProduto(int? id)
        {

            if (id.HasValue)
            {
                var pedido = repositorio.ObterPedidoPorId(id.Value);

                var model = new ProdutoModel()
                {
                    Id = pedido.Id,
                    DataEntrega = pedido.DataEntregaDesejada,
                    NomeCliente = pedido.NomeCliente,
                    Nome = pedido.NomeProduto,
                    ValorVenda = pedido.Valor,
                    Pagamento = pedido.TipoDePagamento,
                    Cidade = pedido.Cidade,
                    Estado = pedido.Estado

                };

                return View("CadastrarProduto", model);
            }
            else
            {
                return View("CadastrarProduto");
            }
        }

        public ActionResult SalvarProduto(ProdutoModel model)
        {
            if (ModelState.IsValid)
            {
                try
                {
                    var pedido = new Pedido(model.Id.GetValueOrDefault(), model.DataEntrega, model.Nome, model.ValorVenda, model.Pagamento, model.NomeCliente, model.Cidade, model.Estado);

                    if (model.Id.HasValue)
                    {
                        repositorio.AtualizarPedido(pedido);
                        ViewBag.Mensagem = "Atualizado com sucesso";
                    }
                    else
                    {
                        repositorio.IncluirPedido(pedido);
                        ViewBag.Mensagem = "Salvo com sucesso";                        
                    }
                    return View("Sucesso");
                }
                catch (ArgumentException ex)
                {
                    ModelState.AddModelError("", ex.Message);
                    return View("CadastrarProduto", model);
                }
                
            }
            else
            {
                return View("CadastrarProduto", model);
            }

        }
        public ActionResult Listagem(string cliente, string produto)
        {
            var pedidos = repositorio.ObterPedidos();
            if (!string.IsNullOrEmpty(cliente))
                pedidos = pedidos.Where(x => x.NomeCliente.ToLower() == cliente.ToLower()).ToList();
            if (!string.IsNullOrEmpty(produto))
                pedidos = pedidos.Where(x => x.NomeProduto.ToLower() == produto.ToLower()).ToList();
            return View(pedidos);
        }
        public ActionResult Excluir(int id)
        {
            repositorio.ExcluirPedido(id);
            ViewBag.Mensagem = "Excluido com sucesso";
            return View("Sucesso");
        }
        public ActionResult Detalhes(int id)
        {
            var pedido = repositorio.ObterPedidoPorId(id);

            return View(pedido);
        }
    }
}