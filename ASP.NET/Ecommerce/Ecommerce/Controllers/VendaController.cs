using Ecommerce.DAO;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Ecommerce.Controllers
{
    public class VendaController : Controller
    {
        // GET: Venda
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult Form()
        {
            ProdutoDAO pdao = new ProdutoDAO();
            ViewBag.Prods = pdao.ProdutoToList();
            return View();
        }
    }
}