using Ecommerce.DAO;
using Ecommerce.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Ecommerce.Controllers
{
    public class HomeController : Controller
    {
        // GET: Home
        public ActionResult Index()
        {
            ViewBag.Login = "";
            return View();
        }

        public ActionResult Login(Funcionario funcionario)
        {
            FuncionarioDAO dao = new FuncionarioDAO();
            Funcionario f = dao.Login(funcionario);
            if (!(f.Login == "" || f.Id ==0 ))
            {
                Session["_Id"] = f.Id;
                Session["_User"] = f.Login;
                Session["_NomeUser"] = f.Nome;
                return RedirectToAction("HomePage");
            }
            else
            {
                ModelState.AddModelError("funcionario.LoginError", "Nome ou Senha incorretos");
                ViewBag.Login = funcionario.Login;
                return View("Index");
            }
        }

        public ActionResult HomePage()
        {
            return View();
        }

        public ActionResult Logout()
        {
            Session["_Id"] = 0;
            Session["_User"] = "";
            Session["_NomeUser"] = "";
            return RedirectToAction("Index");
        }

        public ActionResult Relatorio()
        {
            return View();
        }
    }
}