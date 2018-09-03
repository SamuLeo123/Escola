using Ecommerce.DAO;
using Ecommerce.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Ecommerce.Controllers
{
    public class FuncionarioController : Controller
    {
        // GET: Funcionario
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult Form()
        {
            Funcionario f = new Funcionario();
            ViewBag.Sobre = "";
            ViewBag.Func = f;
            ViewBag.Class = "";
            return View();
        }

        public ActionResult Cadastrar(Funcionario funcionario, string sobre)
        {
            if (ModelState.IsValid)
            {
                funcionario.Nome = funcionario.Nome + " " + sobre;
                funcionario.DataCriacao = DateTime.Now;
                FuncionarioDAO dao = new FuncionarioDAO();
                dao.Cadastrar(funcionario);
                return RedirectToAction("Listar");
            }
            else
            {
                ViewBag.Func = funcionario;
                ViewBag.Sobre = sobre;
                ViewBag.Class = "alert alert-danger";
                return View("Form");
            }
            
        }

        public ActionResult Listar()
        {
            FuncionarioDAO dao = new FuncionarioDAO();
            ViewBag.Funcs = dao.ListarFuncionarios();
            return View();
        }

        public ActionResult Detalhes(int Id)
        {
            FuncionarioDAO dao = new FuncionarioDAO();
            ViewBag.Func = dao.BuscarFuncId(Id);
            return View();
        }
    }
}