using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Ecommerce.DAO;
using Ecommerce.Models;

namespace Ecommerce.Controllers
{
    public class ClienteController : Controller
    {
        // GET: Cliente
        public ActionResult Index()
        {
            return View();
        }
    

        public ActionResult Listar() {
            ClienteDAO dao = new ClienteDAO();
            ViewBag.Clientes = dao.ListarClientes();
            return View();
        }

        public ActionResult Form()
        {
            Cliente c = new Cliente();
            ViewBag.Sobre = "";
            ViewBag.Cli = c;
            ViewBag.Class = "";
            return View();
        }

        public ActionResult Cadastrar(Cliente cliente, string sobre)
        {
            if (ModelState.IsValid)
            {
                cliente.Nome = cliente.Nome + " " + sobre;
                cliente.DataCriacao = DateTime.Now;
                ClienteDAO dao = new ClienteDAO();
                dao.Cadastrar(cliente);
                return RedirectToAction("Listar");
            }
            else
            {
                ViewBag.Func = cliente;
                ViewBag.Sobre = sobre;
                ViewBag.Class = "alert alert-danger";
                return View("Form");
            }

        }

        public ActionResult Detalhes(int id)
        {
            ClienteDAO dao = new ClienteDAO();
            ViewBag.Cli = dao.BuscarCliCPF(id);
            return View();
        }
    }
}