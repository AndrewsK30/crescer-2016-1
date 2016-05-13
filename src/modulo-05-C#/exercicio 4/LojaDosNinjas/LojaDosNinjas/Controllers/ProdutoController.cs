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
        public ActionResult CadastrarProduto(int? id)
        {

            if (id.HasValue)
            {
                var pedido = repositorio.ObterPedidoPorId(id.Value);

                var model = new ProdutoModel()
                //{
                //    Id = pedido.Id,
                //    DataEntrega = pedido.DataEntregaDesejada,
                //    NomeCliente = pedido.NomeCliente,
                //    //...
                //}
                ;

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
                    var pedido = new Pedido(model.DataEntrega, model.Nome, model.ValorVenda, model.Pagamento, model.NomeCliente, model.Cidade, model.Estado);

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
                    return View("Sucesso", model);
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

            return View(pedidos);
        }
        public ActionResult Detalhes(int id)
        {
            var pedido = repositorio.ObterPedidoPorId(id);

            return View(pedido);
        }
    }
}