using Ecommerce.DAO;
using Ecommerce.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Ecommerce.Controllers
{
    public class ProdutoVendaController : Controller
    {
        // GET: ProdutoVenda
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult Listar() {
            ViewBag.C = ProdutoVendaDAO.Carrinho;
            foreach (ProdutoVenda item in ProdutoVendaDAO.Carrinho)
            {
                ViewBag.Prec += item.Produtos.Preco * item.Quantidade;   
            }
            return View();
        }

        public ActionResult AddCarrinho(int Qtd, Produto p)
        {
            ProdutoDAO pdao = new ProdutoDAO();
            if (pdao.BuscarPorId(p.Id) != null)
            {
                ProdutoVenda pv = new ProdutoVenda()
                {
                    Produtos = pdao.BuscarPorId(p.Id),
                    Quantidade = Qtd
                };

                foreach (ProdutoVenda item in ProdutoVendaDAO.Carrinho)
                {
                    if (pv.Produtos.Id == item.Produtos.Id)
                    {
                        pv.Quantidade += item.Quantidade;
                        ProdutoVendaDAO.Carrinho.Remove(item);
                        break;
                    }
                }
                ProdutoVendaDAO.Carrinho.Add(pv);
                ViewBag.C = ProdutoVendaDAO.Carrinho;
                return View();
            }
            else
            {
                return RedirectToAction("Erro");
            }

        }
    }
}