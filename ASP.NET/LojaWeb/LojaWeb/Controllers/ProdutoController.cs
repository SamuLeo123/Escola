using LojaWeb.DAO;
using LojaWeb.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.UI;

namespace LojaWeb.Controllers
{
    public class ProdutoController : Controller
    {
        // GET: Produto
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult FormProd() {
            //ProdutoDAO pdao = new ProdutoDAO();
            //IList<Produto> produtos = pdao.ListarProduto();
            CategoriaProdutoDAO dao = new CategoriaProdutoDAO();
            ViewBag.cat = dao.ListarCategorias();
            ViewBag.Produto = new Produto();
            ViewBag.Class = null;
            return View(/*produtos*/);
        }

        [HttpPostAttribute]
        public ActionResult Adicionar(Produto produto) {
            int idSUV = 1;
            if (produto.CategoriaID.Equals(idSUV) && produto.Preco < 20000)
            {
                ModelState.AddModelError("produto.SUVValor", "SUV deve custar mais de R$20.000");
            }
            if (ModelState.IsValid)
            {
                ProdutoDAO dao = new ProdutoDAO();
                dao.Adicionar(produto);
                return View();
            }
            else
            {
                CategoriaProdutoDAO dao = new CategoriaProdutoDAO();
                ViewBag.cat = dao.ListarCategorias();
                ViewBag.Class = "alert alert-danger";
                ViewBag.Produto = produto;
                return View("FormProd"); /*Caso use este precisa da lista*/
                //return RedirectToAction("FormProd");
            }

        }

        public ActionResult Buscar()
        {
            ProdutoDAO dao = new ProdutoDAO();
            IList<Produto> produtos = dao.ListarProduto();
            ViewBag.produtos = produtos;
            return View();
        }

        public ActionResult Visualiza(int id)
        {
            ProdutoDAO dao = new ProdutoDAO();
            Produto prod = dao.BuscaId(id);
            ViewBag.Produto = prod;
            return View(/*prod*/);
        }

        public ActionResult Editar(int id)
        {
            ProdutoDAO dao = new ProdutoDAO();
            IList <Produto> prods = dao.ListarProdutoId(id);
            ViewBag.prods = prods;
            return View();
        }

        public ActionResult Atualizar(Produto produto)
        {
            ProdutoDAO dao = new ProdutoDAO();
            Produto Vprod = dao.BuscaId(produto.Id);
            Vprod.Nome = produto.Nome;
            Vprod.Descricao = produto.Descricao;
            Vprod.Preco = produto.Preco;
            Vprod.Quantidade = produto.Quantidade;
            Vprod.CategoriaID = produto.CategoriaID;
            dao.Atualizar();
            return View();
        }

        public ActionResult Remover(int id)
        {
            ProdutoDAO dao = new ProdutoDAO();
            Produto prod = dao.BuscaId(id);
            dao.Remover(prod);
            return RedirectToAction("Buscar");
        }
    }
}