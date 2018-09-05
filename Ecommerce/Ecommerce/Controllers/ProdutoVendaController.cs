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
                    ProdutoId = p.Id,
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
                return RedirectToAction("../Venda/Form");
            }
            else
            {
                return RedirectToAction("Erro");
            }

        }

        public ActionResult Carrinho()
        {
            ProdutoDAO dao = new ProdutoDAO();
            ClienteDAO cdao = new ClienteDAO();
            ViewBag.Clientes = cdao.ListarClientes();
            ViewBag.Prods = dao.ProdutoToList();
            ViewBag.Carr = ProdutoVendaDAO.Carrinho;
            double Pt = 0;
            foreach (ProdutoVenda item in ProdutoVendaDAO.Carrinho)
            {
                Pt = (item.Produtos.Preco * item.Quantidade) + Pt;
            }
            ViewBag.Prec = Pt;
            return View();
        }

        public ActionResult BuscarCPF(int Id)
        {
            ClienteDAO cdao = new ClienteDAO();
            IList<Cliente> c = cdao.BuscarClisCPF(Id);
            if (c == null)
            {
                RedirectToAction("Carrinho");
            }
            else
            {
                ProdutoDAO dao = new ProdutoDAO();
                ViewBag.Prods = dao.ProdutoToList();
                ViewBag.Carr = ProdutoVendaDAO.Carrinho;
                ViewBag.Clientes = c;
                double Pt = 0;
                foreach (ProdutoVenda item in ProdutoVendaDAO.Carrinho)
                {
                    Pt = (item.Produtos.Preco * item.Quantidade) + Pt;
                }
                ViewBag.Prec = Pt;
                return View("Carrinho");
            }
            return View("Carrinho");
        }

        public ActionResult Confirmar(int Id, double Ptotal)
        {
            VendaDAO vdao = new VendaDAO();
            ProdutoVendaDAO pvdao = new ProdutoVendaDAO();
            Venda v = new Venda();
            int FuncId = int.Parse(Session["_Id"].ToString());
            v.ClienteId = Id;
            v.FuncionarioId = FuncId;
            v.PrecoTotal = Ptotal;
            v.Data = DateTime.Now;
            vdao.Cadastrar(v);
            Venda vatual = vdao.BuscarVenda(Id, FuncId);

            foreach(ProdutoVenda item in ProdutoVendaDAO.Carrinho)
            {
                ProdutoVenda pv = new ProdutoVenda();
                pv.ProdutoId = item.ProdutoId;
                pv.Quantidade = item.Quantidade;
                pv.VendaId = vatual.Id;
                pvdao.Cadastrar(pv);
            }
            ClienteDAO cdao = new ClienteDAO();
            ViewBag.Cli = cdao.BuscarCliCPF(Id);
            FuncionarioDAO fdao = new FuncionarioDAO();
            ViewBag.Func = fdao.BuscarFuncId(FuncId);
            ProdutoVendaDAO.Carrinho.Clear();
            ViewBag.Pt = v.PrecoTotal;
            return View();
        }

    }
}