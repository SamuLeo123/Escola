using Ecommerce.DAO;
using Ecommerce.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Ecommerce.Controllers
{
    public class ProdutoController : Controller
    {
        // GET: Produto
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult Form()
        {
            Produto p = new Produto();
            ViewBag.Produto = p;
            ViewBag.Class = "";
            return View();
        }

        [HttpPostAttribute]
        public ActionResult Adicionar(Produto produto)
        {
            if (ModelState.IsValid)
            {
                ProdutoDAO dao = new ProdutoDAO();
                dao.Adicionar(produto);
                return RedirectToAction("Listar");
            }
            else
            {
                ViewBag.Produto = produto;
                ViewBag.Class = "alert alert-danger";
                return View("Form");
            }
            
        }

        public ActionResult Listar()
        {
            ProdutoDAO dao = new ProdutoDAO();
            ViewBag.Prods = dao.ProdutoToList();
            return View();
        }

        public ActionResult Detalhes(int Id)
        {
            ProdutoDAO dao = new ProdutoDAO();
            ViewBag.Prod = dao.BuscarPorId(Id);
            return View();
        }
    }
}